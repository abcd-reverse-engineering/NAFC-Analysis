package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class BlockAppBean extends BaseBean {
    private String fileID;
    private String fileName;
    private String filePath;
    private long fileSize;
    private String fileType;
    private boolean uploadComplete;
    private String urlPath;

    public String getFileID() {
        return this.fileID;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public String getFileType() {
        return this.fileType;
    }

    public String getUrlPath() {
        return this.urlPath;
    }

    public boolean isUploadComplete() {
        return this.uploadComplete;
    }

    public void setFileID(String str) {
        this.fileID = str;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public void setFileSize(int i2) {
        this.fileSize = i2;
    }

    public void setFileType(String str) {
        this.fileType = str;
    }

    public void setUploadComplete(boolean z) {
        this.uploadComplete = z;
    }

    public void setUrlPath(String str) {
        this.urlPath = str;
    }

    public void setFileSize(long j2) {
        this.fileSize = j2;
    }
}
