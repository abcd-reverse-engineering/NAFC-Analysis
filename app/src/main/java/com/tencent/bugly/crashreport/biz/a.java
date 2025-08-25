package com.tencent.bugly.crashreport.biz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.tencent.bugly.proguard.ad;
import com.tencent.bugly.proguard.ae;
import com.tencent.bugly.proguard.am;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.aq;
import com.umeng.analytics.pro.bl;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private Context f8940a;

    /* renamed from: b, reason: collision with root package name */
    private long f8941b;

    /* renamed from: c, reason: collision with root package name */
    private int f8942c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f8943d;

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.crashreport.biz.a$a, reason: collision with other inner class name */
    class RunnableC0123a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        private boolean f8948b;

        /* renamed from: c, reason: collision with root package name */
        private UserInfoBean f8949c;

        public RunnableC0123a(UserInfoBean userInfoBean, boolean z) {
            this.f8949c = userInfoBean;
            this.f8948b = z;
        }

        private void a(UserInfoBean userInfoBean) {
            com.tencent.bugly.crashreport.common.info.a aVarB;
            if (userInfoBean == null || (aVarB = com.tencent.bugly.crashreport.common.info.a.b()) == null) {
                return;
            }
            userInfoBean.f8936j = aVarB.e();
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.f8949c != null) {
                    a(this.f8949c);
                    an.c("[UserInfo] Record user info.", new Object[0]);
                    a.this.a(this.f8949c, false);
                }
                if (this.f8948b) {
                    a.this.b();
                }
            } catch (Throwable th) {
                if (an.a(th)) {
                    return;
                }
                th.printStackTrace();
            }
        }
    }

    /* compiled from: BUGLY */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis < a.this.f8941b) {
                am.a().a(a.this.new b(), (a.this.f8941b - jCurrentTimeMillis) + com.heytap.mcssdk.constant.a.r);
            } else {
                a.this.a(3, false, 0L);
                a.this.a();
            }
        }
    }

    /* compiled from: BUGLY */
    class c implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        private long f8952b;

        public c(long j2) {
            this.f8952b = 21600000L;
            this.f8952b = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.b();
            a.this.b(this.f8952b);
        }
    }

    public a(Context context, boolean z) {
        this.f8943d = true;
        this.f8940a = context;
        this.f8943d = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00f2 A[Catch: all -> 0x018b, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0007, B:11:0x000f, B:15:0x0017, B:17:0x001d, B:21:0x0027, B:23:0x003c, B:26:0x0045, B:28:0x004c, B:29:0x004f, B:31:0x0055, B:33:0x0069, B:34:0x0079, B:38:0x0081, B:39:0x008b, B:40:0x0090, B:42:0x0096, B:44:0x00a4, B:46:0x00b1, B:47:0x00b4, B:49:0x00c2, B:51:0x00c6, B:53:0x00cb, B:55:0x00d0, B:58:0x00d7, B:61:0x00ec, B:63:0x00f2, B:65:0x00f7, B:68:0x00ff, B:72:0x0117, B:74:0x011d, B:77:0x0126, B:79:0x012c, B:82:0x0135, B:86:0x013e, B:88:0x0146, B:91:0x014f, B:93:0x0160, B:95:0x0165, B:97:0x016a, B:99:0x016f, B:103:0x017d, B:98:0x016d, B:94:0x0163, B:106:0x0182, B:59:0x00e6), top: B:112:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x011d A[Catch: all -> 0x018b, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0007, B:11:0x000f, B:15:0x0017, B:17:0x001d, B:21:0x0027, B:23:0x003c, B:26:0x0045, B:28:0x004c, B:29:0x004f, B:31:0x0055, B:33:0x0069, B:34:0x0079, B:38:0x0081, B:39:0x008b, B:40:0x0090, B:42:0x0096, B:44:0x00a4, B:46:0x00b1, B:47:0x00b4, B:49:0x00c2, B:51:0x00c6, B:53:0x00cb, B:55:0x00d0, B:58:0x00d7, B:61:0x00ec, B:63:0x00f2, B:65:0x00f7, B:68:0x00ff, B:72:0x0117, B:74:0x011d, B:77:0x0126, B:79:0x012c, B:82:0x0135, B:86:0x013e, B:88:0x0146, B:91:0x014f, B:93:0x0160, B:95:0x0165, B:97:0x016a, B:99:0x016f, B:103:0x017d, B:98:0x016d, B:94:0x0163, B:106:0x0182, B:59:0x00e6), top: B:112:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0126 A[Catch: all -> 0x018b, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0007, B:11:0x000f, B:15:0x0017, B:17:0x001d, B:21:0x0027, B:23:0x003c, B:26:0x0045, B:28:0x004c, B:29:0x004f, B:31:0x0055, B:33:0x0069, B:34:0x0079, B:38:0x0081, B:39:0x008b, B:40:0x0090, B:42:0x0096, B:44:0x00a4, B:46:0x00b1, B:47:0x00b4, B:49:0x00c2, B:51:0x00c6, B:53:0x00cb, B:55:0x00d0, B:58:0x00d7, B:61:0x00ec, B:63:0x00f2, B:65:0x00f7, B:68:0x00ff, B:72:0x0117, B:74:0x011d, B:77:0x0126, B:79:0x012c, B:82:0x0135, B:86:0x013e, B:88:0x0146, B:91:0x014f, B:93:0x0160, B:95:0x0165, B:97:0x016a, B:99:0x016f, B:103:0x017d, B:98:0x016d, B:94:0x0163, B:106:0x0182, B:59:0x00e6), top: B:112:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void c() {
        /*
            Method dump skipped, instructions count: 398
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.biz.a.c():void");
    }

    public void b(long j2) {
        am.a().a(new c(j2), j2);
    }

    private static UserInfoBean a(Context context, int i2) {
        com.tencent.bugly.crashreport.common.info.a aVarA = com.tencent.bugly.crashreport.common.info.a.a(context);
        UserInfoBean userInfoBean = new UserInfoBean();
        userInfoBean.f8928b = i2;
        userInfoBean.f8929c = aVarA.f8978e;
        userInfoBean.f8930d = aVarA.g();
        userInfoBean.f8931e = System.currentTimeMillis();
        userInfoBean.f8932f = -1L;
        userInfoBean.n = aVarA.p;
        userInfoBean.o = i2 != 1 ? 0 : 1;
        userInfoBean.f8938l = aVarA.a();
        userInfoBean.f8939m = aVarA.w;
        userInfoBean.f8933g = aVarA.x;
        userInfoBean.f8934h = aVarA.y;
        userInfoBean.f8935i = aVarA.z;
        userInfoBean.f8937k = aVarA.A;
        userInfoBean.r = aVarA.B();
        userInfoBean.s = aVarA.G();
        userInfoBean.p = aVarA.H();
        userInfoBean.q = aVarA.I();
        return userInfoBean;
    }

    public void b() {
        am amVarA = am.a();
        if (amVarA != null) {
            amVarA.a(new Runnable() { // from class: com.tencent.bugly.crashreport.biz.a.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a.this.c();
                    } catch (Throwable th) {
                        an.a(th);
                    }
                }
            });
        }
    }

    public void a(int i2, boolean z, long j2) {
        com.tencent.bugly.crashreport.common.strategy.a aVarA = com.tencent.bugly.crashreport.common.strategy.a.a();
        if (aVarA != null && !aVarA.c().f8999h && i2 != 1 && i2 != 3) {
            an.e("UserInfo is disable", new Object[0]);
            return;
        }
        if (i2 == 1 || i2 == 3) {
            this.f8942c++;
        }
        am.a().a(new RunnableC0123a(a(this.f8940a, i2), z), j2);
    }

    public void a(long j2) {
        am.a().a(new RunnableC0123a(null, true), j2);
    }

    public void a() {
        this.f8941b = aq.b() + 86400000;
        am.a().a(new b(), (this.f8941b - System.currentTimeMillis()) + com.heytap.mcssdk.constant.a.r);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserInfoBean userInfoBean, boolean z) {
        List<UserInfoBean> listA;
        if (userInfoBean == null) {
            return;
        }
        if (!z && userInfoBean.f8928b != 1 && (listA = a(com.tencent.bugly.crashreport.common.info.a.a(this.f8940a).f8978e)) != null && listA.size() >= 20) {
            an.a("[UserInfo] There are too many user info in local: %d", Integer.valueOf(listA.size()));
            return;
        }
        long jA = ae.a().a("t_ui", a(userInfoBean), (ad) null, true);
        if (jA >= 0) {
            an.c("[Database] insert %s success with ID: %d", "t_ui", Long.valueOf(jA));
            userInfoBean.f8927a = jA;
        }
    }

    public List<UserInfoBean> a(String str) {
        Cursor cursorA;
        String str2;
        try {
            if (aq.a(str)) {
                str2 = null;
            } else {
                str2 = "_pc = '" + str + "'";
            }
            cursorA = ae.a().a("t_ui", null, str2, null, null, true);
            if (cursorA == null) {
                return null;
            }
            try {
                StringBuilder sb = new StringBuilder();
                ArrayList arrayList = new ArrayList();
                while (cursorA.moveToNext()) {
                    UserInfoBean userInfoBeanA = a(cursorA);
                    if (userInfoBeanA != null) {
                        arrayList.add(userInfoBeanA);
                    } else {
                        try {
                            long j2 = cursorA.getLong(cursorA.getColumnIndex(bl.f10170d));
                            sb.append(" or ");
                            sb.append(bl.f10170d);
                            sb.append(" = ");
                            sb.append(j2);
                        } catch (Throwable unused) {
                            an.d("[Database] unknown id.", new Object[0]);
                        }
                    }
                }
                String string = sb.toString();
                if (string.length() > 0) {
                    an.d("[Database] deleted %s error data %d", "t_ui", Integer.valueOf(ae.a().a("t_ui", string.substring(4), (String[]) null, (ad) null, true)));
                }
                if (cursorA != null) {
                    cursorA.close();
                }
                return arrayList;
            } catch (Throwable th) {
                th = th;
                try {
                    if (!an.a(th)) {
                        th.printStackTrace();
                    }
                    if (cursorA != null) {
                        cursorA.close();
                    }
                    return null;
                } finally {
                    if (cursorA != null) {
                        cursorA.close();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursorA = null;
        }
    }

    public void a(List<UserInfoBean> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < list.size() && i2 < 50; i2++) {
            UserInfoBean userInfoBean = list.get(i2);
            sb.append(" or ");
            sb.append(bl.f10170d);
            sb.append(" = ");
            sb.append(userInfoBean.f8927a);
        }
        String string = sb.toString();
        if (string.length() > 0) {
            string = string.substring(4);
        }
        String str = string;
        sb.setLength(0);
        try {
            an.c("[Database] deleted %s data %d", "t_ui", Integer.valueOf(ae.a().a("t_ui", str, (String[]) null, (ad) null, true)));
        } catch (Throwable th) {
            if (an.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    protected ContentValues a(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (userInfoBean.f8927a > 0) {
                contentValues.put(bl.f10170d, Long.valueOf(userInfoBean.f8927a));
            }
            contentValues.put("_tm", Long.valueOf(userInfoBean.f8931e));
            contentValues.put("_ut", Long.valueOf(userInfoBean.f8932f));
            contentValues.put(bl.f10171e, Integer.valueOf(userInfoBean.f8928b));
            contentValues.put("_pc", userInfoBean.f8929c);
            contentValues.put("_dt", aq.a(userInfoBean));
            return contentValues;
        } catch (Throwable th) {
            if (!an.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    protected UserInfoBean a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j2 = cursor.getLong(cursor.getColumnIndex(bl.f10170d));
            UserInfoBean userInfoBean = (UserInfoBean) aq.a(blob, UserInfoBean.CREATOR);
            if (userInfoBean != null) {
                userInfoBean.f8927a = j2;
            }
            return userInfoBean;
        } catch (Throwable th) {
            if (!an.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }
}
