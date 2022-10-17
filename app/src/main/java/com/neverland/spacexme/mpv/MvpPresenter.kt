package com.neverland.spacexme.mpv

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

abstract class MvpPresenter<V : MvpContract.View> : MvpContract.Presenter<V> {

    private var view: V? = null
    private lateinit var presenterScope: CoroutineScope

    override fun attachView(view: V) {
        this.view = view
    }

    override fun cleanUp() {
        view = null
    }

    override fun setCoroutineScope(scope: CoroutineScope) {
        presenterScope = scope
    }

    fun applyOnView(action: V.() -> Unit) = view?.let { action.invoke(it) }

    fun launch(block: suspend CoroutineScope.() -> Unit): Job =
        presenterScope.launch { block.invoke(this) }
}