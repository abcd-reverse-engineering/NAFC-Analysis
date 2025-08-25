package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class OssH5FileInfo extends BaseBean {
    private String apiUrl;
    private String oss_Endpoint;
    private Object params;
    private String path;

    public String getApiUrl() {
        return this.apiUrl;
    }

    public String getOss_Endpoint() {
        return this.oss_Endpoint;
    }

    public Object getParams() {
        return this.params;
    }

    public String getPath() {
        return this.path;
    }

    public void setApiUrl(String str) {
        this.apiUrl = str;
    }

    public void setOss_Endpoint(String str) {
        this.oss_Endpoint = str;
    }

    public void setParams(Object obj) {
        this.params = obj;
    }

    public void setPath(String str) {
        this.path = str;
    }
}
