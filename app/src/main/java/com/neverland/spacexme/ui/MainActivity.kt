package com.neverland.spacexme.ui

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.neverland.spacexme.R
import com.neverland.spacexme.databinding.ActivityMainBinding
import com.neverland.spacexme.mpv.MvpActivity
import com.neverland.spacexme.ui.welcome.WelcomeContract
import com.neverland.spacexme.ui.welcome.model.CompanyInfoUiModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : MvpActivity<WelcomeContract.View, WelcomeContract.Presenter>(),
    WelcomeContract.View {

    @Inject
    override lateinit var presenter: WelcomeContract.Presenter

    private lateinit var dataBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        presenter.init()
    }

    override fun showCompanyInfo(uiModel: CompanyInfoUiModel) {
        dataBinding.tvTitle.text = uiModel.name
        dataBinding.ivHeaderImage.setImageResource(uiModel.headerImage)
        dataBinding.tvSummary.text = uiModel.summary
    }

    override fun showProgress() {
        dataBinding.progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        dataBinding.progressBar.visibility = View.GONE
    }

    override fun showErrorDialog() {
        TODO("Not yet implemented")
    }
}