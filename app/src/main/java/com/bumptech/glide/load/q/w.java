package com.bumptech.glide.load.q;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.q.n;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: UriLoader.java */
/* loaded from: classes.dex */
public class w<Data> implements n<Uri, Data> {

    /* renamed from: b, reason: collision with root package name */
    private static final Set<String> f4785b = Collections.unmodifiableSet(new HashSet(Arrays.asList("file", "android.resource", "content")));

    /* renamed from: a, reason: collision with root package name */
    private final c<Data> f4786a;

    /* compiled from: UriLoader.java */
    public static final class a implements o<Uri, AssetFileDescriptor>, c<AssetFileDescriptor> {

        /* renamed from: a, reason: collision with root package name */
        private final ContentResolver f4787a;

        public a(ContentResolver contentResolver) {
            this.f4787a = contentResolver;
        }

        @Override // com.bumptech.glide.load.q.o
        public n<Uri, AssetFileDescriptor> a(r rVar) {
            return new w(this);
        }

        @Override // com.bumptech.glide.load.q.o
        public void a() {
        }

        @Override // com.bumptech.glide.load.q.w.c
        public com.bumptech.glide.load.o.d<AssetFileDescriptor> a(Uri uri) {
            return new com.bumptech.glide.load.o.a(this.f4787a, uri);
        }
    }

    /* compiled from: UriLoader.java */
    public static class b implements o<Uri, ParcelFileDescriptor>, c<ParcelFileDescriptor> {

        /* renamed from: a, reason: collision with root package name */
        private final ContentResolver f4788a;

        public b(ContentResolver contentResolver) {
            this.f4788a = contentResolver;
        }

        @Override // com.bumptech.glide.load.q.w.c
        public com.bumptech.glide.load.o.d<ParcelFileDescriptor> a(Uri uri) {
            return new com.bumptech.glide.load.o.i(this.f4788a, uri);
        }

        @Override // com.bumptech.glide.load.q.o
        public void a() {
        }

        @Override // com.bumptech.glide.load.q.o
        @NonNull
        public n<Uri, ParcelFileDescriptor> a(r rVar) {
            return new w(this);
        }
    }

    /* compiled from: UriLoader.java */
    public interface c<Data> {
        com.bumptech.glide.load.o.d<Data> a(Uri uri);
    }

    /* compiled from: UriLoader.java */
    public static class d implements o<Uri, InputStream>, c<InputStream> {

        /* renamed from: a, reason: collision with root package name */
        private final ContentResolver f4789a;

        public d(ContentResolver contentResolver) {
            this.f4789a = contentResolver;
        }

        @Override // com.bumptech.glide.load.q.w.c
        public com.bumptech.glide.load.o.d<InputStream> a(Uri uri) {
            return new com.bumptech.glide.load.o.o(this.f4789a, uri);
        }

        @Override // com.bumptech.glide.load.q.o
        public void a() {
        }

        @Override // com.bumptech.glide.load.q.o
        @NonNull
        public n<Uri, InputStream> a(r rVar) {
            return new w(this);
        }
    }

    public w(c<Data> cVar) {
        this.f4786a = cVar;
    }

    @Override // com.bumptech.glide.load.q.n
    public n.a<Data> a(@NonNull Uri uri, int i2, int i3, @NonNull com.bumptech.glide.load.j jVar) {
        return new n.a<>(new com.bumptech.glide.s.e(uri), this.f4786a.a(uri));
    }

    @Override // com.bumptech.glide.load.q.n
    public boolean a(@NonNull Uri uri) {
        return f4785b.contains(uri.getScheme());
    }
}
