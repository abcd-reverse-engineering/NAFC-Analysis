package com.bumptech.glide.manager;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: RequestTracker.java */
/* loaded from: classes.dex */
public class m {

    /* renamed from: d, reason: collision with root package name */
    private static final String f5094d = "RequestTracker";

    /* renamed from: a, reason: collision with root package name */
    private final Set<com.bumptech.glide.r.d> f5095a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b, reason: collision with root package name */
    private final List<com.bumptech.glide.r.d> f5096b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private boolean f5097c;

    @VisibleForTesting
    void a(com.bumptech.glide.r.d dVar) {
        this.f5095a.add(dVar);
    }

    public boolean b(@Nullable com.bumptech.glide.r.d dVar) {
        boolean z = true;
        if (dVar == null) {
            return true;
        }
        boolean zRemove = this.f5095a.remove(dVar);
        if (!this.f5096b.remove(dVar) && !zRemove) {
            z = false;
        }
        if (z) {
            dVar.clear();
        }
        return z;
    }

    public void c(@NonNull com.bumptech.glide.r.d dVar) {
        this.f5095a.add(dVar);
        if (!this.f5097c) {
            dVar.c();
            return;
        }
        dVar.clear();
        Log.isLoggable(f5094d, 2);
        this.f5096b.add(dVar);
    }

    public void d() {
        this.f5097c = true;
        for (com.bumptech.glide.r.d dVar : com.bumptech.glide.util.l.a(this.f5095a)) {
            if (dVar.isRunning()) {
                dVar.pause();
                this.f5096b.add(dVar);
            }
        }
    }

    public void e() {
        for (com.bumptech.glide.r.d dVar : com.bumptech.glide.util.l.a(this.f5095a)) {
            if (!dVar.d() && !dVar.b()) {
                dVar.clear();
                if (this.f5097c) {
                    this.f5096b.add(dVar);
                } else {
                    dVar.c();
                }
            }
        }
    }

    public void f() {
        this.f5097c = false;
        for (com.bumptech.glide.r.d dVar : com.bumptech.glide.util.l.a(this.f5095a)) {
            if (!dVar.d() && !dVar.isRunning()) {
                dVar.c();
            }
        }
        this.f5096b.clear();
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.f5095a.size() + ", isPaused=" + this.f5097c + "}";
    }

    public void a() {
        Iterator it = com.bumptech.glide.util.l.a(this.f5095a).iterator();
        while (it.hasNext()) {
            b((com.bumptech.glide.r.d) it.next());
        }
        this.f5096b.clear();
    }

    public boolean b() {
        return this.f5097c;
    }

    public void c() {
        this.f5097c = true;
        for (com.bumptech.glide.r.d dVar : com.bumptech.glide.util.l.a(this.f5095a)) {
            if (dVar.isRunning() || dVar.d()) {
                dVar.clear();
                this.f5096b.add(dVar);
            }
        }
    }
}
