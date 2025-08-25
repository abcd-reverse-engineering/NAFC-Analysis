package androidx.core.text;

import android.icu.util.ULocale;
import android.os.Build;
import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* loaded from: classes.dex */
public final class ICUCompat {
    private static final String TAG = "ICUCompat";
    private static Method sAddLikelySubtagsMethod;
    private static Method sGetScriptMethod;

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            if (i2 < 24) {
                try {
                    sAddLikelySubtagsMethod = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", Locale.class);
                    return;
                } catch (Exception e2) {
                    throw new IllegalStateException(e2);
                }
            }
            return;
        }
        try {
            Class<?> cls = Class.forName("libcore.icu.ICU");
            if (cls != null) {
                sGetScriptMethod = cls.getMethod("getScript", String.class);
                sAddLikelySubtagsMethod = cls.getMethod("addLikelySubtags", String.class);
            }
        } catch (Exception unused) {
            sGetScriptMethod = null;
            sAddLikelySubtagsMethod = null;
        }
    }

    private ICUCompat() {
    }

    private static String addLikelySubtags(Locale locale) {
        String string = locale.toString();
        try {
            if (sAddLikelySubtagsMethod != null) {
                return (String) sAddLikelySubtagsMethod.invoke(null, string);
            }
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
        return string;
    }

    private static String getScript(String str) {
        try {
            if (sGetScriptMethod != null) {
                return (String) sGetScriptMethod.invoke(null, str);
            }
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
        return null;
    }

    @Nullable
    public static String maximizeAndGetScript(Locale locale) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 24) {
            return ULocale.addLikelySubtags(ULocale.forLocale(locale)).getScript();
        }
        if (i2 >= 21) {
            try {
                return ((Locale) sAddLikelySubtagsMethod.invoke(null, locale)).getScript();
            } catch (IllegalAccessException | InvocationTargetException unused) {
                return locale.getScript();
            }
        }
        String strAddLikelySubtags = addLikelySubtags(locale);
        if (strAddLikelySubtags != null) {
            return getScript(strAddLikelySubtags);
        }
        return null;
    }
}
