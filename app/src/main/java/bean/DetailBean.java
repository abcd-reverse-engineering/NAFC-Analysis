package bean;

import network.BaseBean;
import network.HistoryDetailInfo;

/* loaded from: classes.dex */
public class DetailBean extends BaseBean {
    public static final int APP = 3;
    public static final int IMG = 4;
    public static final int RED = 5;
    public static final int SMS = 2;
    public static final int SOCIAL = 8;
    public static final int TEL = 1;
    public static final int TRAD = 9;
    public static final int VOID = 6;
    public static final int WEB = 7;
    private String account;
    private String accountType;
    public HistoryDetailInfo.AppInnerPicture appAuthorInfo;
    private String content;
    private String createTime;
    public HistoryDetailInfo.AppInnerPicture downloadQRCode;
    public String downloadUrl;
    private String fileName;
    private String number;
    private String occurTime;
    public int os;
    private int type;
    private String version;

    public String getAccount() {
        return this.account;
    }

    public String getAccountType() {
        return this.accountType;
    }

    public HistoryDetailInfo.AppInnerPicture getAppAuthorInfo() {
        return this.appAuthorInfo;
    }

    public String getContent() {
        return this.content;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public HistoryDetailInfo.AppInnerPicture getDownloadQRCode() {
        return this.downloadQRCode;
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getNumber() {
        return this.number;
    }

    public String getOccurTime() {
        return this.occurTime;
    }

    public int getOs() {
        return this.os;
    }

    public int getType() {
        return this.type;
    }

    public String getVersion() {
        return this.version;
    }

    public void setAccount(String str) {
        this.account = str;
    }

    public void setAccountType(String str) {
        this.accountType = str;
    }

    public void setAppAuthorInfo(HistoryDetailInfo.AppInnerPicture appInnerPicture) {
        this.appAuthorInfo = appInnerPicture;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public void setDownloadQRCode(HistoryDetailInfo.AppInnerPicture appInnerPicture) {
        this.downloadQRCode = appInnerPicture;
    }

    public void setDownloadUrl(String str) {
        this.downloadUrl = str;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setNumber(String str) {
        this.number = str;
    }

    public void setOccurTime(String str) {
        this.occurTime = str;
    }

    public void setOs(int i2) {
        this.os = i2;
    }

    public void setType(int i2) {
        this.type = i2;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
