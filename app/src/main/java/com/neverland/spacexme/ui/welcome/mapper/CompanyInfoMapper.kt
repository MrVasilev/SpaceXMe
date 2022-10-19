package com.neverland.spacexme.ui.welcome.mapper

import com.neverland.spacexme.R
import com.neverland.spacexme.domain.model.CompanyInfo
import com.neverland.spacexme.ui.welcome.model.CompanyInfoUiModel
import javax.inject.Inject

class CompanyInfoMapper @Inject constructor() {

    fun mapToCompanyInfoUiModel(companyInfo: CompanyInfo): CompanyInfoUiModel = CompanyInfoUiModel(
        name = companyInfo.name,
        headerImage = R.drawable.ic_spacex_logo,
        founder = companyInfo.founder,
        foundedYear = companyInfo.foundedYear,
        employeesNumber = companyInfo.employeesNumber,
        ceo = companyInfo.ceo,
        ceoImage = R.drawable.ic_launcher_foreground,
        coo = companyInfo.coo,
        cooImage = R.drawable.ic_launcher_foreground,
        cto = companyInfo.cto,
        ctoImage = R.drawable.ic_launcher_foreground,
        valuation = companyInfo.valuation,
        summary = companyInfo.summary
    )
}