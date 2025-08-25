package org.greenrobot.eventbus.r;

import org.greenrobot.eventbus.ThreadMode;

/* compiled from: SubscriberMethodInfo.java */
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    final String f17452a;

    /* renamed from: b, reason: collision with root package name */
    final ThreadMode f17453b;

    /* renamed from: c, reason: collision with root package name */
    final Class<?> f17454c;

    /* renamed from: d, reason: collision with root package name */
    final int f17455d;

    /* renamed from: e, reason: collision with root package name */
    final boolean f17456e;

    public e(String str, Class<?> cls, ThreadMode threadMode, int i2, boolean z) {
        this.f17452a = str;
        this.f17453b = threadMode;
        this.f17454c = cls;
        this.f17455d = i2;
        this.f17456e = z;
    }

    public e(String str, Class<?> cls) {
        this(str, cls, ThreadMode.POSTING, 0, false);
    }

    public e(String str, Class<?> cls, ThreadMode threadMode) {
        this(str, cls, threadMode, 0, false);
    }
}
