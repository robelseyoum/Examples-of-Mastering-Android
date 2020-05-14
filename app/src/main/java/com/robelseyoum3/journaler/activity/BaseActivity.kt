package com.robelseyoum3.journaler.activity

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentActivity
import kotlinx.android.synthetic.main.activity_header.*

abstract class BaseActivity : FragmentActivity() {

    protected abstract val tag : String
    protected abstract fun getLayout(): Int
    protected abstract fun getActivityTitle(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        activity_title.text = getText(getActivityTitle())
        Log.v(tag, "[ ON CREATE]")
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