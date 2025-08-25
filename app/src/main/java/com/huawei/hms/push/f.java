package com.huawei.hms.push;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

/* compiled from: CommonHandler.java */
/* loaded from: classes.dex */
public class f extends Handler {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<a> f7199a;

    /* compiled from: CommonHandler.java */
    public interface a {
        void a(Message message);
    }

    public f(a aVar) {
        this.f7199a = new WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        a aVar = this.f7199a.get();
        if (aVar != null) {
            aVar.a(message);
        }
    }
}
