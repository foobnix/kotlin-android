/**
 * Created by ivan on 1/15/14.
 */

package com.demo

import android.content.res.Resources

fun dipToPx(dp: Int): Int {
    return dp * Resources.getSystem().getDisplayMetrics().density.toInt()
}

fun pxToDip(px: Int): Int {
    return px / Resources.getSystem().getDisplayMetrics().density.toInt()
}
fun String.empty():Boolean {
    return this.trim().length == 0;
}