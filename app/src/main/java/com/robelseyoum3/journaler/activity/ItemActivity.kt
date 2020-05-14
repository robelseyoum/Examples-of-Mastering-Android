package com.robelseyoum3.journaler.activity

import com.robelseyoum3.journaler.R

abstract class ItemActivity : BaseActivity() {
    override val tag = "Item activity"
    override fun getLayout() = R.layout.activity_main
    override fun getActivityTitle() = R.string.app_name
}