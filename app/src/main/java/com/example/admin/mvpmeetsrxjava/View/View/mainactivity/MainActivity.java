package com.example.admin.mvpmeetsrxjava.View.View.mainactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.admin.mvpmeetsrxjava.R;
import com.example.admin.mvpmeetsrxjava.View.injector.mainactivity.DaggerMainActivityComponent;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {

    private static final String TAG = "MainActivityTag";
    @BindView(R.id.etInputString)
    EditText etInputString;

    @BindView(R.id.tvOutputString)
    TextView tvOutputString;
    @Inject
    MainActivityPresenter presenter;

    /*
        io.reactivex.Observable<String> mObservable;
        Observer<String> mObserver;
      */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setUpDaggerComponent();
        presenter.attachView(this);

        /*
        mObservable = mObservable.just("kiwi likes chicken");
        mObserver = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull String s) {
                tvOutputString.setText(s);

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
*/
    }

    private void setUpDaggerComponent() {
        DaggerMainActivityComponent.create().inject(this);
        ;
    }

    @Override
    public void showError(String s) {
        Log.d(TAG, "showError: " + s);
    }

    @Override
    public void updateView(String str) {
        try {
            tvOutputString.setText(str);
        } catch (Exception e) {

        }
    }
    /*
    @OnClick(R.id.btnUpdateView)
    public void updateViewClick(View view) {
        presenter.validateInput(etInputString.getText().toString());
    }
*/

    public void buttonClicks(View view) {
        switch (view.getId()) {
            case R.id.btnJust:
//mObservable.subscribe(mObserver);
                presenter.validateJust(etInputString.getText().toString());
                break;
            case R.id.btnRange:
                presenter.validateRange();
                break;

            case R.id.btnDelay:
                presenter.validateDelay();
                break;
            case R.id.btnConcat:
                presenter.validateConcat();
                break;
            case R.id.btnMerge:
                presenter.validateMerge();
                break;
            case R.id.btnMaterialize:
                presenter.validateMaterialize();
                break;
            case R.id.btnRepeat:
                presenter.validateRepeat();
                break;
            case R.id.btnSubscribe:
                presenter.validateSubscribe();
                break;
            case R.id.btnObserverOn:
                presenter.validateObserver();
                break;
            case R.id.btnInterval:
                presenter.validateInterval();
                break;
            case R.id.btnFilter:
                presenter.validateFilter();
                break;
            case R.id.btnTake:
                presenter.validateTake();
                break;
            case R.id.btnFlatMap:
                presenter.validateFlatMap();
                break;
            case R.id.btnMap:
                presenter.validateMap();
                break;
            case R.id.btnTimer:
                presenter.validateTimer();
                break;
        }
    }
}
