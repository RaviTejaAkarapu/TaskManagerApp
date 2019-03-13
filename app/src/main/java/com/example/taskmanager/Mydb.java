package com.example.taskmanager;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Additem.class},version = 1,exportSchema = false)
public abstract class Mydb extends RoomDatabase
{
    public abstract MyDao myDao();
}
