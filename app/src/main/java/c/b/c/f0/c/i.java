package c.b.c.f0.c;

import c.b.c.t;

/* compiled from: QRCodeDecoderMetaData.java */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f2762a;

    i(boolean z) {
        this.f2762a = z;
    }

    public boolean a() {
        return this.f2762a;
    }

    public void a(t[] tVarArr) {
        if (!this.f2762a || tVarArr == null || tVarArr.length < 3) {
            return;
        }
        t tVar = tVarArr[0];
        tVarArr[0] = tVarArr[2];
        tVarArr[2] = tVar;
    }
}
