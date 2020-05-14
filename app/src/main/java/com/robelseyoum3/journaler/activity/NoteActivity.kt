package com.robelseyoum3.journaler.activity

import com.robelseyoum3.journaler.R

class NoteActivity : ItemActivity() {
    override val tag = "Note activity"
    override fun getLayout() = R.layout.activity_note
    override fun getActivityTitle() = R.string.app_name
}