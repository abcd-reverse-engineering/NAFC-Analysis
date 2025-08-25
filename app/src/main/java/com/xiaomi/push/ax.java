package com.xiaomi.push;

import java.util.LinkedList;

/* loaded from: classes2.dex */
public class ax {

    /* renamed from: a, reason: collision with root package name */
    private LinkedList<a> f12470a = new LinkedList<>();

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final ax f12471a = new ax();

        /* renamed from: a, reason: collision with other field name */
        public int f201a;

        /* renamed from: a, reason: collision with other field name */
        public Object f202a;

        /* renamed from: a, reason: collision with other field name */
        public String f203a;

        a(int i2, Object obj) {
            this.f201a = i2;
            this.f202a = obj;
        }
    }

    public static ax a() {
        return a.f12471a;
    }

    public synchronized void a(Object obj) {
        this.f12470a.add(new a(0, obj));
        m158a();
    }

    /* renamed from: a, reason: collision with other method in class */
    private void m158a() {
        if (this.f12470a.size() > 100) {
            this.f12470a.removeFirst();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized int m159a() {
        return this.f12470a.size();
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized LinkedList<a> m160a() {
        LinkedList<a> linkedList;
        linkedList = this.f12470a;
        this.f12470a = new LinkedList<>();
        return linkedList;
    }
}
