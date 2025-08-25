package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class TransferFileBean extends BaseBean {
    public static final int TRANSFER_FILE_TYPE_1 = 1;
    public static final int TRANSFER_FILE_TYPE_2 = 2;
    private String fileName;
    private Long id;
    private String localPath;
    private Long transferRecordID;
    private int type;

    public String getFileName() {
        return this.fileName;
    }

    public Long getId() {
        return this.id;
    }

    public String getLocalPath() {
        return this.localPath;
    }

    public Long getTransferRecordID() {
        return this.transferRecordID;
    }

    public int getType() {
        return this.type;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setId(Long l2) {
        this.id = l2;
    }

    public void setLocalPath(String str) {
        this.localPath = str;
    }

    public void setTransferRecordID(Long l2) {
        this.transferRecordID = l2;
    }

    public void setType(int i2) {
        this.type = i2;
    }
}
