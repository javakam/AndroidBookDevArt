package com.art.exploration.Chapter2.ipc;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.art.exploration.Chapter2.model.User;
import com.art.exploration.R;
import com.art.exploration.utils.Lg;
import com.art.exploration.utils.MyConstants;
import com.art.exploration.utils.MyUtil;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ShareFileWriteObjActivity extends AppCompatActivity {
    private final int PERMISSIONS_REQUEST_READ_CONTACTS = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_file_write_obj);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    // 授权管理
    private void initPermissions() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
//            Log.i(TAG, "需要授权 ");
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
//                Log.i(TAG, "拒绝过了");
                Toast.makeText(this, "请在 设置-应用管理 中开启此应用的储存授权。", Toast.LENGTH_SHORT).show();
            } else {
//                Log.i(TAG, "进行授权");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSIONS_REQUEST_READ_CONTACTS);
            }
        } else {
//            Log.i(TAG, "不需要授权 ");
        }
    }

    public void goToReadActivity(View view) {
        Lg.i("goToReadActivity......");
        initPermissions();
    }

    public void goReadObj(View view) {
        startActivity(new Intent(ShareFileWriteObjActivity.this,
                ShareFileReadObjActivity.class));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
        if (requestCode == PERMISSIONS_REQUEST_READ_CONTACTS) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Log.i("123", "同意授权");
                doWrite();
            } else {
                Log.i("123", "拒绝授权");
            }
        }
    }

    private void doWrite() {
        Flowable.create((FlowableOnSubscribe<Integer>) emitter -> {
            Lg.i("send 233");
            if (emitter.requested() < 1) {
                throw new RuntimeException("请先设置请求数量");
            }
            emitter.onNext(233);
            emitter.onComplete();
        }, BackpressureStrategy.BUFFER)
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(Schedulers.io())
                .doOnNext(integer -> Lg.d("doOnNext integer : " + integer))
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        s.request(1);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Lg.i("accept " + integer);
                        if (integer == 233) {
                            writeObjToLocal();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        Lg.e(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }


    private void writeObjToLocal() {
        new Thread(() -> {
            User user = new User();
            user.userId = 8;
            user.userName = "tom";
            user.isMale = false;

            File file = new File(MyConstants.EXS_PATH);
            if (!file.exists()) {
                file.mkdirs();
            }
            File fileCache = new File(MyConstants.CACHE_FILE_PATH);
            if (!fileCache.exists()) {
                Lg.e("文件创建失败");
            }
            ObjectOutputStream oos = null;
            try {
                oos = new ObjectOutputStream(new FileOutputStream(fileCache));
                oos.writeObject(user);
                Lg.e(getResources().getString(R.string.c2WriteObjLocal) + "......OK ");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                MyUtil.closeIO(oos);
            }
        }).start();
    }


    //======================================================================================//

    private class MyAsyncTask extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onCancelled(String s) {
            super.onCancelled(s);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }
}
