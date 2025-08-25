package b.a.a.d;

import android.text.TextUtils;

/* compiled from: Area.java */
/* loaded from: classes.dex */
public abstract class a extends f implements h {
    private String areaId;
    private String areaName;

    public a() {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return !TextUtils.isEmpty(this.areaId) ? this.areaId.equals(aVar.getAreaId()) : this.areaName.equals(aVar.getAreaName());
    }

    public String getAreaId() {
        return this.areaId;
    }

    public String getAreaName() {
        return this.areaName;
    }

    @Override // b.a.a.d.h
    public Object getId() {
        return this.areaId;
    }

    @Override // b.a.a.d.l
    public String getName() {
        return this.areaName;
    }

    public void setAreaId(String str) {
        this.areaId = str;
    }

    public void setAreaName(String str) {
        this.areaName = str;
    }

    @Override // b.a.a.d.f
    public String toString() {
        return "areaId=" + this.areaId + ",areaName=" + this.areaName;
    }

    public a(String str) {
        this.areaId = "";
        this.areaName = str;
    }

    public a(String str, String str2) {
        this.areaId = str;
        this.areaName = str2;
    }
}
