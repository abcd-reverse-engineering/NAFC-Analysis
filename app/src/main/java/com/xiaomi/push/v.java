package com.xiaomi.push;

import java.io.File;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    private static final HashMap<String, String> f13484a = new HashMap<>();

    static {
        f13484a.put("FFD8FF", "jpg");
        f13484a.put("89504E47", "png");
        f13484a.put("47494638", "gif");
        f13484a.put("474946", "gif");
        f13484a.put("424D", "bmp");
    }

    public static long a(File file) {
        long jA = 0;
        try {
            File[] fileArrListFiles = file.listFiles();
            for (int i2 = 0; i2 < fileArrListFiles.length; i2++) {
                jA += fileArrListFiles[i2].isDirectory() ? a(fileArrListFiles[i2]) : fileArrListFiles[i2].length();
            }
        } catch (Exception e2) {
            String str = "Get folder size error: " + e2.getMessage();
        }
        return jA;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m764a(File file) {
        long length;
        if (file == null) {
            return false;
        }
        try {
            if (!file.exists()) {
                return true;
            }
            if (file.isDirectory()) {
                length = a(file);
            } else {
                length = file.length();
            }
            return length < 104857600;
        } catch (Exception e2) {
            String str = "Check if internal file can be written error :" + e2.getMessage();
            return false;
        }
    }
}
