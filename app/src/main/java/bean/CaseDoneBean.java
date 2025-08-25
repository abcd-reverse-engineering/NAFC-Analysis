package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class CaseDoneBean extends BaseBean {
    private String data;
    private String hash;
    private String source;
    private String type;

    public String getData() {
        return this.data;
    }

    public String getHash() {
        return this.hash;
    }

    public String getSource() {
        return this.source;
    }

    public String getType() {
        return this.type;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setHash(String str) {
        this.hash = str;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
