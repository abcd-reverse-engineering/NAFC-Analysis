package com.alibaba.sdk.android.utils.crashdefend;

/* compiled from: CrashDefendSDKInfo.java */
/* loaded from: classes.dex */
public class c implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public int f4139a;

    /* renamed from: a, reason: collision with other field name */
    public long f50a;

    /* renamed from: a, reason: collision with other field name */
    public String f52a;

    /* renamed from: b, reason: collision with root package name */
    public int f4140b;

    /* renamed from: b, reason: collision with other field name */
    public long f53b;

    /* renamed from: b, reason: collision with other field name */
    public String f54b;
    public int crashCount;

    /* renamed from: c, reason: collision with root package name */
    public int f4141c = 0;

    /* renamed from: c, reason: collision with other field name */
    public volatile boolean f55c = false;

    /* renamed from: a, reason: collision with other field name */
    public SDKMessageCallback f51a = null;

    public Object clone() {
        try {
            return (c) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }
}
