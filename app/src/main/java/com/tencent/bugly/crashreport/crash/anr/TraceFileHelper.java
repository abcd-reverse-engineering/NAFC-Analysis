package com.tencent.bugly.crashreport.crash.anr;

import com.tencent.bugly.proguard.an;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class TraceFileHelper {

    /* compiled from: BUGLY */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public long f9046a;

        /* renamed from: b, reason: collision with root package name */
        public String f9047b;

        /* renamed from: c, reason: collision with root package name */
        public long f9048c;

        /* renamed from: d, reason: collision with root package name */
        public Map<String, String[]> f9049d;
    }

    /* compiled from: BUGLY */
    public interface b {
        boolean a(long j2);

        boolean a(long j2, long j3, String str);

        boolean a(String str, int i2, String str2, String str3, boolean z);

        boolean a(String str, long j2, long j3);
    }

    protected static Object[] a(BufferedReader bufferedReader, Pattern... patternArr) throws IOException {
        if (bufferedReader != null && patternArr != null) {
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                for (Pattern pattern : patternArr) {
                    if (pattern.matcher(line).matches()) {
                        return new Object[]{pattern, line};
                    }
                }
            }
        }
        return null;
    }

    protected static String b(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null || line.trim().length() <= 0) {
                break;
            }
            stringBuffer.append(line + "\n");
        }
        return stringBuffer.toString();
    }

    public static a readFirstDumpInfo(String str, final boolean z) throws Throwable {
        if (str == null) {
            an.e("path:%s", str);
            return null;
        }
        final a aVar = new a();
        readTraceFile(str, new b() { // from class: com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.2
            @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
            public boolean a(String str2, int i2, String str3, String str4, boolean z2) {
                an.c("new thread %s", str2);
                a aVar2 = aVar;
                if (aVar2.f9049d == null) {
                    aVar2.f9049d = new HashMap();
                }
                aVar.f9049d.put(str2, new String[]{str3, str4, "" + i2});
                return true;
            }

            @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
            public boolean a(String str2, long j2, long j3) {
                return true;
            }

            @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
            public boolean a(long j2, long j3, String str2) {
                an.c("new process %s", str2);
                a aVar2 = aVar;
                aVar2.f9046a = j2;
                aVar2.f9047b = str2;
                aVar2.f9048c = j3;
                return z;
            }

            @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
            public boolean a(long j2) {
                an.c("process end %d", Long.valueOf(j2));
                return false;
            }
        });
        if (aVar.f9046a > 0 && aVar.f9048c > 0 && aVar.f9047b != null) {
            return aVar;
        }
        an.e("first dump error %s", aVar.f9046a + c.c.a.b.a.a.f3100g + aVar.f9048c + c.c.a.b.a.a.f3100g + aVar.f9047b);
        return null;
    }

    public static a readTargetDumpInfo(final String str, String str2, final boolean z) throws Throwable {
        if (str != null && str2 != null) {
            final a aVar = new a();
            readTraceFile(str2, new b() { // from class: com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.1
                @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
                public boolean a(String str3, int i2, String str4, String str5, boolean z2) {
                    an.c("new thread %s", str3);
                    a aVar2 = aVar;
                    if (aVar2.f9046a > 0 && aVar2.f9048c > 0 && aVar2.f9047b != null) {
                        if (aVar2.f9049d == null) {
                            aVar2.f9049d = new HashMap();
                        }
                        aVar.f9049d.put(str3, new String[]{str4, str5, "" + i2});
                    }
                    return true;
                }

                @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
                public boolean a(String str3, long j2, long j3) {
                    return true;
                }

                @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
                public boolean a(long j2, long j3, String str3) {
                    an.c("new process %s", str3);
                    if (!str3.equals(str)) {
                        return true;
                    }
                    a aVar2 = aVar;
                    aVar2.f9046a = j2;
                    aVar2.f9047b = str3;
                    aVar2.f9048c = j3;
                    return z;
                }

                @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
                public boolean a(long j2) {
                    an.c("process end %d", Long.valueOf(j2));
                    a aVar2 = aVar;
                    return aVar2.f9046a <= 0 || aVar2.f9048c <= 0 || aVar2.f9047b == null;
                }
            });
            if (aVar.f9046a > 0 && aVar.f9048c > 0 && aVar.f9047b != null) {
                return aVar;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:119:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x014a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0150, code lost:
    
        if (com.tencent.bugly.proguard.an.a(r0) == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0152, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0155, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void readTraceFile(java.lang.String r18, com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 494
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.readTraceFile(java.lang.String, com.tencent.bugly.crashreport.crash.anr.TraceFileHelper$b):void");
    }

    protected static String a(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < 3; i2++) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return null;
            }
            stringBuffer.append(line + "\n");
        }
        return stringBuffer.toString();
    }
}
