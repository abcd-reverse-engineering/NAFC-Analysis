package com.umeng.socialize.handler;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes2.dex */
public class UMHonorPreferences {
    private static final String KEY_AUTH = "auth";
    private final SharedPreferences sp;

    public UMHonorPreferences(Context context) {
        this.sp = context.getSharedPreferences("um_honor", 0);
    }

    public void delete() {
        this.sp.edit().clear().apply();
    }

    public boolean isAuthed() {
        return this.sp.getBoolean("auth", false);
    }

    public void setAuthed() {
        this.sp.edit().putBoolean("auth", true).apply();
    }
}
