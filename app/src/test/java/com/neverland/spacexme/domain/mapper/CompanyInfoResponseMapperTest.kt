package com.neverland.spacexme.domain.mapper

import com.neverland.spacexme.TestDataGenerator.generateCompanyInfo
import com.neverland.spacexme.TestDataGenerator.generateCompanyInfoEmpty
import com.neverland.spacexme.TestDataGenerator.generateCompanyInfoResponse
import com.neverland.spacexme.TestDataGenerator.generateCompanyInfoResponseEmpty
import com.neverland.spacexme.data.model.CompanyInfoResponse
import com.neverland.spacexme.domain.model.CompanyInfo
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class CompanyInfoResponseMapperTest {

    private lateinit var tested: CompanyInfoResponseMapper

    @Before
    fun setUp() {
        tested = CompanyInfoResponseMapper()
    }

    @Test
    fun `mapCompanyInfoResponse response with data mapped to proper data`() {
        // given
        val response: CompanyInfoResponse = generateCompanyInfoResponse()
        val expected: CompanyInfo = generateCompanyInfo()

        // when
        val actual = tested.mapCompanyInfoResponse(response)

        // then
        assertEquals(expected, actual)
    }

    @Test
    fun `mapCompanyInfoResponse response with empty data mapped to empty data`() {
        // given
        val response: CompanyInfoResponse = generateCompanyInfoResponseEmpty()
        val expected: CompanyInfo = generateCompanyInfoEmpty()

        // when
        val actual = tested.mapCompanyInfoResponse(response)

        // then
        assertEquals(expected, actual)
    }

    @Test
    fun `mapCompanyInfoResponse response with null data mapped to empty data`() {
        // given
        val response = CompanyInfoResponse()
        val expected: CompanyInfo = generateCompanyInfoEmpty()

        // when
        val actual = tested.mapCompanyInfoResponse(response)

        // then
        assertEquals(expected, actual)
    }
}