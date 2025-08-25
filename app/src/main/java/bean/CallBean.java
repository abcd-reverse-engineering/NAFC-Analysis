package bean;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes.dex */
public class CallBean implements Serializable {
    private String callDuration;
    private String callTelDetailID;
    private List<UploadFileBean> callTelDetails;
    private String callTelInfoID;
    private String caseInfoID;
    private String crime_time;
    private long duration;
    private boolean isSelect;
    private String number;
    private String place;
    private String suspectInfoID;
    private String suspectMobile;
    private String swindleTelType;
    private String swindleTelTypeText;
    private String talkTime;
    private int type;
    private String victimMobile;
    private String victimTel;
    private int isInput = 0;
    private int isCheck = 0;

    public CallBean() {
    }

    public String getCallDuration() {
        return this.callDuration;
    }

    public String getCallTelDetailID() {
        return this.callTelDetailID;
    }

    public List<UploadFileBean> getCallTelDetails() {
        return this.callTelDetails;
    }

    public String getCallTelInfoID() {
        return this.callTelInfoID;
    }

    public String getCaseInfoID() {
        return this.caseInfoID;
    }

    public String getCrime_time() {
        return this.crime_time;
    }

    public long getDuration() {
        return this.duration;
    }

    public int getIsCheck() {
        return this.isCheck;
    }

    public int getIsInput() {
        return this.isInput;
    }

    public String getNumber() {
        return this.number;
    }

    public String getPlace() {
        return this.place;
    }

    public String getSuspectInfoID() {
        return this.suspectInfoID;
    }

    public String getSuspectMobile() {
        return this.suspectMobile;
    }

    public String getSwindleTelType() {
        return this.swindleTelType;
    }

    public String getSwindleTelTypeText() {
        return this.swindleTelTypeText;
    }

    public String getTalkTime() {
        return this.talkTime;
    }

    public int getType() {
        return this.type;
    }

    public String getVictimMobile() {
        return this.victimMobile;
    }

    public String getVictimTel() {
        return this.victimTel;
    }

    public boolean isSelect() {
        return this.isSelect;
    }

    public void setCallDuration(String str) {
        this.callDuration = str;
    }

    public void setCallTelDetailID(String str) {
        this.callTelDetailID = str;
    }

    public void setCallTelDetails(List<UploadFileBean> list) {
        this.callTelDetails = list;
    }

    public void setCallTelInfoID(String str) {
        this.callTelInfoID = str;
    }

    public void setCaseInfoID(String str) {
        this.caseInfoID = str;
    }

    public void setCrime_time(String str) {
        this.crime_time = str;
    }

    public void setDuration(long j2) {
        this.duration = j2;
    }

    public void setIsCheck(int i2) {
        this.isCheck = i2;
    }

    public void setIsInput(int i2) {
        this.isInput = i2;
    }

    public void setNumber(String str) {
        this.number = str;
    }

    public void setPlace(String str) {
        this.place = str;
    }

    public void setSelect(boolean z) {
        this.isSelect = z;
    }

    public void setSuspectInfoID(String str) {
        this.suspectInfoID = str;
    }

    public void setSuspectMobile(String str) {
        this.suspectMobile = str;
    }

    public void setSwindleTelType(String str) {
        this.swindleTelType = str;
    }

    public void setSwindleTelTypeText(String str) {
        this.swindleTelTypeText = str;
    }

    public void setTalkTime(String str) {
        this.talkTime = str;
    }

    public void setType(int i2) {
        this.type = i2;
    }

    public void setVictimMobile(String str) {
        this.victimMobile = str;
    }

    public void setVictimTel(String str) {
        this.victimTel = str;
    }

    public CallBean(String str, String str2, String str3, int i2, boolean z) {
        this.number = str;
        this.crime_time = str2;
        this.place = str3;
        this.type = i2;
        this.isSelect = z;
    }

    public CallBean(String str, String str2, String str3, int i2, boolean z, long j2) {
        this.number = str;
        this.crime_time = str2;
        this.place = str3;
        this.type = i2;
        this.isSelect = z;
        this.duration = j2;
    }
}
