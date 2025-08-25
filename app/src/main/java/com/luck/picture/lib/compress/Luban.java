package com.luck.picture.lib.compress;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.tools.AndroidQTransformUtils;
import com.luck.picture.lib.tools.DESUtils;
import com.luck.picture.lib.tools.DateUtils;
import com.luck.picture.lib.tools.PictureFileUtils;
import com.luck.picture.lib.tools.SdkVersionUtils;
import com.luck.picture.lib.tools.StringUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public class Luban implements Handler.Callback {
    private static final int MSG_COMPRESS_ERROR = 2;
    private static final int MSG_COMPRESS_START = 1;
    private static final int MSG_COMPRESS_SUCCESS = 0;
    private static final String TAG = "Luban";
    private int compressQuality;
    private boolean focusAlpha;
    private int index;
    private boolean isAndroidQ;
    private boolean isCamera;
    private OnCompressListener mCompressListener;
    private CompressionPredicate mCompressionPredicate;
    private Handler mHandler;
    private int mLeastCompressSize;
    private String mNewFileName;
    private List<String> mPaths;
    private OnRenameListener mRenameListener;
    private List<InputStreamProvider> mStreamProviders;
    private String mTargetDir;
    private List<LocalMedia> mediaList;

    public static class Builder {
        private int compressQuality;
        private Context context;
        private boolean focusAlpha;
        private boolean isCamera;
        private OnCompressListener mCompressListener;
        private CompressionPredicate mCompressionPredicate;
        private String mNewFileName;
        private OnRenameListener mRenameListener;
        private String mTargetDir;
        private int mLeastCompressSize = 100;
        private List<String> mPaths = new ArrayList();
        private List<LocalMedia> mediaList = new ArrayList();
        private List<InputStreamProvider> mStreamProviders = new ArrayList();
        private boolean isAndroidQ = SdkVersionUtils.checkedAndroid_Q();

        Builder(Context context) {
            this.context = context;
        }

        private Luban build() {
            return new Luban(this);
        }

        public Builder filter(CompressionPredicate compressionPredicate) {
            this.mCompressionPredicate = compressionPredicate;
            return this;
        }

        public File get(final String str) throws IOException {
            return build().get(new InputStreamAdapter() { // from class: com.luck.picture.lib.compress.Luban.Builder.5
                @Override // com.luck.picture.lib.compress.InputStreamProvider
                public LocalMedia getMedia() {
                    return null;
                }

                @Override // com.luck.picture.lib.compress.InputStreamProvider
                public String getPath() {
                    return str;
                }

                @Override // com.luck.picture.lib.compress.InputStreamAdapter
                public InputStream openInternal() throws IOException {
                    return new FileInputStream(str);
                }
            }, this.context);
        }

        public Builder ignoreBy(int i2) {
            this.mLeastCompressSize = i2;
            return this;
        }

        public Builder isCamera(boolean z) {
            this.isCamera = z;
            return this;
        }

        public void launch() {
            build().launch(this.context);
        }

        public Builder load(InputStreamProvider inputStreamProvider) {
            this.mStreamProviders.add(inputStreamProvider);
            return this;
        }

        public <T> Builder loadMediaData(List<LocalMedia> list) {
            this.mediaList = list;
            Iterator<LocalMedia> it = list.iterator();
            while (it.hasNext()) {
                load(it.next());
            }
            return this;
        }

        public Builder putGear(int i2) {
            return this;
        }

        public Builder setCompressListener(OnCompressListener onCompressListener) {
            this.mCompressListener = onCompressListener;
            return this;
        }

        public Builder setCompressQuality(int i2) {
            this.compressQuality = i2;
            return this;
        }

        public Builder setFocusAlpha(boolean z) {
            this.focusAlpha = z;
            return this;
        }

        public Builder setNewCompressFileName(String str) {
            this.mNewFileName = str;
            return this;
        }

        @Deprecated
        public Builder setRenameListener(OnRenameListener onRenameListener) {
            this.mRenameListener = onRenameListener;
            return this;
        }

        public Builder setTargetDir(String str) {
            this.mTargetDir = str;
            return this;
        }

        private Builder load(final LocalMedia localMedia) {
            this.mStreamProviders.add(new InputStreamAdapter() { // from class: com.luck.picture.lib.compress.Luban.Builder.1
                @Override // com.luck.picture.lib.compress.InputStreamProvider
                public LocalMedia getMedia() {
                    return localMedia;
                }

                @Override // com.luck.picture.lib.compress.InputStreamProvider
                public String getPath() {
                    return localMedia.isCut() ? localMedia.getCutPath() : TextUtils.isEmpty(localMedia.getAndroidQToPath()) ? localMedia.getPath() : localMedia.getAndroidQToPath();
                }

                @Override // com.luck.picture.lib.compress.InputStreamAdapter
                public InputStream openInternal() throws IOException {
                    if (!PictureMimeType.isContent(localMedia.getPath()) || localMedia.isCut()) {
                        return new FileInputStream(localMedia.isCut() ? localMedia.getCutPath() : localMedia.getPath());
                    }
                    return !TextUtils.isEmpty(localMedia.getAndroidQToPath()) ? new FileInputStream(localMedia.getAndroidQToPath()) : Builder.this.context.getContentResolver().openInputStream(Uri.parse(localMedia.getPath()));
                }
            });
            return this;
        }

        public List<File> get() throws IOException {
            return build().get(this.context);
        }

        public Builder load(final Uri uri) {
            this.mStreamProviders.add(new InputStreamAdapter() { // from class: com.luck.picture.lib.compress.Luban.Builder.2
                @Override // com.luck.picture.lib.compress.InputStreamProvider
                public LocalMedia getMedia() {
                    return null;
                }

                @Override // com.luck.picture.lib.compress.InputStreamProvider
                public String getPath() {
                    return uri.getPath();
                }

                @Override // com.luck.picture.lib.compress.InputStreamAdapter
                public InputStream openInternal() throws IOException {
                    return Builder.this.context.getContentResolver().openInputStream(uri);
                }
            });
            return this;
        }

        public Builder load(final File file) {
            this.mStreamProviders.add(new InputStreamAdapter() { // from class: com.luck.picture.lib.compress.Luban.Builder.3
                @Override // com.luck.picture.lib.compress.InputStreamProvider
                public LocalMedia getMedia() {
                    return null;
                }

                @Override // com.luck.picture.lib.compress.InputStreamProvider
                public String getPath() {
                    return file.getAbsolutePath();
                }

                @Override // com.luck.picture.lib.compress.InputStreamAdapter
                public InputStream openInternal() throws IOException {
                    return new FileInputStream(file);
                }
            });
            return this;
        }

        public Builder load(final String str) {
            this.mStreamProviders.add(new InputStreamAdapter() { // from class: com.luck.picture.lib.compress.Luban.Builder.4
                @Override // com.luck.picture.lib.compress.InputStreamProvider
                public LocalMedia getMedia() {
                    return null;
                }

                @Override // com.luck.picture.lib.compress.InputStreamProvider
                public String getPath() {
                    return str;
                }

                @Override // com.luck.picture.lib.compress.InputStreamAdapter
                public InputStream openInternal() throws IOException {
                    return new FileInputStream(str);
                }
            });
            return this;
        }

        public <T> Builder load(List<T> list) {
            for (T t : list) {
                if (t instanceof String) {
                    load((String) t);
                } else if (t instanceof File) {
                    load((File) t);
                } else if (t instanceof Uri) {
                    load((Uri) t);
                } else {
                    throw new IllegalArgumentException("Incoming data type exception, it must be String, File, Uri or Bitmap");
                }
            }
            return this;
        }
    }

    private File compress(Context context, InputStreamProvider inputStreamProvider) throws IOException {
        try {
            return compressRealLocalMedia(context, inputStreamProvider);
        } finally {
            inputStreamProvider.close();
        }
    }

    private File compressReal(Context context, InputStreamProvider inputStreamProvider) throws IOException {
        String strExtSuffix = Checker.SINGLE.extSuffix(inputStreamProvider.getMedia() != null ? inputStreamProvider.getMedia().getMimeType() : "");
        if (TextUtils.isEmpty(strExtSuffix)) {
            strExtSuffix = Checker.SINGLE.extSuffix(inputStreamProvider);
        }
        File imageCacheFile = getImageCacheFile(context, inputStreamProvider, strExtSuffix);
        OnRenameListener onRenameListener = this.mRenameListener;
        if (onRenameListener != null) {
            imageCacheFile = getImageCustomFile(context, onRenameListener.rename(inputStreamProvider.getPath()));
        }
        CompressionPredicate compressionPredicate = this.mCompressionPredicate;
        return compressionPredicate != null ? (compressionPredicate.apply(inputStreamProvider.getPath()) && Checker.SINGLE.needCompress(this.mLeastCompressSize, inputStreamProvider.getPath())) ? new Engine(inputStreamProvider, imageCacheFile, this.focusAlpha, this.compressQuality).compress() : new File(inputStreamProvider.getPath()) : Checker.SINGLE.extSuffix(inputStreamProvider).startsWith(".gif") ? new File(inputStreamProvider.getPath()) : Checker.SINGLE.needCompress(this.mLeastCompressSize, inputStreamProvider.getPath()) ? new Engine(inputStreamProvider, imageCacheFile, this.focusAlpha, this.compressQuality).compress() : new File(inputStreamProvider.getPath());
    }

    private File compressRealLocalMedia(Context context, InputStreamProvider inputStreamProvider) throws IOException {
        String str;
        File file;
        LocalMedia media = inputStreamProvider.getMedia();
        if (media == null) {
            throw new NullPointerException("Luban Compress LocalMedia Can't be empty");
        }
        String realPath = this.isAndroidQ ? !TextUtils.isEmpty(media.getRealPath()) ? media.getRealPath() : PictureFileUtils.getPath(context, Uri.parse(inputStreamProvider.getPath())) : inputStreamProvider.getPath();
        String strExtSuffix = Checker.SINGLE.extSuffix(media.getMimeType());
        if (TextUtils.isEmpty(strExtSuffix)) {
            strExtSuffix = Checker.SINGLE.extSuffix(inputStreamProvider);
        }
        File imageCacheFile = getImageCacheFile(context, inputStreamProvider, strExtSuffix);
        if (TextUtils.isEmpty(this.mNewFileName)) {
            str = "";
        } else {
            String strRename = this.isCamera ? this.mNewFileName : StringUtils.rename(this.mNewFileName);
            str = strRename;
            imageCacheFile = getImageCustomFile(context, strRename);
        }
        if (imageCacheFile.exists()) {
            return imageCacheFile;
        }
        if (this.mCompressionPredicate != null) {
            if (Checker.SINGLE.extSuffix(inputStreamProvider).startsWith(".gif")) {
                if (this.isAndroidQ) {
                    return new File(media.isCut() ? media.getCutPath() : AndroidQTransformUtils.copyPathToAndroidQ(context, inputStreamProvider.getPath(), media.getWidth(), media.getHeight(), media.getMimeType(), str));
                }
                return new File(realPath);
            }
            if (this.mCompressionPredicate.apply(realPath) && Checker.SINGLE.needCompressToLocalMedia(this.mLeastCompressSize, realPath)) {
                return new Engine(inputStreamProvider, imageCacheFile, this.focusAlpha, this.compressQuality).compress();
            }
            if (this.isAndroidQ) {
                return new File(media.isCut() ? media.getCutPath() : AndroidQTransformUtils.copyPathToAndroidQ(context, inputStreamProvider.getPath(), media.getWidth(), media.getHeight(), media.getMimeType(), str));
            }
            return new File(realPath);
        }
        if (Checker.SINGLE.extSuffix(inputStreamProvider).startsWith(".gif")) {
            if (this.isAndroidQ) {
                return new File(media.isCut() ? media.getCutPath() : AndroidQTransformUtils.copyPathToAndroidQ(context, inputStreamProvider.getPath(), media.getWidth(), media.getHeight(), media.getMimeType(), str));
            }
            return new File(realPath);
        }
        if (Checker.SINGLE.needCompressToLocalMedia(this.mLeastCompressSize, realPath)) {
            file = new Engine(inputStreamProvider, imageCacheFile, this.focusAlpha, this.compressQuality).compress();
        } else {
            if (this.isAndroidQ) {
                return new File(media.isCut() ? media.getCutPath() : (String) Objects.requireNonNull(AndroidQTransformUtils.copyPathToAndroidQ(context, inputStreamProvider.getPath(), media.getWidth(), media.getHeight(), media.getMimeType(), str)));
            }
            file = new File(realPath);
        }
        return file;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File get(InputStreamProvider inputStreamProvider, Context context) throws IOException {
        try {
            return new Engine(inputStreamProvider, getImageCacheFile(context, inputStreamProvider, Checker.SINGLE.extSuffix(inputStreamProvider)), this.focusAlpha, this.compressQuality).compress();
        } finally {
            inputStreamProvider.close();
        }
    }

    private static File getImageCacheDir(Context context) {
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        if (externalFilesDir == null) {
            Log.isLoggable(TAG, 6);
            return null;
        }
        if (externalFilesDir.mkdirs() || (externalFilesDir.exists() && externalFilesDir.isDirectory())) {
            return externalFilesDir;
        }
        return null;
    }

    private File getImageCacheFile(Context context, InputStreamProvider inputStreamProvider, String str) {
        String string;
        File imageCacheDir;
        if (TextUtils.isEmpty(this.mTargetDir) && (imageCacheDir = getImageCacheDir(context)) != null) {
            this.mTargetDir = imageCacheDir.getAbsolutePath();
        }
        try {
            LocalMedia media = inputStreamProvider.getMedia();
            String strEncode = DESUtils.encode(DESUtils.DES_KEY_STRING, media.getPath(), media.getWidth(), media.getHeight());
            if (TextUtils.isEmpty(strEncode)) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.mTargetDir);
                sb.append("/");
                sb.append(DateUtils.getCreateFileName("IMG_"));
                if (TextUtils.isEmpty(str)) {
                    str = ".jpg";
                }
                sb.append(str);
                string = sb.toString();
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.mTargetDir);
                sb2.append("/");
                sb2.append("IMG_");
                sb2.append(strEncode.toUpperCase());
                if (TextUtils.isEmpty(str)) {
                    str = ".jpg";
                }
                sb2.append(str);
                string = sb2.toString();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            string = "";
        }
        return new File(string);
    }

    private File getImageCustomFile(Context context, String str) {
        if (TextUtils.isEmpty(this.mTargetDir)) {
            this.mTargetDir = getImageCacheDir(context).getAbsolutePath();
        }
        return new File(this.mTargetDir + "/" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void launch(final Context context) {
        List<InputStreamProvider> list = this.mStreamProviders;
        if (list == null || this.mPaths == null || (list.size() == 0 && this.mCompressListener != null)) {
            this.mCompressListener.onError(new NullPointerException("image file cannot be null"));
        }
        Iterator<InputStreamProvider> it = this.mStreamProviders.iterator();
        this.index = -1;
        while (it.hasNext()) {
            final InputStreamProvider next = it.next();
            AsyncTask.SERIAL_EXECUTOR.execute(new Runnable() { // from class: com.luck.picture.lib.compress.a
                @Override // java.lang.Runnable
                public final void run() {
                    this.f7785a.a(next, context);
                }
            });
            it.remove();
        }
    }

    public static Builder with(Context context) {
        return new Builder(context);
    }

    public /* synthetic */ void a(InputStreamProvider inputStreamProvider, Context context) {
        try {
            boolean z = true;
            this.index++;
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
            File file = (!inputStreamProvider.getMedia().isCompressed() || TextUtils.isEmpty(inputStreamProvider.getMedia().getCompressPath())) ? PictureMimeType.eqVideo(inputStreamProvider.getMedia().getMimeType()) ? new File(inputStreamProvider.getPath()) : compress(context, inputStreamProvider) : new File(inputStreamProvider.getMedia().getCompressPath()).exists() ? new File(inputStreamProvider.getMedia().getCompressPath()) : compress(context, inputStreamProvider);
            if (this.mediaList == null || this.mediaList.size() <= 0) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(2, new IOException()));
                return;
            }
            LocalMedia localMedia = this.mediaList.get(this.index);
            boolean zIsHttp = PictureMimeType.isHttp(file.getAbsolutePath());
            boolean zEqVideo = PictureMimeType.eqVideo(localMedia.getMimeType());
            localMedia.setCompressed((zIsHttp || zEqVideo) ? false : true);
            localMedia.setCompressPath((zIsHttp || zEqVideo) ? "" : file.getAbsolutePath());
            localMedia.setAndroidQToPath(this.isAndroidQ ? localMedia.getCompressPath() : null);
            if (this.index != this.mediaList.size() - 1) {
                z = false;
            }
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(0, this.mediaList));
            }
        } catch (IOException e2) {
            Handler handler = this.mHandler;
            handler.sendMessage(handler.obtainMessage(2, e2));
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        OnCompressListener onCompressListener = this.mCompressListener;
        if (onCompressListener == null) {
            return false;
        }
        int i2 = message.what;
        if (i2 == 0) {
            onCompressListener.onSuccess((List) message.obj);
        } else if (i2 == 1) {
            onCompressListener.onStart();
        } else if (i2 == 2) {
            onCompressListener.onError((Throwable) message.obj);
        }
        return false;
    }

    private Luban(Builder builder) {
        this.index = -1;
        this.mPaths = builder.mPaths;
        this.mediaList = builder.mediaList;
        this.mTargetDir = builder.mTargetDir;
        this.mNewFileName = builder.mNewFileName;
        this.mRenameListener = builder.mRenameListener;
        this.mStreamProviders = builder.mStreamProviders;
        this.mCompressListener = builder.mCompressListener;
        this.mLeastCompressSize = builder.mLeastCompressSize;
        this.mCompressionPredicate = builder.mCompressionPredicate;
        this.compressQuality = builder.compressQuality;
        this.focusAlpha = builder.focusAlpha;
        this.isCamera = builder.isCamera;
        this.mHandler = new Handler(Looper.getMainLooper(), this);
        this.isAndroidQ = builder.isAndroidQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<File> get(Context context) throws IOException {
        File fileCompress;
        ArrayList arrayList = new ArrayList();
        Iterator<InputStreamProvider> it = this.mStreamProviders.iterator();
        while (it.hasNext()) {
            InputStreamProvider next = it.next();
            if (next.getMedia().isCompressed() && !TextUtils.isEmpty(next.getMedia().getCompressPath())) {
                if (new File(next.getMedia().getCompressPath()).exists()) {
                    fileCompress = new File(next.getMedia().getCompressPath());
                } else {
                    fileCompress = compress(context, next);
                }
                arrayList.add(fileCompress);
            } else {
                arrayList.add(PictureMimeType.eqVideo(next.getMedia().getMimeType()) ? new File(next.getMedia().getPath()) : compress(context, next));
            }
            it.remove();
        }
        return arrayList;
    }
}
