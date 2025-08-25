package com.bumptech.glide.load.o.p;

import android.content.ContentResolver;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.f;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* compiled from: ThumbnailStreamOpener.java */
/* loaded from: classes.dex */
class e {

    /* renamed from: f, reason: collision with root package name */
    private static final String f4312f = "ThumbStreamOpener";

    /* renamed from: g, reason: collision with root package name */
    private static final a f4313g = new a();

    /* renamed from: a, reason: collision with root package name */
    private final a f4314a;

    /* renamed from: b, reason: collision with root package name */
    private final d f4315b;

    /* renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.p.a0.b f4316c;

    /* renamed from: d, reason: collision with root package name */
    private final ContentResolver f4317d;

    /* renamed from: e, reason: collision with root package name */
    private final List<ImageHeaderParser> f4318e;

    e(List<ImageHeaderParser> list, d dVar, com.bumptech.glide.load.p.a0.b bVar, ContentResolver contentResolver) {
        this(list, f4313g, dVar, bVar, contentResolver);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0046  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String c(@androidx.annotation.NonNull android.net.Uri r5) throws java.lang.Throwable {
        /*
            r4 = this;
            r0 = 0
            com.bumptech.glide.load.o.p.d r1 = r4.f4315b     // Catch: java.lang.Throwable -> L20 java.lang.SecurityException -> L23
            android.database.Cursor r1 = r1.a(r5)     // Catch: java.lang.Throwable -> L20 java.lang.SecurityException -> L23
            if (r1 == 0) goto L1a
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.SecurityException -> L24 java.lang.Throwable -> L43
            if (r2 == 0) goto L1a
            r2 = 0
            java.lang.String r5 = r1.getString(r2)     // Catch: java.lang.SecurityException -> L24 java.lang.Throwable -> L43
            if (r1 == 0) goto L19
            r1.close()
        L19:
            return r5
        L1a:
            if (r1 == 0) goto L1f
            r1.close()
        L1f:
            return r0
        L20:
            r5 = move-exception
            r1 = r0
            goto L44
        L23:
            r1 = r0
        L24:
            java.lang.String r2 = "ThumbStreamOpener"
            r3 = 3
            boolean r2 = android.util.Log.isLoggable(r2, r3)     // Catch: java.lang.Throwable -> L43
            if (r2 == 0) goto L3d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L43
            r2.<init>()     // Catch: java.lang.Throwable -> L43
            java.lang.String r3 = "Failed to query for thumbnail for Uri: "
            r2.append(r3)     // Catch: java.lang.Throwable -> L43
            r2.append(r5)     // Catch: java.lang.Throwable -> L43
            r2.toString()     // Catch: java.lang.Throwable -> L43
        L3d:
            if (r1 == 0) goto L42
            r1.close()
        L42:
            return r0
        L43:
            r5 = move-exception
        L44:
            if (r1 == 0) goto L49
            r1.close()
        L49:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.o.p.e.c(android.net.Uri):java.lang.String");
    }

    int a(Uri uri) throws IOException {
        InputStream inputStreamOpenInputStream = null;
        try {
            try {
                inputStreamOpenInputStream = this.f4317d.openInputStream(uri);
                int iA = f.a(this.f4318e, inputStreamOpenInputStream, this.f4316c);
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (IOException unused) {
                    }
                }
                return iA;
            } catch (Throwable th) {
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (IOException | NullPointerException unused3) {
            if (Log.isLoggable(f4312f, 3)) {
                String str = "Failed to open uri: " + uri;
            }
            if (inputStreamOpenInputStream == null) {
                return -1;
            }
            try {
                inputStreamOpenInputStream.close();
                return -1;
            } catch (IOException unused4) {
                return -1;
            }
        }
    }

    public InputStream b(Uri uri) throws Throwable {
        String strC = c(uri);
        if (TextUtils.isEmpty(strC)) {
            return null;
        }
        File fileA = this.f4314a.a(strC);
        if (!a(fileA)) {
            return null;
        }
        Uri uriFromFile = Uri.fromFile(fileA);
        try {
            return this.f4317d.openInputStream(uriFromFile);
        } catch (NullPointerException e2) {
            throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri + " -> " + uriFromFile).initCause(e2));
        }
    }

    e(List<ImageHeaderParser> list, a aVar, d dVar, com.bumptech.glide.load.p.a0.b bVar, ContentResolver contentResolver) {
        this.f4314a = aVar;
        this.f4315b = dVar;
        this.f4316c = bVar;
        this.f4317d = contentResolver;
        this.f4318e = list;
    }

    private boolean a(File file) {
        return this.f4314a.a(file) && 0 < this.f4314a.b(file);
    }
}
