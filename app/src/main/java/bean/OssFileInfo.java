package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class OssFileInfo extends BaseBean {
    private String fileMd5;
    private String fileName;
    private String filePath;
    private String fileSHA1;
    private boolean isAlreadyUpload;
    private String localPath;
    private String ossUploadStatus;

    public OssFileInfo() {
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

    public String getOssUploadStatus() {
        return this.ossUploadStatus;
    }

    public boolean isAlreadyUpload() {
        return this.isAlreadyUpload;
    }

    public void setAlreadyUpload(boolean z) {
        this.isAlreadyUpload = z;
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

    public void setOssUploadStatus(String str) {
        this.ossUploadStatus = str;
    }

    public void toClear() {
        this.filePath = "";
        this.fileMd5 = "";
        this.fileSHA1 = "";
        this.localPath = "";
        this.isAlreadyUpload = false;
        this.ossUploadStatus = "";
    }

    public OssFileInfo(String str) {
        this.localPath = str;
    }
}
