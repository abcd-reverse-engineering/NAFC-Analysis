package com.bumptech.glide.manager;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: ActivityFragmentLifecycle.java */
/* loaded from: classes.dex */
class a implements h {

    /* renamed from: a, reason: collision with root package name */
    private final Set<i> f5069a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b, reason: collision with root package name */
    private boolean f5070b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f5071c;

    a() {
    }

    @Override // com.bumptech.glide.manager.h
    public void a(@NonNull i iVar) {
        this.f5069a.add(iVar);
        if (this.f5071c) {
            iVar.onDestroy();
        } else if (this.f5070b) {
            iVar.onStart();
        } else {
            iVar.onStop();
        }
    }

    @Override // com.bumptech.glide.manager.h
    public void b(@NonNull i iVar) {
        this.f5069a.remove(iVar);
    }

    void c() {
        this.f5070b = false;
        Iterator it = com.bumptech.glide.util.l.a(this.f5069a).iterator();
        while (it.hasNext()) {
            ((i) it.next()).onStop();
        }
    }

    void b() {
        this.f5070b = true;
        Iterator it = com.bumptech.glide.util.l.a(this.f5069a).iterator();
        while (it.hasNext()) {
            ((i) it.next()).onStart();
        }
    }

    void a() {
        this.f5071c = true;
        Iterator it = com.bumptech.glide.util.l.a(this.f5069a).iterator();
        while (it.hasNext()) {
            ((i) it.next()).onDestroy();
        }
    }
}
