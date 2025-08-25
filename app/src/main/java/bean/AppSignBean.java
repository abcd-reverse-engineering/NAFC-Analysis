package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class AppSignBean extends BaseBean {
    String signMD5;
    String signSha1;
    String signSha256;

    public AppSignBean(String str, String str2, String str3) {
        this.signMD5 = str;
        this.signSha1 = str2;
        this.signSha256 = str3;
    }

    public String getSignMD5() {
        return this.signMD5;
    }

    public String getSignSha1() {
        return this.signSha1;
    }

    public String getSignSha256() {
        return this.signSha256;
    }

    public void setSignMD5(String str) {
        this.signMD5 = str;
    }

    public void setSignSha1(String str) {
        this.signSha1 = str;
    }

    public void setSignSha256(String str) {
        this.signSha256 = str;
    }
}
