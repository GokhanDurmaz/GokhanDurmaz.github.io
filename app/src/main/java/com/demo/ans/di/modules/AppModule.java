package com.demo.ans.di.modules;

import android.app.Application;

import com.demo.ans.AndroidNetworkSecurityApp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by gokhan on 12/3/21.
 */

@Module
public class AppModule {

    @Singleton
    @Provides
    public Application provideAndroidNetworkSecurityApp(AndroidNetworkSecurityApp app) {
        return app;
    }
}
