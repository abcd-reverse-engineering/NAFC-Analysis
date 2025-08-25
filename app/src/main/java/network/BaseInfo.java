package network;

import manager.AccountManager;
import util.q1;
import util.v1;

/* loaded from: classes2.dex */
public class BaseInfo extends BaseBean {
    private String appVersion;
    private String imei;
    private String ip;
    private int os;
    private String osVersion;
    private String submitTime;
    private String submitterID;

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getImei() {
        return this.imei;
    }

    public String getIp() {
        return this.ip;
    }

    public int getOs() {
        return this.os;
    }

    public String getOsVersion() {
        return this.osVersion;
    }

    public String getSubmitTime() {
        return this.submitTime;
    }

    public String getSubmitterID() {
        return this.submitterID;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public void setCommonParams() {
        this.os = 0;
        this.osVersion = v1.i();
        this.imei = v1.l();
        this.submitterID = AccountManager.getAccountId();
        this.submitTime = v1.d();
        this.appVersion = v1.o();
        this.ip = q1.c();
    }

    public void setImei(String str) {
        this.imei = str;
    }

    public void setIp(String str) {
        this.ip = str;
    }

    public void setOs(int i2) {
        this.os = i2;
    }

    public void setOsVersion(String str) {
        this.osVersion = str;
    }

    public void setSubmitTime(String str) {
        this.submitTime = str;
    }

    public void setSubmitterID(String str) {
        this.submitterID = str;
    }
}
