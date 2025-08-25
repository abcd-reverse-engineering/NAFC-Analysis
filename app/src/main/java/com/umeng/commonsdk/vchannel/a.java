package com.umeng.commonsdk.vchannel;

/* compiled from: Constant.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static String f11110a = "https://pslog.umeng.com";

    /* renamed from: b, reason: collision with root package name */
    public static String f11111b = "https://pslog.umeng.com/";

    /* renamed from: c, reason: collision with root package name */
    public static String f11112c = "explog";

    /* renamed from: d, reason: collision with root package name */
    public static final String f11113d = "analytics";

    /* renamed from: e, reason: collision with root package name */
    public static final String f11114e = "ekv";

    /* renamed from: f, reason: collision with root package name */
    public static final String f11115f = "id";

    /* renamed from: g, reason: collision with root package name */
    public static final String f11116g = "ts";

    /* renamed from: h, reason: collision with root package name */
    public static final String f11117h = "ds";

    /* renamed from: i, reason: collision with root package name */
    public static final String f11118i = "pn";

    /* renamed from: j, reason: collision with root package name */
    public static String f11119j = "";

    static {
        String str = "SUB" + System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(String.format("%0" + (32 - str.length()) + "d", 0));
        f11119j = sb.toString();
    }
}
