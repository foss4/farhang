package nejati.me.omdbapi.webServices.api

import io.reactivex.Single
import nejati.me.omdbapi.webServices.helper.Const
import nejati.me.omdbapi.webServices.farhangModel.dictionary.DictionaryResponse
import retrofit2.http.GET
import retrofit2.http.Path


/**
 * Authors:
 * Reza Nejati <rn.nejati@gmail.com>
 * Copyright © 2020
 */
interface RetroClient {

    @GET(Const.Dictionary)
    fun getDictionary(
        @Path("word") word: String

    ): Single<List<DictionaryResponse>>

}
