package com.demo.ans.di.modules;

import com.demo.ans.ui.activity.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by gokhan on 12/3/21.
 * @author gokhan
 * @since 2021/12/03
 */

@Module
public abstract class ActivityInjectionsModule {

    @ContributesAndroidInjector
    abstract MainActivity mainActivityInjector();
}
