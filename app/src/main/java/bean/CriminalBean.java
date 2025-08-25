package bean;

import java.util.List;
import network.BaseBean;

/* loaded from: classes.dex */
public class CriminalBean extends BaseBean {
    private List<UploadFileBean> audios;
    private String caseInfoID;
    private String id;
    private List<CallCriminalBean> mobiles;
    private List<UploadFileBean> printscreens;
    private List<SocialCriminalBean> socialAccounts;

    public List<UploadFileBean> getAudios() {
        return this.audios;
    }

    public String getCaseInfoID() {
        return this.caseInfoID;
    }

    public String getId() {
        return this.id;
    }

    public List<CallCriminalBean> getMobiles() {
        return this.mobiles;
    }

    public List<UploadFileBean> getPrintscreens() {
        return this.printscreens;
    }

    public List<SocialCriminalBean> getSocialAccounts() {
        return this.socialAccounts;
    }

    public void setAudios(List<UploadFileBean> list) {
        this.audios = list;
    }

    public void setCaseInfoID(String str) {
        this.caseInfoID = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setMobiles(List<CallCriminalBean> list) {
        this.mobiles = list;
    }

    public void setPrintscreens(List<UploadFileBean> list) {
        this.printscreens = list;
    }

    public void setSocialAccounts(List<SocialCriminalBean> list) {
        this.socialAccounts = list;
    }
}
