package com.example.admin.mvpmeetsrxjava.View.View.mainactivity;

import com.example.admin.mvpmeetsrxjava.View.model.ObserverFactory;
import com.example.admin.mvpmeetsrxjava.View.model.SpecialNumber;

import org.reactivestreams.Subscriber;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Admin on 9/26/2017.
 */

public class MainActivityPresenter implements MainActivityContract.Presenter {

    io.reactivex.Observable<String> mObservable;
    Observer<String> mObserver;
    io.reactivex.Observable<Integer> numObservable;
    Observer<Integer> numObserver;

    MainActivityContract.View view;
    StringBuilder sb = new StringBuilder();
    List<String> words = Arrays.asList(
            "the",
            "quick",
            "brown",
            "fox",
            "jumped",
            "over",
            "the",
            "lazy",
            "dog"
    );

    @Override
    public void attachView(MainActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void validateRange() {

        List<SpecialNumber> specialNumberList = new ArrayList<>();
        SpecialNumber spNum = new SpecialNumber();
        spNum.setSpNumber(1);
        specialNumberList.add(spNum);
        spNum.setSpNumber(2);
        specialNumberList.add(spNum);
        spNum.setSpNumber(3);
        specialNumberList.add(spNum);
        spNum.setSpNumber(4);
        specialNumberList.add(spNum);
        spNum.setSpNumber(5);
        specialNumberList.add(spNum);
        spNum.setSpNumber(6);
        specialNumberList.add(spNum);
        spNum.setSpNumber(7);
        specialNumberList.add(spNum);
        spNum.setSpNumber(8);
        specialNumberList.add(spNum);
        spNum.setSpNumber(9);
        specialNumberList.add(spNum);
        spNum.setSpNumber(10);
        specialNumberList.add(spNum);


        numObservable = Observable.just(specialNumberList).range(1, 5);

        integerObserver();
        numObservable.subscribe(numObserver);

    }

    @Override
    public void validateJust(String inputString) {

        mObservable = mObservable.just("JUST: " + inputString);
        stringObserver();

        mObservable.subscribe(mObserver);

    }

    @Override
    public void validateDelay(){

        List<SpecialNumber> specialNumberList = new ArrayList<>();
        SpecialNumber spNum = new SpecialNumber();
        spNum.setSpNumber(1);
        specialNumberList.add(spNum);
        spNum.setSpNumber(2);
        specialNumberList.add(spNum);
        spNum.setSpNumber(3);
        specialNumberList.add(spNum);
        spNum.setSpNumber(4);
        specialNumberList.add(spNum);
        spNum.setSpNumber(5);
        specialNumberList.add(spNum);
        spNum.setSpNumber(6);
        specialNumberList.add(spNum);
        spNum.setSpNumber(7);
        specialNumberList.add(spNum);
        spNum.setSpNumber(8);
        specialNumberList.add(spNum);
        spNum.setSpNumber(9);
        specialNumberList.add(spNum);
        spNum.setSpNumber(10);
        specialNumberList.add(spNum);


        numObservable = Observable.just(specialNumberList).range(1, 6).delay(6000,TimeUnit.MILLISECONDS);

        integerObserver();
        numObservable.subscribe(numObserver);

    }

    @Override
    public void validateMerge() {
        String[] numbers = {"1", "2", "3", "4"};

        String[] letters = {"a", "b", "c", "d"};

        Observable<String> query1 = Observable.fromArray(numbers);
        Observable<String> query2 = Observable.fromArray(letters);

        stringObserver();
        Observable
                .merge(query1, query2)
                .subscribe(mObserver);
    }

    @Override
    public void validateMaterialize() {
        List<SpecialNumber> specialNumberList = new ArrayList<>();
        SpecialNumber spNum = new SpecialNumber();
        spNum.setSpNumber(1);
        specialNumberList.add(spNum);
        spNum.setSpNumber(2);
        specialNumberList.add(spNum);
        spNum.setSpNumber(3);
        specialNumberList.add(spNum);
        spNum.setSpNumber(4);
        specialNumberList.add(spNum);
        spNum.setSpNumber(5);
        specialNumberList.add(spNum);
        spNum.setSpNumber(6);
        specialNumberList.add(spNum);
        spNum.setSpNumber(7);
        specialNumberList.add(spNum);
        spNum.setSpNumber(8);
        specialNumberList.add(spNum);
        spNum.setSpNumber(9);
        specialNumberList.add(spNum);
        spNum.setSpNumber(10);
        specialNumberList.add(spNum);


        numObservable = Observable.just(specialNumberList).materialize().range(1, 5);

        integerObserver();
        numObservable.subscribe(numObserver);

    }

    @Override
    public void validateRepeat() {
        List<SpecialNumber> specialNumberList = new ArrayList<>();
        SpecialNumber spNum = new SpecialNumber();
        spNum.setSpNumber(1);
        specialNumberList.add(spNum);
        spNum.setSpNumber(2);
        specialNumberList.add(spNum);
        spNum.setSpNumber(3);
        specialNumberList.add(spNum);
        spNum.setSpNumber(4);
        specialNumberList.add(spNum);
        spNum.setSpNumber(5);
        specialNumberList.add(spNum);
        spNum.setSpNumber(6);
        specialNumberList.add(spNum);
        spNum.setSpNumber(7);
        specialNumberList.add(spNum);
        spNum.setSpNumber(8);
        specialNumberList.add(spNum);
        spNum.setSpNumber(9);
        specialNumberList.add(spNum);
        spNum.setSpNumber(10);
        specialNumberList.add(spNum);


        numObservable = Observable.just(specialNumberList).materialize().repeat().range(1, 7);

        integerObserver();
        numObservable.subscribe(numObserver);

    }

    @Override
    public void validateSubscribe() {
        numObservable = Observable.just(1, 2, 3)
                .subscribeOn(Schedulers.newThread());
        integerObserver();
        numObservable.subscribe(numObserver);
    }

    @Override
    public void validateObserver() {
        numObservable = Observable.just(1, 2, 3,4,5,6,7,8,9,10)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
        integerObserver();
        numObservable.subscribe(numObserver);
    }

    @Override
    public void validateInterval() {
        Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS);


        Observer<Long> longObserver = ObserverFactory.getLongObserver();

        observable.subscribe(longObserver);

        try {
            Thread.sleep(2000);
            view.updateView("Interval completed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void validateFilter() {

        sb = new StringBuilder();


        Observable<String> stringObservable = Observable.just("first", "second");

        Observer<String> stringObserver = ObserverFactory.getStringObserver();

        //filter will remove the emissions that does not pass the test
        stringObservable.filter(new Predicate<String>() {
            @Override
            public boolean test(@NonNull String s) throws Exception {
                sb.append(s);
                if (s.equals("first")) {
                    sb.append(" IS TRUE, ");
                   // view.updateView("Filter: TRUE");
                    return true;

                }
                else {
                    sb.append(" IS FALSE, ");
                   // view.updateView("Filter: FALSE");
                    return false;

                }

            }


        }).subscribe(stringObserver);
        view.updateView(sb.toString());
    }

    @Override
    public void validateTake() {
        Observable<Integer> integerObservable = Observable.range(1, 10);

        Observer<Integer> integerObserver = ObserverFactory.getIntObserver();

        integerObservable
                .take(5)
                .subscribe(integerObserver);

        view.updateView("TAKE FINISHED");
    }

    @Override
    public void validateFlatMap() {
        Observable<List<Integer>> integerObservable = Observable.just(com.example.admin.mvpmeetsrxjava.View.utils.DataSource.getIntList(5));

        Observer<Integer> integerObserver = ObserverFactory.getIntObserver();

        //Flatmap transforms the items emitted by the observable into observables
        //then flattens there emission into one a single observable
        integerObservable.flatMap(new Function<List<Integer>, Observable<Integer>>() {
            @Override
            public Observable<Integer> apply(@NonNull List<Integer> integers) throws Exception {

                return Observable.fromIterable(integers);

            }
        }).subscribe(integerObserver);
        view.updateView("FLATMAP FINISHED");

    }

    @Override
    public void validateMap() {
        //creating an observable to emit integer from 1 to 10
        final Observable<Integer> integerObservable = Observable.range(1, 10);

        //create an observer that will receive the emitted values from the observer
        final Observer<Integer> integerObserver = ObserverFactory.getIntObserver();

        //map would transform each emitted object by the observable
        integerObservable
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(@NonNull Integer integer) throws Exception {
                        integer = integer * 10;
                        return integer;

                    }
                })
                .subscribe(integerObserver);
        view.updateView("MAP FINISHED");
    }

