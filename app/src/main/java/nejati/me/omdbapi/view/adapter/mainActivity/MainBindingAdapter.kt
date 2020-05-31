package nejati.me.sample.view.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import nejati.me.omdbapi.view.adapter.mainActivity.ExpandDictionaryEvent
import nejati.me.omdbapi.viewModels.mainActivity.DictionaryViewModel
import nejati.me.omdbapi.viewModels.mainActivity.MainViewModel
import nejati.me.omdbapi.webServices.farhangModel.dictionary.DictionaryResponse
import nejati.me.omdbapi.webServices.farhangModel.dictionary.DictionaryResult


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
        val adapter = DictionaryAdapter(items, mainViewModel)
        recyclerView.adapter = adapter
        /*when {
            recyclerView.adapter == null -> {
                val adapter = DictionaryAdapter(items, mainViewModel)
                recyclerView.adapter = adapter
            }
            else -> recyclerView.adapter!!.notifyItemInserted(recyclerView.adapter!!.itemCount)
        }*/
    }

    @JvmStatic
    @BindingAdapter(
        "bind:dictionaryExpandItems",
        "bind:viewModel",
        "bind:dictionaryExpandAdapterEvent"
    )
    fun dictionaryExpandAdapter(
        recyclerView: RecyclerView,
        items: MutableList<DictionaryResult>,
        dictionaryViewModel: DictionaryViewModel, expandDictionaryEvent:
        ExpandDictionaryEvent
    ) {
        val adapter =
            DictionaryExpandAdapter(items, dictionaryViewModel, expandDictionaryEvent)
        recyclerView.adapter = adapter
        expandDictionaryEvent.notifyItemHeight()
        /*when {
            recyclerView.adapter == null -> {
                val adapter =
                    DictionaryExpandAdapter(items, dictionaryViewModel, expandDictionaryEvent)
                recyclerView.adapter = adapter
                expandDictionaryEvent.notifyItemHeight()

            }
            else -> {
                recyclerView.adapter!!.notifyItemInserted(recyclerView.adapter!!.itemCount)
                expandDictionaryEvent.notifyItemHeight()
            }

        }*/
    }

    /**
     * Bind Rating Adapter In Detail Movie Activity
     *
     * @param recyclerView
     * @param ratingItems
     * @param mainViewModel
     */
    @JvmStatic
    @BindingAdapter("bind:hourlyItems", "bind:viewModel")
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
