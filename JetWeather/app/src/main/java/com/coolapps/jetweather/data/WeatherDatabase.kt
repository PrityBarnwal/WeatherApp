package com.coolapps.jetweather.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.coolapps.jetweather.model.Favorite
import com.coolapps.jetweather.model.Unit

@Database(entities = [Favorite::class, Unit::class], version = 2, exportSchema = false)
abstract class WeatherDatabase: RoomDatabase() {
    abstract fun weatherDao(): WeatherDao
}
