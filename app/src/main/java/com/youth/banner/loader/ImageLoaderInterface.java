package com.youth.banner.loader;

import android.content.Context;
import android.view.View;
import java.io.Serializable;

/* loaded from: classes2.dex */
public interface ImageLoaderInterface<T extends View> extends Serializable {
    T createImageView(Context context);

    void displayImage(Context context, Object obj, T t);
}
