package nejati.me.sample.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import nejati.me.omdbapi.base.BaseAdapter
import nejati.me.omdbapi.base.BaseViewHolder
import nejati.me.omdbapi.databinding.DictionaryExpandItemBinding
import nejati.me.omdbapi.view.adapter.mainActivity.ExpandDictionaryEvent
import nejati.me.omdbapi.viewModels.mainActivity.DictionaryExpandViewModel
import nejati.me.omdbapi.viewModels.mainActivity.DictionaryViewModel
import nejati.me.omdbapi.webServices.farhangModel.dictionary.DictionaryResult

/**
 * Authors:
 * Reza Nejati <rn.nejati@gmail.com>
 * Copyright © 2020
 */
class DictionaryExpandAdapter(
    private val searchItems: MutableList<DictionaryResult>,
    dictionaryViewModel: DictionaryViewModel,
    expandDictionaryEvent: ExpandDictionaryEvent
) : BaseAdapter<BaseViewHolder, DictionaryResult>() {

    var dictionaryViewModel: DictionaryViewModel
    var expandDictionaryEvent: ExpandDictionaryEvent

    init {
        this.dictionaryViewModel = dictionaryViewModel
        this.expandDictionaryEvent = expandDictionaryEvent

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): BaseViewHolder {
        val adapterBinding = DictionaryExpandItemBinding.inflate(
            LayoutInflater.from(viewGroup.context),
            viewGroup, false
        )

        return MovieListViewHolder(adapterBinding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount(): Int {
        return searchItems.size
    }

    inner class MovieListViewHolder(private val adapterBinding: DictionaryExpandItemBinding) :
        BaseViewHolder(adapterBinding.root){
        private var forcastWeatherItemViewModel: DictionaryExpandViewModel? = null

        override fun onBind(position: Int) {
            if (searchItems.size > 0) {
                val moviesListItem = searchItems[position]
                forcastWeatherItemViewModel = DictionaryExpandViewModel(moviesListItem, position)
                adapterBinding.viewModel = forcastWeatherItemViewModel
            //    expandDictionaryEvent.notifyItemHeight()
               // setFadeAnimation(adapterBinding.root)

            }
        }
    }


}
