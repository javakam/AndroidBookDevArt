package com.art.exploration;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.art.exploration.Chapter1.AActivity;
import com.art.exploration.Chapter1.ScrollingActivity;
import com.art.exploration.Chapter1.intentfilter.SelectFilterActivity;
import com.art.exploration.Chapter1.launchmode.ALActivity;

/**
 * GitHub  http://www.cnblogs.com/jooy/p/8683167.html
 * 博客园   http://www.cnblogs.com/jooy/
 * 个人博客 https://www.jooy.top/
 * <p>
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
     * Android探究1：假设当前Activity为A,如果这时用户打开一个新的Activity B,那么B的onResume和A的onPause哪个先执行呢？
     * <p>
     * 博客园：http://www.cnblogs.com/jooy/p/8683167.html
     *
     * @param view
     */
    public void test1(View view) {
        startActivity(new Intent(this, AActivity.class));
    }

    /**
     * 学习ScrollingActivity
     *
     * @param view
     */
    public void test2(View view) {
        startActivity(new Intent(this, ScrollingActivity.class));
    }

    /**
     * Android探究3：SingleTask启动模式探究:首先从MainActivity启动案例入口AActivity，并在A中启动BActivity，从B启动CActivity，
     * 再从C中又启动AActivity， 最后在A中启动B，现在按两次back键，然后回到的是哪个Activity？
     * 答案是，回到MainActivity。
     * <p>
     * 博客园：http://www.cnblogs.com/jooy/p/8687192.html
     *
     * @param view
     */
    public void test3(View view) {
        startActivity(new Intent(this, ALActivity.class));
    }

    /**
     * IntentFilter意图过滤器，三种匹配规则：action、category、data
     * <p>
     *
     * @param view
     */
    public void test4(View view) {
        startActivity(new Intent(this, SelectFilterActivity.class));
    }
    //=========================================================LINE==========================================================//

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
