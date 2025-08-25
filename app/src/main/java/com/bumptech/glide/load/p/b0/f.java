package com.bumptech.glide.load.p.b0;

import android.content.Context;
import com.bumptech.glide.load.p.b0.a;
import com.bumptech.glide.load.p.b0.d;
import java.io.File;

/* compiled from: ExternalCacheDiskCacheFactory.java */
@Deprecated
/* loaded from: classes.dex */
public final class f extends d {

    /* compiled from: ExternalCacheDiskCacheFactory.java */
    class a implements d.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f4415a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f4416b;

        a(Context context, String str) {
            this.f4415a = context;
            this.f4416b = str;
        }

        @Override // com.bumptech.glide.load.p.b0.d.c
        public File a() {
            File externalCacheDir = this.f4415a.getExternalCacheDir();
            if (externalCacheDir == null) {
                return null;
            }
            String str = this.f4416b;
            return str != null ? new File(externalCacheDir, str) : externalCacheDir;
        }
    }

    public f(Context context) {
        this(context, a.InterfaceC0059a.f4394b, a.InterfaceC0059a.f4393a);
    }

    public f(Context context, int i2) {
        this(context, a.InterfaceC0059a.f4394b, i2);
    }

    public f(Context context, String str, int i2) {
        super(new a(context, str), i2);
    }
}
