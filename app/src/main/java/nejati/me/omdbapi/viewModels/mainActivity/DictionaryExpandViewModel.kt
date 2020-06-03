package nejati.me.omdbapi.viewModels.mainActivity

import androidx.databinding.ObservableField
import nejati.me.omdbapi.view.adapter.mainActivity.DictionaryClickListener
import nejati.me.omdbapi.view.adapter.mainActivity.DictionaryExpandClickListener
import nejati.me.omdbapi.webServices.farhangModel.dictionary.DictionaryResponse
import nejati.me.omdbapi.webServices.farhangModel.dictionary.DictionaryResult

/**
 * Authors:
 * Reza Nejati <rn.nejati@gmail.com>
 * Copyright © 2020
 */
class DictionaryExpandViewModel(
    result: DictionaryResult?,
    private val position: Int, private val customClickListener: DictionaryExpandClickListener
) {
    var dictionaryItems = ObservableField<DictionaryResult>()
    var readMore = ObservableField(false)


    init {
        dictionaryItems.set(result)

    }
    fun onMoreClick(t: DictionaryResult) {
        customClickListener.itemClicked(t)
    }



}
