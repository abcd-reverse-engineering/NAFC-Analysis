package org.greenrobot.eventbus;

import java.util.ArrayList;
import java.util.List;

/* compiled from: PendingPost.java */
/* loaded from: classes2.dex */
final class j {

    /* renamed from: d, reason: collision with root package name */
    private static final List<j> f17412d = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    Object f17413a;

    /* renamed from: b, reason: collision with root package name */
    q f17414b;

    /* renamed from: c, reason: collision with root package name */
    j f17415c;

    private j(Object obj, q qVar) {
        this.f17413a = obj;
        this.f17414b = qVar;
    }

    static j a(q qVar, Object obj) {
        synchronized (f17412d) {
            int size = f17412d.size();
            if (size <= 0) {
                return new j(obj, qVar);
            }
            j jVarRemove = f17412d.remove(size - 1);
            jVarRemove.f17413a = obj;
            jVarRemove.f17414b = qVar;
            jVarRemove.f17415c = null;
            return jVarRemove;
        }
    }

    static void a(j jVar) {
        jVar.f17413a = null;
        jVar.f17414b = null;
        jVar.f17415c = null;
        synchronized (f17412d) {
            if (f17412d.size() < 10000) {
                f17412d.add(jVar);
            }
        }
    }
}
