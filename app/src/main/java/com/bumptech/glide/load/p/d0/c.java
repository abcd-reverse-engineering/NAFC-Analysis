package com.bumptech.glide.load.p.d0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: PreFillQueue.java */
/* loaded from: classes.dex */
final class c {

    /* renamed from: a, reason: collision with root package name */
    private final Map<d, Integer> f4509a;

    /* renamed from: b, reason: collision with root package name */
    private final List<d> f4510b;

    /* renamed from: c, reason: collision with root package name */
    private int f4511c;

    /* renamed from: d, reason: collision with root package name */
    private int f4512d;

    public c(Map<d, Integer> map) {
        this.f4509a = map;
        this.f4510b = new ArrayList(map.keySet());
        Iterator<Integer> it = map.values().iterator();
        while (it.hasNext()) {
            this.f4511c += it.next().intValue();
        }
    }

    public int a() {
        return this.f4511c;
    }

    public boolean b() {
        return this.f4511c == 0;
    }

    public d c() {
        d dVar = this.f4510b.get(this.f4512d);
        Integer num = this.f4509a.get(dVar);
        if (num.intValue() == 1) {
            this.f4509a.remove(dVar);
            this.f4510b.remove(this.f4512d);
        } else {
            this.f4509a.put(dVar, Integer.valueOf(num.intValue() - 1));
        }
        this.f4511c--;
        this.f4512d = this.f4510b.isEmpty() ? 0 : (this.f4512d + 1) % this.f4510b.size();
        return dVar;
    }
}
