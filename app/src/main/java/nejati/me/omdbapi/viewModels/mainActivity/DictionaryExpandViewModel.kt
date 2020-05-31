package nejati.me.omdbapi.viewModels.mainActivity

import androidx.databinding.ObservableField
import nejati.me.omdbapi.view.adapter.mainActivity.DictionaryClickListener
import nejati.me.omdbapi.webServices.farhangModel.dictionary.DictionaryResponse
import nejati.me.omdbapi.webServices.farhangModel.dictionary.DictionaryResult

/**
 * Authors:
 * Reza Nejati <rn.nejati@gmail.com>
 * Copyright © 2020
 */
class DictionaryExpandViewModel(
    result: DictionaryResult?,
    private val position: Int
) {
    var dictionaryItems = ObservableField<DictionaryResult>()


    init {
        dictionaryItems.set(result)

    }




}
