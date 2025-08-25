package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class NoteListBean extends BaseBean {
    private String content;
    private String id;
    private boolean isRead;
    private String title;
    private String url;
    private String vaildEndTime;
    private String vaildStartTime;

    public String getContent() {
        return this.content;
    }

    public String getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUrl() {
        return this.url;
    }

    public String getVaildEndTime() {
        return this.vaildEndTime;
    }

    public String getVaildStartTime() {
        return this.vaildStartTime;
    }

    public boolean isRead() {
        return this.isRead;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setRead(boolean z) {
        this.isRead = z;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setVaildEndTime(String str) {
        this.vaildEndTime = str;
    }

    public void setVaildStartTime(String str) {
        this.vaildStartTime = str;
    }
}
