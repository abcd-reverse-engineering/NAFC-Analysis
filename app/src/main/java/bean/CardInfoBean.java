package bean;

import java.util.List;
import network.BaseBean;

/* loaded from: classes.dex */
public class CardInfoBean extends BaseBean {
    private String caseInfoID;
    private List<CardChildsBean> childList;
    private String createTime;
    private String id;
    private String suspectAccount;
    private String suspectAccountBank;
    private String type;
    private String typeText;
    private String updateTime;
    private String victimAccount;
    private String victimAccountBank;

    public String getCaseInfoID() {
        return this.caseInfoID;
    }

    public List<CardChildsBean> getChildList() {
        return this.childList;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public String getId() {
        return this.id;
    }

    public String getSuspectAccount() {
        return this.suspectAccount;
    }

    public String getSuspectAccountBank() {
        return this.suspectAccountBank;
    }

    public String getType() {
        return this.type;
    }

    public String getTypeText() {
        return this.typeText;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public String getVictimAccount() {
        return this.victimAccount;
    }

    public String getVictimAccountBank() {
        return this.victimAccountBank;
    }

    public void setCaseInfoID(String str) {
        this.caseInfoID = str;
    }

    public void setChildList(List<CardChildsBean> list) {
        this.childList = list;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setSuspectAccount(String str) {
        this.suspectAccount = str;
    }

    public void setSuspectAccountBank(String str) {
        this.suspectAccountBank = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setTypeText(String str) {
        this.typeText = str;
    }

    public void setUpdateTime(String str) {
        this.updateTime = str;
    }

    public void setVictimAccount(String str) {
        this.victimAccount = str;
    }

    public void setVictimAccountBank(String str) {
        this.victimAccountBank = str;
    }
}
