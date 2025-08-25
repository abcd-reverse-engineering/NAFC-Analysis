package j;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import com.bumptech.glide.r.h;
import com.bumptech.glide.r.l.j;
import com.hicorenational.antifraud.R;
import com.luck.picture.lib.engine.ImageEngine;
import com.luck.picture.lib.listener.OnImageCompleteCallback;
import com.luck.picture.lib.tools.MediaUtils;
import com.luck.picture.lib.widget.longimage.ImageSource;
import com.luck.picture.lib.widget.longimage.ImageViewState;
import com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView;
import java.lang.reflect.InvocationTargetException;

/* compiled from: GlideEngine.java */
/* loaded from: classes2.dex */
public class b implements ImageEngine {

    /* renamed from: b, reason: collision with root package name */
    private static b f16992b;

    /* renamed from: a, reason: collision with root package name */
    com.bumptech.glide.r.a f16993a;

    /* compiled from: GlideEngine.java */
    class a extends j<Bitmap> {

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ OnImageCompleteCallback f16994k;

        /* renamed from: l, reason: collision with root package name */
        final /* synthetic */ SubsamplingScaleImageView f16995l;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ ImageView f16996m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(ImageView imageView, OnImageCompleteCallback onImageCompleteCallback, SubsamplingScaleImageView subsamplingScaleImageView, ImageView imageView2) {
            super(imageView);
            this.f16994k = onImageCompleteCallback;
            this.f16995l = subsamplingScaleImageView;
            this.f16996m = imageView2;
        }

        @Override // com.bumptech.glide.r.l.j, com.bumptech.glide.r.l.r, com.bumptech.glide.r.l.b, com.bumptech.glide.r.l.p
        public void b(@Nullable Drawable drawable) {
            super.b(drawable);
            OnImageCompleteCallback onImageCompleteCallback = this.f16994k;
            if (onImageCompleteCallback != null) {
                onImageCompleteCallback.onShowLoading();
            }
        }

        @Override // com.bumptech.glide.r.l.j, com.bumptech.glide.r.l.b, com.bumptech.glide.r.l.p
        public void a(@Nullable Drawable drawable) {
            super.a(drawable);
            OnImageCompleteCallback onImageCompleteCallback = this.f16994k;
            if (onImageCompleteCallback != null) {
                onImageCompleteCallback.onHideLoading();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.r.l.j
        public void a(@Nullable Bitmap bitmap) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            OnImageCompleteCallback onImageCompleteCallback = this.f16994k;
            if (onImageCompleteCallback != null) {
                onImageCompleteCallback.onHideLoading();
            }
            if (bitmap != null) {
                boolean zIsLongImg = MediaUtils.isLongImg(bitmap.getWidth(), bitmap.getHeight());
                this.f16995l.setVisibility(zIsLongImg ? 0 : 8);
                this.f16996m.setVisibility(zIsLongImg ? 8 : 0);
                if (zIsLongImg) {
                    this.f16995l.setQuickScaleEnabled(true);
                    this.f16995l.setZoomEnabled(true);
                    this.f16995l.setPanEnabled(true);
                    this.f16995l.setDoubleTapZoomDuration(100);
                    this.f16995l.setMinimumScaleType(2);
                    this.f16995l.setDoubleTapZoomDpi(2);
                    this.f16995l.setImage(ImageSource.bitmap(bitmap), new ImageViewState(0.0f, new PointF(0.0f, 0.0f), 0));
                    return;
                }
                this.f16996m.setImageBitmap(bitmap);
            }
        }
    }

    /* compiled from: GlideEngine.java */
    /* renamed from: j.b$b, reason: collision with other inner class name */
    class C0263b extends j<Bitmap> {

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ SubsamplingScaleImageView f16997k;

