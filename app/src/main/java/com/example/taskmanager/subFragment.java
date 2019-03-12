package com.example.taskmanager;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class subFragment extends Fragment {
    private TextView TxtInfo;


    public subFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_sub, container, false);
        TxtInfo=v.findViewById(R.id.tex1);
        Bundle b=getArguments();
        String s=b.getString("s");


        List<Additem> tasks=HomeActivity.myAppDatabase.myDao().getTasks();

        String infor="";

        for(Additem tsk : tasks)
        {
            int id= tsk.getId();
            String title=tsk.getTitle();
            String msg=tsk.getMsg();

            if((s.equals(title)))
            {
                infor = "\n\n Task ID :" + id + "\n\n Task Title :" + title + "\n\n Message :" + msg;
            }
        }



        TxtInfo.setText(infor);

      /*  t= (TextView) v.findViewById(R.id.tex1);
        Bundle b=getArguments();
        if(b!=null){
            String s=b.getString("s");
            t.setText(s);
        }  */
        return v;

    }

}
