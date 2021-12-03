package com.demo.ans.ui.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.demo.ans.R;
import com.demo.ans.github.GithubResponseContract;
import com.demo.ans.github.GithubResponsePresenter;
import com.demo.ans.model.GithubResponseModel;
import com.demo.ans.ui.AndroidNetworkSecurityViewModel;

import javax.inject.Inject;

import dagger.android.DaggerActivity;

/**
 * Created by gokhan on 11/5/21.
 * @author gokhan
 * @since 2021/11/05
 */

public class MainActivity extends DaggerActivity implements GithubResponseContract.View {
    private final static String TAG = MainActivity.class.getSimpleName();

    @Inject
    public AndroidNetworkSecurityViewModel viewModel;

    private GithubResponsePresenter mGithubResponsePresenter;
    private Button mRefreshButton;
    private ImageView mProfileImage;
    private TextView mNameTV;
    private TextView mSurnameTV;
    private TextView mAppInfoTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "MainActivity is created");
        setContentView(R.layout.activity_main);

        mGithubResponsePresenter = new GithubResponsePresenter();
        mGithubResponsePresenter.setView(this);
        mGithubResponsePresenter.onCreate();
    }

    @Override
    public void bindViews() {
        Log.i(TAG, "Views are binding");
        mRefreshButton = this.findViewById(R.id.refreshBtn);
        mProfileImage = this.findViewById(R.id.profileIV);
        mNameTV = this.findViewById(R.id.nameTV);
        mSurnameTV = this.findViewById(R.id.surnameTV);
        mAppInfoTV = this.findViewById(R.id.appInfoTV);
    }

    @Override
    public void onClick() {
        Log.i(TAG, "Click event is created");
        mRefreshButton.setOnClickListener(v -> {
            this.mGithubResponsePresenter.onRefreshClick();
            mAppInfoTV.setText(viewModel.getAndroidNetworkSecurityAppInfo());
        });
    }

    @Override
    public void setViewOnUiThread(GithubResponseModel model) {
        Log.i(TAG, "Response model is set to UI components");
        runOnUiThread(() -> {
            mNameTV.setText(model.getName());
            mSurnameTV.setText(model.getSurname());
            setImageView(model.getImageUrl());
        });
    }

    private void setImageView(String imageUrl) {
        Glide.with(this)
                .load(imageUrl)
                .circleCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_baseline_error_outline_24)
                .into(mProfileImage);
    }

    @Override
    protected void onDestroy() {
        this.mGithubResponsePresenter.onDestroy();
        super.onDestroy();
    }
}
