package com.huawei.hms.common.size;

import com.huawei.hms.common.internal.Objects;

/* loaded from: classes.dex */
public class Size {

    /* renamed from: a, reason: collision with root package name */
    private final int f6785a;

    /* renamed from: b, reason: collision with root package name */
    private final int f6786b;

    public Size(int i2, int i3) {
        this.f6785a = i2;
        this.f6786b = i3;
    }

    public static Size parseSize(String str) {
        try {
            int iIndexOf = str.indexOf("x");
            if (iIndexOf < 0) {
                iIndexOf = str.indexOf("*");
            }
            return new Size(Integer.parseInt(str.substring(0, iIndexOf)), Integer.parseInt(str.substring(iIndexOf + 1)));
        } catch (Exception unused) {
            throw new IllegalArgumentException("Size parses failed");
        }
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Size)) {
            return false;
        }
        Size size = (Size) obj;
        return this.f6785a == size.f6785a && this.f6786b == size.f6786b;
    }

    public final int getHeight() {
        return this.f6786b;
    }

    public final int getWidth() {
        return this.f6785a;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(getWidth()), Integer.valueOf(getHeight()));
    }

    public final String toString() {
        return "Width is " + this.f6785a + " Height is " + this.f6786b;
    }
}
