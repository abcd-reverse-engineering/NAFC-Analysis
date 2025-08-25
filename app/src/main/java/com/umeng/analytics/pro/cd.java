package com.umeng.analytics.pro;

import java.io.Serializable;

/* compiled from: FieldValueMetaData.java */
/* loaded from: classes2.dex */
public class cd implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f10214a;

    /* renamed from: b, reason: collision with root package name */
    public final byte f10215b;

    /* renamed from: c, reason: collision with root package name */
    private final String f10216c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f10217d;

    public cd(byte b2, boolean z) {
        this.f10215b = b2;
        this.f10214a = false;
        this.f10216c = null;
        this.f10217d = z;
    }

    public boolean a() {
        return this.f10214a;
    }

    public String b() {
        return this.f10216c;
    }

    public boolean c() {
        return this.f10215b == 12;
    }

    public boolean d() {
        byte b2 = this.f10215b;
        return b2 == 15 || b2 == 13 || b2 == 14;
    }

    public boolean e() {
        return this.f10217d;
    }

    public cd(byte b2) {
        this(b2, false);
    }

    public cd(byte b2, String str) {
        this.f10215b = b2;
        this.f10214a = true;
        this.f10216c = str;
        this.f10217d = false;
    }
}
