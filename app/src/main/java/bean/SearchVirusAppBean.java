package bean;

import com.vivo.push.PushClientConstants;
import h.y;
import i.c.a.e;

/* compiled from: SearchVirusAppBean.kt */
@y(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\u0018\u00002\u00020\u0001B/\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007B\u0005¢\u0006\u0002\u0010\bR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\fR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001b\u0010\fR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\n\"\u0004\b\u001e\u0010\f¨\u0006\u001f"}, d2 = {"Lbean/SearchVirusAppBean;", "", "appName", "", PushClientConstants.TAG_PKG_NAME, "filePath", "fileMd5", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "()V", "getAppName", "()Ljava/lang/String;", "setAppName", "(Ljava/lang/String;)V", "getFileMd5", "setFileMd5", "getFilePath", "setFilePath", "getPkgName", "setPkgName", "signMd5", "getSignMd5", "setSignMd5", "signSha1", "getSignSha1", "setSignSha1", "signSha256", "getSignSha256", "setSignSha256", "version", "getVersion", "setVersion", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class SearchVirusAppBean {

    @e
    private String appName;

    @e
    private String fileMd5;

    @e
    private String filePath;

    @e
    private String pkgName;

    @e
    private String signMd5;

    @e
    private String signSha1;

    @e
    private String signSha256;

    @e
    private String version;

    public SearchVirusAppBean() {
        this.appName = "";
        this.fileMd5 = "";
        this.version = "";
        this.pkgName = "";
        this.signMd5 = "";
        this.signSha1 = "";
        this.signSha256 = "";
        this.filePath = "";
    }

    @e
    public final String getAppName() {
        return this.appName;
    }

    @e
    public final String getFileMd5() {
        return this.fileMd5;
    }

    @e
    public final String getFilePath() {
        return this.filePath;
    }

    @e
    public final String getPkgName() {
        return this.pkgName;
    }

    @e
    public final String getSignMd5() {
        return this.signMd5;
    }

    @e
    public final String getSignSha1() {
        return this.signSha1;
    }

    @e
    public final String getSignSha256() {
        return this.signSha256;
    }

    @e
    public final String getVersion() {
        return this.version;
    }

    public final void setAppName(@e String str) {
        this.appName = str;
    }

    public final void setFileMd5(@e String str) {
        this.fileMd5 = str;
    }

    public final void setFilePath(@e String str) {
        this.filePath = str;
    }

    public final void setPkgName(@e String str) {
        this.pkgName = str;
    }

    public final void setSignMd5(@e String str) {
        this.signMd5 = str;
    }

    public final void setSignSha1(@e String str) {
        this.signSha1 = str;
    }

    public final void setSignSha256(@e String str) {
        this.signSha256 = str;
    }

    public final void setVersion(@e String str) {
        this.version = str;
    }

    public SearchVirusAppBean(@e String str, @e String str2, @e String str3, @e String str4) {
        this();
        this.appName = str;
        this.pkgName = str2;
        this.filePath = str3;
        this.fileMd5 = str4;
    }
}
