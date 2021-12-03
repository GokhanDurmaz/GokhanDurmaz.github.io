package com.demo.ans.github;

import android.util.Log;

import androidx.annotation.VisibleForTesting;

import com.demo.ans.ui.activity.MainActivity;
import com.demo.ans.constants.CommonConstants;
import com.demo.ans.github.network.GithubDemoApplicationServer;
import com.demo.ans.github.network.ResponseReturnHandler;
import com.demo.ans.model.GithubResponseModel;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by gokhan on 11/11/21.
 * @author gokhan
 * @since 2021/11/11
 */

public class GithubResponsePresenter implements GithubResponseContract.Presenter {
    private final static String TAG = GithubResponsePresenter.class.getSimpleName();

    private GithubResponseContract.View mView;

    private ExecutorService mExecutor;

    @Override
    public void setView(GithubResponseContract.View view) {
        this.mView = view;
    }

    @Override
    public void onCreate() {
        Log.i(TAG, "UI is created.");
        this.mView.bindViews();
        this.mView.onClick();
        mExecutor = Executors.newSingleThreadExecutor();
    }

    @Override
    public void onRefreshClick() {
        setResponseToView();
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "Terminated single thread.");
        if (!mExecutor.isShutdown()) {
            mExecutor.shutdown();
        }
    }

    private void setResponseToView() {
        getContentFromUrl(new ResponseReturnHandler() {
            @Override
            public void onDone(Object obj) {
                GithubResponseModel model = null;
                if (obj instanceof GithubResponseModel) {
                    model = (GithubResponseModel) obj;
                }
                if (model == null) {
                    Log.e(MainActivity.class.getSimpleName(), "model is null");
                    return;
                }
                mView.setViewOnUiThread(model);
            }

            @Override
            public void onFailure(int failCode) {
                Log.e(MainActivity.class.getSimpleName(), "Failed to get response, errCode=" + failCode);
            }
        });
    }

    @VisibleForTesting
    public void getContentFromUrl(ResponseReturnHandler handler) {
        mExecutor.execute(() -> {
            try {
                GithubResponseModel model = GithubDemoApplicationServer.getInstance().getGithubResponse();
                handler.onDone(model);
            } catch (IOException e) {
                Log.e(MainActivity.class.getSimpleName(), "error=" + e.getMessage());
                handler.onFailure(CommonConstants.ERR_RET_CODE);
            }
        });
    }
}
