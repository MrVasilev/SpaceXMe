package com.neverland.spacexme.domain.model

data class CompanyInfo(
    val name: String,
    val founder: String,
    val foundedYear: String,
    val employeesNumber: String,
    val ceo: String,
    val cto: String,
    val coo: String,
    val valuation: String,
    val summary: String,
    val headquarter: Headquarter,
    val links: Links
)

data class Headquarter(
    val address: String,
    val city: String,
    val state: String
)

data class Links(
    val website: String,
    val flickr: String,
    val twitter: String,
    val ceoTwitter: String
)