package com.taobao.accs.internal;

import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.l;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class a implements l.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ACCSManagerImpl f8491a;

    a(ACCSManagerImpl aCCSManagerImpl) {
        this.f8491a = aCCSManagerImpl;
    }

    @Override // com.taobao.accs.utl.l.b
    public void a() {
        try {
            ALog.e(ACCSManagerImpl.f8480c, "onForeState", new Object[0]);
            if (AccsClientConfig.getConfigByTag(this.f8491a.f8482b).isForePingEnable()) {
                this.f8491a.a(this.f8491a.f8483d);
            }
        } catch (Exception e2) {
            ALog.e(ACCSManagerImpl.f8480c, "onForeState error, Error:", e2, new Object[0]);
        }
    }

    @Override // com.taobao.accs.utl.l.b
    public void b() {
        ALog.e(ACCSManagerImpl.f8480c, "onBackState", new Object[0]);
    }
}
