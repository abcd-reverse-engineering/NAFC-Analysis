package util;

import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import androidx.exifinterface.media.ExifInterface;
import com.xiaomi.mipush.sdk.Constants;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import ui.Hicore;

/* compiled from: AESUtil.java */
/* loaded from: classes2.dex */
public class u0 {

    /* renamed from: a, reason: collision with root package name */
    private static Cipher f20987a = null;

    /* renamed from: b, reason: collision with root package name */
    private static final String f20988b = "UTF-8";

    /* renamed from: c, reason: collision with root package name */
    private static final String f20989c = "AES";

    /* renamed from: d, reason: collision with root package name */
    private static final String f20990d = "SHA1PRNG";

    /* renamed from: e, reason: collision with root package name */
    private static final String f20991e = "AES/CBC/PKCS5Padding";

    /* renamed from: f, reason: collision with root package name */
    private static final Integer f20992f = 128;

    /* renamed from: g, reason: collision with root package name */
    private static final Integer f20993g = 16;

    /* renamed from: h, reason: collision with root package name */
    private static byte[] f20994h;

    /* compiled from: AESUtil.java */
    public static class a extends Provider {
        public a() {
            super("Crypto", 1.0d, "HARMONY (SHA1 digest; SecureRandom; SHA1withDSA signature)");
            put("SecureRandom.SHA1PRNG", "org.apache.harmony.security.provider.crypto.SHA1PRNG_SecureRandomImpl");
            put("SecureRandom.SHA1PRNG ImplementedIn", ExifInterface.TAG_SOFTWARE);
        }
    }

    private static byte[] a(String str) throws Exception {
        byte[] bArr = f20994h;
        if (bArr == null || bArr.length != 32) {
            SharedPreferences sharedPreferences = Hicore.getApp().getSharedPreferences("crypto_info", 0);
            String string = sharedPreferences.getString("salt", "");
            if (!TextUtils.isEmpty(string)) {
                f20994h = e(string);
            }
            byte[] bArr2 = f20994h;
            if (bArr2 == null || bArr2.length != 32) {
                byte[] bArr3 = new byte[32];
                new SecureRandom().nextBytes(bArr3);
                sharedPreferences.edit().putString("salt", c(bArr3)).commit();
                f20994h = bArr3;
            }
        }
        return new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(str.toCharArray(), f20994h, 1000, 256)).getEncoded(), f20989c).getEncoded();
    }

    private static byte[] b(byte[] bArr) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(f20989c);
        int i2 = Build.VERSION.SDK_INT;
        SecureRandom secureRandom = i2 > 23 ? SecureRandom.getInstance(f20990d, new a()) : i2 >= 17 ? SecureRandom.getInstance(f20990d, "Crypto") : SecureRandom.getInstance(f20990d);
        secureRandom.setSeed(bArr);
        keyGenerator.init(128, secureRandom);
        return keyGenerator.generateKey().getEncoded();
    }

    public static String c(byte[] bArr) {
        return a(bArr, (String) null);
    }

    public static String d(String str) {
        return c(str).substring(8, 24);
    }

    public static byte[] e(String str) {
        return a(str, (String) null, (byte) 0);
    }

    public static String c(String str) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b2 : bArrDigest) {
                stringBuffer.append(String.format("%02X", Integer.valueOf(b2 & h.f1.f16099c)));
            }
            return stringBuffer.toString();
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return "";
        } catch (NoSuchAlgorithmException e3) {
            e3.printStackTrace();
            return "";
        }
    }

    public static String b(String str, String str2, String str3) throws Exception {
        Cipher cipher = Cipher.getInstance(f20991e);
        cipher.init(1, new SecretKeySpec(str2.getBytes("UTF-8"), f20989c), new IvParameterSpec(str3.getBytes("UTF-8")));
        String strEncodeToString = Base64.encodeToString(cipher.doFinal(str.getBytes("UTF-8")), 0);
        n1.b("encrypt-->", strEncodeToString);
        n1.b("decrypt-->", a(strEncodeToString, str2, str3));
        n1.b("encrypt 2-->", strEncodeToString);
        return strEncodeToString;
    }

    public static String a(byte[] bArr, String str) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        if (length <= 0) {
            return "";
        }
        if (TextUtils.isEmpty(str)) {
            str = Constants.ACCEPT_TIME_SEPARATOR_SP;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < length; i2++) {
            sb.append(String.valueOf((int) bArr[i2]));
            if (i2 != length - 1) {
                sb.append(str);
            }
        }
        return sb.toString();
    }

    public static String b(String str, String str2) throws UnsupportedEncodingException {
        String strD = d(str);
        if (strD.length() == f20993g.intValue()) {
            try {
                a(strD, 1);
                return a(f20987a.doFinal(str2.getBytes("UTF-8")));
            } catch (Exception e2) {
                throw new RuntimeException("AESUtil:encrypt fail!", e2);
            }
        }
        throw new RuntimeException("AESUtil:Invalid AES secretKey length (must be 16 bytes)");
    }

    public static byte[] a(String str, String str2, byte b2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = Constants.ACCEPT_TIME_SEPARATOR_SP;
        }
        String[] strArrSplit = str.split(str2);
        int length = strArrSplit.length;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            try {
                bArr[i2] = Byte.parseByte(strArrSplit[i2]);
            } catch (Exception unused) {
                bArr[i2] = b2;
            }
        }
        return bArr;
    }

    private static byte[] b(String str) {
        byte[] bArr = new byte[str.length() / 2];
        int i2 = 0;
        while (i2 < str.length()) {
            int i3 = i2 + 2;
            bArr[i2 / 2] = (byte) Integer.parseInt(str.substring(i2, i3), 16);
            i2 = i3;
        }
        return bArr;
    }

    public static String a(String str, String str2, String str3) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes("UTF-8"), f20989c);
        Cipher cipher = Cipher.getInstance(f20991e);
        cipher.init(2, secretKeySpec, new IvParameterSpec(str3.getBytes("UTF-8")));
        return new String(cipher.doFinal(Base64.decode(str, 0)), "UTF-8");
    }

    public static String a(String str, String str2) {
        String strD = d(str);
        if (strD.length() == f20993g.intValue()) {
            try {
                a(strD, 2);
                return new String(f20987a.doFinal(b(str2)), "UTF-8");
            } catch (Exception e2) {
                throw new RuntimeException("AESUtil:decrypt fail!", e2);
            }
        }
        throw new RuntimeException("AESUtil:Invalid AES secretKey length (must be 16 bytes)");
    }

    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b2 : bArr) {
            sb.append(String.format("%02X", Byte.valueOf(b2)));
        }
        return sb.toString();
    }

    public static void a(String str, int i2) throws NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        try {
            SecureRandom secureRandom = SecureRandom.getInstance(f20990d);
            secureRandom.setSeed(str.getBytes());
            KeyGenerator.getInstance(f20989c).init(f20992f.intValue(), secureRandom);
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), f20989c);
            f20987a = Cipher.getInstance(f20991e);
            f20987a.init(i2, secretKeySpec, new IvParameterSpec(d(str).getBytes()));
        } catch (Exception e2) {
            throw new RuntimeException("AESUtil:initParam fail!", e2);
        }
    }
}
