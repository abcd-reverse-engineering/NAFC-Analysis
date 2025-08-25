package com.airbnb.lottie.y;

/* compiled from: Marker.java */
/* loaded from: classes.dex */
public class h {

    /* renamed from: d, reason: collision with root package name */
    private static String f3832d = "\r";

    /* renamed from: a, reason: collision with root package name */
    private final String f3833a;

    /* renamed from: b, reason: collision with root package name */
    public final float f3834b;

    /* renamed from: c, reason: collision with root package name */
    public final float f3835c;

    public h(String str, float f2, float f3) {
        this.f3833a = str;
        this.f3835c = f3;
        this.f3834b = f2;
    }

    public boolean a(String str) {
        if (this.f3833a.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.f3833a.endsWith(f3832d)) {
            String str2 = this.f3833a;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
