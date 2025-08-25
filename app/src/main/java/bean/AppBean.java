package bean;

import android.graphics.drawable.Drawable;
import com.google.gson.e;
import network.BaseBean;

/* loaded from: classes.dex */
public class AppBean extends BaseBean {
    private String activityName;
    private String appMD5;
    private long fileSize;
    private int flag;
    private boolean isOk;
    private boolean isScaned;
    private boolean isSelect;
    private long lastTime;
    private String name;
    private String pkgName;
    private String pkgPath;
    private int source = 0;
    private boolean typeIsApp;
    private String versionName;
    private String virusDescription;
    private int virusLevel;
    private String virusName;

    public static AppInfoBean AppBean2AppInfoBean(AppBean appBean, Drawable drawable, String str, String str2, boolean z, long j2) {
        AppInfoBean appInfoBeanParent2Child = parent2Child(appBean);
        appInfoBeanParent2Child.setAppIcon(drawable);
        return appInfoBeanParent2Child;
    }

    public static AppBean AppInfoBean2AppBean(AppInfoBean appInfoBean) {
        return child2Parent(appInfoBean);
    }

    public static AppBean child2Parent(AppInfoBean appInfoBean) {
        return (AppBean) new e().a(new e().a(appInfoBean), AppBean.class);
    }

    public static AppInfoBean parent2Child(AppBean appBean) {
        return (AppInfoBean) new e().a(new e().a(appBean), AppInfoBean.class);
    }

    public String getActivityName() {
        return this.activityName;
    }

    public String getAppMD5() {
        return this.appMD5;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public int getFlag() {
        return this.flag;
    }

    public long getLastTime() {
        return this.lastTime;
    }

    public String getName() {
        return this.name;
    }

    public String getPkgName() {
        return this.pkgName;
    }

    public String getPkgPath() {
        return this.pkgPath;
    }

    public int getSource() {
        return this.source;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public String getVirusDescription() {
        return this.virusDescription;
    }

    public int getVirusLevel() {
        return this.virusLevel;
    }

    public String getVirusName() {
        return this.virusName;
    }

    public boolean isOk() {
        return this.isOk;
    }

    public boolean isScaned() {
        return this.isScaned;
    }

    public boolean isSelect() {
        return this.isSelect;
    }

    public boolean isTypeIsApp() {
        return this.typeIsApp;
    }

    public void setActivityName(String str) {
        this.activityName = str;
    }

    public void setAppMD5(String str) {
        this.appMD5 = str;
    }

    public void setFileSize(long j2) {
        this.fileSize = j2;
    }

    public void setFlag(int i2) {
        this.flag = i2;
    }

    public void setLastTime(long j2) {
        this.lastTime = j2;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOk(boolean z) {
        this.isOk = z;
    }

    public void setPkgName(String str) {
        this.pkgName = str;
    }

    public void setPkgPath(String str) {
        this.pkgPath = str;
    }

    public void setScaned(boolean z) {
        this.isScaned = z;
    }

    public void setSelect(boolean z) {
        this.isSelect = z;
    }

    public void setSource(int i2) {
        this.source = i2;
    }

    public void setTypeIsApp(boolean z) {
        this.typeIsApp = z;
    }

    public void setVersionName(String str) {
        this.versionName = str;
    }

    public void setVirusDescription(String str) {
        this.virusDescription = str;
    }

    public void setVirusLevel(int i2) {
        this.virusLevel = i2;
    }

    public void setVirusName(String str) {
        this.virusName = str;
    }
}
