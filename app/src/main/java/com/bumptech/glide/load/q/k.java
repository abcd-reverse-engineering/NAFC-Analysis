package com.bumptech.glide.load.q;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.o.d;
import com.bumptech.glide.load.q.n;
import java.io.File;
import java.io.FileNotFoundException;

/* compiled from: MediaStoreFileLoader.java */
/* loaded from: classes.dex */
public final class k implements n<Uri, File> {

    /* renamed from: a, reason: collision with root package name */
    private final Context f4735a;

    /* compiled from: MediaStoreFileLoader.java */
    public static final class a implements o<Uri, File> {

        /* renamed from: a, reason: collision with root package name */
        private final Context f4736a;

        public a(Context context) {
            this.f4736a = context;
        }

        @Override // com.bumptech.glide.load.q.o
        @NonNull
        public n<Uri, File> a(r rVar) {
            return new k(this.f4736a);
        }

        @Override // com.bumptech.glide.load.q.o
        public void a() {
        }
    }

    public k(Context context) {
        this.f4735a = context;
    }

    @Override // com.bumptech.glide.load.q.n
    public n.a<File> a(@NonNull Uri uri, int i2, int i3, @NonNull com.bumptech.glide.load.j jVar) {
        return new n.a<>(new com.bumptech.glide.s.e(uri), new b(this.f4735a, uri));
    }

    @Override // com.bumptech.glide.load.q.n
    public boolean a(@NonNull Uri uri) {
        return com.bumptech.glide.load.o.p.b.b(uri);
    }

    /* compiled from: MediaStoreFileLoader.java */
    private static class b implements com.bumptech.glide.load.o.d<File> {

        /* renamed from: c, reason: collision with root package name */
        private static final String[] f4737c = {"_data"};

        /* renamed from: a, reason: collision with root package name */
        private final Context f4738a;

        /* renamed from: b, reason: collision with root package name */
        private final Uri f4739b;

        b(Context context, Uri uri) {
            this.f4738a = context;
            this.f4739b = uri;
        }

        @Override // com.bumptech.glide.load.o.d
        public void a(@NonNull com.bumptech.glide.h hVar, @NonNull d.a<? super File> aVar) {
            Cursor cursorQuery = this.f4738a.getContentResolver().query(this.f4739b, f4737c, null, null, null);
            if (cursorQuery != null) {
                try {
                    string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data")) : null;
                } finally {
                    cursorQuery.close();
                }
            }
            if (!TextUtils.isEmpty(string)) {
                aVar.a((d.a<? super File>) new File(string));
                return;
            }
            aVar.a((Exception) new FileNotFoundException("Failed to find file path for: " + this.f4739b));
        }

        @Override // com.bumptech.glide.load.o.d
        public void b() {
        }

        @Override // com.bumptech.glide.load.o.d
        @NonNull
        public com.bumptech.glide.load.a c() {
            return com.bumptech.glide.load.a.LOCAL;
        }

        @Override // com.bumptech.glide.load.o.d
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.o.d
        @NonNull
        public Class<File> a() {
            return File.class;
        }
    }
}
