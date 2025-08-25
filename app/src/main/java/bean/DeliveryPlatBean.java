package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class DeliveryPlatBean extends BaseBean {
    private int ex;
    private String oddNumRegex;
    private String platform;
    private String platformText;

    public int getEx() {
        return this.ex;
    }

    public String getOddNumRegex() {
        return this.oddNumRegex;
    }

    public String getPlatform() {
        return this.platform;
    }

    public String getPlatformText() {
        return this.platformText;
    }

    public void setEx(int i2) {
        this.ex = i2;
    }

    public void setOddNumRegex(String str) {
        this.oddNumRegex = str;
    }

    public void setPlatform(String str) {
        this.platform = str;
    }

    public void setPlatformText(String str) {
        this.platformText = str;
    }
}
