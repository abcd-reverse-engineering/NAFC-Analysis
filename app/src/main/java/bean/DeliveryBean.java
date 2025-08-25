package bean;

import java.util.ArrayList;
import network.BaseBean;

/* loaded from: classes.dex */
public class DeliveryBean extends BaseBean {
    private String caseInfoID;
    private String deliveryGoods;
    private String deliveryTime;
    private int ex;
    private ArrayList<UploadFileBean> mailingTelDetails;
    private String mailingTelInfoID;
    private String oddNumber;
    private String platform;
    private String platformText;
    private String suspectAddr;
    private String suspectMobile;
    private String suspectName;

    public String getCaseInfoID() {
        return this.caseInfoID;
    }

    public String getDeliveryAddress() {
        return this.suspectAddr;
    }

    public String getDeliveryName() {
        return this.suspectName;
    }

    public String getDeliveryNum() {
        return this.oddNumber;
    }

    public String getDeliveryPhone() {
        return this.suspectMobile;
    }

    public String getDeliveryPlat() {
        return this.platformText;
    }

    public String getDeliveryTime() {
        return this.deliveryTime;
    }

    public String getDeliveryWp() {
        return this.deliveryGoods;
    }

    public int getEx() {
        return this.ex;
    }

    public ArrayList<UploadFileBean> getMailingTelDetails() {
        return this.mailingTelDetails;
    }

    public String getMailingTelInfoid() {
        return this.mailingTelInfoID;
    }

    public String getPlatform() {
        return this.platform;
    }

    public void setCaseInfoID(String str) {
        this.caseInfoID = str;
    }

    public void setDeliveryAddress(String str) {
        this.suspectAddr = str;
    }

    public void setDeliveryName(String str) {
        this.suspectName = str;
    }

    public void setDeliveryNum(String str) {
        this.oddNumber = str;
    }

    public void setDeliveryPhone(String str) {
        this.suspectMobile = str;
    }

    public void setDeliveryPlat(String str) {
        this.platformText = str;
    }

    public void setDeliveryTime(String str) {
        this.deliveryTime = str;
    }

    public void setDeliveryWp(String str) {
        this.deliveryGoods = str;
    }

    public void setEx(int i2) {
        this.ex = i2;
    }

    public void setMailingTelDetails(ArrayList<UploadFileBean> arrayList) {
        this.mailingTelDetails = arrayList;
    }

    public void setMailingTelInfoID(String str) {
        this.mailingTelInfoID = str;
    }

    public void setPlatform(String str) {
        this.platform = str;
    }
}
