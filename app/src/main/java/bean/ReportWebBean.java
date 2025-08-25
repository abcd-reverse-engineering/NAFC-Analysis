package bean;

import com.luck.picture.lib.entity.LocalMedia;
import java.util.List;
import network.BaseBean;

/* loaded from: classes.dex */
public class ReportWebBean extends BaseBean {
    private String caseInfoID;
    private String createTime;
    private String firm;
    private String id;
    private List<LocalMedia> localMedias;
    private String updateTime;
    private String url;

    public String getCaseInfoID() {
        return this.caseInfoID;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public String getFirm() {
        return this.firm;
    }

    public String getId() {
        return this.id;
    }

    public List<LocalMedia> getLocalMedias() {
        return this.localMedias;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public String getUrl() {
        return this.url;
    }

    public void setCaseInfoID(String str) {
        this.caseInfoID = str;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public void setFirm(String str) {
        this.firm = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setLocalMedias(List<LocalMedia> list) {
        this.localMedias = list;
    }

    public void setUpdateTime(String str) {
        this.updateTime = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
