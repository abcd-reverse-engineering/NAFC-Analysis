package com.bumptech.glide.load.resource.gif;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.l;
import com.bumptech.glide.load.p.v;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: StreamGifDecoder.java */
/* loaded from: classes.dex */
public class i implements l<InputStream, GifDrawable> {

    /* renamed from: d, reason: collision with root package name */
    private static final String f5046d = "StreamGifDecoder";

    /* renamed from: a, reason: collision with root package name */
    private final List<ImageHeaderParser> f5047a;

    /* renamed from: b, reason: collision with root package name */
    private final l<ByteBuffer, GifDrawable> f5048b;

    /* renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.p.a0.b f5049c;

    public i(List<ImageHeaderParser> list, l<ByteBuffer, GifDrawable> lVar, com.bumptech.glide.load.p.a0.b bVar) {
        this.f5047a = list;
        this.f5048b = lVar;
        this.f5049c = bVar;
    }

    @Override // com.bumptech.glide.load.l
    public boolean a(@NonNull InputStream inputStream, @NonNull j jVar) throws IOException {
        return !((Boolean) jVar.a(h.f5045b)).booleanValue() && com.bumptech.glide.load.f.b(this.f5047a, inputStream, this.f5049c) == ImageHeaderParser.ImageType.GIF;
    }

    @Override // com.bumptech.glide.load.l
    public v<GifDrawable> a(@NonNull InputStream inputStream, int i2, int i3, @NonNull j jVar) throws IOException {
        byte[] bArrA = a(inputStream);
        if (bArrA == null) {
            return null;
        }
        return this.f5048b.a(ByteBuffer.wrap(bArrA), i2, i3, jVar);
    }

    private static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int i2 = inputStream.read(bArr);
                if (i2 != -1) {
                    byteArrayOutputStream.write(bArr, 0, i2);
                } else {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException unused) {
            Log.isLoggable(f5046d, 5);
            return null;
        }
    }
}
