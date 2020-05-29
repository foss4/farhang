package nejati.me.sample.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import nejati.me.omdbapi.base.BaseAdapter
import nejati.me.omdbapi.base.BaseViewHolder
import nejati.me.omdbapi.databinding.DictionaryItemBinding
import nejati.me.omdbapi.view.adapter.mainActivity.DictionaryClickListener
import nejati.me.omdbapi.viewModels.mainActivity.DictionaryViewModel
import nejati.me.omdbapi.viewModels.mainActivity.MainViewModel
import nejati.me.omdbapi.webServices.farhangModel.dictionary.DictionaryResponse

/**
 * Authors:
 * Reza Nejati <rn.nejati@gmail.com>
 * Copyright © 2020
 */
class DictionaryAdapter(
    private val searchItems: MutableList<DictionaryResponse>,
    mainViewModel: MainViewModel
) : BaseAdapter<BaseViewHolder, DictionaryResponse>() {

    var mainViewModel: MainViewModel

    init {
        this.mainViewModel = mainViewModel
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): BaseViewHolder {
        val adapterBinding = DictionaryItemBinding.inflate(
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

    inner class MovieListViewHolder(private val adapterBinding: DictionaryItemBinding) :
        BaseViewHolder(adapterBinding.root),
        DictionaryClickListener {
        private var forcastWeatherItemViewModel: DictionaryViewModel? = null

        override fun onBind(position: Int) {
            if (searchItems.size > 0) {
                val moviesListItem = searchItems[position]
                forcastWeatherItemViewModel = DictionaryViewModel(moviesListItem, this,position)
                adapterBinding.viewModel = forcastWeatherItemViewModel
                setFadeAnimation(adapterBinding.root)

            }
        }

        override fun itemClicked(t: DictionaryResponse?) {
            mainViewModel.onMoviesItemClick(adapterPosition)
        }
    }

}
