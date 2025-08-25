package com.chad.library.adapter.base;

import android.util.SparseIntArray;
import android.view.ViewGroup;
import androidx.annotation.IntRange;
import androidx.annotation.LayoutRes;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.b.b;
import com.chad.library.adapter.base.b.c;
import java.util.List;

/* loaded from: classes.dex */
public abstract class BaseMultiItemQuickAdapter<T extends c, K extends BaseViewHolder> extends BaseQuickAdapter<T, K> {
    private static final int W = -255;
    public static final int X = -404;
    private SparseIntArray V;

    public BaseMultiItemQuickAdapter(List<T> list) {
        super(list);
    }

    private int n(int i2) {
        return this.V.get(i2, -404);
    }

    protected void a(b bVar, int i2) {
        List listA;
        if (!bVar.isExpanded() || (listA = bVar.a()) == null || listA.size() == 0) {
            return;
        }
        int size = listA.size();
        for (int i3 = 0; i3 < size; i3++) {
            f(i2 + 1);
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    protected K b(ViewGroup viewGroup, int i2) {
        return a(viewGroup, n(i2));
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    protected int c(int i2) {
        T t = this.A.get(i2);
        return t instanceof c ? t.a() : W;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void f(@IntRange(from = 0) int i2) {
        List<T> list = this.A;
        if (list == null || i2 < 0 || i2 >= list.size()) {
            return;
        }
        T t = this.A.get(i2);
        if (t instanceof b) {
            a((b) t, i2);
        }
        a((BaseMultiItemQuickAdapter<T, K>) t);
        super.f(i2);
    }

    protected void m(@LayoutRes int i2) {
        b(W, i2);
    }

    protected void b(int i2, @LayoutRes int i3) {
        if (this.V == null) {
            this.V = new SparseIntArray();
        }
        this.V.put(i2, i3);
    }

    protected void a(T t) {
        int iB = b((BaseMultiItemQuickAdapter<T, K>) t);
        if (iB >= 0) {
            ((b) this.A.get(iB)).a().remove(t);
        }
    }
}
