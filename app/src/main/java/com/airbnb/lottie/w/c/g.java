package com.airbnb.lottie.w.c;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MaskKeyframeAnimation.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private final List<a<com.airbnb.lottie.y.k.l, Path>> f3759a;

    /* renamed from: b, reason: collision with root package name */
    private final List<a<Integer, Integer>> f3760b;

    /* renamed from: c, reason: collision with root package name */
    private final List<com.airbnb.lottie.y.k.g> f3761c;

    public g(List<com.airbnb.lottie.y.k.g> list) {
        this.f3761c = list;
        this.f3759a = new ArrayList(list.size());
        this.f3760b = new ArrayList(list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f3759a.add(list.get(i2).b().a());
            this.f3760b.add(list.get(i2).c().a());
        }
    }

    public List<a<com.airbnb.lottie.y.k.l, Path>> a() {
        return this.f3759a;
    }

    public List<com.airbnb.lottie.y.k.g> b() {
        return this.f3761c;
    }

    public List<a<Integer, Integer>> c() {
        return this.f3760b;
    }
}
