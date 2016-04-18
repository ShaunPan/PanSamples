package com.pan.pansamples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import rx.Subscriber;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createObservableType_create();
    }

    /**
     * 创建observable的基本方式
     */
    private void createObservableType_create() {
        rx.Observable<String> observable = rx.Observable.create(new rx.Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("create_1");
                subscriber.onNext("create_2");
                subscriber.onNext("create_3");
                subscriber.onCompleted();
            }
        });
        observable.subscribe();
    }

    /**
     * 将传入的参数依次发送出来。
     */
    private void createObservableType_from() {
        rx.Observable<String> observable = rx.Observable.just("from1", "from2", "from3");
    }

    private void createObservableType_just() {
        String[] justStr = {"just1", "just2", "just3"};
        rx.Observable<String[]> observable = rx.Observable.just(justStr);
    }

}
