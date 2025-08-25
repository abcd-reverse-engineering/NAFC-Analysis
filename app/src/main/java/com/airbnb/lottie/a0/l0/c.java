package com.airbnb.lottie.a0.l0;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Options;

/* compiled from: JsonReader.java */
/* loaded from: classes.dex */
public abstract class c implements Closeable {

    /* renamed from: g, reason: collision with root package name */
    private static final String[] f3353g = new String[128];

    /* renamed from: a, reason: collision with root package name */
    int f3354a;

    /* renamed from: b, reason: collision with root package name */
    int[] f3355b = new int[32];

    /* renamed from: c, reason: collision with root package name */
    String[] f3356c = new String[32];

    /* renamed from: d, reason: collision with root package name */
    int[] f3357d = new int[32];

    /* renamed from: e, reason: collision with root package name */
    boolean f3358e;

    /* renamed from: f, reason: collision with root package name */
    boolean f3359f;

    /* compiled from: JsonReader.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        final String[] f3360a;

        /* renamed from: b, reason: collision with root package name */
        final Options f3361b;

        private a(String[] strArr, Options options) {
            this.f3360a = strArr;
            this.f3361b = options;
        }

        public static a a(String... strArr) {
            try {
                ByteString[] byteStringArr = new ByteString[strArr.length];
                Buffer buffer = new Buffer();
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    c.b(buffer, strArr[i2]);
                    buffer.readByte();
                    byteStringArr[i2] = buffer.readByteString();
                }
                return new a((String[]) strArr.clone(), Options.of(byteStringArr));
            } catch (IOException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    /* compiled from: JsonReader.java */
    public enum b {
        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL,
        END_DOCUMENT
    }

    static {
        for (int i2 = 0; i2 <= 31; i2++) {
            f3353g[i2] = String.format("\\u%04x", Integer.valueOf(i2));
        }
        String[] strArr = f3353g;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void b(okio.BufferedSink r7, java.lang.String r8) throws java.io.IOException {
        /*
            java.lang.String[] r0 = com.airbnb.lottie.a0.l0.c.f3353g
            r1 = 34
            r7.writeByte(r1)
            int r2 = r8.length()
            r3 = 0
            r4 = 0
        Ld:
            if (r3 >= r2) goto L36
            char r5 = r8.charAt(r3)
            r6 = 128(0x80, float:1.8E-43)
            if (r5 >= r6) goto L1c
            r5 = r0[r5]
            if (r5 != 0) goto L29
            goto L33
        L1c:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L23
            java.lang.String r5 = "\\u2028"
            goto L29
        L23:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L33
            java.lang.String r5 = "\\u2029"
        L29:
            if (r4 >= r3) goto L2e
            r7.writeUtf8(r8, r4, r3)
        L2e:
            r7.writeUtf8(r5)
            int r4 = r3 + 1
        L33:
            int r3 = r3 + 1
            goto Ld
        L36:
            if (r4 >= r2) goto L3b
            r7.writeUtf8(r8, r4, r2)
        L3b:
            r7.writeByte(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.a0.l0.c.b(okio.BufferedSink, java.lang.String):void");
    }

    public abstract int a(a aVar) throws IOException;

    public abstract void c() throws IOException;

    public abstract void d() throws IOException;

    public abstract void e() throws IOException;

    public abstract void f() throws IOException;

    public final String g() {
        return d.a(this.f3354a, this.f3355b, this.f3356c, this.f3357d);
    }

    public abstract boolean h() throws IOException;

    public abstract boolean i() throws IOException;

    public abstract double j() throws IOException;

    public abstract int k() throws IOException;

    public abstract String l() throws IOException;

    public abstract String m() throws IOException;

    public abstract void n() throws IOException;

    public abstract void o() throws IOException;

    public abstract b peek() throws IOException;

    public static c a(BufferedSource bufferedSource) {
        return new e(bufferedSource);
    }

    final void a(int i2) {
        int i3 = this.f3354a;
        int[] iArr = this.f3355b;
        if (i3 == iArr.length) {
            if (i3 != 256) {
                this.f3355b = Arrays.copyOf(iArr, iArr.length * 2);
                String[] strArr = this.f3356c;
                this.f3356c = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                int[] iArr2 = this.f3357d;
                this.f3357d = Arrays.copyOf(iArr2, iArr2.length * 2);
            } else {
                throw new com.airbnb.lottie.a0.l0.a("Nesting too deep at " + g());
            }
        }
        int[] iArr3 = this.f3355b;
        int i4 = this.f3354a;
        this.f3354a = i4 + 1;
        iArr3[i4] = i2;
    }

    final com.airbnb.lottie.a0.l0.b a(String str) throws com.airbnb.lottie.a0.l0.b {
        throw new com.airbnb.lottie.a0.l0.b(str + " at path " + g());
    }
}
