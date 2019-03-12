package com.example.taskmanager;

import android.arch.persistence.room.Room;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class HomeActivity extends AppCompatActivity {
    public static Mydb myAppDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        FragmentManager manager=getSupportFragmentManager();
        myAppDatabase= Room.databaseBuilder(getApplicationContext(),Mydb.class,"taskdb" ).allowMainThreadQueries().build();

        if(findViewById(R.id.frame1)!=null)
        {
            if(savedInstanceState!=null)
            {
                return;
            }
        }

        FragmentTransaction t=manager.beginTransaction();
        BlankFragment m1=new BlankFragment();
        t.add(R.id.frame1,m1);
        t.commit();

    }
    public void f1(String s) {
        FragmentManager manager1=getSupportFragmentManager();
        FragmentTransaction t1=manager1.beginTransaction();
        subFragment m22=new subFragment();
        Bundle b2=new Bundle();
        b2.putString("s",s);
        m22.setArguments(b2);
        t1.replace(R.id.frame1,m22).addToBackStack(null);
        t1.commit();

    }

    public void f2() {
        FragmentManager manager2=getSupportFragmentManager();
        FragmentTransaction t2=manager2.beginTransaction();
        addtask m2=new addtask();
        t2.replace(R.id.frame1,m2).addToBackStack(null);
        t2.commit();
    }
}
