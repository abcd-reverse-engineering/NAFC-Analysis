package com.taobao.accs.data;

import java.util.Comparator;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class b implements Comparator<Integer> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f8448a;

    b(a aVar) {
        this.f8448a = aVar;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(Integer num, Integer num2) {
        return num.intValue() - num2.intValue();
    }
}
