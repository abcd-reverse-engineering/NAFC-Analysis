package com.luck.picture.lib.tools;

import android.text.TextUtils;
import c.c.a.b.a.a;
import h.f1;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

/* loaded from: classes.dex */
public class DESUtils {
    private static final String ALGORITHM_DES = "DES/CBC/PKCS5Padding";
    public static final String DES_KEY_STRING = "lmw#2020";

    private static String byte2String(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; bArr != null && i2 < bArr.length; i2++) {
            String hexString = Integer.toHexString(bArr[i2] & f1.f16099c);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString().toUpperCase(Locale.CHINA);
    }

    public static String encode(String str, String str2, int i2, int i3) throws InvalidKeySpecException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException, InvalidAlgorithmParameterException {
        if (str2 == null) {
            return null;
        }
        String str3 = str2 + a.s1 + i2 + "x" + i3;
        try {
            SecretKey secretKeyGenerateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(str.getBytes()));
            Cipher cipher = Cipher.getInstance(ALGORITHM_DES);
            cipher.init(1, secretKeyGenerateSecret, new IvParameterSpec(DES_KEY_STRING.getBytes()));
            String strEncode = URLEncoder.encode(byte2String(cipher.doFinal(str3.getBytes())), "UTF-8");
            if (TextUtils.isEmpty(strEncode)) {
                return null;
            }
            return strEncode.length() > 30 ? strEncode.substring(strEncode.length() - 30) : strEncode;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
