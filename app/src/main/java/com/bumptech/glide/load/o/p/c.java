package com.bumptech.glide.load.o.p;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.h;
import com.bumptech.glide.load.o.d;
import com.bumptech.glide.load.o.g;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ThumbFetcher.java */
/* loaded from: classes.dex */
public class c implements com.bumptech.glide.load.o.d<InputStream> {

    /* renamed from: d, reason: collision with root package name */
    private static final String f4302d = "MediaStoreThumbFetcher";

    /* renamed from: a, reason: collision with root package name */
    private final Uri f4303a;

    /* renamed from: b, reason: collision with root package name */
    private final e f4304b;

    /* renamed from: c, reason: collision with root package name */
    private InputStream f4305c;

    /* compiled from: ThumbFetcher.java */
    static class a implements d {

        /* renamed from: b, reason: collision with root package name */
        private static final String[] f4306b = {"_data"};

        /* renamed from: c, reason: collision with root package name */
        private static final String f4307c = "kind = 1 AND image_id = ?";

        /* renamed from: a, reason: collision with root package name */
        private final ContentResolver f4308a;

        a(ContentResolver contentResolver) {
            this.f4308a = contentResolver;
        }

        @Override // com.bumptech.glide.load.o.p.d
        public Cursor a(Uri uri) {
            return this.f4308a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, f4306b, f4307c, new String[]{uri.getLastPathSegment()}, null);
        }
    }

    /* compiled from: ThumbFetcher.java */
    static class b implements d {

        /* renamed from: b, reason: collision with root package name */
        private static final String[] f4309b = {"_data"};

        /* renamed from: c, reason: collision with root package name */
        private static final String f4310c = "kind = 1 AND video_id = ?";

        /* renamed from: a, reason: collision with root package name */
        private final ContentResolver f4311a;

        b(ContentResolver contentResolver) {
            this.f4311a = contentResolver;
        }

        @Override // com.bumptech.glide.load.o.p.d
        public Cursor a(Uri uri) {
            return this.f4311a.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, f4309b, f4310c, new String[]{uri.getLastPathSegment()}, null);
        }
    }

    @VisibleForTesting
    c(Uri uri, e eVar) {
        this.f4303a = uri;
        this.f4304b = eVar;
    }

    public static c a(Context context, Uri uri) {
        return a(context, uri, new a(context.getContentResolver()));
    }

    public static c b(Context context, Uri uri) {
        return a(context, uri, new b(context.getContentResolver()));
    }

    private InputStream d() throws Throwable {
        InputStream inputStreamB = this.f4304b.b(this.f4303a);
        int iA = inputStreamB != null ? this.f4304b.a(this.f4303a) : -1;
        return iA != -1 ? new g(inputStreamB, iA) : inputStreamB;
    }

    @Override // com.bumptech.glide.load.o.d
    @NonNull
    public com.bumptech.glide.load.a c() {
        return com.bumptech.glide.load.a.LOCAL;
    }

    @Override // com.bumptech.glide.load.o.d
    public void cancel() {
    }

    private static c a(Context context, Uri uri, d dVar) {
        return new c(uri, new e(com.bumptech.glide.b.a(context).h().a(), dVar, com.bumptech.glide.b.a(context).c(), context.getContentResolver()));
    }

    @Override // com.bumptech.glide.load.o.d
    public void b() throws IOException {
        InputStream inputStream = this.f4305c;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.bumptech.glide.load.o.d
    public void a(@NonNull h hVar, @NonNull d.a<? super InputStream> aVar) {
        try {
            this.f4305c = d();
            aVar.a((d.a<? super InputStream>) this.f4305c);
        } catch (FileNotFoundException e2) {
            Log.isLoggable(f4302d, 3);
            aVar.a((Exception) e2);
        }
    }

    @Override // com.bumptech.glide.load.o.d
    @NonNull
    public Class<InputStream> a() {
        return InputStream.class;
    }
}
