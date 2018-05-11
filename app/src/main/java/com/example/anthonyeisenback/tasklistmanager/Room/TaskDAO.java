package com.example.anthonyeisenback.tasklistmanager.Room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.anthonyeisenback.tasklistmanager.TaskCreator;

import java.util.List;


@Dao
public interface TaskDAO {

    @Query("SELECT * FROM taskcreator")
    List<TaskCreator> getTasks();

    @Insert
    void addTask(TaskCreator taskCreator);

    @Update
    void updateTask(TaskCreator taskCreator);

    @Delete
    void deleteTask(TaskCreator taskCreator);

}
