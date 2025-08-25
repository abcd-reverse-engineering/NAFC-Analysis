package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class ReportZPEleBean extends BaseBean {
    private String clusterID;
    private int code = -1;
    private long id = -1;
    private String isShow;
    private String name;
    private String parentClusterID;
    private String sort;
    private String topClass;

    public String getClusterID() {
        return this.clusterID;
    }

    public int getCode() {
        return this.code;
    }

    public long getId() {
        return this.id;
    }

    public String getIsShow() {
        return this.isShow;
    }

    public String getName() {
        return this.name;
    }

    public String getParentClusterID() {
        return this.parentClusterID;
    }

    public String getSort() {
        return this.sort;
    }

    public String getTopClass() {
        return this.topClass;
    }

    public void setClusterID(String str) {
        this.clusterID = str;
    }

    public void setCode(int i2) {
        this.code = i2;
    }

    public void setId(long j2) {
        this.id = j2;
    }

    public void setIsShow(String str) {
        this.isShow = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setParentClusterID(String str) {
        this.parentClusterID = str;
    }

    public void setSort(String str) {
        this.sort = str;
    }

    public void setTopClass(String str) {
        this.topClass = str;
    }
}
