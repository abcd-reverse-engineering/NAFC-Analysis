package bean;

/* loaded from: classes.dex */
public class ProgressBean {
    private long progress;
    private long total;

    public ProgressBean(long j2, long j3) {
        this.total = j2;
        this.progress = j3;
    }

    public long getProgress() {
        return this.progress;
    }

    public long getTotal() {
        return this.total;
    }

    public void setProgress(long j2) {
        this.progress = j2;
    }

    public void setTotal(long j2) {
        this.total = j2;
    }
}
