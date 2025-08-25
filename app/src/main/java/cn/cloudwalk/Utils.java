package cn.cloudwalk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import androidx.core.view.ViewCompat;
import c.c.a.b.a.a;
import cn.cloudwalk.jni.FaceLivingImg;
import com.xiaomi.mipush.sdk.Constants;
import h.f1;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* loaded from: classes.dex */
public class Utils {
    public static void assetsDataToDest(Context context, String str, String str2) throws IOException {
        InputStream inputStreamOpen = context.getAssets().open(str);
        FileOutputStream fileOutputStream = new FileOutputStream(str2);
        byte[] bArr = new byte[1024];
        for (int i2 = inputStreamOpen.read(bArr); i2 > 0; i2 = inputStreamOpen.read(bArr)) {
            fileOutputStream.write(bArr, 0, i2);
        }
        fileOutputStream.flush();
        inputStreamOpen.close();
        fileOutputStream.close();
    }

    static byte[] bitmapToByte(Bitmap bitmap, Bitmap.CompressFormat compressFormat) {
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

    static Bitmap byteArrayBGRToBitmap(byte[] bArr, int i2, int i3) {
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

    public static void copyAssetsToDest(Context context, String str, String str2) throws IOException {
        InputStream inputStreamOpen = context.getAssets().open(str);
        FileOutputStream fileOutputStream = new FileOutputStream(str2);
        byte[] bArr = new byte[1024];
        for (int i2 = inputStreamOpen.read(bArr); i2 > 0; i2 = inputStreamOpen.read(bArr)) {
            fileOutputStream.write(bArr, 0, i2);
        }
        fileOutputStream.flush();
        inputStreamOpen.close();
        fileOutputStream.close();
    }

    static String cwGetFaceLivingImgInfo(FaceLivingImg faceLivingImg) {
        String str = "";
        if (faceLivingImg == null || faceLivingImg.pointX == null || faceLivingImg.pointY == null) {
            return "";
        }
        String str2 = "";
        for (int i2 = 0; i2 < faceLivingImg.pointX.length; i2++) {
            if (i2 < faceLivingImg.pointY.length) {
                str = str + faceLivingImg.pointX[i2] + Constants.ACCEPT_TIME_SEPARATOR_SP;
                str2 = str2 + faceLivingImg.pointY[i2] + Constants.ACCEPT_TIME_SEPARATOR_SP;
            }
        }
        return str + str2 + faceLivingImg.keyptScore + Constants.ACCEPT_TIME_SEPARATOR_SP + faceLivingImg.pitch + Constants.ACCEPT_TIME_SEPARATOR_SP + faceLivingImg.yaw + Constants.ACCEPT_TIME_SEPARATOR_SP + faceLivingImg.roll;
    }

    public static boolean deleteFile(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }

    public static String getExtensionNameWithDot(String str) {
        int iLastIndexOf;
        return (str == null || str.length() <= 0 || (iLastIndexOf = str.lastIndexOf(46)) <= -1 || iLastIndexOf >= str.length() + (-1)) ? str : str.substring(iLastIndexOf);
    }

    public static float getFloatVal(Object obj, float f2) {
        if (obj == null) {
            return f2;
        }
        try {
            return Float.valueOf(obj.toString()).floatValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return f2;
        }
    }

    public static int getIntVal(Object obj, int i2) {
        if (obj == null) {
            return i2;
        }
        try {
            return Integer.valueOf(obj.toString()).intValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return i2;
        }
    }

    public static boolean isEmpty(String str) {
        return str == null || "".equals(str) || a.f3101h.equals(str) || "unknown".equals(str);
    }

    public static boolean isFileExist(String str) {
        return new File(str).exists();
    }

    static void recycleBitmap(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        bitmap.recycle();
    }

    static Bitmap rotaingImageView(Bitmap bitmap, int i2, int i3) {
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

    public static byte[] rotateNV21Degree90(byte[] bArr, int i2, int i3) {
        int i4 = i2 * i3;
        int i5 = i4 * 3;
        byte[] bArr2 = new byte[i5 / 2];
        int i6 = 0;
        for (int i7 = 0; i7 < i2; i7++) {
            for (int i8 = i3 - 1; i8 >= 0; i8--) {
                try {
                    bArr2[i6] = bArr[(i8 * i2) + i7];
                    i6++;
                } catch (Exception unused) {
                }
            }
        }
        int i9 = (i5 / 2) - 1;
        int i10 = i2 - 1;
        while (i10 > 0) {
            int i11 = i9;
            for (int i12 = 0; i12 < i3 / 2; i12++) {
                int i13 = (i12 * i2) + i4;
                bArr2[i11] = bArr[i13 + i10];
                int i14 = i11 - 1;
                bArr2[i14] = bArr[i13 + (i10 - 1)];
                i11 = i14 - 1;
            }
            i10 -= 2;
            i9 = i11;
        }
        return bArr2;
    }

    static void saveJPGE_After(Bitmap bitmap, String str, int i2) throws IOException {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(str));
            if (bitmap.compress(Bitmap.CompressFormat.JPEG, i2, fileOutputStream)) {
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    public static void unZipModelFolder(String str, String str2) throws Exception {
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(str));
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                zipInputStream.close();
                return;
            }
            String name = nextEntry.getName();
            if (!name.contains("../")) {
                if (nextEntry.isDirectory()) {
                    new File(str2 + File.separator + name.substring(0, name.length() - 1)).mkdirs();
                } else if (getExtensionNameWithDot(name).equals(".bin") || getExtensionNameWithDot(name).equals(".mdl") || getExtensionNameWithDot(name).equals(".txt")) {
                    File file = new File(str2 + File.separator + name);
                    file.createNewFile();
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i2 = zipInputStream.read(bArr);
                        if (i2 == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, i2);
                        fileOutputStream.flush();
                    }
                    fileOutputStream.close();
                }
            }
        }
    }

    static Bitmap yuv2Img(byte[] bArr, int i2, int i3, int i4, int i5) throws IOException {
        Long lValueOf = Long.valueOf(System.currentTimeMillis());
        Bitmap bitmapDecodeByteArray = null;
        try {
            YuvImage yuvImage = new YuvImage(bArr, i2, i3, i4, null);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            yuvImage.compressToJpeg(new Rect(0, 0, i3, i4), i5, byteArrayOutputStream);
            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
            byteArrayOutputStream.close();
        } catch (Exception e2) {
            TestLog.netE("ContentValues", "yuv2Img异常:" + e2.getMessage());
        }
        TestLog.netE("ContentValues", "yuv2Img" + (System.currentTimeMillis() - lValueOf.longValue()));
        return bitmapDecodeByteArray;
    }
}
