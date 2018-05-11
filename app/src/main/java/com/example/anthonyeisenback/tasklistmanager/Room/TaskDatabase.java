package com.example.anthonyeisenback.tasklistmanager.Room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.example.anthonyeisenback.tasklistmanager.TaskCreator;


@Database(entities = TaskCreator.class, version = 2)
@TypeConverters(DateConverter.class)
public abstract class TaskDatabase extends RoomDatabase {

    public abstract TaskDAO taskDAO();


}
