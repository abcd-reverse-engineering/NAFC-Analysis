package com.chad.library.adapter.base.c;

import com.chad.library.R;

/* compiled from: SimpleLoadMoreView.java */
/* loaded from: classes.dex */
public final class b extends a {
    @Override // com.chad.library.adapter.base.c.a
    public int a() {
        return R.layout.quick_view_load_more;
    }

    @Override // com.chad.library.adapter.base.c.a
    protected int b() {
        return R.id.load_more_load_end_view;
    }

    @Override // com.chad.library.adapter.base.c.a
    protected int c() {
        return R.id.load_more_load_fail_view;
    }

    @Override // com.chad.library.adapter.base.c.a
    protected int e() {
        return R.id.load_more_loading_view;
    }
}
