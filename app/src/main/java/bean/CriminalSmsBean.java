package bean;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes.dex */
public class CriminalSmsBean implements Serializable {
    private String caseInfoID;
    private String content;
    private String deliveryTime;
    private int index = -1;
    private int isInput;
    private String osBrandType;
    private String osBrandTypeText;
    private List<SmsPictureBean> smsDetails;
    private String smsInfoID;
    private int smsType;
    private String smsTypeText;
    private String suspectMobile;
    private String suspectMobileTypeText;
    private String victimMobile;

    public String getCaseInfoID() {
        return this.caseInfoID;
    }

    public String getContent() {
        return this.content;
    }

    public String getDeliveryTime() {
        return this.deliveryTime;
    }

    public int getIndex() {
        return this.index;
    }

    public int getIsInput() {
        return this.isInput;
    }

    public String getOsBrandType() {
        return this.osBrandType;
    }

    public String getOsBrandTypeText() {
        return this.osBrandTypeText;
    }

    public List<SmsPictureBean> getSmsDetails() {
        return this.smsDetails;
    }

    public String getSmsInfoID() {
        return this.smsInfoID;
    }

    public int getSmsType() {
        return this.smsType;
    }

    public String getSmsTypeText() {
        return this.smsTypeText;
    }

    public String getSuspectMobile() {
        return this.suspectMobile;
    }

    public String getSuspectMobileTypeText() {
        return this.suspectMobileTypeText;
    }

    public String getVictimMobile() {
        return this.victimMobile;
    }

    public void setCaseInfoID(String str) {
        this.caseInfoID = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setDeliveryTime(String str) {
        this.deliveryTime = str;
    }

    public void setIndex(int i2) {
        this.index = i2;
    }

    public void setIsInput(int i2) {
        this.isInput = i2;
    }

    public void setOsBrandType(String str) {
        this.osBrandType = str;
    }

    public void setOsBrandTypeText(String str) {
        this.osBrandTypeText = str;
    }

    public void setSmsDetails(List<SmsPictureBean> list) {
        this.smsDetails = list;
    }

    public void setSmsInfoID(String str) {
        this.smsInfoID = str;
    }

    public void setSmsType(int i2) {
        this.smsType = i2;
    }

    public void setSmsTypeText(String str) {
        this.smsTypeText = str;
    }

    public void setSuspectMobile(String str) {
        this.suspectMobile = str;
    }

    public void setSuspectMobileTypeText(String str) {
        this.suspectMobileTypeText = str;
    }

    public void setVictimMobile(String str) {
        this.victimMobile = str;
    }
}
