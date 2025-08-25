package bean;

import java.util.List;
import network.BaseBean;

/* loaded from: classes.dex */
public class CriminalSocialBean extends BaseBean {
    private String caseInfoId;
    private List<CriminalSocialFileBean> netAccountDetails;
    private String netAccountInfoID;
    private String platform;
    private String platformText;
    private String suspectAccount;

    public String getCaseInfoId() {
        return this.caseInfoId;
    }

    public List<CriminalSocialFileBean> getNetAccountDetails() {
        return this.netAccountDetails;
    }

    public String getNetAccountInfoID() {
        return this.netAccountInfoID;
    }

    public String getPlatform() {
        return this.platform;
    }

    public String getPlatformText() {
        return this.platformText;
    }

    public String getSuspectAccount() {
        return this.suspectAccount;
    }

    public void setCaseInfoId(String str) {
        this.caseInfoId = str;
    }

    public void setNetAccountDetails(List<CriminalSocialFileBean> list) {
        this.netAccountDetails = list;
    }

    public void setNetAccountInfoID(String str) {
        this.netAccountInfoID = str;
    }

    public void setPlatform(String str) {
        this.platform = str;
    }

    public void setPlatformText(String str) {
        this.platformText = str;
    }

    public void setSuspectAccount(String str) {
        this.suspectAccount = str;
    }
}
