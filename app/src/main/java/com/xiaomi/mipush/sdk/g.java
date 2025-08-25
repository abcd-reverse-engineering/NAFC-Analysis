package com.xiaomi.mipush.sdk;

import com.xiaomi.push.gk;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<d, a> f12373a = new HashMap<>();

    /* renamed from: com.xiaomi.mipush.sdk.g$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12374a = new int[d.values().length];

        static {
            try {
                f12374a[d.ASSEMBLE_PUSH_HUAWEI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12374a[d.ASSEMBLE_PUSH_FCM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12374a[d.ASSEMBLE_PUSH_COS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12374a[d.ASSEMBLE_PUSH_FTOS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f12375a;

        /* renamed from: b, reason: collision with root package name */
        public String f12376b;

        public a(String str, String str2) {
            this.f12375a = str;
            this.f12376b = str2;
        }
    }

    static {
        a(d.ASSEMBLE_PUSH_HUAWEI, new a("com.xiaomi.assemble.control.HmsPushManager", "newInstance"));
        a(d.ASSEMBLE_PUSH_FCM, new a("com.xiaomi.assemble.control.FCMPushManager", "newInstance"));
        a(d.ASSEMBLE_PUSH_COS, new a("com.xiaomi.assemble.control.COSPushManager", "newInstance"));
        a(d.ASSEMBLE_PUSH_FTOS, new a("com.xiaomi.assemble.control.FTOSPushManager", "newInstance"));
    }

    private static void a(d dVar, a aVar) {
        if (aVar != null) {
            f12373a.put(dVar, aVar);
        }
    }

    public static a a(d dVar) {
        return f12373a.get(dVar);
    }

    /* renamed from: a, reason: collision with other method in class */
    public static gk m102a(d dVar) {
        return gk.AggregatePushSwitch;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static v m101a(d dVar) {
        int i2 = AnonymousClass1.f12374a[dVar.ordinal()];
        if (i2 == 1) {
            return v.UPLOAD_HUAWEI_TOKEN;
        }
        if (i2 == 2) {
            return v.UPLOAD_FCM_TOKEN;
        }
        if (i2 == 3) {
            return v.UPLOAD_COS_TOKEN;
        }
        if (i2 != 4) {
            return null;
        }
        return v.UPLOAD_FTOS_TOKEN;
    }
}
