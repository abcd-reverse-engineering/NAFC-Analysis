package com.luck.picture.lib.tools;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.hardware.Camera;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.media.ExifInterface;
import android.net.Uri;
import androidx.annotation.RequiresApi;
import com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class BitmapUtils {
    public static Bitmap compressMatrix(Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.setScale(0.5f, 0.5f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static Bitmap compressQuality(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
    }

    private void compressSampling() {
        new BitmapFactory.Options().inSampleSize = 2;
    }

    public static Bitmap crompBitmap(Bitmap bitmap) {
        return Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() / 2, bitmap.getHeight() / 2, true);
    }

    private Bitmap cropBitmap(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width < height) {
            height = width;
        }
        int i2 = height / 2;
        return Bitmap.createBitmap(bitmap, width / 3, 0, i2, (int) (i2 / 1.2d), (Matrix) null, false);
    }

    private static int exifInterfaceDegree(ExifInterface exifInterface) {
        int attributeInt = exifInterface.getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
        if (attributeInt == 3) {
            return 180;
        }
        if (attributeInt == 6) {
            return 90;
        }
        if (attributeInt != 8) {
            return 0;
        }
        return SubsamplingScaleImageView.ORIENTATION_270;
    }

    @RequiresApi(api = 21)
    public static Bitmap getCameraMap(Activity activity, Bitmap bitmap, int i2) {
        Bitmap bitmapRotateBitmap;
        if (bitmap.getWidth() <= bitmap.getHeight()) {
            return getCameraOrientation(activity, i2) ? mirrorBitmap(bitmap, 1) : mirrorBitmap(bitmap, -1);
        }
        try {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i2, cameraInfo);
            bitmapRotateBitmap = rotateBitmap(cameraInfo.orientation, bitmap);
            if (bitmapRotateBitmap == null) {
                bitmapRotateBitmap = bitmap;
            }
        } catch (Exception unused) {
            bitmapRotateBitmap = rotateBitmap(SubsamplingScaleImageView.ORIENTATION_270, bitmap);
        }
        return mirrorBitmap(bitmapRotateBitmap, -1);
    }

    @RequiresApi(api = 21)
    public static boolean getCameraOrientation(Activity activity, int i2) throws CameraAccessException {
        CameraCharacteristics cameraCharacteristics;
        try {
            cameraCharacteristics = ((CameraManager) activity.getSystemService("camera")).getCameraCharacteristics(i2 + "");
        } catch (CameraAccessException e2) {
            e2.printStackTrace();
            cameraCharacteristics = null;
        }
        return (cameraCharacteristics != null ? (Integer) cameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL) : 0).intValue() == 2;
    }

    public static int getRotationAngle(int i2) {
        if (i2 == 1) {
            return 0;
        }
        if (i2 == 3) {
            return 180;
        }
        if (i2 == 6) {
            return 90;
        }
        if (i2 != 8) {
            return 0;
        }
        return SubsamplingScaleImageView.ORIENTATION_270;
    }

    public static Bitmap mirrorBitmap(Bitmap bitmap, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(i2, -i2);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public static int readPictureDegree(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt == 6) {
                return 90;
            }
            if (attributeInt != 8) {
                return 0;
            }
            return SubsamplingScaleImageView.ORIENTATION_270;
        } catch (IOException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int readTruePathDegree(String str) {
        try {
            return exifInterfaceDegree(new ExifInterface(str));
        } catch (IOException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static Bitmap rotaingImageView(int i2, Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.postRotate(i2);
        System.out.println("angle2=" + i2);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static Bitmap rotateBitmap(int i2, Bitmap bitmap) {
        return rotateBitmap(i2, 0, bitmap);
    }

    public static void rotateImage(int i2, String str) {
        if (i2 > 0) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 2;
                File file = new File(str);
                Bitmap bitmapRotatingImage = rotatingImage(BitmapFactory.decodeFile(file.getAbsolutePath(), options), i2);
                if (bitmapRotatingImage != null) {
                    saveBitmapFile(bitmapRotatingImage, file);
                    bitmapRotatingImage.recycle();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static Bitmap rotatingImage(Bitmap bitmap, int i2) {
        Matrix matrix = new Matrix();
        matrix.postRotate(i2);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static void saveBitmapFile(Bitmap bitmap, File file) throws IOException {
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bufferedOutputStream);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private Bitmap scaleBitmap(Bitmap bitmap, int i2, int i3) {
        if (bitmap == null) {
            return null;
        }
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();
        Matrix matrix = new Matrix();
        matrix.postScale(i2 / width, i3 / height);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        if (!bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    public static Bitmap showProtraitBitmap(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i2 = (height - width) / 2;
        return Bitmap.createBitmap(bitmap, 0, i2, width, height - (i2 * 2));
    }

    public static Bitmap rotateBitmap(int i2, int i3, Bitmap bitmap) {
        if (bitmap == null) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.setRotate(i2);
        if (i3 != 0) {
            matrix.postScale(-i3, i3);
        }
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public static Bitmap crompBitmap(Bitmap bitmap, int i2, int i3) {
        return Bitmap.createScaledBitmap(bitmap, i2, i3, true);
    }

    public static int readPictureDegree(Context context, String str) {
        ExifInterface exifInterface;
        try {
            if (SdkVersionUtils.checkedAndroid_Q()) {
                exifInterface = new ExifInterface(context.getContentResolver().openFileDescriptor(Uri.parse(str), "r").getFileDescriptor());
            } else {
                exifInterface = new ExifInterface(str);
            }
            return exifInterfaceDegree(exifInterface);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    private Bitmap scaleBitmap(Bitmap bitmap, float f2) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.preScale(f2, f2);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        if (bitmapCreateBitmap.equals(bitmap)) {
            return bitmapCreateBitmap;
        }
        bitmap.recycle();
        return bitmapCreateBitmap;
    }
}
