package com.sunsun.jsbridge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getSupportFragmentManager()
            .beginTransaction()
            .add(R.id.fragment_container, WebFragment())
            .commit();
    }
}