package a.a.u;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static AtomicInteger f1257a = new AtomicInteger(0);

    public static String a(String str, String str2) {
        StringBuilder sb = new StringBuilder(16);
        if (str != null) {
            sb.append(str);
            sb.append('.');
        }
        if (str2 != null) {
            sb.append(str2);
            sb.append(f1257a.incrementAndGet() & Integer.MAX_VALUE);
        }
        return sb.toString();
    }
}
