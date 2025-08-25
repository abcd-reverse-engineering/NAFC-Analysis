package com.chad.library.adapter.base.b;

import java.util.ArrayList;
import java.util.List;

/* compiled from: AbstractExpandableItem.java */
/* loaded from: classes.dex */
public abstract class a<T> implements b<T> {

    /* renamed from: a, reason: collision with root package name */
    protected boolean f5450a = false;

    /* renamed from: b, reason: collision with root package name */
    protected List<T> f5451b;

    @Override // com.chad.library.adapter.base.b.b
    public List<T> a() {
        return this.f5451b;
    }

    public boolean b(T t) {
        List<T> list = this.f5451b;
        return list != null && list.contains(t);
    }

    public boolean c() {
        List<T> list = this.f5451b;
        return list != null && list.size() > 0;
    }

    public boolean d(T t) {
        List<T> list = this.f5451b;
        return list != null && list.remove(t);
    }

    @Override // com.chad.library.adapter.base.b.b
    public boolean isExpanded() {
        return this.f5450a;
    }

    @Override // com.chad.library.adapter.base.b.b
    public void setExpanded(boolean z) {
        this.f5450a = z;
    }

    public void a(List<T> list) {
        this.f5451b = list;
    }

    public boolean b(int i2) {
        List<T> list = this.f5451b;
        if (list == null || i2 < 0 || i2 >= list.size()) {
            return false;
        }
        this.f5451b.remove(i2);
        return true;
    }

    public int c(T t) {
        List<T> list = this.f5451b;
        if (list != null) {
            return list.indexOf(t);
        }
        return -1;
    }

    public T a(int i2) {
        if (!c() || i2 >= this.f5451b.size()) {
            return null;
        }
        return this.f5451b.get(i2);
    }

    public void a(T t) {
        if (this.f5451b == null) {
            this.f5451b = new ArrayList();
        }
        this.f5451b.add(t);
    }

    public void a(int i2, T t) {
        List<T> list = this.f5451b;
        if (list != null && i2 >= 0 && i2 < list.size()) {
            this.f5451b.add(i2, t);
        } else {
            a((a<T>) t);
        }
    }
}
