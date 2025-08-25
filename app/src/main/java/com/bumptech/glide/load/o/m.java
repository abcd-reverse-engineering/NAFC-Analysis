package com.bumptech.glide.load.o;

import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.o.e;
import java.io.IOException;

/* compiled from: ParcelFileDescriptorRewinder.java */
/* loaded from: classes.dex */
public final class m implements e<ParcelFileDescriptor> {

    /* renamed from: a, reason: collision with root package name */
    private final b f4292a;

    /* compiled from: ParcelFileDescriptorRewinder.java */
    @RequiresApi(21)
    public static final class a implements e.a<ParcelFileDescriptor> {
        @Override // com.bumptech.glide.load.o.e.a
        @NonNull
        public e<ParcelFileDescriptor> a(@NonNull ParcelFileDescriptor parcelFileDescriptor) {
            return new m(parcelFileDescriptor);
        }

        @Override // com.bumptech.glide.load.o.e.a
        @NonNull
        public Class<ParcelFileDescriptor> a() {
            return ParcelFileDescriptor.class;
        }
    }

    /* compiled from: ParcelFileDescriptorRewinder.java */
    @RequiresApi(21)
    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final ParcelFileDescriptor f4293a;

        b(ParcelFileDescriptor parcelFileDescriptor) {
            this.f4293a = parcelFileDescriptor;
        }

        ParcelFileDescriptor a() throws IOException, ErrnoException {
            try {
                Os.lseek(this.f4293a.getFileDescriptor(), 0L, OsConstants.SEEK_SET);
                return this.f4293a;
            } catch (ErrnoException e2) {
                throw new IOException(e2);
            }
        }
    }

    @RequiresApi(21)
    public m(ParcelFileDescriptor parcelFileDescriptor) {
        this.f4292a = new b(parcelFileDescriptor);
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT >= 21;
    }

    @Override // com.bumptech.glide.load.o.e
    public void b() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.o.e
    @NonNull
    @RequiresApi(21)
    public ParcelFileDescriptor a() throws IOException {
        return this.f4292a.a();
    }
}
