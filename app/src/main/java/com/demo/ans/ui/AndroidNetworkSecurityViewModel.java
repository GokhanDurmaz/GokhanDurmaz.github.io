package com.demo.ans.ui;

import androidx.lifecycle.ViewModel;

import com.demo.ans.AndroidNetworkSecurityApp;

import javax.inject.Inject;

/**
 * Created by gokhan on 12/3/21.
 */

public class AndroidNetworkSecurityViewModel extends ViewModel {

    private final AndroidNetworkSecurityApp app;

    @Inject
    public AndroidNetworkSecurityViewModel(AndroidNetworkSecurityApp app) {
        this.app = app;
    }

    public String getAndroidNetworkSecurityAppInfo() {
        return app.getPackageName();
    }
}
