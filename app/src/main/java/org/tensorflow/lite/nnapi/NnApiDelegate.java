package org.tensorflow.lite.nnapi;

import org.tensorflow.lite.b;

/* loaded from: classes2.dex */
public class NnApiDelegate implements b, AutoCloseable {

    /* renamed from: b, reason: collision with root package name */
    private static final long f17525b = 0;

    /* renamed from: a, reason: collision with root package name */
    private long f17526a = createDelegate();

    private static native long createDelegate();

    @Override // org.tensorflow.lite.b
    public long c() {
        return this.f17526a;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        if (this.f17526a != 0) {
            this.f17526a = 0L;
        }
    }
}
