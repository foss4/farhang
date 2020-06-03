package nejati.me.omdbapi.base

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProviders
import javax.inject.Inject

/**
 * Authors:
 * Reza Nejati <rn.nejati@gmail.com>
 * Copyright © 2019
 */
abstract class BaseDialog<D : ViewDataBinding, V : DialogBaseViewModel<*>> : DialogFragment() {

    protected var dataBinding: D? = null

    protected var viewModel: V? = null

    abstract val bindingVariable: Int

    @get:LayoutRes
    protected abstract val layoutRes_portrait: Int


    protected abstract val _Activity: Activity

    internal lateinit var dialog: Dialog

    @SuppressLint("CheckResult")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        super.onCreate(savedInstanceState)

        dialog = Dialog(_Activity)

        viewModel = ViewModelProviders.of(this).get(getViewModel())

        screenStatus(resources.configuration.orientation)

        dataBinding!!.setVariable(bindingVariable, viewModel)
        dataBinding!!.executePendingBindings()

        onCreate()

        return dialog
    }

    protected abstract fun getViewModel(): Class<V>

    protected abstract fun onCreate()

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        screenStatus(newConfig.orientation)
    }

    fun screenStatus(orientation: Int) {

/*
        val intLayoutId: Int

        if (orientation== Configuration.ORIENTATION_PORTRAIT){
            intLayoutId=layoutRes_portrait
        }else{
            intLayoutId=layoutRes_land
        }
*/

        dataBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),layoutRes_portrait, null, false)
        dialog.setContentView(dataBinding!!.getRoot())

    }
}