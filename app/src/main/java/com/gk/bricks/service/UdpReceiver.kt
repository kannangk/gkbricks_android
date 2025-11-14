package com.gk.bricks.service

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*
import java.net.*
import java.nio.charset.StandardCharsets

class UdpReceiver(
    private val context: Context,
    private val lifecycleOwner: LifecycleOwner
) {
    private var udpSocket: DatagramSocket? = null
    private var receiverJob: Job? = null
    private var isReceiving = false

    companion object {
        private const val TAG = "com.gk.bricks.service.UdpReceiver"
        private const val BUFFER_SIZE = 1024
        private const val DEFAULT_PORT = 8888
    }

    // Callback interface for received data
    interface UdpDataListener {
        fun onDataReceived(data: String, senderAddress: InetAddress, senderPort: Int)
        fun onError(error: String)
    }

    private var dataListener: UdpDataListener? = null

    fun setDataListener(listener: UdpDataListener) {
        dataListener = listener
    }

    /**
     * Start UDP receiver on specified port
     */
    fun startReceiver(port: Int = DEFAULT_PORT) {
        if (isReceiving) {
            Log.w(TAG, "UDP receiver is already running")
            return
        }

        // Check network permissions
        if (!hasNetworkPermissions()) {
            dataListener?.onError("Network permissions not granted")
            return
        }

        lifecycleOwner.lifecycleScope.launch {
            try {
                startUdpReceiver(port)
            } catch (e: Exception) {
                Log.e(TAG, "Error starting UDP receiver", e)
                dataListener?.onError("Failed to start UDP receiver: ${e.message}")
            }
        }
    }

    /**
     * Stop UDP receiver
     */
    fun stopReceiver() {
        isReceiving = false
        receiverJob?.cancel()
        udpSocket?.close()
        udpSocket = null
        Log.i(TAG, "UDP receiver stopped")
    }

    private suspend fun startUdpReceiver(port: Int) = withContext(Dispatchers.IO) {
        try {
            // Create UDP socket
            udpSocket = DatagramSocket(port).apply {
                reuseAddress = true
                soTimeout = 5000 // 5 second timeout for socket operations
            }

            isReceiving = true
            Log.i(TAG, "UDP receiver started on port $port")

            // Start receiving data
            receiverJob = launch {
                receiveData()
            }

        } catch (e: SocketException) {
            Log.e(TAG, "Socket error: ${e.message}")
            dataListener?.onError("Socket error: ${e.message}")
        } catch (e: Exception) {
            Log.e(TAG, "Unexpected error: ${e.message}")
            dataListener?.onError("Unexpected error: ${e.message}")
        }
    }

    private suspend fun receiveData() = withContext(Dispatchers.IO) {
        val buffer = ByteArray(BUFFER_SIZE)

        while (isReceiving && udpSocket != null && !udpSocket!!.isClosed) {
            try {
                val packet = DatagramPacket(buffer, buffer.size)
                udpSocket?.receive(packet)

                // Convert received data to string
                val receivedData = String(
                    packet.data,
                    0,
                    packet.length,
                    StandardCharsets.UTF_8
                )

                Log.d(TAG, "Received: $receivedData from ${packet.address}:${packet.port}")

                // Notify listener on main thread
                withContext(Dispatchers.Main) {
                    dataListener?.onDataReceived(
                        receivedData,
                        packet.address,
                        packet.port
                    )
                }

            } catch (e: SocketTimeoutException) {
                // Timeout is expected, continue receiving
                continue
            } catch (e: SocketException) {
                if (isReceiving) {
                    Log.e(TAG, "Socket exception: ${e.message}")
                    withContext(Dispatchers.Main) {
                        dataListener?.onError("Socket exception: ${e.message}")
                    }
                }
                break
            } catch (e: Exception) {
                Log.e(TAG, "Error receiving data: ${e.message}")
                withContext(Dispatchers.Main) {
                    dataListener?.onError("Error receiving data: ${e.message}")
                }
                break
            }
        }
    }

    /**
     * Send UDP response back to sender
     */
    fun sendResponse(message: String, targetAddress: InetAddress, targetPort: Int) {
        lifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
            try {
                val socket = DatagramSocket()
                val data = message.toByteArray(StandardCharsets.UTF_8)
                val packet = DatagramPacket(data, data.size, targetAddress, targetPort)

                socket.send(packet)
                socket.close()

                Log.d(TAG, "Response sent: $message to $targetAddress:$targetPort")
            } catch (e: Exception) {
                Log.e(TAG, "Error sending response: ${e.message}")
                withContext(Dispatchers.Main) {
                    dataListener?.onError("Error sending response: ${e.message}")
                }
            }
        }
    }

    /**
     * Check if device has network connectivity
     */
    private fun isNetworkAvailable(): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val network = connectivityManager.activeNetwork ?: return false
            val capabilities = connectivityManager.getNetworkCapabilities(network) ?: return false
            capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
        } else {
            @Suppress("DEPRECATION")
            val networkInfo = connectivityManager.activeNetworkInfo
            networkInfo?.isConnected == true
        }
    }

    /**
     * Check if app has required network permissions
     */
    private fun hasNetworkPermissions(): Boolean {
        val internetPermission = ActivityCompat.checkSelfPermission(
            context,
            Manifest.permission.INTERNET
        ) == PackageManager.PERMISSION_GRANTED

        val networkStatePermission = ActivityCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_NETWORK_STATE
        ) == PackageManager.PERMISSION_GRANTED

        return internetPermission && networkStatePermission
    }

    /**
     * Get local IP address
     */
    fun getLocalIpAddress(): String? {
        try {
            val interfaces = NetworkInterface.getNetworkInterfaces()
            while (interfaces.hasMoreElements()) {
                val networkInterface = interfaces.nextElement()
                if (!networkInterface.isLoopback && networkInterface.isUp) {
                    val addresses = networkInterface.inetAddresses
                    while (addresses.hasMoreElements()) {
                        val address = addresses.nextElement()
                        if (!address.isLoopbackAddress && address is Inet4Address) {
                            return address.hostAddress
                        }
                    }
                }
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error getting local IP: ${e.message}")
        }
        return null
    }

    /**
     * Check if receiver is currently running
     */
    fun isRunning(): Boolean = isReceiving

    /**
     * Get current listening port
     */
    fun getListeningPort(): Int? = udpSocket?.localPort
}