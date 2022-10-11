package com.neverland.spacexme.di

import com.neverland.spacexme.ui.welcome.WelcomeContract
import com.neverland.spacexme.ui.welcome.WelcomePresenter
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class PresenterModule {

    @Binds
    abstract fun provideWelcomePresenter(presenter: WelcomePresenter): WelcomeContract.Presenter
}