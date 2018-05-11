package com.example.anthonyeisenback.tasklistmanager;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.example.anthonyeisenback.tasklistmanager.Room.TaskDatabase;

public class DatabaseApplication extends Application {
    private TaskDatabase database;

    public static String DATABASE_NAME = "task_database";

    @Override
    public void onCreate() {
        super.onCreate();

        database = Room.databaseBuilder(getApplicationContext(),
                TaskDatabase.class, DATABASE_NAME).
                allowMainThreadQueries().build();
    }

    public TaskDatabase getDatabase() {
        return database;
    }
}
