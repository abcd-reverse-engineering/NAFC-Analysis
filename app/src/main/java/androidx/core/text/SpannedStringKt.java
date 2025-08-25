package androidx.core.text;

import android.text.Spanned;
import android.text.SpannedString;
import androidx.exifinterface.media.ExifInterface;
import h.q2.t.i0;
import h.y;
import i.c.a.d;

/* compiled from: SpannedString.kt */
@y(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\u001a:\u0010\u0000\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0086\b¢\u0006\u0002\u0010\b\u001a\r\u0010\t\u001a\u00020\u0004*\u00020\nH\u0086\b¨\u0006\u000b"}, d2 = {"getSpans", "", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroid/text/Spanned;", "start", "", "end", "(Landroid/text/Spanned;II)[Ljava/lang/Object;", "toSpanned", "", "core-ktx_release"}, k = 2, mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class SpannedStringKt {
    private static final <T> T[] getSpans(@d Spanned spanned, int i2, int i3) {
        i0.a(4, ExifInterface.GPS_DIRECTION_TRUE);
        T[] tArr = (T[]) spanned.getSpans(i2, i3, Object.class);
        i0.a((Object) tArr, "getSpans(start, end, T::class.java)");
        return tArr;
    }

    static /* bridge */ /* synthetic */ Object[] getSpans$default(Spanned spanned, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = spanned.length();
        }
        i0.a(4, ExifInterface.GPS_DIRECTION_TRUE);
        Object[] spans = spanned.getSpans(i2, i3, Object.class);
        i0.a((Object) spans, "getSpans(start, end, T::class.java)");
        return spans;
    }

    @d
    public static final Spanned toSpanned(@d CharSequence charSequence) {
        i0.f(charSequence, "$receiver");
        SpannedString spannedStringValueOf = SpannedString.valueOf(charSequence);
        i0.a((Object) spannedStringValueOf, "SpannedString.valueOf(this)");
        return spannedStringValueOf;
    }
}
