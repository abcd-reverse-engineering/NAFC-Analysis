package com.bumptech.glide.load.p.d0;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.p.a0.e;
import com.bumptech.glide.load.p.b0.j;
import com.bumptech.glide.load.p.d0.d;
import com.bumptech.glide.util.l;
import java.util.HashMap;

/* compiled from: BitmapPreFiller.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final j f4504a;

    /* renamed from: b, reason: collision with root package name */
    private final e f4505b;

    /* renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.b f4506c;

    /* renamed from: d, reason: collision with root package name */
    private final Handler f4507d = new Handler(Looper.getMainLooper());

    /* renamed from: e, reason: collision with root package name */
    private a f4508e;

    public b(j jVar, e eVar, com.bumptech.glide.load.b bVar) {
        this.f4504a = jVar;
        this.f4505b = eVar;
        this.f4506c = bVar;
    }

    public void a(d.a... aVarArr) {
        a aVar = this.f4508e;
        if (aVar != null) {
            aVar.b();
        }
        d[] dVarArr = new d[aVarArr.length];
        for (int i2 = 0; i2 < aVarArr.length; i2++) {
            d.a aVar2 = aVarArr[i2];
            if (aVar2.b() == null) {
                aVar2.a(this.f4506c == com.bumptech.glide.load.b.PREFER_ARGB_8888 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
            }
            dVarArr[i2] = aVar2.a();
        }
        this.f4508e = new a(this.f4505b, this.f4504a, a(dVarArr));
        this.f4507d.post(this.f4508e);
    }

    @VisibleForTesting
    c a(d... dVarArr) {
        long jB = (this.f4504a.b() - this.f4504a.getCurrentSize()) + this.f4505b.b();
        int iC = 0;
        for (d dVar : dVarArr) {
            iC += dVar.c();
        }
        float f2 = jB / iC;
        HashMap map = new HashMap();
        for (d dVar2 : dVarArr) {
            map.put(dVar2, Integer.valueOf(Math.round(dVar2.c() * f2) / a(dVar2)));
        }
        return new c(map);
    }

    private static int a(d dVar) {
        return l.a(dVar.d(), dVar.b(), dVar.a());
    }
}
