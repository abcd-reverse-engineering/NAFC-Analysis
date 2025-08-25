package com.umeng.socialize.a;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.socialize.utils.ContextUtil;
import java.util.Map;

/* compiled from: DataStore.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static volatile b f11544a;

    /* renamed from: b, reason: collision with root package name */
    private final SharedPreferences f11545b = ContextUtil.getContext().getSharedPreferences("um_social_azx", 0);

    private b() {
    }

    public static b a() {
        if (f11544a == null) {
            synchronized (b.class) {
                if (f11544a == null) {
                    f11544a = new b();
                }
            }
        }
        return f11544a;
    }

    public String b(String str, String str2) {
        return this.f11545b.getString(str, str2);
    }

    public Map<String, ?> b() {
        return this.f11545b.getAll();
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f11545b.edit().putString(str, str2).apply();
    }

    public int a(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return 0;
        }
        SharedPreferences.Editor editorEdit = this.f11545b.edit();
        int i2 = 0;
        for (String str : strArr) {
            if (this.f11545b.contains(str)) {
                editorEdit.remove(str);
                i2++;
            }
        }
        if (i2 > 0) {
            editorEdit.apply();
        }
        return i2;
    }

    public void a(String str) {
        if (this.f11545b.contains(str)) {
            this.f11545b.edit().remove(str).apply();
        }
    }
}
