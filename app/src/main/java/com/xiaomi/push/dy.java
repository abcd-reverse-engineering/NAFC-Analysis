package com.xiaomi.push;

import android.util.Pair;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public class dy {

    /* renamed from: a, reason: collision with root package name */
    private static Vector<Pair<String, Long>> f12725a = new Vector<>();

    /* renamed from: a, reason: collision with other field name */
    private static ConcurrentHashMap<String, Long> f416a = new ConcurrentHashMap<>();

    public static String a() {
        StringBuilder sb = new StringBuilder();
        synchronized (f12725a) {
            for (int i2 = 0; i2 < f12725a.size(); i2++) {
                Pair<String, Long> pairElementAt = f12725a.elementAt(i2);
                sb.append((String) pairElementAt.first);
                sb.append(Constants.COLON_SEPARATOR);
                sb.append(pairElementAt.second);
                if (i2 < f12725a.size() - 1) {
                    sb.append(";");
                }
            }
            f12725a.clear();
        }
        return sb.toString();
    }
}
