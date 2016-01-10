package com.example.root.doy;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by root on 12/23/15.
 */
public class main_activity extends Activity implements View.OnClickListener {

    String TAG = "main_activity";
    first_page fm_first;
    second_page fm_second;
    third_page fm_third;
    fourth_page fm_fourth;
    fifth_page fm_fifth;

    private IntentFilter intentFilter;
    private NetworkBroadcastReceiver networkBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        Log.d(TAG, getClass().getSimpleName());
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main_layout);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        fm_first = new first_page();
        transaction.replace(R.id.content_fragment, fm_first);
        transaction.commit();

        //sixth seventh eighth ninth tenth
        Button button_first_page = (Button) findViewById(R.id.button_first_page);
        Button button_second_page = (Button) findViewById(R.id.button_second_page);
        Button button_third_page = (Button) findViewById(R.id.button_third_page);
        Button button_fourth_page = (Button) findViewById(R.id.button_fourth_page);
        Button button_fifth_page = (Button) findViewById(R.id.button_fifth_page);
        button_first_page.setOnClickListener(this);
        button_second_page.setOnClickListener(this);
        button_third_page.setOnClickListener(this);
        button_fourth_page.setOnClickListener(this);
        button_fifth_page.setOnClickListener(this);

        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkBroadcastReceiver = new NetworkBroadcastReceiver();
        registerReceiver(networkBroadcastReceiver, intentFilter);

    }

    public void onClick(View v) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();

        switch (v.getId()) {
            case R.id.button_first_page: {
                if (fm_first == null)
                    fm_first = new first_page();
                transaction.replace(R.id.content_fragment, fm_first);
                break;
            }
            case R.id.button_second_page: {
                if (fm_second == null)
                    fm_second = new second_page();
                transaction.replace(R.id.content_fragment, fm_second);
                break;
            }
            case R.id.button_third_page: {
                if (fm_third == null)
                    fm_third = new third_page();
                transaction.replace(R.id.content_fragment, fm_third);
                break;
            }
            case R.id.button_fourth_page: {
                if (fm_fourth == null)
                    fm_fourth = new fourth_page();
                transaction.replace(R.id.content_fragment, fm_fourth);
                break;
            }
            case R.id.button_fifth_page: {
                if (fm_fifth == null)
                    fm_fifth = new fifth_page();
                transaction.replace(R.id.content_fragment, fm_fifth);
                break;
            }
        }

        transaction.commit();
    }

    class NetworkBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
/*            if(networkInfo != null && networkInfo.isAvailable())
                Toast.makeText(context, "network connected", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(context, "network disconnected", Toast.LENGTH_SHORT).show();*/
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(main_activity.this, "select a", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(main_activity.this, "select b", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
        unregisterReceiver(networkBroadcastReceiver);
    }

}
