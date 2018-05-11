package com.example.anthonyeisenback.tasklistmanager.Room;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

public class DateConverter {
    @TypeConverter
    public static Date fromTimeStamp(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter public static  Long dateToTimestamp(Date date) {
        return date == null ? null :date.getTime();
    }
}
