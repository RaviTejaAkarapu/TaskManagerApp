package com.example.taskmanager;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class subFragment extends Fragment {
    private TextView TxtInfo;
    public ToggleButton tb;


    public subFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_sub, container, false);
        TxtInfo=v.findViewById(R.id.tex1);
        tb=v.findViewById(R.id.togglebutton);
        Bundle b=getArguments();
        final String s=b.getString("s");


        List<Additem> tasks=HomeActivity.myAppDatabase.myDao().getTasks();





                String infor="";
                String stat="";

                for(Additem tsk : tasks)
                {


                    int id= tsk.getId();
                    String title=tsk.getTitle();
                    String msg=tsk.getMsg();
                    boolean sts=tsk.isStatus();

                    tb.setChecked(!sts);

                    if(sts==false) {
                        stat=""+msg+"\n\n Status : Pending";
                    } else {
                        stat=""+msg+"\n\n Status : Complete";
                    }


                    if((s.equals(title)))
                    {
                        infor = "\n\n Task ID :" + id + "\n\n Task Title :" + title + "\n\n Message :" + stat;
                    }
                }
                TxtInfo.setText(infor);









        tb.setOnClickListener(new AdapterView.OnClickListener( ) {
            @Override
            public void onClick(View v) {

             List<Additem> tasks=HomeActivity.myAppDatabase.myDao().getTasks();


                        for(Additem tsk : tasks)
                        {
                            //  int id= tsk.getId();
                            String title=tsk.getTitle();
                            // String msg=tsk.getMsg();
                            boolean sts=tsk.isStatus();

                            if((s.equals(title)))
                            {
                                tsk.setStatus(!sts);

                                HomeActivity.myAppDatabase.myDao().updateTask(tsk);
                                HomeActivity ha1= (HomeActivity) getActivity();
                                ha1.f1(s);
                            }
                        }






            }
        });

      /*  t= (TextView) v.findViewById(R.id.tex1);
        Bundle b=getArguments();
        if(b!=null){
            String s=b.getString("s");
            t.setText(s);
        }  */
        return v;

    }

  /*  @Override
    public void onBackPressed() {

        HomeActivity ha1= (HomeActivity) getActivity();
        ha1.f3();
    }
    */

}
