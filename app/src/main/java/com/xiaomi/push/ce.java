package com.xiaomi.push;

import com.xiaomi.mipush.sdk.Constants;
import java.net.InetSocketAddress;

/* loaded from: classes2.dex */
public final class ce {

    /* renamed from: a, reason: collision with root package name */
    private int f12550a;

    /* renamed from: a, reason: collision with other field name */
    private String f253a;

    public ce(String str, int i2) {
        this.f253a = str;
        this.f12550a = i2;
    }

    public int a() {
        return this.f12550a;
    }

    public String toString() {
        if (this.f12550a <= 0) {
            return this.f253a;
        }
        return this.f253a + Constants.COLON_SEPARATOR + this.f12550a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m226a() {
        return this.f253a;
    }

    public static ce a(String str, int i2) throws NumberFormatException {
        String strSubstring;
        int iLastIndexOf = str.lastIndexOf(Constants.COLON_SEPARATOR);
        if (iLastIndexOf != -1) {
            strSubstring = str.substring(0, iLastIndexOf);
            try {
                int i3 = Integer.parseInt(str.substring(iLastIndexOf + 1));
                if (i3 > 0) {
                    i2 = i3;
                }
            } catch (NumberFormatException unused) {
            }
        } else {
            strSubstring = str;
        }
        return new ce(strSubstring, i2);
    }

    /* renamed from: a, reason: collision with other method in class */
    public static InetSocketAddress m225a(String str, int i2) throws NumberFormatException {
        ce ceVarA = a(str, i2);
        return new InetSocketAddress(ceVarA.m226a(), ceVarA.a());
    }
}
