package com.demo.ans.di.components;

import com.demo.ans.AndroidNetworkSecurityApp;
import com.demo.ans.di.modules.ActivityInjectionsModule;
import com.demo.ans.di.modules.AppModule;
import com.demo.ans.di.modules.ViewModelModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by gokhan on 12/3/21.
 */

@Singleton
@Component(
        modules = {
                AndroidSupportInjectionModule.class,
                ActivityInjectionsModule.class,
                AppModule.class,
                ViewModelModule.class
        }
)
public interface AppComponent extends AndroidInjector<AndroidNetworkSecurityApp> {
    @Component.Factory
    interface Factory {
        AppComponent create(@BindsInstance AndroidNetworkSecurityApp application);
    }
}
