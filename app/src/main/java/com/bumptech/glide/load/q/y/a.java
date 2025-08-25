package com.bumptech.glide.load.q.y;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.q.h;
import com.bumptech.glide.load.q.m;
import com.bumptech.glide.load.q.n;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: BaseGlideUrlLoader.java */
/* loaded from: classes.dex */
public abstract class a<Model> implements n<Model, InputStream> {

    /* renamed from: a, reason: collision with root package name */
    private final n<com.bumptech.glide.load.q.g, InputStream> f4792a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private final m<Model, com.bumptech.glide.load.q.g> f4793b;

    protected a(n<com.bumptech.glide.load.q.g, InputStream> nVar) {
        this(nVar, null);
    }

    @Override // com.bumptech.glide.load.q.n
    @Nullable
    public n.a<InputStream> a(@NonNull Model model, int i2, int i3, @NonNull j jVar) {
        m<Model, com.bumptech.glide.load.q.g> mVar = this.f4793b;
        com.bumptech.glide.load.q.g gVarA = mVar != null ? mVar.a(model, i2, i3) : null;
        if (gVarA == null) {
            String strD = d(model, i2, i3, jVar);
            if (TextUtils.isEmpty(strD)) {
                return null;
            }
            com.bumptech.glide.load.q.g gVar = new com.bumptech.glide.load.q.g(strD, c(model, i2, i3, jVar));
            m<Model, com.bumptech.glide.load.q.g> mVar2 = this.f4793b;
            if (mVar2 != null) {
                mVar2.a(model, i2, i3, gVar);
            }
            gVarA = gVar;
        }
        List<String> listB = b(model, i2, i3, jVar);
        n.a<InputStream> aVarA = this.f4792a.a(gVarA, i2, i3, jVar);
        return (aVarA == null || listB.isEmpty()) ? aVarA : new n.a<>(aVarA.f4747a, a((Collection<String>) listB), aVarA.f4749c);
    }

    protected List<String> b(Model model, int i2, int i3, j jVar) {
        return Collections.emptyList();
    }

    @Nullable
    protected h c(Model model, int i2, int i3, j jVar) {
        return h.f4725b;
    }

    protected abstract String d(Model model, int i2, int i3, j jVar);

    protected a(n<com.bumptech.glide.load.q.g, InputStream> nVar, @Nullable m<Model, com.bumptech.glide.load.q.g> mVar) {
        this.f4792a = nVar;
        this.f4793b = mVar;
    }

    private static List<com.bumptech.glide.load.g> a(Collection<String> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(new com.bumptech.glide.load.q.g(it.next()));
        }
        return arrayList;
    }
}
