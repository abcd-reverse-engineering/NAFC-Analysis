package j;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.luck.picture.lib.config.PictureMimeType;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import util.f1;

/* compiled from: ImageCacheUtils.java */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static String f17003a = f1.a() + "/appiconjb";

    /* renamed from: b, reason: collision with root package name */
    public static String f17004b = f1.a() + "/appiconxs";

    /* renamed from: c, reason: collision with root package name */
    public static String f17005c = f1.a() + "/appiconAutoVirus";

    /* renamed from: d, reason: collision with root package name */
    private static String f17006d = f1.a() + "/apppic";

    /* renamed from: e, reason: collision with root package name */
    public static String f17007e = f1.a() + "/appiconxk";

    /* renamed from: f, reason: collision with root package name */
    public static String f17008f = f1.a() + "/appiconxc";

    /* compiled from: ImageCacheUtils.java */
    static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f17009a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f17010b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f17011c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Bitmap f17012d;

        a(String str, String str2, String str3, Bitmap bitmap) {
            this.f17009a = str;
            this.f17010b = str2;
            this.f17011c = str3;
            this.f17012d = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() throws IOException {
            try {
                String str = "国家反诈中心_" + this.f17009a + "_v" + this.f17010b + PictureMimeType.PNG;
                if (c.b(str, this.f17011c)) {
                    return;
                }
                File file = new File(this.f17011c, str);
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                this.f17012d.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (Exception unused) {
            }
        }
    }

    public static File b(Context context, String str) {
        try {
            return com.bumptech.glide.b.e(context).f().a(str).T().get();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static File a(Context context, String str) {
        try {
            return com.bumptech.glide.b.e(context).a(str).b(Integer.MIN_VALUE, Integer.MIN_VALUE).get();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Drawable b(String str, String str2, String str3) {
        return new BitmapDrawable(a(str, str2, str3));
    }

    public static Bitmap a(Drawable drawable) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(String str, String str2) {
        File file = new File(str2);
        if (file.exists() && file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                if (TextUtils.equals(file2.getName(), str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void a(Bitmap bitmap, String str, String str2, String str3) {
        new Thread(new a(str, str2, str3, bitmap)).start();
    }

    public static String b(String str) {
        return new File(f17006d, str).getAbsolutePath();
    }

    public static Bitmap a(String str, String str2, String str3) {
        try {
            File file = new File(str3, "国家反诈中心_" + str + "_v" + str2 + PictureMimeType.PNG);
            if (file.exists()) {
                return BitmapFactory.decodeStream(new FileInputStream(file));
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static void a(String str) {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                file2.delete();
            }
        }
    }

    public static void a(Context context, String str, String str2) throws Throwable {
        File file;
        try {
            file = com.bumptech.glide.b.e(context).a(str).b(90, 90).get();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
            file = null;
            a(file, new File(f17006d, str2));
        } catch (ExecutionException e3) {
            e3.printStackTrace();
            file = null;
            a(file, new File(f17006d, str2));
        }
        a(file, new File(f17006d, str2));
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0052 A[Catch: IOException -> 0x004e, TRY_LEAVE, TryCatch #7 {IOException -> 0x004e, blocks: (B:39:0x004a, B:43:0x0052), top: B:50:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x004a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(java.io.File r2, java.io.File r3) throws java.lang.Throwable {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2f
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2f
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L27
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L27
            r3 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r3]     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L22
        Lf:
            int r0 = r1.read(r3)     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L22
            if (r0 <= 0) goto L19
            r2.write(r3)     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L22
            goto Lf
        L19:
            r1.close()     // Catch: java.io.IOException -> L3a
            r2.close()     // Catch: java.io.IOException -> L3a
            goto L45
        L20:
            r3 = move-exception
            goto L48
        L22:
            r3 = move-exception
            goto L29
        L24:
            r3 = move-exception
            r2 = r0
            goto L48
        L27:
            r3 = move-exception
            r2 = r0
        L29:
            r0 = r1
            goto L31
        L2b:
            r3 = move-exception
            r2 = r0
            r1 = r2
            goto L48
        L2f:
            r3 = move-exception
            r2 = r0
        L31:
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L46
            if (r0 == 0) goto L3c
            r0.close()     // Catch: java.io.IOException -> L3a
            goto L3c
        L3a:
            r2 = move-exception
            goto L42
        L3c:
            if (r2 == 0) goto L45
            r2.close()     // Catch: java.io.IOException -> L3a
            goto L45
        L42:
            r2.printStackTrace()
        L45:
            return
        L46:
            r3 = move-exception
            r1 = r0
        L48:
            if (r1 == 0) goto L50
            r1.close()     // Catch: java.io.IOException -> L4e
            goto L50
        L4e:
            r2 = move-exception
            goto L56
        L50:
            if (r2 == 0) goto L59
            r2.close()     // Catch: java.io.IOException -> L4e
            goto L59
        L56:
            r2.printStackTrace()
        L59:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: j.c.a(java.io.File, java.io.File):void");
    }
}
