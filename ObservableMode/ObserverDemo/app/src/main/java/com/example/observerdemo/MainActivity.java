package com.example.observerdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends Activity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.title);
        textView.setOnClickListener(v -> {
            Log.d(TAG, "onCreate: click ");
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}