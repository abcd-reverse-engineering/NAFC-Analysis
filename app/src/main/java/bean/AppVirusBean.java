package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class AppVirusBean extends BaseBean {
    private String appName;
    private String fileMd5;
    private String filePath;
    private String findTime;
    private String illegalType;
    private String ipAddress;
    private String pkgName;
    private String signHash;
    private String signMD5;
    private String signSha1;
    private String signSha256;
    private String useMobileNumber;
    private String versionCode;
    private String virusDescription;
    private int virusLevel;
    private String virusName;
    private int warningType;

    public String getAppName() {
        return this.appName;
    }

    public String getFileMd5() {
        return this.fileMd5;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public String getFindTime() {
        return this.findTime;
    }

    public String getIllegalType() {
        return this.illegalType;
    }

    public String getIpAddress() {
        return this.ipAddress;
    }

    public String getPkgName() {
        return this.pkgName;
    }

    public String getSignHash() {
        return this.signHash;
    }

    public String getSignMD5() {
        return this.signMD5;
    }

    public String getSignSha1() {
        return this.signSha1;
    }

    public String getSignSha256() {
        return this.signSha256;
    }

    public String getUseMobileNumber() {
        return this.useMobileNumber;
    }

    public String getVersionCode() {
        return this.versionCode;
    }

    public String getVirusDescription() {
        return this.virusDescription;
    }

    public int getVirusLevel() {
        return this.virusLevel;
    }

    public String getVirusName() {
        return this.virusName;
    }

    public int getWarningType() {
        return this.warningType;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setFileMd5(String str) {
        this.fileMd5 = str;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public void setFindTime(String str) {
        this.findTime = str;
    }

    public void setIllegalType(String str) {
        this.illegalType = str;
    }

    public void setIpAddress(String str) {
        this.ipAddress = str;
    }

    public void setPkgName(String str) {
        this.pkgName = str;
    }

    public void setSignHash(String str) {
        this.signHash = str;
    }

    public void setSignMD5(String str) {
        this.signMD5 = str;
    }

    public void setSignSha1(String str) {
        this.signSha1 = str;
    }

    public void setSignSha256(String str) {
        this.signSha256 = str;
    }

    public void setUseMobileNumber(String str) {
        this.useMobileNumber = str;
    }

    public void setVersionCode(String str) {
        this.versionCode = str;
    }

    public void setVirusDescription(String str) {
        this.virusDescription = str;
    }

    public void setVirusLevel(int i2) {
        this.virusLevel = i2;
    }

    public void setVirusName(String str) {
        this.virusName = str;
    }

    public void setWarningType(int i2) {
        this.warningType = i2;
    }
}
