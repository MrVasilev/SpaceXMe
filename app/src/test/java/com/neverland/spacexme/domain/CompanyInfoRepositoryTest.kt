package com.neverland.spacexme.domain

import com.neverland.spacexme.TestDataGenerator.generateCompanyInfo
import com.neverland.spacexme.TestDataGenerator.generateCompanyInfoResponse
import com.neverland.spacexme.data.CompanyInfoService
import com.neverland.spacexme.data.model.CompanyInfoResponse
import com.neverland.spacexme.domain.mapper.CompanyInfoResponseMapper
import com.neverland.spacexme.domain.model.CompanyInfo
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class CompanyInfoRepositoryTest {

    private val companyInfoService = mock<CompanyInfoService>()
    private val companyInfoResponseMapper = mock<CompanyInfoResponseMapper>()

    private lateinit var tested: CompanyInfoRepository

    @Before
    fun setUp() {
        tested = CompanyInfoRepository(companyInfoService, companyInfoResponseMapper)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `getCompanyInfo service call success`() = runTest {
        // given
        val companyInfoResponse: CompanyInfoResponse = generateCompanyInfoResponse()
        val expected: CompanyInfo = generateCompanyInfo()

        whenever(companyInfoService.getCompanyInfo()).thenReturn(companyInfoResponse)
        whenever(companyInfoResponseMapper.mapCompanyInfoResponse(companyInfoResponse))
            .thenReturn(expected)

        // when
        val actual = tested.getCompanyInfo()

        // then
        assertEquals(expected, actual)
    }

}