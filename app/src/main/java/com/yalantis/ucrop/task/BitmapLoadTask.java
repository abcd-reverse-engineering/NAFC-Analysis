package com.yalantis.ucrop.task;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import anet.channel.util.HttpConstant;
import com.yalantis.ucrop.callback.BitmapLoadCallback;
import com.yalantis.ucrop.model.ExifInfo;
import com.yalantis.ucrop.util.BitmapLoadUtils;
import com.yalantis.ucrop.util.FileUtils;
import com.yalantis.ucrop.util.MimeType;
import com.yalantis.ucrop.util.SdkUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URL;
import util.permissionutil.a;

/* loaded from: classes2.dex */
public class BitmapLoadTask extends AsyncTask<Void, Void, BitmapWorkerResult> {
    private static final String TAG = "BitmapWorkerTask";
    private final BitmapLoadCallback mBitmapLoadCallback;
    private WeakReference<Context> mContextWeakReference;
    private Uri mInputUri;
    private Uri mOutputUri;
    private final int mRequiredHeight;
    private final int mRequiredWidth;

    public BitmapLoadTask(@NonNull Context context, @NonNull Uri uri, @Nullable Uri uri2, int i2, int i3, BitmapLoadCallback bitmapLoadCallback) {
        this.mContextWeakReference = new WeakReference<>(context);
        this.mInputUri = uri;
        this.mOutputUri = uri2;
        this.mRequiredWidth = i2;
        this.mRequiredHeight = i3;
        this.mBitmapLoadCallback = bitmapLoadCallback;
    }

