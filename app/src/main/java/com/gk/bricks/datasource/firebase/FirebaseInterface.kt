package com.gk.bricks.datasource.firebase

import android.app.Activity
import android.content.Context
import com.gk.bricks.model.ProductionModel

interface FirebaseInterface {

    fun getAllProduction(
        mContext: Context,
        isUpdateAvailableListener: (List<ProductionModel>) -> Unit,
    )

    fun updateProductionCount(
        mContext: Context,
        date: String,
        count: Int,
        isUpdatedListener: (Boolean) -> Unit,
    )

}