    @Override
    public void validateTimer() {
/*
        timer operator will emit a single value after the given delay
*/

        Observable<Long> observable = Observable.timer(1, TimeUnit.SECONDS);

        Observer<Long> longObserver = ObserverFactory.getLongObserver();


        observable.subscribe(longObserver);
//
//        Thread sleep is used to display the result for the delayed emission
//

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        view.updateView("TIMER FINISHED");
    }

    @Override
    public void validateConcat() {
        String[] numbers = {"1", "2", "3", "4"};

        String[] letters = {"a", "b", "c", "d"};

        Observable<String> query1 = Observable.fromArray(numbers);
        Observable<String> query2 = Observable.fromArray(letters);

        stringObserver();
        Observable
                .concat(query1, query2)
                .subscribe(mObserver);
//        assertEquals( new Integer(3), Observable.from(items).count().toBlocking().single() );
     //   view.updateView("TEST");
    }


    public void integerObserver() {

        numObserver = new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Integer i) {
                //  tvOutputString.setText(s);
                sb.append(i + ", ");

                //  view.updateView(""+i);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {
                view.updateView("RANGE: " + sb.toString());
            }
        };
    }

    public void stringObserver() {
      sb = new StringBuilder();
        mObserver = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull String s) {
                //  tvOutputString.setText(s);
                sb.append(s + ", ");
               // view.updateView(sb.toString());
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {
                view.updateView("MERGE: :"+sb.toString());
            }
        };

     //   mObservable.subscribe(mObserver);
    }
}
