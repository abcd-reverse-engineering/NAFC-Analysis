package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class RechargePlatBean extends BaseBean {
    private String ex;
    private String platform;
    private String platformText;

    public String getEx() {
        return this.ex;
    }

    public String getPlatform() {
        return this.platform;
    }

    public String getPlatformText() {
        return this.platformText;
    }

    public void setEx(String str) {
        this.ex = str;
    }

    public void setPlatform(String str) {
        this.platform = str;
    }

    public void setPlatformText(String str) {
        this.platformText = str;
    }
}
