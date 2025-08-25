package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.aq;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static List<File> f9159a = new ArrayList();

    protected static Map<String, Integer> a(String str) {
        if (str == null) {
            return null;
        }
        try {
            HashMap map = new HashMap();
            for (String str2 : str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                String[] strArrSplit = str2.split(Constants.COLON_SEPARATOR);
                if (strArrSplit.length != 2) {
                    an.e("error format at %s", str2);
                    return null;
                }
                map.put(strArrSplit[0], Integer.valueOf(Integer.parseInt(strArrSplit[1])));
            }
            return map;
        } catch (Exception e2) {
            an.e("error format intStateStr %s", str);
            e2.printStackTrace();
            return null;
        }
    }

    protected static String b(String str) {
        if (str == null) {
            return "";
        }
        String[] strArrSplit = str.split("\n");
        if (strArrSplit == null || strArrSplit.length == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : strArrSplit) {
            if (!str2.contains("java.lang.Thread.getStackTrace(")) {
                sb.append(str2);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    private static String c(String str, String str2) throws IOException {
        BufferedReader bufferedReaderA = aq.a(str, "map_record.txt");
        if (bufferedReaderA == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            String line = bufferedReaderA.readLine();
            if (line != null && line.startsWith(str2)) {
                while (true) {
                    String line2 = bufferedReaderA.readLine();
                    if (line2 == null) {
                        break;
                    }
                    sb.append("  ");
                    sb.append(line2);
                    sb.append("\n");
                }
                return sb.toString();
            }
            if (bufferedReaderA != null) {
                try {
                    bufferedReaderA.close();
                } catch (Exception e2) {
                    an.a(e2);
                }
            }
            return null;
        } catch (Throwable th) {
            try {
                an.a(th);
                if (bufferedReaderA != null) {
                    try {
                        bufferedReaderA.close();
                    } catch (Exception e3) {
                        an.a(e3);
                    }
                }
                return null;
            } finally {
                if (bufferedReaderA != null) {
                    try {
                        bufferedReaderA.close();
                    } catch (Exception e4) {
                        an.a(e4);
                    }
                }
            }
        }
    }

    public static void d(String str) {
        File[] fileArrListFiles;
        if (str == null) {
            return;
        }
        try {
            File file = new File(str);
            if (file.canRead() && file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
                for (File file2 : fileArrListFiles) {
                    if (file2.canRead() && file2.canWrite() && file2.length() == 0) {
                        file2.delete();
                        an.c("Delete empty record file %s", file2.getAbsoluteFile());
                    }
                }
            }
        } catch (Throwable th) {
            an.a(th);
        }
    }

    private static String b(String str, String str2) throws IOException {
        BufferedReader bufferedReaderA = aq.a(str, "reg_record.txt");
        if (bufferedReaderA == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            String line = bufferedReaderA.readLine();
            if (line != null && line.startsWith(str2)) {
                int i2 = 0;
                int i3 = 18;
                int length = 0;
                while (true) {
                    String line2 = bufferedReaderA.readLine();
                    if (line2 == null) {
                        break;
                    }
                    if (i2 % 4 == 0) {
                        if (i2 > 0) {
                            sb.append("\n");
                        }
                        sb.append("  ");
                    } else {
                        if (line2.length() > 16) {
                            i3 = 28;
                        }
                        sb.append("                ".substring(0, i3 - length));
                    }
                    length = line2.length();
                    sb.append(line2);
                    i2++;
                }
                sb.append("\n");
                return sb.toString();
            }
            if (bufferedReaderA != null) {
                try {
                    bufferedReaderA.close();
                } catch (Exception e2) {
                    an.a(e2);
                }
            }
            return null;
        } catch (Throwable th) {
            try {
                an.a(th);
                if (bufferedReaderA != null) {
                    try {
                        bufferedReaderA.close();
                    } catch (Exception e3) {
                        an.a(e3);
                    }
                }
                return null;
            } finally {
                if (bufferedReaderA != null) {
                    try {
                        bufferedReaderA.close();
                    } catch (Exception e4) {
                        an.a(e4);
                    }
                }
            }
        }
    }

    protected static CrashDetailBean a(Context context, Map<String, String> map, NativeExceptionHandler nativeExceptionHandler) {
        String str;
        String str2;
        HashMap map2;
        if (map == null) {
            return null;
        }
        if (com.tencent.bugly.crashreport.common.info.a.a(context) == null) {
            an.e("abnormal com info not created", new Object[0]);
            return null;
        }
        String str3 = map.get("intStateStr");
        if (str3 != null && str3.trim().length() > 0) {
            Map<String, Integer> mapA = a(str3);
            if (mapA == null) {
                an.e("parse intSateMap fail", Integer.valueOf(map.size()));
                return null;
            }
            try {
                mapA.get("sino").intValue();
                mapA.get("sud").intValue();
                String str4 = map.get("soVersion");
                if (TextUtils.isEmpty(str4)) {
                    an.e("error format at version", new Object[0]);
                    return null;
                }
                String str5 = map.get("errorAddr");
                String str6 = "unknown";
                String str7 = str5 == null ? "unknown" : str5;
                String str8 = map.get("codeMsg");
                if (str8 == null) {
                    str8 = "unknown";
                }
                String str9 = map.get("tombPath");
                String str10 = str9 == null ? "unknown" : str9;
                String str11 = map.get("signalName");
                if (str11 == null) {
                    str11 = "unknown";
                }
                map.get("errnoMsg");
                String str12 = map.get("stack");
                if (str12 == null) {
                    str12 = "unknown";
                }
                String str13 = map.get("jstack");
                if (str13 != null) {
                    str12 = str12 + "java:\n" + str13;
                }
                Integer num = mapA.get("sico");
                if (num == null || num.intValue() <= 0) {
                    str = str8;
                    str2 = str11;
                } else {
                    str2 = str11 + "(" + str8 + ")";
                    str = "KERNEL";
                }
                String str14 = map.get("nativeLog");
                byte[] bArrA = (str14 == null || str14.isEmpty()) ? null : aq.a((File) null, str14, "BuglyNativeLog.txt");
                String str15 = map.get("sendingProcess");
                if (str15 == null) {
                    str15 = "unknown";
                }
                Integer num2 = mapA.get("spd");
                if (num2 != null) {
                    str15 = str15 + "(" + num2 + ")";
                }
                String str16 = str15;
                String str17 = map.get("threadName");
                if (str17 == null) {
                    str17 = "unknown";
                }
                Integer num3 = mapA.get("et");
                if (num3 != null) {
                    str17 = str17 + "(" + num3 + ")";
                }
                String str18 = str17;
                String str19 = map.get("processName");
                if (str19 != null) {
                    str6 = str19;
                }
                Integer num4 = mapA.get("ep");
                if (num4 != null) {
                    str6 = str6 + "(" + num4 + ")";
                }
                String str20 = str6;
                String str21 = map.get("key-value");
                if (str21 != null) {
                    HashMap map3 = new HashMap();
                    String[] strArrSplit = str21.split("\n");
                    int length = strArrSplit.length;
                    int i2 = 0;
                    while (i2 < length) {
                        String[] strArrSplit2 = strArrSplit[i2].split(ContainerUtils.KEY_VALUE_DELIMITER);
                        String[] strArr = strArrSplit;
                        if (strArrSplit2.length == 2) {
                            map3.put(strArrSplit2[0], strArrSplit2[1]);
                        }
                        i2++;
                        strArrSplit = strArr;
                    }
                    map2 = map3;
                } else {
                    map2 = null;
                }
                CrashDetailBean crashDetailBeanPackageCrashDatas = nativeExceptionHandler.packageCrashDatas(str20, str18, (mapA.get("etms").intValue() / 1000) + (mapA.get("ets").intValue() * 1000), str2, str7, b(str12), str, str16, str10, map.get("sysLogPath"), map.get("jniLogPath"), str4, bArrA, map2, false, false);
                if (crashDetailBeanPackageCrashDatas != null) {
                    String str22 = map.get("userId");
                    if (str22 != null) {
                        an.c("[Native record info] userId: %s", str22);
                        crashDetailBeanPackageCrashDatas.f9034m = str22;
                    }
                    String str23 = map.get("sysLog");
                    if (str23 != null) {
                        crashDetailBeanPackageCrashDatas.w = str23;
                    }
                    String str24 = map.get("appVersion");
                    if (str24 != null) {
                        an.c("[Native record info] appVersion: %s", str24);
                        crashDetailBeanPackageCrashDatas.f9027f = str24;
                    }
                    String str25 = map.get("isAppForeground");
                    if (str25 != null) {
                        an.c("[Native record info] isAppForeground: %s", str25);
                        crashDetailBeanPackageCrashDatas.O = str25.equalsIgnoreCase(a.a.u.a.f1253j);
                    }
                    String str26 = map.get("launchTime");
                    if (str26 != null) {
                        an.c("[Native record info] launchTime: %s", str26);
                        try {
                            crashDetailBeanPackageCrashDatas.N = Long.parseLong(str26);
                        } catch (NumberFormatException e2) {
                            if (!an.a(e2)) {
                                e2.printStackTrace();
                            }
                        }
                    }
                    crashDetailBeanPackageCrashDatas.z = null;
                    crashDetailBeanPackageCrashDatas.f9032k = true;
                }
                return crashDetailBeanPackageCrashDatas;
            } catch (Throwable th) {
                an.e("error format", new Object[0]);
                th.printStackTrace();
                return null;
            }
        }
        an.e("no intStateStr", new Object[0]);
        return null;
    }

    public static String c(String str) {
        if (str == null) {
            return null;
        }
        File file = new File(str, "backup_record.txt");
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        return null;
    }

    protected static String a(BufferedInputStream bufferedInputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        if (bufferedInputStream == null) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(1024);
            while (true) {
                try {
                    int i2 = bufferedInputStream.read();
                    if (i2 == -1) {
                        break;
                    }
                    if (i2 == 0) {
                        String str = new String(byteArrayOutputStream.toByteArray(), "UTf-8");
                        byteArrayOutputStream.close();
                        return str;
                    }
                    byteArrayOutputStream.write(i2);
                } catch (Throwable th) {
                    th = th;
                    try {
                        an.a(th);
                        return null;
                    } finally {
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v6 */
    public static CrashDetailBean a(Context context, String str, NativeExceptionHandler nativeExceptionHandler) throws Throwable {
        BufferedInputStream bufferedInputStream;
        String str2;
        String strA;
        if (context != null && str != null && nativeExceptionHandler != null) {
            File file = new File(str, "rqd_record.eup");
            if (file.exists()) {
                BufferedInputStream bufferedInputStreamCanRead = file.canRead();
                try {
                    if (bufferedInputStreamCanRead != 0) {
                        try {
                            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                        } catch (IOException e2) {
                            e = e2;
                            bufferedInputStream = null;
                        } catch (Throwable th) {
                            th = th;
                            bufferedInputStreamCanRead = 0;
                            if (bufferedInputStreamCanRead != 0) {
                                try {
                                    bufferedInputStreamCanRead.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            throw th;
                        }
                        try {
                            String strA2 = a(bufferedInputStream);
                            if (strA2 != null && strA2.equals("NATIVE_RQD_REPORT")) {
                                HashMap map = new HashMap();
                                loop0: while (true) {
                                    str2 = null;
                                    while (true) {
                                        strA = a(bufferedInputStream);
                                        if (strA == null) {
                                            break loop0;
                                        }
                                        if (str2 == null) {
                                            str2 = strA;
                                        }
                                    }
                                    map.put(str2, strA);
                                }
                                if (str2 != null) {
                                    an.e("record not pair! drop! %s", str2);
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException e4) {
                                        e4.printStackTrace();
                                    }
                                    return null;
                                }
                                CrashDetailBean crashDetailBeanA = a(context, map, nativeExceptionHandler);
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                                return crashDetailBeanA;
                            }
                            an.e("record read fail! %s", strA2);
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                            return null;
                        } catch (IOException e7) {
                            e = e7;
                            e.printStackTrace();
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e8) {
                                    e8.printStackTrace();
                                }
                            }
                            return null;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            return null;
        }
        an.e("get eup record file args error", new Object[0]);
        return null;
    }

    public static String a(String str, String str2) throws IOException {
        if (str == null || str2 == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String strB = b(str, str2);
        if (strB != null && !strB.isEmpty()) {
            sb.append("Register infos:\n");
            sb.append(strB);
        }
        String strC = c(str, str2);
        if (strC != null && !strC.isEmpty()) {
            if (sb.length() > 0) {
                sb.append("\n");
            }
            sb.append("System SO infos:\n");
            sb.append(strC);
        }
        return sb.toString();
    }

    public static void a(boolean z, String str) {
        if (str != null) {
            f9159a.add(new File(str, "rqd_record.eup"));
            f9159a.add(new File(str, "reg_record.txt"));
            f9159a.add(new File(str, "map_record.txt"));
            f9159a.add(new File(str, "backup_record.txt"));
            if (z) {
                d(str);
            }
        }
        List<File> list = f9159a;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (File file : f9159a) {
            if (file.exists() && file.canWrite()) {
                file.delete();
                an.c("Delete record file %s", file.getAbsoluteFile());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.lang.String] */
    public static String a(String str, int i2, String str2, boolean z) throws IOException {
        BufferedReader bufferedReader;
        if (str != null && i2 > 0) {
            File file = new File(str);
            if (file.exists() && file.canRead()) {
                an.a("Read system log from native record file(length: %s bytes): %s", Long.valueOf(file.length()), file.getAbsolutePath());
                f9159a.add(file);
                an.c("Add this record file to list for cleaning lastly.", new Object[0]);
                if (str2 == null) {
                    return aq.a(new File(str), i2, z);
                }
                String sb = new StringBuilder();
                try {
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
                        while (true) {
                            try {
                                String line = bufferedReader.readLine();
                                if (line == null) {
                                    break;
                                }
                                if (Pattern.compile(str2 + "[ ]*:").matcher(line).find()) {
                                    sb.append(line);
                                    sb.append("\n");
                                }
                                if (i2 > 0 && sb.length() > i2) {
                                    if (z) {
                                        sb.delete(i2, sb.length());
                                        break;
                                    }
                                    sb.delete(0, sb.length() - i2);
                                }
                            } catch (Throwable th) {
                                th = th;
                                try {
                                    an.a(th);
                                    sb.append("\n[error:" + th.toString() + "]");
                                    String string = sb.toString();
                                    if (bufferedReader == null) {
                                        return string;
                                    }
                                    bufferedReader.close();
                                    sb = string;
                                    return sb;
                                } catch (Throwable th2) {
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (Exception e2) {
                                            an.a(e2);
                                        }
                                    }
                                    throw th2;
                                }
                            }
                        }
                        String string2 = sb.toString();
                        bufferedReader.close();
                        sb = string2;
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedReader = null;
                    }
                    return sb;
                } catch (Exception e3) {
                    an.a(e3);
                    return sb;
                }
            }
        }
        return null;
    }
}
