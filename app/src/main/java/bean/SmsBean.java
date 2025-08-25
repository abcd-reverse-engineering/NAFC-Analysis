package bean;

import java.io.Serializable;

/* loaded from: classes.dex */
public class SmsBean implements Serializable {
    private String fileUri;
    private String id;
    private int index = -1;
    private boolean isSelect;
    private int report_type;
    private String smsContent;
    private String smsFilePath;
    private String smsNum;
    private String stringDate;
    private String type;
    private String victimTel;

    public SmsBean() {
    }

    public String getFileUri() {
        return this.fileUri;
    }

    public String getId() {
        return this.id;
    }

    public int getIndex() {
        return this.index;
    }

    public int getReport_type() {
        return this.report_type;
    }

    public String getSmsContent() {
        return this.smsContent;
    }

    public String getSmsFilePath() {
        return this.smsFilePath;
    }

    public String getSmsNum() {
        return this.smsNum;
    }

    public String getStringDate() {
        return this.stringDate;
    }

    public String getType() {
        return this.type;
    }

    public String getVictimTel() {
        return this.victimTel;
    }

    public boolean isSelect() {
        return this.isSelect;
    }

    public void setFileUri(String str) {
        this.fileUri = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setIndex(int i2) {
        this.index = i2;
    }

    public SmsBean setReport_type(int i2) {
        this.report_type = i2;
        return this;
    }

    public void setSelect(boolean z) {
        this.isSelect = z;
    }

    public void setSmsContent(String str) {
        this.smsContent = str;
    }

    public void setSmsFilePath(String str) {
        this.smsFilePath = str;
    }

    public void setSmsNum(String str) {
        this.smsNum = str;
    }

    public void setStringDate(String str) {
        this.stringDate = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setVictimTel(String str) {
        this.victimTel = str;
    }

    public SmsBean(String str, String str2, String str3, boolean z) {
        this.smsNum = str;
        this.smsContent = str2;
        this.stringDate = str3;
        this.isSelect = z;
    }
}
