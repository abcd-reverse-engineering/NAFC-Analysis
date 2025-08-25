package com.umeng.analytics.pro;

import com.umeng.analytics.pro.cj;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/* compiled from: TSerializer.java */
/* loaded from: classes2.dex */
public class bz {

    /* renamed from: a, reason: collision with root package name */
    private final ByteArrayOutputStream f10202a;

    /* renamed from: b, reason: collision with root package name */
    private final db f10203b;

    /* renamed from: c, reason: collision with root package name */
    private cp f10204c;

    public bz() {
        this(new cj.a());
    }

    public byte[] a(bq bqVar) throws bw {
        this.f10202a.reset();
        bqVar.write(this.f10204c);
        return this.f10202a.toByteArray();
    }

    public String b(bq bqVar) throws bw {
        return new String(a(bqVar));
    }

    public bz(cr crVar) {
        this.f10202a = new ByteArrayOutputStream();
        this.f10203b = new db(this.f10202a);
        this.f10204c = crVar.a(this.f10203b);
    }

    public String a(bq bqVar, String str) throws bw {
        try {
            return new String(a(bqVar), str);
        } catch (UnsupportedEncodingException unused) {
            throw new bw("JVM DOES NOT SUPPORT ENCODING: " + str);
        }
    }
}
