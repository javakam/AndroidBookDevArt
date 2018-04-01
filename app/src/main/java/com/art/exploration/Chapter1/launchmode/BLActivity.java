package com.art.exploration.Chapter1.launchmode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.art.exploration.R;

public class BLActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bl);
    }

    public void goToCLActivity(View view) {
        startActivity(new Intent(this, CLActivity.class));
    }
}
