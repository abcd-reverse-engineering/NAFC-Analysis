package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class SurveyAudioResultBean extends BaseBean {
    private String suspectFileID;
    private String suspectInfoID;

    public String getSuspectFileID() {
        return this.suspectFileID;
    }

    public String getSuspectInfoID() {
        return this.suspectInfoID;
    }

    public void setSuspectFileID(String str) {
        this.suspectFileID = str;
    }

    public void setSuspectInfoID(String str) {
        this.suspectInfoID = str;
    }
}
