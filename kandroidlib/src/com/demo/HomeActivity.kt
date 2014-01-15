/**
 * Created by ivan on 1/15/14.
 */

package com.demo;

import android.app.Activity
import android.os.Bundle
import android.widget.BaseAdapter
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.content.Context
import android.graphics.Color

class HomeActivity : Activity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super<Activity>.onCreate(savedInstanceState)
        val listOf = arrayListOf(Music("sdf", "sdf"))

        var adapter = CommonAdapter(listOf, { item ->
            var text = TextView(this)
            text.setText("Go to ${item.path}")
            text
        })


        val layout = linearLayout(Orientation.Vertical) {
            linearLayout(Orientation.Horizontal) {
                button("1").weight(1f).margin(top = 10.dp)
                button("2").weight(1f).padding(5.dp).bgColor(Color.RED).margin(0.dp)
                button("3").weight(1f)
            }.bgColor(Color.DKGRAY).weight(0f)



            listView (adapter)
                    .itemClick { pos ->
                toast("item clicked $pos")
                setTitle("hello $pos")
            }
                    .weight(1f)


            button("BIG").weight(0f).size(Size.MatchParent, Size.MatchParent, 0f)

        }

        setContentView(layout)


    }

    class uiFunc(var music:Music){

    }
    class MyAdapter(val context: Context) : BaseAdapter(){
        override fun getCount(): Int {
            return 10;
        }
        override fun getItem(position: Int): Any? {
            return 0;
        }
        override fun getItemId(position: Int): Long {
            return 0L;
        }
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
            val text = TextView(context)
            text.setText("item $position");
            return text

        }

    }

    class Music(val path: String, val text: String) {
        {
            val path = path;
            val text = text;
        }
    }

}