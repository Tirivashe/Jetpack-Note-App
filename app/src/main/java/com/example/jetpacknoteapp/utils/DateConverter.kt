package com.example.jetpacknoteapp.utils

import androidx.room.TypeConverter
import java.util.*

class DateConverter {
    @TypeConverter
    fun timeStampFromDate(date: Date): Long {
        return date.time
    }

    @TypeConverter
    fun dateFromTimeStamp(timeStamp: Long) : Date {
        return Date(timeStamp)
    }
}