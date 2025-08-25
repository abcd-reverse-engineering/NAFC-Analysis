package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class ChatDetailBean extends BaseBean {
    private Long caseInfoID;
    private Long conversationID;
    private Integer conversationType;
    private String conversationTypeText;
    private long duration;
    private String fileName;
    private long fileSize;
    private Long id;
    private String localPath;
    private long progress;
    private long total;
    private int type;

    public Long getCaseInfoID() {
        return this.caseInfoID;
    }

    public Long getConversationID() {
        return this.conversationID;
    }

    public Integer getConversationType() {
        return this.conversationType;
    }

    public String getConversationTypeText() {
        return this.conversationTypeText;
    }

    public long getDuration() {
        return this.duration;
    }

    public String getFileName() {
        return this.fileName;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public Long getId() {
        return this.id;
    }

    public String getLocalPath() {
        return this.localPath;
    }

    public long getProgress() {
        return this.progress;
    }

    public long getTotal() {
        return this.total;
    }

    public int getType() {
        return this.type;
    }

    public void setCaseInfoID(Long l2) {
        this.caseInfoID = l2;
    }

    public void setConversationID(Long l2) {
        this.conversationID = l2;
    }

    public void setConversationType(Integer num) {
        this.conversationType = num;
    }

    public void setConversationTypeText(String str) {
        this.conversationTypeText = str;
    }

    public void setDuration(long j2) {
        this.duration = j2;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setFileSize(long j2) {
        this.fileSize = j2;
    }

    public void setId(Long l2) {
        this.id = l2;
    }

    public void setLocalPath(String str) {
        this.localPath = str;
    }

    public void setProgress(long j2) {
        this.progress = j2;
    }

    public void setTotal(long j2) {
        this.total = j2;
    }

    public void setType(int i2) {
        this.type = i2;
    }
}
