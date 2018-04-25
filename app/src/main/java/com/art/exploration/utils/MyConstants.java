package com.art.exploration.utils;

import android.os.Environment;

/**
 * Created by javakam on 2018/4/23.
 */
public class MyConstants {

    public static final String EXS_PATH = Environment.getExternalStorageDirectory().getPath()
            + "/devart/chapter_2/";

    public static final String CACHE_FILE_PATH = EXS_PATH + "usercache";
}
