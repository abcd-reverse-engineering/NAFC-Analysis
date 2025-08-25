package org.android.agoo.control;

import com.taobao.accs.base.TaoBaseService;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ byte[] f17327a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f17328b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ TaoBaseService.ExtraInfo f17329c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ AgooFactory f17330d;

    b(AgooFactory agooFactory, byte[] bArr, String str, TaoBaseService.ExtraInfo extraInfo) {
        this.f17330d = agooFactory;
        this.f17327a = bArr;
        this.f17328b = str;
        this.f17329c = extraInfo;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f17330d.msgReceiverPreHandler(this.f17327a, this.f17328b, this.f17329c, true);
    }
}
