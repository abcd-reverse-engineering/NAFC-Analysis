package bean;

import java.util.ArrayList;
import network.BaseBean;

/* loaded from: classes.dex */
public class ReportWebsitBean extends BaseBean {
    private String caseInfoID;
    private String url;
    private ArrayList<UploadFileBean> urlDetails;
    private String urlInfoID;

    public String getCaseInfoID() {
        return this.caseInfoID;
    }

    public String getUrl() {
        return this.url;
    }

    public ArrayList<UploadFileBean> getUrlDetails() {
        return this.urlDetails;
    }

    public String getUrlInfoID() {
        return this.urlInfoID;
    }

    public void setCaseInfoID(String str) {
        this.caseInfoID = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setUrlDetails(ArrayList<UploadFileBean> arrayList) {
        this.urlDetails = arrayList;
    }

    public void setUrlInfoID(String str) {
        this.urlInfoID = str;
    }
}
