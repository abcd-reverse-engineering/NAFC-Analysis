package com.bumptech.glide;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import java.io.File;
import java.net.URL;

/* compiled from: ModelTypes.java */
/* loaded from: classes.dex */
interface g<T> {
    @NonNull
    @CheckResult
    T a(@Nullable Bitmap bitmap);

    @NonNull
    @CheckResult
    T a(@Nullable Uri uri);

    @NonNull
    @CheckResult
    T a(@Nullable File file);

    @NonNull
    @CheckResult
    T a(@Nullable @DrawableRes @RawRes Integer num);

    @NonNull
    @CheckResult
    T a(@Nullable Object obj);

    @NonNull
    @CheckResult
    T a(@Nullable String str);

    @CheckResult
    @Deprecated
    T a(@Nullable URL url);

    @NonNull
    @CheckResult
    T a(@Nullable byte[] bArr);

    @NonNull
    @CheckResult
    T d(@Nullable Drawable drawable);
}
