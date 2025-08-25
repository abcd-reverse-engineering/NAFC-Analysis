package network;

import util.q1;

/* loaded from: classes2.dex */
public class HelpUploadInfo extends BaseBean {
    private String fileID;
    private String fileName;
    private int fileStatus;
    private int heartTimes = -1;
    private String networkG = q1.a();
    private String networkType = q1.e();
    private int source;
    private String sourceID;
    private int status;

    public String getFileID() {
        return this.fileID;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int getFileStatus() {
        return this.fileStatus;
    }

    public int getHeartTimes() {
        return this.heartTimes;
    }

    public int getSource() {
        return this.source;
    }

    public String getSourceID() {
        return this.sourceID;
    }

    public int getStatus() {
        return this.status;
    }

    public void setFileID(String str) {
        this.fileID = str;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setFileStatus(int i2) {
        this.fileStatus = i2;
    }

    public void setHeartTimes(int i2) {
        this.heartTimes = i2;
    }

    public void setSource(int i2) {
        this.source = i2;
    }

    public void setSourceID(String str) {
        this.sourceID = str;
    }

    public void setStatus(int i2) {
        this.status = i2;
    }
}
