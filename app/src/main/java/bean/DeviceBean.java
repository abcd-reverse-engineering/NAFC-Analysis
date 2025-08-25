package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class DeviceBean extends BaseBean {
    private String androidSDKVersion;
    private String androidVersion;
    private String brand;
    private String imei;
    private String model;
    private String source;
    private String version;

    public String getAndroidSDKVersion() {
        return this.androidSDKVersion;
    }

    public String getAndroidVersion() {
        return this.androidVersion;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getImei() {
        return this.imei;
    }

    public String getModel() {
        return this.model;
    }

    public String getSource() {
        return this.source;
    }

    public String getVersion() {
        return this.version;
    }

    public void setAndroidSDKVersion(String str) {
        this.androidSDKVersion = str;
    }

    public void setAndroidVersion(String str) {
        this.androidVersion = str;
    }

    public void setBrand(String str) {
        this.brand = str;
    }

    public void setImei(String str) {
        this.imei = str;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
