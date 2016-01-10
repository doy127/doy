package com.example.root.doy;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by root on 16-1-10.
 */
public class my_service extends Service {

    String TAG = "service";

    class my_binder extends Binder {

        public void action()
        {
            Log.d(TAG, "action");
        }
    }

    private my_binder binder = new my_binder();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");

        Intent intent = new Intent(this, my_service.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        Notification notification = new Notification.Builder(this)
                .setContentTitle("title")
                .setContentText("text")
                .setSmallIcon(R.mipmap.crayon)
                .setContentIntent(pi)
                .build();
        notification.defaults = Notification.DEFAULT_ALL;
        startForeground(1, notification);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}
