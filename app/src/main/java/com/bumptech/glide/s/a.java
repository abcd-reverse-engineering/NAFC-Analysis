package com.bumptech.glide.s;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.g;
import com.bumptech.glide.util.l;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: AndroidResourceSignature.java */
/* loaded from: classes.dex */
public final class a implements g {

    /* renamed from: c, reason: collision with root package name */
    private final int f5346c;

    /* renamed from: d, reason: collision with root package name */
    private final g f5347d;

    private a(int i2, g gVar) {
        this.f5346c = i2;
        this.f5347d = gVar;
    }

    @NonNull
    public static g a(@NonNull Context context) {
        return new a(context.getResources().getConfiguration().uiMode & 48, b.b(context));
    }

    @Override // com.bumptech.glide.load.g
    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f5346c == aVar.f5346c && this.f5347d.equals(aVar.f5347d);
    }

    @Override // com.bumptech.glide.load.g
    public int hashCode() {
        return l.a(this.f5347d, this.f5346c);
    }

    @Override // com.bumptech.glide.load.g
    public void a(@NonNull MessageDigest messageDigest) {
        this.f5347d.a(messageDigest);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f5346c).array());
    }
}
