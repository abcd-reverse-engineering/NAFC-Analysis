package com.bumptech.glide.load.o;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.o.d;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: LocalUriFetcher.java */
/* loaded from: classes.dex */
public abstract class l<T> implements d<T> {

    /* renamed from: d, reason: collision with root package name */
    private static final String f4288d = "LocalUriFetcher";

    /* renamed from: a, reason: collision with root package name */
    private final Uri f4289a;

    /* renamed from: b, reason: collision with root package name */
    private final ContentResolver f4290b;

    /* renamed from: c, reason: collision with root package name */
    private T f4291c;

    public l(ContentResolver contentResolver, Uri uri) {
        this.f4290b = contentResolver;
        this.f4289a = uri;
    }

    protected abstract T a(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;

    @Override // com.bumptech.glide.load.o.d
    public final void a(@NonNull com.bumptech.glide.h hVar, @NonNull d.a<? super T> aVar) {
        try {
            this.f4291c = a(this.f4289a, this.f4290b);
            aVar.a((d.a<? super T>) this.f4291c);
        } catch (FileNotFoundException e2) {
            Log.isLoggable(f4288d, 3);
            aVar.a((Exception) e2);
        }
    }

    protected abstract void a(T t) throws IOException;

    @Override // com.bumptech.glide.load.o.d
    public void b() {
        T t = this.f4291c;
        if (t != null) {
            try {
                a(t);
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.bumptech.glide.load.o.d
    @NonNull
    public com.bumptech.glide.load.a c() {
        return com.bumptech.glide.load.a.LOCAL;
    }

    @Override // com.bumptech.glide.load.o.d
    public void cancel() {
    }
}
