package com.tencent.bugly.beta.global;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.core.view.ViewCompat;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.aq;
import com.tencent.bugly.proguard.p;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.File;
import java.util.Map;
import util.r1;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class a {
    public static int a(Context context) {
        NetworkInfo activeNetworkInfo;
        TelephonyManager telephonyManager;
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e2) {
            if (!an.a(e2)) {
                e2.printStackTrace();
            }
        }
        if (activeNetworkInfo == null) {
            return 0;
        }
        if (activeNetworkInfo.getType() == 1) {
            return 1;
        }
        if (activeNetworkInfo.getType() == 0 && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
            switch (telephonyManager.getNetworkType()) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return 2;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return 3;
                case 13:
                    return 4;
                default:
                    return 0;
            }
        }
        return 0;
    }

    public static String b(String str) {
        return new com.tencent.bugly.beta.utils.c(str).a();
    }

    public static String b(String str, String str2) {
        SharedPreferences sharedPreferences = e.G.C;
        return sharedPreferences != null ? sharedPreferences.getString(str, str2) : str2;
    }

    public static boolean b(String str, boolean z) {
        SharedPreferences sharedPreferences = e.G.C;
        return sharedPreferences != null ? sharedPreferences.getBoolean(str, z) : z;
    }

    public static int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static BitmapDrawable a(Bitmap bitmap, int i2, int i3, float f2) {
        DisplayMetrics displayMetrics = e.G.D;
        int i4 = (int) (displayMetrics.widthPixels * displayMetrics.heightPixels * 0.8f);
        if (bitmap == null || i2 * i3 > i4) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, i2, i3);
        RectF rectF = new RectF(rect);
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        canvas.drawRoundRect(rectF, f2, f2, paint);
        canvas.drawRect(0.0f, f2, i2, i3, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), rect, paint);
        return new BitmapDrawable(bitmapCreateBitmap);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0053 A[Catch: Exception -> 0x003a, TryCatch #0 {Exception -> 0x003a, blocks: (B:12:0x0014, B:15:0x001f, B:17:0x002e, B:26:0x004b, B:28:0x0053, B:30:0x005c, B:33:0x006d, B:50:0x00c5, B:52:0x00cd, B:55:0x00dd, B:59:0x00e9, B:51:0x00c8, B:39:0x00a2, B:36:0x0088, B:32:0x0066, B:23:0x003f), top: B:66:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00dd A[Catch: Exception -> 0x003a, TryCatch #0 {Exception -> 0x003a, blocks: (B:12:0x0014, B:15:0x001f, B:17:0x002e, B:26:0x004b, B:28:0x0053, B:30:0x005c, B:33:0x006d, B:50:0x00c5, B:52:0x00cd, B:55:0x00dd, B:59:0x00e9, B:51:0x00c8, B:39:0x00a2, B:36:0x0088, B:32:0x0066, B:23:0x003f), top: B:66:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap a(android.content.Context r18, int r19, java.lang.Object... r20) {
        /*
            Method dump skipped, instructions count: 249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.global.a.a(android.content.Context, int, java.lang.Object[]):android.graphics.Bitmap");
    }

    public static boolean a(Context context, File file, String str) {
        if (file != null) {
            try {
                if (file.exists() && file.getName().endsWith(r1.f20958d)) {
                    String strA = aq.a(file, "MD5");
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals(str.toUpperCase(), strA)) {
                        an.a("md5 error [file md5: %s] [target md5: %s]", strA, str);
                        return false;
                    }
                    Runtime.getRuntime().exec("chmod 777 " + file.getAbsolutePath());
                    Intent intent = new Intent("android.intent.action.VIEW");
                    if (Build.VERSION.SDK_INT >= 24) {
                        intent.addFlags(1);
                        if (Class.forName("androidx.core.content.FileProvider") == null) {
                            an.e("can't find class android.support.v4.content.FileProvider", new Object[0]);
                            return false;
                        }
                        Uri uri = (Uri) aq.a("androidx.core.content.FileProvider", "getUriForFile", null, new Class[]{Context.class, String.class, File.class}, new Object[]{context, com.tencent.bugly.crashreport.common.info.a.a(context).f8977d + ".fileProvider", file});
                        if (uri == null) {
                            an.e("file location is " + file.toString(), new Object[0]);
                            an.e("install failed, contentUri is null!", new Object[0]);
                            return false;
                        }
                        an.c("contentUri is " + uri, new Object[0]);
                        intent.setDataAndType(uri, "application/vnd.android.package-archive");
                    } else {
                        intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
                    }
                    intent.addFlags(CommonNetImpl.FLAG_AUTH);
                    context.startActivity(intent);
                    a("installApkMd5", strA);
                    return true;
                }
            } catch (Exception e2) {
                if (!an.b(e2)) {
                    e2.printStackTrace();
                }
            }
        }
        return false;
    }

    public static boolean a(File file, String str, String str2) throws Throwable {
        if (file != null) {
            try {
                if (file.exists()) {
                    String strA = aq.a(file, str2);
                    if (!TextUtils.isEmpty(str) && TextUtils.equals(str.toUpperCase(), strA)) {
                        return true;
                    }
                    an.a("checkFileUniqueId failed [file  uniqueId %s] [target uniqueId %s]", strA, str);
                    return false;
                }
            } catch (Exception unused) {
                an.e("checkFileUniqueId exception", new Object[0]);
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0061 A[Catch: IOException -> 0x005d, TRY_LEAVE, TryCatch #8 {IOException -> 0x005d, blocks: (B:45:0x0059, B:49:0x0061), top: B:57:0x0059 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0059 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(java.io.File r3, java.io.File r4) throws java.lang.Throwable {
        /*
            r0 = 0
            if (r3 == 0) goto L69
            r1 = 0
            boolean r2 = r3.exists()     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L46
            if (r2 == 0) goto L69
            boolean r2 = r3.isDirectory()     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L46
            if (r2 == 0) goto L12
            goto L69
        L12:
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L46
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L46
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3f
            r3.<init>(r4, r0)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3f
            r4 = 1048576(0x100000, float:1.469368E-39)
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39
        L20:
            int r1 = r2.read(r4)     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39
            if (r1 <= 0) goto L2a
            r3.write(r4, r0, r1)     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39
            goto L20
        L2a:
            r0 = 1
            r2.close()     // Catch: java.io.IOException -> L32
            r3.close()     // Catch: java.io.IOException -> L32
            goto L55
        L32:
            r3 = move-exception
            r3.printStackTrace()
            goto L55
        L37:
            r4 = move-exception
            goto L3d
        L39:
            r4 = move-exception
            goto L41
        L3b:
            r4 = move-exception
            r3 = r1
        L3d:
            r1 = r2
            goto L57
        L3f:
            r4 = move-exception
            r3 = r1
        L41:
            r1 = r2
            goto L48
        L43:
            r4 = move-exception
            r3 = r1
            goto L57
        L46:
            r4 = move-exception
            r3 = r1
        L48:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L56
            if (r1 == 0) goto L50
            r1.close()     // Catch: java.io.IOException -> L32
        L50:
            if (r3 == 0) goto L55
            r3.close()     // Catch: java.io.IOException -> L32
        L55:
            return r0
        L56:
            r4 = move-exception
        L57:
            if (r1 == 0) goto L5f
            r1.close()     // Catch: java.io.IOException -> L5d
            goto L5f
        L5d:
            r3 = move-exception
            goto L65
        L5f:
            if (r3 == 0) goto L68
            r3.close()     // Catch: java.io.IOException -> L5d
            goto L68
        L65:
            r3.printStackTrace()
        L68:
            throw r4
        L69:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.global.a.a(java.io.File, java.io.File):boolean");
    }

    public static Bitmap a(Drawable drawable) {
        Bitmap bitmapCreateBitmap;
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }
        if (drawable.getIntrinsicWidth() > 0 && drawable.getIntrinsicHeight() > 0) {
            bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        } else {
            bitmapCreateBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    public static void a(File file) {
        File[] fileArrListFiles;
        if (file == null || !file.exists() || !file.isDirectory() || (fileArrListFiles = file.listFiles()) == null || fileArrListFiles.length <= 0) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            if (!file2.delete()) {
                an.e("cannot delete file:%s", file2.getAbsolutePath());
            }
        }
    }

    public static synchronized <T extends Parcelable> boolean a(String str, T t) {
        boolean z = false;
        if (t == null) {
            return false;
        }
        byte[] bArrA = aq.a(t);
        if (bArrA != null) {
            if (p.f9423a.a(1002, str, bArrA)) {
                z = true;
            }
        }
        return z;
    }

    public static synchronized <T extends Parcelable> T a(String str, Parcelable.Creator<T> creator) {
        Map<String, byte[]> mapC = p.f9423a.c();
        if (mapC == null) {
            return null;
        }
        byte[] bArr = mapC.get(str);
        if (bArr != null && bArr.length > 0) {
            return (T) aq.a(bArr, creator);
        }
        return null;
    }

    public static synchronized boolean a(String str) {
        return p.f9423a.c(str);
    }

    public static void a(String str, String str2) {
        SharedPreferences sharedPreferences = e.G.C;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(str, str2).apply();
        }
    }

    public static void a(String str, boolean z) {
        SharedPreferences sharedPreferences = e.G.C;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(str, z).apply();
        }
    }

    public static String a(Context context, String str) throws PackageManager.NameNotFoundException {
        Object obj;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || applicationInfo.metaData == null || (obj = applicationInfo.metaData.get(str)) == null) {
                return null;
            }
            return String.valueOf(obj);
        } catch (Exception e2) {
            an.c(a.class, "getManifestMetaDataValue exception:" + e2.getMessage(), new Object[0]);
            return null;
        }
    }
}
