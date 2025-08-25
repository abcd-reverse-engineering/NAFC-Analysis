package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class NoteDlgBean extends BaseBean {
    private String content;
    private boolean redDot;
    private String title;
    private String url;

    public String getContent() {
        return this.content;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isRedDot() {
        return this.redDot;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setRedDot(boolean z) {
        this.redDot = z;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
