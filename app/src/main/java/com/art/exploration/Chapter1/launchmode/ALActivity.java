package com.art.exploration.Chapter1.launchmode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.art.exploration.R;

/**
 * Created by machangbao on 2018-4-1 15:48:10
 * 博客园：http://www.cnblogs.com/jooy/p/8687192.html
 * Android探究3：SingleTask启动模式探究:首先从MainActivity启动案例入口AActivity，并在A中启动BActivity，从B启动CActivity，
 * 再从C中又启动AActivity， 最后在A中启动B，现在按两次back键，然后回到的是哪个Activity？
 * 答案是，回到MainActivity。
 */
public class ALActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_al);
    }

    public void goToBLActivity(View view) {
        startActivity(new Intent(this, BLActivity.class));
    }
}
