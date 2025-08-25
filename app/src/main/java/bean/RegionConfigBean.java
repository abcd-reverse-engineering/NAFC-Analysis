package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class RegionConfigBean extends BaseBean {
    private String filePath;
    private String jsonRegionCode;
    private String jsonVersion;

    public String getFilePath() {
        return this.filePath;
    }

    public String getJsonRegionCode() {
        return this.jsonRegionCode;
    }

    public String getJsonVersion() {
        return this.jsonVersion;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public void setJsonRegionCode(String str) {
        this.jsonRegionCode = str;
    }

    public void setJsonVersion(String str) {
        this.jsonVersion = str;
    }
}
