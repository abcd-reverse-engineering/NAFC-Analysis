package com.airbnb.lottie;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;

/* compiled from: LottieConfig.java */
/* loaded from: classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    final com.airbnb.lottie.z.f f3532a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    final com.airbnb.lottie.z.e f3533b;

    /* renamed from: c, reason: collision with root package name */
    final boolean f3534c;

    /* compiled from: LottieConfig.java */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        private com.airbnb.lottie.z.f f3535a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        private com.airbnb.lottie.z.e f3536b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f3537c = false;

        /* compiled from: LottieConfig.java */
        class a implements com.airbnb.lottie.z.e {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ File f3538a;

            a(File file) {
                this.f3538a = file;
            }

            @Override // com.airbnb.lottie.z.e
            @NonNull
            public File a() {
                if (this.f3538a.isDirectory()) {
                    return this.f3538a;
                }
                throw new IllegalArgumentException("cache file must be a directory");
            }
        }

        /* compiled from: LottieConfig.java */
        /* renamed from: com.airbnb.lottie.i$b$b, reason: collision with other inner class name */
        class C0048b implements com.airbnb.lottie.z.e {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.airbnb.lottie.z.e f3540a;

            C0048b(com.airbnb.lottie.z.e eVar) {
                this.f3540a = eVar;
            }

            @Override // com.airbnb.lottie.z.e
            @NonNull
            public File a() {
                File fileA = this.f3540a.a();
                if (fileA.isDirectory()) {
                    return fileA;
                }
                throw new IllegalArgumentException("cache file must be a directory");
            }
        }

        @NonNull
        public b a(@NonNull com.airbnb.lottie.z.f fVar) {
            this.f3535a = fVar;
            return this;
        }

        @NonNull
        public b a(@NonNull File file) {
            if (this.f3536b != null) {
                throw new IllegalStateException("There is already a cache provider!");
            }
            this.f3536b = new a(file);
            return this;
        }

        @NonNull
        public b a(@NonNull com.airbnb.lottie.z.e eVar) {
            if (this.f3536b == null) {
                this.f3536b = new C0048b(eVar);
                return this;
            }
            throw new IllegalStateException("There is already a cache provider!");
        }

        @NonNull
        public b a(boolean z) {
            this.f3537c = z;
            return this;
        }

        @NonNull
        public i a() {
            return new i(this.f3535a, this.f3536b, this.f3537c);
        }
    }

    private i(@Nullable com.airbnb.lottie.z.f fVar, @Nullable com.airbnb.lottie.z.e eVar, boolean z) {
        this.f3532a = fVar;
        this.f3533b = eVar;
        this.f3534c = z;
    }
}
