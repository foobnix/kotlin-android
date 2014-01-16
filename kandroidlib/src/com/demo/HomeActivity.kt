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
import android.view.Gravity

class HomeActivity : Activity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super<Activity>.onCreate(savedInstanceState)
        val layout = linearLayout(Orientation.Vertical) {

            linearLayout(Orientation.Horizontal) {
                textView("Score:18").weight(1f); textView("Time: 99").weight(1f).gravity(Gravity.END)
            }

            button("Solve")

            linearLayout(Orientation.Horizontal) {
                button("7"); button("8"); button("9")
            }
            linearLayout(Orientation.Horizontal) {
                button("4"); button("5"); button("6")
            }
            linearLayout(Orientation.Horizontal) {
                button("1"); button("2"); button("3")
            }
            linearLayout(Orientation.Horizontal) {
                button("0"); button("."); button("C");
            }


        }

        setContentView(layout)


    }

    class uiFunc(var music: Music){

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