package com.lxj.easyadapter;

import androidx.collection.SparseArrayCompat;
import h.q2.t.i0;
import i.c.a.d;

/* compiled from: ItemDelegateManager.kt */
/* loaded from: classes.dex */
public final class c<T> {

    /* renamed from: a, reason: collision with root package name */
    private SparseArrayCompat<b<T>> f7899a = new SparseArrayCompat<>();

    public final int a() {
        return this.f7899a.size();
    }

    @d
    public final b<T> b(int i2) {
        b<T> bVar = this.f7899a.get(i2);
        if (bVar == null) {
            i0.f();
        }
        return bVar;
    }

    @d
    public final c<T> c(@d b<T> bVar) {
        i0.f(bVar, "delegate");
        int iIndexOfValue = this.f7899a.indexOfValue(bVar);
        if (iIndexOfValue >= 0) {
            this.f7899a.removeAt(iIndexOfValue);
        }
        return this;
    }

    @d
    public final c<T> a(@d b<T> bVar) {
        i0.f(bVar, "delegate");
        this.f7899a.put(this.f7899a.size(), bVar);
        return this;
    }

    public final int b(@d b<T> bVar) {
        i0.f(bVar, "itemViewDelegate");
        return this.f7899a.indexOfValue(bVar);
    }

    @d
    public final c<T> c(int i2) {
        int iIndexOfKey = this.f7899a.indexOfKey(i2);
        if (iIndexOfKey >= 0) {
            this.f7899a.removeAt(iIndexOfKey);
        }
        return this;
    }

    @d
    public final c<T> a(int i2, @d b<T> bVar) {
        i0.f(bVar, "delegate");
        if (this.f7899a.get(i2) == null) {
            this.f7899a.put(i2, bVar);
            return this;
        }
        throw new IllegalArgumentException("An ItemDelegate is already registered for the viewType = " + i2 + ". Already registered ItemDelegate is " + this.f7899a.get(i2));
    }

    public final int a(T t, int i2) {
        for (int size = this.f7899a.size() - 1; size >= 0; size--) {
            if (this.f7899a.valueAt(size).a(t, i2)) {
                return this.f7899a.keyAt(size);
            }
        }
        throw new IllegalArgumentException("No ItemDelegate added that matches position=" + i2 + " in data source");
    }

    public final void a(@d ViewHolder viewHolder, T t, int i2) {
        i0.f(viewHolder, "holder");
        int size = this.f7899a.size();
        for (int i3 = 0; i3 < size; i3++) {
            b<T> bVarValueAt = this.f7899a.valueAt(i3);
            if (bVarValueAt.a(t, i2)) {
                bVarValueAt.a(viewHolder, t, i2);
                return;
            }
        }
        throw new IllegalArgumentException("No ItemDelegateManager added that matches position=" + i2 + " in data source");
    }

    public final int a(int i2) {
        return b(i2).a();
    }
}
