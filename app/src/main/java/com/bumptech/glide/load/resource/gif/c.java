package com.bumptech.glide.load.resource.gif;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.m;
import com.bumptech.glide.load.p.v;
import java.io.File;
import java.io.IOException;

/* compiled from: GifDrawableEncoder.java */
/* loaded from: classes.dex */
public class c implements m<GifDrawable> {

    /* renamed from: a, reason: collision with root package name */
    private static final String f5021a = "GifEncoder";

    @Override // com.bumptech.glide.load.m
    @NonNull
    public com.bumptech.glide.load.c a(@NonNull j jVar) {
        return com.bumptech.glide.load.c.SOURCE;
    }

    @Override // com.bumptech.glide.load.d
    public boolean a(@NonNull v<GifDrawable> vVar, @NonNull File file, @NonNull j jVar) throws Throwable {
        try {
            com.bumptech.glide.util.a.a(vVar.get().b(), file);
            return true;
        } catch (IOException unused) {
            Log.isLoggable(f5021a, 5);
            return false;
        }
    }
}
