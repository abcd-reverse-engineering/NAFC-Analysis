package com.airbnb.lottie.y;

import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: KeyPath.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: c, reason: collision with root package name */
    public static final e f3827c = new e("COMPOSITION");

    /* renamed from: a, reason: collision with root package name */
    private final List<String> f3828a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private f f3829b;

    public e(String... strArr) {
        this.f3828a = Arrays.asList(strArr);
    }

    @CheckResult
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public e a(String str) {
        e eVar = new e(this);
        eVar.f3828a.add(str);
        return eVar;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int b(String str, int i2) {
        if (b(str)) {
            return 0;
        }
        if (this.f3828a.get(i2).equals("**")) {
            return (i2 != this.f3828a.size() - 1 && this.f3828a.get(i2 + 1).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean c(String str, int i2) {
        if (b(str)) {
            return true;
        }
        if (i2 >= this.f3828a.size()) {
            return false;
        }
        return this.f3828a.get(i2).equals(str) || this.f3828a.get(i2).equals("**") || this.f3828a.get(i2).equals("*");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean d(String str, int i2) {
        return "__container".equals(str) || i2 < this.f3828a.size() - 1 || this.f3828a.get(i2).equals("**");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KeyPath{keys=");
        sb.append(this.f3828a);
        sb.append(",resolved=");
        sb.append(this.f3829b != null);
        sb.append('}');
        return sb.toString();
    }

    private e(e eVar) {
        this.f3828a = new ArrayList(eVar.f3828a);
        this.f3829b = eVar.f3829b;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public e a(f fVar) {
        e eVar = new e(this);
        eVar.f3829b = fVar;
        return eVar;
    }

    private boolean b(String str) {
        return "__container".equals(str);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public f a() {
        return this.f3829b;
    }

    private boolean c() {
        return this.f3828a.get(r0.size() - 1).equals("**");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean a(String str, int i2) {
        if (i2 >= this.f3828a.size()) {
            return false;
        }
        boolean z = i2 == this.f3828a.size() - 1;
        String str2 = this.f3828a.get(i2);
        if (!str2.equals("**")) {
            return (z || (i2 == this.f3828a.size() + (-2) && c())) && (str2.equals(str) || str2.equals("*"));
        }
        if (!z && this.f3828a.get(i2 + 1).equals(str)) {
            return i2 == this.f3828a.size() + (-2) || (i2 == this.f3828a.size() + (-3) && c());
        }
        if (z) {
            return true;
        }
        int i3 = i2 + 1;
        if (i3 < this.f3828a.size() - 1) {
            return false;
        }
        return this.f3828a.get(i3).equals(str);
    }

    public String b() {
        return this.f3828a.toString();
    }
}
