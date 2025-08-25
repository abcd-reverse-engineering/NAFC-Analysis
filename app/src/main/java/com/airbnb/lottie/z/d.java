package com.airbnb.lottie.z;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: LottieFetchResult.java */
/* loaded from: classes.dex */
public interface d extends Closeable {
    @Nullable
    String a();

    @NonNull
    InputStream b() throws IOException;

    @Nullable
    String contentType();

    boolean isSuccessful();
}
