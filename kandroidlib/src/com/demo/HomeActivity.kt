/**
 * Created by ivan on 1/15/14.
 */

package com.demo;

import android.app.Activity
import android.os.Bundle
import android.widget.EditText
import android.view.Gravity

class HomeActivity : Activity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super<Activity>.onCreate(savedInstanceState)
        var input: EditText;

        val layout = linearLayout(VERTICAL) {

            horizontalLayout {
                textView("Score: 18")
                textView().layout(MATCH, WRAP, weight = 1f)
                textView("Time: 99")
            }.layout(MATCH, WRAP).padding(10.dp)

            textView("6 + 7")
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

            button("Solve").layout(380.dip, WRAP)

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
                button("C").click { input.setText("") }
            }

        }

        setContentView(layout);
    }

}

