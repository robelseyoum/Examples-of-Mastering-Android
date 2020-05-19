package com.robelseyoum3.journaler.model

import android.location.Location
import com.robelseyoum3.journaler.database.DbModel

abstract class Entry(var title: String, var messsage: String, var location: Location) : DbModel()
