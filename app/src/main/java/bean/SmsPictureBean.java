package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class SmsPictureBean extends BaseBean {
    private String fileMd5;
    private String fileName;
    private String filePath;
    private String fileSHA1;
    private String localPath;
    private String smsDetailID;

    public SmsPictureBean() {
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

    public String getSmsDetailID() {
        return this.smsDetailID;
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

    public void setSmsDetailID(String str) {
        this.smsDetailID = str;
    }

    public SmsPictureBean(String str, String str2, String str3, String str4) {
        this.localPath = str;
        this.filePath = str2;
        this.fileMd5 = str3;
        this.fileSHA1 = str4;
    }
}
