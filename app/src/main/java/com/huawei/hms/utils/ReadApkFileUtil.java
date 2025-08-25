package com.huawei.hms.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import android.util.AndroidException;
import android.util.Base64;
import com.huawei.hms.support.log.HMSLog;
import com.xiaomi.mipush.sdk.Constants;
import h.f1;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: classes.dex */
public class ReadApkFileUtil {
    public static final String EMUI10_PK = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAx4nUogUyMCmzHhaEb420yvpw9zBs+ETzE9Qm77bGxl1Iml9JEkBkNTsUWOstLgUBajNhV+BAMVBHKMEdzoQbL5kIHkTgUVM65yewd+5+BhrcB9OQ3LHp+0BN6aLKZh71T4WvsvHFhfhQpShuGWkRkSaVGLFTHxX70kpWLzeZ3RtqiEUNIufPR2SFCH6EmecJ+HdkmBOh603IblCpGxwSWse0fDI98wZBEmV88RFaiYEgyiezLlWvXzqIj6I/xuyd5nGAegjH2y3cmoDE6CubecoB1jf4KdgACXgdiQ4Oc63MfLGTor3l6RCqeUk4APAMtyhK83jc72W1sdXMd/sj2wIDAQAB";
    public static final String EMUI11_PK = "MIIBojANBgkqhkiG9w0BAQEFAAOCAY8AMIIBigKCAYEAqq2eRTMYr2JHLtvuZzfgPrgU8oatD4Rar9fOD7E00es2VhtB3vTyaT2BvYPUPA/nbkHRPak3EZX77CfWj9tzLgSHJE8XLk9C+2ESkdrxCDA6z7I8X+cBDnA05OlCJeZFjnUbjYB8SP8M3BttdrvqtVPxTkEJhchC7UXnMLaJ3kQ3ZPjN7ubjYzO4rv7EtEpqr2bX+qjnSLIZZuUXraxqfdBuhGDIYq62dNsqiyrhX1mfvA3+43N4ZIs3BdfSYII8BNFmFxf+gyf1aoq386R2kAjHcrfOOhjAbZh+R1OAGLWPCqi3E9nB8EsZkeoTW/oIP6pJvgL3bnxq+1viT2dmZyipMgcx/3N6FJqkd67j/sPMtPlHJuq8/s0silzs13jAw1WBV6tWHFkLGpkWGs8jp50wQtndtY8cCPl2XPGmdPN72agH+zsHuKqr/HOB2TuzzaO8rKlGIDQlzZcCSHB28nnvOyBVN9xzLkbYiLnHfd6bTwzNPeqjWrTnPwKyH3BPAgMBAAE=";
    public static final String KEY_SIGNATURE = "Signature:";
    public static final String KEY_SIGNATURE2 = "Signature2:";
    public static final String KEY_SIGNATURE3 = "Signature3:";

    /* renamed from: a, reason: collision with root package name */
    private static final String f7398a = "ReadApkFileUtil";

    /* renamed from: c, reason: collision with root package name */
    private static String f7400c;

    /* renamed from: d, reason: collision with root package name */
    private static String f7401d;

    /* renamed from: e, reason: collision with root package name */
    private static String f7402e;

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f7399b = Pattern.compile("\\s*|\t|\r|\n");

    /* renamed from: f, reason: collision with root package name */
    private static String f7403f = null;

    /* renamed from: g, reason: collision with root package name */
    private static String f7404g = null;

    private static byte[] a(ZipFile zipFile) {
        return a(zipFile, "META-INF/MANIFEST.MF");
    }

