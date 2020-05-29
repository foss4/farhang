package nejati.me.omdbapi.base

import android.app.Activity
import android.app.Application
import android.content.ContextWrapper
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleObserver
import com.pixplicity.easyprefs.library.Prefs
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import nejati.me.omdbapi.R
import nejati.me.omdbapi.di.component.DaggerApplicationComponent
import nejati.me.omdbapi.utility.font.CustomViewWithTypefaceSupport
import nejati.me.omdbapi.utility.font.TextField
import uk.co.chrisjenx.calligraphy.CalligraphyConfig
import javax.inject.Inject

/**
 * Authors:
 * Reza Nejati <rn.nejati></rn.nejati>@gmail.com>
 * Copyright © 2020
 */
class BaseApplication : Application(), HasActivityInjector, LifecycleObserver{
    companion object {
        private lateinit var app: BaseApplication
        fun get(): BaseApplication = app
    }

    @set : Inject
    var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>? = null



    override fun onCreate() {
        super.onCreate()

        app = this


        DaggerApplicationComponent
            .builder()
            .application(this)
            .build()
            .inject(this)

        Prefs.Builder()
            .setContext(this)
            .setMode(ContextWrapper.MODE_PRIVATE)
            .setPrefsName(packageName)
            .setUseDefaultSharedPreference(true)
            .build()
        CalligraphyConfig.initDefault(
            CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/iran_sans_normal.ttf")
                .setFontAttrId(R.attr.fontPath)
                .addCustomViewWithSetTypeface(CustomViewWithTypefaceSupport::class.java)
                .addCustomStyle(TextField::class.java, R.attr.textFieldStyle)
                .build()
        )


    }

    override fun activityInjector(): AndroidInjector<Activity>? {
        return activityDispatchingAndroidInjector
    }


}