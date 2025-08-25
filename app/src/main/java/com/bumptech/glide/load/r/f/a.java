package com.bumptech.glide.load.r.f;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

/* compiled from: DrawableDecoderCompat.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f4975a = true;

    private a() {
    }

    public static Drawable a(Context context, Context context2, @DrawableRes int i2) {
        return a(context, context2, i2, null);
    }

    private static Drawable b(Context context, @DrawableRes int i2, @Nullable Resources.Theme theme) {
        return ResourcesCompat.getDrawable(context.getResources(), i2, theme);
    }

    private static Drawable c(Context context, @DrawableRes int i2, @Nullable Resources.Theme theme) {
        if (theme != null) {
            context = new ContextThemeWrapper(context, theme);
        }
        return AppCompatResources.getDrawable(context, i2);
    }

    public static Drawable a(Context context, @DrawableRes int i2, @Nullable Resources.Theme theme) {
        return a(context, context, i2, theme);
    }

    private static Drawable a(Context context, Context context2, @DrawableRes int i2, @Nullable Resources.Theme theme) {
        try {
            if (f4975a) {
                return c(context2, i2, theme);
            }
        } catch (Resources.NotFoundException unused) {
        } catch (IllegalStateException e2) {
            if (!context.getPackageName().equals(context2.getPackageName())) {
                return ContextCompat.getDrawable(context2, i2);
            }
            throw e2;
        } catch (NoClassDefFoundError unused2) {
            f4975a = false;
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        return b(context2, i2, theme);
    }
}
