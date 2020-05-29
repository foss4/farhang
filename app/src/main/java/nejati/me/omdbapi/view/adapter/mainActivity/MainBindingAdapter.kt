package nejati.me.sample.view.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import nejati.me.omdbapi.viewModels.mainActivity.MainViewModel
import nejati.me.omdbapi.webServices.farhangModel.dictionary.DictionaryResponse


/**
 * Authors:
 * Reza Nejati <rn.nejati@gmail.com>
 * Copyright © 2020
 */
object MainBindingAdapter {


    @JvmStatic
    @BindingAdapter("bind:dictionaryItems", "bind:viewModel")
    fun dictionaryAdapter(
        recyclerView: RecyclerView,
        items: MutableList<DictionaryResponse>,
        mainViewModel: MainViewModel
    ) {
        when {
            recyclerView.adapter == null -> {
                val adapter = DictionaryAdapter(items, mainViewModel)
                recyclerView.adapter = adapter
            }
            else -> recyclerView.adapter!!.notifyItemInserted(recyclerView.adapter!!.itemCount)
        }
    }

    /**
     * Bind Rating Adapter In Detail Movie Activity
     *
     * @param recyclerView
     * @param ratingItems
     * @param mainViewModel
     */
    @JvmStatic
    @BindingAdapter("bind:hourlyItems",  "bind:viewModel")
    fun ratingAdapter(
        recyclerView: RecyclerView,
        ratingItems: MutableList<String>,
        mainViewModel: MainViewModel
    ) {
        if (recyclerView.adapter == null) {
            val adapter = HourlyAdapter(ratingItems, mainViewModel)
            recyclerView.adapter = adapter

        } else
            recyclerView.adapter!!.notifyDataSetChanged()
    }


}
