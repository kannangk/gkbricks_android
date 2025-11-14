package com.gk.bricks.model

import java.util.Date

data class ProductionModel(
    val date: String = "",
    val production: Int = 0,
    val count: Int = 0,
    val dateObj: Date? = null // for sorting
)
