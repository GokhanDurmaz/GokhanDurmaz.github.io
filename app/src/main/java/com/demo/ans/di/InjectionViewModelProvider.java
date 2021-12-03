package com.demo.ans.di;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProvider.Factory;

import javax.inject.Inject;

import dagger.Lazy;

/**
 * Created by gokhan on 12/3/21.
 */

public class InjectionViewModelProvider<VM extends ViewModel> {

    private final Lazy<VM> lazyViewModel;

    @Inject
    public InjectionViewModelProvider(dagger.Lazy<VM> lazyViewModel) {
        this.lazyViewModel = lazyViewModel;
    }

    @SuppressWarnings("unchecked")
    private final Factory viewModelFactory = new Factory() {
        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) lazyViewModel.get();
        }
    };

    public <ACTIVITY extends FragmentActivity> ViewModel get(ACTIVITY activity, Class<VM> viewModelClass) {
        return new ViewModelProvider(activity, viewModelFactory).get(viewModelClass);
    }

    public <FRAGMENT extends Fragment> ViewModel get(FRAGMENT fragment, Class<VM> viewModelClass) {
        return new ViewModelProvider(fragment, viewModelFactory).get(viewModelClass);
    }
}
