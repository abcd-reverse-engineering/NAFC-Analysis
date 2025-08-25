package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.strategy.l;
import anet.channel.util.HttpConstant;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ConnProtocol implements Serializable {
    private static final long serialVersionUID = -3523201990674557001L;
    final int isHttp;
    public final String name;
    public final String protocol;
    public final String publicKey;
    public final String rtt;
    private static Map<String, ConnProtocol> protocolMap = new HashMap();
    public static final ConnProtocol HTTP = valueOf(HttpConstant.HTTP, null, null);
    public static final ConnProtocol HTTPS = valueOf(HttpConstant.HTTPS, null, null);

    private ConnProtocol(String str, String str2, String str3, String str4) {
        this.name = str;
        this.protocol = str2;
        this.rtt = str3;
        this.publicKey = str4;
        this.isHttp = (HttpConstant.HTTP.equalsIgnoreCase(str2) || HttpConstant.HTTPS.equalsIgnoreCase(str2)) ? 1 : 0;
    }

    private static String buildName(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(18);
        sb.append(str);
        if (TextUtils.isEmpty(str2)) {
            sb.append("_0rtt");
        } else {
            sb.append(c.c.a.b.a.a.s1);
            sb.append(str2);
        }
        sb.append(c.c.a.b.a.a.s1);
        sb.append(str3);
        return sb.toString();
    }

    public static ConnProtocol valueOf(l.a aVar) {
        if (aVar == null) {
            return null;
        }
        return valueOf(aVar.f1990b, aVar.f1995g, aVar.f1996h);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ConnProtocol)) {
            return false;
        }
        return this.name.equals(((ConnProtocol) obj).name);
    }

    public int hashCode() {
        int iHashCode = 527 + this.protocol.hashCode();
        String str = this.rtt;
        if (str != null) {
            iHashCode = (iHashCode * 31) + str.hashCode();
        }
        String str2 = this.publicKey;
        return str2 != null ? (iHashCode * 31) + str2.hashCode() : iHashCode;
    }

    public String toString() {
        return this.name;
    }

    @Deprecated
    public static ConnProtocol valueOf(String str, String str2, String str3, @Deprecated boolean z) {
        return valueOf(str, str2, str3);
    }

    public static ConnProtocol valueOf(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String strBuildName = buildName(str, str2, str3);
        synchronized (protocolMap) {
            if (protocolMap.containsKey(strBuildName)) {
                return protocolMap.get(strBuildName);
            }
            ConnProtocol connProtocol = new ConnProtocol(strBuildName, str, str2, str3);
            protocolMap.put(strBuildName, connProtocol);
            return connProtocol;
        }
    }
}
