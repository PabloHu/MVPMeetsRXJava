package com.example.admin.mvpmeetsrxjava.View.View;

/**
 * Created by Admin on 9/26/2017.
 */

public interface BasePresenter <V extends BaseView> {
    void attachView(V view);
    void detachView();
}
