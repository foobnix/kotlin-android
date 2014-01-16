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
import android.widget.EditText
import android.view.View


fun ViewGroup.button(text: String, click: () -> Any = { }): Button {
    val button = Button(this.getContext()!!);
    button.setText(text)
    button.setOnClickListener({ click() })
    addView(button)
    return button;
}
fun ViewGroup.editText(text: String = ""): EditText {
    val editText = EditText(this.getContext()!!);
    editText.setText(text)
    addView(editText)
    return editText;
}
fun EditText.hint(hint: String): EditText {
    this.setHint(hint)
    return this;
}

fun EditText.append(value: String) {
    this.setText(this.getText().toString() + value)
}

fun ViewGroup.textView(text: String=""): TextView {
    val button = TextView(this.getContext()!!);
    button.setText(text)
    addView(button)
    return button;
}
fun ViewGroup.view(): View {
    return View(this.getContext()!!);
}

fun ViewGroup.linearLayout(orientation: Int = Orientation.Vertical.value, init: LinearLayout.() -> Unit): LinearLayout {
    val layout = LinearLayout(this.getContext()!!);
    layout.setOrientation(orientation)
    layout.init()
    addView(layout)
    return layout;
}
fun ViewGroup.verticalLayout(init: LinearLayout.() -> Unit): LinearLayout {
    return this.linearLayout(VERTICAL, init);
}
fun ViewGroup.horizontalLayout(init: LinearLayout.() -> Unit): LinearLayout {
    return this.linearLayout(HORIZONTAL, init);
}


fun Activity.linearLayout(orientation: Int = Orientation.Vertical.value, init: LinearLayout.() -> Unit = { }): LinearLayout {
    val layout = LinearLayout(this);
    layout.setOrientation(orientation)
    layout.init()
    return layout;
}


fun ViewGroup.listView(adapter: BaseAdapter): ListView {
    val listView = ListView(this.getContext()!!)
    addView(listView)
    listView.setAdapter(adapter)
    return listView;
}



