package com.robelseyoum3.journaler.activity

import android.location.Location
import android.location.LocationListener
import android.os.AsyncTask
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import com.robelseyoum3.journaler.R
import com.robelseyoum3.journaler.database.Db
import com.robelseyoum3.journaler.location.LocationProvider
import com.robelseyoum3.journaler.model.Note
import kotlinx.android.synthetic.main.activity_note.*

class NoteActivity : ItemActivity() {
    override val tag = "Note activity"
    override fun getLayout() = R.layout.activity_note
    override fun getActivityTitle() = R.string.app_name
    private var note: Note? = null
    private var location: Location? = null

    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            updateNote()
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
    }

    private val locationListener = object : LocationListener {

        override fun onLocationChanged(p0: Location?) {
            p0?.let {
                LocationProvider.unSubscribe(this)
                location = p0
                val title = note_title.toString()
                val content = note_content.toString()
                note = Note(title, content, p0)

                val task = object : AsyncTask<Note, Void, Boolean>() {

                    override fun doInBackground(vararg params: Note?): Boolean {
                        if (params.isNotEmpty()) {
                            val param = params[0]
                            param?.let { return Db.NOTE.insert(param) > 0 }
                        }
                        return false
                    }

                    override fun onPostExecute(result: Boolean?) {
                        result?.let {
                            if (result) {
                                Log.i(tag, "Note inserted.")
                            } else {
                                Log.e(tag, "Note not inserted.")
                            }
                        }
                    }
                }
                task.execute(note)
            }
        }

        override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {}

        override fun onProviderEnabled(provider: String?) {}

        override fun onProviderDisabled(provider: String?) {}
    }

    private fun updateNote() {
        if (note == null) {
            if (TextUtils.isEmpty(note_title.toString()) &&
                !TextUtils.isEmpty(note_title.toString())
            ) {
                LocationProvider.subscribe(locationListener)
            }
        } else {
            note?.title = note_title.toString()
            note?.messsage = note_content.toString()

            val task = object : AsyncTask<Note, Void, Boolean>() {
                override fun doInBackground(vararg params: Note?):
                        Boolean {
                    if (!params.isEmpty()) {
                        val param = params[0]
                        param?.let {
                            return Db.NOTE.update(param) > 0
                        }
                    }
                    return false
                }

                override fun onPostExecute(result: Boolean?) {
                    result?.let {
                        if (result) {
                            Log.i(tag, "Note updated.")
                        } else {
                            Log.e(tag, "Note not updated.")
                        }
                    }
                }
            }
            task.execute(note)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        note_title.addTextChangedListener(textWatcher)
        note_content.addTextChangedListener(textWatcher)
        Log.v(tag, "Robel NoteActivity ")
    }

}