package com.airbnb.lottie.y;

import androidx.annotation.RestrictTo;
import com.airbnb.lottie.y.k.n;
import java.util.List;

/* compiled from: FontCharacter.java */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private final List<n> f3821a;

    /* renamed from: b, reason: collision with root package name */
    private final char f3822b;

    /* renamed from: c, reason: collision with root package name */
    private final double f3823c;

    /* renamed from: d, reason: collision with root package name */
    private final double f3824d;

    /* renamed from: e, reason: collision with root package name */
    private final String f3825e;

    /* renamed from: f, reason: collision with root package name */
    private final String f3826f;

    public d(List<n> list, char c2, double d2, double d3, String str, String str2) {
        this.f3821a = list;
        this.f3822b = c2;
        this.f3823c = d2;
        this.f3824d = d3;
        this.f3825e = str;
        this.f3826f = str2;
    }

    public static int a(char c2, String str, String str2) {
        return ((((0 + c2) * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    double b() {
        return this.f3823c;
    }

    String c() {
        return this.f3825e;
    }

    public double d() {
        return this.f3824d;
    }

    public int hashCode() {
        return a(this.f3822b, this.f3826f, this.f3825e);
    }

    public List<n> a() {
        return this.f3821a;
    }
}
