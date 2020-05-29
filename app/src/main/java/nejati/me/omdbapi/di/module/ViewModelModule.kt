package nejati.me.omdbapi.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import nejati.me.omdbapi.di.scope.ViewModelKey
import nejati.me.omdbapi.module.ApiModule
import nejati.me.omdbapi.utility.FarhangViewModelFactory
import nejati.me.omdbapi.viewModels.mainActivity.MainViewModel

/**
 * Authors:
 * Reza Nejati <rn.nejati@gmail.com>
 * Copyright © 2020
 */
@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun omdbViewModelFactory(factory: FarhangViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun mainViewModel(mainViewModel: MainViewModel): ViewModel


}
