package com.art.aidlclient;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.art.exploration.ISumAIDL;

public class MainActivity extends AppCompatActivity {

    private EditText num1;
    private EditText num2;
    private EditText sum;

    private ISumAIDL iSumAIDL;

    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
//            iSumAIDL = (ISumAIDL) service;
            iSumAIDL = ISumAIDL.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            iSumAIDL = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        bindSumAIDLService();
    }

    private void initViews() {
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        sum = findViewById(R.id.sum);
    }

    private void bindSumAIDLService() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.art.exploration.Chapter2.aidl", "com.art.exploration.Chapter2.aidl.ISumService"));
//        intent.setAction("com.sumservice");
//        intent.setPackage("com.art.exploration.Chapter2.aidl");
//        bindService(intent, conn, Context.BIND_AUTO_CREATE);

//        mLog.setText("Starting service…\n");
        startService(intent);
//        mLog.append("Binding service…\n");
        bindService(intent, conn, BIND_AUTO_CREATE);
    }

    public void sumByAIDL(View view) {
        try {
            int result = iSumAIDL.add(Integer.parseInt(num1.getText().toString()), Integer.parseInt(num2.getText().toString()));
            sum.setText(result + "");
        } catch (RemoteException e) {
            e.printStackTrace();
            sum.setText("错误。。。");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(conn);
    }
}
