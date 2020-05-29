package nejati.me.sample.di.api


import io.reactivex.Single
import nejati.me.omdbapi.webServices.api.RetroClient
import nejati.me.omdbapi.webServices.farhangModel.dictionary.DictionaryResponse
import javax.inject.Inject


/**
 * Authors:
 * Reza Nejati <rn.nejati@gmail.com>
 * Copyright © 2020
 */
class OmdpApi(private val api: RetroClient) {


    fun getDictionary(request: String): Single<List<DictionaryResponse>> {
        return api.getDictionary(request)
    }

}
