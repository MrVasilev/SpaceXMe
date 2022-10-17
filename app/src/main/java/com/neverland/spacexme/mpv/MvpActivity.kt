package com.neverland.spacexme.mpv

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope

abstract class MvpActivity<V : MvpContract.View, P : MvpContract.Presenter<V>> :
    AppCompatActivity(), MvpContract.View {

    open lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.attachView(this@MvpActivity as V)
        presenter.setCoroutineScope(lifecycleScope)
    }

    override fun onStop() {
        super.onStop()
        presenter.cleanUp()
    }
}