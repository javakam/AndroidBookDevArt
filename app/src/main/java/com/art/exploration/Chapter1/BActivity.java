package com.art.exploration.Chapter1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.art.exploration.R;

public class BActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("BActivity.onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("BActivity.onResume");
    }
}
