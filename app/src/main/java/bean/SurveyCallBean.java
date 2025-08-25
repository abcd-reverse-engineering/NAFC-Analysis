package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class SurveyCallBean extends BaseBean {
    private long callDuration;
    private String caseInfoID;
    private String description;
    private String fileName;
    private long fileSize;
    private String id;
    private String localPath;
    private long progress;
    private String startTime;
    private int status = 9;
    private String telAudioFileID;
    private String telAudioFileName;
    private String telNumber;
    private long total;

    public long getCallDuration() {
        return this.callDuration;
    }

    public String getCaseInfoID() {
        return this.caseInfoID;
    }

    public String getDescription() {
        return this.description;
    }

    public String getFileName() {
        return this.fileName;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public String getId() {
        return this.id;
    }

    public String getLocalPath() {
        return this.localPath;
    }

    public long getProgress() {
        return this.progress;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public int getStatus() {
        return this.status;
    }

    public String getTelAudioFileID() {
        return this.telAudioFileID;
    }

    public String getTelAudioFileName() {
        return this.telAudioFileName;
    }

    public String getTelNumber() {
        return this.telNumber;
    }

    public long getTotal() {
        return this.total;
    }

    public void setCallDuration(long j2) {
        this.callDuration = j2;
    }

    public void setCaseInfoID(String str) {
        this.caseInfoID = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setFileSize(long j2) {
        this.fileSize = j2;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setLocalPath(String str) {
        this.localPath = str;
    }

    public void setProgress(long j2) {
        this.progress = j2;
    }

    public void setStartTime(String str) {
        this.startTime = str;
    }

    public void setStatus(int i2) {
        this.status = i2;
    }

    public void setTelAudioFileID(String str) {
        this.telAudioFileID = str;
    }

    public void setTelAudioFileName(String str) {
        this.telAudioFileName = str;
    }

    public void setTelNumber(String str) {
        this.telNumber = str;
    }

    public void setTotal(long j2) {
        this.total = j2;
    }
}
