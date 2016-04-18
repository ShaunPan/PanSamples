package com.pan.handlersample;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.lang.ref.WeakReference;

/**
 * 演示处理Handler引起的内存泄露问题
 */
public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    private MyHandler myHandler = new MyHandler(this);

    //报内存溢出警告的handler
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {//处理发送过来的消息
            if (msg.arg1 == 1) {
                Log.i(TAG, "1消息已被接收");
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendMessageToHandler();
    }

    /**
     * 向Handler发送消息
     */
    private void sendMessageToHandler() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                Message message = Message.obtain();
                message.arg1 = 1;
                handler.sendMessage(message);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Message message = Message.obtain();
                message.arg2 = 2;
                myHandler.sendMessage(message);
            }
        }).start();

    }

    /**
     * MyHandler的处理方法
     *
     * @param msg 消息
     */
    private void handlerMessage(Message msg) {
        if (msg.arg2 == 2) {
            Log.i(MainActivity.TAG, "2已接收到消息");
        }
    }


    private static class MyHandler extends Handler {

        //弱引用，避免Handler持有外部类的引用，即MainActivity的引用，
        // 这样会导致MainActivity的上下文及资源无法被回收，引发内存泄露的情况发生
        private WeakReference<MainActivity> weakReference;

        public MyHandler(MainActivity mainActivity) {
            weakReference = new WeakReference<>(mainActivity);
        }

        @Override
        public void handleMessage(Message msg) {

            MainActivity mainActivity = weakReference.get();
            mainActivity.handlerMessage(msg);

        }
    }

}
