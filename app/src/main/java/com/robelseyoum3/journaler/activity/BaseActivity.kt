package com.robelseyoum3.journaler.activity

import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import com.robelseyoum3.journaler.R
import kotlinx.android.synthetic.main.activity_main.*

abstract class BaseActivity : AppCompatActivity() {

    protected abstract val tag : String
    protected abstract fun getLayout(): Int
    protected abstract fun getActivityTitle(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        setSupportActionBar(toolbar)
        Log.v(tag, "[ ON CREATE]")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        Log.v(tag, "[ ON POST CREATE ]")
    }

    override fun onStart() {
        super.onStart()
        Log.v(tag, "[ ON onStart]")
    }

    override fun onRestart() {
        super.onRestart()
        Log.v(tag, "[ ON onRestart]")
    }

    override fun onResume() {
        super.onResume()
        Log.v(tag, "[ ON onResume]")
    }

    override fun onPostResume() {
        super.onPostResume()
        Log.v(tag, "[ ON onPostResume]")
    }

    override fun onPause() {
        super.onPause()
        Log.v(tag, "[ ON onPause]")
    }

    override fun onStop() {
        super.onStop()
        Log.v(tag, "[ ON onStop]")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(tag, "[ ON onDestroy]")
    }

}