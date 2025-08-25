package com.bumptech.glide.load.q;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

/* compiled from: GlideUrl.java */
/* loaded from: classes.dex */
public class g implements com.bumptech.glide.load.g {

    /* renamed from: j, reason: collision with root package name */
    private static final String f4716j = "@#&=*+-_.,:!?()/~'%;$";

    /* renamed from: c, reason: collision with root package name */
    private final h f4717c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private final URL f4718d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private final String f4719e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private String f4720f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    private URL f4721g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    private volatile byte[] f4722h;

    /* renamed from: i, reason: collision with root package name */
    private int f4723i;

    public g(URL url) {
        this(url, h.f4725b);
    }

    private byte[] e() {
        if (this.f4722h == null) {
            this.f4722h = a().getBytes(com.bumptech.glide.load.g.f4249b);
        }
        return this.f4722h;
    }

    private String f() {
        if (TextUtils.isEmpty(this.f4720f)) {
            String string = this.f4719e;
            if (TextUtils.isEmpty(string)) {
                string = ((URL) com.bumptech.glide.util.j.a(this.f4718d)).toString();
            }
            this.f4720f = Uri.encode(string, f4716j);
        }
        return this.f4720f;
    }

    private URL g() throws MalformedURLException {
        if (this.f4721g == null) {
            this.f4721g = new URL(f());
        }
        return this.f4721g;
    }

    public String a() {
        String str = this.f4719e;
        return str != null ? str : ((URL) com.bumptech.glide.util.j.a(this.f4718d)).toString();
    }

    public Map<String, String> b() {
        return this.f4717c.a();
    }

    public String c() {
        return f();
    }

    public URL d() throws MalformedURLException {
        return g();
    }

    @Override // com.bumptech.glide.load.g
    public boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return a().equals(gVar.a()) && this.f4717c.equals(gVar.f4717c);
    }

    @Override // com.bumptech.glide.load.g
    public int hashCode() {
        if (this.f4723i == 0) {
            this.f4723i = a().hashCode();
            this.f4723i = (this.f4723i * 31) + this.f4717c.hashCode();
        }
        return this.f4723i;
    }

    public String toString() {
        return a();
    }

    public g(String str) {
        this(str, h.f4725b);
    }

    @Override // com.bumptech.glide.load.g
    public void a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(e());
    }

    public g(URL url, h hVar) {
        this.f4718d = (URL) com.bumptech.glide.util.j.a(url);
        this.f4719e = null;
        this.f4717c = (h) com.bumptech.glide.util.j.a(hVar);
    }

    public g(String str, h hVar) {
        this.f4718d = null;
        this.f4719e = com.bumptech.glide.util.j.a(str);
        this.f4717c = (h) com.bumptech.glide.util.j.a(hVar);
    }
}
