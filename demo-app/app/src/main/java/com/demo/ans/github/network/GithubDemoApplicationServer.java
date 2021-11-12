package com.demo.ans.github.network;

import android.util.Log;

import androidx.annotation.VisibleForTesting;

import com.datatheorem.android.trustkit.TrustKit;
import com.demo.ans.model.GithubResponseModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;


/**
 * Created by gokhan on 11/5/21.
 * @author gokhan
 * @since 2021/11/05
 */

public class GithubDemoApplicationServer {
    private final static String TAG = GithubDemoApplicationServer.class.getSimpleName();
    private static final String URL_NAME = "https://gokhandurmaz.github.io/output.json";
    private final Gson gson;

    private GithubDemoApplicationServer() {
        gson = new GsonBuilder().create();
    }

    public static GithubDemoApplicationServer getInstance() {
        return InnerSingletonHolder.INSTANCE;
    }

    @VisibleForTesting
    public GithubResponseModel getGithubResponse() throws IOException {
        StringBuilder strBuilder = new StringBuilder();
        URL url = new URL(URL_NAME);
        HttpsURLConnection client = (HttpsURLConnection) url.openConnection();
        client.setSSLSocketFactory(TrustKit.getInstance().getSSLSocketFactory(client.getURL().getHost()));
        try {
            InputStream inputStream = new BufferedInputStream(client.getInputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String buffer;
            while ((buffer = reader.readLine()) != null) {
                strBuilder.append(buffer);
            }
        } finally {
            client.disconnect();
        }
        Log.i(TAG, "response=" + strBuilder);
        return gson.fromJson(String.valueOf(strBuilder), GithubResponseModel.class);
    }

    private static class InnerSingletonHolder {
        private final static GithubDemoApplicationServer INSTANCE = new GithubDemoApplicationServer();
    }
}
