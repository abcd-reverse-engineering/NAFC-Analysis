package com.bumptech.glide.load.q;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.q.n;
import java.io.InputStream;

/* compiled from: ResourceLoader.java */
/* loaded from: classes.dex */
public class s<Data> implements n<Integer, Data> {

    /* renamed from: c, reason: collision with root package name */
    private static final String f4772c = "ResourceLoader";

    /* renamed from: a, reason: collision with root package name */
    private final n<Uri, Data> f4773a;

    /* renamed from: b, reason: collision with root package name */
    private final Resources f4774b;

    /* compiled from: ResourceLoader.java */
    public static final class a implements o<Integer, AssetFileDescriptor> {

        /* renamed from: a, reason: collision with root package name */
        private final Resources f4775a;

        public a(Resources resources) {
            this.f4775a = resources;
        }

        @Override // com.bumptech.glide.load.q.o
        public n<Integer, AssetFileDescriptor> a(r rVar) {
            return new s(this.f4775a, rVar.a(Uri.class, AssetFileDescriptor.class));
        }

        @Override // com.bumptech.glide.load.q.o
        public void a() {
        }
    }

    /* compiled from: ResourceLoader.java */
    public static class b implements o<Integer, ParcelFileDescriptor> {

        /* renamed from: a, reason: collision with root package name */
        private final Resources f4776a;

        public b(Resources resources) {
            this.f4776a = resources;
        }

        @Override // com.bumptech.glide.load.q.o
        @NonNull
        public n<Integer, ParcelFileDescriptor> a(r rVar) {
            return new s(this.f4776a, rVar.a(Uri.class, ParcelFileDescriptor.class));
        }

        @Override // com.bumptech.glide.load.q.o
        public void a() {
        }
    }

    /* compiled from: ResourceLoader.java */
    public static class c implements o<Integer, InputStream> {

        /* renamed from: a, reason: collision with root package name */
        private final Resources f4777a;

        public c(Resources resources) {
            this.f4777a = resources;
        }

        @Override // com.bumptech.glide.load.q.o
        @NonNull
        public n<Integer, InputStream> a(r rVar) {
            return new s(this.f4777a, rVar.a(Uri.class, InputStream.class));
        }

        @Override // com.bumptech.glide.load.q.o
        public void a() {
        }
    }

    /* compiled from: ResourceLoader.java */
    public static class d implements o<Integer, Uri> {

        /* renamed from: a, reason: collision with root package name */
        private final Resources f4778a;

        public d(Resources resources) {
            this.f4778a = resources;
        }

        @Override // com.bumptech.glide.load.q.o
        @NonNull
        public n<Integer, Uri> a(r rVar) {
            return new s(this.f4778a, v.a());
        }

        @Override // com.bumptech.glide.load.q.o
        public void a() {
        }
    }

    public s(Resources resources, n<Uri, Data> nVar) {
        this.f4774b = resources;
        this.f4773a = nVar;
    }

    @Nullable
    private Uri b(Integer num) {
        try {
            return Uri.parse("android.resource://" + this.f4774b.getResourcePackageName(num.intValue()) + '/' + this.f4774b.getResourceTypeName(num.intValue()) + '/' + this.f4774b.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException unused) {
            if (!Log.isLoggable(f4772c, 5)) {
                return null;
            }
            String str = "Received invalid resource id: " + num;
            return null;
        }
    }

    @Override // com.bumptech.glide.load.q.n
    public boolean a(@NonNull Integer num) {
        return true;
    }

    @Override // com.bumptech.glide.load.q.n
    public n.a<Data> a(@NonNull Integer num, int i2, int i3, @NonNull com.bumptech.glide.load.j jVar) {
        Uri uriB = b(num);
        if (uriB == null) {
            return null;
        }
        return this.f4773a.a(uriB, i2, i3, jVar);
    }
}
