package util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayOutputStream;

/* compiled from: Base64Utils.java */
/* loaded from: classes2.dex */
public class x0 {
    public static String a(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
    }

    public static String b(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
    }

    public static String c(String str) {
        try {
            return Base64.encodeToString(str.getBytes("UTF-8"), 0);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String a(ByteArrayOutputStream byteArrayOutputStream) {
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
    }

    public static String b(String str) {
        try {
            return new String(Base64.decode(str.getBytes("UTF-8"), 0));
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static Bitmap a(String str) {
        if (str.contains("data:image/*;base64,")) {
            byte[] bArrDecode = Base64.decode(str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)[1], 0);
            return BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
        }
        byte[] bArrDecode2 = Base64.decode(str, 0);
        return BitmapFactory.decodeByteArray(bArrDecode2, 0, bArrDecode2.length);
    }

    public static String a(byte[] bArr) {
        try {
            return Base64.encodeToString(bArr, 0);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }
}
