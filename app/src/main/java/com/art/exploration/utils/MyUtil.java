package com.art.exploration.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by javakam on 2018/4/23.
 */
public class MyUtil {
    /**
     *
     * @param c
     */
    public static void closeIO(Closeable c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
