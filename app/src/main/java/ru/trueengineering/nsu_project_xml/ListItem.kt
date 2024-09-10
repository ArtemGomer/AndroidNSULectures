package ru.trueengineering.nsu_project_xml

import androidx.annotation.DrawableRes

sealed interface ListItem {

    data class BrandItem(
        @DrawableRes val iconRes: Int,
        val title: String,
    ) : ListItem

    data class HeaderItem(
        val title: String,
    ) : ListItem

}