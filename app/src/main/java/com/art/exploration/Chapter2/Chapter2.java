package com.art.exploration.Chapter2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.art.exploration.Chapter2.ipc.ShareFileWriteObjActivity;
import com.art.exploration.R;

public class Chapter2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter2);
        UserManager.sUserId = 8;
        System.out.println("Chapter2 sUserId : " + UserManager.sUserId);
    }

    public void goSecondActivity(View view) {
        startActivity(new Intent(this, SecondActivity.class));
    }

    public void goThirdActivity(View view) {
        startActivity(new Intent(this, ThirdActivity.class));
    }

    public void goShareFileActivity(View view) {
        startActivity(new Intent(this, ShareFileWriteObjActivity.class));
    }
}
