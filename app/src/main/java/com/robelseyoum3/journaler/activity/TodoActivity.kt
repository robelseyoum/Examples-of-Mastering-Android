package com.robelseyoum3.journaler.activity

import android.os.Bundle
import com.robelseyoum3.journaler.R
import kotlinx.android.synthetic.main.activity_todo.*

class TodoActivity : ItemActivity() {
    override val tag = "Todo activity"
    override fun getLayout() = R.layout.activity_todo
    override fun getActivityTitle() = R.string.app_name

    companion object {
        val EXTRA_DATE = "EXTRA_DATE"
        val EXTRA_TIME = "EXTRA_TIME"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val data = intent.extras
        data?.let {
            val date = it.getString(EXTRA_DATE, "")
            val time = it.getString(EXTRA_TIME, "")
            pick_date.text = date
            pick_tme.text = time
        }
    }
}