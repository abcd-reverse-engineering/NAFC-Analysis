package org.greenrobot.eventbus.r;

import org.greenrobot.eventbus.o;

/* compiled from: SimpleSubscriberInfo.java */
/* loaded from: classes2.dex */
public class b extends a {

    /* renamed from: d, reason: collision with root package name */
    private final e[] f17451d;

    public b(Class cls, boolean z, e[] eVarArr) {
        super(cls, null, z);
        this.f17451d = eVarArr;
    }

    @Override // org.greenrobot.eventbus.r.c
    public synchronized o[] a() {
        o[] oVarArr;
        int length = this.f17451d.length;
        oVarArr = new o[length];
        for (int i2 = 0; i2 < length; i2++) {
            e eVar = this.f17451d[i2];
            oVarArr[i2] = a(eVar.f17452a, eVar.f17454c, eVar.f17453b, eVar.f17455d, eVar.f17456e);
        }
        return oVarArr;
    }
}
