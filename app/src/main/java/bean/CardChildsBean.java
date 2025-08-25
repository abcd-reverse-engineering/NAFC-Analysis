package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class CardChildsBean extends BaseBean {
    private String createTime;
    private String id;
    private String paymentInfoID;
    private String transferAmount;
    private String transferNumber;
    private String transferTime;
    private String updateTime;

    public String getCreateTime() {
        return this.createTime;
    }

    public String getId() {
        return this.id;
    }

    public String getPaymentInfoID() {
        return this.paymentInfoID;
    }

    public String getTransferAmount() {
        return this.transferAmount;
    }

    public String getTransferNumber() {
        return this.transferNumber;
    }

    public String getTransferTime() {
        return this.transferTime;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setPaymentInfoID(String str) {
        this.paymentInfoID = str;
    }

    public void setTransferAmount(String str) {
        this.transferAmount = str;
    }

    public void setTransferNumber(String str) {
        this.transferNumber = str;
    }

    public void setTransferTime(String str) {
        this.transferTime = str;
    }

    public void setUpdateTime(String str) {
        this.updateTime = str;
    }
}
