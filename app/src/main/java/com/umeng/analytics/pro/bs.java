package com.umeng.analytics.pro;

import java.io.ByteArrayOutputStream;

/* compiled from: TByteArrayOutputStream.java */
/* loaded from: classes2.dex */
public class bs extends ByteArrayOutputStream {
    public bs(int i2) {
        super(i2);
    }

    public byte[] a() {
        return ((ByteArrayOutputStream) this).buf;
    }

    public int b() {
        return ((ByteArrayOutputStream) this).count;
    }

    public bs() {
    }
}
