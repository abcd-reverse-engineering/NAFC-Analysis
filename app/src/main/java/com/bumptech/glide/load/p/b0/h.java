package com.bumptech.glide.load.p.b0;

import android.content.Context;
import com.bumptech.glide.load.p.b0.a;
import com.bumptech.glide.load.p.b0.d;
import java.io.File;

/* compiled from: InternalCacheDiskCacheFactory.java */
/* loaded from: classes.dex */
public final class h extends d {

    /* compiled from: InternalCacheDiskCacheFactory.java */
    class a implements d.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f4419a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f4420b;

        a(Context context, String str) {
            this.f4419a = context;
            this.f4420b = str;
        }

        @Override // com.bumptech.glide.load.p.b0.d.c
        public File a() {
            File cacheDir = this.f4419a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            String str = this.f4420b;
            return str != null ? new File(cacheDir, str) : cacheDir;
        }
    }

    public h(Context context) {
        this(context, a.InterfaceC0059a.f4394b, 262144000L);
    }

    public h(Context context, long j2) {
        this(context, a.InterfaceC0059a.f4394b, j2);
    }

    public h(Context context, String str, long j2) {
        super(new a(context, str), j2);
    }
}
