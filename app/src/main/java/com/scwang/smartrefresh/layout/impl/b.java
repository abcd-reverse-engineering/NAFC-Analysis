package com.scwang.smartrefresh.layout.impl;

import android.graphics.PointF;
import android.view.View;
import com.scwang.smartrefresh.layout.b.k;
import com.scwang.smartrefresh.layout.e.d;

/* compiled from: ScrollBoundaryDeciderAdapter.java */
/* loaded from: classes.dex */
public class b implements k {

    /* renamed from: a, reason: collision with root package name */
    public PointF f8330a;

    /* renamed from: b, reason: collision with root package name */
    public k f8331b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f8332c = true;

    @Override // com.scwang.smartrefresh.layout.b.k
    public boolean a(View view) {
        k kVar = this.f8331b;
        return kVar != null ? kVar.a(view) : d.a(view, this.f8330a);
    }

    @Override // com.scwang.smartrefresh.layout.b.k
    public boolean b(View view) {
        k kVar = this.f8331b;
        return kVar != null ? kVar.b(view) : d.a(view, this.f8330a, this.f8332c);
    }
}
