package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class H5AudioBean extends BaseBean {
    private String fileMd5;
    private String name;
    private int ossUploadStatus;
    private String path;
    private String size;

    public String getFileMd5() {
        return this.fileMd5;
    }

    public String getName() {
        return this.name;
    }

    public int getOssUploadStatus() {
        return this.ossUploadStatus;
    }

    public String getPath() {
        return this.path;
    }

    public String getSize() {
        return this.size;
    }

    public void setFileMd5(String str) {
        this.fileMd5 = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOssUploadStatus(int i2) {
        this.ossUploadStatus = i2;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setSize(String str) {
        this.size = str;
    }
}
