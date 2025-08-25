package cn.cloudwalk.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import androidx.core.view.ViewCompat;
import cn.cloudwalk.jni.FaceLivingImg;
import com.xiaomi.mipush.sdk.Constants;
import h.f1;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class IOUtils {
    public static byte[] bitmapToByte(Bitmap bitmap, Bitmap.CompressFormat compressFormat) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (bitmap == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(compressFormat, 80, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        TestLog.netE("2222", "bitmapToByte" + (System.currentTimeMillis() - jCurrentTimeMillis));
        return byteArray;
    }

    public static Bitmap byteArrayBGRToBitmap(byte[] bArr, int i2, int i3) {
        if (bArr == null) {
            return null;
        }
        int i4 = i2 * i3;
        int[] iArr = new int[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = i5 * 3;
            int i7 = bArr[i6] & f1.f16099c;
            int i8 = bArr[i6 + 1] & f1.f16099c;
            int i9 = bArr[i6 + 2] & f1.f16099c;
            if (i7 < 0) {
                i7 = 0;
            } else if (i7 > 255) {
                i7 = 255;
            }
            if (i8 < 0) {
                i8 = 0;
            } else if (i8 > 255) {
                i8 = 255;
            }
            if (i9 < 0) {
                i9 = 0;
            } else if (i9 > 255) {
                i9 = 255;
            }
            iArr[i5] = (i9 << 16) + ViewCompat.MEASURED_STATE_MASK + (i8 << 8) + i7;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.setPixels(iArr, 0, i2, 0, 0, i2, i3);
        return bitmapCreateBitmap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v12, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.io.FileOutputStream, java.io.OutputStream] */
    public static boolean copyAssetsToDest(Context context, String str, String str2) throws Throwable {
        boolean z;
        ?? r1 = 0;
        r1 = 0;
        r1 = 0;
        r1 = 0;
        r1 = 0;
        boolean z2 = false;
        try {
        } catch (IOException e2) {
            context = e2.getMessage();
            LogUtils.LOGE(LogUtils.LOG_EXCEPTION, context);
        }
        try {
            try {
                context = context.getAssets().open(str);
                try {
                    ?? fileOutputStream = new FileOutputStream(str2);
                    try {
                        byte[] bArr = new byte[1024];
                        r1 = context.read(bArr);
                        while (r1 > 0) {
                            fileOutputStream.write(bArr, 0, r1);
                            r1 = context.read(bArr);
                        }
                        try {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                            z = true;
                        } catch (IOException e3) {
                            LogUtils.LOGE(LogUtils.LOG_EXCEPTION, e3.getMessage());
                            z = false;
                        }
                        if (context != 0) {
                            context.close();
                        }
                        z2 = z;
                    } catch (IOException e4) {
                        e = e4;
                        r1 = fileOutputStream;
                        LogUtils.LOGE(LogUtils.LOG_EXCEPTION, e.getMessage());
                        if (r1 != 0) {
                            try {
                                r1.flush();
                                r1.close();
                            } catch (IOException e5) {
                                LogUtils.LOGE(LogUtils.LOG_EXCEPTION, e5.getMessage());
                            }
                        }
                        if (context != 0) {
                            context.close();
                        }
                        return z2;
                    } catch (Throwable th) {
                        th = th;
                        r1 = fileOutputStream;
                        if (r1 != 0) {
                            try {
                                r1.flush();
                                r1.close();
                            } catch (IOException e6) {
                                LogUtils.LOGE(LogUtils.LOG_EXCEPTION, e6.getMessage());
                            }
                        }
                        if (context == 0) {
                            throw th;
                        }
                        try {
                            context.close();
                            throw th;
                        } catch (IOException e7) {
                            LogUtils.LOGE(LogUtils.LOG_EXCEPTION, e7.getMessage());
                            throw th;
                        }
                    }
                } catch (IOException e8) {
                    e = e8;
                }
            } catch (IOException e9) {
                e = e9;
                context = 0;
            } catch (Throwable th2) {
                th = th2;
                context = 0;
            }
            return z2;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static String cwGetFaceLivingImgInfo(FaceLivingImg faceLivingImg) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (faceLivingImg == null || faceLivingImg.pointX == null || faceLivingImg.pointY == null) {
            return "";
        }
        int i2 = 0;
        while (true) {
            float[] fArr = faceLivingImg.pointX;
            if (i2 >= fArr.length) {
                return sb.toString() + sb2.toString() + faceLivingImg.keyptScore + Constants.ACCEPT_TIME_SEPARATOR_SP + faceLivingImg.pitch + Constants.ACCEPT_TIME_SEPARATOR_SP + faceLivingImg.yaw + Constants.ACCEPT_TIME_SEPARATOR_SP + faceLivingImg.roll;
            }
            if (i2 < faceLivingImg.pointY.length) {
                sb.append(fArr[i2]);
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb2.append(faceLivingImg.pointY[i2]);
                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            i2++;
        }
    }

    public static boolean deleteFile(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }

    public static boolean isFileExist(String str) {
        return new File(str).exists();
    }

    public static void recycleBitmap(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        bitmap.recycle();
    }

    public static Bitmap rotaingImageView(Bitmap bitmap, int i2, int i3) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Matrix matrix = new Matrix();
        if (i3 == 1) {
            matrix.postScale(-1.0f, 1.0f);
            if (i2 == 1) {
                matrix.postRotate(270.0f);
            }
            if (i2 == 2) {
                matrix.postRotate(180.0f);
            }
            if (i2 == 3) {
                matrix.postRotate(90.0f);
            }
        } else {
            if (i2 == 1) {
                matrix.postRotate(270.0f);
            }
            if (i2 == 2) {
                matrix.postRotate(180.0f);
            }
            if (i2 == 3) {
                matrix.postRotate(90.0f);
            }
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        TestLog.netE("2222", "rotaingImageView" + (System.currentTimeMillis() - jCurrentTimeMillis));
        return bitmapCreateBitmap;
    }

    public static Bitmap yuv2Img(byte[] bArr, int i2, int i3, int i4, int i5) throws IOException {
        Long lValueOf = Long.valueOf(System.currentTimeMillis());
        Bitmap bitmapDecodeByteArray = null;
        try {
            YuvImage yuvImage = new YuvImage(bArr, i2, i3, i4, null);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            yuvImage.compressToJpeg(new Rect(0, 0, i3, i4), i5, byteArrayOutputStream);
            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
            byteArrayOutputStream.close();
        } catch (IOException e2) {
            TestLog.netE("ContentValues", "yuv2Img异常:" + e2.getMessage());
        }
        TestLog.netE("ContentValues", "yuv2Img" + (System.currentTimeMillis() - lValueOf.longValue()));
        return bitmapDecodeByteArray;
    }
}
