package com.neverland.spacexme.ui.welcome

import com.neverland.spacexme.TestDataGenerator.generateCompanyInfo
import com.neverland.spacexme.TestDataGenerator.generateCompanyInfoUiModel
import com.neverland.spacexme.domain.CompanyInfoRepository
import com.neverland.spacexme.ui.welcome.mapper.CompanyInfoMapper
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.inOrder
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@OptIn(ExperimentalCoroutinesApi::class)
class WelcomePresenterTest {

    private val testScope = TestScope(UnconfinedTestDispatcher())

    private val companyInfoRepository = mock<CompanyInfoRepository>()
    private val companyInfoMapper = mock<CompanyInfoMapper>()

    private val view = mock<WelcomeContract.View>()

    private lateinit var tested: WelcomePresenter

    @Before
    fun setUp() {
        tested = WelcomePresenter(companyInfoRepository, companyInfoMapper)
            .also {
                it.attachView(view)
                it.setCoroutineScope(testScope)
            }
    }

    @Test
    fun `init load company info successfully and show data on the screen`() = testScope.runTest {
        // given
        val companyInfo = generateCompanyInfo()
        val uiModel = generateCompanyInfoUiModel()

        whenever(companyInfoRepository.getCompanyInfo()).thenReturn(companyInfo)
        whenever(companyInfoMapper.mapToCompanyInfoUiModel(companyInfo)).thenReturn(uiModel)

        // when
        tested.init()

        // then
        inOrder(view, companyInfoRepository, companyInfoMapper) {
            verify(view).showProgress()
            verify(companyInfoRepository).getCompanyInfo()
            verify(companyInfoMapper).mapToCompanyInfoUiModel(companyInfo)
            verify(view).hideProgress()
            verify(view).showCompanyInfo(uiModel)
            verifyNoMoreInteractions()
        }
    }

    @Test
    fun `init load company info failed show error message on the screen`() = testScope.runTest {
        // given
        whenever(companyInfoRepository.getCompanyInfo()).thenThrow(IllegalArgumentException())

        // when
        tested.init()

        // then
        inOrder(view, companyInfoRepository, companyInfoMapper) {
            verify(view).showProgress()
            verify(companyInfoRepository).getCompanyInfo()
            verify(view).hideProgress()
            verifyNoMoreInteractions()
        }
    }
}