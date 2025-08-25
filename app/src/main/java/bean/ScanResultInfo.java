package bean;

/* loaded from: classes.dex */
public class ScanResultInfo {
    private int count;
    private String label;

    public ScanResultInfo(String str, int i2) {
        this.label = str;
        this.count = i2;
    }

    public int getCount() {
        return this.count;
    }

    public String getLabel() {
        return this.label;
    }

    public void setCount(int i2) {
        this.count = i2;
    }

    public void setLabel(String str) {
        this.label = str;
    }
}
