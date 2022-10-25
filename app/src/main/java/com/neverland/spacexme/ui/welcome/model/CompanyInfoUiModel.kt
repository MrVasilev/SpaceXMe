package com.neverland.spacexme.ui.welcome.model

import androidx.annotation.DrawableRes

data class CompanyInfoUiModel(
    val name: String,
    @DrawableRes
    val headerImage: Int,
    val founder: String,
    val foundedYear: String,
    val employeesNumber: String,
    val valuation: String,
    val summary: String,
    val cLevelUiModel: CLevelUiModel
)

data class CLevelUiModel(
    val ceo: String,
    @DrawableRes
    val ceoImage: Int,
    val cto: String,
    @DrawableRes
    val ctoImage: Int,
    val coo: String,
    @DrawableRes
    val cooImage: Int
)