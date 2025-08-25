package anet.channel.util;

import android.util.Base64;
import com.xiaomi.mipush.sdk.Constants;
import java.net.InetSocketAddress;
import java.net.Proxy;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public static g f2057a;

    /* renamed from: b, reason: collision with root package name */
    private final Proxy f2058b;

    /* renamed from: c, reason: collision with root package name */
    private final String f2059c;

    /* renamed from: d, reason: collision with root package name */
    private final String f2060d;

    public g(String str, int i2, String str2, String str3) {
        this.f2058b = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(str, i2));
        this.f2059c = str2;
        this.f2060d = str3;
    }

    public static g a() {
        return f2057a;
    }

    public Proxy b() {
        return this.f2058b;
    }

    public String c() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.f2059c);
        sb.append(Constants.COLON_SEPARATOR);
        sb.append(this.f2060d);
        String strEncodeToString = Base64.encodeToString(sb.toString().getBytes(), 0);
        StringBuilder sb2 = new StringBuilder(64);
        sb2.append("Basic ");
        sb2.append(strEncodeToString);
        return sb2.toString();
    }
}
