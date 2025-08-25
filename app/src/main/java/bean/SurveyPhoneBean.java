package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class SurveyPhoneBean extends BaseBean {
    private String imei;
    private String mac;
    private String mobileBrand;
    private String mobileModel;
    private String mobileSys;
    private String rom;
    private String sysVersion;

    public String getImei() {
        return this.imei;
    }

    public String getMac() {
        return this.mac;
    }

    public String getMobileBrand() {
        return this.mobileBrand;
    }

    public String getMobileModel() {
        return this.mobileModel;
    }

    public String getMobileSys() {
        return this.mobileSys;
    }

    public String getRom() {
        return this.rom;
    }

    public String getSysVersion() {
        return this.sysVersion;
    }

    public void setImei(String str) {
        this.imei = str;
    }

    public void setMac(String str) {
        this.mac = str;
    }

    public void setMobileBrand(String str) {
        this.mobileBrand = str;
    }

    public void setMobileModel(String str) {
        this.mobileModel = str;
    }

    public void setMobileSys(String str) {
        this.mobileSys = str;
    }

    public void setRom(String str) {
        this.rom = str;
    }

    public void setSysVersion(String str) {
        this.sysVersion = str;
    }
}
