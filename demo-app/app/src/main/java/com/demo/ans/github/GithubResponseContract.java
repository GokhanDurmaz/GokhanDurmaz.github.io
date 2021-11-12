package com.demo.ans.github;

import com.demo.ans.model.GithubResponseModel;

/**
 * Created by gokhan on 11/11/21.
 * @author gokhan
 * @since 2021/11/11
 */

public interface GithubResponseContract {

    interface View {

        void bindViews();

        void onClick();

        void setViewOnUiThread(GithubResponseModel model);
    }

    interface Presenter {

        void setView(View view);

        void onCreate();

        void onRefreshClick();

        void onDestroy();
    }
}
