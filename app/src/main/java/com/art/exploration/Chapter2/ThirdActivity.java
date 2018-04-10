package com.art.exploration.Chapter2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.art.exploration.R;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        System.out.println("ThirdActivity sUserId : " + UserManager.sUserId);
    }
}
