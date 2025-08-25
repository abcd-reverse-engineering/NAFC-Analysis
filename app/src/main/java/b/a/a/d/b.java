package b.a.a.d;

import java.util.List;

/* compiled from: CarNumberCity.java */
/* loaded from: classes.dex */
public class b implements i<Void> {
    private String name;

    public b(String str) {
        this.name = str;
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            return this.name.equals(((b) obj).getName());
        }
        return false;
    }

    @Override // b.a.a.d.i, b.a.a.d.h
    public Object getId() {
        return this.name;
    }

    @Override // b.a.a.d.l
    public String getName() {
        return this.name;
    }

    @Override // b.a.a.d.i
    public List<Void> getThirds() {
        return null;
    }

    public String toString() {
        return "name=" + this.name;
    }
}
