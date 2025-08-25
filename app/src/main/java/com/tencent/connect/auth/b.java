package com.tencent.connect.auth;

import com.tencent.tauth.IUiListener;
import java.util.HashMap;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static b f9570a;

    /* renamed from: d, reason: collision with root package name */
    static final /* synthetic */ boolean f9571d = !b.class.desiredAssertionStatus();

    /* renamed from: e, reason: collision with root package name */
    private static int f9572e = 0;

    /* renamed from: b, reason: collision with root package name */
    public HashMap<String, a> f9573b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    public final String f9574c = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    /* compiled from: ProGuard */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public IUiListener f9575a;

        /* renamed from: b, reason: collision with root package name */
        public com.tencent.connect.auth.a f9576b;

        /* renamed from: c, reason: collision with root package name */
        public String f9577c;
    }

    public static b a() {
        if (f9570a == null) {
            f9570a = new b();
        }
        return f9570a;
    }

    public static int b() {
        int i2 = f9572e + 1;
        f9572e = i2;
        return i2;
    }

    public String c() {
        int iCeil = (int) Math.ceil((Math.random() * 20.0d) + 3.0d);
        char[] charArray = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        int length = charArray.length;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < iCeil; i2++) {
            stringBuffer.append(charArray[(int) (Math.random() * length)]);
        }
        return stringBuffer.toString();
    }

    public String a(a aVar) {
        int iB = b();
        try {
            this.f9573b.put("" + iB, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return "" + iB;
    }
}
