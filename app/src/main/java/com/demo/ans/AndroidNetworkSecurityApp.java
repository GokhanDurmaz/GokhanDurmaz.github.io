package com.demo.ans;

import com.datatheorem.android.trustkit.TrustKit;
import com.demo.ans.di.components.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

/**
 * Created by gokhan on 11/5/21.
 *
 * @author gokhan
 * @since 2021/11/05
 */

public class AndroidNetworkSecurityApp extends DaggerApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        TrustKit.initializeWithNetworkSecurityConfiguration(this);
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.factory().create(this);
    }
}
