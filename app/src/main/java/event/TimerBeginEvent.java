package event;

/* loaded from: classes2.dex */
public class TimerBeginEvent {
    private long mBaseTime;

    public TimerBeginEvent() {
        this.mBaseTime = 0L;
    }

    public long getmBaseTime() {
        return this.mBaseTime;
    }

    public void setmBaseTime(long j2) {
        this.mBaseTime = j2;
    }

    public TimerBeginEvent(long j2) {
        this.mBaseTime = 0L;
        this.mBaseTime = j2;
    }
}
