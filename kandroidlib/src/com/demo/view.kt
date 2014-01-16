/**
 * Created by ivan on 1/15/14.
 */

package com.demo

import android.widget.Button
import android.widget.LinearLayout
import android.view.ViewGroup
import android.app.Activity
import android.widget.ListView
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast
import android.view.View
import android.content.Context


fun ViewGroup.button(text: String): Button {
    val button = Button(this.getContext()!!);
    button.setText(text)
    addView(button)
    return button;
}

fun ViewGroup.textView(text: String): TextView {
    val button = TextView(this.getContext()!!);
    button.setText(text)
    addView(button)
    return button;
}


fun ViewGroup.linearLayout(orientation: Orientation = Orientation.Vertical, init: LinearLayout.() -> Unit): LinearLayout {
    val layout = LinearLayout(this.getContext()!!);
    layout.setOrientation(orientation.value)
    layout.init()
    addView(layout)
    return layout;
}

fun Activity.linearLayout(orientation: Orientation = Orientation.Vertical, init: LinearLayout.() -> Unit): LinearLayout {
    val layout = LinearLayout(this);
    layout.setOrientation(orientation.value)
    layout.init()
    return layout;
}


fun ViewGroup.listView(adapter: BaseAdapter): ListView {
    val listView = ListView(this.getContext()!!)
    addView(listView)
    listView.setAdapter(adapter)
    return listView;
}



