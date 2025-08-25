package bean;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* loaded from: classes.dex */
public class AppInfoBean implements Parcelable {
    public static final String API_TAG_VIRUS_DISCRIPTION = "(API-dscrp)";
    public static final String API_TAG_VIRUS_NAME = ";(API-name)";
    public static final int APP_SOURCE_VIRUS_0 = 0;
    public static final int APP_SOURCE_VIRUS_1 = 1;
    public static final Parcelable.Creator<AppInfoBean> CREATOR = new Parcelable.Creator<AppInfoBean>() { // from class: bean.AppInfoBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppInfoBean createFromParcel(Parcel parcel) {
            return new AppInfoBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppInfoBean[] newArray(int i2) {
            return new AppInfoBean[i2];
        }
    };
    public static final String TENCENT_TAG_VIRUS_DISCRIPTION = "(T-dscrp)";
    public static final String TENCENT_TAG_VIRUS_NAME = ";(T-name)";
    public static final String TENCENT_TAG_VIRUS_URL = "(T-url)";
    private String activityName;
    private boolean addNew;
    private transient Drawable appIcon;
    private String appIconBase64;
    private String appMD5;
    private long fileSize;
    private int flag;
    private String ipAddress;
    private boolean isCancleUninstall;
    private boolean isScaned;
    private boolean isSelect;
    private long lastTime;
    private String name;
    private String pkgName;
    private String pkgPath;
    private String signHash;
    private String signMD5;
    private String signSha1;
    private String signSha256;
    private int source;
    private boolean typeIsApp;
    private String uri;
    private String useMobileNumber;
    private String versionName;
    private String virusDescription;
    private int virusLevel;
    private String virusName;

