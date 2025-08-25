package network.account;

import network.BaseBean;

/* loaded from: classes2.dex */
public class RegisterBody extends BaseBean {
    private String appVersion;
    private String idNumber;
    private String imei;
    private String innerversion;
    private int loginType;
    private String name;
    private int os;
    private String osVersion;
    private String pCode;
    private String password;
    private String phoneNum;
    private String policeUserID;
    private String region;
    private String requestIP;
    private String smsVerifyCode;
    private String verificationLogID;

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getIdNumber() {
        return this.idNumber;
    }

    public String getImei() {
        return this.imei;
    }

    public String getInnerversion() {
        return this.innerversion;
    }

    public int getLoginType() {
        return this.loginType;
    }

    public String getName() {
        return this.name;
    }

    public int getOs() {
        return this.os;
    }

    public String getOsVersion() {
        return this.osVersion;
    }

    public String getPassword() {
        return this.password;
    }

    public String getPhoneNum() {
        return this.phoneNum;
    }

    public String getPoliceUserID() {
        return this.policeUserID;
    }

    public String getRegion() {
        return this.region;
    }

    public String getRequestIP() {
        return this.requestIP;
    }

    public String getSmsVerifyCode() {
        return this.smsVerifyCode;
    }

    public String getVerificationLogID() {
        return this.verificationLogID;
    }

    public String getpCode() {
        return this.pCode;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public void setIdNumber(String str) {
        this.idNumber = str;
    }

    public void setImei(String str) {
        this.imei = str;
    }

    public void setInnerversion(String str) {
        this.innerversion = str;
    }

    public void setLoginType(int i2) {
        this.loginType = i2;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOs(int i2) {
        this.os = i2;
    }

    public void setOsVersion(String str) {
        this.osVersion = str;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setPhoneNum(String str) {
        this.phoneNum = str;
    }

    public void setPoliceUserID(String str) {
        this.policeUserID = str;
    }

    public void setRegion(String str) {
        this.region = str;
    }

    public void setRequestIP(String str) {
        this.requestIP = str;
    }

    public void setSmsVerifyCode(String str) {
        this.smsVerifyCode = str;
    }

    public void setVerificationLogID(String str) {
        this.verificationLogID = str;
    }

    public void setpCode(String str) {
        this.pCode = str;
    }

    public String toString() {
        return "RegisterBody{phoneNum='" + this.phoneNum + "', password='" + this.password + "', appVersion='" + this.appVersion + "', os=" + this.os + ", osVersion='" + this.osVersion + "', imei='" + this.imei + "', requestIP='" + this.requestIP + "', region='" + this.region + "'}";
    }
}
