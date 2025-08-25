package cn.cloudwalk.libproject.util;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import com.umeng.analytics.pro.cw;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
public class Util {
    public static final String AppName = "FaceRecog";
    public static boolean DEBUG = true;
    public static final String FACE_THRESHOLD = "0";
    private static final String TAG = "Util";

    public static final String MD5(String str) throws NoSuchAlgorithmException {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            byte[] bytes = str.getBytes();
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bytes);
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
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String bytes2kb(long j2) {
        BigDecimal bigDecimal = new BigDecimal(j2);
        float fFloatValue = bigDecimal.divide(new BigDecimal(1048576), 2, 0).floatValue();
        if (fFloatValue > 1.0f) {
            return fFloatValue + "MB";
        }
        return bigDecimal.divide(new BigDecimal(1024), 2, 0).floatValue() + "KB";
    }

    public static String getBeBetweenTime(long j2) {
        long jCurrentTimeMillis = (System.currentTimeMillis() - j2) / 1000;
        int i2 = (int) (jCurrentTimeMillis % 60);
        long j3 = jCurrentTimeMillis / 60;
        return (j3 / 60) + Constants.COLON_SEPARATOR + String.format("%02d", Integer.valueOf((int) (j3 % 60))) + Constants.COLON_SEPARATOR + String.format("%02d", Integer.valueOf(i2));
    }

    public static byte[] getBytesFromStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int i2 = inputStream.read(bArr, 0, 1024);
            if (i2 == -1) {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            }
            byteArrayOutputStream.write(bArr, 0, i2);
            byteArrayOutputStream.flush();
        }
    }

    public static String getDiskCacheDir(Context context) {
        String path = (Build.VERSION.SDK_INT >= 29 || (!"mounted".equals(Environment.getExternalStorageState()) && Environment.isExternalStorageRemovable())) ? null : context.getExternalCacheDir().getPath();
        return path == null ? context.getCacheDir().getPath() : path;
    }

    public static String getPackageFileBaseDir(Context context) {
        return Build.VERSION.SDK_INT < 29 ? Environment.getExternalStorageDirectory().getAbsolutePath() : context.getExternalFilesDir(Environment.DIRECTORY_PICTURES).getPath();
    }

    public static int getStatusBarHeight(Context context) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NumberFormatException {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e2) {
            e2.printStackTrace();
            return 40;
        }
    }

    public static String getTimeStamp() {
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    }

    public static boolean isChineseLanguage() {
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        locale.getCountry().toLowerCase();
        return "zh".equals(language);
    }

    public static boolean isScreenPortrait(Context context) {
        int i2 = context.getResources().getConfiguration().orientation;
        if (i2 == 2) {
            return false;
        }
        if (i2 == 1) {
        }
        return true;
    }

    public static byte[] readInputStream(InputStream inputStream) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int i2 = inputStream.read(bArr);
            if (i2 == -1) {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                inputStream.close();
                return byteArray;
            }
            byteArrayOutputStream.write(bArr, 0, i2);
        }
    }
}
