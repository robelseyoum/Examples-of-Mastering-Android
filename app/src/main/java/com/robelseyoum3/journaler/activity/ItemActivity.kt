package com.robelseyoum3.journaler.activity

import android.app.Activity
import android.os.Bundle
import android.util.Log
import com.robelseyoum3.journaler.R
import com.robelseyoum3.journaler.model.MODE

abstract class ItemActivity : BaseActivity() {
    override val tag = "Item activity"
    override fun getLayout() = R.layout.activity_main
    override fun getActivityTitle() = R.string.app_name
    protected var mode = MODE.VIEW
    protected var success = Activity.RESULT_CANCELED


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val data = intent.extras
        data?.let {
            val modeTest = it.getInt(MODE.EXTRAS_KEY, MODE.VIEW.mode)
            mode = MODE.getByValue(modeTest)
        }
        Log.v(tag, "MODE [ $mode ")
    }

    override fun onDestroy() {
        super.onDestroy()
        setResult(success)
    }
}