package com.demo.ans;

import android.app.Application;

import com.datatheorem.android.trustkit.TrustKit;

/**
 * Created by gokhan on 11/5/21.
 * @author gokhan
 * @since 2021/11/05
 */

public class AndroidNetworkSecurityApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        TrustKit.initializeWithNetworkSecurityConfiguration(this);
    }
}
