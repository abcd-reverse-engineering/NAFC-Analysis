package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class DeviceInfoBean extends BaseBean {
    private DeviceBean androidExtra;
    private String currentType;
    private String ip;

    public DeviceBean getAndroidExtra() {
        return this.androidExtra;
    }

    public String getCurrentType() {
        return this.currentType;
    }

    public String getIp() {
        return this.ip;
    }

    public void setAndroidExtra(DeviceBean deviceBean) {
        this.androidExtra = deviceBean;
    }

    public void setCurrentType(String str) {
        this.currentType = str;
    }

    public void setIp(String str) {
        this.ip = str;
    }
}
