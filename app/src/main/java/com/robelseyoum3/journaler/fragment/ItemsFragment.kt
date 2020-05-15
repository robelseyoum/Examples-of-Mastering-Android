package com.robelseyoum3.journaler.fragment

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.robelseyoum3.journaler.R
import com.robelseyoum3.journaler.activity.NoteActivity
import com.robelseyoum3.journaler.activity.TodoActivity
import com.robelseyoum3.journaler.model.MODE

class ItemsFragment : BaseFragment() {
    override val logTag: String = "Items Fragment"
    override fun getLayout(): Int = R.layout.fragment_items

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(getLayout(), container, false)
        val btn = view.findViewById<FloatingActionButton>(R.id.new_item)
        btn?.setOnClickListener {
            val items = arrayOf(
                getString(R.string.todos),
                getString(R.string.notes)
            )

            val builder =
                AlertDialog.Builder(this@ItemsFragment.context)
                    .setTitle(R.string.choose_a_type)
                    .setItems(
                        items
                    ) { _, which ->
                        when (which) {
                            0 -> openCreateNote()
                            1 -> openCreateTodo()
                            else -> Log.e(logTag, "Unknown Option Selected [ $which ]")
                        }
                    }
            builder.show()
        }
        return view
    }


    private fun openCreateNote() {
        val intent = Intent(context, NoteActivity::class.java)
        intent.putExtra(MODE.EXTRAS_KEY, MODE.CREATE.mode)
        startActivity(intent)
    }

    private fun openCreateTodo() {
        val intent = Intent(context, TodoActivity::class.java)
        intent.putExtra(MODE.EXTRAS_KEY, MODE.CREATE.mode)
        startActivity(intent)
    }

}