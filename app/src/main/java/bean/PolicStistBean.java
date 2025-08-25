package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class PolicStistBean extends BaseBean {
    private int downloadCount;
    private int qrCodeScanCount;
    private int registeCount;

    public int getDownloadCount() {
        return this.downloadCount;
    }

    public int getQrCodeScanCount() {
        return this.qrCodeScanCount;
    }

    public int getRegisteCount() {
        return this.registeCount;
    }

    public void setDownloadCount(int i2) {
        this.downloadCount = i2;
    }

    public void setQrCodeScanCount(int i2) {
        this.qrCodeScanCount = i2;
    }

    public void setRegisteCount(int i2) {
        this.registeCount = i2;
    }
}
