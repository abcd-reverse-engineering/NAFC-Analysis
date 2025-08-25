package com.alibaba.sdk.android.httpdns;

import android.content.Context;
import com.huawei.hms.framework.common.ContainerUtils;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
class q implements Callable<String[]> {

    /* renamed from: a, reason: collision with root package name */
    private static Context f4096a;

    /* renamed from: a, reason: collision with other field name */
    private s f37a;

    /* renamed from: d, reason: collision with root package name */
    private int f4097d;

    /* renamed from: d, reason: collision with other field name */
    private long f38d;

    /* renamed from: e, reason: collision with root package name */
    private String[] f4098e;
    private Map<String, String> extra;
    private String hostName;

    /* renamed from: j, reason: collision with root package name */
    private boolean f4099j;

    /* renamed from: k, reason: collision with root package name */
    private String f4100k;

    /* renamed from: l, reason: collision with root package name */
    private String f4101l;
    private static d hostManager = d.a();

    /* renamed from: a, reason: collision with other field name */
    private static final Object f36a = new Object();

    q(String str, s sVar) {
        this.f4097d = 1;
        this.f4100k = null;
        this.f4098e = f.f20c;
        this.f4099j = false;
        this.f4101l = null;
        this.extra = new HashMap();
        this.f38d = 0L;
        this.hostName = str;
        this.f37a = sVar;
    }

    q(String str, s sVar, Map<String, String> map, String str2) {
        this.f4097d = 1;
        this.f4100k = null;
        this.f4098e = f.f20c;
        this.f4099j = false;
        this.f4101l = null;
        this.extra = new HashMap();
        this.f38d = 0L;
        this.hostName = str;
        this.f37a = sVar;
        this.f4101l = str2;
        this.extra.putAll(map);
    }

    private boolean d(String str) {
        return str.matches("[a-zA-Z0-9\\-_]+");
    }

    private boolean e(String str) {
        return str.matches("[a-zA-Z0-9\\-_=]+");
    }

    private String getExtra() {
        boolean z;
        StringBuilder sb = new StringBuilder();
        Map<String, String> map = this.extra;
        boolean z2 = true;
        if (map != null) {
            z = true;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb.append("&sdns-");
                sb.append(entry.getKey());
                sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                if (!d(entry.getKey())) {
                    i.f("设置自定义参数失败，自定义key不合法：" + entry.getKey());
                    z2 = false;
                }
                if (!e(entry.getValue())) {
                    i.f("设置自定义参数失败，自定义value不合法：" + entry.getValue());
                    z = false;
                }
            }
        } else {
            z = true;
        }
        if (z2 && z) {
            String string = sb.toString();
            if (string.getBytes("UTF-8").length <= 1000) {
                return string;
            }
            i.f("设置自定义参数失败，自定义参数过长");
        }
        return "";
    }

    static void setContext(Context context) {
        f4096a = context;
    }

    public void a(int i2) {
        if (i2 >= 0) {
            this.f4097d = i2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:82:0x03c5 A[Catch: all -> 0x03f4, TryCatch #2 {all -> 0x03f4, blocks: (B:80:0x03b7, B:82:0x03c5, B:83:0x03ce), top: B:110:0x03b7 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x03ce A[Catch: all -> 0x03f4, TRY_LEAVE, TryCatch #2 {all -> 0x03f4, blocks: (B:80:0x03b7, B:82:0x03c5, B:83:0x03ce), top: B:110:0x03b7 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x03d6  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x03db A[Catch: IOException -> 0x03df, TRY_ENTER, TryCatch #5 {IOException -> 0x03df, blocks: (B:66:0x0392, B:68:0x0397, B:87:0x03db, B:91:0x03e3), top: B:112:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x03e3 A[Catch: IOException -> 0x03df, TRY_LEAVE, TryCatch #5 {IOException -> 0x03df, blocks: (B:66:0x0392, B:68:0x0397, B:87:0x03db, B:91:0x03e3), top: B:112:0x0046 }] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v44 */
    /* JADX WARN: Type inference failed for: r3v65 */
    /* JADX WARN: Type inference failed for: r3v66 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6 */
    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String[] call() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1036
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.httpdns.q.call():java.lang.String[]");
    }
}
