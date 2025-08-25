package com.bumptech.glide.q;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.ImageHeaderParser;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ImageHeaderParserRegistry.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final List<ImageHeaderParser> f5198a = new ArrayList();

    @NonNull
    public synchronized List<ImageHeaderParser> a() {
        return this.f5198a;
    }

    public synchronized void a(@NonNull ImageHeaderParser imageHeaderParser) {
        this.f5198a.add(imageHeaderParser);
    }
}
