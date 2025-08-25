package com.hihonor.push.sdk;

import android.os.Looper;
import com.hihonor.push.framework.aidl.IPushInvoke;
import com.hihonor.push.sdk.b0;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import com.hihonor.push.sdk.z;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class d0 implements b0 {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicInteger f6261a = new AtomicInteger(1);

    /* renamed from: b, reason: collision with root package name */
    public volatile IPushInvoke f6262b;

    /* renamed from: c, reason: collision with root package name */
    public final b0.a f6263c;

    /* renamed from: d, reason: collision with root package name */
    public f0 f6264d;

    public d0(b0.a aVar) {
        this.f6263c = aVar;
    }

    public boolean a() {
        return this.f6261a.get() == 3 || this.f6261a.get() == 4;
    }

    public final void a(int i2) {
        String str = "notifyFailed result: " + i2;
        b0.a aVar = this.f6263c;
        if (aVar != null) {
            z.a aVar2 = (z.a) aVar;
            aVar2.getClass();
            if (Looper.myLooper() == z.this.f6358a.getLooper()) {
                aVar2.a(HonorPushErrorEnum.fromCode(i2));
            } else {
                z.this.f6358a.post(new y(aVar2, i2));
            }
        }
    }
}
