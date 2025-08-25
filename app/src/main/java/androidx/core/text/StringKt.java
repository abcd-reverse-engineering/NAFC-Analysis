package androidx.core.text;

import android.text.TextUtils;
import h.q2.t.i0;
import h.y;
import i.c.a.d;

/* compiled from: String.kt */
@y(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0086\b¨\u0006\u0002"}, d2 = {"htmlEncode", "", "core-ktx_release"}, k = 2, mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class StringKt {
    @d
    public static final String htmlEncode(@d String str) {
        i0.f(str, "$receiver");
        String strHtmlEncode = TextUtils.htmlEncode(str);
        i0.a((Object) strHtmlEncode, "TextUtils.htmlEncode(this)");
        return strHtmlEncode;
    }
}
