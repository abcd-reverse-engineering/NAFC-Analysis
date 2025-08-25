package com.bumptech.glide.load;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.p.v;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: MultiTransformation.java */
/* loaded from: classes.dex */
public class h<T> implements n<T> {

    /* renamed from: c, reason: collision with root package name */
    private final Collection<? extends n<T>> f4250c;

    @SafeVarargs
    public h(@NonNull n<T>... nVarArr) {
        if (nVarArr.length == 0) {
            throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
        }
        this.f4250c = Arrays.asList(nVarArr);
    }

    @Override // com.bumptech.glide.load.n
    @NonNull
    public v<T> a(@NonNull Context context, @NonNull v<T> vVar, int i2, int i3) {
        Iterator<? extends n<T>> it = this.f4250c.iterator();
        v<T> vVar2 = vVar;
        while (it.hasNext()) {
            v<T> vVarA = it.next().a(context, vVar2, i2, i3);
            if (vVar2 != null && !vVar2.equals(vVar) && !vVar2.equals(vVarA)) {
                vVar2.recycle();
            }
            vVar2 = vVarA;
        }
        return vVar2;
    }

    @Override // com.bumptech.glide.load.g
    public boolean equals(Object obj) {
        if (obj instanceof h) {
            return this.f4250c.equals(((h) obj).f4250c);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.g
    public int hashCode() {
        return this.f4250c.hashCode();
    }

    public h(@NonNull Collection<? extends n<T>> collection) {
        if (!collection.isEmpty()) {
            this.f4250c = collection;
            return;
        }
        throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
    }

    @Override // com.bumptech.glide.load.g
    public void a(@NonNull MessageDigest messageDigest) {
        Iterator<? extends n<T>> it = this.f4250c.iterator();
        while (it.hasNext()) {
            it.next().a(messageDigest);
        }
    }
}
