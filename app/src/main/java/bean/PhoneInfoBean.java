package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class PhoneInfoBean extends BaseBean {
    private String areaVid;
    private String carrier;
    private String catName;
    private String ispVid;
    private String mts;
    private String province;
    private String telString;

    public String getAreaVid() {
        return this.areaVid;
    }

    public String getCarrier() {
        return this.carrier;
    }

    public String getCatName() {
        return this.catName;
    }

    public String getIspVid() {
        return this.ispVid;
    }

    public String getMts() {
        return this.mts;
    }

    public String getProvince() {
        return this.province;
    }

    public String getTelString() {
        return this.telString;
    }

    public void setAreaVid(String str) {
        this.areaVid = str;
    }

    public void setCarrier(String str) {
        this.carrier = str;
    }

    public void setCatName(String str) {
        this.catName = str;
    }

    public void setIspVid(String str) {
        this.ispVid = str;
    }

    public void setMts(String str) {
        this.mts = str;
    }

    public void setProvince(String str) {
        this.province = str;
    }

    public void setTelString(String str) {
        this.telString = str;
    }
}
