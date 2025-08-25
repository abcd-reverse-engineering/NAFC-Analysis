package com.vivo.push.f;

import java.util.List;

/* compiled from: OnDelTagsReceiveTask.java */
/* loaded from: classes2.dex */
final class n implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f12061a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ List f12062b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ List f12063c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f12064d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ l f12065e;

    n(l lVar, int i2, List list, List list2, String str) {
        this.f12065e = lVar;
        this.f12061a = i2;
        this.f12062b = list;
        this.f12063c = list2;
        this.f12064d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        l lVar = this.f12065e;
        ((aa) lVar).f12034b.onDelAlias(((com.vivo.push.s) lVar).f12207a, this.f12061a, this.f12062b, this.f12063c, this.f12064d);
    }
}
