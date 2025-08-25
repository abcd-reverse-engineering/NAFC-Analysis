package com.bumptech.glide.s;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.g;
import com.bumptech.glide.util.j;
import java.security.MessageDigest;

/* compiled from: ObjectKey.java */
/* loaded from: classes.dex */
public final class e implements g {

    /* renamed from: c, reason: collision with root package name */
    private final Object f5354c;

    public e(@NonNull Object obj) {
        this.f5354c = j.a(obj);
    }

    @Override // com.bumptech.glide.load.g
    public void a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(this.f5354c.toString().getBytes(g.f4249b));
    }

    @Override // com.bumptech.glide.load.g
    public boolean equals(Object obj) {
        if (obj instanceof e) {
            return this.f5354c.equals(((e) obj).f5354c);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.g
    public int hashCode() {
        return this.f5354c.hashCode();
    }

    public String toString() {
        return "ObjectKey{object=" + this.f5354c + '}';
    }
}
