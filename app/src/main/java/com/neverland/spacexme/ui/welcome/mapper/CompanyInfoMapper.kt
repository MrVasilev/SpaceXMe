package com.neverland.spacexme.ui.welcome.mapper

import com.neverland.spacexme.R
import com.neverland.spacexme.domain.model.CompanyInfo
import com.neverland.spacexme.ui.welcome.model.CLevelUiModel
import com.neverland.spacexme.ui.welcome.model.CompanyInfoUiModel
import javax.inject.Inject

class CompanyInfoMapper @Inject constructor() {

    fun mapToCompanyInfoUiModel(companyInfo: CompanyInfo): CompanyInfoUiModel = CompanyInfoUiModel(
        name = companyInfo.name,
        headerImage = R.drawable.ic_spacex_logo,
        founder = companyInfo.founder,
        foundedYear = companyInfo.foundedYear,
        employeesNumber = companyInfo.employeesNumber,
        valuation = companyInfo.valuation,
        summary = companyInfo.summary,
        cLevelUiModel = mapToCompanyCLevelInfo(companyInfo)
    )

    private fun mapToCompanyCLevelInfo(companyInfo: CompanyInfo): CLevelUiModel =
        CLevelUiModel(
            ceo = companyInfo.ceo,
            ceoImage = R.drawable.img_elon_musk,
            coo = companyInfo.coo,
            cooImage = R.drawable.img_gwynne_shotwell,
            cto = companyInfo.cto,
            ctoImage = R.drawable.img_tom_mueller
        )
}