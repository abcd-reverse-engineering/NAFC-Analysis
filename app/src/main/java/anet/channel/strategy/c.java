package anet.channel.strategy;

import anet.channel.util.HttpConstant;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, String> f1954a = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private boolean f1955b = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static c f1956a = new c();

        private a() {
        }
    }

    public void a(boolean z) {
        this.f1955b = z;
    }

    public void b(String str) {
        this.f1954a.put(str, HttpConstant.HTTP);
    }

    public String a(String str) {
        if (!this.f1955b) {
            return null;
        }
        String str2 = this.f1954a.get(str);
        if (str2 != null) {
            return str2;
        }
        this.f1954a.put(str, HttpConstant.HTTPS);
        return HttpConstant.HTTPS;
    }
}
