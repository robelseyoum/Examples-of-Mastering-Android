package com.robelseyoum3.journaler.activity

import com.robelseyoum3.journaler.R

class TodoActivity : ItemActivity() {
    override val tag = "Todo activity"
    override fun getLayout() = R.layout.activity_todo
    override fun getActivityTitle() = R.string.app_name
}