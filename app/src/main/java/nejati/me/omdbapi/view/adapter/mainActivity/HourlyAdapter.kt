package nejati.me.sample.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import nejati.me.omdbapi.base.BaseAdapter
import nejati.me.omdbapi.base.BaseViewHolder
import nejati.me.omdbapi.databinding.HourlyListItemBinding
import nejati.me.omdbapi.viewModels.mainActivity.HourlyItemViewModel
import nejati.me.omdbapi.viewModels.mainActivity.MainViewModel


/**
 * Authors:
 * Reza Nejati <rn.nejati@gmail.com>
 * Copyright © 2020
 */
class HourlyAdapter(
    private val hourlyItems: MutableList<String>,
    mainViewModel: MainViewModel
): BaseAdapter<BaseViewHolder, String>() {

    var mainViewModel: MainViewModel

    init {
       this.mainViewModel=mainViewModel
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): BaseViewHolder {
        val adapterBinding = HourlyListItemBinding.inflate(
            LayoutInflater.from(viewGroup.context),
            viewGroup, false)

        return RatingListViewHolder(adapterBinding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount(): Int {
        return hourlyItems.size
    }

    inner class RatingListViewHolder(private val adapterBinding: HourlyListItemBinding) :
        BaseViewHolder(adapterBinding.root) {
        private var moviesItemViewModel: HourlyItemViewModel? = null


        override fun onBind(position: Int) {
            if (hourlyItems.size > 0) {
                val moviesListItem = hourlyItems[position]
                moviesItemViewModel =
                    HourlyItemViewModel(
                        moviesListItem
                    )
                adapterBinding.viewModel = moviesItemViewModel
                setFadeAnimation(adapterBinding.root)

            }
        }

    }


}
