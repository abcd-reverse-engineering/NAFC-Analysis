package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class AccountBean extends BaseBean {
    private String id;
    private String paymentInfoID;
    private String paymentTime;
    private String paymentType;
    private String paymentTypeText;
    private String suspectAccount;
    private String suspectAccountType;
    private String suspectAccountTypeText;
    private String suspectAccountTypeText1;
    private String suspectName;
    private String transferAmount;
    private String victimAccount;
    private String victimAccountType;
    private String victimAccountTypeText;
    private String victimAccountTypeText1;

    public String getId() {
        return this.id;
    }

    public String getPaymentInfoID() {
        return this.paymentInfoID;
    }

    public String getPaymentTime() {
        return this.paymentTime;
    }

    public String getPaymentType() {
        return this.paymentType;
    }

    public String getPaymentTypeText() {
        return this.paymentTypeText;
    }

    public String getSuspectAccount() {
        return this.suspectAccount;
    }

    public String getSuspectAccountType() {
        return this.suspectAccountType;
    }

    public String getSuspectAccountTypeText() {
        return this.suspectAccountTypeText;
    }

    public String getSuspectAccountTypeText1() {
        return this.suspectAccountTypeText1;
    }

    public String getSuspectName() {
        return this.suspectName;
    }

    public String getTransferAmount() {
        return this.transferAmount;
    }

    public String getVictimAccount() {
        return this.victimAccount;
    }

    public String getVictimAccountType() {
        return this.victimAccountType;
    }

    public String getVictimAccountTypeText() {
        return this.victimAccountTypeText;
    }

    public String getVictimAccountTypeText1() {
        return this.victimAccountTypeText1;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setPaymentInfoID(String str) {
        this.paymentInfoID = str;
    }

    public void setPaymentTime(String str) {
        this.paymentTime = str;
    }

    public void setPaymentType(String str) {
        this.paymentType = str;
    }

    public void setPaymentTypeText(String str) {
        this.paymentTypeText = str;
    }

    public void setSuspect(String str, String str2, String str3, String str4, String str5) {
        this.suspectAccountType = str;
        this.suspectAccountTypeText = str2;
        this.suspectAccountTypeText1 = str3;
        this.suspectAccount = str4;
        this.suspectName = str5;
    }

    public void setSuspectAccount(String str) {
        this.suspectAccount = str;
    }

    public void setSuspectAccountType(String str) {
        this.suspectAccountType = str;
    }

    public void setSuspectAccountTypeText(String str) {
        this.suspectAccountTypeText = str;
    }

    public void setSuspectAccountTypeText1(String str) {
        this.suspectAccountTypeText1 = str;
    }

    public void setSuspectName(String str) {
        this.suspectName = str;
    }

    public void setTransferAmount(String str) {
        this.transferAmount = str;
    }

    public void setVictim(String str, String str2, String str3, String str4) {
        this.victimAccountType = str;
        this.victimAccountTypeText = str2;
        this.victimAccountTypeText1 = str3;
        this.victimAccount = str4;
    }

    public void setVictimAccount(String str) {
        this.victimAccount = str;
    }

    public void setVictimAccountType(String str) {
        this.victimAccountType = str;
    }

    public void setVictimAccountTypeText(String str) {
        this.victimAccountTypeText = str;
    }

    public void setVictimAccountTypeText1(String str) {
        this.victimAccountTypeText1 = str;
    }
}
