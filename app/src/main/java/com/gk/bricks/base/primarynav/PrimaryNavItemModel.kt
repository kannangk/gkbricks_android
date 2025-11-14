package com.elite.x300.base.primarynav


data class PrimaryNavItemModel(
    val priNavId: String,
    val title: String
) {
    var menuItemId: Int? = null
}

data class PrimaryNavItemIcons(
    val drawable: Int,
    val selected: Int
)