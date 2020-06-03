package nejati.me.omdbapi.view.activities.mian

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.TextView.OnEditorActionListener
import androidx.core.view.ViewCompat
import kotlinx.android.synthetic.main.activity_main.*
import nejati.me.omdbapi.BR
import nejati.me.omdbapi.R
import nejati.me.omdbapi.base.BaseActivity
import nejati.me.omdbapi.databinding.ActivityMainBinding
import nejati.me.omdbapi.viewModels.mainActivity.MainViewModel
import nejati.me.omdbapi.webServices.farhangModel.dictionary.DictionaryResult
import nejati.me.sample.view.dialog.DetailDialog
import java.util.*


/**
 * Authors:
 * Reza Nejati <rn.nejati@gmail.com>
 * Copyright © 2020
 */

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(),
    MainActivityNavigator {
    var detailDialog: DetailDialog? = null


    /**
     * Set Variable fot DataBinding
     *
     * @return
     */
    override val bindingVariable: Int
        get() = BR.viewModel

    /**
     * Set Layout For Activity
     *
     * @return
     */
    override val layoutRes: Int
        get() = R.layout.activity_main

    /**
     * Add View Model
     *
     * @return
     */
    override fun getViewModel(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel!!.navigator = this
        ViewCompat.setNestedScrollingEnabled(rvResult, true)
        etSearchView.requestFocus()
        etSearchView.setOnEditorActionListener(OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH && etSearchView.text!!.length > 0) {
                viewModel!!.getDataDictionary(etSearchView.text.toString())
                val imm =
                    getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                Objects.requireNonNull(imm)
                    .hideSoftInputFromWindow(etSearchView.getWindowToken(), 0)
                return@OnEditorActionListener true
            }
            false
        })
    }


    override fun onNetworkStatus(isConnectedToInternet: Boolean) {
        when {

            !isConnectedToInternet -> showSnackBar(
                dataBinding!!.root,
                getString(R.string.network_not_available)
            )
        }
    }

    override fun message(message: String) {
        showSnackBar(
            dataBinding!!.root,
            message
        )
    }

    override fun onMoreInExpandClick(t: DictionaryResult?) {
        detailDialog = DetailDialog.newInstance(this,t!!)
        detailDialog!!.show(supportFragmentManager, "detailDialog")
    }

}
