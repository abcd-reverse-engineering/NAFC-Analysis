package com.bumptech.glide.load.q;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: LazyHeaders.java */
/* loaded from: classes.dex */
public final class j implements h {

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, List<i>> f4726c;

    /* renamed from: d, reason: collision with root package name */
    private volatile Map<String, String> f4727d;

    /* compiled from: LazyHeaders.java */
    public static final class a {

        /* renamed from: d, reason: collision with root package name */
        private static final String f4728d = "User-Agent";

        /* renamed from: e, reason: collision with root package name */
        private static final String f4729e = d();

        /* renamed from: f, reason: collision with root package name */
        private static final Map<String, List<i>> f4730f;

        /* renamed from: a, reason: collision with root package name */
        private boolean f4731a = true;

        /* renamed from: b, reason: collision with root package name */
        private Map<String, List<i>> f4732b = f4730f;

        /* renamed from: c, reason: collision with root package name */
        private boolean f4733c = true;

        static {
            HashMap map = new HashMap(2);
            if (!TextUtils.isEmpty(f4729e)) {
                map.put("User-Agent", Collections.singletonList(new b(f4729e)));
            }
            f4730f = Collections.unmodifiableMap(map);
        }

        private void c() {
            if (this.f4731a) {
                this.f4731a = false;
                this.f4732b = b();
            }
        }

        @VisibleForTesting
        static String d() {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            int length = property.length();
            StringBuilder sb = new StringBuilder(property.length());
            for (int i2 = 0; i2 < length; i2++) {
                char cCharAt = property.charAt(i2);
                if ((cCharAt > 31 || cCharAt == '\t') && cCharAt < 127) {
                    sb.append(cCharAt);
                } else {
                    sb.append('?');
                }
            }
            return sb.toString();
        }

        public a a(@NonNull String str, @NonNull String str2) {
            return a(str, new b(str2));
        }

        public a b(@NonNull String str, @Nullable String str2) {
            return b(str, str2 == null ? null : new b(str2));
        }

        public a a(@NonNull String str, @NonNull i iVar) {
            if (this.f4733c && "User-Agent".equalsIgnoreCase(str)) {
                return b(str, iVar);
            }
            c();
            a(str).add(iVar);
            return this;
        }

        public a b(@NonNull String str, @Nullable i iVar) {
            c();
            if (iVar == null) {
                this.f4732b.remove(str);
            } else {
                List<i> listA = a(str);
                listA.clear();
                listA.add(iVar);
            }
            if (this.f4733c && "User-Agent".equalsIgnoreCase(str)) {
                this.f4733c = false;
            }
            return this;
        }

        private List<i> a(String str) {
            List<i> list = this.f4732b.get(str);
            if (list != null) {
                return list;
            }
            ArrayList arrayList = new ArrayList();
            this.f4732b.put(str, arrayList);
            return arrayList;
        }

        private Map<String, List<i>> b() {
            HashMap map = new HashMap(this.f4732b.size());
            for (Map.Entry<String, List<i>> entry : this.f4732b.entrySet()) {
                map.put(entry.getKey(), new ArrayList(entry.getValue()));
            }
            return map;
        }

        public j a() {
            this.f4731a = true;
            return new j(this.f4732b);
        }
    }

    /* compiled from: LazyHeaders.java */
    static final class b implements i {

        /* renamed from: a, reason: collision with root package name */
        @NonNull
        private final String f4734a;

        b(@NonNull String str) {
            this.f4734a = str;
        }

        @Override // com.bumptech.glide.load.q.i
        public String a() {
            return this.f4734a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.f4734a.equals(((b) obj).f4734a);
            }
            return false;
        }

        public int hashCode() {
            return this.f4734a.hashCode();
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.f4734a + "'}";
        }
    }

    j(Map<String, List<i>> map) {
        this.f4726c = Collections.unmodifiableMap(map);
    }

    private Map<String, String> b() {
        HashMap map = new HashMap();
        for (Map.Entry<String, List<i>> entry : this.f4726c.entrySet()) {
            String strA = a(entry.getValue());
            if (!TextUtils.isEmpty(strA)) {
                map.put(entry.getKey(), strA);
            }
        }
        return map;
    }

    @Override // com.bumptech.glide.load.q.h
    public Map<String, String> a() {
        if (this.f4727d == null) {
            synchronized (this) {
                if (this.f4727d == null) {
                    this.f4727d = Collections.unmodifiableMap(b());
                }
            }
        }
        return this.f4727d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof j) {
            return this.f4726c.equals(((j) obj).f4726c);
        }
        return false;
    }

    public int hashCode() {
        return this.f4726c.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.f4726c + '}';
    }

    @NonNull
    private String a(@NonNull List<i> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            String strA = list.get(i2).a();
            if (!TextUtils.isEmpty(strA)) {
                sb.append(strA);
                if (i2 != list.size() - 1) {
                    sb.append(',');
                }
            }
        }
        return sb.toString();
    }
}
