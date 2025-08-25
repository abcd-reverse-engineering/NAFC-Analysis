package com.huawei.secure.android.common.encrypt.utils;

import android.os.Build;
import android.util.Base64;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.prng.SP800SecureRandomBuilder;

/* loaded from: classes.dex */
public class EncryptUtil {

    /* renamed from: a, reason: collision with root package name */
    private static final String f7524a = "EncryptUtil";

    /* renamed from: b, reason: collision with root package name */
    private static final String f7525b = "RSA";

    /* renamed from: c, reason: collision with root package name */
    private static boolean f7526c = true;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f7527d = true;

    private static SecureRandom a() {
        b.a(f7524a, "generateSecureRandomNew ");
        try {
        } catch (NoSuchAlgorithmException unused) {
            b.b(f7524a, "getSecureRandomBytes: NoSuchAlgorithmException");
        }
        SecureRandom instanceStrong = Build.VERSION.SDK_INT >= 26 ? SecureRandom.getInstanceStrong() : null;
        if (instanceStrong == null) {
            try {
                instanceStrong = SecureRandom.getInstance("SHA1PRNG");
            } catch (NoSuchAlgorithmException unused2) {
                b.b(f7524a, "NoSuchAlgorithmException");
                return instanceStrong;
            } catch (Throwable th) {
                if (f7527d) {
                    b.b(f7524a, "exception : " + th.getMessage() + " , you should implementation bcprov-jdk15on library");
                    f7527d = false;
                }
                return instanceStrong;
            }
        }
        AESEngine aESEngine = new AESEngine();
        byte[] bArr = new byte[32];
        instanceStrong.nextBytes(bArr);
        return new SP800SecureRandomBuilder(instanceStrong, true).setEntropyBitsRequired(384).buildCTR(aESEngine, 256, bArr, false);
    }

    public static SecureRandom genSecureRandom() {
        if (f7526c) {
            return a();
        }
        SecureRandom instanceStrong = null;
        try {
            instanceStrong = Build.VERSION.SDK_INT >= 26 ? SecureRandom.getInstanceStrong() : SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException unused) {
            b.b(f7524a, "genSecureRandom: NoSuchAlgorithmException");
        }
        return instanceStrong;
    }

    public static byte[] generateSecureRandom(int i2) throws NoSuchAlgorithmException {
        if (f7526c) {
            return a(i2);
        }
        byte[] bArr = new byte[i2];
        SecureRandom secureRandom = null;
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                secureRandom = SecureRandom.getInstanceStrong();
            }
        } catch (NoSuchAlgorithmException unused) {
            b.b(f7524a, "getSecureRandomBytes: NoSuchAlgorithmException");
        }
        if (secureRandom == null) {
            try {
                secureRandom = SecureRandom.getInstance("SHA1PRNG");
            } catch (NoSuchAlgorithmException unused2) {
                b.b(f7524a, "getSecureRandomBytes getInstance: NoSuchAlgorithmException");
                return new byte[0];
            } catch (Exception e2) {
                b.b(f7524a, "getSecureRandomBytes getInstance: exception : " + e2.getMessage());
                return new byte[0];
            }
        }
        secureRandom.nextBytes(bArr);
        return bArr;
    }

    public static String generateSecureRandomStr(int i2) {
        return HexUtil.byteArray2HexStr(generateSecureRandom(i2));
    }

    public static PrivateKey getPrivateKey(String str) {
        try {
            try {
                return KeyFactory.getInstance(f7525b).generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str, 0)));
            } catch (GeneralSecurityException e2) {
                b.b(f7524a, "load Key Exception:" + e2.getMessage());
                return null;
            }
        } catch (IllegalArgumentException unused) {
            b.b(f7524a, "base64 decode IllegalArgumentException");
            return null;
        } catch (Exception e3) {
            b.b(f7524a, "base64 decode Exception" + e3.getMessage());
            return null;
        }
    }

    public static RSAPublicKey getPublicKey(String str) {
        try {
            try {
                return (RSAPublicKey) KeyFactory.getInstance(f7525b).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
            } catch (GeneralSecurityException e2) {
                b.b(f7524a, "load Key Exception:" + e2.getMessage());
                return null;
            }
        } catch (IllegalArgumentException unused) {
            b.b(f7524a, "base64 decode IllegalArgumentException");
            return null;
        } catch (Exception e3) {
            b.b(f7524a, "base64 decode Exception" + e3.getMessage());
            return null;
        }
    }

    public static boolean isBouncycastleFlag() {
        return f7526c;
    }

    public static void setBouncycastleFlag(boolean z) {
        b.c(f7524a, "setBouncycastleFlag: " + z);
        f7526c = z;
    }

    private static byte[] a(int i2) {
        SecureRandom secureRandomA = a();
        if (secureRandomA == null) {
            return new byte[0];
        }
        byte[] bArr = new byte[i2];
        secureRandomA.nextBytes(bArr);
        return bArr;
    }
}
