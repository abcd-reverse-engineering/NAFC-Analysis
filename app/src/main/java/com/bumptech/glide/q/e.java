package com.bumptech.glide.q;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: ResourceDecoderRegistry.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final List<String> f5204a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, List<a<?, ?>>> f5205b = new HashMap();

    /* compiled from: ResourceDecoderRegistry.java */
    private static class a<T, R> {

        /* renamed from: a, reason: collision with root package name */
        private final Class<T> f5206a;

        /* renamed from: b, reason: collision with root package name */
        final Class<R> f5207b;

        /* renamed from: c, reason: collision with root package name */
        final l<T, R> f5208c;

        public a(@NonNull Class<T> cls, @NonNull Class<R> cls2, l<T, R> lVar) {
            this.f5206a = cls;
            this.f5207b = cls2;
            this.f5208c = lVar;
        }

        public boolean a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return this.f5206a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f5207b);
        }
    }

    public synchronized void a(@NonNull List<String> list) {
        ArrayList<String> arrayList = new ArrayList(this.f5204a);
        this.f5204a.clear();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            this.f5204a.add(it.next());
        }
        for (String str : arrayList) {
            if (!list.contains(str)) {
                this.f5204a.add(str);
            }
        }
    }

    @NonNull
    public synchronized <T, R> List<Class<R>> b(@NonNull Class<T> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<String> it = this.f5204a.iterator();
        while (it.hasNext()) {
            List<a<?, ?>> list = this.f5205b.get(it.next());
            if (list != null) {
                for (a<?, ?> aVar : list) {
                    if (aVar.a(cls, cls2) && !arrayList.contains(aVar.f5207b)) {
                        arrayList.add(aVar.f5207b);
                    }
                }
            }
        }
        return arrayList;
    }

    @NonNull
    public synchronized <T, R> List<l<T, R>> a(@NonNull Class<T> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<String> it = this.f5204a.iterator();
        while (it.hasNext()) {
            List<a<?, ?>> list = this.f5205b.get(it.next());
            if (list != null) {
                for (a<?, ?> aVar : list) {
                    if (aVar.a(cls, cls2)) {
                        arrayList.add(aVar.f5208c);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized <T, R> void b(@NonNull String str, @NonNull l<T, R> lVar, @NonNull Class<T> cls, @NonNull Class<R> cls2) {
        a(str).add(0, new a<>(cls, cls2, lVar));
    }

    public synchronized <T, R> void a(@NonNull String str, @NonNull l<T, R> lVar, @NonNull Class<T> cls, @NonNull Class<R> cls2) {
        a(str).add(new a<>(cls, cls2, lVar));
    }

    @NonNull
    private synchronized List<a<?, ?>> a(@NonNull String str) {
        List<a<?, ?>> arrayList;
        if (!this.f5204a.contains(str)) {
            this.f5204a.add(str);
        }
        arrayList = this.f5205b.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.f5205b.put(str, arrayList);
        }
        return arrayList;
    }
}
