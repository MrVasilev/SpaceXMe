package com.neverland.spacexme.data

import com.neverland.spacexme.data.model.CompanyInfoResponse
import retrofit2.http.GET

interface CompanyInfoService {

    @GET("v4/company")
    suspend fun getCompanyInfo(): CompanyInfoResponse
}