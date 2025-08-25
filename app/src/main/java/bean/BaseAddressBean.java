package bean;

/* loaded from: classes.dex */
public class BaseAddressBean {
    public static final int UPDATE_ADDRESS_STATE = 1;
    private int areaVersion;
    private int isRenew;
    private String ossPath;
    private Object provinceList;

    public int getAreaVersion() {
        return this.areaVersion;
    }

    public int getIsRenew() {
        return this.isRenew;
    }

    public String getOssPath() {
        return this.ossPath;
    }

    public Object getProvinceList() {
        return this.provinceList;
    }

    public void setAreaVersion(int i2) {
        this.areaVersion = i2;
    }

    public void setIsRenew(int i2) {
        this.isRenew = i2;
    }

    public void setOssPath(String str) {
        this.ossPath = str;
    }

    public void setProvinceList(Object obj) {
        this.provinceList = obj;
    }
}
