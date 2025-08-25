package bean;

import java.io.Serializable;

/* loaded from: classes.dex */
public class UploadStateInfo implements Serializable {
    private String fileId;
    private String fileMd5;
    private String fileName;
    private String filePath;
    private long fileSize;
    private boolean playState;
    private long progress;
    private long total;
    private int uploadState;

    public UploadStateInfo() {
    }

    public String getFileId() {
        return this.fileId;
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

    public long getFileSize() {
        return this.fileSize;
    }

    public long getProgress() {
        return this.progress;
    }

    public long getTotal() {
        return this.total;
    }

    public int getUploadState() {
        return this.uploadState;
    }

    public boolean isPlayState() {
        return this.playState;
    }

    public void setFileId(String str) {
        this.fileId = str;
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

    public void setFileSize(long j2) {
        this.fileSize = j2;
    }

    public void setPlayState(boolean z) {
        this.playState = z;
    }

    public void setProgress(long j2) {
        this.progress = j2;
    }

    public void setTotal(long j2) {
        this.total = j2;
    }

    public void setUploadState(int i2) {
        this.uploadState = i2;
    }

    public UploadStateInfo(long j2) {
        this.fileSize = j2;
    }
}
