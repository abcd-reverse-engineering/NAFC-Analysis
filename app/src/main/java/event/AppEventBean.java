package event;

import bean.AppInfoBean;
import java.util.List;

/* loaded from: classes2.dex */
public class AppEventBean {
    private List<AppInfoBean> mAppBeans;

    public AppEventBean(List<AppInfoBean> list) {
        this.mAppBeans = list;
    }

    public List<AppInfoBean> getAppBeans() {
        return this.mAppBeans;
    }

    public void setSmsBeans(List<AppInfoBean> list) {
        this.mAppBeans = list;
    }
}
