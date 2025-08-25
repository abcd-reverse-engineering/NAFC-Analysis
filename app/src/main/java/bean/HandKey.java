package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class HandKey extends BaseBean {
    private String expire;
    private String identity;
    private String peer;
    private String seqid;

    public String getExpire() {
        return this.expire;
    }

    public String getIdentity() {
        return this.identity;
    }

    public String getPeer() {
        return this.peer;
    }

    public String getSeqid() {
        return this.seqid;
    }

    public void setExpire(String str) {
        this.expire = str;
    }

    public void setIdentity(String str) {
        this.identity = str;
    }

    public void setPeer(String str) {
        this.peer = str;
    }

    public void setSeqid(String str) {
        this.seqid = str;
    }
}
