package c.b.c.d0.a0.g;

import java.util.ArrayList;
import java.util.List;

/* compiled from: ExpandedRow.java */
/* loaded from: classes.dex */
final class c {

    /* renamed from: a, reason: collision with root package name */
    private final List<b> f2481a;

    /* renamed from: b, reason: collision with root package name */
    private final int f2482b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f2483c;

    c(List<b> list, int i2, boolean z) {
        this.f2481a = new ArrayList(list);
        this.f2482b = i2;
        this.f2483c = z;
    }

    List<b> a() {
        return this.f2481a;
    }

    int b() {
        return this.f2482b;
    }

    boolean c() {
        return this.f2483c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f2481a.equals(cVar.a()) && this.f2483c == cVar.f2483c;
    }

    public int hashCode() {
        return this.f2481a.hashCode() ^ Boolean.valueOf(this.f2483c).hashCode();
    }

    public String toString() {
        return "{ " + this.f2481a + " }";
    }

    boolean a(List<b> list) {
        return this.f2481a.equals(list);
    }
}
