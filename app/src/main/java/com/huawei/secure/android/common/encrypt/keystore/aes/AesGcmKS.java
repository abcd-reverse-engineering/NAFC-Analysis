package com.huawei.secure.android.common.encrypt.keystore.aes;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

/* loaded from: classes.dex */
public class AesGcmKS {

    /* renamed from: a, reason: collision with root package name */
    private static final String f7488a = "GCMKS";

    /* renamed from: b, reason: collision with root package name */
    private static final String f7489b = "AndroidKeyStore";

    /* renamed from: c, reason: collision with root package name */
    private static final String f7490c = "AES/GCM/NoPadding";

    /* renamed from: d, reason: collision with root package name */
    private static final String f7491d = "";

    /* renamed from: e, reason: collision with root package name */
    private static final int f7492e = 12;

    /* renamed from: f, reason: collision with root package name */
    private static final int f7493f = 256;

    /* renamed from: g, reason: collision with root package name */
    private static Map<String, SecretKey> f7494g = new HashMap();

    private static SecretKey a(String str) throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyStoreException, CertificateException, NoSuchProviderException, InvalidAlgorithmParameterException {
        b.c(f7488a, "load key");
        SecretKey secretKeyGenerateKey = null;
        try {
            KeyStore keyStore = KeyStore.getInstance(f7489b);
            keyStore.load(null);
            Key key = keyStore.getKey(str, null);
            if (key instanceof SecretKey) {
                secretKeyGenerateKey = (SecretKey) key;
            } else {
                b.c(f7488a, "generate key");
                KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", f7489b);
                keyGenerator.init(new KeyGenParameterSpec.Builder(str, 3).setBlockModes("GCM").setEncryptionPaddings("NoPadding").setKeySize(256).build());
                secretKeyGenerateKey = keyGenerator.generateKey();
            }
        } catch (IOException e2) {
            b.b(f7488a, "IOException : " + e2.getMessage());
        } catch (InvalidAlgorithmParameterException e3) {
            b.b(f7488a, "InvalidAlgorithmParameterException : " + e3.getMessage());
        } catch (KeyStoreException e4) {
            b.b(f7488a, "KeyStoreException : " + e4.getMessage());
        } catch (NoSuchAlgorithmException e5) {
            b.b(f7488a, "NoSuchAlgorithmException : " + e5.getMessage());
        } catch (NoSuchProviderException e6) {
            b.b(f7488a, "NoSuchProviderException : " + e6.getMessage());
        } catch (UnrecoverableKeyException e7) {
            b.b(f7488a, "UnrecoverableKeyException : " + e7.getMessage());
        } catch (CertificateException e8) {
            b.b(f7488a, "CertificateException : " + e8.getMessage());
        } catch (Exception e9) {
            b.b(f7488a, "Exception: " + e9.getMessage());
        }
        f7494g.put(str, secretKeyGenerateKey);
        return secretKeyGenerateKey;
    }

