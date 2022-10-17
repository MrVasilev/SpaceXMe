package com.neverland.spacexme.mpv

import kotlinx.coroutines.CoroutineScope

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

        /**
         * Attach a view to the presenter
         *
         * @param view the view to be supervised
         */
        fun attachView(view: V)

        /**
         * Release any additional resources when the view becomes unavailable for update
         */
        fun cleanUp()

        /**
         * Set the scope which will delimit the lifetime of coroutines launched in the presenter
         *
         * @param scope the scope of all coroutines in that presenter
         */
        fun setCoroutineScope(scope: CoroutineScope)
    }
}