        /* renamed from: l, reason: collision with root package name */
        final /* synthetic */ ImageView f16998l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0263b(ImageView imageView, SubsamplingScaleImageView subsamplingScaleImageView, ImageView imageView2) {
            super(imageView);
            this.f16997k = subsamplingScaleImageView;
            this.f16998l = imageView2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.r.l.j
        public void a(@Nullable Bitmap bitmap) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (bitmap != null) {
                boolean zIsLongImg = MediaUtils.isLongImg(bitmap.getWidth(), bitmap.getHeight());
                this.f16997k.setVisibility(zIsLongImg ? 0 : 8);
                this.f16998l.setVisibility(zIsLongImg ? 8 : 0);
                if (!zIsLongImg) {
                    this.f16998l.setImageBitmap(bitmap);
                    return;
                }
                this.f16997k.setQuickScaleEnabled(true);
                this.f16997k.setZoomEnabled(true);
                this.f16997k.setPanEnabled(true);
                this.f16997k.setDoubleTapZoomDuration(100);
                this.f16997k.setMinimumScaleType(2);
                this.f16997k.setDoubleTapZoomDpi(2);
                this.f16997k.setImage(ImageSource.bitmap(bitmap), new ImageViewState(0.0f, new PointF(0.0f, 0.0f), 0));
            }
        }
    }

    /* compiled from: GlideEngine.java */
    class c extends com.bumptech.glide.r.l.c {

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ Context f17000k;

        /* renamed from: l, reason: collision with root package name */
        final /* synthetic */ ImageView f17001l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(ImageView imageView, Context context, ImageView imageView2) {
            super(imageView);
            this.f17000k = context;
            this.f17001l = imageView2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bumptech.glide.r.l.c, com.bumptech.glide.r.l.j
        public void a(Bitmap bitmap) {
            RoundedBitmapDrawable roundedBitmapDrawableCreate = RoundedBitmapDrawableFactory.create(this.f17000k.getResources(), bitmap);
            roundedBitmapDrawableCreate.setCornerRadius(8.0f);
            this.f17001l.setImageDrawable(roundedBitmapDrawableCreate);
        }
    }

    private b() {
    }

    public static b a() {
        if (f16992b == null) {
            synchronized (b.class) {
                if (f16992b == null) {
                    f16992b = new b();
                }
            }
        }
        return f16992b;
    }

    @Override // com.luck.picture.lib.engine.ImageEngine
    public void loadAsGifImage(@NonNull Context context, @NonNull String str, @NonNull ImageView imageView) {
        com.bumptech.glide.b.e(context).e().a(str).a(imageView);
    }

    @Override // com.luck.picture.lib.engine.ImageEngine
    public void loadFolderImage(@NonNull Context context, @NonNull String str, @NonNull ImageView imageView) {
        com.bumptech.glide.b.e(context).b().a(180, 180).a(str).b().a(0.5f).a((com.bumptech.glide.r.a<?>) new h().e(R.drawable.picture_image_placeholder)).b((com.bumptech.glide.j) new c(imageView, context, imageView));
    }

    @Override // com.luck.picture.lib.engine.ImageEngine
    public void loadGridImage(@NonNull Context context, @NonNull String str, @NonNull ImageView imageView) {
        if (this.f16993a == null) {
            this.f16993a = new h().e(R.drawable.picture_image_placeholder);
        }
        com.bumptech.glide.b.e(context).a(str).a(200, 200).b().a(this.f16993a).a(imageView);
    }

    @Override // com.luck.picture.lib.engine.ImageEngine
    public void loadImage(@NonNull Context context, @NonNull String str, @NonNull ImageView imageView) {
        com.bumptech.glide.b.e(context).a(str).a(imageView);
    }

    @Override // com.luck.picture.lib.engine.ImageEngine
    public void loadImage(@NonNull Context context, @NonNull String str, @NonNull ImageView imageView, SubsamplingScaleImageView subsamplingScaleImageView, OnImageCompleteCallback onImageCompleteCallback) {
        com.bumptech.glide.b.e(context).b().a(str).b((com.bumptech.glide.j<Bitmap>) new a(imageView, onImageCompleteCallback, subsamplingScaleImageView, imageView));
    }

    @Override // com.luck.picture.lib.engine.ImageEngine
    public void loadImage(@NonNull Context context, @NonNull String str, @NonNull ImageView imageView, SubsamplingScaleImageView subsamplingScaleImageView) {
        com.bumptech.glide.b.e(context).b().a(str).b((com.bumptech.glide.j<Bitmap>) new C0263b(imageView, subsamplingScaleImageView, imageView));
    }
}
