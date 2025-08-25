package com.bumptech.glide.r.m;

import android.view.View;
import com.bumptech.glide.r.m.f;

/* compiled from: ViewPropertyTransition.java */
/* loaded from: classes.dex */
public class j<R> implements f<R> {

    /* renamed from: a, reason: collision with root package name */
    private final a f5344a;

    /* compiled from: ViewPropertyTransition.java */
    public interface a {
        void a(View view);
    }

    public j(a aVar) {
        this.f5344a = aVar;
    }

    @Override // com.bumptech.glide.r.m.f
    public boolean a(R r, f.a aVar) {
        if (aVar.getView() == null) {
            return false;
        }
        this.f5344a.a(aVar.getView());
        return false;
    }
}
