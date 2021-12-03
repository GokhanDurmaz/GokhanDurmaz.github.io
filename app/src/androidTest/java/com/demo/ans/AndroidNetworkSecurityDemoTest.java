package com.demo.ans;

import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.demo.ans.ui.activity.MainActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;

/**
 * Created by gokhan on 11/6/21.
 */

@RunWith(AndroidJUnit4.class)
public abstract class AndroidNetworkSecurityDemoTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule(MainActivity.class);

    protected MainActivity mActivity = null;

    protected Gson gson;

    @Before
    public void setUp() {
        mActivity = mActivityRule.getActivity();
        gson = new GsonBuilder().create();
    }

    @After
    public void tearDown() {
        mActivity = null;
    }
}
