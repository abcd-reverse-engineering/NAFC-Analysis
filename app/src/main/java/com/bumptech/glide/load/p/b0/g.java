package com.bumptech.glide.load.p.b0;

import android.content.Context;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.p.b0.a;
import com.bumptech.glide.load.p.b0.d;
import java.io.File;

/* compiled from: ExternalPreferredCacheDiskCacheFactory.java */
/* loaded from: classes.dex */
public final class g extends d {

    /* compiled from: ExternalPreferredCacheDiskCacheFactory.java */
    class a implements d.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f4417a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f4418b;

        a(Context context, String str) {
            this.f4417a = context;
            this.f4418b = str;
        }

        @Nullable
        private File b() {
            File cacheDir = this.f4417a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            String str = this.f4418b;
            return str != null ? new File(cacheDir, str) : cacheDir;
        }

        @Override // com.bumptech.glide.load.p.b0.d.c
        public File a() {
            File externalCacheDir;
            File fileB = b();
            if ((fileB != null && fileB.exists()) || (externalCacheDir = this.f4417a.getExternalCacheDir()) == null || !externalCacheDir.canWrite()) {
                return fileB;
            }
            String str = this.f4418b;
            return str != null ? new File(externalCacheDir, str) : externalCacheDir;
        }
    }

    public g(Context context) {
        this(context, a.InterfaceC0059a.f4394b, 262144000L);
    }

    public g(Context context, long j2) {
        this(context, a.InterfaceC0059a.f4394b, j2);
    }

    public g(Context context, String str, long j2) {
        super(new a(context, str), j2);
    }
}
