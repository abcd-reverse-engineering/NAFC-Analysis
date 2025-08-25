package com.taobao.accs.antibrush;

import com.taobao.accs.utl.ALog;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AntiBrush f8381a;

    a(AntiBrush antiBrush) {
        this.f8381a = antiBrush;
    }

    @Override // java.lang.Runnable
    public void run() {
        ALog.e("AntiBrush", "anti bursh timeout", new Object[0]);
        AntiBrush.onResult(this.f8381a.mContext, false);
    }
}
