package anet.channel;

import android.text.TextUtils;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class c {

    /* renamed from: a, reason: collision with root package name */
    Map<String, Integer> f1692a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    Map<String, SessionInfo> f1693b = new ConcurrentHashMap();

    c() {
    }

    void a(SessionInfo sessionInfo) {
        if (sessionInfo == null) {
            throw new NullPointerException("info is null");
        }
        if (TextUtils.isEmpty(sessionInfo.host)) {
            throw new IllegalArgumentException("host cannot be null or empty");
        }
        this.f1693b.put(sessionInfo.host, sessionInfo);
    }

    SessionInfo b(String str) {
        return this.f1693b.get(str);
    }

    public int c(String str) {
        Integer num;
        synchronized (this.f1692a) {
            num = this.f1692a.get(str);
        }
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    SessionInfo a(String str) {
        return this.f1693b.remove(str);
    }

    Collection<SessionInfo> a() {
        return this.f1693b.values();
    }

    void a(String str, int i2) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.f1692a) {
                this.f1692a.put(str, Integer.valueOf(i2));
            }
            return;
        }
        throw new IllegalArgumentException("host cannot be null or empty");
    }
}
