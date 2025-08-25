package com.vivo.push.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: BaseSharePreference.java */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    protected Context f12260a;

    /* renamed from: b, reason: collision with root package name */
    private String f12261b;

    /* renamed from: c, reason: collision with root package name */
    private volatile SharedPreferences f12262c;

    /* renamed from: d, reason: collision with root package name */
    private HashMap<String, String> f12263d = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    private HashMap<String, Long> f12264e = new HashMap<>();

    /* renamed from: f, reason: collision with root package name */
    private HashMap<String, Integer> f12265f = new HashMap<>();

    /* renamed from: g, reason: collision with root package name */
    private HashMap<String, Boolean> f12266g = new HashMap<>();

    public final void a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("sharedFileName can't be null");
        }
        this.f12261b = str;
        this.f12262c = context.getSharedPreferences(this.f12261b, 0);
        this.f12260a = context;
        List<String> listB = b("local_iv");
        if (listB == null || listB.size() < 4) {
            u.a("BaseSharePreference", " initSecureCode error list is null ");
            return;
        }
        HashMap map = new HashMap();
        map.put("com.vivo.push.secure_sub_iv", listB.get(1));
        map.put("com.vivo.push.secure_sub_key", listB.get(2));
        map.put("com.vivo.push.secure_cache_iv", listB.get(3));
        map.put("com.vivo.push.secure_cache_key", listB.get(0));
        a(map);
    }

    public final String b(String str, String str2) {
        String string = this.f12263d.get(str);
        if (string != null) {
            return string;
        }
        b();
        if (this.f12262c != null) {
            string = this.f12262c.getString(str, str2);
            if (!TextUtils.isEmpty(string) && !string.equals(str2)) {
                this.f12263d.put(str, string);
            }
        }
        return string;
    }

    public final int b(String str, int i2) {
        Integer numValueOf = this.f12265f.get(str);
        if (numValueOf != null) {
            return numValueOf.intValue();
        }
        b();
        if (this.f12262c != null) {
            numValueOf = Integer.valueOf(this.f12262c.getInt(str, i2));
            if (!numValueOf.equals(Integer.valueOf(i2))) {
                this.f12265f.put(str, numValueOf);
            }
        }
        return numValueOf.intValue();
    }

    public final void a(String str, String str2) {
        this.f12263d.put(str, str2);
        b();
        if (this.f12262c != null) {
            SharedPreferences.Editor editorEdit = this.f12262c.edit();
            editorEdit.putString(str, str2);
            a(editorEdit);
        }
    }

    public final long b(String str, long j2) {
        Long lValueOf = this.f12264e.get(str);
        if (lValueOf != null) {
            return lValueOf.longValue();
        }
        b();
        if (this.f12262c != null) {
            lValueOf = Long.valueOf(this.f12262c.getLong(str, j2));
            if (!lValueOf.equals(Long.valueOf(j2))) {
                this.f12264e.put(str, lValueOf);
            }
        }
        return lValueOf.longValue();
    }

    private void a(Map<String, String> map) {
        if (map.size() > 0) {
            b();
            if (this.f12262c != null) {
                SharedPreferences.Editor editorEdit = this.f12262c.edit();
                for (String str : map.keySet()) {
                    String str2 = map.get(str);
                    this.f12263d.put(str, str2);
                    editorEdit.putString(str, str2);
                }
                a(editorEdit);
            }
        }
    }

    private synchronized void b() {
        if (this.f12262c == null) {
            if (this.f12260a != null) {
                this.f12262c = this.f12260a.getSharedPreferences(this.f12261b, 0);
            } else {
                throw new RuntimeException("SharedPreferences is not init", new Throwable());
            }
        }
    }

    private List<String> b(String str) {
        Object objA;
        String[] strArrSplit;
        if (this.f12260a == null) {
            u.c("BaseSharePreference", " parsLocalIv error mContext is null ");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            objA = ag.a(this.f12260a, this.f12260a.getPackageName(), str);
        } catch (Exception e2) {
            u.c("BaseSharePreference", " parsLocalIv error e =" + e2.getMessage());
            e2.printStackTrace();
        }
        if (objA == null) {
            return null;
        }
        String str2 = new String(Base64.decode(objA.toString(), 2));
        if (!TextUtils.isEmpty(str2) && (strArrSplit = str2.split(",#@")) != null && strArrSplit.length >= 4) {
            for (String str3 : strArrSplit) {
                arrayList.add(str3.replace(",#@", ""));
            }
            if (arrayList.size() >= 4) {
                return arrayList;
            }
        }
        return null;
    }

    public final void a(String str, int i2) {
        this.f12265f.put(str, Integer.valueOf(i2));
        b();
        if (this.f12262c != null) {
            SharedPreferences.Editor editorEdit = this.f12262c.edit();
            editorEdit.putInt(str, i2);
            a(editorEdit);
        }
    }

    public final void a(String str, long j2) {
        this.f12264e.put(str, Long.valueOf(j2));
        b();
        if (this.f12262c != null) {
            SharedPreferences.Editor editorEdit = this.f12262c.edit();
            editorEdit.putLong(str, j2);
            a(editorEdit);
        }
    }

    public final void a(String str) {
        this.f12264e.remove(str);
        this.f12265f.remove(str);
        this.f12266g.remove(str);
        this.f12263d.remove(str);
        b();
        if (this.f12262c != null) {
            SharedPreferences.Editor editorEdit = this.f12262c.edit();
            if (this.f12262c.contains(str)) {
                editorEdit.remove(str);
                a(editorEdit);
            }
        }
    }

    public static void a(SharedPreferences.Editor editor) {
        if (editor == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            editor.apply();
        } else {
            editor.commit();
        }
    }

    public final void a() {
        this.f12264e.clear();
        this.f12265f.clear();
        this.f12266g.clear();
        this.f12263d.clear();
        b();
        if (this.f12262c != null) {
            SharedPreferences.Editor editorEdit = this.f12262c.edit();
            editorEdit.clear();
            a(editorEdit);
        }
    }
}
