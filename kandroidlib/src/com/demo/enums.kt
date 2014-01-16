package com.demo

import android.view.ViewGroup
import android.widget.LinearLayout
import android.view.View
import android.widget.TextView

/**
 * Created by ivan on 1/15/14.
 */
var bug = array(
        ViewGroup.LayoutParams.WRAP_CONTENT,
        LinearLayout.HORIZONTAL,
        View.TEXT_ALIGNMENT_TEXT_START
        )


enum class Size(val value: Int){
    WrapContent: Size(ViewGroup.LayoutParams.WRAP_CONTENT)
    MatchParent: Size(ViewGroup.LayoutParams.MATCH_PARENT)
}
enum class Orientation(val value: Int){
    Horizontal: Orientation(LinearLayout.HORIZONTAL)
    Vertical: Orientation(LinearLayout.VERTICAL)
}
enum class Align(val value:Int){
    Start: Align(View.TEXT_ALIGNMENT_TEXT_START)
    End: Align(View.TEXT_ALIGNMENT_TEXT_END)
}

val Int.px: Int
    get(){
        return this
    }

val Int.dp: Int
    get(){
        return pxToDip(this);
    }
val Int.dip: Int
    get(){
        return pxToDip(this)
    }