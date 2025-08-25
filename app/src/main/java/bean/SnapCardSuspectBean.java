package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class SnapCardSuspectBean extends BaseBean {
    private String address;
    private String addressDetail;
    private String age;
    private String caseCategory;
    private String caseCategoryText;
    private String idNumber;
    private String name;
    private String sex;

    public String getDefraudType() {
        return this.caseCategory;
    }

    public String getDupery() {
        return this.caseCategoryText;
    }

    public String getSuspAge() {
        return this.age;
    }

    public String getSuspIdnum() {
        return this.idNumber;
    }

    public String getSuspName() {
        return this.name;
    }

    public String getSuspNation() {
        return this.address;
    }

    public String getSuspRegion() {
        return this.addressDetail;
    }

    public String getSuspSex() {
        return this.sex;
    }

    public void setDefraudType(String str) {
        this.caseCategory = str;
    }

    public void setDupery(String str) {
        this.caseCategoryText = str;
    }

    public void setSuspAge(String str) {
        this.age = str;
    }

    public void setSuspIdnum(String str) {
        this.idNumber = str;
    }

    public void setSuspName(String str) {
        this.name = str;
    }

    public void setSuspNation(String str) {
        this.address = str;
    }

    public void setSuspRegion(String str) {
        this.addressDetail = str;
    }

    public void setSuspSex(String str) {
        this.sex = str;
    }
}
