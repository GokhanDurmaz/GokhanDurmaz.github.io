package com.demo.ans.di.modules;

import androidx.lifecycle.ViewModel;

import com.demo.ans.di.InjectionViewModelProvider;
import com.demo.ans.ui.AndroidNetworkSecurityViewModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.android.support.DaggerFragment;

/**
 * Created by gokhan on 12/3/21.
 * @author gokhan
 * @since 2021/12/03
 */

@Module
public class ViewModelModule {

    @Singleton
    @Provides
    public ViewModel provideAndroidNetworkSecurityViewModel(
            DaggerFragment fragment,
            InjectionViewModelProvider<AndroidNetworkSecurityViewModel> viewModelProvider
    ) {
        return viewModelProvider.get(fragment, AndroidNetworkSecurityViewModel.class);
    }
}
