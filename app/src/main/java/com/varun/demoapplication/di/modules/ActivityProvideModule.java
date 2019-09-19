package com.varun.demoapplication.di.modules;


import com.varun.demoapplication.view.MainActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityProvideModule {

    @ContributesAndroidInjector
    abstract MainActivity contributeMainActivity();
}
