package com.art.exploration.Chapter2.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.art.exploration.ISumAIDL;

public class ISumService extends Service {
    public ISumService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }


    private IBinder mBinder = new ISumAIDL.Stub() {
        @Override
        public int add(int num1, int num2) throws RemoteException {
            int sum = num1 + num2;
            Log.e("123", "我接收到的数据为：" + num1 + " 和 " + num2 + " ，计算结果： " + sum);
            return sum;
        }
    };

}
