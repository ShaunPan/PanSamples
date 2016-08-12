package cn.pan.basesample1.app;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Pan
 * Date:   2016/8/3
 * Description:
 */
public class App {

    private static App mApp = null;
    private static List<Activity> sActivityList = new ArrayList<>();

    private App() {
    }

    public static App getInstance() {
        if (mApp == null) {
            mApp = new App();
        }
        return mApp;
    }


    public static void addActivity(Activity activity) {
        if (!sActivityList.contains(activity)) {
            sActivityList.add(activity);
        }
    }

    public static void removeActivity(Activity activity) {
        if (sActivityList.contains(activity)) {
            sActivityList.remove(activity);
        }
    }

}
