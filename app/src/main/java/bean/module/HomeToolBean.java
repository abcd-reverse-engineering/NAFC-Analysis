package bean.module;

import network.BaseBean;

/* loaded from: classes.dex */
public class HomeToolBean extends BaseBean {
    public static final int NEED_VERIFIED = 1;
    private String content;
    private boolean hasRedDot;
    private String id;
    private String image;
    private int isNeedVerified;
    private int localIcon;
    private String module;

    public String getContent() {
        return this.content;
    }

    public String getId() {
        return this.id;
    }

    public String getImage() {
        return this.image;
    }

    public int getIsNeedVerified() {
        return this.isNeedVerified;
    }

    public int getLocalIcon() {
        return this.localIcon;
    }

    public String getModule() {
        return this.module;
    }

    public boolean isHasRedDot() {
        return this.hasRedDot;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setHasRedDot(boolean z) {
        this.hasRedDot = z;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setImage(String str) {
        this.image = str;
    }

    public void setIsNeedVerified(int i2) {
        this.isNeedVerified = i2;
    }

    public void setLocalIcon(int i2) {
        this.localIcon = i2;
    }

    public void setModule(String str) {
        this.module = str;
    }
}
