package com.tencent.bugly.crashreport.crash;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.ad;
import com.tencent.bugly.proguard.ae;
import com.tencent.bugly.proguard.ag;
import com.tencent.bugly.proguard.ah;
import com.tencent.bugly.proguard.aj;
import com.tencent.bugly.proguard.ak;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.aq;
import com.tencent.bugly.proguard.bc;
import com.tencent.bugly.proguard.be;
import com.tencent.bugly.proguard.bf;
import com.tencent.bugly.proguard.bg;
import com.tencent.bugly.proguard.bh;
import com.tencent.bugly.proguard.bi;
import com.tencent.bugly.proguard.m;
import com.umeng.analytics.pro.bl;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import org.android.agoo.message.MessageService;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static int f9071a;

    /* renamed from: b, reason: collision with root package name */
    protected final Context f9072b;

    /* renamed from: c, reason: collision with root package name */
    protected final ak f9073c;

    /* renamed from: d, reason: collision with root package name */
    protected final ae f9074d;

    /* renamed from: e, reason: collision with root package name */
    protected final com.tencent.bugly.crashreport.common.strategy.a f9075e;

    /* renamed from: f, reason: collision with root package name */
    protected f f9076f;

    /* renamed from: g, reason: collision with root package name */
    protected BuglyStrategy.a f9077g;

    public b(int i2, Context context, ak akVar, ae aeVar, com.tencent.bugly.crashreport.common.strategy.a aVar, BuglyStrategy.a aVar2, f fVar) {
        f9071a = i2;
        this.f9072b = context;
        this.f9073c = akVar;
        this.f9074d = aeVar;
        this.f9075e = aVar;
        this.f9077g = aVar2;
        this.f9076f = fVar;
    }

    private boolean f(CrashDetailBean crashDetailBean) {
        try {
            an.c("save eup logs", new Object[0]);
            com.tencent.bugly.crashreport.common.info.a aVarB = com.tencent.bugly.crashreport.common.info.a.b();
            String str = String.format(Locale.US, "#--------\npackage:%s\nversion:%s\nsdk:%s\nprocess:%s\ndate:%s\ntype:%s\nmessage:%s\nstack:\n%s\neupID:%s\n", aVarB.f(), aVarB.p, aVarB.f8983j, crashDetailBean.A, aq.a(new Date(crashDetailBean.r)), crashDetailBean.n, crashDetailBean.o, crashDetailBean.q, crashDetailBean.f9024c);
            String absolutePath = null;
            if (c.f9089j != null) {
                File file = new File(c.f9089j);
                if (file.isFile()) {
                    file = file.getParentFile();
                }
                absolutePath = file.getAbsolutePath();
            } else if (Environment.getExternalStorageState().equals("mounted")) {
                absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Tencent/" + this.f9072b.getPackageName();
            }
            aq.a(this.f9072b, absolutePath + "/euplog.txt", str, c.f9090k);
            return true;
        } catch (Throwable th) {
            an.d("rqdp{  save error} %s", th.toString());
            if (!an.a(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }

    protected List<a> a(List<a> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (a aVar : list) {
            if (aVar.f9038d && aVar.f9036b <= jCurrentTimeMillis - 86400000) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    public void b(CrashDetailBean crashDetailBean) {
        int i2 = crashDetailBean.f9023b;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 3 && !c.a().q()) {
                    return;
                }
            } else if (!c.a().p()) {
                return;
            }
        } else if (!c.a().p()) {
            return;
        }
        if (this.f9076f != null) {
            an.c("Calling 'onCrashHandleEnd' of RQD crash listener.", new Object[0]);
            this.f9076f.b(crashDetailBean.f9023b == 1);
        }
    }

    public void c(CrashDetailBean crashDetailBean) {
        int i2;
        long j2;
        String str;
        String str2;
        Map<String, String> mapOnCrashHandleStart;
        int i3;
        byte[] bArrA;
        String strSubstring;
        HashMap map;
        if (crashDetailBean == null) {
            return;
        }
        if (this.f9077g == null && this.f9076f == null) {
            return;
        }
        try {
            switch (crashDetailBean.f9023b) {
                case 0:
                    if (c.a().p()) {
                        i2 = 0;
                        break;
                    } else {
                        return;
                    }
                case 1:
                    if (c.a().p()) {
                        i2 = 2;
                        break;
                    } else {
                        return;
                    }
                case 2:
                    i2 = 1;
                    break;
                case 3:
                    i2 = 4;
                    if (!c.a().q()) {
                        return;
                    }
                    break;
                case 4:
                    i2 = 3;
                    if (!c.a().r()) {
                        return;
                    }
                    break;
                case 5:
                    i2 = 5;
                    if (!c.a().s()) {
                        return;
                    }
                    break;
                case 6:
                    i2 = 6;
                    if (!c.a().t()) {
                        return;
                    }
                    break;
                case 7:
                    i2 = 7;
                    break;
                default:
                    return;
            }
            boolean z = crashDetailBean.f9023b == 1;
            String str3 = crashDetailBean.n;
            String str4 = crashDetailBean.p;
            String str5 = crashDetailBean.q;
            long j3 = crashDetailBean.r;
            byte[] bArrOnCrashHandleStart2GetExtraDatas = null;
            if (this.f9076f != null) {
                an.c("Calling 'onCrashHandleStart' of RQD crash listener.", new Object[0]);
                this.f9076f.a(z);
                an.c("Calling 'getCrashExtraMessage' of RQD crash listener.", new Object[0]);
                j2 = j3;
                str = str4;
                str2 = str5;
                String strB = this.f9076f.b(z, str3, str4, str5, -1234567890, j2);
                if (strB != null) {
                    map = new HashMap(1);
                    map.put(com.umeng.socialize.tracker.a.f11818h, strB);
                } else {
                    map = null;
                }
                mapOnCrashHandleStart = map;
            } else {
                j2 = j3;
                str = str4;
                str2 = str5;
                if (this.f9077g != null) {
                    an.c("Calling 'onCrashHandleStart' of Bugly crash listener.", new Object[0]);
                    mapOnCrashHandleStart = this.f9077g.onCrashHandleStart(i2, crashDetailBean.n, crashDetailBean.o, crashDetailBean.q);
                } else {
                    mapOnCrashHandleStart = null;
                }
            }
            if (mapOnCrashHandleStart != null && mapOnCrashHandleStart.size() > 0) {
                crashDetailBean.P = new LinkedHashMap(mapOnCrashHandleStart.size());
                for (Map.Entry<String, String> entry : mapOnCrashHandleStart.entrySet()) {
                    if (!aq.a(entry.getKey())) {
                        String key = entry.getKey();
                        if (key.length() > 100) {
                            key = key.substring(0, 100);
                            an.d("setted key length is over limit %d substring to %s", 100, key);
                        }
                        if (aq.a(entry.getValue()) || entry.getValue().length() <= 30000) {
                            strSubstring = "" + entry.getValue();
                        } else {
                            strSubstring = entry.getValue().substring(entry.getValue().length() - BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH);
                            an.d("setted %s value length is over limit %d substring", key, Integer.valueOf(BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH));
                        }
                        crashDetailBean.P.put(key, strSubstring);
                        an.a("add setted key %s value size:%d", key, Integer.valueOf(strSubstring.length()));
                    }
                }
            }
            an.a("[crash callback] start user's callback:onCrashHandleStart2GetExtraDatas()", new Object[0]);
            if (this.f9076f != null) {
                an.c("Calling 'getCrashExtraData' of RQD crash listener.", new Object[0]);
                bArrA = this.f9076f.a(z, str3, str, str2, -1234567890, j2);
                i3 = BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH;
            } else {
                i3 = BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH;
                if (this.f9077g != null) {
                    an.c("Calling 'onCrashHandleStart2GetExtraDatas' of Bugly crash listener.", new Object[0]);
                    bArrOnCrashHandleStart2GetExtraDatas = this.f9077g.onCrashHandleStart2GetExtraDatas(i2, crashDetailBean.n, crashDetailBean.o, crashDetailBean.q);
                }
                bArrA = bArrOnCrashHandleStart2GetExtraDatas;
            }
            crashDetailBean.U = bArrA;
            if (bArrA != null) {
                if (bArrA.length > i3) {
                    an.d("extra bytes size %d is over limit %d will drop over part", Integer.valueOf(bArrA.length), Integer.valueOf(i3));
                    crashDetailBean.U = Arrays.copyOf(bArrA, i3);
                }
                an.a("add extra bytes %d ", Integer.valueOf(bArrA.length));
            }
            if (this.f9076f != null) {
                an.c("Calling 'onCrashSaving' of RQD crash listener.", new Object[0]);
                if (this.f9076f.a(z, str3, crashDetailBean.o, str, str2, -1234567890, j2, crashDetailBean.f9034m, crashDetailBean.f9026e, crashDetailBean.f9024c, crashDetailBean.A, crashDetailBean.B)) {
                    return;
                }
                an.d("Crash listener 'onCrashSaving' return 'false' thus will not handle this crash.", new Object[0]);
            }
        } catch (Throwable th) {
            an.d("crash handle callback something wrong! %s", th.getClass().getName());
            if (an.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    protected ContentValues d(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (crashDetailBean.f9022a > 0) {
                contentValues.put(bl.f10170d, Long.valueOf(crashDetailBean.f9022a));
            }
            contentValues.put("_tm", Long.valueOf(crashDetailBean.r));
            contentValues.put("_s1", crashDetailBean.u);
            int i2 = 1;
            contentValues.put("_up", Integer.valueOf(crashDetailBean.f9025d ? 1 : 0));
            if (!crashDetailBean.f9031j) {
                i2 = 0;
            }
            contentValues.put("_me", Integer.valueOf(i2));
            contentValues.put("_uc", Integer.valueOf(crashDetailBean.f9033l));
            contentValues.put("_dt", aq.a(crashDetailBean));
            return contentValues;
        } catch (Throwable th) {
            if (!an.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public void e(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return;
        }
        ContentValues contentValuesD = d(crashDetailBean);
        if (contentValuesD != null) {
            long jA = ae.a().a("t_cr", contentValuesD, (ad) null, true);
            if (jA >= 0) {
                an.c("insert %s success!", "t_cr");
                crashDetailBean.f9022a = jA;
            }
        }
        if (c.f9088i) {
            f(crashDetailBean);
        }
    }

    public List<CrashDetailBean> b(List<a> list) {
        Cursor cursorA;
        if (list == null || list.size() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(bl.f10170d);
        sb.append(" in ");
        sb.append("(");
        Iterator<a> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next().f9035a);
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (sb.toString().contains(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            sb = new StringBuilder(sb.substring(0, sb.lastIndexOf(Constants.ACCEPT_TIME_SEPARATOR_SP)));
        }
        sb.append(")");
        String string = sb.toString();
        sb.setLength(0);
        try {
            cursorA = ae.a().a("t_cr", null, string, null, null, true);
            if (cursorA == null) {
                return null;
            }
            try {
                ArrayList arrayList = new ArrayList();
                sb.append(bl.f10170d);
                sb.append(" in ");
                sb.append("(");
                int i2 = 0;
                while (cursorA.moveToNext()) {
                    try {
                        CrashDetailBean crashDetailBeanA = a(cursorA);
                        if (crashDetailBeanA != null) {
                            arrayList.add(crashDetailBeanA);
                        } else {
                            try {
                                sb.append(cursorA.getLong(cursorA.getColumnIndex(bl.f10170d)));
                                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                i2++;
                            } catch (Throwable unused) {
                                an.d("unknown id!", new Object[0]);
                            }
                        }
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
                }
                if (sb.toString().contains(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                    sb = new StringBuilder(sb.substring(0, sb.lastIndexOf(Constants.ACCEPT_TIME_SEPARATOR_SP)));
                }
                sb.append(")");
                String string2 = sb.toString();
                if (i2 > 0) {
                    an.d("deleted %s illegal data %d", "t_cr", Integer.valueOf(ae.a().a("t_cr", string2, (String[]) null, (ad) null, true)));
                }
                if (cursorA != null) {
                    cursorA.close();
                }
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            cursorA = null;
        }
    }

    protected CrashDetailBean a(List<a> list, CrashDetailBean crashDetailBean) {
        List<CrashDetailBean> listB;
        String[] strArrSplit;
        if (list == null || list.size() == 0) {
            return crashDetailBean;
        }
        CrashDetailBean crashDetailBean2 = null;
        ArrayList arrayList = new ArrayList(10);
        for (a aVar : list) {
            if (aVar.f9039e) {
                arrayList.add(aVar);
            }
        }
        if (arrayList.size() > 0 && (listB = b(arrayList)) != null && listB.size() > 0) {
            Collections.sort(listB);
            CrashDetailBean crashDetailBean3 = null;
            for (int i2 = 0; i2 < listB.size(); i2++) {
                CrashDetailBean crashDetailBean4 = listB.get(i2);
                if (i2 == 0) {
                    crashDetailBean3 = crashDetailBean4;
                } else {
                    String str = crashDetailBean4.s;
                    if (str != null && (strArrSplit = str.split("\n")) != null) {
                        for (String str2 : strArrSplit) {
                            if (!crashDetailBean3.s.contains("" + str2)) {
                                crashDetailBean3.t++;
                                crashDetailBean3.s += str2 + "\n";
                            }
                        }
                    }
                }
            }
            crashDetailBean2 = crashDetailBean3;
        }
        if (crashDetailBean2 == null) {
            crashDetailBean.f9031j = true;
            crashDetailBean.t = 0;
            crashDetailBean.s = "";
            crashDetailBean2 = crashDetailBean;
        }
        for (a aVar2 : list) {
            if (!aVar2.f9039e && !aVar2.f9038d) {
                if (!crashDetailBean2.s.contains("" + aVar2.f9036b)) {
                    crashDetailBean2.t++;
                    crashDetailBean2.s += aVar2.f9036b + "\n";
                }
            }
        }
        if (crashDetailBean2.r != crashDetailBean.r) {
            if (!crashDetailBean2.s.contains("" + crashDetailBean.r)) {
                crashDetailBean2.t++;
                crashDetailBean2.s += crashDetailBean.r + "\n";
            }
        }
        return crashDetailBean2;
    }

    public void d(List<CrashDetailBean> list) {
        if (list != null) {
            try {
                if (list.size() == 0) {
                    return;
                }
                StringBuilder sb = new StringBuilder();
                for (CrashDetailBean crashDetailBean : list) {
                    sb.append(" or ");
                    sb.append(bl.f10170d);
                    sb.append(" = ");
                    sb.append(crashDetailBean.f9022a);
                }
                String string = sb.toString();
                if (string.length() > 0) {
                    string = string.substring(4);
                }
                sb.setLength(0);
                an.c("deleted %s data %d", "t_cr", Integer.valueOf(ae.a().a("t_cr", string, (String[]) null, (ad) null, true)));
            } catch (Throwable th) {
                if (an.a(th)) {
                    return;
                }
                th.printStackTrace();
            }
        }
    }

    public boolean a(CrashDetailBean crashDetailBean) {
        return a(crashDetailBean, -123456789);
    }

    protected a b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            a aVar = new a();
            aVar.f9035a = cursor.getLong(cursor.getColumnIndex(bl.f10170d));
            aVar.f9036b = cursor.getLong(cursor.getColumnIndex("_tm"));
            aVar.f9037c = cursor.getString(cursor.getColumnIndex("_s1"));
            aVar.f9038d = cursor.getInt(cursor.getColumnIndex("_up")) == 1;
            aVar.f9039e = cursor.getInt(cursor.getColumnIndex("_me")) == 1;
            aVar.f9040f = cursor.getInt(cursor.getColumnIndex("_uc"));
            return aVar;
        } catch (Throwable th) {
            if (!an.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public boolean a(CrashDetailBean crashDetailBean, int i2) {
        if (crashDetailBean == null) {
            return true;
        }
        String str = c.n;
        if (str != null && !str.isEmpty()) {
            an.c("Crash filter for crash stack is: %s", c.n);
            if (crashDetailBean.q.contains(c.n)) {
                an.d("This crash contains the filter string set. It will not be record and upload.", new Object[0]);
                return true;
            }
        }
        String str2 = c.o;
        if (str2 != null && !str2.isEmpty()) {
            an.c("Crash regular filter for crash stack is: %s", c.o);
            if (Pattern.compile(c.o).matcher(crashDetailBean.q).find()) {
                an.d("This crash matches the regular filter string set. It will not be record and upload.", new Object[0]);
                return true;
            }
        }
        if (crashDetailBean.f9023b != 2) {
            ag agVar = new ag();
            agVar.f9204b = 1;
            agVar.f9205c = crashDetailBean.A;
            agVar.f9206d = crashDetailBean.B;
            agVar.f9207e = crashDetailBean.r;
            this.f9074d.b(1);
            this.f9074d.a(agVar);
            an.b("[crash] a crash occur, handling...", new Object[0]);
        } else {
            an.b("[crash] a caught exception occur, handling...", new Object[0]);
        }
        List<a> listB = b();
        ArrayList arrayList = null;
        if (listB != null && listB.size() > 0) {
            arrayList = new ArrayList(10);
            ArrayList arrayList2 = new ArrayList(10);
            arrayList.addAll(a(listB));
            listB.removeAll(arrayList);
            if (listB.size() > 20) {
                a(5);
            }
            if (!com.tencent.bugly.b.f8759c && c.f9083d) {
                boolean z = false;
                for (a aVar : listB) {
                    if (crashDetailBean.u.equals(aVar.f9037c)) {
                        if (aVar.f9039e) {
                            z = true;
                        }
                        arrayList2.add(aVar);
                    }
                }
                if (z || arrayList2.size() >= c.f9082c) {
                    an.a("same crash occur too much do merged!", new Object[0]);
                    CrashDetailBean crashDetailBeanA = a(arrayList2, crashDetailBean);
                    for (a aVar2 : arrayList2) {
                        if (aVar2.f9035a != crashDetailBeanA.f9022a) {
                            arrayList.add(aVar2);
                        }
                    }
                    e(crashDetailBeanA);
                    c(arrayList);
                    an.b("[crash] save crash success. For this device crash many times, it will not upload crashes immediately", new Object[0]);
                    return true;
                }
            }
        }
        e(crashDetailBean);
        if (arrayList != null && !arrayList.isEmpty()) {
            c(arrayList);
        }
        an.b("[crash] save crash success", new Object[0]);
        return false;
    }

    public List<a> b() {
        Cursor cursorA;
        ArrayList arrayList = new ArrayList();
        try {
            cursorA = ae.a().a("t_cr", new String[]{bl.f10170d, "_tm", "_s1", "_up", "_me", "_uc"}, null, null, null, true);
            if (cursorA == null) {
                return null;
            }
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(bl.f10170d);
                sb.append(" in ");
                sb.append("(");
                int i2 = 0;
                while (cursorA.moveToNext()) {
                    try {
                        a aVarB = b(cursorA);
                        if (aVarB != null) {
                            arrayList.add(aVarB);
                        } else {
                            try {
                                sb.append(cursorA.getLong(cursorA.getColumnIndex(bl.f10170d)));
                                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                i2++;
                            } catch (Throwable unused) {
                                an.d("unknown id!", new Object[0]);
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            if (!an.a(th)) {
                                th.printStackTrace();
                            }
                            if (cursorA != null) {
                                cursorA.close();
                            }
                            return arrayList;
                        } finally {
                            if (cursorA != null) {
                                cursorA.close();
                            }
                        }
                    }
                }
                StringBuilder sb2 = sb.toString().contains(Constants.ACCEPT_TIME_SEPARATOR_SP) ? new StringBuilder(sb.substring(0, sb.lastIndexOf(Constants.ACCEPT_TIME_SEPARATOR_SP))) : sb;
                sb2.append(")");
                String string = sb2.toString();
                sb2.setLength(0);
                if (i2 > 0) {
                    an.d("deleted %s illegal data %d", "t_cr", Integer.valueOf(ae.a().a("t_cr", string, (String[]) null, (ad) null, true)));
                }
                if (cursorA != null) {
                    cursorA.close();
                }
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            cursorA = null;
        }
    }

    public void c(List<a> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(bl.f10170d);
        sb.append(" in ");
        sb.append("(");
        Iterator<a> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next().f9035a);
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        StringBuilder sb2 = new StringBuilder(sb.substring(0, sb.lastIndexOf(Constants.ACCEPT_TIME_SEPARATOR_SP)));
        sb2.append(")");
        String string = sb2.toString();
        sb2.setLength(0);
        try {
            an.c("deleted %s data %d", "t_cr", Integer.valueOf(ae.a().a("t_cr", string, (String[]) null, (ad) null, true)));
        } catch (Throwable th) {
            if (an.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public List<CrashDetailBean> a() {
        StrategyBean strategyBeanC = com.tencent.bugly.crashreport.common.strategy.a.a().c();
        if (strategyBeanC == null) {
            an.d("have not synced remote!", new Object[0]);
            return null;
        }
        if (!strategyBeanC.f8998g) {
            an.d("Crashreport remote closed, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            an.b("[init] WARNING! Crashreport closed by server, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jB = aq.b();
        List<a> listB = b();
        an.c("Size of crash list loaded from DB: %s", Integer.valueOf(listB.size()));
        if (listB == null || listB.size() <= 0) {
            return null;
        }
        List<a> arrayList = new ArrayList<>();
        arrayList.addAll(a(listB));
        listB.removeAll(arrayList);
        Iterator<a> it = listB.iterator();
        while (it.hasNext()) {
            a next = it.next();
            long j2 = next.f9036b;
            if (j2 < jB - c.f9086g) {
                it.remove();
                arrayList.add(next);
            } else if (next.f9038d) {
                if (j2 >= jCurrentTimeMillis - 86400000) {
                    it.remove();
                } else if (!next.f9039e) {
                    it.remove();
                    arrayList.add(next);
                }
            } else if (next.f9040f >= 3 && j2 < jCurrentTimeMillis - 86400000) {
                it.remove();
                arrayList.add(next);
            }
        }
        if (arrayList.size() > 0) {
            c(arrayList);
        }
        List<CrashDetailBean> arrayList2 = new ArrayList<>();
        List<CrashDetailBean> listB2 = b(listB);
        if (listB2 != null && listB2.size() > 0) {
            String str = com.tencent.bugly.crashreport.common.info.a.b().p;
            Iterator<CrashDetailBean> it2 = listB2.iterator();
            while (it2.hasNext()) {
                CrashDetailBean next2 = it2.next();
                if (!str.equals(next2.f9027f)) {
                    it2.remove();
                    arrayList2.add(next2);
                }
            }
        }
        if (arrayList2.size() > 0) {
            d(arrayList2);
        }
        return listB2;
    }

    public void a(CrashDetailBean crashDetailBean, long j2, boolean z) {
        if (c.f9091l) {
            an.a("try to upload right now", new Object[0]);
            ArrayList arrayList = new ArrayList();
            arrayList.add(crashDetailBean);
            a(arrayList, j2, z, crashDetailBean.f9023b == 7, z);
        }
    }

    public void a(final List<CrashDetailBean> list, long j2, boolean z, boolean z2, boolean z3) {
        ak akVar;
        if (com.tencent.bugly.crashreport.common.info.a.a(this.f9072b).f8981h && (akVar = this.f9073c) != null) {
            if (z3 || akVar.b(c.f9080a)) {
                StrategyBean strategyBeanC = this.f9075e.c();
                if (!strategyBeanC.f8998g) {
                    an.d("remote report is disable!", new Object[0]);
                    an.b("[crash] server closed bugly in this app. please check your appid if is correct, and re-install it", new Object[0]);
                    return;
                }
                if (list == null || list.size() == 0) {
                    return;
                }
                try {
                    String str = this.f9073c.f9215b ? strategyBeanC.s : strategyBeanC.t;
                    String str2 = this.f9073c.f9215b ? StrategyBean.f8994c : StrategyBean.f8992a;
                    int i2 = this.f9073c.f9215b ? 830 : 630;
                    bg bgVarA = a(this.f9072b, list, com.tencent.bugly.crashreport.common.info.a.b());
                    if (bgVarA == null) {
                        an.d("create eupPkg fail!", new Object[0]);
                        return;
                    }
                    byte[] bArrA = ah.a((m) bgVarA);
                    if (bArrA == null) {
                        an.d("send encode fail!", new Object[0]);
                        return;
                    }
                    bh bhVarA = ah.a(this.f9072b, i2, bArrA);
                    if (bhVarA == null) {
                        an.d("request package is null.", new Object[0]);
                        return;
                    }
                    aj ajVar = new aj() { // from class: com.tencent.bugly.crashreport.crash.b.1
                        @Override // com.tencent.bugly.proguard.aj
                        public void a(int i3) {
                        }

                        @Override // com.tencent.bugly.proguard.aj
                        public void a(int i3, bi biVar, long j3, long j4, boolean z4, String str3) {
                            b.this.a(z4, list);
                        }
                    };
                    if (z) {
                        this.f9073c.a(f9071a, bhVarA, str, str2, ajVar, j2, z2);
                    } else {
                        this.f9073c.a(f9071a, bhVarA, str, str2, ajVar, false);
                    }
                } catch (Throwable th) {
                    an.e("req cr error %s", th.toString());
                    if (an.b(th)) {
                        return;
                    }
                    th.printStackTrace();
                }
            }
        }
    }

    public void a(boolean z, List<CrashDetailBean> list) {
        if (list != null && list.size() > 0) {
            an.c("up finish update state %b", Boolean.valueOf(z));
            for (CrashDetailBean crashDetailBean : list) {
                an.c("pre uid:%s uc:%d re:%b me:%b", crashDetailBean.f9024c, Integer.valueOf(crashDetailBean.f9033l), Boolean.valueOf(crashDetailBean.f9025d), Boolean.valueOf(crashDetailBean.f9031j));
                crashDetailBean.f9033l++;
                crashDetailBean.f9025d = z;
                an.c("set uid:%s uc:%d re:%b me:%b", crashDetailBean.f9024c, Integer.valueOf(crashDetailBean.f9033l), Boolean.valueOf(crashDetailBean.f9025d), Boolean.valueOf(crashDetailBean.f9031j));
            }
            Iterator<CrashDetailBean> it = list.iterator();
            while (it.hasNext()) {
                c.a().a(it.next());
            }
            an.c("update state size %d", Integer.valueOf(list.size()));
        }
        if (z) {
            return;
        }
        an.b("[crash] upload fail.", new Object[0]);
    }

    protected CrashDetailBean a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j2 = cursor.getLong(cursor.getColumnIndex(bl.f10170d));
            CrashDetailBean crashDetailBean = (CrashDetailBean) aq.a(blob, CrashDetailBean.CREATOR);
            if (crashDetailBean != null) {
                crashDetailBean.f9022a = j2;
            }
            return crashDetailBean;
        } catch (Throwable th) {
            if (!an.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public void a(int i2) {
        if (i2 <= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(bl.f10170d);
        sb.append(" in ");
        sb.append("(");
        sb.append("SELECT ");
        sb.append(bl.f10170d);
        sb.append(" FROM ");
        sb.append("t_cr");
        sb.append(" order by ");
        sb.append(bl.f10170d);
        sb.append(" limit ");
        sb.append(i2);
        sb.append(")");
        String string = sb.toString();
        sb.setLength(0);
        try {
            an.c("deleted first record %s data %d", "t_cr", Integer.valueOf(ae.a().a("t_cr", string, (String[]) null, (ad) null, true)));
        } catch (Throwable th) {
            if (an.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public static bf a(Context context, CrashDetailBean crashDetailBean, com.tencent.bugly.crashreport.common.info.a aVar) throws IOException {
        be beVarA;
        be beVarA2;
        be beVar;
        if (context != null && crashDetailBean != null && aVar != null) {
            bf bfVar = new bf();
            int i2 = crashDetailBean.f9023b;
            switch (i2) {
                case 0:
                    bfVar.f9307a = crashDetailBean.f9031j ? "200" : MessageService.MSG_DB_COMPLETE;
                    break;
                case 1:
                    bfVar.f9307a = crashDetailBean.f9031j ? "201" : "101";
                    break;
                case 2:
                    bfVar.f9307a = crashDetailBean.f9031j ? "202" : "102";
                    break;
                case 3:
                    bfVar.f9307a = crashDetailBean.f9031j ? "203" : "103";
                    break;
                case 4:
                    bfVar.f9307a = crashDetailBean.f9031j ? "204" : "104";
                    break;
                case 5:
                    bfVar.f9307a = crashDetailBean.f9031j ? "207" : "107";
                    break;
                case 6:
                    bfVar.f9307a = crashDetailBean.f9031j ? "206" : "106";
                    break;
                case 7:
                    bfVar.f9307a = crashDetailBean.f9031j ? "208" : "108";
                    break;
                default:
                    an.e("crash type error! %d", Integer.valueOf(i2));
                    break;
            }
            bfVar.f9308b = crashDetailBean.r;
            bfVar.f9309c = crashDetailBean.n;
            bfVar.f9310d = crashDetailBean.o;
            bfVar.f9311e = crashDetailBean.p;
            bfVar.f9313g = crashDetailBean.q;
            bfVar.f9314h = crashDetailBean.z;
            bfVar.f9315i = crashDetailBean.f9024c;
            bfVar.f9316j = null;
            bfVar.f9318l = crashDetailBean.f9034m;
            bfVar.f9319m = crashDetailBean.f9026e;
            bfVar.f9312f = crashDetailBean.B;
            bfVar.t = com.tencent.bugly.crashreport.common.info.a.b().i();
            bfVar.n = null;
            Map<String, PlugInBean> map = crashDetailBean.f9030i;
            if (map != null && map.size() > 0) {
                bfVar.o = new ArrayList<>();
                for (Map.Entry<String, PlugInBean> entry : crashDetailBean.f9030i.entrySet()) {
                    bc bcVar = new bc();
                    bcVar.f9295a = entry.getValue().f8971a;
                    bcVar.f9297c = entry.getValue().f8973c;
                    bcVar.f9299e = entry.getValue().f8972b;
                    bcVar.f9296b = aVar.r();
                    bfVar.o.add(bcVar);
                }
            }
            Map<String, PlugInBean> map2 = crashDetailBean.f9029h;
            if (map2 != null && map2.size() > 0) {
                bfVar.p = new ArrayList<>();
                for (Map.Entry<String, PlugInBean> entry2 : crashDetailBean.f9029h.entrySet()) {
                    bc bcVar2 = new bc();
                    bcVar2.f9295a = entry2.getValue().f8971a;
                    bcVar2.f9297c = entry2.getValue().f8973c;
                    bcVar2.f9299e = entry2.getValue().f8972b;
                    bfVar.p.add(bcVar2);
                }
            }
            if (crashDetailBean.f9031j) {
                bfVar.f9317k = crashDetailBean.t;
                String str = crashDetailBean.s;
                if (str != null && str.length() > 0) {
                    if (bfVar.q == null) {
                        bfVar.q = new ArrayList<>();
                    }
                    try {
                        bfVar.q.add(new be((byte) 1, "alltimes.txt", crashDetailBean.s.getBytes("utf-8")));
                    } catch (UnsupportedEncodingException e2) {
                        e2.printStackTrace();
                        bfVar.q = null;
                    }
                }
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(bfVar.f9317k);
                ArrayList<be> arrayList = bfVar.q;
                objArr[1] = Integer.valueOf(arrayList != null ? arrayList.size() : 0);
                an.c("crashcount:%d sz:%d", objArr);
            }
            if (crashDetailBean.w != null) {
                if (bfVar.q == null) {
                    bfVar.q = new ArrayList<>();
                }
                try {
                    bfVar.q.add(new be((byte) 1, "log.txt", crashDetailBean.w.getBytes("utf-8")));
                } catch (UnsupportedEncodingException e3) {
                    e3.printStackTrace();
                    bfVar.q = null;
                }
            }
            if (crashDetailBean.x != null) {
                if (bfVar.q == null) {
                    bfVar.q = new ArrayList<>();
                }
                try {
                    bfVar.q.add(new be((byte) 1, "jniLog.txt", crashDetailBean.x.getBytes("utf-8")));
                } catch (UnsupportedEncodingException e4) {
                    e4.printStackTrace();
                    bfVar.q = null;
                }
            }
            if (!aq.a(crashDetailBean.V)) {
                if (bfVar.q == null) {
                    bfVar.q = new ArrayList<>();
                }
                try {
                    beVar = new be((byte) 1, "crashInfos.txt", crashDetailBean.V.getBytes("utf-8"));
                } catch (UnsupportedEncodingException e5) {
                    e5.printStackTrace();
                    beVar = null;
                }
                if (beVar != null) {
                    an.c("attach crash infos", new Object[0]);
                    bfVar.q.add(beVar);
                }
            }
            if (crashDetailBean.W != null) {
                if (bfVar.q == null) {
                    bfVar.q = new ArrayList<>();
                }
                be beVarA3 = a("backupRecord.zip", context, crashDetailBean.W);
                if (beVarA3 != null) {
                    an.c("attach backup record", new Object[0]);
                    bfVar.q.add(beVarA3);
                }
            }
            byte[] bArr = crashDetailBean.y;
            if (bArr != null && bArr.length > 0) {
                be beVar2 = new be((byte) 2, "buglylog.zip", bArr);
                an.c("attach user log", new Object[0]);
                if (bfVar.q == null) {
                    bfVar.q = new ArrayList<>();
                }
                bfVar.q.add(beVar2);
            }
            if (crashDetailBean.f9023b == 3) {
                if (bfVar.q == null) {
                    bfVar.q = new ArrayList<>();
                }
                an.c("crashBean.userDatas:%s", crashDetailBean.P);
                Map<String, String> map3 = crashDetailBean.P;
                if (map3 != null && map3.containsKey("BUGLY_CR_01")) {
                    try {
                        if (!TextUtils.isEmpty(crashDetailBean.P.get("BUGLY_CR_01"))) {
                            bfVar.q.add(new be((byte) 1, "anrMessage.txt", crashDetailBean.P.get("BUGLY_CR_01").getBytes("utf-8")));
                            an.c("attach anr message", new Object[0]);
                        }
                    } catch (UnsupportedEncodingException e6) {
                        e6.printStackTrace();
                        bfVar.q = null;
                    }
                    crashDetailBean.P.remove("BUGLY_CR_01");
                }
                String str2 = crashDetailBean.v;
                if (str2 != null && (beVarA2 = a("trace.zip", context, str2)) != null) {
                    an.c("attach traces", new Object[0]);
                    bfVar.q.add(beVarA2);
                }
            }
            if (crashDetailBean.f9023b == 1) {
                if (bfVar.q == null) {
                    bfVar.q = new ArrayList<>();
                }
                String str3 = crashDetailBean.v;
                if (str3 != null && (beVarA = a("tomb.zip", context, str3)) != null) {
                    an.c("attach tombs", new Object[0]);
                    bfVar.q.add(beVarA);
                }
            }
            List<String> list = aVar.M;
            if (list != null && !list.isEmpty()) {
                if (bfVar.q == null) {
                    bfVar.q = new ArrayList<>();
                }
                StringBuilder sb = new StringBuilder();
                Iterator<String> it = aVar.M.iterator();
                while (it.hasNext()) {
                    sb.append(it.next());
                }
                try {
                    bfVar.q.add(new be((byte) 1, "martianlog.txt", sb.toString().getBytes("utf-8")));
                    an.c("attach pageTracingList", new Object[0]);
                } catch (UnsupportedEncodingException e7) {
                    e7.printStackTrace();
                }
            }
            byte[] bArr2 = crashDetailBean.U;
            if (bArr2 != null && bArr2.length > 0) {
                if (bfVar.q == null) {
                    bfVar.q = new ArrayList<>();
                }
                bfVar.q.add(new be((byte) 1, "userExtraByteData", crashDetailBean.U));
                an.c("attach extraData", new Object[0]);
            }
            bfVar.r = new HashMap();
            bfVar.r.put("A9", "" + crashDetailBean.C);
            bfVar.r.put("A11", "" + crashDetailBean.D);
            bfVar.r.put("A10", "" + crashDetailBean.E);
            bfVar.r.put("A23", "" + crashDetailBean.f9027f);
            bfVar.r.put("A7", "" + aVar.f8985l);
            bfVar.r.put("A6", "" + aVar.s());
            bfVar.r.put("A5", "" + aVar.r());
            bfVar.r.put("A22", "" + aVar.h());
            bfVar.r.put("A2", "" + crashDetailBean.G);
            bfVar.r.put("A1", "" + crashDetailBean.F);
            bfVar.r.put("A24", "" + aVar.n);
            bfVar.r.put("A17", "" + crashDetailBean.H);
            bfVar.r.put("A3", "" + aVar.k());
            bfVar.r.put("A16", "" + aVar.m());
            bfVar.r.put("A25", "" + aVar.n());
            bfVar.r.put("A14", "" + aVar.l());
            bfVar.r.put("A15", "" + aVar.w());
            bfVar.r.put("A13", "" + aVar.x());
            bfVar.r.put("A34", "" + crashDetailBean.A);
            if (aVar.E != null) {
                bfVar.r.put("productIdentify", "" + aVar.E);
            }
            try {
                bfVar.r.put("A26", "" + URLEncoder.encode(crashDetailBean.I, "utf-8"));
            } catch (UnsupportedEncodingException e8) {
                e8.printStackTrace();
            }
            if (crashDetailBean.f9023b == 1) {
                bfVar.r.put("A27", "" + crashDetailBean.L);
                bfVar.r.put("A28", "" + crashDetailBean.K);
                bfVar.r.put("A29", "" + crashDetailBean.f9032k);
            }
            bfVar.r.put("A30", "" + crashDetailBean.M);
            bfVar.r.put("A18", "" + crashDetailBean.N);
            Map<String, String> map4 = bfVar.r;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("");
            sb2.append(!crashDetailBean.O);
            map4.put("A36", sb2.toString());
            bfVar.r.put("F02", "" + aVar.x);
            bfVar.r.put("F03", "" + aVar.y);
            bfVar.r.put("F04", "" + aVar.e());
            bfVar.r.put("F05", "" + aVar.z);
            bfVar.r.put("F06", "" + aVar.w);
            bfVar.r.put("F08", "" + aVar.C);
            bfVar.r.put("F09", "" + aVar.D);
            bfVar.r.put("F10", "" + aVar.A);
            if (crashDetailBean.Q >= 0) {
                bfVar.r.put("C01", "" + crashDetailBean.Q);
            }
            if (crashDetailBean.R >= 0) {
                bfVar.r.put("C02", "" + crashDetailBean.R);
            }
            Map<String, String> map5 = crashDetailBean.S;
            if (map5 != null && map5.size() > 0) {
                for (Map.Entry<String, String> entry3 : crashDetailBean.S.entrySet()) {
                    bfVar.r.put("C03_" + entry3.getKey(), entry3.getValue());
                }
            }
            Map<String, String> map6 = crashDetailBean.T;
            if (map6 != null && map6.size() > 0) {
                for (Map.Entry<String, String> entry4 : crashDetailBean.T.entrySet()) {
                    bfVar.r.put("C04_" + entry4.getKey(), entry4.getValue());
                }
            }
            bfVar.s = null;
            Map<String, String> map7 = crashDetailBean.P;
            if (map7 != null && map7.size() > 0) {
                bfVar.s = crashDetailBean.P;
                an.a("setted message size %d", Integer.valueOf(bfVar.s.size()));
            }
            Object[] objArr2 = new Object[12];
            objArr2[0] = crashDetailBean.n;
            objArr2[1] = crashDetailBean.f9024c;
            objArr2[2] = aVar.e();
            objArr2[3] = Long.valueOf((crashDetailBean.r - crashDetailBean.N) / 1000);
            objArr2[4] = Boolean.valueOf(crashDetailBean.f9032k);
            objArr2[5] = Boolean.valueOf(crashDetailBean.O);
            objArr2[6] = Boolean.valueOf(crashDetailBean.f9031j);
            objArr2[7] = Boolean.valueOf(crashDetailBean.f9023b == 1);
            objArr2[8] = Integer.valueOf(crashDetailBean.t);
            objArr2[9] = crashDetailBean.s;
            objArr2[10] = Boolean.valueOf(crashDetailBean.f9025d);
            objArr2[11] = Integer.valueOf(bfVar.r.size());
            an.c("%s rid:%s sess:%s ls:%ds isR:%b isF:%b isM:%b isN:%b mc:%d ,%s ,isUp:%b ,vm:%d", objArr2);
            return bfVar;
        }
        an.d("enExp args == null", new Object[0]);
        return null;
    }

    public static bg a(Context context, List<CrashDetailBean> list, com.tencent.bugly.crashreport.common.info.a aVar) {
        if (context != null && list != null && list.size() != 0 && aVar != null) {
            bg bgVar = new bg();
            bgVar.f9321a = new ArrayList<>();
            Iterator<CrashDetailBean> it = list.iterator();
            while (it.hasNext()) {
                bgVar.f9321a.add(a(context, it.next(), aVar));
            }
            return bgVar;
        }
        an.d("enEXPPkg args == null!", new Object[0]);
        return null;
    }

    public static be a(String str, Context context, String str2) throws IOException {
        FileInputStream fileInputStream;
        if (str2 != null && context != null) {
            an.c("zip %s", str2);
            File file = new File(str2);
            File file2 = new File(context.getCacheDir(), str);
            if (!aq.a(file, file2, 5000)) {
                an.d("zip fail!", new Object[0]);
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                fileInputStream = new FileInputStream(file2);
            } catch (Throwable th) {
                th = th;
                fileInputStream = null;
            }
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int i2 = fileInputStream.read(bArr);
                    if (i2 <= 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i2);
                    byteArrayOutputStream.flush();
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                an.c("read bytes :%d", Integer.valueOf(byteArray.length));
                be beVar = new be((byte) 2, file2.getName(), byteArray);
                try {
                    fileInputStream.close();
                } catch (IOException e2) {
                    if (!an.a(e2)) {
                        e2.printStackTrace();
                    }
                }
                if (file2.exists()) {
                    an.c("del tmp", new Object[0]);
                    file2.delete();
                }
                return beVar;
            } catch (Throwable th2) {
                th = th2;
                try {
                    if (!an.a(th)) {
                        th.printStackTrace();
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                            if (!an.a(e3)) {
                                e3.printStackTrace();
                            }
                        }
                    }
                    if (file2.exists()) {
                        an.c("del tmp", new Object[0]);
                        file2.delete();
                    }
                    return null;
                } catch (Throwable th3) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e4) {
                            if (!an.a(e4)) {
                                e4.printStackTrace();
                            }
                        }
                    }
                    if (file2.exists()) {
                        an.c("del tmp", new Object[0]);
                        file2.delete();
                    }
                    throw th3;
                }
            }
        }
        an.d("rqdp{  createZipAttachment sourcePath == null || context == null ,pls check}", new Object[0]);
        return null;
    }

    public static void a(String str, String str2, String str3, String str4, String str5, CrashDetailBean crashDetailBean) {
        String str6;
        com.tencent.bugly.crashreport.common.info.a aVarB = com.tencent.bugly.crashreport.common.info.a.b();
        if (aVarB == null) {
            return;
        }
        an.e("#++++++++++Record By Bugly++++++++++#", new Object[0]);
        an.e("# You can use Bugly(http:\\\\bugly.qq.com) to get more Crash Detail!", new Object[0]);
        an.e("# PKG NAME: %s", aVarB.f8977d);
        an.e("# APP VER: %s", aVarB.p);
        an.e("# SDK VER: %s", aVarB.f8983j);
        an.e("# LAUNCH TIME: %s", aq.a(new Date(com.tencent.bugly.crashreport.common.info.a.b().f8974a)));
        an.e("# CRASH TYPE: %s", str);
        an.e("# CRASH TIME: %s", str2);
        an.e("# CRASH PROCESS: %s", str3);
        an.e("# CRASH THREAD: %s", str4);
        if (crashDetailBean != null) {
            an.e("# REPORT ID: %s", crashDetailBean.f9024c);
            Object[] objArr = new Object[2];
            objArr[0] = aVarB.f8986m;
            objArr[1] = aVarB.x().booleanValue() ? "ROOTED" : "UNROOT";
            an.e("# CRASH DEVICE: %s %s", objArr);
            an.e("# RUNTIME AVAIL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.C), Long.valueOf(crashDetailBean.D), Long.valueOf(crashDetailBean.E));
            an.e("# RUNTIME TOTAL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.F), Long.valueOf(crashDetailBean.G), Long.valueOf(crashDetailBean.H));
            if (!aq.a(crashDetailBean.L)) {
                an.e("# EXCEPTION FIRED BY %s %s", crashDetailBean.L, crashDetailBean.K);
            } else if (crashDetailBean.f9023b == 3) {
                Object[] objArr2 = new Object[1];
                if (crashDetailBean.P == null) {
                    str6 = c.c.a.b.a.a.f3101h;
                } else {
                    str6 = "" + crashDetailBean.P.get("BUGLY_CR_01");
                }
                objArr2[0] = str6;
                an.e("# EXCEPTION ANR MESSAGE:\n %s", objArr2);
            }
        }
        if (!aq.a(str5)) {
            an.e("# CRASH STACK: ", new Object[0]);
            an.e(str5, new Object[0]);
        }
        an.e("#++++++++++++++++++++++++++++++++++++++++++#", new Object[0]);
    }
}
