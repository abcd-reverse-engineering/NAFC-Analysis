package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: MD5Utils.java */
/* loaded from: classes2.dex */
public class o1 {
    public static String a(String str) {
        return b(str).toLowerCase();
    }

    public static String b(String str) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length];
            for (int i2 = 0; i2 < charArray.length; i2++) {
                bArr[i2] = (byte) charArray[i2];
            }
            byte[] bArrDigest = messageDigest.digest(bArr);
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b2 : bArrDigest) {
                int i3 = b2 & h.f1.f16099c;
                if (i3 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i3));
            }
            return stringBuffer.toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String a(File file) throws NoSuchAlgorithmException, IOException {
        int i2;
        if (!file.isFile()) {
            return null;
        }
        byte[] bArr = new byte[1024];
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(file);
            while (true) {
                int i3 = fileInputStream.read(bArr, 0, 1024);
                if (i3 == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, i3);
            }
            fileInputStream.close();
            String string = new BigInteger(1, messageDigest.digest()).toString(16);
            int length = string.length();
            if (length >= 32) {
                return string;
            }
            int i4 = 32 - length;
            String str = "";
            for (i2 = 0; i2 < i4; i2++) {
                str = "0" + str;
            }
            return str + string;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String b(File file) throws Throwable {
        FileInputStream fileInputStream;
        int i2;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
                    byte[] bArr = new byte[10485760];
                    while (true) {
                        int i3 = fileInputStream.read(bArr);
                        if (i3 <= 0) {
                            break;
                        }
                        messageDigest.update(bArr, 0, i3);
                    }
                    String string = new BigInteger(1, messageDigest.digest()).toString(16);
                    int length = 40 - string.length();
                    if (length > 0) {
                        for (i2 = 0; i2 < length; i2++) {
                            string = "0" + string;
                        }
                    }
                    try {
                        fileInputStream.close();
                    } catch (Exception unused) {
                    }
                    return string;
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream2 = fileInputStream;
                    System.out.println(e);
                    if (fileInputStream2 == null) {
                        return "";
                    }
                    try {
                        fileInputStream2.close();
                        return "";
                    } catch (Exception unused2) {
                        return "";
                    }
                } catch (Throwable th) {
                    th = th;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception unused3) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = fileInputStream2;
        }
    }

    public static Map<String, String> a(File file, boolean z) throws NoSuchAlgorithmException, IOException {
        if (!file.isDirectory()) {
            return null;
        }
        HashMap map = new HashMap();
        for (File file2 : file.listFiles()) {
            if (file2.isDirectory() && z) {
                map.putAll(a(file2, z));
            } else {
                String strA = a(file2);
                if (strA != null) {
                    map.put(file2.getPath(), strA);
                }
            }
        }
        return map;
    }
}
