package com.art.exploration.Chapter1.intentfilter;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.art.exploration.R;

/**
 * IntentFilter意图过滤器，三种匹配规则：action、category、data
 * 重：过滤规则中必须设置 '<category android:name="android.intent.category.DEFAULT" />' ，
 * 否则不生效。
 * 也说明，addCategory是一个叠加的属性。源码内部是一个 ArraySet
 */
public class SelectFilterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_filter);
    }

    /**
     * 通过自定义action跳转，不设置category（系统在startActivity/startActivityForResult时默认为Intent加上DEFAULT），设置相应的data
     *
     * @param view
     */
    public void action1(View view) {
        Intent intent = new Intent();
        intent.setAction("com.action.123");
//        intent.addCategory("");
        //注意:不能先setData在setType，因为这两个方法彼此会清除对方的值，详见源码
        intent.setDataAndType(Uri.parse("content://"), "text/plain");
        startActivity(intent);
    }

    /**
     * 通过自定义action跳转，设置自定义category，设置相应的data
     *
     * @param view
     */
    public void action2(View view) {
        Intent intent = new Intent("com.action.1");
        intent.addCategory("com.category.abc.2");
        intent.setDataAndType(Uri.parse("http://www.baidu.com:8080"), "image/*");
        startActivity(intent);
    }

    /**
     * 不设置action，设置自定义category，设置相应的data
     * <p>
     * 失败：仅通过category跳转，intent-filter中仅设置了一个自定义的category；\r\n
     * 成功：Intent可以不指定Action，通过category+data来做跳转,data中仅需设置一个mimeType即可，
     * 但必须设置 《action android:name="com.action.mif3"/》 否则隐式跳转无效.
     *
     * @param view
     */
    public void category1(View view) {
        Intent intent = new Intent();
        intent.addCategory("com.category.mif3");
        intent.setDataAndType(Uri.parse("file://abc"), "video/*");
        startActivity(intent);
    }


}
