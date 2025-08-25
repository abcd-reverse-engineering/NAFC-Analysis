package com.lxj.xpermission;

import android.annotation.SuppressLint;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: PermissionConstants.java */
@SuppressLint({"InlinedApi"})
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final String f7924a = "android.permission-group.CALENDAR";

    /* renamed from: b, reason: collision with root package name */
    public static final String f7925b = "android.permission-group.CAMERA";

    /* renamed from: c, reason: collision with root package name */
    public static final String f7926c = "android.permission-group.CONTACTS";

    /* renamed from: d, reason: collision with root package name */
    public static final String f7927d = "android.permission-group.LOCATION";

    /* renamed from: e, reason: collision with root package name */
    public static final String f7928e = "android.permission-group.MICROPHONE";

    /* renamed from: f, reason: collision with root package name */
    public static final String f7929f = "android.permission-group.PHONE";

    /* renamed from: g, reason: collision with root package name */
    public static final String f7930g = "android.permission-group.SENSORS";

    /* renamed from: h, reason: collision with root package name */
    public static final String f7931h = "android.permission-group.SMS";

    /* renamed from: i, reason: collision with root package name */
    public static final String f7932i = "android.permission-group.STORAGE";

    /* renamed from: j, reason: collision with root package name */
    private static final String[] f7933j = {util.permissionutil.a.f20907a, util.permissionutil.a.f20908b};

    /* renamed from: k, reason: collision with root package name */
    private static final String[] f7934k = {util.permissionutil.a.f20909c};

    /* renamed from: l, reason: collision with root package name */
    private static final String[] f7935l = {util.permissionutil.a.f20910d, util.permissionutil.a.f20911e, util.permissionutil.a.f20912f};

    /* renamed from: m, reason: collision with root package name */
    private static final String[] f7936m = {util.permissionutil.a.f20913g, util.permissionutil.a.f20914h};
    private static final String[] n = {util.permissionutil.a.f20915i};
    private static final String[] o = {util.permissionutil.a.f20916j, util.permissionutil.a.r, util.permissionutil.a.f20917k, util.permissionutil.a.f20918l, util.permissionutil.a.f20919m, util.permissionutil.a.n, util.permissionutil.a.p, util.permissionutil.a.q, util.permissionutil.a.s};
    private static final String[] p = {util.permissionutil.a.f20916j, util.permissionutil.a.r, util.permissionutil.a.f20917k, util.permissionutil.a.f20918l, util.permissionutil.a.f20919m, util.permissionutil.a.n, util.permissionutil.a.p, util.permissionutil.a.q};
    private static final String[] q = {util.permissionutil.a.t};
    private static final String[] r = {util.permissionutil.a.u, util.permissionutil.a.v, util.permissionutil.a.w, util.permissionutil.a.x, util.permissionutil.a.y};
    private static final String[] s = {util.permissionutil.a.z, util.permissionutil.a.A};

    /* compiled from: PermissionConstants.java */
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String[] a(java.lang.String r3) {
        /*
            int r0 = r3.hashCode()
            r1 = 0
            r2 = 1
            switch(r0) {
                case -1639857183: goto L5b;
                case -1410061184: goto L51;
                case -1250730292: goto L47;
                case -1140935117: goto L3d;
                case 421761675: goto L33;
                case 828638019: goto L29;
                case 852078861: goto L1e;
                case 1581272376: goto L14;
                case 1795181803: goto La;
                default: goto L9;
            }
        L9:
            goto L65
        La:
            java.lang.String r0 = "android.permission-group.SMS"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L65
            r0 = 7
            goto L66
        L14:
            java.lang.String r0 = "android.permission-group.MICROPHONE"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L65
            r0 = 4
            goto L66
        L1e:
            java.lang.String r0 = "android.permission-group.STORAGE"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L65
            r0 = 8
            goto L66
        L29:
            java.lang.String r0 = "android.permission-group.LOCATION"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L65
            r0 = 3
            goto L66
        L33:
            java.lang.String r0 = "android.permission-group.SENSORS"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L65
            r0 = 6
            goto L66
        L3d:
            java.lang.String r0 = "android.permission-group.CAMERA"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L65
            r0 = 1
            goto L66
        L47:
            java.lang.String r0 = "android.permission-group.CALENDAR"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L65
            r0 = 0
            goto L66
        L51:
            java.lang.String r0 = "android.permission-group.PHONE"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L65
            r0 = 5
            goto L66
        L5b:
            java.lang.String r0 = "android.permission-group.CONTACTS"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L65
            r0 = 2
            goto L66
        L65:
            r0 = -1
        L66:
            switch(r0) {
                case 0: goto L8f;
                case 1: goto L8c;
                case 2: goto L89;
                case 3: goto L86;
                case 4: goto L83;
                case 5: goto L77;
                case 6: goto L74;
                case 7: goto L71;
                case 8: goto L6e;
                default: goto L69;
            }
        L69:
            java.lang.String[] r0 = new java.lang.String[r2]
            r0[r1] = r3
            return r0
        L6e:
            java.lang.String[] r3 = com.lxj.xpermission.b.s
            return r3
        L71:
            java.lang.String[] r3 = com.lxj.xpermission.b.r
            return r3
        L74:
            java.lang.String[] r3 = com.lxj.xpermission.b.q
            return r3
        L77:
            int r3 = android.os.Build.VERSION.SDK_INT
            r0 = 26
            if (r3 >= r0) goto L80
            java.lang.String[] r3 = com.lxj.xpermission.b.p
            return r3
        L80:
            java.lang.String[] r3 = com.lxj.xpermission.b.o
            return r3
        L83:
            java.lang.String[] r3 = com.lxj.xpermission.b.n
            return r3
        L86:
            java.lang.String[] r3 = com.lxj.xpermission.b.f7936m
            return r3
        L89:
            java.lang.String[] r3 = com.lxj.xpermission.b.f7935l
            return r3
        L8c:
            java.lang.String[] r3 = com.lxj.xpermission.b.f7934k
            return r3
        L8f:
            java.lang.String[] r3 = com.lxj.xpermission.b.f7933j
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lxj.xpermission.b.a(java.lang.String):java.lang.String[]");
    }
}
