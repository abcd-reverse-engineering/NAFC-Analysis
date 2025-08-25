package androidx.camera.core;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class ImageSaver implements Runnable {
    private static final int COPY_BUFFER_SIZE = 1024;
    private static final int NOT_PENDING = 0;
    private static final int PENDING = 1;
    private static final String TAG = "ImageSaver";
    private static final String TEMP_FILE_PREFIX = "CameraX";
    private static final String TEMP_FILE_SUFFIX = ".tmp";
    final OnImageSavedCallback mCallback;
    private final Executor mExecutor;
    private final ImageProxy mImage;
    private final int mOrientation;

    @NonNull
    private final ImageCapture.OutputFileOptions mOutputFileOptions;

    /* renamed from: androidx.camera.core.ImageSaver$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$core$ImageUtil$CodecFailedException$FailureType = new int[ImageUtil.CodecFailedException.FailureType.values().length];

        static {
            try {
                $SwitchMap$androidx$camera$core$ImageUtil$CodecFailedException$FailureType[ImageUtil.CodecFailedException.FailureType.ENCODE_FAILED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$camera$core$ImageUtil$CodecFailedException$FailureType[ImageUtil.CodecFailedException.FailureType.DECODE_FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$camera$core$ImageUtil$CodecFailedException$FailureType[ImageUtil.CodecFailedException.FailureType.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public interface OnImageSavedCallback {
        void onError(SaveError saveError, String str, @Nullable Throwable th);

        void onImageSaved(@NonNull ImageCapture.OutputFileResults outputFileResults);
    }

    public enum SaveError {
        FILE_IO_FAILED,
        ENCODE_FAILED,
        CROP_FAILED,
        UNKNOWN
    }

    ImageSaver(ImageProxy imageProxy, @NonNull ImageCapture.OutputFileOptions outputFileOptions, int i2, Executor executor, OnImageSavedCallback onImageSavedCallback) {
        this.mImage = imageProxy;
        this.mOutputFileOptions = outputFileOptions;
        this.mOrientation = i2;
        this.mCallback = onImageSavedCallback;
        this.mExecutor = executor;
    }

    private void copyTempFileToOutputStream(@NonNull File file, @NonNull OutputStream outputStream) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i2 = fileInputStream.read(bArr);
                if (i2 <= 0) {
                    fileInputStream.close();
                    return;
                }
                outputStream.write(bArr, 0, i2);
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    fileInputStream.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    private boolean copyTempFileToUri(@NonNull File file, @NonNull Uri uri) throws IOException {
        OutputStream outputStreamOpenOutputStream = this.mOutputFileOptions.getContentResolver().openOutputStream(uri);
        if (outputStreamOpenOutputStream == null) {
            if (outputStreamOpenOutputStream != null) {
                outputStreamOpenOutputStream.close();
            }
            return false;
        }
        try {
            copyTempFileToOutputStream(file, outputStreamOpenOutputStream);
            if (outputStreamOpenOutputStream == null) {
                return true;
            }
            outputStreamOpenOutputStream.close();
            return true;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (outputStreamOpenOutputStream != null) {
                    try {
                        outputStreamOpenOutputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    private boolean isSaveToFile() {
        return this.mOutputFileOptions.getFile() != null;
    }

    private boolean isSaveToMediaStore() {
        return (this.mOutputFileOptions.getSaveCollection() == null || this.mOutputFileOptions.getContentResolver() == null || this.mOutputFileOptions.getContentValues() == null) ? false : true;
    }

    private boolean isSaveToOutputStream() {
        return this.mOutputFileOptions.getOutputStream() != null;
    }

    private void postError(final SaveError saveError, final String str, @Nullable final Throwable th) {
        this.mExecutor.execute(new Runnable() { // from class: androidx.camera.core.e0
            @Override // java.lang.Runnable
            public final void run() {
                this.f1467a.a(saveError, str, th);
            }
        });
    }

    private void postSuccess(@Nullable final Uri uri) {
        this.mExecutor.execute(new Runnable() { // from class: androidx.camera.core.d0
            @Override // java.lang.Runnable
            public final void run() {
                this.f1463a.a(uri);
            }
        });
    }

    private void setUriPending(Uri uri, int i2) {
        if (Build.VERSION.SDK_INT >= 29) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_pending", Integer.valueOf(i2));
            this.mOutputFileOptions.getContentResolver().update(uri, contentValues, null, null);
        }
    }

    public /* synthetic */ void a(Uri uri) {
        this.mCallback.onImageSaved(new ImageCapture.OutputFileResults(uri));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f7 A[DONT_GENERATE, PHI: r2 r5 r6 r7
  0x00f7: PHI (r2v9 'e' androidx.camera.core.ImageUtil$CodecFailedException) = 
  (r2v6 'e' androidx.camera.core.ImageUtil$CodecFailedException)
  (r2v7 'e' androidx.camera.core.ImageUtil$CodecFailedException)
  (r2v1 'e' androidx.camera.core.ImageUtil$CodecFailedException)
 binds: [B:90:0x0153, B:83:0x0145, B:48:0x00f5] A[DONT_GENERATE, DONT_INLINE]
  0x00f7: PHI (r5v5 androidx.camera.core.ImageUtil$CodecFailedException) = 
  (r5v24 androidx.camera.core.ImageUtil$CodecFailedException)
  (r5v25 androidx.camera.core.ImageUtil$CodecFailedException)
  (r5v26 androidx.camera.core.ImageUtil$CodecFailedException)
 binds: [B:90:0x0153, B:83:0x0145, B:48:0x00f5] A[DONT_GENERATE, DONT_INLINE]
  0x00f7: PHI (r6v3 androidx.camera.core.ImageSaver$SaveError) = 
  (r6v0 androidx.camera.core.ImageSaver$SaveError)
  (r6v1 androidx.camera.core.ImageSaver$SaveError)
  (r6v12 androidx.camera.core.ImageSaver$SaveError)
 binds: [B:90:0x0153, B:83:0x0145, B:48:0x00f5] A[DONT_GENERATE, DONT_INLINE]
  0x00f7: PHI (r7v3 java.lang.String) = (r7v0 java.lang.String), (r7v1 java.lang.String), (r7v8 java.lang.String) binds: [B:90:0x0153, B:83:0x0145, B:48:0x00f5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x015c  */
    /* JADX WARN: Type inference failed for: r10v0, types: [androidx.camera.core.ImageSaver] */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r5v20, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r5v4, types: [android.net.Uri] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            Method dump skipped, instructions count: 371
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.ImageSaver.run():void");
    }

    public /* synthetic */ void a(SaveError saveError, String str, Throwable th) {
        this.mCallback.onError(saveError, str, th);
    }
}
