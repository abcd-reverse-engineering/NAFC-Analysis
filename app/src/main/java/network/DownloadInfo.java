package network;

/* loaded from: classes2.dex */
public class DownloadInfo extends BaseBean {
    private String content;
    private String fileMD5;
    private int innerVersion;
    private boolean isForcedVersion;
    private boolean isUpdatable;
    private String url;
    private String version;

    public String getContent() {
        return this.content;
    }

    public String getFileMD5() {
        return this.fileMD5;
    }

    public int getInnerVersion() {
        return this.innerVersion;
    }

    public String getUrl() {
        return this.url;
    }

    public String getVersion() {
        return this.version;
    }

    public boolean isIsForcedVersion() {
        return this.isForcedVersion;
    }

    public boolean isIsUpdatable() {
        return this.isUpdatable;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setFileMD5(String str) {
        this.fileMD5 = str;
    }

    public void setInnerVersion(int i2) {
        this.innerVersion = i2;
    }

    public void setIsForcedVersion(boolean z) {
        this.isForcedVersion = z;
    }

    public void setIsUpdatable(boolean z) {
        this.isUpdatable = z;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
