package androidx.core.text;

import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import h.q2.t.i0;
import h.y;
import i.c.a.d;
import java.util.Locale;

/* compiled from: Locale.kt */
@y(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"layoutDirection", "", "Ljava/util/Locale;", "getLayoutDirection", "(Ljava/util/Locale;)I", "core-ktx_release"}, k = 2, mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class LocaleKt {
    @RequiresApi(17)
    public static final int getLayoutDirection(@d Locale locale) {
        i0.f(locale, "$receiver");
        return TextUtils.getLayoutDirectionFromLocale(locale);
    }
}
