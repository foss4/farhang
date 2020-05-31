package nejati.me.sample.view.adapter

import android.animation.ObjectAnimator
import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.aakira.expandablelayout.ExpandableLayoutListenerAdapter
import com.github.aakira.expandablelayout.Utils
import nejati.me.omdbapi.base.BaseAdapter
import nejati.me.omdbapi.base.BaseViewHolder
import nejati.me.omdbapi.databinding.DictionaryItemBinding
import nejati.me.omdbapi.view.adapter.mainActivity.DictionaryClickListener
import nejati.me.omdbapi.view.adapter.mainActivity.ExpandDictionaryEvent
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
    private val expandState = SparseBooleanArray()

    var mainViewModel: MainViewModel

    init {
        this.mainViewModel = mainViewModel
        for (i in 0 until searchItems.size) {
            expandState.append(i, false)
        }
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
        DictionaryClickListener, ExpandDictionaryEvent {
        private var dictionaryItemViewModel: DictionaryViewModel? = null

        override fun onBind(position: Int) {
            if (searchItems.size > 0) {
                val moviesListItem = searchItems[position]
                dictionaryItemViewModel = DictionaryViewModel(moviesListItem, this,this,position)
                adapterBinding.viewModel = dictionaryItemViewModel
              //  setFadeAnimation(adapterBinding.root)
                adapterBinding.expandableLayout.setInRecyclerView(true)
                adapterBinding.expandableLayout.setExpanded(expandState[position])

                adapterBinding.expandableLayout.setListener(object : ExpandableLayoutListenerAdapter() {
                    override fun onPreOpen() {
                        createRotateAnimator(adapterBinding.ivArrow, 0f, 180f)!!.start()
                       expandState.put(position, true)


                    }

                    override fun onPreClose() {
                        createRotateAnimator(adapterBinding.ivArrow, 180f, 0f)!!.start()
                    expandState.put(position, false)

                    }
                })
                adapterBinding.ivArrow.setRotation(if (expandState[position]) 180f else 0f)
                adapterBinding.llDetailResult.setOnClickListener({
                 //  adapterBinding.expandableLayout.initLayout()
                   adapterBinding.expandableLayout.toggle()


                    /*     Handler().postDelayed({
                             if ( adapterBinding.expandableLayout.isExpanded){
                                 adapterBinding.expandableLayout.setExpanded(false)

                             }else{
                                 adapterBinding.expandableLayout.setExpanded(true)

                             }

                         }, 300)
     */
                })
            }
        }

        override fun itemClicked(t: DictionaryResponse?) {
            mainViewModel.onMoviesItemClick(adapterPosition)
        }

        override fun notifyItemHeight() {
            adapterBinding.expandableLayout.initLayout()

        }
    }

    fun createRotateAnimator(
        target: View?,
        from: Float,
        to: Float
    ): ObjectAnimator? {
        val animator = ObjectAnimator.ofFloat(target, "rotation", from, to)
        animator.duration = 300
        animator.interpolator = Utils.createInterpolator(Utils.LINEAR_INTERPOLATOR)
        return animator
    }


}
