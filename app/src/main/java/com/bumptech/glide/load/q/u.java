package com.bumptech.glide.load.q;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.q.n;
import java.io.File;
import java.io.InputStream;

/* compiled from: StringLoader.java */
/* loaded from: classes.dex */
public class u<Data> implements n<String, Data> {

    /* renamed from: a, reason: collision with root package name */
    private final n<Uri, Data> f4781a;

    /* compiled from: StringLoader.java */
    public static final class a implements o<String, AssetFileDescriptor> {
        @Override // com.bumptech.glide.load.q.o
        public n<String, AssetFileDescriptor> a(@NonNull r rVar) {
            return new u(rVar.a(Uri.class, AssetFileDescriptor.class));
        }

        @Override // com.bumptech.glide.load.q.o
        public void a() {
        }
    }

    /* compiled from: StringLoader.java */
    public static class b implements o<String, ParcelFileDescriptor> {
        @Override // com.bumptech.glide.load.q.o
        @NonNull
        public n<String, ParcelFileDescriptor> a(@NonNull r rVar) {
            return new u(rVar.a(Uri.class, ParcelFileDescriptor.class));
        }

        @Override // com.bumptech.glide.load.q.o
        public void a() {
        }
    }

    /* compiled from: StringLoader.java */
    public static class c implements o<String, InputStream> {
        @Override // com.bumptech.glide.load.q.o
        @NonNull
        public n<String, InputStream> a(@NonNull r rVar) {
            return new u(rVar.a(Uri.class, InputStream.class));
        }

        @Override // com.bumptech.glide.load.q.o
        public void a() {
        }
    }

    public u(n<Uri, Data> nVar) {
        this.f4781a = nVar;
    }

    @Nullable
    private static Uri b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.charAt(0) == '/') {
            return c(str);
        }
        Uri uri = Uri.parse(str);
        return uri.getScheme() == null ? c(str) : uri;
    }

    private static Uri c(String str) {
        return Uri.fromFile(new File(str));
    }

    @Override // com.bumptech.glide.load.q.n
    public boolean a(@NonNull String str) {
        return true;
    }

    @Override // com.bumptech.glide.load.q.n
    public n.a<Data> a(@NonNull String str, int i2, int i3, @NonNull com.bumptech.glide.load.j jVar) {
        Uri uriB = b(str);
        if (uriB == null || !this.f4781a.a(uriB)) {
            return null;
        }
        return this.f4781a.a(uriB, i2, i3, jVar);
    }
}
