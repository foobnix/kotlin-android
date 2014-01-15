package com.demo

import android.widget.BaseAdapter
import android.view.View
import android.view.ViewGroup

/**
 * Created by ivan on 1/15/14.
 */

class CommonAdapter<T>(val items: List<T>, val itemView: (T) -> View) : BaseAdapter(){
    override fun getCount(): Int {
        return items.size;
    }
    override fun getItem(position: Int): Any? {
        return 0;
    }
    override fun getItemId(position: Int): Long {
        return 0L;
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        return itemView(items.get(position));

    }

}