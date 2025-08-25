package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class CriminalSocialFileBean extends BaseBean {
    private String fileMd5;
    private String fileName;
    private String filePath;
    private String fileSHA1;
    private String localPath;
    private String netAccountDetailInfoID;

    public CriminalSocialFileBean() {
    }

    public String getFileMd5() {
        return this.fileMd5;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public String getFileSHA1() {
        return this.fileSHA1;
    }

    public String getLocalPath() {
        return this.localPath;
    }

    public String getNetAccountDetailInfoID() {
        return this.netAccountDetailInfoID;
    }

    public void setFileMd5(String str) {
        this.fileMd5 = str;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public void setFileSHA1(String str) {
        this.fileSHA1 = str;
    }

    public void setLocalPath(String str) {
        this.localPath = str;
    }

    public void setNetAccountDetailInfoID(String str) {
        this.netAccountDetailInfoID = str;
    }

    public CriminalSocialFileBean(String str, String str2, String str3, String str4) {
        this.localPath = str;
        this.filePath = str2;
        this.fileMd5 = str3;
        this.fileSHA1 = str4;
    }
}
