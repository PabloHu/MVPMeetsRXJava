package com.example.admin.mvpmeetsrxjava.View.View.mainactivity;

import com.example.admin.mvpmeetsrxjava.View.View.BasePresenter;
import com.example.admin.mvpmeetsrxjava.View.View.BaseView;

/**
 * Created by Admin on 9/26/2017.
 */

public interface MainActivityContract {
    interface View extends BaseView {
        void updateView(String str);


    }

    interface Presenter extends BasePresenter<View> {
        void validateRange();
        void validateJust(String inputString);
        void validateDelay ();
        void validateConcat ();
        void validateMerge ();
        void validateMaterialize();
        void validateRepeat ();
        void validateSubscribe ();
        void validateObserver();
        void validateInterval ();
        void validateFilter ();
        void validateTake ();
        void validateFlatMap ();
        void validateMap ();
        void validateTimer ();
    }
}
