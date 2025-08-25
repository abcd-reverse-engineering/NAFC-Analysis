package androidx.core.content;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.StyleRes;
import androidx.exifinterface.media.ExifInterface;
import h.q2.s.l;
import h.q2.t.i0;
import h.y;
import h.y1;
import i.c.a.d;
import i.c.a.e;

/* compiled from: Context.kt */
@y(bv = {1, 0, 2}, d1 = {"\u00006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\u0086\b¢\u0006\u0002\u0010\u0003\u001aN\u0010\u0004\u001a\u00020\u0005*\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0003\u0010\n\u001a\u00020\u000b2\b\b\u0003\u0010\f\u001a\u00020\u000b2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00050\u000e¢\u0006\u0002\b\u0010H\u0086\b\u001a8\u0010\u0004\u001a\u00020\u0005*\u00020\u00022\b\b\u0001\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00050\u000e¢\u0006\u0002\b\u0010H\u0086\b¨\u0006\u0012"}, d2 = {"getSystemService", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/content/Context;", "(Landroid/content/Context;)Ljava/lang/Object;", "withStyledAttributes", "", "set", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "", "defStyleRes", "block", "Lkotlin/Function1;", "Landroid/content/res/TypedArray;", "Lkotlin/ExtensionFunctionType;", "resourceId", "core-ktx_release"}, k = 2, mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class ContextKt {
    private static final <T> T getSystemService(@d Context context) {
        i0.a(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) ContextCompat.getSystemService(context, Object.class);
    }

    public static final void withStyledAttributes(@d Context context, @e AttributeSet attributeSet, @d int[] iArr, @AttrRes int i2, @StyleRes int i3, @d l<? super TypedArray, y1> lVar) {
        i0.f(context, "$receiver");
        i0.f(iArr, "attrs");
        i0.f(lVar, "block");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i2, i3);
        lVar.invoke(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
    }

    public static /* bridge */ /* synthetic */ void withStyledAttributes$default(Context context, AttributeSet attributeSet, int[] iArr, int i2, int i3, l lVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            attributeSet = null;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = 0;
        }
        i0.f(context, "$receiver");
        i0.f(iArr, "attrs");
        i0.f(lVar, "block");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i2, i3);
        lVar.invoke(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
    }

    public static final void withStyledAttributes(@d Context context, @StyleRes int i2, @d int[] iArr, @d l<? super TypedArray, y1> lVar) throws Resources.NotFoundException {
        i0.f(context, "$receiver");
        i0.f(iArr, "attrs");
        i0.f(lVar, "block");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i2, iArr);
        lVar.invoke(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
    }
}
