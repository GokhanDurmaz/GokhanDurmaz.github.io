package com.demo.ans.github;

import com.demo.ans.AndroidNetworkSecurityDemoTest;
import com.demo.ans.github.network.GithubDemoApplicationServer;
import com.demo.ans.github.network.ResponseReturnHandler;
import com.demo.ans.model.GithubResponseModel;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by gokhan on 11/6/21.
 */


public class GithubResponseTest extends AndroidNetworkSecurityDemoTest {
    private static final String TAG = GithubResponseTest.class.getSimpleName();

    @Test
    public void givenModel_WhenResponse_ThenVerifying() {
        mActivity.getContentFromUrl(new ResponseReturnHandler() {
            @Override
            public void onDone(Object obj) {
                assertTrue(true);
            }

            @Override
            public void onFailure(int failCode) {
                fail();
            }
        });
    }

    @Test
    public void responseValidation() throws IOException {
        final String realResponse = "{\"code\": 0, \"desc\": \"Success\", \"name\": \"Gökhan\", \"surname\": \"Durmaz\", \"imageUrl\": \"https://media-exp1.licdn.com/dms/image/C4D03AQHkm1TSbk2lPg/profile-displayphoto-shrink_200_200/0/1575757259572?e=1641427200&v=beta&t=GbbormIP524a17qDwierWVk1OcWVa8BURHE6xkQgu-w\"}";
        GithubResponseModel model = GithubDemoApplicationServer.getInstance().getGithubResponse();
        GithubResponseModel realModel = gson.fromJson(realResponse, GithubResponseModel.class);
        assertEquals(model.getCode(), realModel.getCode());
        assertEquals(model.getDesc(), realModel.getDesc());
        assertEquals(model.getName(), realModel.getName());
        assertEquals(model.getSurname(), realModel.getSurname());
    }
}
