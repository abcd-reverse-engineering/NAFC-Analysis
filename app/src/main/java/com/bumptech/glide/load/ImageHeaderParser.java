package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public interface ImageHeaderParser {

    /* renamed from: a, reason: collision with root package name */
    public static final int f4235a = -1;

    public enum ImageType {
        GIF(true),
        JPEG(false),
        RAW(false),
        PNG_A(true),
        PNG(false),
        WEBP_A(true),
        WEBP(false),
        UNKNOWN(false);

        private final boolean hasAlpha;

        ImageType(boolean z) {
            this.hasAlpha = z;
        }

        public boolean hasAlpha() {
            return this.hasAlpha;
        }
    }

    int a(@NonNull InputStream inputStream, @NonNull com.bumptech.glide.load.p.a0.b bVar) throws IOException;

    int a(@NonNull ByteBuffer byteBuffer, @NonNull com.bumptech.glide.load.p.a0.b bVar) throws IOException;

    @NonNull
    ImageType a(@NonNull InputStream inputStream) throws IOException;

    @NonNull
    ImageType a(@NonNull ByteBuffer byteBuffer) throws IOException;
}
