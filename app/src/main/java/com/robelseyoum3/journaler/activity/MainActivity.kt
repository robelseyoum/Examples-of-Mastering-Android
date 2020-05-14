package com.robelseyoum3.journaler.activity


import com.robelseyoum3.journaler.R

class MainActivity : BaseActivity() {
    override val tag = "Main activity"
    override fun getLayout() = R.layout.activity_main
    override fun getActivityTitle() = R.string.app_name
}
