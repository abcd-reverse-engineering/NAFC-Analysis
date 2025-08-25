package com.xiaomi.push;

import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class ex extends er {
    public ex() {
        a("PING", (String) null);
        a("0");
        a(0);
    }

    @Override // com.xiaomi.push.er
    /* renamed from: a */
    ByteBuffer mo391a(ByteBuffer byteBuffer) {
        return m394a().length == 0 ? byteBuffer : super.mo391a(byteBuffer);
    }

    @Override // com.xiaomi.push.er
    public int c() {
        if (m394a().length == 0) {
            return 0;
        }
        return super.c();
    }
}
