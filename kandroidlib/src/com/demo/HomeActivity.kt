/**
 * Created by ivan on 1/15/14.
 */

package com.demo;

import android.app.Activity
import android.os.Bundle
import android.widget.EditText
import java.util.Random
import android.widget.TextView

class HomeActivity : Activity(){
    var score: Int = 0;
    var time: Int = 60;
    var taskView: TextView? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super<Activity>.onCreate(savedInstanceState)
        var input: EditText;

        val layout = linearLayout(VERTICAL) {

            horizontalLayout {
                textView("Score: $score")
                textView().layout(MATCH, WRAP, weight = 1f)
                textView("Time: $time")
            }.layout(MATCH, WRAP).padding(10.dp)

            taskView = textView()

            horizontalLayout {
                input = editText().layout(300.dp, WRAP) as EditText
                input.setCursorVisible(false)
                button("<-").layout(80.dp).click {
                    var str = input.getText().toString()
                    if (!str.isEmpty()) {
                        input.setText(str.substring(0, str.length - 1))
                    }
                }
            }

            button("Solve").layout(380.dip, WRAP).click {
                val value = input.getText().toString()
                if (value.isNotEmpty()) {
                    input.setText("")
                    input.setHint("")
                    if (value.toInt() == task.result()) {
                        //toast("Good!")
                        nextTask()
                    } else {
                        input.setHint("mistake")
                    }
                }
            }

            linearLayout(HORIZONTAL) {
                button("7").click { input.append("7") };
                button("8").click { input.append("8") };
                button("9").click { input.append("9") };
            }

            linearLayout(HORIZONTAL) {
                button("4").click { input.append("4") };
                button("5").click { input.append("5") };
                button("6").click { input.append("6") };
            }
            linearLayout(HORIZONTAL) {
                button("1").click { input.append("1") };
                button("2").click { input.append("2") };
                button("3").click { input.append("3") };
            }
            linearLayout(HORIZONTAL) {
                button("0").click { input.append("0") };
                button(".").click {
                    val value = input.getText().toString()
                    if (!value.contains(".") && value.length > 0) {
                        input.append(".")
                    }
                };
                button("-").click {
                    val value = input.getText().toString()
                    if (value.length == 0) {
                        input.append("-")
                    }
                }
            }

        }

        setContentView(layout);

        nextTask()
    }
    var task: Task = generateTask()

    fun generateTask(min: Int = 10, max: Int = 20): Task {
        return Task(rnd(min, max), rnd(min, max), signs.get(Random().nextInt(3)))
    }
    fun rnd(min: Int = 1, max: Int = 100): Int = Random().nextInt(max - min) + min

    fun nextTask() {
        task = generateTask()
        displayTask(taskView!!, task)
    }

    fun displayTask(textView: TextView, task: Task) {
        textView.setText("${task.a} ${task.sign.str} ${task.b}")

    }
}
open class Sign(val str: String, val func: (a: Int, b: Int) -> Int)
class plus : Sign("+", { x, y -> x + y })
class minus : Sign("-", { x, y -> x - y })
class mult : Sign("*", { x, y -> x * y })
class div : Sign("/", { x, y -> x / y })

val signs = listOf(plus(), div(), minus(), mult())

class Task(a: Int, b: Int, sign: Sign){
    var a = a;
    var b = b;
    var sign = sign;
    fun result(): Int {
        return sign.func(a, b);
    }
}




