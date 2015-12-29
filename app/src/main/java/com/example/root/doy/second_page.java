package com.example.root.doy;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by root on 12/29/15.
 */
public class second_page extends Fragment {

    private String[] data = {"aaa", "bbb", "ccc", "ddd", "eee", "fff", "ggg", "hhh", "jjj",
            "kkk", "lll", "mmm", "nnn", "ooo", "ppp", "qqq"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.second_page, container, false);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, data);
        ListView listview = (ListView)view.findViewById(R.id.list_view);
        listview.setAdapter(adapter);

        return view;
    }
}