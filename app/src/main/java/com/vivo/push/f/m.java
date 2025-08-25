package com.vivo.push.f;

import java.util.List;

/* compiled from: OnDelTagsReceiveTask.java */
/* loaded from: classes2.dex */
final class m implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f12056a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ List f12057b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ List f12058c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f12059d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ l f12060e;

    m(l lVar, int i2, List list, List list2, String str) {
        this.f12060e = lVar;
        this.f12056a = i2;
        this.f12057b = list;
        this.f12058c = list2;
        this.f12059d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        l lVar = this.f12060e;
        ((aa) lVar).f12034b.onDelTags(((com.vivo.push.s) lVar).f12207a, this.f12056a, this.f12057b, this.f12058c, this.f12059d);
    }
}
