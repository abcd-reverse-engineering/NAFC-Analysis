package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes2.dex */
public class bm {

    /* renamed from: a, reason: collision with root package name */
    private static volatile bm f12505a;

    /* renamed from: a, reason: collision with other field name */
    private Context f216a;

    private bm(Context context) {
        this.f216a = context;
    }

    public static bm a(Context context) {
        if (f12505a == null) {
            synchronized (bm.class) {
                if (f12505a == null) {
                    f12505a = new bm(context);
                }
            }
        }
        return f12505a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized void m188a(String str, String str2, String str3) {
        SharedPreferences.Editor editorEdit = this.f216a.getSharedPreferences(str, 4).edit();
        editorEdit.putString(str2, str3);
        editorEdit.commit();
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized void m187a(String str, String str2, long j2) {
        SharedPreferences.Editor editorEdit = this.f216a.getSharedPreferences(str, 4).edit();
        editorEdit.putLong(str2, j2);
        editorEdit.commit();
    }

    public synchronized String a(String str, String str2, String str3) {
        try {
        } catch (Throwable unused) {
            return str3;
        }
        return this.f216a.getSharedPreferences(str, 4).getString(str2, str3);
    }

    public synchronized long a(String str, String str2, long j2) {
        try {
        } catch (Throwable unused) {
            return j2;
        }
        return this.f216a.getSharedPreferences(str, 4).getLong(str2, j2);
    }
}
