package com.neverland.spacexme.domain.mapper

import com.neverland.spacexme.data.model.CompanyInfoResponse
import com.neverland.spacexme.data.model.HeadquarterResponse
import com.neverland.spacexme.data.model.LinksResponse
import com.neverland.spacexme.domain.model.CompanyInfo
import com.neverland.spacexme.domain.model.Headquarter
import com.neverland.spacexme.domain.model.Links
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CompanyInfoResponseMapper @Inject constructor() {

    fun mapCompanyInfoResponse(response: CompanyInfoResponse) = CompanyInfo(
        name = response.name.orEmpty(),
        founder = response.founder.orEmpty(),
        foundedYear = response.foundedYear.orEmpty(),
        employeesNumber = response.employeesNumber.orEmpty(),
        ceo = response.ceo.orEmpty(),
        cto = response.cto.orEmpty(),
        coo = response.coo.orEmpty(),
        valuation = response.valuation.orEmpty(),
        summary = response.summary.orEmpty(),
        headquarter = mapHeadquarterResponse(response.headquarter),
        links = mapLinksResponse(response.links)
    )

    private fun mapHeadquarterResponse(headquarterResponse: HeadquarterResponse?) = Headquarter(
        address = headquarterResponse?.address.orEmpty(),
        city = headquarterResponse?.city.orEmpty(),
        state = headquarterResponse?.state.orEmpty()
    )

    private fun mapLinksResponse(linksResponse: LinksResponse?) = Links(
        website = linksResponse?.website.orEmpty(),
        flickr = linksResponse?.flickr.orEmpty(),
        twitter = linksResponse?.twitter.orEmpty(),
        ceoTwitter = linksResponse?.ceoTwitter.orEmpty()
    )
}