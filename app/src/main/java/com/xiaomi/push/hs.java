package com.xiaomi.push;

import java.io.ByteArrayOutputStream;

/* loaded from: classes2.dex */
public class hs extends ByteArrayOutputStream {
    public hs(int i2) {
        super(i2);
    }

    /* renamed from: a, reason: collision with other method in class */
    public byte[] m599a() {
        return ((ByteArrayOutputStream) this).buf;
    }

    public hs() {
    }

    public int a() {
        return ((ByteArrayOutputStream) this).count;
    }
}
