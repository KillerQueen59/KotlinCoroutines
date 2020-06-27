package com.example.kotlincoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Global Scope
        GlobalScope.launch{
            delay(2000L)//delay harus dalem coroutine karena harus di dalam fungsi suspend
            Log.d("ojan","Hi Im from ${Thread.currentThread().name}")// dalem coroutine
        }
        Log.d("ojan","Hi Im from ${Thread.currentThread().name}")//main thread

        //suspend function
        GlobalScope.launch {
            delay(3000L)
            val test1 = test1()
            Log.d("ojan",test1)
            val test2 = test2()
            Log.d("ojan",test2)
        }

    }
    //suspend function
    suspend fun test1():String{
        delay(8000L)
        return "Say Hello1"

    }
    //suspend function
    suspend fun test2():String{
        delay(10000L)
        return "Say Hello2"

    }
}
