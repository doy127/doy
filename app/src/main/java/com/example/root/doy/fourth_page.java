package com.example.root.doy;

import android.app.Fragment;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.VideoView;



/**
 * Created by root on 16-1-6.
 */
public class fourth_page extends Fragment implements View.OnClickListener {

    private Button button_send_notice;
    private VideoView video_view;

    private Handler handler = new Handler() {

        public void handleMessage(Message msg)
        {
            switch (msg.what)
            {
                case 1:
                {
                    Uri uri = Uri.parse(Environment.getExternalStorageDirectory().getPath()+"/b.mp4");
                    video_view.setVideoURI(uri);
                    break;
                }
                case 2:
                {
                    Uri uri = Uri.parse(Environment.getExternalStorageDirectory().getPath()+"/a.mp4");
                    video_view.setVideoURI(uri);
                    break;
                }
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fourth_page, container, false);
        button_send_notice = (Button)view.findViewById(R.id.send_notice);
        button_send_notice.setOnClickListener(this);

        Button play = (Button)view.findViewById(R.id.play);
        play.setOnClickListener(this);
        Button pause = (Button)view.findViewById(R.id.pause);
        pause.setOnClickListener(this);
        Button replay = (Button)view.findViewById(R.id.replay);
        replay.setOnClickListener(this);
        video_view = (VideoView)view.findViewById(R.id.video_view);
        set_video_path();

        Button start_thread = (Button)view.findViewById(R.id.start_thread);
        start_thread.setOnClickListener(this);

        return view;
    }

    private void set_video_path()
    {
        Uri uri = Uri.parse(Environment.getExternalStorageDirectory().getPath()+"/a.mp4");
        video_view.setVideoURI(uri);
    }

    public void onClick(View v)
    {
        switch (v.getId()) {
            case R.id.send_notice:
            {
                NotificationManager manager = (NotificationManager)getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
                Intent intent = new Intent(getActivity(), activity_2.class);
                PendingIntent pi = PendingIntent.getActivity(getActivity(), 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
                Notification notification = new Notification.Builder(getActivity())
                        .setContentTitle("title")
                        .setContentText("text")
                        .setSmallIcon(R.mipmap.crayon)
                        .setContentIntent(pi)
                        .build();
                notification.defaults = Notification.DEFAULT_ALL;
                manager.notify(1, notification);
                break;
            }
            case R.id.play:
            {
                if(!video_view.isPlaying())
                    video_view.start();
                break;
            }
            case R.id.pause:
            {
                if(video_view.isPlaying())
                    video_view.pause();
                break;
            }
            case R.id.replay:
            {
                if(video_view.isPlaying())
                    video_view.resume();
                break;
            }
            case R.id.start_thread:
            {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int flag = 0;
                        while (true) {
                            Log.d("Thread", "5s");
                            try {
                                Thread.sleep(5000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            if(flag == 0) {
                                Message msg = new Message();
                                msg.what = 1;
                                handler.sendMessage(msg);
                                flag = 1;
                            }
                            else if(flag == 1){
                                Message msg = new Message();
                                msg.what = 2;
                                handler.sendMessage(msg);
                                flag = 0;
                            }
                        }
                    }
                }).start();
                break;
            }
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(video_view != null)
            video_view.suspend();
    }
}
