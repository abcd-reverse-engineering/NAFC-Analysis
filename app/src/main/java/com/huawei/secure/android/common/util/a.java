package com.huawei.secure.android.common.util;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private String f7713a;

    /* renamed from: b, reason: collision with root package name */
    private Character f7714b;

    /* renamed from: c, reason: collision with root package name */
    private Character f7715c;

    /* renamed from: d, reason: collision with root package name */
    private int f7716d = 0;

    /* renamed from: e, reason: collision with root package name */
    private int f7717e = 0;

    public a(String str) {
        this.f7713a = str;
    }

    public static boolean c(Character ch) {
        char cCharValue;
        return ch != null && (cCharValue = ch.charValue()) >= '0' && cCharValue <= '7';
    }

    public void a(Character ch) {
        this.f7714b = ch;
    }

    public int b() {
        return this.f7716d;
    }

    public Character d() {
        Character ch = this.f7714b;
        if (ch != null) {
            this.f7714b = null;
            return ch;
        }
        String str = this.f7713a;
        if (str == null || str.length() == 0 || this.f7716d >= this.f7713a.length()) {
            return null;
        }
        String str2 = this.f7713a;
        int i2 = this.f7716d;
        this.f7716d = i2 + 1;
        return Character.valueOf(str2.charAt(i2));
    }

    public Character e() {
        Character chD = d();
        if (chD != null && b(chD)) {
            return chD;
        }
        return null;
    }

    public Character f() {
        Character chD = d();
        if (chD != null && c(chD)) {
            return chD;
        }
        return null;
    }

    public Character g() {
        Character ch = this.f7714b;
        if (ch != null) {
            return ch;
        }
        String str = this.f7713a;
        if (str == null || str.length() == 0 || this.f7716d >= this.f7713a.length()) {
            return null;
        }
        return Character.valueOf(this.f7713a.charAt(this.f7716d));
    }

    protected String h() {
        String strSubstring = this.f7713a.substring(this.f7716d);
        if (this.f7714b == null) {
            return strSubstring;
        }
        return this.f7714b + strSubstring;
    }

    public void i() {
        this.f7714b = this.f7715c;
        this.f7716d = this.f7717e;
    }

    public static boolean b(Character ch) {
        if (ch == null) {
            return false;
        }
        char cCharValue = ch.charValue();
        return (cCharValue >= '0' && cCharValue <= '9') || (cCharValue >= 'a' && cCharValue <= 'f') || (cCharValue >= 'A' && cCharValue <= 'F');
    }

    public boolean a() {
        if (this.f7714b != null) {
            return true;
        }
        String str = this.f7713a;
        return (str == null || str.length() == 0 || this.f7716d >= this.f7713a.length()) ? false : true;
    }

    public void c() {
        this.f7715c = this.f7714b;
        this.f7717e = this.f7716d;
    }

    public boolean a(char c2) {
        Character ch = this.f7714b;
        if (ch != null && ch.charValue() == c2) {
            return true;
        }
        String str = this.f7713a;
        return str != null && str.length() != 0 && this.f7716d < this.f7713a.length() && this.f7713a.charAt(this.f7716d) == c2;
    }
}
