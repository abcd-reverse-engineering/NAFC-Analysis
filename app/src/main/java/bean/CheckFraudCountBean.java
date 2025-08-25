package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class CheckFraudCountBean extends BaseBean {
    private int usableToDayCount;
    private int usableToWeekCount;

    public int getUsableToDayCount() {
        return this.usableToDayCount;
    }

    public int getUsableToWeekCount() {
        return this.usableToWeekCount;
    }

    public void setUsableToDayCount(int i2) {
        this.usableToDayCount = i2;
    }

    public void setUsableToWeekCount(int i2) {
        this.usableToWeekCount = i2;
    }
}
