package nejati.me.omdbapi.view.activities.mian

import nejati.me.omdbapi.webServices.farhangModel.dictionary.DictionaryResult

/**
 * Authors:
 * Reza Nejati <rn.nejati></rn.nejati>@gmail.com>
 * Copyright © 2020
 */
interface MainActivityNavigator {

    fun onNetworkStatus(isConnectedToInternet: Boolean)
    fun message(message: String)
    abstract fun onMoreInExpandClick(t: DictionaryResult?)

}