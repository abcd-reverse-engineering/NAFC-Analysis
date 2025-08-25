package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public abstract class fo {

    /* renamed from: b, reason: collision with root package name */
    private static long f12856b;

    /* renamed from: c, reason: collision with root package name */
    private static String f12857c;

    /* renamed from: a, reason: collision with other field name */
    public long f529a;

    /* renamed from: a, reason: collision with other field name */
    private fs f530a;

    /* renamed from: a, reason: collision with other field name */
    private List<fl> f531a;

    /* renamed from: a, reason: collision with other field name */
    private final Map<String, Object> f532a;

    /* renamed from: d, reason: collision with root package name */
    private String f12858d;

    /* renamed from: e, reason: collision with root package name */
    private String f12859e;

    /* renamed from: f, reason: collision with root package name */
    private String f12860f;

    /* renamed from: g, reason: collision with root package name */
    private String f12861g;

    /* renamed from: h, reason: collision with root package name */
    private String f12862h;

    /* renamed from: i, reason: collision with root package name */
    private String f12863i;

    /* renamed from: a, reason: collision with root package name */
    protected static final String f12855a = Locale.getDefault().getLanguage().toLowerCase();

    /* renamed from: b, reason: collision with other field name */
    private static String f528b = null;

    /* renamed from: a, reason: collision with other field name */
    public static final DateFormat f527a = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    static {
        f527a.setTimeZone(TimeZone.getTimeZone("UTC"));
        f12857c = fx.a(5) + Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        f12856b = 0L;
    }

    public fo() {
        this.f12858d = f528b;
        this.f12859e = null;
        this.f12860f = null;
        this.f12861g = null;
        this.f12862h = null;
        this.f12863i = null;
        this.f531a = new CopyOnWriteArrayList();
        this.f532a = new HashMap();
        this.f530a = null;
    }

    public static synchronized String i() {
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append(f12857c);
        long j2 = f12856b;
        f12856b = 1 + j2;
        sb.append(Long.toString(j2));
        return sb.toString();
    }

    public static String q() {
        return f12855a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public fs m432a() {
        return this.f530a;
    }

    /* renamed from: a */
    public abstract String mo431a();

    public synchronized Collection<String> b() {
        if (this.f532a == null) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(new HashSet(this.f532a.keySet()));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        fo foVar = (fo) obj;
        fs fsVar = this.f530a;
        if (fsVar == null ? foVar.f530a != null : !fsVar.equals(foVar.f530a)) {
            return false;
        }
        String str = this.f12861g;
        if (str == null ? foVar.f12861g != null : !str.equals(foVar.f12861g)) {
            return false;
        }
        if (!this.f531a.equals(foVar.f531a)) {
            return false;
        }
        String str2 = this.f12859e;
        if (str2 == null ? foVar.f12859e != null : !str2.equals(foVar.f12859e)) {
            return false;
        }
        String str3 = this.f12862h;
        if (str3 == null ? foVar.f12862h != null : !str3.equals(foVar.f12862h)) {
            return false;
        }
        Map<String, Object> map = this.f532a;
        if (map == null ? foVar.f532a != null : !map.equals(foVar.f532a)) {
            return false;
        }
        String str4 = this.f12860f;
        if (str4 == null ? foVar.f12860f != null : !str4.equals(foVar.f12860f)) {
            return false;
        }
        String str5 = this.f12858d;
        String str6 = foVar.f12858d;
        if (str5 != null) {
            if (str5.equals(str6)) {
                return true;
            }
        } else if (str6 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.f12858d;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f12859e;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f12860f;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f12861g;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f12862h;
        int iHashCode5 = (((((iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.f531a.hashCode()) * 31) + this.f532a.hashCode()) * 31;
        fs fsVar = this.f530a;
        return iHashCode5 + (fsVar != null ? fsVar.hashCode() : 0);
    }

    public String j() {
        if ("ID_NOT_AVAILABLE".equals(this.f12859e)) {
            return null;
        }
        if (this.f12859e == null) {
            this.f12859e = i();
        }
        return this.f12859e;
    }

    public void k(String str) {
        this.f12859e = str;
    }

    public void l(String str) {
        this.f12862h = str;
    }

    public void m(String str) {
        this.f12860f = str;
    }

    public void n(String str) {
        this.f12861g = str;
    }

    public void o(String str) {
        this.f12863i = str;
    }

    public String p() {
        return this.f12858d;
    }

    public void a(fs fsVar) {
        this.f530a = fsVar;
    }

    public String k() {
        return this.f12862h;
    }

    public String l() {
        return this.f12860f;
    }

    public String m() {
        return this.f12861g;
    }

    public String n() {
        return this.f12863i;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:33|93|34|91|35|(4:80|36|85|37)|82|38|104) */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0128 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0107 A[EXC_TOP_SPLITTER, PHI: r4
  0x0107: PHI (r4v7 java.io.ByteArrayOutputStream) = (r4v6 java.io.ByteArrayOutputStream), (r4v8 java.io.ByteArrayOutputStream), (r4v8 java.io.ByteArrayOutputStream) binds: [B:56:0x0125, B:76:0x0107, B:37:0x0104] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0120 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected synchronized java.lang.String o() {
        /*
            Method dump skipped, instructions count: 331
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.fo.o():java.lang.String");
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized Collection<fl> m434a() {
        if (this.f531a == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(new ArrayList(this.f531a));
    }

    public fl a(String str) {
        return a(str, null);
    }

    public fl a(String str, String str2) {
        for (fl flVar : this.f531a) {
            if (str2 == null || str2.equals(flVar.b())) {
                if (str.equals(flVar.m428a())) {
                    return flVar;
                }
            }
        }
        return null;
    }

    public void a(fl flVar) {
        this.f531a.add(flVar);
    }

    public fo(Bundle bundle) {
        this.f12858d = f528b;
        this.f12859e = null;
        this.f12860f = null;
        this.f12861g = null;
        this.f12862h = null;
        this.f12863i = null;
        this.f531a = new CopyOnWriteArrayList();
        this.f532a = new HashMap();
        this.f530a = null;
        this.f12860f = bundle.getString("ext_to");
        this.f12861g = bundle.getString("ext_from");
        this.f12862h = bundle.getString("ext_chid");
        this.f12859e = bundle.getString("ext_pkt_id");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.f531a = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                fl flVarA = fl.a((Bundle) parcelable);
                if (flVarA != null) {
                    this.f531a.add(flVarA);
                }
            }
        }
        Bundle bundle2 = bundle.getBundle("ext_ERROR");
        if (bundle2 != null) {
            this.f530a = new fs(bundle2);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized Object m433a(String str) {
        if (this.f532a == null) {
            return null;
        }
        return this.f532a.get(str);
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(this.f12858d)) {
            bundle.putString("ext_ns", this.f12858d);
        }
        if (!TextUtils.isEmpty(this.f12861g)) {
            bundle.putString("ext_from", this.f12861g);
        }
        if (!TextUtils.isEmpty(this.f12860f)) {
            bundle.putString("ext_to", this.f12860f);
        }
        if (!TextUtils.isEmpty(this.f12859e)) {
            bundle.putString("ext_pkt_id", this.f12859e);
        }
        if (!TextUtils.isEmpty(this.f12862h)) {
            bundle.putString("ext_chid", this.f12862h);
        }
        fs fsVar = this.f530a;
        if (fsVar != null) {
            bundle.putBundle("ext_ERROR", fsVar.a());
        }
        List<fl> list = this.f531a;
        if (list != null) {
            Bundle[] bundleArr = new Bundle[list.size()];
            int i2 = 0;
            Iterator<fl> it = this.f531a.iterator();
            while (it.hasNext()) {
                Bundle bundleA = it.next().a();
                if (bundleA != null) {
                    bundleArr[i2] = bundleA;
                    i2++;
                }
            }
            bundle.putParcelableArray("ext_exts", bundleArr);
        }
        return bundle;
    }
}
