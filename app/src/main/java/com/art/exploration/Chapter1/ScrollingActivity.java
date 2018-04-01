package com.art.exploration.Chapter1;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;

import com.art.exploration.R;

/**
 * 演示：Android 5.0下 Dialog&AlertDialog 并不会影响Activity的生命周期
 * Created by machangbao on 2018-4-1 11:15:27
 */
public class ScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Resources resources = this.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        final int widthPixels = displayMetrics.widthPixels / 2;
        final int heightPixels = displayMetrics.heightPixels / 2;
        //1
        //Android 5.0下 Dialog&AlertDialog 并不会影响Activity的生命周期
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                //test Dialog
//                EditText editText = new EditText(ScrollingActivity.this);
//                editText.setLayoutParams(new ViewGroup.LayoutParams(widthPixels, heightPixels));
//                Dialog dialog = new Dialog(ScrollingActivity.this);
//                dialog.setContentView(editText);
//                dialog.setTitle("标题");
//                dialog.setCanceledOnTouchOutside(false);
//                dialog.show();
                //test Dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ScrollingActivity.this);
                builder.setTitle("弹窗")
                        .setMessage("Msg")
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        ;
                    }
                }).setCancelable(false);
                builder.create().show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("ScrollingActivity.onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("ScrollingActivity.onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("ScrollingActivity.onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("ScrollingActivity.onStop");
    }
}
