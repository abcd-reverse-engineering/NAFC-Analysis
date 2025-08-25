package network.account;

import java.util.List;
import network.BaseBean;

/* loaded from: classes2.dex */
public class AccountInfo extends BaseBean {
    private int auditstatus;
    private String id;
    private String idNumber;
    private boolean isPolice;
    private boolean isVerified;
    private int loginType;
    private String name;
    private String openId;
    private String phoneNum;
    private String policeUserID;
    private String policeUserPCode;
    private String region;
    private String registerRegionCode;
    private String registerRegionName;
    private List<String> tags;
    private String token;
    private String visiblePhone;

    public int getAuditstatus() {
        return this.auditstatus;
    }

    public String getId() {
        return this.id;
    }

    public String getIdNumber() {
        return this.idNumber;
    }

    public int getLoginType() {
        return this.loginType;
    }

    public String getName() {
        return this.name;
    }

    public String getOpenId() {
        return this.openId;
    }

    public String getPhoneNum() {
        return this.phoneNum;
    }

    public String getPoliceUserID() {
        return this.policeUserID;
    }

    public String getPoliceUserPCode() {
        return this.policeUserPCode;
    }

    public String getRegion() {
        return this.region;
    }

    public String getRegisterRegionCode() {
        return this.registerRegionCode;
    }

    public String getRegisterRegionName() {
        return this.registerRegionName;
    }

    public List<String> getTags() {
        return this.tags;
    }

    public String getToken() {
        return this.token;
    }

    public String getVisiblePhone() {
        return this.visiblePhone;
    }

    public boolean isIsVerified() {
        return this.isVerified;
    }

    public boolean isPolice() {
        return this.isPolice;
    }

    public boolean isVerified() {
        return this.isVerified;
    }

    public void setAuditstatus(int i2) {
        this.auditstatus = i2;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setIdNumber(String str) {
        this.idNumber = str;
    }

    public void setIsVerified(boolean z) {
        this.isVerified = z;
    }

    public void setLoginType(int i2) {
        this.loginType = i2;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOpenId(String str) {
        this.openId = str;
    }

    public void setPhoneNum(String str) {
        this.phoneNum = str;
    }

    public void setPolice(boolean z) {
        this.isPolice = z;
    }

    public void setPoliceUserID(String str) {
        this.policeUserID = str;
    }

    public void setPoliceUserPCode(String str) {
        this.policeUserPCode = str;
    }

    public void setRegion(String str) {
        this.region = str;
    }

    public void setRegisterRegionCode(String str) {
        this.registerRegionCode = str;
    }

    public void setRegisterRegionName(String str) {
        this.registerRegionName = str;
    }

    public void setTags(List<String> list) {
        this.tags = list;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setVerified(boolean z) {
        this.isVerified = z;
    }

    public void setVisiblePhone(String str) {
        this.visiblePhone = str;
    }
}
