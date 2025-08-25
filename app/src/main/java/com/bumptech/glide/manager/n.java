package com.bumptech.glide.manager;

import androidx.annotation.NonNull;
import com.bumptech.glide.r.l.p;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: TargetTracker.java */
/* loaded from: classes.dex */
public final class n implements i {

    /* renamed from: a, reason: collision with root package name */
    private final Set<p<?>> f5098a = Collections.newSetFromMap(new WeakHashMap());

    public void a(@NonNull p<?> pVar) {
        this.f5098a.add(pVar);
    }

    public void b(@NonNull p<?> pVar) {
        this.f5098a.remove(pVar);
    }

    @NonNull
    public List<p<?>> c() {
        return com.bumptech.glide.util.l.a(this.f5098a);
    }

    @Override // com.bumptech.glide.manager.i
    public void onDestroy() {
        Iterator it = com.bumptech.glide.util.l.a(this.f5098a).iterator();
        while (it.hasNext()) {
            ((p) it.next()).onDestroy();
        }
    }

    @Override // com.bumptech.glide.manager.i
    public void onStart() {
        Iterator it = com.bumptech.glide.util.l.a(this.f5098a).iterator();
        while (it.hasNext()) {
            ((p) it.next()).onStart();
        }
    }

    @Override // com.bumptech.glide.manager.i
    public void onStop() {
        Iterator it = com.bumptech.glide.util.l.a(this.f5098a).iterator();
        while (it.hasNext()) {
            ((p) it.next()).onStop();
        }
    }

    public void b() {
        this.f5098a.clear();
    }
}