    private void copyFile(@NonNull Uri uri, @Nullable Uri uri2) throws Throwable {
        InputStream inputStreamOpenInputStream;
        if (uri2 == null) {
            throw new NullPointerException("Output Uri is null - cannot copy image");
        }
        FileOutputStream fileOutputStream = null;
        try {
            inputStreamOpenInputStream = getContext().getContentResolver().openInputStream(uri);
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(new File(uri2.getPath()));
                try {
                    if (inputStreamOpenInputStream == null) {
                        throw new NullPointerException("InputStream for given input Uri is null");
                    }
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i2 = inputStreamOpenInputStream.read(bArr);
                        if (i2 <= 0) {
                            BitmapLoadUtils.close(fileOutputStream2);
                            BitmapLoadUtils.close(inputStreamOpenInputStream);
                            this.mInputUri = this.mOutputUri;
                            return;
                        }
                        fileOutputStream2.write(bArr, 0, i2);
                    }
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    BitmapLoadUtils.close(fileOutputStream);
                    BitmapLoadUtils.close(inputStreamOpenInputStream);
                    this.mInputUri = this.mOutputUri;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStreamOpenInputStream = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r6v9 */
    private void downloadFile(@NonNull Uri uri, @Nullable Uri uri2) throws Throwable {
        BufferedInputStream bufferedInputStream;
        byte[] bArr;
        if (uri2 == 0) {
            throw new NullPointerException("Output Uri is null - cannot download image");
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                URL url = new URL(uri.toString());
                bArr = new byte[1024];
                bufferedInputStream = new BufferedInputStream(url.openStream());
                try {
                    uri2 = getContext().getContentResolver().openOutputStream(uri2);
                } catch (Exception e2) {
                    e = e2;
                    uri2 = 0;
                } catch (Throwable th) {
                    th = th;
                    uri2 = 0;
                }
            } catch (Exception e3) {
                e = e3;
                uri2 = 0;
                bufferedInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                uri2 = 0;
                bufferedInputStream = null;
            }
            if (uri2 != 0) {
                try {
                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(uri2);
                    while (true) {
                        try {
                            int i2 = bufferedInputStream.read(bArr);
                            if (i2 <= -1) {
                                break;
                            } else {
                                bufferedOutputStream2.write(bArr, 0, i2);
                            }
                        } catch (Exception e4) {
                            e = e4;
                            bufferedOutputStream = bufferedOutputStream2;
                            e.printStackTrace();
                            uri2 = uri2;
                            this.mInputUri = this.mOutputUri;
                            BitmapLoadUtils.close(bufferedOutputStream);
                            BitmapLoadUtils.close(bufferedInputStream);
                            BitmapLoadUtils.close(uri2);
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedOutputStream = bufferedOutputStream2;
                            this.mInputUri = this.mOutputUri;
                            BitmapLoadUtils.close(bufferedOutputStream);
                            BitmapLoadUtils.close(bufferedInputStream);
                            BitmapLoadUtils.close(uri2);
                            throw th;
                        }
                    }
                    bufferedOutputStream2.flush();
                    bufferedOutputStream = bufferedOutputStream2;
                    uri2 = uri2;
                } catch (Exception e5) {
                    e = e5;
                }
            }
            this.mInputUri = this.mOutputUri;
            BitmapLoadUtils.close(bufferedOutputStream);
            BitmapLoadUtils.close(bufferedInputStream);
            BitmapLoadUtils.close(uri2);
        } catch (Throwable th4) {
            th = th4;
        }
    }

    private Context getContext() {
        return this.mContextWeakReference.get();
    }

    private String getFilePath() {
        if (ContextCompat.checkSelfPermission(getContext(), a.z) == 0) {
            return FileUtils.getPath(getContext(), this.mInputUri);
        }
        return null;
    }

    private void processInputUri() throws IOException, NullPointerException {
        String scheme = this.mInputUri.getScheme();
        String str = "Uri scheme: " + scheme;
        if (HttpConstant.HTTP.equals(scheme) || HttpConstant.HTTPS.equals(scheme)) {
            try {
                downloadFile(this.mInputUri, this.mOutputUri);
                return;
            } catch (IOException | NullPointerException e2) {
                throw e2;
            }
        }
        if ("content".equals(scheme)) {
            String filePath = getFilePath();
            if (!TextUtils.isEmpty(filePath) && new File(filePath).exists()) {
                this.mInputUri = SdkUtils.isQ() ? this.mInputUri : Uri.fromFile(new File(filePath));
                return;
            }
            try {
                copyFile(this.mInputUri, this.mOutputUri);
                return;
            } catch (IOException | NullPointerException e3) {
                throw e3;
            }
        }
        if ("file".equals(scheme)) {
            return;
        }
        String str2 = "Invalid Uri scheme " + scheme;
        throw new IllegalArgumentException("Invalid Uri scheme" + scheme);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    @NonNull
    public BitmapWorkerResult doInBackground(Void... voidArr) throws IOException {
        if (this.mInputUri == null) {
            return new BitmapWorkerResult(new NullPointerException("Input Uri cannot be null"));
        }
        try {
            processInputUri();
            try {
                ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = getContext().getContentResolver().openFileDescriptor(this.mInputUri, "r");
                if (parcelFileDescriptorOpenFileDescriptor == null) {
                    return new BitmapWorkerResult(new NullPointerException("ParcelFileDescriptor was null for given Uri: [" + this.mInputUri + "]"));
                }
                FileDescriptor fileDescriptor = parcelFileDescriptorOpenFileDescriptor.getFileDescriptor();
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
                if (options.outWidth == -1 || options.outHeight == -1) {
                    return new BitmapWorkerResult(new IllegalArgumentException("Bounds for bitmap could not be retrieved from the Uri: [" + this.mInputUri + "]"));
                }
                options.inSampleSize = BitmapLoadUtils.calculateInSampleSize(options, this.mRequiredWidth, this.mRequiredHeight);
                boolean z = false;
                options.inJustDecodeBounds = false;
                Bitmap bitmapDecodeFileDescriptor = null;
                while (!z) {
                    try {
                        bitmapDecodeFileDescriptor = BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
                        z = true;
                    } catch (OutOfMemoryError unused) {
                        options.inSampleSize *= 2;
                    }
                }
                if (bitmapDecodeFileDescriptor == null) {
                    return new BitmapWorkerResult(new IllegalArgumentException("Bitmap could not be decoded from the Uri: [" + this.mInputUri + "]"));
                }
                if (Build.VERSION.SDK_INT >= 16) {
                    BitmapLoadUtils.close(parcelFileDescriptorOpenFileDescriptor);
                }
                int exifOrientation = BitmapLoadUtils.getExifOrientation(getContext(), this.mInputUri);
                int iExifToDegrees = BitmapLoadUtils.exifToDegrees(exifOrientation);
                int iExifToTranslation = BitmapLoadUtils.exifToTranslation(exifOrientation);
                ExifInfo exifInfo = new ExifInfo(exifOrientation, iExifToDegrees, iExifToTranslation);
                Matrix matrix = new Matrix();
                if (iExifToDegrees != 0) {
                    matrix.preRotate(iExifToDegrees);
                }
                if (iExifToTranslation != 1) {
                    matrix.postScale(iExifToTranslation, 1.0f);
                }
                return !matrix.isIdentity() ? new BitmapWorkerResult(BitmapLoadUtils.transformBitmap(bitmapDecodeFileDescriptor, matrix), exifInfo) : new BitmapWorkerResult(bitmapDecodeFileDescriptor, exifInfo);
            } catch (FileNotFoundException e2) {
                return new BitmapWorkerResult(e2);
            }
        } catch (IOException | NullPointerException e3) {
            return new BitmapWorkerResult(e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(@NonNull BitmapWorkerResult bitmapWorkerResult) {
        Exception exc = bitmapWorkerResult.mBitmapWorkerException;
        if (exc != null) {
            this.mBitmapLoadCallback.onFailure(exc);
            return;
        }
        String string = this.mInputUri.toString();
        BitmapLoadCallback bitmapLoadCallback = this.mBitmapLoadCallback;
        Bitmap bitmap = bitmapWorkerResult.mBitmapResult;
        ExifInfo exifInfo = bitmapWorkerResult.mExifInfo;
        if (!MimeType.isContent(string)) {
            string = this.mInputUri.getPath();
        }
        Uri uri = this.mOutputUri;
        bitmapLoadCallback.onBitmapLoaded(bitmap, exifInfo, string, uri == null ? null : uri.getPath());
    }

    public static class BitmapWorkerResult {
        Bitmap mBitmapResult;
        Exception mBitmapWorkerException;
        ExifInfo mExifInfo;

        public BitmapWorkerResult(@NonNull Bitmap bitmap, @NonNull ExifInfo exifInfo) {
            this.mBitmapResult = bitmap;
            this.mExifInfo = exifInfo;
        }

        public BitmapWorkerResult(@NonNull Exception exc) {
            this.mBitmapWorkerException = exc;
        }
    }
}
