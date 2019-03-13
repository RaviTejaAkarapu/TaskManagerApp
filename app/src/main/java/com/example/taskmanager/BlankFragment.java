package com.example.taskmanager;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
    ListView listview;
    ArrayList<String> arraylist;
    ArrayAdapter<String> arrayadapter;
    Button button1,delbutton;


    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v=inflater.inflate(R.layout.fragment_blank, container, false);
        listview= (ListView) v.findViewById(R.id.list1);
        arraylist=new ArrayList<String>();
        arrayadapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_multiple_choice,arraylist);
        listview.setAdapter(arrayadapter);

       // final TaskViewModel model= ViewModelProviders.of(this).get(TaskViewModel.class);

        List<Additem> tasks = HomeActivity.myAppDatabase.myDao().getTasks();

        String info="";
       List<Additem> tasks1 = HomeActivity.myAppDatabase.myDao().getTasks();
                for(Additem tsk : tasks1)
                {
                    int id=tsk.getId();
                    String title=tsk.getTitle();
                    String msg=tsk.getMsg();
                    boolean sts=tsk.isStatus();

                    arraylist.add(title);

                }


       /* for(Additem tsk : tasks)
        {
            int id=tsk.getId();
            String title=tsk.getTitle();
            String msg=tsk.getMsg();
            boolean sts=tsk.isStatus();



            al.add(title);

        }*/

        button1=(Button) v.findViewById(R.id.addbutton);
        delbutton=(Button) v.findViewById(R.id.delbutton);


        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                String s=arraylist.get(position);
                HomeActivity ha1= (HomeActivity) getActivity();
                ha1.f1(s);
                return false;
            }

        });
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener( ) {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                arrayadapter.notifyDataSetChanged();
            }


        });




        button1.setOnClickListener(new AdapterView.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeActivity ha2 = (HomeActivity) getActivity( );
                ha2.f2( );
            }

        });
        delbutton.setOnClickListener(new AdapterView.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                List<Additem> tasks2 = HomeActivity.myAppDatabase.myDao().getTasks();
                                SparseBooleanArray positionchecker = listview.getCheckedItemPositions();
                                int count =listview.getCount();
                                for(int item=count-1;item>=0;item--)
                                {

                                    for(Additem tsk : tasks2)
                                    {
                                        String title=tsk.getTitle();
                                        if(positionchecker.get(item))
                                        {
                                            if(title.equals(arraylist.get(item)))
                                            {
                                                HomeActivity.myAppDatabase.myDao().deleteTask(tsk);
                                                arrayadapter.remove(arraylist.get(item));
                                            }
                                        }
                                    }
                                    positionchecker.clear();
                                    arrayadapter.notifyDataSetChanged();
                                }



                      //  LiveData < List < Additem >> tasks = HomeActivity.myAppDatabase.myDao( ).getTasks( );


        }
    });
    return v;
    }

}
