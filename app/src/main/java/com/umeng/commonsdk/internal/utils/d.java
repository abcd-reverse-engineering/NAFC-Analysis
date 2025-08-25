package com.umeng.commonsdk.internal.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: CpuUtil.java */
/* loaded from: classes2.dex */
public class d {

    /* compiled from: CpuUtil.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f10806a;

        /* renamed from: b, reason: collision with root package name */
        public String f10807b;

        /* renamed from: c, reason: collision with root package name */
        public int f10808c;

        /* renamed from: d, reason: collision with root package name */
        public String f10809d;

        /* renamed from: e, reason: collision with root package name */
        public String f10810e;

        /* renamed from: f, reason: collision with root package name */
        public String f10811f;

        /* renamed from: g, reason: collision with root package name */
        public String f10812g;

        /* renamed from: h, reason: collision with root package name */
        public String f10813h;

        /* renamed from: i, reason: collision with root package name */
        public String f10814i;

        /* renamed from: j, reason: collision with root package name */
        public String f10815j;

        /* renamed from: k, reason: collision with root package name */
        public String f10816k;

        /* renamed from: l, reason: collision with root package name */
        public String f10817l;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0111 A[EXC_TOP_SPLITTER, PHI: r2 r4 r8
  0x0111: PHI (r2v4 com.umeng.commonsdk.internal.utils.d$a) = 
  (r2v2 com.umeng.commonsdk.internal.utils.d$a)
  (r2v5 com.umeng.commonsdk.internal.utils.d$a)
  (r2v5 com.umeng.commonsdk.internal.utils.d$a)
 binds: [B:115:0x0140, B:119:0x0111, B:88:0x010e] A[DONT_GENERATE, DONT_INLINE]
  0x0111: PHI (r4v5 ??) = (r4v4 ??), (r4v9 ??), (r4v9 ??) binds: [B:115:0x0140, B:119:0x0111, B:88:0x010e] A[DONT_GENERATE, DONT_INLINE]
  0x0111: PHI (r8v4 int) = (r8v2 int), (r8v9 int), (r8v9 int) binds: [B:115:0x0140, B:119:0x0111, B:88:0x010e] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0131 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x013b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x012a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:147:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9, types: [java.io.BufferedReader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.umeng.commonsdk.internal.utils.d.a a() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 326
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.utils.d.a():com.umeng.commonsdk.internal.utils.d$a");
    }

    public static String b() throws IOException {
        String str = "";
        try {
            InputStream inputStream = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq").start().getInputStream();
            byte[] bArr = new byte[24];
            while (inputStream.read(bArr) != -1) {
                str = str + new String(bArr);
            }
            inputStream.close();
        } catch (Exception unused) {
        }
        return str.trim();
    }

    public static String c() throws IOException {
        String str = "";
        try {
            InputStream inputStream = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq").start().getInputStream();
            byte[] bArr = new byte[24];
            while (inputStream.read(bArr) != -1) {
                str = str + new String(bArr);
            }
            inputStream.close();
        } catch (Exception unused) {
        }
        return str.trim();
    }

    public static String d() throws Throwable {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq"));
        } catch (Exception unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            String strTrim = bufferedReader.readLine().trim();
            try {
                bufferedReader.close();
                return strTrim;
            } catch (Throwable unused2) {
                return strTrim;
            }
        } catch (Exception unused3) {
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Throwable unused4) {
                }
            }
            return "";
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Throwable unused5) {
                }
            }
            throw th;
        }
    }
}
