package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class TencentVirusBean extends BaseBean {
    private AppInfoBean mAppInfoBean;
    private ScanAppInfoBean mInfoBean;
    private AppVirusBean mVirusBean;

    public AppInfoBean getmAppInfoBean() {
        return this.mAppInfoBean;
    }

    public ScanAppInfoBean getmInfoBean() {
        return this.mInfoBean;
    }

    public AppVirusBean getmVirusBean() {
        return this.mVirusBean;
    }

    public void setmAppInfoBean(AppInfoBean appInfoBean) {
        this.mAppInfoBean = appInfoBean;
    }

    public void setmInfoBean(ScanAppInfoBean scanAppInfoBean) {
        this.mInfoBean = scanAppInfoBean;
    }

    public void setmVirusBean(AppVirusBean appVirusBean) {
        this.mVirusBean = appVirusBean;
    }
}
