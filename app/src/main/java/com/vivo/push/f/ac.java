package com.vivo.push.f;

import java.util.List;

/* compiled from: OnSetTagsReceiveTask.java */
/* loaded from: classes2.dex */
final class ac implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f12036a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ List f12037b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ List f12038c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f12039d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ ab f12040e;

    ac(ab abVar, int i2, List list, List list2, String str) {
        this.f12040e = abVar;
        this.f12036a = i2;
        this.f12037b = list;
        this.f12038c = list2;
        this.f12039d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ab abVar = this.f12040e;
        ((aa) abVar).f12034b.onSetTags(((com.vivo.push.s) abVar).f12207a, this.f12036a, this.f12037b, this.f12038c, this.f12039d);
    }
}
