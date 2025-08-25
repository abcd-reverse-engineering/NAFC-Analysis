package i.e.b.b.a.a;

import android.text.TextUtils;

/* loaded from: classes2.dex */
class c {

    /* renamed from: a, reason: collision with root package name */
    String f16906a;

    /* renamed from: b, reason: collision with root package name */
    Boolean f16907b;

    c() {
    }

    void a(boolean z) {
        this.f16907b = Boolean.valueOf(z);
    }

    boolean a() {
        return this.f16907b != null;
    }

    boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.equals(this.f16906a, str);
    }

    void b(String str) {
        this.f16906a = str;
    }

    boolean b() {
        Boolean bool = this.f16907b;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }
}
