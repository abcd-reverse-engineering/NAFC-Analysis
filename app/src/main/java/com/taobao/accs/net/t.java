package com.taobao.accs.net;

import android.text.TextUtils;
import com.taobao.accs.utl.ALog;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class t implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ k f8556a;

    t(k kVar) {
        this.f8556a = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.f8556a.f8503d == null || TextUtils.isEmpty(this.f8556a.i())) {
                return;
            }
            ALog.i(this.f8556a.d(), "mTryStartServiceRunable bindapp", new Object[0]);
            this.f8556a.k();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
