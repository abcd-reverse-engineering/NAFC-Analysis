package com.airbnb.lottie;

import androidx.collection.ArraySet;
import androidx.core.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: PerformanceTracker.java */
/* loaded from: classes.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    private boolean f3620a = false;

    /* renamed from: b, reason: collision with root package name */
    private final Set<b> f3621b = new ArraySet();

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, com.airbnb.lottie.b0.f> f3622c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private final Comparator<Pair<String, Float>> f3623d = new a();

    /* compiled from: PerformanceTracker.java */
    class a implements Comparator<Pair<String, Float>> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Pair<String, Float> pair, Pair<String, Float> pair2) {
            float fFloatValue = pair.second.floatValue();
            float fFloatValue2 = pair2.second.floatValue();
            if (fFloatValue2 > fFloatValue) {
                return 1;
            }
            return fFloatValue > fFloatValue2 ? -1 : 0;
        }
    }

    /* compiled from: PerformanceTracker.java */
    public interface b {
        void a(float f2);
    }

    void a(boolean z) {
        this.f3620a = z;
    }

    public void b(b bVar) {
        this.f3621b.remove(bVar);
    }

    public void c() {
        if (this.f3620a) {
            List<Pair<String, Float>> listB = b();
            for (int i2 = 0; i2 < listB.size(); i2++) {
                Pair<String, Float> pair = listB.get(i2);
                String.format("\t\t%30s:%.2f", pair.first, pair.second);
            }
        }
    }

    public void a(String str, float f2) {
        if (this.f3620a) {
            com.airbnb.lottie.b0.f fVar = this.f3622c.get(str);
            if (fVar == null) {
                fVar = new com.airbnb.lottie.b0.f();
                this.f3622c.put(str, fVar);
            }
            fVar.a(f2);
            if (str.equals("__container")) {
                Iterator<b> it = this.f3621b.iterator();
                while (it.hasNext()) {
                    it.next().a(f2);
                }
            }
        }
    }

    public List<Pair<String, Float>> b() {
        if (!this.f3620a) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(this.f3622c.size());
        for (Map.Entry<String, com.airbnb.lottie.b0.f> entry : this.f3622c.entrySet()) {
            arrayList.add(new Pair(entry.getKey(), Float.valueOf(entry.getValue().a())));
        }
        Collections.sort(arrayList, this.f3623d);
        return arrayList;
    }

    public void a(b bVar) {
        this.f3621b.add(bVar);
    }

    public void a() {
        this.f3622c.clear();
    }
}
