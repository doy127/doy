package com.example.root.doy;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

/**
 * Created by root on 12/29/15.
 */
public class first_page extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_page, container, false);

        if(savedInstanceState != null)
        {
            EditText text = (EditText)view.findViewById(R.id.editText);
            text.setText(savedInstanceState.getString("web"));
        }

        Button button1 = (Button)view.findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "hi!", Toast.LENGTH_SHORT).show();
            }
        });

        Button button2 = (Button)view.findViewById(R.id.button_3);
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

        Button button3 = (Button)view.findViewById(R.id.button_4);
        final EditText text = (EditText)view.findViewById(R.id.editText);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                String temp = "http://";
                intent.setData(Uri.parse(temp.concat(text.getText().toString())));
                startActivity(intent);
            }
        });

        Button button4 = (Button)view.findViewById(R.id.button_5);
        final EditText text_2 = (EditText)view.findViewById(R.id.editText_2);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                String temp = "tel:";
                intent.setData(Uri.parse(temp.concat(text_2.getText().toString())));
                startActivity(intent);
            }
        });

        Button button5 = (Button)view.findViewById(R.id.button_6);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), activity_dialog.class);
                startActivity(intent);
            }
        });

        Button button6 = (Button)view.findViewById(R.id.button_7);
        final ProgressBar bar = (ProgressBar)view.findViewById(R.id.progressbar);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bar.getVisibility() == View.GONE)
                    bar.setVisibility(View.VISIBLE);
                else
                    bar.setVisibility(View.GONE);
            }
        });

        Button button7 = (Button)view.findViewById(R.id.button_8);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
                alert.setTitle("aaa");
                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alert.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alert.show();
            }
        });

        Button button8 = (Button)view.findViewById(R.id.button_9);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progress = new ProgressDialog(getActivity());
                progress.setCancelable(false);
                progress.show();
            }
        });

        return view;
    }
/*
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
    }*/
/*
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        EditText text = (EditText)findViewById(R.id.editText);
        outState.putString("web", text.getText().toString());
    }*/
}
