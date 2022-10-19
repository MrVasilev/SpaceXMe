package com.neverland.spacexme

import com.neverland.spacexme.data.model.CompanyInfoResponse
import com.neverland.spacexme.data.model.HeadquarterResponse
import com.neverland.spacexme.data.model.LinksResponse
import com.neverland.spacexme.domain.model.CompanyInfo
import com.neverland.spacexme.domain.model.Headquarter
import com.neverland.spacexme.domain.model.Links
import com.neverland.spacexme.ui.welcome.model.CompanyInfoUiModel

object TestDataGenerator {

    fun generateCompanyInfoResponse() = CompanyInfoResponse(
        name = "SpaceX",
        founder = "Elon Musk",
        foundedYear = "2002",
        employeesNumber = "9500",
        ceo = "Elon Musk",
        cto = "Elon Musk",
        coo = "Gwynne Shotwell",
        valuation = "74000000000",
        summary = "SpaceX designs, manufactures and launches",
        headquarter = HeadquarterResponse(
            address = "Rocket Road",
            city = "Hawthorne",
            state = "California"
        ),
        links = LinksResponse(
            website = "https://www.spacex.com/",
            flickr = "https://www.flickr.com/photos/spacex/",
            twitter = "https://twitter.com/SpaceX",
            ceoTwitter = "https://twitter.com/elonmusk"
        )
    )

    fun generateCompanyInfo() = CompanyInfo(
        name = "SpaceX",
        founder = "Elon Musk",
        foundedYear = "2002",
        employeesNumber = "9500",
        ceo = "Elon Musk",
        cto = "Elon Musk",
        coo = "Gwynne Shotwell",
        valuation = "74000000000",
        summary = "SpaceX designs, manufactures and launches",
        headquarter = Headquarter(
            address = "Rocket Road",
            city = "Hawthorne",
            state = "California"
        ),
        links = Links(
            website = "https://www.spacex.com/",
            flickr = "https://www.flickr.com/photos/spacex/",
            twitter = "https://twitter.com/SpaceX",
            ceoTwitter = "https://twitter.com/elonmusk"
        )
    )

    fun generateCompanyInfoEmpty() = CompanyInfo(
        name = "",
        founder = "",
        foundedYear = "",
        employeesNumber = "",
        ceo = "",
        cto = "",
        coo = "",
        valuation = "",
        summary = "",
        headquarter = Headquarter(
            address = "",
            city = "",
            state = ""
        ),
        links = Links(
            website = "",
            flickr = "",
            twitter = "",
            ceoTwitter = ""
        )
    )

    fun generateCompanyInfoUiModel() = CompanyInfoUiModel(
        name = "SpaceX",
        headerImage = R.drawable.ic_spacex_logo,
        founder = "Elon Musk",
        foundedYear = "2002",
        employeesNumber = "9500",
        ceo = "Elon Musk",
        ceoImage = R.drawable.ic_launcher_foreground,
        coo = "Gwynne Shotwell",
        cooImage = R.drawable.ic_launcher_foreground,
        cto = "Elon Musk",
        ctoImage = R.drawable.ic_launcher_foreground,
        valuation = "74000000000",
        summary = "SpaceX designs, manufactures and launches"
    )
}