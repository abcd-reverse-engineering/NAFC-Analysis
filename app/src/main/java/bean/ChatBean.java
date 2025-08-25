package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class ChatBean extends BaseBean {
    public static final int CHAT_TYPE_ALIPAY = 3;
    public static final int CHAT_TYPE_OTHER = 0;
    public static final int CHAT_TYPE_QQ = 2;
    public static final int CHAT_TYPE_WCHAT = 1;
    private Long caseInfoID;
    private Long id;
    private String suspectAccount;
    private String suspectAccountBindEMail;
    private String suspectAccountBindMobile;
    private Long suspectAccountHeadFileID;
    private String suspectAccountHeadFileName;
    private String suspectAccountName;
    private String suspectLocalPath;
    private int type;
    private String typeText;
    private String victimAccount;
    private String victimAccountBindEMail;
    private String victimAccountBindMobile;
    private Long victimAccountHeadFileID;
    private String victimAccountHeadFileName;
    private String victimAccountName;
    private String victimLocalPath;

    public Long getCaseInfoID() {
        return this.caseInfoID;
    }

    public Long getId() {
        return this.id;
    }

    public String getSuspectAccount() {
        return this.suspectAccount;
    }

    public String getSuspectAccountBindEMail() {
        return this.suspectAccountBindEMail;
    }

    public String getSuspectAccountBindMobile() {
        return this.suspectAccountBindMobile;
    }

    public Long getSuspectAccountHeadFileID() {
        return this.suspectAccountHeadFileID;
    }

    public String getSuspectAccountHeadFileName() {
        return this.suspectAccountHeadFileName;
    }

    public String getSuspectAccountName() {
        return this.suspectAccountName;
    }

    public String getSuspectLocalPath() {
        return this.suspectLocalPath;
    }

    public int getType() {
        return this.type;
    }

    public String getTypeText() {
        return this.typeText;
    }

    public String getVictimAccount() {
        return this.victimAccount;
    }

    public String getVictimAccountBindEMail() {
        return this.victimAccountBindEMail;
    }

    public String getVictimAccountBindMobile() {
        return this.victimAccountBindMobile;
    }

    public Long getVictimAccountHeadFileID() {
        return this.victimAccountHeadFileID;
    }

    public String getVictimAccountHeadFileName() {
        return this.victimAccountHeadFileName;
    }

    public String getVictimAccountName() {
        return this.victimAccountName;
    }

    public String getVictimLocalPath() {
        return this.victimLocalPath;
    }

    public void setCaseInfoID(Long l2) {
        this.caseInfoID = l2;
    }

    public void setId(Long l2) {
        this.id = l2;
    }

    public void setSuspectAccount(String str) {
        this.suspectAccount = str;
    }

    public void setSuspectAccountBindEMail(String str) {
        this.suspectAccountBindEMail = str;
    }

    public void setSuspectAccountBindMobile(String str) {
        this.suspectAccountBindMobile = str;
    }

    public void setSuspectAccountHeadFileID(Long l2) {
        this.suspectAccountHeadFileID = l2;
    }

    public void setSuspectAccountHeadFileName(String str) {
        this.suspectAccountHeadFileName = str;
    }

    public void setSuspectAccountName(String str) {
        this.suspectAccountName = str;
    }

    public void setSuspectLocalPath(String str) {
        this.suspectLocalPath = str;
    }

    public void setType(int i2) {
        this.type = i2;
    }

    public void setTypeText(String str) {
        this.typeText = str;
    }

    public void setVictimAccount(String str) {
        this.victimAccount = str;
    }

    public void setVictimAccountBindEMail(String str) {
        this.victimAccountBindEMail = str;
    }

    public void setVictimAccountBindMobile(String str) {
        this.victimAccountBindMobile = str;
    }

    public void setVictimAccountHeadFileID(Long l2) {
        this.victimAccountHeadFileID = l2;
    }

    public void setVictimAccountHeadFileName(String str) {
        this.victimAccountHeadFileName = str;
    }

    public void setVictimAccountName(String str) {
        this.victimAccountName = str;
    }

    public void setVictimLocalPath(String str) {
        this.victimLocalPath = str;
    }
}
