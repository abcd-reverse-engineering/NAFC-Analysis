package com.umeng.ut.b.b;

/* loaded from: classes2.dex */
public class e {
    public static boolean a(com.umeng.ut.a.b.a aVar) {
        String str = "";
        try {
            str = new String(aVar.data, "UTF-8");
        } catch (Exception e2) {
            com.umeng.ut.a.c.e.m44a("", e2);
        }
        if (com.umeng.ut.a.b.a.a(str, aVar.signature)) {
            return b.a(b.a(str).f11918d);
        }
        return false;
    }
}
