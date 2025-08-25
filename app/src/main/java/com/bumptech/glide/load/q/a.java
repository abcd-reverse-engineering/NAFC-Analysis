package com.bumptech.glide.load.q;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.q.n;
import java.io.InputStream;

/* compiled from: AssetUriLoader.java */
/* loaded from: classes.dex */
public class a<Data> implements n<Uri, Data> {

    /* renamed from: c, reason: collision with root package name */
    private static final String f4687c = "android_asset";

    /* renamed from: d, reason: collision with root package name */
    private static final String f4688d = "file:///android_asset/";

    /* renamed from: e, reason: collision with root package name */
    private static final int f4689e = 22;

    /* renamed from: a, reason: collision with root package name */
    private final AssetManager f4690a;

    /* renamed from: b, reason: collision with root package name */
    private final InterfaceC0067a<Data> f4691b;

    /* compiled from: AssetUriLoader.java */
    /* renamed from: com.bumptech.glide.load.q.a$a, reason: collision with other inner class name */
    public interface InterfaceC0067a<Data> {
        com.bumptech.glide.load.o.d<Data> a(AssetManager assetManager, String str);
    }

    /* compiled from: AssetUriLoader.java */
    public static class b implements o<Uri, ParcelFileDescriptor>, InterfaceC0067a<ParcelFileDescriptor> {

        /* renamed from: a, reason: collision with root package name */
        private final AssetManager f4692a;

        public b(AssetManager assetManager) {
            this.f4692a = assetManager;
        }

        @Override // com.bumptech.glide.load.q.o
        @NonNull
        public n<Uri, ParcelFileDescriptor> a(r rVar) {
            return new a(this.f4692a, this);
        }

        @Override // com.bumptech.glide.load.q.o
        public void a() {
        }

        @Override // com.bumptech.glide.load.q.a.InterfaceC0067a
        public com.bumptech.glide.load.o.d<ParcelFileDescriptor> a(AssetManager assetManager, String str) {
            return new com.bumptech.glide.load.o.h(assetManager, str);
        }
    }

    /* compiled from: AssetUriLoader.java */
    public static class c implements o<Uri, InputStream>, InterfaceC0067a<InputStream> {

        /* renamed from: a, reason: collision with root package name */
        private final AssetManager f4693a;

        public c(AssetManager assetManager) {
            this.f4693a = assetManager;
        }

        @Override // com.bumptech.glide.load.q.o
        @NonNull
        public n<Uri, InputStream> a(r rVar) {
            return new a(this.f4693a, this);
        }

        @Override // com.bumptech.glide.load.q.o
        public void a() {
        }

        @Override // com.bumptech.glide.load.q.a.InterfaceC0067a
        public com.bumptech.glide.load.o.d<InputStream> a(AssetManager assetManager, String str) {
            return new com.bumptech.glide.load.o.n(assetManager, str);
        }
    }

    public a(AssetManager assetManager, InterfaceC0067a<Data> interfaceC0067a) {
        this.f4690a = assetManager;
        this.f4691b = interfaceC0067a;
    }

    @Override // com.bumptech.glide.load.q.n
    public n.a<Data> a(@NonNull Uri uri, int i2, int i3, @NonNull com.bumptech.glide.load.j jVar) {
        return new n.a<>(new com.bumptech.glide.s.e(uri), this.f4691b.a(this.f4690a, uri.toString().substring(f4689e)));
    }

    @Override // com.bumptech.glide.load.q.n
    public boolean a(@NonNull Uri uri) {
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && f4687c.equals(uri.getPathSegments().get(0));
    }
}
