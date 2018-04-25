package com.art.exploration.Chapter2.ipc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.art.exploration.Chapter2.model.User;
import com.art.exploration.R;
import com.art.exploration.utils.Lg;
import com.art.exploration.utils.MyConstants;
import com.art.exploration.utils.MyUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class ShareFileReadObjActivity extends AppCompatActivity {

    private TextView tvUserInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_file_read_obj);
        tvUserInfo = findViewById(R.id.tvUserInfo);
    }

    public void readObjFromLocal(View view) {
        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(666);
                emitter.onComplete();
            }
        });

        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(Integer o) {
                Lg.e("onNext :" + o);
                readObjFromLocalFile();
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onComplete() {
                Lg.e("onComplete ");
            }
        };

        observable.subscribe(observer);
    }

    private void readObjFromLocalFile() {
        new Thread(() -> {
            File file = new File(MyConstants.EXS_PATH);
            if (!file.exists()) {
                file.mkdirs();
            }
            File cacheFile = new File(MyConstants.CACHE_FILE_PATH);
            ObjectInputStream ois = null;
            if (cacheFile.exists()) {
                try {
                    ois = new ObjectInputStream(new FileInputStream(cacheFile));
                    User user = (User) ois.readObject();
                    Lg.e("读取完成 : " + user);
                    tvUserInfo.setText(user.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } finally {
                    Lg.w("333");

                    MyUtil.closeIO(ois);
                }
            } else {
                Lg.e("没有该文件......");
            }
        }).start();
    }
}
