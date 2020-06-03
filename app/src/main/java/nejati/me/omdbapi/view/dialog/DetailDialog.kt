package nejati.me.sample.view.dialog

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.WindowManager
import nejati.me.omdbapi.BR
import nejati.me.omdbapi.R
import nejati.me.omdbapi.base.BaseDialog
import nejati.me.omdbapi.databinding.AlertDialogDetailBinding
import nejati.me.omdbapi.view.dialog.DetailDialogNavigator
import nejati.me.omdbapi.webServices.farhangModel.dictionary.DictionaryResult
import nejati.me.sample.viewModel.dialog.detailDialog.DialogViewModel
import java.util.Objects




/**
 * Authors:
 * Reza Nejati <rn.nejati@gmail.com>
 * Copyright © 2019
 */
class DetailDialog(override val _Activity: Activity) :
    BaseDialog<AlertDialogDetailBinding, DialogViewModel>(), DetailDialogNavigator {
    private var result: DictionaryResult? = null

    companion object {
        @JvmStatic fun newInstance(activity: Activity, result: DictionaryResult): DetailDialog {
            val dialog = DetailDialog(activity)
            dialog.result = result
            return dialog
        }

    }

    override fun getViewModel(): Class<DialogViewModel> {
        return DialogViewModel::class.java
    }

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutRes_portrait: Int
        get() = R.layout.alert_dialog_detail


    override fun onCreate() {

        viewModel!!.navigator = this

        viewModel!!.dictionaryResult.set(result)

        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val lp = WindowManager.LayoutParams()

        lp.copyFrom(dialog.window!!.attributes)

        lp.width = WindowManager.LayoutParams.MATCH_PARENT

        lp.height = WindowManager.LayoutParams.WRAP_CONTENT

        dialog.window!!.attributes = lp


    }

    override fun onCloseClick() {
        dismiss()
    }


    override fun onShareClick() {

        val sharingIntent = Intent(Intent.ACTION_SEND)

        sharingIntent.type = "text/plain"

        sharingIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.app_name))

        val sb = StringBuilder()

        sb.append(getString(R.string.mean).plus(" ").plus("\"").plus(result!!.name).plus("\"").plus(" از فرهنگ لغت")
            .plus(" ").plus(result!!.dictionary).plus(":").plus("\n"))
            .append((result!!.meaning).plus("\n"))
            .append(("----------------------------").plus("\n"))

            .append("https://www.abtin_reza.com/")


        sharingIntent.putExtra(Intent.EXTRA_TEXT, sb.toString())

        startActivity(
            Intent.createChooser(sharingIntent, "share").addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        )
    }
}
