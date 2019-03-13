/*package com.example.taskmanager;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

public class TaskViewModel extends ViewModel {

    public LiveData<List<Additem>> getTaskList(){
        LiveData<List<Additem>> tasks = HomeActivity.myAppDatabase.myDao().getTasks( );
        return tasks;
    }

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    private String title;

    private String msg;

    private boolean status;
}
*/