package com.tencent.open.log;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public final class e extends Tracer {

    /* renamed from: a, reason: collision with root package name */
    public static final e f9888a = new e();

    @Override // com.tencent.open.log.Tracer
    protected void doTrace(int i2, Thread thread, long j2, String str, String str2, Throwable th) {
        if (i2 == 1 || i2 == 2 || i2 == 4 || i2 == 8 || i2 != 16) {
        }
    }
}
