package nejati.me.omdbapi.viewModels.mainActivity

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import io.reactivex.disposables.CompositeDisposable
import nejati.me.omdbapi.api.RxSingleSchedulers
import nejati.me.omdbapi.base.ActivityBaseViewModel
import nejati.me.omdbapi.view.activities.mian.MainActivityNavigator
import nejati.me.omdbapi.webServices.farhangModel.dictionary.DictionaryResponse
import nejati.me.sample.di.api.FarhangApi
import java.lang.Exception
import javax.inject.Inject

/**
 * Authors:
 * Reza Nejati <rn.nejati@gmail.com>
 * Copyright © 2020
 */
class MainViewModel
@Inject
constructor(): ActivityBaseViewModel<MainActivityNavigator>() {



    val dictionary = ObservableArrayList<DictionaryResponse>()

    private var disposable: CompositeDisposable? = null

    private var dictonaryRequest: String? = null

    var showProgress = ObservableField(false)
    @set : Inject
    internal var rxSingleSchedulers: RxSingleSchedulers? = null
    @set : Inject
    internal var api: FarhangApi? = null

    init {
        disposable = CompositeDisposable()
    }



    fun getDataDictionary(){
        showProgress.set(true)

          disposable!!.add(
        api!!.getDictionary(dictonaryRequest!!)
            .compose(rxSingleSchedulers!!.applySchedulers())
            .subscribe({ onReadyDictionary(it) }, { onErrorRetroClient() })
    )

    }

    private fun onReadyDictionary(it: List<DictionaryResponse>?) {
        showProgress.set(false)
        try{
            if(it!!.size>0){
                dictionary.clear()
                dictionary.addAll(it)
            }else{
                navigator!!.message("not found!!")
            }

        }catch (e:Exception){
            navigator!!.message("not found!!")

        }



    }

    private fun onErrorRetroClient() {

    }
    /**
     *
     * @param isConnectedToInternet
     */
    override fun isInternetAvailable(isConnectedToInternet: Boolean) {
        navigator!!.onNetworkStatus(isConnectedToInternet)
    }

    /**
     * On Click Movie Grid Recycler Listener
     * @param position of Grid Recycler
     */
    fun onMoviesItemClick(position: Int) {
        //  navigator!!.onStartDetailMovieActivity(moviesResult.get(position))

    }


    fun getDataDictionary(word: String) {
        dictonaryRequest = word
        getDataDictionary()
    }
}


