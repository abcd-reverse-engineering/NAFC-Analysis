package com.chad.library.adapter.base.d;

import android.util.SparseIntArray;
import androidx.annotation.LayoutRes;
import java.util.List;

/* compiled from: MultiTypeDelegate.java */
/* loaded from: classes.dex */
public abstract class a<T> {

    /* renamed from: d, reason: collision with root package name */
    private static final int f5463d = -255;

    /* renamed from: a, reason: collision with root package name */
    private SparseIntArray f5464a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f5465b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f5466c;

    public a(SparseIntArray sparseIntArray) {
        this.f5464a = sparseIntArray;
    }

    private void b(int i2, @LayoutRes int i3) {
        if (this.f5464a == null) {
            this.f5464a = new SparseIntArray();
        }
        this.f5464a.put(i2, i3);
    }

    protected abstract int a(T t);

    public final int a(List<T> list, int i2) {
        T t = list.get(i2);
        return t != null ? a((a<T>) t) : f5463d;
    }

    public a() {
    }

    public final int a(int i2) {
        return this.f5464a.get(i2, -404);
    }

    public a a(@LayoutRes int... iArr) {
        this.f5465b = true;
        a(this.f5466c);
        for (int i2 = 0; i2 < iArr.length; i2++) {
            b(i2, iArr[i2]);
        }
        return this;
    }

    public a a(int i2, @LayoutRes int i3) {
        this.f5466c = true;
        a(this.f5465b);
        b(i2, i3);
        return this;
    }

    private void a(boolean z) {
        if (z) {
            throw new RuntimeException("Don't mess two register mode");
        }
    }
}
