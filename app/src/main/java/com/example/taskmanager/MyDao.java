package com.example.taskmanager;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

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



}
