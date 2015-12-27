package com.example.root.doy;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by root on 15-12-27.
 */
public class bottom_tag extends LinearLayout {

    public bottom_tag(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.change_page_tag, this);

        Button first_page = (Button) findViewById(R.id.button_first_page);
        first_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //setContentView(R.layout.main_layout);
                Log.d("aaa", "first");
            }

        });

        Button second_page = (Button) findViewById(R.id.button_second_page);
        second_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //setContentView(R.layout.second_page);
                Log.d("aaa", "second");
            }
        });
    }
}
