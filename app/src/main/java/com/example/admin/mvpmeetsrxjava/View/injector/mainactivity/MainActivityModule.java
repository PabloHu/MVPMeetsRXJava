package com.example.admin.mvpmeetsrxjava.View.injector.mainactivity;

import com.example.admin.mvpmeetsrxjava.View.View.mainactivity.MainActivityPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Admin on 9/26/2017.
 */

@Module
public class MainActivityModule {

    @Provides
    MainActivityPresenter getMainActivityPresenter(){
        return new MainActivityPresenter();
    }



}
