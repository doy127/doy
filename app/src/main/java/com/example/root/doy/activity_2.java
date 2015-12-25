package com.example.root.doy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by root on 12/24/15.
 */
public class activity_2 extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.layout_2);

        Intent intent = getIntent();
        String data = intent.getStringExtra("from main activity");
        Toast.makeText(activity_2.this, data, Toast.LENGTH_SHORT).show();

        Button button = (Button)findViewById(R.id.button_2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("from activity 2", "return main activity");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }

}
