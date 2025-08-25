package network;

/* loaded from: classes2.dex */
public class ReportAppInfo extends BaseBean {
    private String appName;
    private String appPackage;
    private String appVersion;
    private String appVirus;
    private String fileLocalPath;
    private String fileMd5;
    private String filePath;
    private String occurTime;
    private int source;

    public String getAppName() {
        return this.appName;
    }

    public String getAppPackage() {
        return this.appPackage;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getAppVirus() {
        return this.appVirus;
    }

    public String getFileLocalPath() {
        return this.fileLocalPath;
    }

    public String getFileMd5() {
        return this.fileMd5;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public String getOccurTime() {
        return this.occurTime;
    }

    public int getSource() {
        return this.source;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setAppPackage(String str) {
        this.appPackage = str;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public void setAppVirus(String str) {
        this.appVirus = str;
    }

    public void setFileLocalPath(String str) {
        this.fileLocalPath = str;
    }

    public void setFileMd5(String str) {
        this.fileMd5 = str;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public void setOccurTime(String str) {
        this.occurTime = str;
    }

    public void setSource(int i2) {
        this.source = i2;
    }
}
