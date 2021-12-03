package com.demo.ans.di.modules;

/**
 * Created by gokhan on 12/3/21.
 */

import com.demo.ans.ui.activity.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityInjectionsModule {

    @ContributesAndroidInjector
    abstract MainActivity mainActivityInjector();
}
