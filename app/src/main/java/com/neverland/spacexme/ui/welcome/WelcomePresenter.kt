package com.neverland.spacexme.ui.welcome

import android.util.Log
import com.neverland.spacexme.domain.CompanyInfoRepository
import com.neverland.spacexme.mpv.MvpPresenter
import com.neverland.spacexme.ui.welcome.mapper.CompanyInfoMapper
import javax.inject.Inject

class WelcomePresenter @Inject constructor(
    private val companyInfoRepository: CompanyInfoRepository,
    private val companyInfoMapper: CompanyInfoMapper
) : MvpPresenter<WelcomeContract.View>(), WelcomeContract.Presenter {

    override fun init() {
        applyOnView { showProgress() }

        launch {
            kotlin.runCatching { companyInfoRepository.getCompanyInfo() }
                .map { info -> companyInfoMapper.mapToCompanyInfoUiModel(info) }
                .onSuccess { uiModel ->
                    applyOnView {
                        hideProgress()
                        showCompanyInfo(uiModel)
                    }
                }
                .onFailure { throwable ->
                    applyOnView { hideProgress() }
                    Log.println(Log.DEBUG, "ERROR", throwable.message.orEmpty())
                }
        }
    }
}