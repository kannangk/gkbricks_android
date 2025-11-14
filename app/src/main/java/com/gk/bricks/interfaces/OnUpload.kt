package com.gk.bricks.interfaces

interface OnUpload {
    fun onUploadSuccess(url: String)
    fun onUploadFailed()

    fun onError(id: Int, ex: Exception)

    fun onProgressUpdate(percentage: Int,uploadedSize: Long)
}
