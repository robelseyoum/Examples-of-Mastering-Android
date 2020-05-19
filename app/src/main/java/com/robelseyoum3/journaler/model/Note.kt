package com.robelseyoum3.journaler.model

import android.location.Location

class Note(
    title: String,
    message: String,
    location: Location
) : Entry(title, message, location) {
    override var id: Long = 0L
}