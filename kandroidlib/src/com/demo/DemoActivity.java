package com.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by ivan on 1/15/14.
 */
public class DemoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        finish();
        startActivity(new Intent(this,HomeActivity.class));
    }
}
