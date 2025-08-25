package com.airbnb.lottie.a0.l0;

import h.z2.h0;

/* compiled from: JsonScope.java */
/* loaded from: classes.dex */
final class d {

    /* renamed from: a, reason: collision with root package name */
    static final int f3363a = 1;

    /* renamed from: b, reason: collision with root package name */
    static final int f3364b = 2;

    /* renamed from: c, reason: collision with root package name */
    static final int f3365c = 3;

    /* renamed from: d, reason: collision with root package name */
    static final int f3366d = 4;

    /* renamed from: e, reason: collision with root package name */
    static final int f3367e = 5;

    /* renamed from: f, reason: collision with root package name */
    static final int f3368f = 6;

    /* renamed from: g, reason: collision with root package name */
    static final int f3369g = 7;

    /* renamed from: h, reason: collision with root package name */
    static final int f3370h = 8;

    private d() {
    }

    static String a(int i2, int[] iArr, String[] strArr, int[] iArr2) {
        StringBuilder sb = new StringBuilder();
        sb.append(h0.f16705b);
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = iArr[i3];
            if (i4 == 1 || i4 == 2) {
                sb.append('[');
                sb.append(iArr2[i3]);
                sb.append(']');
            } else if (i4 == 3 || i4 == 4 || i4 == 5) {
                sb.append('.');
                if (strArr[i3] != null) {
                    sb.append(strArr[i3]);
                }
            }
        }
        return sb.toString();
    }
}
