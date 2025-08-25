package androidx.core.text;

import android.text.Html;
import android.text.Spanned;
import com.taobao.accs.common.Constants;
import h.q2.t.i0;
import h.y;
import i.c.a.d;
import i.c.a.e;

/* compiled from: Html.kt */
@y(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a/\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0086\b\u001a\u0017\u0010\t\u001a\u00020\u0002*\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u0004H\u0086\b¨\u0006\u000b"}, d2 = {"parseAsHtml", "Landroid/text/Spanned;", "", Constants.KEY_FLAGS, "", "imageGetter", "Landroid/text/Html$ImageGetter;", "tagHandler", "Landroid/text/Html$TagHandler;", "toHtml", "option", "core-ktx_release"}, k = 2, mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class HtmlKt {
    @d
    public static final Spanned parseAsHtml(@d String str, int i2, @e Html.ImageGetter imageGetter, @e Html.TagHandler tagHandler) {
        i0.f(str, "$receiver");
        Spanned spannedFromHtml = HtmlCompat.fromHtml(str, i2, imageGetter, tagHandler);
        i0.a((Object) spannedFromHtml, "HtmlCompat.fromHtml(this… imageGetter, tagHandler)");
        return spannedFromHtml;
    }

    @d
    public static /* bridge */ /* synthetic */ Spanned parseAsHtml$default(String str, int i2, Html.ImageGetter imageGetter, Html.TagHandler tagHandler, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        if ((i3 & 2) != 0) {
            imageGetter = null;
        }
        if ((i3 & 4) != 0) {
            tagHandler = null;
        }
        i0.f(str, "$receiver");
        Spanned spannedFromHtml = HtmlCompat.fromHtml(str, i2, imageGetter, tagHandler);
        i0.a((Object) spannedFromHtml, "HtmlCompat.fromHtml(this… imageGetter, tagHandler)");
        return spannedFromHtml;
    }

    @d
    public static final String toHtml(@d Spanned spanned, int i2) {
        i0.f(spanned, "$receiver");
        String html = HtmlCompat.toHtml(spanned, i2);
        i0.a((Object) html, "HtmlCompat.toHtml(this, option)");
        return html;
    }

    @d
    public static /* bridge */ /* synthetic */ String toHtml$default(Spanned spanned, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        i0.f(spanned, "$receiver");
        String html = HtmlCompat.toHtml(spanned, i2);
        i0.a((Object) html, "HtmlCompat.toHtml(this, option)");
        return html;
    }
}
