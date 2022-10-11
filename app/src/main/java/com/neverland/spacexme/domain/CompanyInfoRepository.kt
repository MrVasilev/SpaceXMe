package com.neverland.spacexme.domain

import com.neverland.spacexme.data.CompanyInfoService
import com.neverland.spacexme.domain.mapper.CompanyInfoResponseMapper
import com.neverland.spacexme.domain.model.CompanyInfo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CompanyInfoRepository @Inject constructor(
    private val companyInfoService: CompanyInfoService,
    private val companyInfoResponseMapper: CompanyInfoResponseMapper
) {

    suspend fun getCompanyInfo(): CompanyInfo =
        companyInfoService.getCompanyInfo()
            .run { companyInfoResponseMapper.mapCompanyInfoResponse(this) }
}