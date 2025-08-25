package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import androidx.annotation.AnyRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.FontRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class ResourcesCompat {

    @AnyRes
    public static final int ID_NULL = 0;
    private static final String TAG = "ResourcesCompat";

    public static abstract class FontCallback {
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public final void callbackFailAsync(final int i2, @Nullable Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new Runnable() { // from class: androidx.core.content.res.ResourcesCompat.FontCallback.2
                @Override // java.lang.Runnable
                public void run() {
                    FontCallback.this.onFontRetrievalFailed(i2);
                }
            });
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public final void callbackSuccessAsync(final Typeface typeface, @Nullable Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new Runnable() { // from class: androidx.core.content.res.ResourcesCompat.FontCallback.1
                @Override // java.lang.Runnable
                public void run() {
                    FontCallback.this.onFontRetrieved(typeface);
                }
            });
        }

        public abstract void onFontRetrievalFailed(int i2);

        public abstract void onFontRetrieved(@NonNull Typeface typeface);
    }

    public static final class ThemeCompat {

        @RequiresApi(23)
        static class ImplApi23 {
            private static Method sRebaseMethod;
            private static boolean sRebaseMethodFetched;
            private static final Object sRebaseMethodLock = new Object();

            private ImplApi23() {
            }

            static void rebase(@NonNull Resources.Theme theme) {
                synchronized (sRebaseMethodLock) {
                    if (!sRebaseMethodFetched) {
                        try {
                            sRebaseMethod = Resources.Theme.class.getDeclaredMethod("rebase", new Class[0]);
                            sRebaseMethod.setAccessible(true);
                        } catch (NoSuchMethodException unused) {
                        }
                        sRebaseMethodFetched = true;
                    }
                    if (sRebaseMethod != null) {
                        try {
                            sRebaseMethod.invoke(theme, new Object[0]);
                        } catch (IllegalAccessException | InvocationTargetException unused2) {
                            sRebaseMethod = null;
                        }
                    }
                }
            }
        }

        @RequiresApi(29)
        static class ImplApi29 {
            private ImplApi29() {
            }

            static void rebase(@NonNull Resources.Theme theme) {
                theme.rebase();
            }
        }

        private ThemeCompat() {
        }

        public static void rebase(@NonNull Resources.Theme theme) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 29) {
                ImplApi29.rebase(theme);
            } else if (i2 >= 23) {
                ImplApi23.rebase(theme);
            }
        }
    }

    private ResourcesCompat() {
    }

    @ColorInt
    public static int getColor(@NonNull Resources resources, @ColorRes int i2, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        return Build.VERSION.SDK_INT >= 23 ? resources.getColor(i2, theme) : resources.getColor(i2);
    }

    @Nullable
    public static ColorStateList getColorStateList(@NonNull Resources resources, @ColorRes int i2, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        return Build.VERSION.SDK_INT >= 23 ? resources.getColorStateList(i2, theme) : resources.getColorStateList(i2);
    }

    @Nullable
    public static Drawable getDrawable(@NonNull Resources resources, @DrawableRes int i2, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        return Build.VERSION.SDK_INT >= 21 ? resources.getDrawable(i2, theme) : resources.getDrawable(i2);
    }

    @Nullable
    public static Drawable getDrawableForDensity(@NonNull Resources resources, @DrawableRes int i2, int i3, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        int i4 = Build.VERSION.SDK_INT;
        return i4 >= 21 ? resources.getDrawableForDensity(i2, i3, theme) : i4 >= 15 ? resources.getDrawableForDensity(i2, i3) : resources.getDrawable(i2);
    }

    public static float getFloat(@NonNull Resources resources, @DimenRes int i2) throws Resources.NotFoundException {
        TypedValue typedValue = new TypedValue();
        resources.getValue(i2, typedValue, true);
        if (typedValue.type == 4) {
            return typedValue.getFloat();
        }
        throw new Resources.NotFoundException("Resource ID #0x" + Integer.toHexString(i2) + " type #0x" + Integer.toHexString(typedValue.type) + " is not valid");
    }

    @Nullable
    public static Typeface getFont(@NonNull Context context, @FontRes int i2) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return loadFont(context, i2, new TypedValue(), 0, null, null, false);
    }

    private static Typeface loadFont(@NonNull Context context, int i2, TypedValue typedValue, int i3, @Nullable FontCallback fontCallback, @Nullable Handler handler, boolean z) throws Resources.NotFoundException {
        Resources resources = context.getResources();
        resources.getValue(i2, typedValue, true);
        Typeface typefaceLoadFont = loadFont(context, resources, typedValue, i2, i3, fontCallback, handler, z);
        if (typefaceLoadFont != null || fontCallback != null) {
            return typefaceLoadFont;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i2) + " could not be retrieved.");
    }

    public static void getFont(@NonNull Context context, @FontRes int i2, @NonNull FontCallback fontCallback, @Nullable Handler handler) throws Resources.NotFoundException {
        Preconditions.checkNotNull(fontCallback);
        if (context.isRestricted()) {
            fontCallback.callbackFailAsync(-4, handler);
        } else {
            loadFont(context, i2, new TypedValue(), 0, fontCallback, handler, false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.graphics.Typeface loadFont(@androidx.annotation.NonNull android.content.Context r13, android.content.res.Resources r14, android.util.TypedValue r15, int r16, int r17, @androidx.annotation.Nullable androidx.core.content.res.ResourcesCompat.FontCallback r18, @androidx.annotation.Nullable android.os.Handler r19, boolean r20) {
        /*
            r2 = r14
            r0 = r15
            r3 = r16
            r4 = r17
            r8 = r18
            r9 = r19
            java.lang.CharSequence r1 = r0.string
            if (r1 == 0) goto L93
            java.lang.String r10 = r1.toString()
            java.lang.String r0 = "res/"
            boolean r0 = r10.startsWith(r0)
            r11 = 0
            r12 = -3
            if (r0 != 0) goto L22
            if (r8 == 0) goto L21
            r8.callbackFailAsync(r12, r9)
        L21:
            return r11
        L22:
            android.graphics.Typeface r0 = androidx.core.graphics.TypefaceCompat.findFromCache(r14, r3, r4)
            if (r0 == 0) goto L2e
            if (r8 == 0) goto L2d
            r8.callbackSuccessAsync(r0, r9)
        L2d:
            return r0
        L2e:
            java.lang.String r0 = r10.toLowerCase()     // Catch: java.io.IOException -> L6c org.xmlpull.v1.XmlPullParserException -> L7d
            java.lang.String r1 = ".xml"
            boolean r0 = r0.endsWith(r1)     // Catch: java.io.IOException -> L6c org.xmlpull.v1.XmlPullParserException -> L7d
            if (r0 == 0) goto L5b
            android.content.res.XmlResourceParser r0 = r14.getXml(r3)     // Catch: java.io.IOException -> L6c org.xmlpull.v1.XmlPullParserException -> L7d
            androidx.core.content.res.FontResourcesParserCompat$FamilyResourceEntry r1 = androidx.core.content.res.FontResourcesParserCompat.parse(r0, r14)     // Catch: java.io.IOException -> L6c org.xmlpull.v1.XmlPullParserException -> L7d
            if (r1 != 0) goto L4a
            if (r8 == 0) goto L49
            r8.callbackFailAsync(r12, r9)     // Catch: java.io.IOException -> L6c org.xmlpull.v1.XmlPullParserException -> L7d
        L49:
            return r11
        L4a:
            r0 = r13
            r2 = r14
            r3 = r16
            r4 = r17
            r5 = r18
            r6 = r19
            r7 = r20
            android.graphics.Typeface r0 = androidx.core.graphics.TypefaceCompat.createFromResourcesFamilyXml(r0, r1, r2, r3, r4, r5, r6, r7)     // Catch: java.io.IOException -> L6c org.xmlpull.v1.XmlPullParserException -> L7d
            return r0
        L5b:
            r0 = r13
            android.graphics.Typeface r0 = androidx.core.graphics.TypefaceCompat.createFromResourcesFontFile(r13, r14, r3, r10, r4)     // Catch: java.io.IOException -> L6c org.xmlpull.v1.XmlPullParserException -> L7d
            if (r8 == 0) goto L6b
            if (r0 == 0) goto L68
            r8.callbackSuccessAsync(r0, r9)     // Catch: java.io.IOException -> L6c org.xmlpull.v1.XmlPullParserException -> L7d
            goto L6b
        L68:
            r8.callbackFailAsync(r12, r9)     // Catch: java.io.IOException -> L6c org.xmlpull.v1.XmlPullParserException -> L7d
        L6b:
            return r0
        L6c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Failed to read xml resource "
            r0.append(r1)
            r0.append(r10)
            r0.toString()
            goto L8d
        L7d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Failed to parse xml resource "
            r0.append(r1)
            r0.append(r10)
            r0.toString()
        L8d:
            if (r8 == 0) goto L92
            r8.callbackFailAsync(r12, r9)
        L92:
            return r11
        L93:
            android.content.res.Resources$NotFoundException r1 = new android.content.res.Resources$NotFoundException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Resource \""
            r4.append(r5)
            java.lang.String r2 = r14.getResourceName(r3)
            r4.append(r2)
            java.lang.String r2 = "\" ("
            r4.append(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r16)
            r4.append(r2)
            java.lang.String r2 = ") is not a Font: "
            r4.append(r2)
            r4.append(r15)
            java.lang.String r0 = r4.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.ResourcesCompat.loadFont(android.content.Context, android.content.res.Resources, android.util.TypedValue, int, int, androidx.core.content.res.ResourcesCompat$FontCallback, android.os.Handler, boolean):android.graphics.Typeface");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Typeface getFont(@NonNull Context context, @FontRes int i2, TypedValue typedValue, int i3, @Nullable FontCallback fontCallback) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return loadFont(context, i2, typedValue, i3, fontCallback, null, true);
    }
}
