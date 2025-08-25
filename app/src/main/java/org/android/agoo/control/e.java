package org.android.agoo.control;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f17335a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f17336b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ AgooFactory f17337c;

    e(AgooFactory agooFactory, String str, String str2) {
        this.f17337c = agooFactory;
        this.f17335a = str;
        this.f17336b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f17337c.updateMsgStatus(this.f17335a, this.f17336b);
    }
}
