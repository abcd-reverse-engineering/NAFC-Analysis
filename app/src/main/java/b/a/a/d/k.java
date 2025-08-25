package b.a.a.d;

import java.util.ArrayList;
import java.util.List;

/* compiled from: Province.java */
/* loaded from: classes.dex */
public class k extends a implements g<d> {
    private List<d> cities;

    public k() {
        this.cities = new ArrayList();
    }

    public List<d> getCities() {
        return this.cities;
    }

    @Override // b.a.a.d.g
    public List<d> getSeconds() {
        return this.cities;
    }

    public void setCities(List<d> list) {
        this.cities = list;
    }

    public k(String str) {
        super(str);
        this.cities = new ArrayList();
    }

    public k(String str, String str2) {
        super(str, str2);
        this.cities = new ArrayList();
    }
}
