package com.bumptech.glide.load.p.a0;

/* compiled from: IntegerArrayAdapter.java */
/* loaded from: classes.dex */
public final class i implements a<int[]> {

    /* renamed from: a, reason: collision with root package name */
    private static final String f4348a = "IntegerArrayPool";

    @Override // com.bumptech.glide.load.p.a0.a
    public int a() {
        return 4;
    }

    @Override // com.bumptech.glide.load.p.a0.a
    public String getTag() {
        return f4348a;
    }

    @Override // com.bumptech.glide.load.p.a0.a
    public int a(int[] iArr) {
        return iArr.length;
    }

    @Override // com.bumptech.glide.load.p.a0.a
    public int[] newArray(int i2) {
        return new int[i2];
    }
}
