package com.art.exploration.Chapter1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.art.exploration.R;

/**
 * Created by machangbao on 2018-3-31 17:32:56
 * 博客园：http://www.cnblogs.com/jooy/p/8683167.html
 * Android读书笔记一：假设当前Activity为A,如果这时用户打开一个新的Activity B,那么B的onResume和A的onPause哪个先执行呢？
 */
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
