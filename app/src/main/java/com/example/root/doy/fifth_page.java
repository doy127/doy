package com.example.root.doy;

import android.app.Fragment;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 16-1-10.
 */
public class fifth_page extends Fragment{

    private List<String> string_list = new ArrayList<String>();

    private my_service.my_binder binder;
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            binder = (my_service.my_binder) service;
            binder.action();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fifth_page, container, false);

        init_string_list();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
               android.R.layout.simple_list_item_1, string_list);
        ListView listview = (ListView)view.findViewById(R.id.list_view_2);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String string = string_list.get(position);
                switch ((int)id)
                {
                    case 0:
                    {
                        Intent start = new Intent(getActivity(), my_service.class);
                        getActivity().startService(start);
                        break;
                    }
                    case 1:
                    {
                        Intent stop = new Intent(getActivity(), my_service.class);
                        getActivity().stopService(stop);
                        break;
                    }
                    case 2:
                    {
                        Intent bind = new Intent(getActivity(), my_service.class);
                        getActivity().bindService(bind, connection, Context.BIND_AUTO_CREATE);
                        break;
                    }
                    case 3:
                    {
                        getActivity().unbindService(connection);
                        break;
                    }
                    case 4:
                    {
                        Intent intent = new Intent(getActivity(), activity_web.class);
                        startActivity(intent);
                        break;
                    }
                    case 5:
                    {
                        Intent intent = new Intent(getActivity(), activity_location.class);
                        startActivity(intent);
                        break;
                    }
                    case 6:
                    {

                        break;
                    }
                    case 7:
                    {

                        break;
                    }
                    case 8:
                    {

                        break;
                    }
                    case 9:
                    {

                        break;
                    }
                    case 10:
                    {

                        break;
                    }

                }
            }
        });

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    private void init_string_list()
    {
        string_list.add("start service");
        string_list.add("stop service");
        string_list.add("bind service");
        string_list.add("unbind service");
        string_list.add("web view");
        string_list.add("get position");
        string_list.add("null");
        string_list.add("null");
        string_list.add("null");
        string_list.add("null");
        string_list.add("null");
    }
}
