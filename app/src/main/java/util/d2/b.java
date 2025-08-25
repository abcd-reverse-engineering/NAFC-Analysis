package util.d2;

import android.text.TextUtils;
import android.util.Base64;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import util.u0;

/* compiled from: UrlAES.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f20802a = "hicore2020051518";

    /* renamed from: b, reason: collision with root package name */
    private static final String f20803b = "AES/ECB/PKCS5Padding";

    /* renamed from: c, reason: collision with root package name */
    private static final String f20804c = "hicore2020051518";

    /* renamed from: d, reason: collision with root package name */
    private static final String f20805d = "UTF-8";

    /* renamed from: e, reason: collision with root package name */
    private static final String f20806e = "AES";

    public static String a(String str) {
        try {
            return TextUtils.isEmpty(str) ? "" : u0.a(str.replaceAll(c.c.a.b.a.a.f3100g, "+"), "hicore2020051518", "hicore2020051518");
        } catch (Exception unused) {
            return "";
        }
    }

    public static String b(String str) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec("hicore2020051518".getBytes("UTF-8"), f20806e);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, new IvParameterSpec("hicore2020051518".getBytes()));
            return new String(cipher.doFinal(Base64.decode(str, 0)));
        } catch (Exception unused) {
            return "";
        }
    }

    public static String c(String str) {
        try {
            return TextUtils.isEmpty(str) ? "" : u0.b(str.replaceAll(c.c.a.b.a.a.f3100g, "+"), "hicore2020051518", "hicore2020051518");
        } catch (Exception unused) {
            return "";
        }
    }
}
