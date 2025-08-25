package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class ReplyBean extends BaseBean {
    private String content;
    private String replyTime;

    public String getContent() {
        return this.content;
    }

    public String getReplyTime() {
        return this.replyTime;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setReplyTime(String str) {
        this.replyTime = str;
    }
}
