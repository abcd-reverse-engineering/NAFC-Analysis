package bean;

/* loaded from: classes.dex */
public class BlockFileBean extends OssFileInfo {
    private String fileID;
    private String fileMD5;
    private String fileSize;

    public String getFileID() {
        return this.fileID;
    }

    public String getFileMD5() {
        return this.fileMD5;
    }

    public String getFileSize() {
        return this.fileSize;
    }

    public void setFileID(String str) {
        this.fileID = str;
    }

    public void setFileMD5(String str) {
        this.fileMD5 = str;
    }

    public void setFileSize(String str) {
        this.fileSize = str;
    }
}
