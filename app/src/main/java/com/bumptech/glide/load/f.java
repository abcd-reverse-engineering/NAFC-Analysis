package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.r.d.b0;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: ImageHeaderParserUtils.java */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private static final int f4239a = 5242880;

    /* compiled from: ImageHeaderParserUtils.java */
    class a implements g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InputStream f4240a;

        a(InputStream inputStream) {
            this.f4240a = inputStream;
        }

        @Override // com.bumptech.glide.load.f.g
        public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws IOException {
            try {
                return imageHeaderParser.a(this.f4240a);
            } finally {
                this.f4240a.reset();
            }
        }
    }

    /* compiled from: ImageHeaderParserUtils.java */
    class b implements g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ByteBuffer f4241a;

        b(ByteBuffer byteBuffer) {
            this.f4241a = byteBuffer;
        }

        @Override // com.bumptech.glide.load.f.g
        public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws IOException {
            return imageHeaderParser.a(this.f4241a);
        }
    }

    /* compiled from: ImageHeaderParserUtils.java */
    class c implements g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.bumptech.glide.load.o.m f4242a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.bumptech.glide.load.p.a0.b f4243b;

        c(com.bumptech.glide.load.o.m mVar, com.bumptech.glide.load.p.a0.b bVar) {
            this.f4242a = mVar;
            this.f4243b = bVar;
        }

        @Override // com.bumptech.glide.load.f.g
        public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws Throwable {
            b0 b0Var;
            b0 b0Var2 = null;
            try {
                b0Var = new b0(new FileInputStream(this.f4242a.a().getFileDescriptor()), this.f4243b);
            } catch (Throwable th) {
                th = th;
            }
            try {
                ImageHeaderParser.ImageType imageTypeA = imageHeaderParser.a(b0Var);
                try {
                    b0Var.close();
                } catch (IOException unused) {
                }
                this.f4242a.a();
                return imageTypeA;
            } catch (Throwable th2) {
                th = th2;
                b0Var2 = b0Var;
                if (b0Var2 != null) {
                    try {
                        b0Var2.close();
                    } catch (IOException unused2) {
                    }
                }
                this.f4242a.a();
                throw th;
            }
        }
    }

    /* compiled from: ImageHeaderParserUtils.java */
    class d implements InterfaceC0056f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InputStream f4244a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.bumptech.glide.load.p.a0.b f4245b;

        d(InputStream inputStream, com.bumptech.glide.load.p.a0.b bVar) {
            this.f4244a = inputStream;
            this.f4245b = bVar;
        }

        @Override // com.bumptech.glide.load.f.InterfaceC0056f
        public int a(ImageHeaderParser imageHeaderParser) throws IOException {
            try {
                return imageHeaderParser.a(this.f4244a, this.f4245b);
            } finally {
                this.f4244a.reset();
            }
        }
    }

    /* compiled from: ImageHeaderParserUtils.java */
    class e implements InterfaceC0056f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.bumptech.glide.load.o.m f4246a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.bumptech.glide.load.p.a0.b f4247b;

        e(com.bumptech.glide.load.o.m mVar, com.bumptech.glide.load.p.a0.b bVar) {
            this.f4246a = mVar;
            this.f4247b = bVar;
        }

        @Override // com.bumptech.glide.load.f.InterfaceC0056f
        public int a(ImageHeaderParser imageHeaderParser) throws Throwable {
            b0 b0Var;
            b0 b0Var2 = null;
            try {
                b0Var = new b0(new FileInputStream(this.f4246a.a().getFileDescriptor()), this.f4247b);
            } catch (Throwable th) {
                th = th;
            }
            try {
                int iA = imageHeaderParser.a(b0Var, this.f4247b);
                try {
                    b0Var.close();
                } catch (IOException unused) {
                }
                this.f4246a.a();
                return iA;
            } catch (Throwable th2) {
                th = th2;
                b0Var2 = b0Var;
                if (b0Var2 != null) {
                    try {
                        b0Var2.close();
                    } catch (IOException unused2) {
                    }
                }
                this.f4246a.a();
                throw th;
            }
        }
    }

    /* compiled from: ImageHeaderParserUtils.java */
    /* renamed from: com.bumptech.glide.load.f$f, reason: collision with other inner class name */
    private interface InterfaceC0056f {
        int a(ImageHeaderParser imageHeaderParser) throws IOException;
    }

    /* compiled from: ImageHeaderParserUtils.java */
    private interface g {
        ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws IOException;
    }

    private f() {
    }

    @NonNull
    public static ImageHeaderParser.ImageType a(@NonNull List<ImageHeaderParser> list, @Nullable ByteBuffer byteBuffer) throws IOException {
        return byteBuffer == null ? ImageHeaderParser.ImageType.UNKNOWN : a(list, new b(byteBuffer));
    }

    @NonNull
    public static ImageHeaderParser.ImageType b(@NonNull List<ImageHeaderParser> list, @Nullable InputStream inputStream, @NonNull com.bumptech.glide.load.p.a0.b bVar) throws IOException {
        if (inputStream == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new b0(inputStream, bVar);
        }
        inputStream.mark(5242880);
        return a(list, new a(inputStream));
    }

    @NonNull
    private static ImageHeaderParser.ImageType a(@NonNull List<ImageHeaderParser> list, g gVar) throws IOException {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            ImageHeaderParser.ImageType imageTypeA = gVar.a(list.get(i2));
            if (imageTypeA != ImageHeaderParser.ImageType.UNKNOWN) {
                return imageTypeA;
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    @NonNull
    @RequiresApi(21)
    public static ImageHeaderParser.ImageType b(@NonNull List<ImageHeaderParser> list, @NonNull com.bumptech.glide.load.o.m mVar, @NonNull com.bumptech.glide.load.p.a0.b bVar) throws IOException {
        return a(list, new c(mVar, bVar));
    }

    public static int a(@NonNull List<ImageHeaderParser> list, @Nullable InputStream inputStream, @NonNull com.bumptech.glide.load.p.a0.b bVar) throws IOException {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new b0(inputStream, bVar);
        }
        inputStream.mark(5242880);
        return a(list, new d(inputStream, bVar));
    }

    @RequiresApi(21)
    public static int a(@NonNull List<ImageHeaderParser> list, @NonNull com.bumptech.glide.load.o.m mVar, @NonNull com.bumptech.glide.load.p.a0.b bVar) throws IOException {
        return a(list, new e(mVar, bVar));
    }

    private static int a(@NonNull List<ImageHeaderParser> list, InterfaceC0056f interfaceC0056f) throws IOException {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            int iA = interfaceC0056f.a(list.get(i2));
            if (iA != -1) {
                return iA;
            }
        }
        return -1;
    }
}
