package com.pan.calendarsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CalendarView;

import java.net.URL;
import java.net.URLConnection;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendarView = (CalendarView) findViewById(R.id.calendarView);

        initCalendar();


    }

    private void initCalendar() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                URL url = null;
                try {
                    // 获取网络时间，这里获取淘宝的时间
                    url = new URL("http://www.taobao.com");
                    URLConnection uc = url.openConnection();
                    final long networkTime = uc.getDate();


                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            // 预订起始日期
                            calendarView.setMinDate(networkTime);

                            // 预订结束日期
                            Calendar calendar = Calendar.getInstance();
                            Date date = new Date(networkTime);
                            calendar.setTime(date);// 设置当天日期
                            calendar.add(Calendar.DATE, 30);// 增加30天的预订时间
                            //解决最后一天不能点击的问题
                            calendar.set(Calendar.HOUR_OF_DAY, 23);
                            calendar.set(Calendar.MINUTE, 59);
                            calendar.set(Calendar.SECOND, 59);

                            long endTime = calendar.getTimeInMillis();
                            calendarView.setMaxDate(endTime);
                        }
                    });

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }
}
