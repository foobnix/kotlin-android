package com.demo

import android.view.View
import android.widget.ListView
import android.widget.AdapterView.OnItemClickListener
import android.widget.Adapter
import android.widget.AdapterView

/**
 * Created by ivan on 1/15/14.
 */
fun View.click(click: () -> Any): View {
    this.setOnClickListener { click() }
    return this
}
fun View.longClick(longClick: () -> Boolean): View {
    this.setOnLongClickListener { longClick() }
    return this
}

fun ListView.itemClick(itemClick: (Int) -> Any): ListView {
    this.setOnItemClickListener (object:OnItemClickListener{
        override fun onItemClick(parent: AdapterView<out Adapter?>?, view: View?, position: Int, id: Long) {
            itemClick(position)
        }

    })
    return this
}



