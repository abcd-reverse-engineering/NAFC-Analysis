package com.chad.library.adapter.base.listener;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;

/* loaded from: classes.dex */
public abstract class OnItemChildLongClickListener extends SimpleClickListener {
    @Override // com.chad.library.adapter.base.listener.SimpleClickListener
    public void a(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
    }

    @Override // com.chad.library.adapter.base.listener.SimpleClickListener
    public void b(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        e(baseQuickAdapter, view, i2);
    }

    @Override // com.chad.library.adapter.base.listener.SimpleClickListener
    public void c(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
    }

    @Override // com.chad.library.adapter.base.listener.SimpleClickListener
    public void d(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
    }

    public abstract void e(BaseQuickAdapter baseQuickAdapter, View view, int i2);
}
