package com.example.taskmanager;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;


public class addtask extends Fragment {

    ArrayList<String> al2;
    ArrayAdapter<String> aa2;
    EditText et1,et2,et3;  //et=EditText
    Button at;  //at=AddTask


    public addtask() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fatask, container, false);
        // Inflate the layout for this fragment
        et1=v.findViewById(R.id.et1);
        et2=v.findViewById(R.id.et2);
        et3=v.findViewById(R.id.et3);
        at=v.findViewById(R.id.bnaddtask);

        at.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {

                int taskid=Integer.parseInt(et1.getText().toString());
                String tasktitle=et2.getText().toString();
                String taskmsg=et3.getText().toString();

                Additem newtask = new Additem();
                newtask.setId(taskid);
                newtask.setTitle(tasktitle);
                newtask.setMsg(taskmsg);

                HomeActivity.myAppDatabase.myDao().addTask(newtask);
                Toast.makeText(getActivity(),"task added successfully",Toast.LENGTH_SHORT).show();

                et1.setText("");
                et2.setText("");
                et3.setText("");

            }
        });
        return v;
    }

}