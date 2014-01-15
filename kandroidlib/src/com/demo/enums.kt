package com.demo

import android.view.ViewGroup
import android.widget.LinearLayout

/**
 * Created by ivan on 1/15/14.
 */
var bug = array(ViewGroup.LayoutParams.WRAP_CONTENT, LinearLayout.HORIZONTAL)



enum class Size(val value: Int){
    WrapContent: Size(ViewGroup.LayoutParams.WRAP_CONTENT)
    MatchParent: Size(ViewGroup.LayoutParams.MATCH_PARENT)
}
enum class Orientation(val value: Int){
    Horizontal: Orientation(LinearLayout.HORIZONTAL)
    Vertical: Orientation(LinearLayout.VERTICAL)
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