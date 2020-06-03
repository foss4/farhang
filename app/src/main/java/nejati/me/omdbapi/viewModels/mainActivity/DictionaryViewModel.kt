package nejati.me.omdbapi.viewModels.mainActivity

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import nejati.me.omdbapi.view.adapter.mainActivity.DictionaryClickListener
import nejati.me.omdbapi.view.adapter.mainActivity.ExpandDictionaryEvent
import nejati.me.omdbapi.webServices.farhangModel.dictionary.DictionaryResponse
import nejati.me.omdbapi.webServices.farhangModel.dictionary.DictionaryResult

/**
 * Authors:
 * Reza Nejati <rn.nejati@gmail.com>
 * Copyright © 2020
 */
class DictionaryViewModel(
    result: DictionaryResponse?,
    private val customClickListener: DictionaryClickListener,private val expandDictionaryEvents : ExpandDictionaryEvent ,
    position: Int
) {
    var moviesItems = ObservableField<DictionaryResponse>()
    var dictionaryResult = ObservableArrayList<DictionaryResult>()
    var expandDictionaryEvent = ObservableField<ExpandDictionaryEvent>()


    init {
        moviesItems.set(result)
        dictionaryResult.addAll(result!!.dictionaryResults)
        expandDictionaryEvent.set(expandDictionaryEvents)

    }

    fun onItemClick(t: DictionaryResponse) {
        customClickListener.itemClicked(t)
    }


    fun onItemMoreClick(t: DictionaryResult) {
        customClickListener.itemMoreClicked(t)
    }



}
