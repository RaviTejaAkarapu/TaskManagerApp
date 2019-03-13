package com.example.taskmanager;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface MyDao
{
    @Insert
    public void addTask(Additem newtask);

    @Query("select * from tasks")
    public List<Additem> getTasks();

    @Delete
    public void deleteTask(Additem task);

    @Update
    public void updateTask(Additem task);


}
