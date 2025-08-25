package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.Drawable;
import androidx.annotation.RequiresApi;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import h.q2.s.q;
import h.q2.t.i0;
import h.y;
import h.y1;
import i.c.a.d;
import java.io.IOException;

/* compiled from: ImageDecoder.kt */
@y(bv = {1, 0, 2}, d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aR\u0010\u0000\u001a\u00020\u0001*\u00020\u00022C\b\u0004\u0010\u0003\u001a=\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0004¢\u0006\u0002\b\fH\u0087\b\u001aR\u0010\r\u001a\u00020\u000e*\u00020\u00022C\b\u0004\u0010\u0003\u001a=\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0004¢\u0006\u0002\b\fH\u0087\b¨\u0006\u000f"}, d2 = {"decodeBitmap", "Landroid/graphics/Bitmap;", "Landroid/graphics/ImageDecoder$Source;", "action", "Lkotlin/Function3;", "Landroid/graphics/ImageDecoder;", "Landroid/graphics/ImageDecoder$ImageInfo;", "Lkotlin/ParameterName;", CommonNetImpl.NAME, "info", "source", "", "Lkotlin/ExtensionFunctionType;", "decodeDrawable", "Landroid/graphics/drawable/Drawable;", "core-ktx_release"}, k = 2, mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class ImageDecoderKt {
    @RequiresApi(28)
    @d
    public static final Bitmap decodeBitmap(@d ImageDecoder.Source source, @d final q<? super ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, y1> qVar) throws IOException {
        i0.f(source, "$receiver");
        i0.f(qVar, "action");
        Bitmap bitmapDecodeBitmap = ImageDecoder.decodeBitmap(source, new ImageDecoder.OnHeaderDecodedListener() { // from class: androidx.core.graphics.ImageDecoderKt.decodeBitmap.1
            @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
            public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source2) {
                q qVar2 = qVar;
                i0.a((Object) imageDecoder, "decoder");
                i0.a((Object) imageInfo, "info");
                i0.a((Object) source2, "source");
                qVar2.invoke(imageDecoder, imageInfo, source2);
            }
        });
        i0.a((Object) bitmapDecodeBitmap, "ImageDecoder.decodeBitma…ction(info, source)\n    }");
        return bitmapDecodeBitmap;
    }

    @RequiresApi(28)
    @d
    public static final Drawable decodeDrawable(@d ImageDecoder.Source source, @d final q<? super ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, y1> qVar) throws IOException {
        i0.f(source, "$receiver");
        i0.f(qVar, "action");
        Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(source, new ImageDecoder.OnHeaderDecodedListener() { // from class: androidx.core.graphics.ImageDecoderKt.decodeDrawable.1
            @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
            public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source2) {
                q qVar2 = qVar;
                i0.a((Object) imageDecoder, "decoder");
                i0.a((Object) imageInfo, "info");
                i0.a((Object) source2, "source");
                qVar2.invoke(imageDecoder, imageInfo, source2);
            }
        });
        i0.a((Object) drawableDecodeDrawable, "ImageDecoder.decodeDrawa…ction(info, source)\n    }");
        return drawableDecodeDrawable;
    }
}
