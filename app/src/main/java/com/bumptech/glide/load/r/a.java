package com.bumptech.glide.load.r;

import android.annotation.SuppressLint;
import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.k;
import com.bumptech.glide.load.l;
import com.bumptech.glide.load.p.v;
import com.bumptech.glide.load.r.d.p;
import com.bumptech.glide.load.r.d.q;
import com.bumptech.glide.load.r.d.w;
import java.io.IOException;

/* compiled from: ImageDecoderResourceDecoder.java */
@RequiresApi(api = 28)
/* loaded from: classes.dex */
public abstract class a<T> implements l<ImageDecoder.Source, T> {

    /* renamed from: b, reason: collision with root package name */
    private static final String f4821b = "ImageDecoder";

    /* renamed from: a, reason: collision with root package name */
    final w f4822a = w.a();

    /* compiled from: ImageDecoderResourceDecoder.java */
    /* renamed from: com.bumptech.glide.load.r.a$a, reason: collision with other inner class name */
    class C0071a implements ImageDecoder.OnHeaderDecodedListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f4823a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f4824b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f4825c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.bumptech.glide.load.b f4826d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ p f4827e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ k f4828f;

        /* compiled from: ImageDecoderResourceDecoder.java */
        /* renamed from: com.bumptech.glide.load.r.a$a$a, reason: collision with other inner class name */
        class C0072a implements ImageDecoder.OnPartialImageListener {
            C0072a() {
            }

            @Override // android.graphics.ImageDecoder.OnPartialImageListener
            public boolean onPartialImage(@NonNull ImageDecoder.DecodeException decodeException) {
                return false;
            }
        }

        C0071a(int i2, int i3, boolean z, com.bumptech.glide.load.b bVar, p pVar, k kVar) {
            this.f4823a = i2;
            this.f4824b = i3;
            this.f4825c = z;
            this.f4826d = bVar;
            this.f4827e = pVar;
            this.f4828f = kVar;
        }

        @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
        @SuppressLint({"Override"})
        public void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
            if (a.this.f4822a.a(this.f4823a, this.f4824b, this.f4825c, false)) {
                imageDecoder.setAllocator(3);
            } else {
                imageDecoder.setAllocator(1);
            }
            if (this.f4826d == com.bumptech.glide.load.b.PREFER_RGB_565) {
                imageDecoder.setMemorySizePolicy(0);
            }
            imageDecoder.setOnPartialImageListener(new C0072a());
            Size size = imageInfo.getSize();
            int width = this.f4823a;
            if (width == Integer.MIN_VALUE) {
                width = size.getWidth();
            }
            int height = this.f4824b;
            if (height == Integer.MIN_VALUE) {
                height = size.getHeight();
            }
            float fB = this.f4827e.b(size.getWidth(), size.getHeight(), width, height);
            int iRound = Math.round(size.getWidth() * fB);
            int iRound2 = Math.round(size.getHeight() * fB);
            if (Log.isLoggable(a.f4821b, 2)) {
                String str = "Resizing from [" + size.getWidth() + "x" + size.getHeight() + "] to [" + iRound + "x" + iRound2 + "] scaleFactor: " + fB;
            }
            imageDecoder.setTargetSize(iRound, iRound2);
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 28) {
                imageDecoder.setTargetColorSpace(ColorSpace.get(this.f4828f == k.DISPLAY_P3 && imageInfo.getColorSpace() != null && imageInfo.getColorSpace().isWideGamut() ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB));
            } else if (i2 >= 26) {
                imageDecoder.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
            }
        }
    }

    protected abstract v<T> a(ImageDecoder.Source source, int i2, int i3, ImageDecoder.OnHeaderDecodedListener onHeaderDecodedListener) throws IOException;

    @Override // com.bumptech.glide.load.l
    public final boolean a(@NonNull ImageDecoder.Source source, @NonNull j jVar) {
        return true;
    }

    @Override // com.bumptech.glide.load.l
    @Nullable
    public final v<T> a(@NonNull ImageDecoder.Source source, int i2, int i3, @NonNull j jVar) throws IOException {
        return a(source, i2, i3, new C0071a(i2, i3, jVar.a(q.f4932k) != null && ((Boolean) jVar.a(q.f4932k)).booleanValue(), (com.bumptech.glide.load.b) jVar.a(q.f4928g), (p) jVar.a(p.f4924h), (k) jVar.a(q.f4929h)));
    }
}
