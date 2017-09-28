package com.example.admin.mvpmeetsrxjava.View.injector.mainactivity;

import com.example.admin.mvpmeetsrxjava.View.View.mainactivity.MainActivity;

import dagger.Component;

/**
 * Created by Admin on 9/26/2017.
 */

@Component(modules = MainActivityModule.class)
public interface MainActivityComponent {
    void inject(MainActivity mainActivity);


}