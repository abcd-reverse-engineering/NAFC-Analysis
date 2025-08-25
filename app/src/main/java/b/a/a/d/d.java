package b.a.a.d;

import java.util.ArrayList;
import java.util.List;

/* compiled from: City.java */
/* loaded from: classes.dex */
public class d extends a implements i<e> {
    private List<e> counties;
    private String provinceId;

    public d() {
        this.counties = new ArrayList();
    }

    public List<e> getCounties() {
        return this.counties;
    }

    public String getProvinceId() {
        return this.provinceId;
    }

    @Override // b.a.a.d.i
    public List<e> getThirds() {
        return this.counties;
    }

    public void setCounties(List<e> list) {
        this.counties = list;
    }

    public void setProvinceId(String str) {
        this.provinceId = str;
    }

    public d(String str) {
        super(str);
        this.counties = new ArrayList();
    }

    public d(String str, String str2) {
        super(str, str2);
        this.counties = new ArrayList();
    }
}
