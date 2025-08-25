package com.android.dingtalk.share.ddsharemodule.algorithm;

import com.umeng.analytics.pro.cw;
import h.f1;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
public class MD5 {
    public static final String getMD5(FileInputStream fileInputStream, int i2, int i3, int i4) throws NoSuchAlgorithmException, IOException {
        if (fileInputStream != null && i2 > 0 && i3 >= 0 && i4 > 0) {
            long j2 = i3;
            try {
                if (fileInputStream.skip(j2) < j2) {
                    return null;
                }
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                StringBuilder sb = new StringBuilder(32);
                byte[] bArr = new byte[i2];
                int i5 = 0;
                while (true) {
                    int i6 = fileInputStream.read(bArr);
                    if (i6 == -1 || i5 >= i4) {
                        break;
                    }
                    int i7 = i5 + i6;
                    if (i7 <= i4) {
                        messageDigest.update(bArr, 0, i6);
                        i5 = i7;
                    } else {
                        messageDigest.update(bArr, 0, i4 - i5);
                        i5 = i4;
                    }
                }
                for (byte b2 : messageDigest.digest()) {
                    sb.append(Integer.toString((b2 & f1.f16099c) + 256, 16).substring(1));
                }
                return sb.toString();
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static final String getMessageDigest(byte[] bArr) throws NoSuchAlgorithmException {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            byte[] bArrDigest = messageDigest.digest();
            char[] cArr2 = new char[bArrDigest.length * 2];
            int i2 = 0;
            for (byte b2 : bArrDigest) {
                int i3 = i2 + 1;
                cArr2[i2] = cArr[(b2 >>> 4) & 15];
                i2 = i3 + 1;
                cArr2[i3] = cArr[b2 & cw.f10303m];
            }
            return new String(cArr2);
        } catch (Exception unused) {
            return null;
        }
    }

    public static final byte[] getRawDigest(byte[] bArr) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (Exception unused) {
            return null;
        }
    }

    public static final String getMD5(FileInputStream fileInputStream, int i2) throws NoSuchAlgorithmException, IOException {
        int i3;
        if (fileInputStream != null && i2 > 0) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                StringBuilder sb = new StringBuilder(32);
                byte[] bArr = new byte[i2];
                while (true) {
                    int i4 = fileInputStream.read(bArr);
                    if (i4 == -1) {
                        break;
                    }
                    messageDigest.update(bArr, 0, i4);
                }
                for (byte b2 : messageDigest.digest()) {
                    sb.append(Integer.toString((b2 & f1.f16099c) + 256, 16).substring(1));
                }
                return sb.toString();
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static String getMD5(String str) {
        if (str == null) {
            return null;
        }
        File file = new File(str);
        if (file.exists()) {
            return getMD5(file, 102400);
        }
        return null;
    }

    public static String getMD5(File file) {
        return getMD5(file, 102400);
    }

    public static String getMD5(File file, int i2) throws Throwable {
        FileInputStream fileInputStream;
        long length;
        if (file != null && i2 > 0 && file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
                length = i2;
            } catch (Exception unused) {
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
                fileInputStream = null;
            }
            try {
                if (length > file.length()) {
                    length = file.length();
                }
                String md5 = getMD5(fileInputStream, (int) length);
                fileInputStream.close();
                try {
                    fileInputStream.close();
                } catch (IOException unused2) {
                }
                return md5;
            } catch (Exception unused3) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused5) {
                    }
                }
                throw th;
            }
        }
        return null;
    }

    public static String getMD5(String str, int i2, int i3) {
        if (str == null) {
            return null;
        }
        File file = new File(str);
        if (file.exists()) {
            return getMD5(file, i2, i3);
        }
        return null;
    }

    public static String getMD5(File file, int i2, int i3) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (file != null && file.exists() && i2 >= 0 && i3 > 0) {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Exception unused) {
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                String md5 = getMD5(fileInputStream, 102400, i2, i3);
                fileInputStream.close();
                try {
                    fileInputStream.close();
                } catch (IOException unused2) {
                }
                return md5;
            } catch (Exception unused3) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused5) {
                    }
                }
                throw th;
            }
        }
        return null;
    }
}
