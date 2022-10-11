package com.neverland.spacexme.ui.welcome

import com.neverland.spacexme.mpv.MvpContract
import com.neverland.spacexme.ui.welcome.model.CompanyInfoUiModel

interface WelcomeContract {

    interface View : MvpContract.View {

        fun showCompanyInfo(uiModel: CompanyInfoUiModel)
    }

    interface Presenter : MvpContract.Presenter<View> {

        fun init()
    }
}