package com.demo

import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.view.Gravity
import android.widget.FrameLayout

/**
 * Created by ivan on 1/15/14.
 */
fun View.padding(all: Int = 0, left: Int = 0, top: Int = 0, right: Int = 0, bottom: Int = 0): View {
    if (all > 0) {
        this.setPadding(all, all, all, all)
    } else {
        this.setPadding(left, top, right, bottom)
    }
    return this;
}

fun View.margin(all: Int = 0, left: Int = 0, top: Int = 0, right: Int = 0, bottom: Int = 0): View {
    val layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    if (all > 0) {
        layoutParams.setMargins(all, all, all, all);
    } else {
        layoutParams.setMargins(left, top, right, bottom);
    }
    this.setLayoutParams(layoutParams)
    return this;
}

fun View.layout(width: Int = WRAP_CONTENT, height: Int = WRAP_CONTENT, layoutGravity: Int = Gravity.LEFT, weight: Float = 0f): View {
    if (this.getParent() is FrameLayout) {
        var res = FrameLayout.LayoutParams(width, height)
        res.gravity = layoutGravity
        this.setLayoutParams(res)
        return this
    } else {
        var res = LinearLayout.LayoutParams(width, height)
        res.gravity = layoutGravity
        res.weight = weight
        this.setLayoutParams(res)
        return this
    }
}

fun ViewGroup.frame(init: FrameLayout.() -> Unit): View {
    val layout = FrameLayout(getContext()!!)
    layout.init()
    addView(layout)
    return layout
}


fun View.bgColor(color: Int): View {
    setBackgroundColor(color)
    return this;
}
fun View.align(align: Align = Align.Start): View {
    setTextAlignment(align.value)
    return this
}
fun View.textGravity(gravity: Int = Gravity.LEFT): View {
    if (this is TextView) {
        setGravity(gravity)
    }
    return this
}