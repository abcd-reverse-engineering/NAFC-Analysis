package com.zhy.view.flowlayout;

import android.view.View;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: TagAdapter.java */
/* loaded from: classes2.dex */
public abstract class b<T> {

    /* renamed from: a, reason: collision with root package name */
    private List<T> f13512a;

    /* renamed from: b, reason: collision with root package name */
    private a f13513b;

    /* renamed from: c, reason: collision with root package name */
    @Deprecated
    private HashSet<Integer> f13514c = new HashSet<>();

    /* compiled from: TagAdapter.java */
    interface a {
        void a();
    }

    public b(List<T> list) {
        this.f13512a = list;
    }

    public abstract View a(FlowLayout flowLayout, int i2, T t);

    @Deprecated
    public void a(int... iArr) {
        HashSet hashSet = new HashSet();
        for (int i2 : iArr) {
            hashSet.add(Integer.valueOf(i2));
        }
        a(hashSet);
    }

    public boolean a(int i2, T t) {
        return false;
    }

    @Deprecated
    HashSet<Integer> b() {
        return this.f13514c;
    }

    public void c() {
        a aVar = this.f13513b;
        if (aVar != null) {
            aVar.a();
        }
    }

    void setOnDataChangedListener(a aVar) {
        this.f13513b = aVar;
    }

    public void b(int i2, View view) {
        String str = "unSelected " + i2;
    }

    @Deprecated
    public b(T[] tArr) {
        this.f13512a = new ArrayList(Arrays.asList(tArr));
    }

    @Deprecated
    public void a(Set<Integer> set) {
        this.f13514c.clear();
        if (set != null) {
            this.f13514c.addAll(set);
        }
        c();
    }

    public int a() {
        List<T> list = this.f13512a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public T a(int i2) {
        return this.f13512a.get(i2);
    }

    public void a(int i2, View view) {
        String str = "onSelected " + i2;
    }
}
