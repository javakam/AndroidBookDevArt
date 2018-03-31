package com.art.exploration.Chapter1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.art.exploration.R;

public class AActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
    }

    public void goToBActivity(View view) {
        startActivity(new Intent(this, BActivity.class));
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("AActivity.onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("AActivity.onStop");
    }
}
