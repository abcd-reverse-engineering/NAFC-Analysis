package com.umeng.socialize.media;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import com.umeng.social.tool.UMImageMark;
import com.umeng.socialize.c.a.a;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.umeng.socialize.utils.ContextUtil;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.SocializeUtils;
import com.umeng.socialize.utils.UmengText;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class UMImage extends BaseMediaObject {
    public static int BINARY_IMAGE = 5;
    public static int BITMAP_IMAGE = 4;
    public static int FILE_IMAGE = 1;
    public static int MAX_HEIGHT = 1024;
    public static int MAX_WIDTH = 768;
    public static int RES_IMAGE = 3;
    public static int URL_IMAGE = 2;
    public Bitmap.CompressFormat compressFormat;
    public CompressStyle compressStyle;

    /* renamed from: f, reason: collision with root package name */
    private ConfiguredConvertor f11707f;

    /* renamed from: g, reason: collision with root package name */
    private UMImage f11708g;

    /* renamed from: h, reason: collision with root package name */
    private UMImageMark f11709h;

    /* renamed from: i, reason: collision with root package name */
    private int f11710i;
    public boolean isLoadImgByCompress;

    /* renamed from: j, reason: collision with root package name */
    private boolean f11711j;

    class BinaryConvertor extends ConfiguredConvertor {

        /* renamed from: b, reason: collision with root package name */
        private byte[] f11713b;

        public BinaryConvertor(byte[] bArr) {
            this.f11713b = bArr;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public byte[] asBinary() {
            return this.f11713b;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public Bitmap asBitmap() {
            if (SocializeUtils.assertBinaryInvalid(asBinary())) {
                return a.a(asBinary());
            }
            return null;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public File asFile() {
            if (SocializeUtils.assertBinaryInvalid(asBinary())) {
                return a.b(asBinary());
            }
            return null;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public String asUrl() {
            return null;
        }
    }

    class BitmapConvertor extends ConfiguredConvertor {

        /* renamed from: b, reason: collision with root package name */
        private Bitmap f11715b;

        public BitmapConvertor(Bitmap bitmap) {
            this.f11715b = bitmap;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public byte[] asBinary() {
            return a.a(this.f11715b, UMImage.this.compressFormat);
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public Bitmap asBitmap() {
            return this.f11715b;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public File asFile() {
            byte[] bArrA = a.a(this.f11715b, UMImage.this.compressFormat);
            if (SocializeUtils.assertBinaryInvalid(asBinary())) {
                return a.b(bArrA);
            }
            return null;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public String asUrl() {
            return null;
        }
    }

    public enum CompressStyle {
        SCALE,
        QUALITY
    }

    static abstract class ConfiguredConvertor implements IImageConvertor {
        ConfiguredConvertor() {
        }
    }

    class FileConvertor extends ConfiguredConvertor {

        /* renamed from: b, reason: collision with root package name */
        private File f11718b;

        public FileConvertor(File file) {
            this.f11718b = file;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public byte[] asBinary() {
            return a.a(this.f11718b, UMImage.this.compressFormat);
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public Bitmap asBitmap() {
            if (SocializeUtils.assertBinaryInvalid(asBinary())) {
                return a.a(UMImage.this.asBinImage());
            }
            return null;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public File asFile() {
            return this.f11718b;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public String asUrl() {
            return null;
        }
    }

    interface IImageConvertor {
        byte[] asBinary();

        Bitmap asBitmap();

        File asFile();

        String asUrl();
    }

    class ResConvertor extends ConfiguredConvertor {

        /* renamed from: b, reason: collision with root package name */
        private Context f11720b;

        /* renamed from: c, reason: collision with root package name */
        private int f11721c;

        public ResConvertor(Context context, int i2) {
            this.f11721c = 0;
            this.f11720b = context;
            this.f11721c = i2;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public byte[] asBinary() {
            Context context = this.f11720b;
            int i2 = this.f11721c;
            UMImage uMImage = UMImage.this;
            return a.a(context, i2, uMImage.isLoadImgByCompress, uMImage.compressFormat);
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public Bitmap asBitmap() {
            if (SocializeUtils.assertBinaryInvalid(asBinary())) {
                return a.a(asBinary());
            }
            return null;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public File asFile() {
            if (SocializeUtils.assertBinaryInvalid(asBinary())) {
                return a.b(asBinary());
            }
            return null;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public String asUrl() {
            return null;
        }
    }

    class UrlConvertor extends ConfiguredConvertor {

        /* renamed from: b, reason: collision with root package name */
        private String f11723b;

        public UrlConvertor(String str) {
            this.f11723b = null;
            this.f11723b = str;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public byte[] asBinary() {
            return a.a(this.f11723b);
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public Bitmap asBitmap() {
            if (SocializeUtils.assertBinaryInvalid(asBinary())) {
                return a.a(asBinary());
            }
            return null;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public File asFile() {
            if (SocializeUtils.assertBinaryInvalid(asBinary())) {
                return a.b(asBinary());
            }
            return null;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public String asUrl() {
            return this.f11723b;
        }
    }

    public UMImage(Context context, File file) {
        this.f11707f = null;
        this.isLoadImgByCompress = true;
        this.compressStyle = CompressStyle.SCALE;
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.f11710i = 0;
        a(context, file);
    }

    private float a(float f2, float f3, float f4, float f5) {
        if (f2 <= f5 && f3 <= f5) {
            return -1.0f;
        }
        float f6 = f2 / f4;
        float f7 = f3 / f5;
        return f6 > f7 ? f6 : f7;
    }

    private void a(Context context, Object obj) {
        a(context, obj, null);
    }

    private void b(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                if (bitmap.isRecycled()) {
                    return;
                }
                bitmap.recycle();
            } catch (Exception e2) {
                SLog.error(e2);
            }
        }
    }

    public byte[] asBinImage() {
        ConfiguredConvertor configuredConvertor = this.f11707f;
        if (configuredConvertor == null) {
            return null;
        }
        return configuredConvertor.asBinary();
    }

    public Bitmap asBitmap() {
        ConfiguredConvertor configuredConvertor = this.f11707f;
        if (configuredConvertor == null) {
            return null;
        }
        return configuredConvertor.asBitmap();
    }

    public File asFileImage() {
        ConfiguredConvertor configuredConvertor = this.f11707f;
        if (configuredConvertor == null) {
            return null;
        }
        return configuredConvertor.asFile();
    }

    public String asUrlImage() {
        ConfiguredConvertor configuredConvertor = this.f11707f;
        if (configuredConvertor == null) {
            return null;
        }
        return configuredConvertor.asUrl();
    }

    public int getImageStyle() {
        return this.f11710i;
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public UMediaObject.MediaType getMediaType() {
        return UMediaObject.MediaType.IMAGE;
    }

    @Override // com.umeng.socialize.media.BaseMediaObject
    public UMImage getThumbImage() {
        return this.f11708g;
    }

    public boolean isHasWaterMark() {
        return this.f11711j;
    }

    @Override // com.umeng.socialize.media.BaseMediaObject
    public void setThumb(UMImage uMImage) {
        this.f11708g = uMImage;
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public byte[] toByte() {
        return asBinImage();
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public final Map<String, Object> toUrlExtraParams() {
        HashMap map = new HashMap();
        if (isUrlMedia()) {
            map.put(SocializeProtocolConstants.PROTOCOL_KEY_FURL, this.f11689a);
            map.put(SocializeProtocolConstants.PROTOCOL_KEY_FTYPE, getMediaType());
        }
        return map;
    }

    private void a(Context context, Object obj, UMImageMark uMImageMark) {
        Bitmap bitmapA;
        if (uMImageMark != null) {
            this.f11711j = true;
            this.f11709h = uMImageMark;
            this.f11709h.setContext(context);
        }
        if (ContextUtil.getContext() == null) {
            ContextUtil.setContext(context.getApplicationContext());
        }
        if (obj instanceof File) {
            this.f11710i = FILE_IMAGE;
            this.f11707f = new FileConvertor((File) obj);
            return;
        }
        if (obj instanceof String) {
            this.f11710i = URL_IMAGE;
            this.f11707f = new UrlConvertor((String) obj);
            return;
        }
        if (obj instanceof Integer) {
            this.f11710i = RES_IMAGE;
            bitmapA = isHasWaterMark() ? a(context, ((Integer) obj).intValue()) : null;
            if (bitmapA != null) {
                this.f11707f = new BitmapConvertor(bitmapA);
                return;
            } else {
                this.f11707f = new ResConvertor(context.getApplicationContext(), ((Integer) obj).intValue());
                return;
            }
        }
        if (obj instanceof byte[]) {
            this.f11710i = BINARY_IMAGE;
            bitmapA = isHasWaterMark() ? a((byte[]) obj) : null;
            if (bitmapA != null) {
                this.f11707f = new BitmapConvertor(bitmapA);
                return;
            } else {
                this.f11707f = new BinaryConvertor((byte[]) obj);
                return;
            }
        }
        if (obj instanceof Bitmap) {
            this.f11710i = BITMAP_IMAGE;
            bitmapA = isHasWaterMark() ? a((Bitmap) obj, true) : null;
            if (bitmapA == null) {
                bitmapA = (Bitmap) obj;
            }
            this.f11707f = new BitmapConvertor(bitmapA);
            return;
        }
        if (obj != null) {
            SLog.E(UmengText.IMAGE.UNKNOW_UMIMAGE + obj.getClass().getSimpleName());
            return;
        }
        SLog.E(UmengText.IMAGE.UNKNOW_UMIMAGE + c.c.a.b.a.a.f3101h);
    }

    public UMImage(Context context, String str) {
        super(str);
        this.f11707f = null;
        this.isLoadImgByCompress = true;
        this.compressStyle = CompressStyle.SCALE;
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.f11710i = 0;
        a((Context) new WeakReference(context).get(), str);
    }

    public UMImage(Context context, int i2) {
        this.f11707f = null;
        this.isLoadImgByCompress = true;
        this.compressStyle = CompressStyle.SCALE;
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.f11710i = 0;
        a(context, Integer.valueOf(i2));
    }

    public UMImage(Context context, byte[] bArr) {
        this.f11707f = null;
        this.isLoadImgByCompress = true;
        this.compressStyle = CompressStyle.SCALE;
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.f11710i = 0;
        a(context, bArr);
    }

    public UMImage(Context context, Bitmap bitmap) {
        this.f11707f = null;
        this.isLoadImgByCompress = true;
        this.compressStyle = CompressStyle.SCALE;
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.f11710i = 0;
        a(context, bitmap);
    }

    private Bitmap a(Bitmap bitmap, boolean z) {
        if (this.f11709h == null) {
            return bitmap;
        }
        if (bitmap == null) {
            return null;
        }
        if (z) {
            try {
                bitmap = a(bitmap);
            } catch (Exception e2) {
                SLog.error(e2);
                return null;
            }
        }
        return this.f11709h.compound(bitmap);
    }

    public UMImage(Context context, Bitmap bitmap, UMImageMark uMImageMark) {
        this.f11707f = null;
        this.isLoadImgByCompress = true;
        this.compressStyle = CompressStyle.SCALE;
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.f11710i = 0;
        a(context, bitmap, uMImageMark);
    }

    private Bitmap a(Context context, int i2) throws Throwable {
        InputStream inputStream;
        InputStream inputStreamOpenRawResource;
        if (i2 != 0 && context != null) {
            try {
                if (this.f11709h != null) {
                    try {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inJustDecodeBounds = true;
                        inputStreamOpenRawResource = context.getResources().openRawResource(i2);
                        try {
                            BitmapFactory.decodeStream(inputStreamOpenRawResource, null, options);
                            a(inputStreamOpenRawResource);
                            int iA = (int) a(options.outWidth, options.outHeight, MAX_WIDTH, MAX_HEIGHT);
                            if (iA > 0) {
                                options.inSampleSize = iA;
                            }
                            options.inJustDecodeBounds = false;
                            InputStream inputStreamOpenRawResource2 = context.getResources().openRawResource(i2);
                            try {
                                Bitmap bitmapA = a(BitmapFactory.decodeStream(inputStreamOpenRawResource2, null, options), false);
                                a(inputStreamOpenRawResource2);
                                return bitmapA;
                            } catch (Exception e2) {
                                inputStreamOpenRawResource = inputStreamOpenRawResource2;
                                e = e2;
                                SLog.error(e);
                                a(inputStreamOpenRawResource);
                                return null;
                            } catch (Throwable th) {
                                inputStream = inputStreamOpenRawResource2;
                                th = th;
                                a(inputStream);
                                throw th;
                            }
                        } catch (Exception e3) {
                            e = e3;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        inputStreamOpenRawResource = null;
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = null;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
        return null;
    }

    public UMImage(Context context, int i2, UMImageMark uMImageMark) {
        this.f11707f = null;
        this.isLoadImgByCompress = true;
        this.compressStyle = CompressStyle.SCALE;
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.f11710i = 0;
        a(context, Integer.valueOf(i2), uMImageMark);
    }

    public UMImage(Context context, byte[] bArr, UMImageMark uMImageMark) {
        this.f11707f = null;
        this.isLoadImgByCompress = true;
        this.compressStyle = CompressStyle.SCALE;
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.f11710i = 0;
        a(context, bArr, uMImageMark);
    }

    private void a(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e2) {
                SLog.error(e2);
            }
        }
    }

    private Bitmap a(byte[] bArr) {
        if (bArr != null && this.f11709h != null) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                int iA = (int) a(options.outWidth, options.outHeight, MAX_WIDTH, MAX_HEIGHT);
                if (iA > 0) {
                    options.inSampleSize = iA;
                }
                options.inJustDecodeBounds = false;
                return a(BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options), false);
            } catch (Exception e2) {
                SLog.error(e2);
            }
        }
        return null;
    }

    private Bitmap a(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float fA = a(width, height, MAX_WIDTH, MAX_HEIGHT);
        if (fA < 0.0f) {
            return bitmap;
        }
        float f2 = 1.0f / fA;
        Matrix matrix = new Matrix();
        matrix.postScale(f2, f2);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        b(bitmap);
        return bitmapCreateBitmap;
    }
}
