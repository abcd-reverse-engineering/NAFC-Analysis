package com.airbnb.lottie.w.b;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CompoundTrimPathContent.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private List<t> f3645a = new ArrayList();

    void a(t tVar) {
        this.f3645a.add(tVar);
    }

    public void a(Path path) {
        for (int size = this.f3645a.size() - 1; size >= 0; size--) {
            com.airbnb.lottie.b0.h.a(path, this.f3645a.get(size));
        }
    }
}
