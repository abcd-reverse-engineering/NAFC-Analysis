package com.bumptech.glide.load.p.a0;

import com.bumptech.glide.load.p.a0.m;
import java.util.Queue;

/* compiled from: BaseKeyPool.java */
/* loaded from: classes.dex */
abstract class d<T extends m> {

    /* renamed from: b, reason: collision with root package name */
    private static final int f4339b = 20;

    /* renamed from: a, reason: collision with root package name */
    private final Queue<T> f4340a = com.bumptech.glide.util.l.a(20);

    d() {
    }

    abstract T a();

    public void a(T t) {
        if (this.f4340a.size() < 20) {
            this.f4340a.offer(t);
        }
    }

    T b() {
        T tPoll = this.f4340a.poll();
        return tPoll == null ? (T) a() : tPoll;
    }
}
