package com.neverland.spacexme.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CompanyInfoResponse(
    @Json(name = "name")
    val name: String? = null,

    @Json(name = "founder")
    val founder: String? = null,

    @Json(name = "founded")
    val foundedYear: String? = null,

    @Json(name = "employees")
    val employeesNumber: String? = null,

    @Json(name = "ceo")
    val ceo: String? = null,

    @Json(name = "cto")
    val cto: String? = null,

    @Json(name = "coo")
    val coo: String? = null,

    @Json(name = "valuation")
    val valuation: String? = null,

    @Json(name = "summary")
    val summary: String? = null,

    @Json(name = "headquarters")
    val headquarter: HeadquarterResponse? = null,

    @Json(name = "links")
    val links: LinksResponse? = null
)

@JsonClass(generateAdapter = true)
data class HeadquarterResponse(
    @Json(name = "address")
    val address: String? = null,

    @Json(name = "city")
    val city: String? = null,

    @Json(name = "state")
    val state: String? = null
)

@JsonClass(generateAdapter = true)
data class LinksResponse(
    @Json(name = "website")
    val website: String? = null,

    @Json(name = "flickr")
    val flickr: String? = null,

    @Json(name = "twitter")
    val twitter: String? = null,

    @Json(name = "elon_twitter")
    val ceoTwitter: String? = null
)