    public AppInfoBean() {
        this.virusLevel = -1;
        this.source = 0;
        this.addNew = false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getActivityName() {
        return this.activityName;
    }

    public Drawable getAppIcon() {
        return this.appIcon;
    }

    public String getAppIconBase64() {
        return this.appIconBase64;
    }

    public String getAppMD5() {
        return this.appMD5;
    }

    public String getDealVirusDescription() {
        if (TextUtils.isEmpty(this.virusDescription)) {
            return "";
        }
        if (!this.virusDescription.contains(TENCENT_TAG_VIRUS_DISCRIPTION)) {
            return this.virusDescription;
        }
        int iIndexOf = this.virusDescription.indexOf(TENCENT_TAG_VIRUS_DISCRIPTION);
        return iIndexOf > 0 ? this.virusDescription.substring(0, iIndexOf) : this.virusDescription.substring(9).replace(TENCENT_TAG_VIRUS_DISCRIPTION, "");
    }

    public String getDealVirusName() {
        if (TextUtils.isEmpty(this.virusName)) {
            return "";
        }
        if (!this.virusName.contains(TENCENT_TAG_VIRUS_NAME)) {
            return this.virusName;
        }
        int iIndexOf = this.virusName.indexOf(TENCENT_TAG_VIRUS_NAME);
        return iIndexOf > 0 ? this.virusName.substring(0, iIndexOf) : this.virusName.substring(9).replace(TENCENT_TAG_VIRUS_NAME, "");
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public int getFlag() {
        return this.flag;
    }

    public String getIpAddress() {
        return this.ipAddress;
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

    public String getSignHash() {
        return this.signHash;
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

    public int getSource() {
        return this.source;
    }

    public String getUri() {
        return this.uri;
    }

    public String getUseMobileNumber() {
        return this.useMobileNumber;
    }

    public String getVersionCode() {
        return this.versionName;
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

    public boolean isAddNew() {
        return this.addNew;
    }

    public boolean isCancleUninstall() {
        return this.isCancleUninstall;
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

    public void setAddNew(boolean z) {
        this.addNew = z;
    }

    public void setAppIcon(Drawable drawable) {
        this.appIcon = drawable;
    }

    public void setAppIconBase64(String str) {
        this.appIconBase64 = str;
    }

    public void setAppMD5(String str) {
        this.appMD5 = str;
    }

    public void setCancleUninstall(boolean z) {
        this.isCancleUninstall = z;
    }

    public void setFileSize(long j2) {
        this.fileSize = j2;
    }

    public void setFlag(int i2) {
        this.flag = i2;
    }

    public void setIpAddress(String str) {
        this.ipAddress = str;
    }

    public void setLastTime(long j2) {
        this.lastTime = j2;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPkgName(String str) {
        this.pkgName = str;
    }

    public AppInfoBean setPkgPath(String str) {
        this.pkgPath = str;
        return this;
    }

    public void setScaned(boolean z) {
        this.isScaned = z;
    }

    public void setSelect(boolean z) {
        this.isSelect = z;
    }

    public void setSignHash(String str) {
        this.signHash = str;
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

    public void setSource(int i2) {
        this.source = i2;
    }

    public void setTypeIsApp(boolean z) {
        this.typeIsApp = z;
    }

    public void setUri(String str) {
        this.uri = str;
    }

    public void setUseMobileNumber(String str) {
        this.useMobileNumber = str;
    }

    public void setVersionCode(String str) {
        this.versionName = str;
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

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.pkgName);
        parcel.writeString(this.activityName);
        parcel.writeString(this.name);
        parcel.writeInt(this.flag);
        parcel.writeByte(this.isSelect ? (byte) 1 : (byte) 0);
        parcel.writeString(this.versionName);
        parcel.writeLong(this.lastTime);
        parcel.writeString(this.appMD5);
        parcel.writeString(this.virusName);
        parcel.writeLong(this.fileSize);
        parcel.writeByte(this.isScaned ? (byte) 1 : (byte) 0);
        parcel.writeString(this.pkgPath);
        parcel.writeByte(this.addNew ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.typeIsApp ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isCancleUninstall ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.virusLevel);
        parcel.writeString(this.virusDescription);
        parcel.writeInt(this.source);
        parcel.writeString(this.signHash);
        parcel.writeString(this.useMobileNumber);
        parcel.writeString(this.signMD5);
        parcel.writeString(this.signSha1);
        parcel.writeString(this.signSha256);
        parcel.writeString(this.ipAddress);
        parcel.writeString(this.appIconBase64);
        parcel.writeString(this.uri);
    }

    public AppInfoBean(String str, String str2, String str3, String str4, int i2, Drawable drawable, boolean z, long j2) {
        this.virusLevel = -1;
        this.source = 0;
        this.addNew = false;
        this.pkgName = str;
        this.activityName = str2;
        this.name = str3;
        this.flag = i2;
        this.appIcon = drawable;
        this.isSelect = z;
        this.versionName = str4;
        this.lastTime = j2;
    }

    protected AppInfoBean(Parcel parcel) {
        this.virusLevel = -1;
        this.source = 0;
        this.addNew = false;
        this.pkgName = parcel.readString();
        this.activityName = parcel.readString();
        this.name = parcel.readString();
        this.flag = parcel.readInt();
        this.isSelect = parcel.readByte() != 0;
        this.versionName = parcel.readString();
        this.lastTime = parcel.readLong();
        this.appMD5 = parcel.readString();
        this.virusName = parcel.readString();
        this.fileSize = parcel.readLong();
        this.isScaned = parcel.readByte() != 0;
        this.pkgPath = parcel.readString();
        this.addNew = parcel.readByte() != 0;
        this.typeIsApp = parcel.readByte() != 0;
        this.isCancleUninstall = parcel.readByte() != 0;
        this.virusLevel = parcel.readInt();
        this.virusDescription = parcel.readString();
        this.source = parcel.readInt();
        this.signHash = parcel.readString();
        this.useMobileNumber = parcel.readString();
        this.signMD5 = parcel.readString();
        this.signSha1 = parcel.readString();
        this.signSha256 = parcel.readString();
        this.ipAddress = parcel.readString();
        this.appIconBase64 = parcel.readString();
        this.uri = parcel.readString();
    }
}
