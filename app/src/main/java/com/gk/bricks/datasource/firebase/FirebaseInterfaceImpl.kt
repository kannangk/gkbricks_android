package com.gk.bricks.datasource.firebase

import android.content.Context
import android.util.Log
import com.gk.bricks.datasource.SharedPrefDelegate
import com.gk.bricks.model.ProductionModel
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.text.SimpleDateFormat
import java.util.Locale
import kotlin.collections.getValue

class FirebaseInterfaceImpl(
    database: FirebaseDatabase,
    private val dataSource: SharedPrefDelegate,
) : FirebaseInterface {

    private var productionReference: DatabaseReference? = null

    init {
        productionReference = database.getReference("gkbricks/productions")
    }

    override fun getAllProduction(
        mContext: Context,
        dataAvailableListener: (List<ProductionModel>) -> Unit,
    ) {
        productionReference?.get()?.addOnCompleteListener { task: Task<DataSnapshot> ->
            if (task.isComplete && task.isSuccessful) {
                val snapshot = task.result
                if (snapshot.exists()) {
                    val sdf = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())

                    val tempList = mutableListOf<ProductionModel>()
                    for (dateSnapshot in snapshot.children) {
                        val dateStr = dateSnapshot.key ?: continue
                        val production = dateSnapshot.child("production").getValue(Int::class.java) ?: 0
                        val count = dateSnapshot.child("count").getValue(Int::class.java) ?: 0

                        // Parse string to Date
                        val dateObj = try { sdf.parse(dateStr) } catch (e: Exception) { null } ?: continue

                        tempList.add(ProductionModel(dateStr, production, count, dateObj))
                    }

                    // Sort by actual Date object
                    tempList.sortByDescending { it.dateObj }
                    dataAvailableListener.invoke(tempList)

                }else{
                    dataAvailableListener.invoke(mutableListOf<ProductionModel>())
                }
            }
        }
    }

    override fun updateProductionCount(
        mContext: Context,
        date: String,
        count: Int,
        isUpdatedListener: (Boolean) -> Unit
    ) {
        val dateRef = productionReference?.child(date)

        // Create or update data
        val data = hashMapOf(
            "count" to count/2,
            "production" to count // Example: static or computed value
        )

        // Write to Firebase
        dateRef?.setValue(data)
            ?.addOnSuccessListener {
                Log.d("GK_updateProduction", "Production updated successfully for $date")
                isUpdatedListener(true)
            }
            ?.addOnFailureListener { e ->
                Log.e("GK_updateProduction", "Failed to update: ${e.message}")
                isUpdatedListener(false)
            }
    }



}