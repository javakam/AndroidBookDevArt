package com.art.exploration.Chapter1.savestate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.art.exploration.R;
import com.art.exploration.utils.SharedPreUtil;

public class SaveInstanceStateActivity extends AppCompatActivity {
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_instance_state);
        editText = findViewById(R.id.editState);
        if (savedInstanceState != null) {
            String s = savedInstanceState.getString("edtStr");
            System.out.println("onCreate 恢复的数据 : " + s);
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("SaveInstanceStateActivity.onStart");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            String s = savedInstanceState.getString("edtStr");
            System.out.println("onRestoreInstanceState 恢复的数据 : " + s);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("onResume 从SharedPreferences取值："
                + SharedPreUtil.getInstance(this).getString(null));
    }

    @Override
    protected void onPause() {
        super.onPause();
        String save = editText.getText().toString().trim();
        SharedPreUtil.getInstance(this).putString( save);
        System.out.println("onPause 向SharedPreferences中存值：" + save);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String save = editText.getText().toString().trim();
        outState.putString("edtStr", "".equals(save) ? "" : save);
        System.out.println("onSaveInstanceState 保存的数据 : " + save);
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("SaveInstanceStateActivity.onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("SaveInstanceStateActivity.onDestroy");
    }
}
