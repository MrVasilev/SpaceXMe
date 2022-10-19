package com.neverland.spacexme.ui.welcome.mapper

import com.neverland.spacexme.TestDataGenerator.generateCompanyInfo
import com.neverland.spacexme.TestDataGenerator.generateCompanyInfoUiModel
import com.neverland.spacexme.domain.model.CompanyInfo
import com.neverland.spacexme.ui.welcome.model.CompanyInfoUiModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class CompanyInfoMapperTest {

    private lateinit var tested: CompanyInfoMapper

    @Before
    fun setUp() {
        tested = CompanyInfoMapper()
    }

    @Test
    fun mapToCompanyInfoUiModel() {
        // given
        val companyInfo: CompanyInfo = generateCompanyInfo()
        val expected: CompanyInfoUiModel = generateCompanyInfoUiModel()

        // when
        val actual: CompanyInfoUiModel = tested.mapToCompanyInfoUiModel(companyInfo)

        // then
        assertEquals(expected, actual)
    }
}