package nejati.me.omdbapi.viewModels.mainActivity

import androidx.databinding.ObservableField
import nejati.me.omdbapi.view.adapter.mainActivity.DictionaryClickListener
import nejati.me.omdbapi.webServices.farhangModel.dictionary.DictionaryResponse
/**
 * Authors:
 * Reza Nejati <rn.nejati@gmail.com>
 * Copyright © 2020
 */
class DictionaryViewModel(
    result: DictionaryResponse?,
    private val customClickListener: DictionaryClickListener,
    private val position: Int
) {
    var moviesItems = ObservableField<DictionaryResponse>()


    init {
        moviesItems.set(result)

    }

    fun onMovieClick(t: DictionaryResponse) {
        customClickListener.itemClicked(t)
    }




}
