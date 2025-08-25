package com.bumptech.glide.load.q;

import android.util.Log;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: ByteBufferEncoder.java */
/* loaded from: classes.dex */
public class c implements com.bumptech.glide.load.d<ByteBuffer> {

    /* renamed from: a, reason: collision with root package name */
    private static final String f4699a = "ByteBufferEncoder";

    @Override // com.bumptech.glide.load.d
    public boolean a(@NonNull ByteBuffer byteBuffer, @NonNull File file, @NonNull com.bumptech.glide.load.j jVar) throws Throwable {
        try {
            com.bumptech.glide.util.a.a(byteBuffer, file);
            return true;
        } catch (IOException unused) {
            Log.isLoggable(f4699a, 3);
            return false;
        }
    }
}
