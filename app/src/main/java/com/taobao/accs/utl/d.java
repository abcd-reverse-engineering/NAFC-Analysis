package com.taobao.accs.utl;

import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.vivo.push.PushClientConstants;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f8644a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f8645b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f8646c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ AccsDataListener f8647d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ String f8648e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ byte[] f8649f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ TaoBaseService.ExtraInfo f8650g;

    d(String str, String str2, int i2, AccsDataListener accsDataListener, String str3, byte[] bArr, TaoBaseService.ExtraInfo extraInfo) {
        this.f8644a = str;
        this.f8645b = str2;
        this.f8646c = i2;
        this.f8647d = accsDataListener;
        this.f8648e = str3;
        this.f8649f = bArr;
        this.f8650g = extraInfo;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (ALog.isPrintLog(ALog.Level.D) || "accs-impaas".equals(this.f8644a)) {
            ALog.e(a.TAG, "onData start", Constants.KEY_DATA_ID, this.f8645b, Constants.KEY_SERVICE_ID, this.f8644a, "command", Integer.valueOf(this.f8646c), PushClientConstants.TAG_CLASS_NAME, this.f8647d.getClass().getName());
        }
        this.f8647d.onData(this.f8644a, this.f8648e, this.f8645b, this.f8649f, this.f8650g);
        if (ALog.isPrintLog(ALog.Level.D) || "accs-impaas".equals(this.f8644a)) {
            ALog.e(a.TAG, "onData end", Constants.KEY_DATA_ID, this.f8645b);
        }
    }
}
