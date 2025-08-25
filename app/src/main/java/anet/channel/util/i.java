package anet.channel.util;

import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private static AtomicInteger f2062a = new AtomicInteger();

    public static String a(String str) {
        if (f2062a.get() == Integer.MAX_VALUE) {
            f2062a.set(0);
        }
        return !TextUtils.isEmpty(str) ? StringUtils.concatString(str, ".AWCN", String.valueOf(f2062a.incrementAndGet())) : StringUtils.concatString("AWCN", String.valueOf(f2062a.incrementAndGet()));
    }
}
