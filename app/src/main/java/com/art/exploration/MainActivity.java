package com.art.exploration;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.art.exploration.Chapter1.AActivity;

/**
 * GitHub  http://www.cnblogs.com/jooy/p/8683167.html
 * 博客园   http://www.cnblogs.com/jooy/
 * 个人博客 https://www.jooy.top/
 *
 * Created by machangbao on 2018-3-31 17:32:56
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    /**
     * 博客园：http://www.cnblogs.com/jooy/p/8683167.html
     * Android读书笔记一：假设当前Activity为A,如果这时用户打开一个新的Activity B,那么B的onResume和A的onPause哪个先执行呢？
     *
     * @param view
     */
    public void test1(View view) {
        startActivity(new Intent(this, AActivity.class));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
