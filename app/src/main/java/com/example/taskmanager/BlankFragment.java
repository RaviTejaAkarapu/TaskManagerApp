package com.example.taskmanager;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {
    ListView lv;
    ArrayList<String> al;
    ArrayAdapter<String> aa;
    Button b,db;


    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_blank, container, false);
        lv= (ListView) v.findViewById(R.id.list1);
        al=new ArrayList<String>();
        aa=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_multiple_choice,al);
        lv.setAdapter(aa);



        List<Additem> tasks = HomeActivity.myAppDatabase.myDao().getTasks();

        String info="";

        for(Additem tsk : tasks)
        {
            int id=tsk.getId();
            String title=tsk.getTitle();
            String msg=tsk.getMsg();

            al.add(title);

        }

        b=(Button) v.findViewById(R.id.addbutton);
        db=(Button) v.findViewById(R.id.delbutton);


        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                String s=al.get(position);
                HomeActivity ha1= (HomeActivity) getActivity();
                ha1.f1(s);
                return false;
            }

        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener( ) {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                aa.notifyDataSetChanged();
            }


        });




        b.setOnClickListener(new AdapterView.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeActivity ha2 = (HomeActivity) getActivity( );
                ha2.f2( );
            }

        });
        db.setOnClickListener(new AdapterView.OnClickListener( ) {
            @Override
            public void onClick(View v) {


               // Additem task=new Additem();

                List<Additem> tasks=HomeActivity.myAppDatabase.myDao().getTasks();

                SparseBooleanArray positionchecker = lv.getCheckedItemPositions();
                int count =lv.getCount();
                for(int item=count-1;item>=0;item--)
                {

                    if(positionchecker.get(item))
                    {
                       aa.remove(al.get(item));
                    }

                }

                positionchecker.clear();
                aa.notifyDataSetChanged();


            }

        });
        return v;
    }

}
