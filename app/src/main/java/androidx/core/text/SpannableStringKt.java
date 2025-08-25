package androidx.core.text;

import android.annotation.SuppressLint;
import android.text.Spannable;
import android.text.SpannableString;
import h.q2.t.i0;
import h.v2.k;
import h.y;
import i.c.a.d;

/* compiled from: SpannableString.kt */
@y(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a%\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086\n\u001a\u001d\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0086\n\u001a\r\u0010\u000b\u001a\u00020\u0002*\u00020\fH\u0086\b¨\u0006\r"}, d2 = {"clearSpans", "", "Landroid/text/Spannable;", "set", "start", "", "end", "span", "", "range", "Lkotlin/ranges/IntRange;", "toSpannable", "", "core-ktx_release"}, k = 2, mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class SpannableStringKt {
    @SuppressLint({"SyntheticAccessor"})
    public static final void clearSpans(@d Spannable spannable) {
        i0.f(spannable, "$receiver");
        Object[] spans = spannable.getSpans(0, spannable.length(), Object.class);
        i0.a((Object) spans, "getSpans(start, end, T::class.java)");
        for (Object obj : spans) {
            spannable.removeSpan(obj);
        }
    }

    public static final void set(@d Spannable spannable, int i2, int i3, @d Object obj) {
        i0.f(spannable, "$receiver");
        i0.f(obj, "span");
        spannable.setSpan(obj, i2, i3, 17);
    }

    @d
    public static final Spannable toSpannable(@d CharSequence charSequence) {
        i0.f(charSequence, "$receiver");
        SpannableString spannableStringValueOf = SpannableString.valueOf(charSequence);
        i0.a((Object) spannableStringValueOf, "SpannableString.valueOf(this)");
        return spannableStringValueOf;
    }

    public static final void set(@d Spannable spannable, @d k kVar, @d Object obj) {
        i0.f(spannable, "$receiver");
        i0.f(kVar, "range");
        i0.f(obj, "span");
        spannable.setSpan(obj, kVar.getStart().intValue(), kVar.getEndInclusive().intValue(), 17);
    }
}
