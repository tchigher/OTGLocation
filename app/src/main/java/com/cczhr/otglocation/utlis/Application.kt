package com.cczhr.otglocation.utlis

import android.app.Application
import android.content.Context

class Application:Application() {

    override fun onCreate() {
        super.onCreate()
        context=this
    }
    companion object {
        lateinit var context: Application
        private val NAME: String = Application::class.java.simpleName
        private const val LON = "lon"
        private const val LAT = "lat"



        fun saveLat(value: String) {
            getSharedPreferences(context).edit().putString(LAT, value).apply()
        }

        fun getLat(): String {
            return getSharedPreferences(context).getString(LAT, "").toString()
        }

        fun saveLon(value: String) {
            getSharedPreferences(context).edit().putString(LON, value).apply()
        }

        fun getLon(): String {
            return getSharedPreferences(context).getString(LON, "").toString()
        }



        fun getSharedPreferences(context: Context, name: String) =
            context.getSharedPreferences(name, Context.MODE_PRIVATE)

        fun getSharedPreferences(context: Context) = getSharedPreferences(context, NAME)
    }
}