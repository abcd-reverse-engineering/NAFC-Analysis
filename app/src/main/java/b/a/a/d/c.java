package b.a.a.d;

/* compiled from: CarNumberProvince.java */
/* loaded from: classes.dex */
public class c implements g<b> {
    private String name;

    public c(String str) {
        this.name = str;
    }

    @Override // b.a.a.d.g, b.a.a.d.h
    public Object getId() {
        return this.name;
    }

    @Override // b.a.a.d.l
    public String getName() {
        return this.name;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0193  */
    @Override // b.a.a.d.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<b.a.a.d.b> getSeconds() {
        /*
            Method dump skipped, instructions count: 1724
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: b.a.a.d.c.getSeconds():java.util.List");
    }

    public String toString() {
        return "name=" + this.name;
    }
}
