package nejati.me.omdbapi.view.adapter.mainActivity

import nejati.me.omdbapi.webServices.farhangModel.dictionary.DictionaryResponse

interface DictionaryClickListener {
    fun itemClicked(t: DictionaryResponse?)
}