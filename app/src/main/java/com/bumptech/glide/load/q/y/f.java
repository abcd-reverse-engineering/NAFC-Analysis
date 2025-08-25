package com.bumptech.glide.load.q.y;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.h;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.o.d;
import com.bumptech.glide.load.q.n;
import com.bumptech.glide.load.q.o;
import com.bumptech.glide.load.q.r;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

/* compiled from: QMediaStoreUriLoader.java */
@RequiresApi(29)
/* loaded from: classes.dex */
public final class f<DataT> implements n<Uri, DataT> {

    /* renamed from: a, reason: collision with root package name */
    private final Context f4803a;

    /* renamed from: b, reason: collision with root package name */
    private final n<File, DataT> f4804b;

    /* renamed from: c, reason: collision with root package name */
    private final n<Uri, DataT> f4805c;

    /* renamed from: d, reason: collision with root package name */
    private final Class<DataT> f4806d;

    /* compiled from: QMediaStoreUriLoader.java */
    private static abstract class a<DataT> implements o<Uri, DataT> {

        /* renamed from: a, reason: collision with root package name */
        private final Context f4807a;

        /* renamed from: b, reason: collision with root package name */
        private final Class<DataT> f4808b;

        a(Context context, Class<DataT> cls) {
            this.f4807a = context;
            this.f4808b = cls;
        }

        @Override // com.bumptech.glide.load.q.o
        @NonNull
        public final n<Uri, DataT> a(@NonNull r rVar) {
            return new f(this.f4807a, rVar.a(File.class, this.f4808b), rVar.a(Uri.class, this.f4808b), this.f4808b);
        }

        @Override // com.bumptech.glide.load.q.o
        public final void a() {
        }
    }

    /* compiled from: QMediaStoreUriLoader.java */
    @RequiresApi(29)
    public static final class b extends a<ParcelFileDescriptor> {
        public b(Context context) {
            super(context, ParcelFileDescriptor.class);
        }
    }

    /* compiled from: QMediaStoreUriLoader.java */
    @RequiresApi(29)
    public static final class c extends a<InputStream> {
        public c(Context context) {
            super(context, InputStream.class);
        }
    }

    f(Context context, n<File, DataT> nVar, n<Uri, DataT> nVar2, Class<DataT> cls) {
        this.f4803a = context.getApplicationContext();
        this.f4804b = nVar;
        this.f4805c = nVar2;
        this.f4806d = cls;
    }

    @Override // com.bumptech.glide.load.q.n
    public n.a<DataT> a(@NonNull Uri uri, int i2, int i3, @NonNull j jVar) {
        return new n.a<>(new com.bumptech.glide.s.e(uri), new d(this.f4803a, this.f4804b, this.f4805c, uri, i2, i3, jVar, this.f4806d));
    }

    @Override // com.bumptech.glide.load.q.n
    public boolean a(@NonNull Uri uri) {
        return Build.VERSION.SDK_INT >= 29 && com.bumptech.glide.load.o.p.b.b(uri);
    }

    /* compiled from: QMediaStoreUriLoader.java */
    private static final class d<DataT> implements com.bumptech.glide.load.o.d<DataT> {

        /* renamed from: k, reason: collision with root package name */
        private static final String[] f4809k = {"_data"};

        /* renamed from: a, reason: collision with root package name */
        private final Context f4810a;

        /* renamed from: b, reason: collision with root package name */
        private final n<File, DataT> f4811b;

        /* renamed from: c, reason: collision with root package name */
        private final n<Uri, DataT> f4812c;

        /* renamed from: d, reason: collision with root package name */
        private final Uri f4813d;

        /* renamed from: e, reason: collision with root package name */
        private final int f4814e;

        /* renamed from: f, reason: collision with root package name */
        private final int f4815f;

        /* renamed from: g, reason: collision with root package name */
        private final j f4816g;

        /* renamed from: h, reason: collision with root package name */
        private final Class<DataT> f4817h;

        /* renamed from: i, reason: collision with root package name */
        private volatile boolean f4818i;

        /* renamed from: j, reason: collision with root package name */
        @Nullable
        private volatile com.bumptech.glide.load.o.d<DataT> f4819j;

        d(Context context, n<File, DataT> nVar, n<Uri, DataT> nVar2, Uri uri, int i2, int i3, j jVar, Class<DataT> cls) {
            this.f4810a = context.getApplicationContext();
            this.f4811b = nVar;
            this.f4812c = nVar2;
            this.f4813d = uri;
            this.f4814e = i2;
            this.f4815f = i3;
            this.f4816g = jVar;
            this.f4817h = cls;
        }

        @Nullable
        private n.a<DataT> d() throws FileNotFoundException {
            if (Environment.isExternalStorageLegacy()) {
                return this.f4811b.a(a(this.f4813d), this.f4814e, this.f4815f, this.f4816g);
            }
            return this.f4812c.a(f() ? MediaStore.setRequireOriginal(this.f4813d) : this.f4813d, this.f4814e, this.f4815f, this.f4816g);
        }

        @Nullable
        private com.bumptech.glide.load.o.d<DataT> e() throws FileNotFoundException {
            n.a<DataT> aVarD = d();
            if (aVarD != null) {
                return aVarD.f4749c;
            }
            return null;
        }

        private boolean f() {
            return this.f4810a.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION") == 0;
        }

        @Override // com.bumptech.glide.load.o.d
        public void a(@NonNull h hVar, @NonNull d.a<? super DataT> aVar) {
            try {
                com.bumptech.glide.load.o.d<DataT> dVarE = e();
                if (dVarE == null) {
                    aVar.a((Exception) new IllegalArgumentException("Failed to build fetcher for: " + this.f4813d));
                    return;
                }
                this.f4819j = dVarE;
                if (this.f4818i) {
                    cancel();
                } else {
                    dVarE.a(hVar, aVar);
                }
            } catch (FileNotFoundException e2) {
                aVar.a((Exception) e2);
            }
        }

        @Override // com.bumptech.glide.load.o.d
        public void b() {
            com.bumptech.glide.load.o.d<DataT> dVar = this.f4819j;
            if (dVar != null) {
                dVar.b();
            }
        }

        @Override // com.bumptech.glide.load.o.d
        @NonNull
        public com.bumptech.glide.load.a c() {
            return com.bumptech.glide.load.a.LOCAL;
        }

        @Override // com.bumptech.glide.load.o.d
        public void cancel() {
            this.f4818i = true;
            com.bumptech.glide.load.o.d<DataT> dVar = this.f4819j;
            if (dVar != null) {
                dVar.cancel();
            }
        }

        @Override // com.bumptech.glide.load.o.d
        @NonNull
        public Class<DataT> a() {
            return this.f4817h;
        }

        @NonNull
        private File a(Uri uri) throws FileNotFoundException {
            Cursor cursor = null;
            try {
                Cursor cursorQuery = this.f4810a.getContentResolver().query(uri, f4809k, null, null, null);
                if (cursorQuery != null && cursorQuery.moveToFirst()) {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                    if (!TextUtils.isEmpty(string)) {
                        File file = new File(string);
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return file;
                    }
                    throw new FileNotFoundException("File path was empty in media store for: " + uri);
                }
                throw new FileNotFoundException("Failed to media store entry for: " + uri);
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
        }
    }
}
