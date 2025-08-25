package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public final class x extends m implements Cloneable {

    /* renamed from: b, reason: collision with root package name */
    static ArrayList<w> f9472b;

    /* renamed from: c, reason: collision with root package name */
    static final /* synthetic */ boolean f9473c = !x.class.desiredAssertionStatus();

    /* renamed from: a, reason: collision with root package name */
    public ArrayList<w> f9474a;

    public x() {
        this.f9474a = null;
    }

    public ArrayList<w> a() {
        return this.f9474a;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f9473c) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return n.a(this.f9474a, ((x) obj).f9474a);
    }

    public int hashCode() throws Exception {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(l lVar) {
        lVar.a((Collection) this.f9474a, 0);
    }

    public x(ArrayList<w> arrayList) {
        this.f9474a = null;
        this.f9474a = arrayList;
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(k kVar) {
        if (f9472b == null) {
            f9472b = new ArrayList<>();
            f9472b.add(new w());
        }
        this.f9474a = (ArrayList) kVar.a((k) f9472b, 0, true);
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(StringBuilder sb, int i2) {
        new i(sb, i2).a((Collection) this.f9474a, com.umeng.analytics.pro.d.ar);
    }
}
