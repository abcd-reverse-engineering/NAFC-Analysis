package com.chad.library.adapter.base.c;

import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import com.chad.library.adapter.base.BaseViewHolder;

/* compiled from: LoadMoreView.java */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: c, reason: collision with root package name */
    public static final int f5452c = 1;

    /* renamed from: d, reason: collision with root package name */
    public static final int f5453d = 2;

    /* renamed from: e, reason: collision with root package name */
    public static final int f5454e = 3;

    /* renamed from: f, reason: collision with root package name */
    public static final int f5455f = 4;

    /* renamed from: a, reason: collision with root package name */
    private int f5456a = 1;

    /* renamed from: b, reason: collision with root package name */
    private boolean f5457b = false;

    private void b(BaseViewHolder baseViewHolder, boolean z) {
        baseViewHolder.c(c(), z);
    }

    private void c(BaseViewHolder baseViewHolder, boolean z) {
        baseViewHolder.c(e(), z);
    }

    @LayoutRes
    public abstract int a();

    public void a(int i2) {
        this.f5456a = i2;
    }

    @IdRes
    protected abstract int b();

    @IdRes
    protected abstract int c();

    public int d() {
        return this.f5456a;
    }

    @IdRes
    protected abstract int e();

    @Deprecated
    public boolean f() {
        return this.f5457b;
    }

    public final boolean g() {
        if (b() == 0) {
            return true;
        }
        return this.f5457b;
    }

    public void a(BaseViewHolder baseViewHolder) {
        int i2 = this.f5456a;
        if (i2 == 1) {
            c(baseViewHolder, false);
            b(baseViewHolder, false);
            a(baseViewHolder, false);
            return;
        }
        if (i2 == 2) {
            c(baseViewHolder, true);
            b(baseViewHolder, false);
            a(baseViewHolder, false);
        } else if (i2 == 3) {
            c(baseViewHolder, false);
            b(baseViewHolder, true);
            a(baseViewHolder, false);
        } else {
            if (i2 != 4) {
                return;
            }
            c(baseViewHolder, false);
            b(baseViewHolder, false);
            a(baseViewHolder, true);
        }
    }

    private void a(BaseViewHolder baseViewHolder, boolean z) {
        int iB = b();
        if (iB != 0) {
            baseViewHolder.c(iB, z);
        }
    }

    public final void a(boolean z) {
        this.f5457b = z;
    }
}