    private static SecretKey b(String str) throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyStoreException, CertificateException, NoSuchProviderException, InvalidAlgorithmParameterException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (f7494g.get(str) == null) {
            a(str);
        }
        return f7494g.get(str);
    }

    public static String decrypt(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            b.b(f7488a, "alias or encrypt content is null");
            return "";
        }
        try {
            return new String(decrypt(str, HexUtil.hexStr2ByteArray(str2)), "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            b.b(f7488a, "decrypt: UnsupportedEncodingException : " + e2.getMessage());
            return "";
        }
    }

    public static String encrypt(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            b.b(f7488a, "alias or encrypt content is null");
            return "";
        }
        try {
            return HexUtil.byteArray2HexStr(encrypt(str, str2.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e2) {
            b.b(f7488a, "encrypt: UnsupportedEncodingException : " + e2.getMessage());
            return "";
        }
    }

    public static byte[] decrypt(String str, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (!TextUtils.isEmpty(str) && bArr != null) {
            if (!a()) {
                b.b(f7488a, "sdk version is too low");
                return bArr2;
            }
            if (bArr.length <= 12) {
                b.b(f7488a, "Decrypt source data is invalid.");
                return bArr2;
            }
            return decrypt(b(str), bArr);
        }
        b.b(f7488a, "alias or encrypt content is null");
        return bArr2;
    }

    public static byte[] encrypt(String str, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (!TextUtils.isEmpty(str) && bArr != null) {
            if (!a()) {
                b.b(f7488a, "sdk version is too low");
                return bArr2;
            }
            return encrypt(b(str), bArr);
        }
        b.b(f7488a, "alias or encrypt content is null");
        return bArr2;
    }

    public static byte[] encrypt(SecretKey secretKey, byte[] bArr) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        byte[] bArr2 = new byte[0];
        if (bArr == null) {
            b.b(f7488a, "content is null");
            return bArr2;
        }
        if (secretKey == null) {
            b.b(f7488a, "secret key is null");
            return bArr2;
        }
        if (!a()) {
            b.b(f7488a, "sdk version is too low");
            return bArr2;
        }
        try {
            Cipher cipher = Cipher.getInstance(f7490c);
            cipher.init(1, secretKey);
            byte[] bArrDoFinal = cipher.doFinal(bArr);
            byte[] iv = cipher.getIV();
            if (iv != null && iv.length == 12) {
                byte[] bArrCopyOf = Arrays.copyOf(iv, iv.length + bArrDoFinal.length);
                System.arraycopy(bArrDoFinal, 0, bArrCopyOf, iv.length, bArrDoFinal.length);
                return bArrCopyOf;
            }
            b.b(f7488a, "IV is invalid.");
            return bArr2;
        } catch (InvalidKeyException e2) {
            b.b(f7488a, "InvalidKeyException : " + e2.getMessage());
            return bArr2;
        } catch (NoSuchAlgorithmException e3) {
            b.b(f7488a, "NoSuchAlgorithmException : " + e3.getMessage());
            return bArr2;
        } catch (BadPaddingException e4) {
            b.b(f7488a, "BadPaddingException : " + e4.getMessage());
            return bArr2;
        } catch (IllegalBlockSizeException e5) {
            b.b(f7488a, "IllegalBlockSizeException : " + e5.getMessage());
            return bArr2;
        } catch (NoSuchPaddingException e6) {
            b.b(f7488a, "NoSuchPaddingException : " + e6.getMessage());
            return bArr2;
        } catch (Exception e7) {
            b.b(f7488a, "Exception: " + e7.getMessage());
            return bArr2;
        }
    }

    public static byte[] decrypt(SecretKey secretKey, byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        byte[] bArr2 = new byte[0];
        if (secretKey == null) {
            b.b(f7488a, "Decrypt secret key is null");
            return bArr2;
        }
        if (bArr == null) {
            b.b(f7488a, "content is null");
            return bArr2;
        }
        if (!a()) {
            b.b(f7488a, "sdk version is too low");
            return bArr2;
        }
        if (bArr.length <= 12) {
            b.b(f7488a, "Decrypt source data is invalid.");
            return bArr2;
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, 12);
        try {
            Cipher cipher = Cipher.getInstance(f7490c);
            cipher.init(2, secretKey, new GCMParameterSpec(128, bArrCopyOf));
            return cipher.doFinal(bArr, 12, bArr.length - 12);
        } catch (InvalidAlgorithmParameterException e2) {
            b.b(f7488a, "InvalidAlgorithmParameterException : " + e2.getMessage());
            return bArr2;
        } catch (InvalidKeyException e3) {
            b.b(f7488a, "InvalidKeyException : " + e3.getMessage());
            return bArr2;
        } catch (NoSuchAlgorithmException e4) {
            b.b(f7488a, "NoSuchAlgorithmException : " + e4.getMessage());
            return bArr2;
        } catch (BadPaddingException e5) {
            b.b(f7488a, "BadPaddingException : " + e5.getMessage());
            return bArr2;
        } catch (IllegalBlockSizeException e6) {
            b.b(f7488a, "IllegalBlockSizeException : " + e6.getMessage());
            return bArr2;
        } catch (NoSuchPaddingException e7) {
            b.b(f7488a, "NoSuchPaddingException : " + e7.getMessage());
            return bArr2;
        } catch (Exception e8) {
            b.b(f7488a, "Exception: " + e8.getMessage());
            return bArr2;
        }
    }

    private static boolean a() {
        return Build.VERSION.SDK_INT >= 23;
    }
}
