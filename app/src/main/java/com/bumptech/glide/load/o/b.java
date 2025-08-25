package com.bumptech.glide.load.o;

import android.content.res.AssetManager;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.o.d;
import java.io.IOException;

/* compiled from: AssetPathFetcher.java */
/* loaded from: classes.dex */
public abstract class b<T> implements d<T> {

    /* renamed from: d, reason: collision with root package name */
    private static final String f4258d = "AssetPathFetcher";

    /* renamed from: a, reason: collision with root package name */
    private final String f4259a;

    /* renamed from: b, reason: collision with root package name */
    private final AssetManager f4260b;

    /* renamed from: c, reason: collision with root package name */
    private T f4261c;

    public b(AssetManager assetManager, String str) {
        this.f4260b = assetManager;
        this.f4259a = str;
    }

    protected abstract T a(AssetManager assetManager, String str) throws IOException;

    @Override // com.bumptech.glide.load.o.d
    public void a(@NonNull com.bumptech.glide.h hVar, @NonNull d.a<? super T> aVar) {
        try {
            this.f4261c = a(this.f4260b, this.f4259a);
            aVar.a((d.a<? super T>) this.f4261c);
        } catch (IOException e2) {
            Log.isLoggable(f4258d, 3);
            aVar.a((Exception) e2);
        }
    }

    protected abstract void a(T t) throws IOException;

    @Override // com.bumptech.glide.load.o.d
    public void b() {
        T t = this.f4261c;
        if (t == null) {
            return;
        }
        try {
            a(t);
        } catch (IOException unused) {
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
