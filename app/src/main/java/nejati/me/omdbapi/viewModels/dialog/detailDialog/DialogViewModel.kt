package nejati.me.sample.viewModel.dialog.detailDialog

import androidx.databinding.ObservableField
import nejati.me.omdbapi.base.DialogBaseViewModel
import nejati.me.omdbapi.view.dialog.DetailDialogNavigator
import nejati.me.omdbapi.webServices.farhangModel.dictionary.DictionaryResult

/**
 * Authors:
 * Reza Nejati <rn.nejati@gmail.com>
 * Copyright © 2020
 */
class DialogViewModel() : DialogBaseViewModel<DetailDialogNavigator>() {

    var dictionaryResult = ObservableField<DictionaryResult>()

    var startAnimation = ObservableField(true)

    fun onClose() {
        navigator!!.onCloseClick()
    }

    fun onShare() {
        navigator!!.onShareClick()
    }

}
