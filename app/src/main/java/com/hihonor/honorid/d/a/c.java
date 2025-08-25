package com.hihonor.honorid.d.a;

import android.annotation.TargetApi;
import android.security.keystore.KeyGenParameterSpec;
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
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

/* compiled from: KeyStoreEncryptAndDecrypt.java */
/* loaded from: classes.dex */
public class c {
    public static String a(String str, String str2) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        byte[] bArrA = a.a(str2);
        if (bArrA.length <= 16) {
            k.a.a.a.j.e.a("KeyStoreEncryptAndDecrypt", "Decrypt source data is invalid.", true);
            return "";
        }
        byte[] bArrDoFinal = new byte[0];
        try {
            SecretKey secretKeyA = a(str);
            byte[] bArrCopyOf = Arrays.copyOf(bArrA, 16);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            cipher.init(2, secretKeyA, new IvParameterSpec(bArrCopyOf));
            bArrDoFinal = cipher.doFinal(bArrA, 16, bArrA.length - 16);
        } catch (RuntimeException unused) {
            k.a.a.a.j.e.b("KeyStoreEncryptAndDecrypt", "RuntimeException", true);
        } catch (Exception unused2) {
            k.a.a.a.j.e.a("KeyStoreEncryptAndDecrypt", "Decrypt exception", true);
        }
        try {
            return new String(bArrDoFinal, "UTF-8");
        } catch (UnsupportedEncodingException unused3) {
            k.a.a.a.j.e.b("KeyStoreEncryptAndDecrypt", "unreachable UnsupportedEncodingException", true);
            return "";
        }
    }

    public static String b(String str, String str2) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        byte[] bArrDoFinal;
        byte[] iv;
        byte[] bArrCopyOf = new byte[0];
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            cipher.init(1, a(str));
            bArrDoFinal = cipher.doFinal(str2.getBytes("UTF-8"));
            iv = cipher.getIV();
        } catch (RuntimeException unused) {
            k.a.a.a.j.e.b("KeyStoreEncryptAndDecrypt", "RuntimeException", true);
        } catch (Exception unused2) {
            k.a.a.a.j.e.a("KeyStoreEncryptAndDecrypt", "Encrypt exception", true);
        }
        if (iv != null && iv.length == 16) {
            bArrCopyOf = Arrays.copyOf(iv, iv.length + bArrDoFinal.length);
            System.arraycopy(bArrDoFinal, 0, bArrCopyOf, iv.length, bArrDoFinal.length);
            return a.a(bArrCopyOf);
        }
        k.a.a.a.j.e.a("KeyStoreEncryptAndDecrypt", "IV is invalid.", true);
        return "";
    }

    @TargetApi(23)
    private static SecretKey a(String str) throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyStoreException, CertificateException, NoSuchProviderException, InvalidAlgorithmParameterException {
        SecretKey secretKeyGenerateKey = null;
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            Key key = keyStore.getKey(str, null);
            if (key != null && (key instanceof SecretKey)) {
                secretKeyGenerateKey = (SecretKey) key;
            } else {
                KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
                keyGenerator.init(new KeyGenParameterSpec.Builder(str, 3).setBlockModes("CBC").setEncryptionPaddings("PKCS7Padding").setKeySize(256).build());
                secretKeyGenerateKey = keyGenerator.generateKey();
            }
        } catch (RuntimeException unused) {
            k.a.a.a.j.e.b("KeyStoreEncryptAndDecrypt", "RuntimeException", true);
        } catch (Exception unused2) {
            k.a.a.a.j.e.a("KeyStoreEncryptAndDecrypt", "Generate key exception ", true);
        }
        return secretKeyGenerateKey;
    }
}
