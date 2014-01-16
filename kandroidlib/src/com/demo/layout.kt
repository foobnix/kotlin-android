package com.demo

import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.view.Gravity

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

fun View.size(width: Size = Size.WrapContent, height: Size = Size.WrapContent, weight: Float = -1f): View {
    val lp = getLayoutParams() as LinearLayout.LayoutParams
    var actualWeight = 0f;

    if (weight != -1f) {
        actualWeight = weight
    } else if (lp != null) {
        actualWeight = lp.weight
    }
    val layoutParams = LinearLayout.LayoutParams(lp?.width ?: width.value, lp?.height ?: height.value, actualWeight);
    this.setLayoutParams(layoutParams)
    return this;
}

fun View.weight(weight: Float): View {
    val lp = getLayoutParams()
    val layoutParams = LinearLayout.LayoutParams(lp?.width ?: Size.WrapContent.value, lp?.height ?: Size.WrapContent.value, weight)
    this.setLayoutParams(layoutParams)
    return this;
}
fun View.bgColor(color: Int): View {
    setBackgroundColor(color)
    return this;
}
fun View.align(align:Align=Align.Start):View{
    setTextAlignment(align.value)
    return this
}
fun View.gravity(gravity:Int = Gravity.LEFT):View{
    if(this is TextView){
        setGravity(gravity)
    }
    return this
}