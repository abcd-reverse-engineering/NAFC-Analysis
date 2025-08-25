package com.taobao.accs.utl;

import java.io.ByteArrayOutputStream;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class r extends ByteArrayOutputStream {
    public r(int i2) {
        super(i2);
    }

    public r a(byte b2) {
        write(b2);
        return this;
    }

    public r() {
    }

    public r a(short s) {
        write(s >> 8);
        write(s);
        return this;
    }
}
