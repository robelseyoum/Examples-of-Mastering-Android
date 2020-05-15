package com.robelseyoum3.journaler.navigation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.LinearLayout
import com.robelseyoum3.journaler.R

class NavigationDrawerAdapter(val ctx: Context, val items: List<NavigationDrawerItem>) :
    BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = LayoutInflater.from(ctx)
        var view = convertView
        if (view == null) {
            view = inflater.inflate(R.layout.adapter_navigation_drawer, null) as LinearLayout
        }
        /**
        In this code example, we instantiated several NavigationDrawerItem instances, then, we assigned a title to the buttons and Runnable actions that we will execute.
        Each Runnable will jump to a specific page of our view pager. We passed all instances to the adapter as one single mutable list.
        You may have also noticed that we changed the line for the drawing_menu item. By clicking on it, we will expand our navigation drawer. Please follow these steps:
         */
        val item = items[position]
        val title = view.findViewById<Button>(R.id.drawer_item)
        title.text = item.title
        title.setOnClickListener { item.onClick.run() }

        return view
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return 0L
    }

    override fun getCount(): Int {
        return items.size
    }

}