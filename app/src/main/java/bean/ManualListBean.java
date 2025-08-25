package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class ManualListBean extends BaseBean {
    private String applytime;
    private int auditstatus;
    private String documentType;
    private long id;
    private String idnumber;
    private String title;
    private String uasename;

    public String getApplytime() {
        return this.applytime;
    }

    public int getAuditstatus() {
        return this.auditstatus;
    }

    public String getDocumentType() {
        return this.documentType;
    }

    public long getId() {
        return this.id;
    }

    public String getIdnumber() {
        return this.idnumber;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUasename() {
        return this.uasename;
    }

    public void setApplytime(String str) {
        this.applytime = str;
    }

    public void setAuditstatus(int i2) {
        this.auditstatus = i2;
    }

    public void setDocumentType(String str) {
        this.documentType = str;
    }

    public void setId(long j2) {
        this.id = j2;
    }

    public void setIdnumber(String str) {
        this.idnumber = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUasename(String str) {
        this.uasename = str;
    }
}
