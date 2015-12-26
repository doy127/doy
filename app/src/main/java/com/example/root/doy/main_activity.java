package com.example.root.doy;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by root on 12/23/15.
 */
public class main_activity extends Activity{

    String TAG = "main_activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        Log.d(TAG, getClass().getSimpleName());
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main_layout);

        if(savedInstanceState != null)
        {
            EditText text = (EditText)findViewById(R.id.editText);
            text.setText(savedInstanceState.getString("web"));
        }

        Button button1 = (Button)findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(main_activity.this, "hi!", Toast.LENGTH_SHORT).show();
            }
        });

        Button button2 = (Button)findViewById(R.id.button_3);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
//                Intent intent = new Intent(main_activity.this, activity_2.class);
//                startActivity(intent);

                Intent intent = new Intent("android.intent.action.MYACTION");
                String data = "start activity 2";
                intent.putExtra("from main activity", data);
                startActivityForResult(intent, 1);

            }
        });

        Button button3 = (Button)findViewById(R.id.button_4);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                String temp = new String("http://");
                EditText text = (EditText)findViewById(R.id.editText);
                intent.setData(Uri.parse(temp.concat(text.getText().toString())));
                startActivity(intent);
            }
        });

        Button button4 = (Button)findViewById(R.id.button_5);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                String temp = new String("tel:");
                EditText text = (EditText)findViewById(R.id.editText_2);
                intent.setData(Uri.parse(temp.concat(text.getText().toString())));
                startActivity(intent);
            }
        });

        Button button5 = (Button)findViewById(R.id.button_6);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(main_activity.this, activity_dialog.class);
                startActivity(intent);
            }
        });
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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch(requestCode)
        {
            case 1:
                if(resultCode == RESULT_OK)
                {
                    Toast.makeText(main_activity.this, data.getStringExtra("from activity 2"), Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        EditText text = (EditText)findViewById(R.id.editText);
        outState.putString("web", text.getText().toString());
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
    }
}
