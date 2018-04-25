package com.art.exploration.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

/**
 * Created by javakam on 2018/4/22.
 */
public class SharedPreUtil {
    private static SharedPreferences sp;
    private static final String SP_KEY = "sharedPref";

    private SharedPreUtil() {
    }

    private static final class SPUtilHolder {
        public final static SharedPreUtil instance = new SharedPreUtil();
    }

    public synchronized static SharedPreUtil getInstance(@NonNull Context context) {
        if (sp == null) {
            sp = context.getSharedPreferences(SP_KEY, Context.MODE_PRIVATE);
        }
        return SPUtilHolder.instance;
    }

    public synchronized void putString(@NonNull String s) {
        checkNull(s);
        sp.edit().putString(SP_KEY, s).commit();
    }

    public synchronized String getString(@Nullable String defaultVal) {
        checkNull(null);
        return sp.getString(SP_KEY, defaultVal);
    }

    private void checkNull(@Nullable String param) {
        if (sp == null) {
            throw new ExceptionInInitializerError("U must init SharedPreUtil First ");
        }
        if (TextUtils.isEmpty(param)) {
            return;
        }
    }

}
