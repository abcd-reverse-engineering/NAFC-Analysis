package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class TransferBean extends BaseBean {
    private String amount;
    private Long caseInfoID;
    private Long conversationID;
    private Integer conversationType;
    private String conversationTypeText;
    private Long id;
    private boolean isSave;

    public String getAmount() {
        return this.amount;
    }

    public Long getCaseInfoID() {
        return this.caseInfoID;
    }

    public Long getConversationID() {
        return this.conversationID;
    }

    public Integer getConversationType() {
        return this.conversationType;
    }

    public String getConversationTypeText() {
        return this.conversationTypeText;
    }

    public Long getId() {
        return this.id;
    }

    public boolean isSave() {
        return this.isSave;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public void setCaseInfoID(Long l2) {
        this.caseInfoID = l2;
    }

    public void setConversationID(Long l2) {
        this.conversationID = l2;
    }

    public void setConversationType(Integer num) {
        this.conversationType = num;
    }

    public void setConversationTypeText(String str) {
        this.conversationTypeText = str;
    }

    public void setId(Long l2) {
        this.id = l2;
    }

    public void setSave(boolean z) {
        this.isSave = z;
    }
}
