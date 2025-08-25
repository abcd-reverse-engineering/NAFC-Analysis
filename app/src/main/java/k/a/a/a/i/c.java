package k.a.a.a.i;

import java.util.ArrayList;
import java.util.List;

/* compiled from: VersionUpdateHelper.java */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static List<a> f17030a;

    static {
        ArrayList arrayList = new ArrayList();
        f17030a = arrayList;
        arrayList.add(new d());
        f17030a.add(new b());
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001e A[Catch: all -> 0x003d, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x000e, B:11:0x001e, B:12:0x0024, B:14:0x002a, B:15:0x0034, B:8:0x0013), top: B:23:0x0003, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized void a(android.content.Context r5) {
        /*
            java.lang.Class<k.a.a.a.i.c> r0 = k.a.a.a.i.c.class
            monitor-enter(r0)
            java.lang.String r1 = k.a.a.a.c.a(r5)     // Catch: java.lang.Throwable -> L3d
            r2 = -1
            boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L3d
            if (r3 != 0) goto L1b
            int r2 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.Exception -> L13 java.lang.Throwable -> L3d
            goto L1b
        L13:
            java.lang.String r1 = "VersionUpdateHelper"
            java.lang.String r3 = "parse encryptversion error:"
            r4 = 1
            k.a.a.a.j.e.a(r1, r3, r4)     // Catch: java.lang.Throwable -> L3d
        L1b:
            r1 = 3
            if (r2 >= r1) goto L34
            java.util.List<k.a.a.a.i.a> r3 = k.a.a.a.i.c.f17030a     // Catch: java.lang.Throwable -> L3d
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L3d
        L24:
            boolean r4 = r3.hasNext()     // Catch: java.lang.Throwable -> L3d
            if (r4 == 0) goto L34
            java.lang.Object r4 = r3.next()     // Catch: java.lang.Throwable -> L3d
            k.a.a.a.i.a r4 = (k.a.a.a.i.a) r4     // Catch: java.lang.Throwable -> L3d
            r4.a(r5, r2, r1)     // Catch: java.lang.Throwable -> L3d
            goto L24
        L34:
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch: java.lang.Throwable -> L3d
            k.a.a.a.c.c(r5, r1)     // Catch: java.lang.Throwable -> L3d
            monitor-exit(r0)
            return
        L3d:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: k.a.a.a.i.c.a(android.content.Context):void");
    }
}
