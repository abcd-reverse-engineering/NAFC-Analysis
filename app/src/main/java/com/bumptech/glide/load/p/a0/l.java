package com.bumptech.glide.load.p.a0;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;

/* compiled from: LruPoolStrategy.java */
/* loaded from: classes.dex */
interface l {
    @Nullable
    Bitmap a(int i2, int i3, Bitmap.Config config);

    void a(Bitmap bitmap);

    int b(Bitmap bitmap);

    String b(int i2, int i3, Bitmap.Config config);

    String c(Bitmap bitmap);

    @Nullable
    Bitmap removeLast();
}
