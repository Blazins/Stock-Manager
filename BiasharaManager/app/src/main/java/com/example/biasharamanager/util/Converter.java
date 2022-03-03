package com.example.biasharamanager.util;

import androidx.room.TypeConverter;

import com.example.biasharamanager.model.Priority;

import java.util.Date;

public class Converter {

    //Date to long
    @TypeConverter
    public static Date fromTimeStamp(Long value){
        return value == null ? null : new Date(value);
        /*
        if return value is null then return null
        else create a new date from this value we are receiving
        Saved as a timestamp(Long value)
         */
    }
    //Doing the inverse -date to TimeStamp
    @TypeConverter
    public static Long dateToTimeStamp(Date date){
        return date == null ? null : date.getTime();
        //if date = null,return null otherwise get date
    }
    @TypeConverter
    //convert priority to string
    public static String fromPriority(Priority priority){
        return priority == null ? null : priority.name();
        //from enum class you can return name of field in text form

    }
    @TypeConverter
    //convert priority to string
    public static Priority toPriority(String priority) {
        return priority == null ? null : Priority.valueOf(priority);
        //from enum class you can return name in text form

    }



}
