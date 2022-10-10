package com.neverland.spacexme.mpv

/**
 * A base contract for views and presenter that are part of our MVP implementation.
 */
interface MvpContract {

    /**
     * Define the basic behaviour of a view.
     */
    interface View {

        fun showProgress()

        fun hideProgress()

        fun showErrorDialog()
    }

    /**
     * Define the basic behaviour of a presenter.
     *
     * @param <V> the concrete type of the supervised view
     */
    interface Presenter<V : View> {

        fun attachView(view: V)
    }
}