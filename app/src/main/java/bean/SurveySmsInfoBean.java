package bean;

import java.util.List;
import network.BaseBean;

/* loaded from: classes.dex */
public class SurveySmsInfoBean extends BaseBean {
    private List<SurveySmsBean> addList;
    private String caseInfoID;

    public List<SurveySmsBean> getAddList() {
        return this.addList;
    }

    public String getCaseInfoID() {
        return this.caseInfoID;
    }

    public void setAddList(List<SurveySmsBean> list) {
        this.addList = list;
    }

    public void setCaseInfoID(String str) {
        this.caseInfoID = str;
    }
}