    @TargetApi(19)
    private static void b(byte[] bArr) throws Throwable {
        Throwable th;
        ByteArrayInputStream byteArrayInputStream;
        BufferedReader bufferedReader;
        if (bArr == null) {
            HMSLog.e(f7398a, "manifest is null！");
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader bufferedReader2 = null;
        f7400c = null;
        f7401d = null;
        f7402e = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(byteArrayInputStream, StandardCharsets.UTF_8));
                    try {
                        String strA = a(bufferedReader);
                        while (strA != null) {
                            if (strA.length() != 0) {
                                if (strA.startsWith("ApkHash:")) {
                                    f7403f = a(strA.substring(strA.indexOf(Constants.COLON_SEPARATOR) + 1));
                                }
                                if (strA.startsWith(KEY_SIGNATURE)) {
                                    f7400c = a(strA.substring(strA.indexOf(Constants.COLON_SEPARATOR) + 1));
                                    strA = a(bufferedReader);
                                } else if (strA.startsWith(KEY_SIGNATURE2)) {
                                    f7401d = a(strA.substring(strA.indexOf(Constants.COLON_SEPARATOR) + 1));
                                    strA = a(bufferedReader);
                                } else if (strA.startsWith(KEY_SIGNATURE3)) {
                                    f7402e = a(strA.substring(strA.indexOf(Constants.COLON_SEPARATOR) + 1));
                                    strA = a(bufferedReader);
                                } else {
                                    stringBuffer.append(strA);
                                    stringBuffer.append("\r\n");
                                }
                            }
                            strA = a(bufferedReader);
                        }
                        f7404g = stringBuffer.toString();
                    } catch (Exception unused) {
                        bufferedReader2 = bufferedReader;
                        HMSLog.e(f7398a, "loadApkCert Exception!");
                        bufferedReader = bufferedReader2;
                        IOUtils.closeQuietly((InputStream) byteArrayInputStream);
                        IOUtils.closeQuietly((Reader) bufferedReader);
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader2 = bufferedReader;
                        IOUtils.closeQuietly((InputStream) byteArrayInputStream);
                        IOUtils.closeQuietly((Reader) bufferedReader2);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Exception unused2) {
            }
        } catch (Exception unused3) {
            byteArrayInputStream = null;
        } catch (Throwable th4) {
            th = th4;
            byteArrayInputStream = null;
        }
        IOUtils.closeQuietly((InputStream) byteArrayInputStream);
        IOUtils.closeQuietly((Reader) bufferedReader);
    }

    public static String bytesToString(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[bArr.length * 2];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = bArr[i2] & f1.f16099c;
            int i4 = i2 * 2;
            cArr2[i4] = cArr[i3 >>> 4];
            cArr2[i4 + 1] = cArr[i3 & 15];
        }
        return String.valueOf(cArr2);
    }

    private static boolean c() {
        try {
        } catch (Exception e2) {
            HMSLog.i(f7398a, "verifyMDMSignatureV3 MDM verify Exception!:" + e2.getMessage());
        }
        if (a(Base64.decode(EMUI11_PK, 0), a(f7404g, "SHA-384"), b(f7402e), "SHA384withRSA")) {
            HMSLog.i(f7398a, "verifyMDMSignatureV3 verify successful!");
            return true;
        }
        HMSLog.i(f7398a, "verifyMDMSignatureV3 verify failure!");
        return false;
    }

    public static boolean checkSignature() {
        if (f7402e != null) {
            return c();
        }
        if (f7401d != null) {
            return b();
        }
        if (f7400c != null) {
            return a();
        }
        return false;
    }

    public static String getHmsPath(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo("com.huawei.hwid", 128).sourceDir;
        } catch (AndroidException | RuntimeException unused) {
            HMSLog.e(f7398a, "HMS is not found!");
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetApi(19)
    public static boolean isCertFound(String str) throws Throwable {
        ZipFile zipFile;
        boolean z;
        ZipFile zipFile2 = null;
        zipFile2 = null;
        ZipFile zipFile3 = null;
        try {
            try {
                zipFile = new ZipFile(str);
                try {
                    z = zipFile.getEntry("META-INF/HUAWEI.CER") != null;
                    if (z) {
                        b(a(zipFile, "META-INF/HUAWEI.CER"));
                    }
                    try {
                        zipFile.close();
                    } catch (IOException e2) {
                        String str2 = f7398a;
                        StringBuilder sb = new StringBuilder();
                        sb.append("zipFile.close Exception!");
                        sb.append(e2.getMessage());
                        HMSLog.e(str2, sb.toString());
                        zipFile2 = sb;
                    }
                } catch (Exception e3) {
                    e = e3;
                    zipFile3 = zipFile;
                    HMSLog.e(f7398a, "isCertFound Exception!" + e.getMessage());
                    ZipFile zipFile4 = zipFile3;
                    if (zipFile3 != null) {
                        try {
                            zipFile3.close();
                            zipFile4 = zipFile3;
                        } catch (IOException e4) {
                            String str3 = f7398a;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("zipFile.close Exception!");
                            sb2.append(e4.getMessage());
                            HMSLog.e(str3, sb2.toString());
                            zipFile4 = sb2;
                        }
                    }
                    z = false;
                    zipFile2 = zipFile4;
                    return z;
                } catch (Throwable th) {
                    th = th;
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException e5) {
                            HMSLog.e(f7398a, "zipFile.close Exception!" + e5.getMessage());
                        }
                    }
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
            }
            return z;
        } catch (Throwable th2) {
            th = th2;
            zipFile = zipFile2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean verifyApkHash(String str) throws Throwable {
        ZipFile zipFile;
        String str2 = null;
        ZipFile zipFile2 = null;
        try {
            try {
                zipFile = new ZipFile(str);
                try {
                    byte[] bArrA = a(zipFile);
                    ArrayList<String> arrayListA = a(bArrA);
                    if (arrayListA != null) {
                        bArrA = a(arrayListA);
                    }
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                    messageDigest.update(bArrA);
                    String strBytesToString = bytesToString(messageDigest.digest());
                    String str3 = f7403f;
                    if (str3 != null) {
                        if (str3.equals(strBytesToString)) {
                            try {
                                zipFile.close();
                            } catch (Exception e2) {
                                HMSLog.i(f7398a, "close stream Exception!" + e2.getMessage());
                            }
                            return true;
                        }
                    }
                    try {
                        zipFile.close();
                        return false;
                    } catch (Exception e3) {
                        HMSLog.i(f7398a, "close stream Exception!" + e3.getMessage());
                        return false;
                    }
                } catch (Exception e4) {
                    e = e4;
                    zipFile2 = zipFile;
                    HMSLog.i(f7398a, "verifyApkHash Exception!" + e.getMessage());
                    if (zipFile2 == null) {
                        return false;
                    }
                    try {
                        zipFile2.close();
                        return false;
                    } catch (Exception e5) {
                        str2 = f7398a;
                        HMSLog.i(str2, "close stream Exception!" + e5.getMessage());
                        return false;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (Exception e6) {
                            HMSLog.i(f7398a, "close stream Exception!" + e6.getMessage());
                        }
                    }
                    throw th;
                }
            } catch (Exception e7) {
                e = e7;
            }
        } catch (Throwable th2) {
            th = th2;
            zipFile = str2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.io.BufferedOutputStream, java.io.OutputStream] */
    private static byte[] a(ZipFile zipFile, String str) throws Throwable {
        Throwable th;
        InputStream inputStream;
        Exception e2;
        Throwable th2;
        BufferedInputStream bufferedInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ?? bufferedOutputStream;
        OutputStream outputStream;
        OutputStream outputStream2;
        ZipEntry entry = zipFile.getEntry(str);
        OutputStream outputStream3 = null;
        if (entry == null) {
            return null;
        }
        try {
            inputStream = zipFile.getInputStream(entry);
            if (inputStream == null) {
                IOUtils.closeQuietly(inputStream);
                IOUtils.closeQuietly((InputStream) null);
                IOUtils.closeQuietly((OutputStream) null);
                IOUtils.closeQuietly((OutputStream) null);
                return null;
            }
            try {
                bufferedInputStream = new BufferedInputStream(inputStream);
            } catch (Exception e3) {
                e2 = e3;
                bufferedInputStream = null;
                byteArrayOutputStream = null;
                bufferedOutputStream = byteArrayOutputStream;
                try {
                    HMSLog.i(f7398a, "getManifestBytes Exception!" + e2.getMessage());
                    IOUtils.closeQuietly(inputStream);
                    IOUtils.closeQuietly((InputStream) bufferedInputStream);
                    IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                    IOUtils.closeQuietly((OutputStream) bufferedOutputStream);
                    return null;
                } catch (Throwable th3) {
                    th2 = th3;
                    outputStream2 = bufferedOutputStream;
                    bufferedInputStream = bufferedInputStream;
                    outputStream = outputStream2;
                    outputStream3 = outputStream;
                    IOUtils.closeQuietly(inputStream);
                    IOUtils.closeQuietly((InputStream) bufferedInputStream);
                    IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                    IOUtils.closeQuietly(outputStream3);
                    throw th2;
                }
            } catch (Throwable th4) {
                th = th4;
                th2 = th;
                bufferedInputStream = null;
                byteArrayOutputStream = null;
                IOUtils.closeQuietly(inputStream);
                IOUtils.closeQuietly((InputStream) bufferedInputStream);
                IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                IOUtils.closeQuietly(outputStream3);
                throw th2;
            }
            try {
                byte[] bArr = new byte[4096];
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    bufferedOutputStream = new BufferedOutputStream(byteArrayOutputStream);
                } catch (Exception e4) {
                    e2 = e4;
                    bufferedOutputStream = 0;
                } catch (Throwable th5) {
                    th2 = th5;
                    IOUtils.closeQuietly(inputStream);
                    IOUtils.closeQuietly((InputStream) bufferedInputStream);
                    IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                    IOUtils.closeQuietly(outputStream3);
                    throw th2;
                }
                try {
                    for (int i2 = bufferedInputStream.read(bArr, 0, 4096); i2 > 0; i2 = bufferedInputStream.read(bArr, 0, 4096)) {
                        bufferedOutputStream.write(bArr, 0, i2);
                    }
                    bufferedOutputStream.flush();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    IOUtils.closeQuietly(inputStream);
                    IOUtils.closeQuietly((InputStream) bufferedInputStream);
                    IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                    IOUtils.closeQuietly((OutputStream) bufferedOutputStream);
                    return byteArray;
                } catch (Exception e5) {
                    e2 = e5;
                    HMSLog.i(f7398a, "getManifestBytes Exception!" + e2.getMessage());
                    IOUtils.closeQuietly(inputStream);
                    IOUtils.closeQuietly((InputStream) bufferedInputStream);
                    IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                    IOUtils.closeQuietly((OutputStream) bufferedOutputStream);
                    return null;
                } catch (Throwable th6) {
                    th2 = th6;
                    outputStream = bufferedOutputStream;
                    outputStream3 = outputStream;
                    IOUtils.closeQuietly(inputStream);
                    IOUtils.closeQuietly((InputStream) bufferedInputStream);
                    IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                    IOUtils.closeQuietly(outputStream3);
                    throw th2;
                }
            } catch (Exception e6) {
                e2 = e6;
                byteArrayOutputStream = null;
                bufferedOutputStream = byteArrayOutputStream;
                HMSLog.i(f7398a, "getManifestBytes Exception!" + e2.getMessage());
                IOUtils.closeQuietly(inputStream);
                IOUtils.closeQuietly((InputStream) bufferedInputStream);
                IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                IOUtils.closeQuietly((OutputStream) bufferedOutputStream);
                return null;
            } catch (Throwable th7) {
                th2 = th7;
                byteArrayOutputStream = null;
                outputStream2 = null;
                bufferedInputStream = bufferedInputStream;
                outputStream = outputStream2;
                outputStream3 = outputStream;
                IOUtils.closeQuietly(inputStream);
                IOUtils.closeQuietly((InputStream) bufferedInputStream);
                IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                IOUtils.closeQuietly(outputStream3);
                throw th2;
            }
        } catch (Exception e7) {
            e2 = e7;
            inputStream = null;
        } catch (Throwable th8) {
            th = th8;
            inputStream = null;
        }
    }

    @TargetApi(19)
    private static ArrayList<String> a(byte[] bArr) throws IOException {
        if (bArr == null) {
            HMSLog.e(f7398a, "manifest is null！");
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(byteArrayInputStream, StandardCharsets.UTF_8));
                try {
                    if (a(bufferedReader, arrayList)) {
                        bufferedReader.close();
                        byteArrayInputStream.close();
                        return arrayList;
                    }
                    bufferedReader.close();
                    byteArrayInputStream.close();
                    return null;
                } finally {
                }
            } finally {
            }
        } catch (IOException unused) {
            HMSLog.e(f7398a, "getManifestLinesArrary IOException!");
            return null;
        }
    }

    private static boolean b() {
        try {
        } catch (Exception e2) {
            HMSLog.i(f7398a, "verifyMDMSignatureV2 MDM verify Exception!:" + e2.getMessage());
        }
        if (a(Base64.decode(EMUI10_PK, 0), a(f7404g, "SHA-256"), b(f7401d), "SHA256withRSA")) {
            HMSLog.i(f7398a, "verifyMDMSignatureV2 verify successful!");
            return true;
        }
        HMSLog.i(f7398a, "verifyMDMSignatureV2 verify failure!");
        return false;
    }

    @TargetApi(19)
    private static byte[] a(ArrayList<String> arrayList) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, StandardCharsets.UTF_8));
        try {
            try {
                Collections.sort(arrayList);
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    String str = arrayList.get(i2);
                    bufferedWriter.write(str, 0, str.length());
                    bufferedWriter.write("\r\n", 0, 2);
                }
                bufferedWriter.flush();
            } catch (Exception e2) {
                HMSLog.i(f7398a, "getManifestBytesbySorted Exception!" + e2.getMessage());
            }
            IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
            IOUtils.closeQuietly((Writer) bufferedWriter);
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
            IOUtils.closeQuietly((Writer) bufferedWriter);
            throw th;
        }
    }

    private static byte[] b(String str) {
        int i2;
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        int length = str.length();
        if (length % 2 == 0) {
            i2 = length / 2;
        } else {
            i2 = (length / 2) + 1;
        }
        byte[] bArr = new byte[i2];
        for (int i3 = 0; i3 < length; i3 += 2) {
            int i4 = i3 + 1;
            if (i4 < length) {
                bArr[i3 / 2] = (byte) ((Character.digit(str.charAt(i3), 16) << 4) + Character.digit(str.charAt(i4), 16));
            } else {
                bArr[i3 / 2] = (byte) (Character.digit(str.charAt(i3), 16) << 4);
            }
        }
        return bArr;
    }

    private static boolean a(BufferedReader bufferedReader, ArrayList<String> arrayList) throws IOException {
        String strA = a(bufferedReader);
        boolean z = false;
        while (strA != null) {
            if (strA.equals("Name: META-INF/HUAWEI.CER")) {
                z = true;
                String strA2 = a(bufferedReader);
                while (true) {
                    if (strA2 == null) {
                        break;
                    }
                    if (strA2.startsWith("Name:")) {
                        strA = strA2;
                        break;
                    }
                    strA2 = a(bufferedReader);
                }
            }
            if (strA.length() != 0) {
                arrayList.add(strA);
            }
            strA = a(bufferedReader);
        }
        return z;
    }

    private static String a(BufferedReader bufferedReader) throws IOException {
        int i2;
        if (bufferedReader == null || (i2 = bufferedReader.read()) == -1) {
            return null;
        }
        StringBuilder sb = new StringBuilder(10);
        while (i2 != -1) {
            char c2 = (char) i2;
            if (c2 == '\n') {
                break;
            }
            if (sb.length() < 4096) {
                sb.append(c2);
                i2 = bufferedReader.read();
            } else {
                throw new IOException("cert line is too long!");
            }
        }
        String string = sb.toString();
        return (string.isEmpty() || !string.endsWith("\r")) ? string : string.substring(0, string.length() - 1);
    }

    private static boolean a() {
        try {
            if (a(b("30820122300d06092a864886f70d01010105000382010f003082010a0282010100a3d269348ac59923f65e8111c337605e29a1d1bc54fa96c1445050dd14d8d63b10f9f0230bb87ef348183660bedcabfdec045e235ed96935799fcdb4af5c97717ff3b0954eaf1b723225b3a00f81cbd67ce6dc5a4c07f7741ad3bf1913a480c6e267ab1740f409edd2dc33c8b718a8e30e56d9a93f321723c1d0c9ea62115f996812ceef186954595e39a19b74245542c407f7dddb1d12e6eedcfc0bd7cd945ef7255ad0fc9e796258e0fb5e52a23013d15033a32b4071b65f3f924ae5c5761e22327b4d2ae60f4158a5eb15565ba079de29b81540f5fbb3be101a95357f367fc661d797074ff3826950029c52223e4594673a24a334cae62d63b838ba3df9770203010001"), a(f7404g, "SHA-256"), b(f7400c), "SHA256withRSA")) {
                HMSLog.i(f7398a, "verifyMDMSignatureV1 verify successful!");
                return true;
            }
            HMSLog.i(f7398a, "verifyMDMSignatureV1 verify failure!");
            return false;
        } catch (Exception e2) {
            HMSLog.i(f7398a, "verifyMDMSignatureV1 MDM verify Exception!:" + e2.getMessage());
            return false;
        }
    }

    private static boolean a(byte[] bArr, byte[] bArr2, byte[] bArr3, String str) throws Exception {
        Signature signature = Signature.getInstance(str);
        signature.initVerify(KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr)));
        signature.update(bArr2);
        return signature.verify(bArr3);
    }

    @TargetApi(19)
    private static byte[] a(String str, String str2) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance(str2);
        messageDigest.update(str.getBytes(StandardCharsets.UTF_8.name()));
        return messageDigest.digest();
    }

    private static String a(String str) {
        return str != null ? f7399b.matcher(str).replaceAll("") : "";
    }
}
