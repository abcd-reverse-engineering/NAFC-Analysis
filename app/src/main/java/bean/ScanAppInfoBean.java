package bean;

import android.graphics.drawable.Drawable;
import network.BaseBean;

/* loaded from: classes.dex */
public class ScanAppInfoBean extends BaseBean {
    private Drawable appIcon;
    private String appName;
    private String appPackageName;
    private int checkState = 0;
    private String isSafe;
    private long lastTime;
    private String path;
    private String versionName;

    public ScanAppInfoBean(String str, String str2, String str3, String str4, long j2, String str5, Drawable drawable) {
        this.appName = str;
        this.appPackageName = str2;
        this.versionName = str4;
        this.lastTime = j2;
        this.isSafe = str5;
        this.path = str3;
        this.appIcon = drawable;
    }

    public Drawable getAppIcon() {
        return this.appIcon;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getAppPackageName() {
        return this.appPackageName;
    }

    public int getCheckState() {
        return this.checkState;
    }

    public String getIsSafe() {
        return this.isSafe;
    }

    public long getLastTime() {
        return this.lastTime;
    }

    public String getPath() {
        return this.path;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public void setAppIcon(Drawable drawable) {
        this.appIcon = drawable;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setAppPackageName(String str) {
        this.appPackageName = str;
    }

    public void setCheckState(int i2) {
        this.checkState = i2;
    }

    public void setIsSafe(String str) {
        this.isSafe = str;
    }

    public void setLastTime(long j2) {
        this.lastTime = j2;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setVersionName(String str) {
        this.versionName = str;
    }
}
