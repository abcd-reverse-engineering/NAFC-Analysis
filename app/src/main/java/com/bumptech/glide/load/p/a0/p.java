package com.bumptech.glide.load.p.a0;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import java.util.NavigableMap;

/* compiled from: SizeStrategy.java */
@RequiresApi(19)
/* loaded from: classes.dex */
final class p implements l {

    /* renamed from: d, reason: collision with root package name */
    private static final int f4387d = 8;

    /* renamed from: a, reason: collision with root package name */
    private final b f4388a = new b();

    /* renamed from: b, reason: collision with root package name */
    private final h<a, Bitmap> f4389b = new h<>();

    /* renamed from: c, reason: collision with root package name */
    private final NavigableMap<Integer, Integer> f4390c = new n();

    /* compiled from: SizeStrategy.java */
    @VisibleForTesting
    static final class a implements m {

        /* renamed from: a, reason: collision with root package name */
        private final b f4391a;

        /* renamed from: b, reason: collision with root package name */
        int f4392b;

        a(b bVar) {
            this.f4391a = bVar;
        }

        public void a(int i2) {
            this.f4392b = i2;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && this.f4392b == ((a) obj).f4392b;
        }

        public int hashCode() {
            return this.f4392b;
        }

        @Override // com.bumptech.glide.load.p.a0.m
        public void offer() {
            this.f4391a.a((b) this);
        }

        public String toString() {
            return p.a(this.f4392b);
        }
    }

    /* compiled from: SizeStrategy.java */
    @VisibleForTesting
    static class b extends d<a> {
        b() {
        }

        public a a(int i2) {
            a aVar = (a) super.b();
            aVar.a(i2);
            return aVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.load.p.a0.d
        public a a() {
            return new a(this);
        }
    }

    p() {
    }

    private static String d(Bitmap bitmap) {
        return a(com.bumptech.glide.util.l.a(bitmap));
    }

    @Override // com.bumptech.glide.load.p.a0.l
    public void a(Bitmap bitmap) {
        a aVarA = this.f4388a.a(com.bumptech.glide.util.l.a(bitmap));
        this.f4389b.a(aVarA, bitmap);
        Integer num = (Integer) this.f4390c.get(Integer.valueOf(aVarA.f4392b));
        this.f4390c.put(Integer.valueOf(aVarA.f4392b), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    @Override // com.bumptech.glide.load.p.a0.l
    public String b(int i2, int i3, Bitmap.Config config) {
        return a(com.bumptech.glide.util.l.a(i2, i3, config));
    }

    @Override // com.bumptech.glide.load.p.a0.l
    public String c(Bitmap bitmap) {
        return d(bitmap);
    }

    @Override // com.bumptech.glide.load.p.a0.l
    @Nullable
    public Bitmap removeLast() {
        Bitmap bitmapA = this.f4389b.a();
        if (bitmapA != null) {
            a(Integer.valueOf(com.bumptech.glide.util.l.a(bitmapA)));
        }
        return bitmapA;
    }

    public String toString() {
        return "SizeStrategy:\n  " + this.f4389b + "\n  SortedSizes" + this.f4390c;
    }

    @Override // com.bumptech.glide.load.p.a0.l
    public int b(Bitmap bitmap) {
        return com.bumptech.glide.util.l.a(bitmap);
    }

    @Override // com.bumptech.glide.load.p.a0.l
    @Nullable
    public Bitmap a(int i2, int i3, Bitmap.Config config) {
        int iA = com.bumptech.glide.util.l.a(i2, i3, config);
        a aVarA = this.f4388a.a(iA);
        Integer numCeilingKey = this.f4390c.ceilingKey(Integer.valueOf(iA));
        if (numCeilingKey != null && numCeilingKey.intValue() != iA && numCeilingKey.intValue() <= iA * 8) {
            this.f4388a.a((b) aVarA);
            aVarA = this.f4388a.a(numCeilingKey.intValue());
        }
        Bitmap bitmapA = this.f4389b.a((h<a, Bitmap>) aVarA);
        if (bitmapA != null) {
            bitmapA.reconfigure(i2, i3, config);
            a(numCeilingKey);
        }
        return bitmapA;
    }

    private void a(Integer num) {
        Integer num2 = (Integer) this.f4390c.get(num);
        if (num2.intValue() == 1) {
            this.f4390c.remove(num);
        } else {
            this.f4390c.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    static String a(int i2) {
        return "[" + i2 + "]";
    }
}
