package com.xiaomi.clientreport.processor;

import android.text.TextUtils;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.push.w;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class e {
    public static void a(String str, com.xiaomi.clientreport.data.a[] aVarArr) throws IOException {
        RandomAccessFile randomAccessFile;
        if (aVarArr == null || aVarArr.length <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        FileLock fileLockLock = null;
        try {
            File file = new File(str + ".lock");
            w.m765a(file);
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                fileLockLock = randomAccessFile.getChannel().lock();
                HashMap<String, String> mapM64a = m64a(str);
                for (com.xiaomi.clientreport.data.a aVar : aVarArr) {
                    if (aVar != null) {
                        String strA = a((PerfClientReport) aVar);
                        long j2 = ((PerfClientReport) aVar).perfCounts;
                        long j3 = ((PerfClientReport) aVar).perfLatencies;
                        if (!TextUtils.isEmpty(strA) && j2 > 0 && j3 >= 0) {
                            a(mapM64a, strA, j2, j3);
                        }
                    }
                }
                a(str, mapM64a);
                if (fileLockLock != null && fileLockLock.isValid()) {
                    try {
                        fileLockLock.release();
                    } catch (IOException e2) {
                        e = e2;
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                        w.a(randomAccessFile);
                    }
                }
            } catch (Throwable unused) {
                try {
                    com.xiaomi.channel.commonutils.logger.b.c("failed to write perf to file ");
                    if (fileLockLock != null && fileLockLock.isValid()) {
                        try {
                            fileLockLock.release();
                        } catch (IOException e3) {
                            e = e3;
                            com.xiaomi.channel.commonutils.logger.b.a(e);
                            w.a(randomAccessFile);
                        }
                    }
                    w.a(randomAccessFile);
                } catch (Throwable th) {
                    if (fileLockLock != null && fileLockLock.isValid()) {
                        try {
                            fileLockLock.release();
                        } catch (IOException e4) {
                            com.xiaomi.channel.commonutils.logger.b.a(e4);
                        }
                    }
                    w.a(randomAccessFile);
                    throw th;
                }
            }
        } catch (Throwable unused2) {
            randomAccessFile = null;
        }
        w.a(randomAccessFile);
    }

    private static void a(HashMap<String, String> map, String str, long j2, long j3) {
        String str2;
        String str3 = map.get(str);
        if (TextUtils.isEmpty(str3)) {
            map.put(str, j2 + "#" + j3);
            return;
        }
        long[] jArrM65a = m65a(str3);
        if (jArrM65a != null && jArrM65a[0] > 0 && jArrM65a[1] >= 0) {
            str2 = (j2 + jArrM65a[0]) + "#" + (j3 + jArrM65a[1]);
        } else {
            str2 = j2 + "#" + j3;
        }
        map.put(str, str2);
    }

    /* renamed from: a, reason: collision with other method in class */
    protected static long[] m65a(String str) {
        long[] jArr = new long[2];
        try {
            String[] strArrSplit = str.split("#");
            if (strArrSplit.length >= 2) {
                jArr[0] = Long.parseLong(strArrSplit[0].trim());
                jArr[1] = Long.parseLong(strArrSplit[1].trim());
            }
            return jArr;
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            return null;
        }
    }

    private static void a(String str, HashMap<String, String> map) throws Throwable {
        BufferedWriter bufferedWriter;
        Throwable th;
        Exception e2;
        if (TextUtils.isEmpty(str) || map == null || map.size() == 0) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file));
        } catch (Exception e3) {
            bufferedWriter = null;
            e2 = e3;
        } catch (Throwable th2) {
            bufferedWriter = null;
            th = th2;
            w.a(bufferedWriter);
            throw th;
        }
        try {
            try {
                for (String str2 : map.keySet()) {
                    bufferedWriter.write(str2 + "%%%" + map.get(str2));
                    bufferedWriter.newLine();
                }
            } catch (Throwable th3) {
                th = th3;
                w.a(bufferedWriter);
                throw th;
            }
        } catch (Exception e4) {
            e2 = e4;
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            w.a(bufferedWriter);
        }
        w.a(bufferedWriter);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.lang.Object] */
    /* renamed from: a, reason: collision with other method in class */
    private static HashMap<String, String> m64a(String str) throws Throwable {
        BufferedReader bufferedReader;
        HashMap map = new HashMap();
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            return map;
        }
        BufferedReader bufferedReader2 = null;
        ?? length = 0;
        BufferedReader bufferedReader3 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader(str));
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        ?? Split = line.split("%%%");
                        length = Split.length;
                        if (length >= 2) {
                            length = 0;
                            length = 0;
                            if (!TextUtils.isEmpty(Split[0]) && !TextUtils.isEmpty(Split[1])) {
                                length = Split[0];
                                map.put(length, Split[1]);
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        bufferedReader3 = bufferedReader;
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                        w.a(bufferedReader3);
                        bufferedReader2 = bufferedReader3;
                        return map;
                    } catch (Throwable th) {
                        th = th;
                        w.a(bufferedReader);
                        throw th;
                    }
                }
                w.a(bufferedReader);
                bufferedReader2 = length;
            } catch (Exception e3) {
                e = e3;
            }
            return map;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = bufferedReader2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:113:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00d5 A[PHI: r1
  0x00d5: PHI (r1v7 java.io.File) = (r1v6 java.io.File), (r1v8 java.io.File) binds: [B:65:0x00d3, B:32:0x0094] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00f4  */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.io.BufferedReader, java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<java.lang.String> a(android.content.Context r7, java.lang.String r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.clientreport.processor.e.a(android.content.Context, java.lang.String):java.util.List");
    }

    /* renamed from: a, reason: collision with other method in class */
    private static String[] m66a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.split("#");
    }

    private static PerfClientReport a(String str) {
        PerfClientReport blankInstance = null;
        try {
            String[] strArrM66a = m66a(str);
            if (strArrM66a == null || strArrM66a.length < 4 || TextUtils.isEmpty(strArrM66a[0]) || TextUtils.isEmpty(strArrM66a[1]) || TextUtils.isEmpty(strArrM66a[2]) || TextUtils.isEmpty(strArrM66a[3])) {
                return null;
            }
            blankInstance = PerfClientReport.getBlankInstance();
            blankInstance.production = Integer.parseInt(strArrM66a[0]);
            blankInstance.clientInterfaceId = strArrM66a[1];
            blankInstance.reportType = Integer.parseInt(strArrM66a[2]);
            blankInstance.code = Integer.parseInt(strArrM66a[3]);
            return blankInstance;
        } catch (Exception unused) {
            com.xiaomi.channel.commonutils.logger.b.c("parse per key error");
            return blankInstance;
        }
    }

    private static PerfClientReport a(PerfClientReport perfClientReport, String str) {
        long[] jArrM65a;
        if (perfClientReport == null || (jArrM65a = m65a(str)) == null) {
            return null;
        }
        perfClientReport.perfCounts = jArrM65a[0];
        perfClientReport.perfLatencies = jArrM65a[1];
        return perfClientReport;
    }

    public static String a(PerfClientReport perfClientReport) {
        return perfClientReport.production + "#" + perfClientReport.clientInterfaceId + "#" + perfClientReport.reportType + "#" + perfClientReport.code;
    }
}
