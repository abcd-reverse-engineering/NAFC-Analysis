package a.a.q.b;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public enum a {
    Slow("弱网络", 1),
    Fast("强网络", 5);

    private final int code;
    private final String desc;

    a(String str, int i2) {
        this.desc = str;
        this.code = i2;
    }

    public static a valueOfCode(int i2) {
        return i2 == 1 ? Slow : Fast;
    }

    public int getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }
}
