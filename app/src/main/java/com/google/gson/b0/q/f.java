package com.google.gson.b0.q;

import com.google.gson.JsonObject;
import com.google.gson.p;
import h.z2.h0;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/* compiled from: JsonTreeReader.java */
/* loaded from: classes.dex */
public final class f extends com.google.gson.e0.a {
    private static final Reader h0 = new a();
    private static final Object i0 = new Object();
    private Object[] d0;
    private int e0;
    private String[] f0;
    private int[] g0;

    /* compiled from: JsonTreeReader.java */
    class a extends Reader {
        a() {
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i2, int i3) {
            throw new AssertionError();
        }
    }

    /* compiled from: JsonTreeReader.java */
    static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5566a = new int[com.google.gson.e0.c.values().length];

        static {
            try {
                f5566a[com.google.gson.e0.c.NAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5566a[com.google.gson.e0.c.END_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5566a[com.google.gson.e0.c.END_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5566a[com.google.gson.e0.c.END_DOCUMENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public f(com.google.gson.k kVar) {
        super(h0);
        this.d0 = new Object[32];
        this.e0 = 0;
        this.f0 = new String[32];
        this.g0 = new int[32];
        a(kVar);
    }

    private void a(com.google.gson.e0.c cVar) throws IOException {
        if (peek() == cVar) {
            return;
        }
        throw new IllegalStateException("Expected " + cVar + " but was " + peek() + l());
    }

    private String b(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(h0.f16705b);
        int i2 = 0;
        while (true) {
            int i3 = this.e0;
            if (i2 >= i3) {
                return sb.toString();
            }
            Object[] objArr = this.d0;
            if (objArr[i2] instanceof com.google.gson.h) {
                i2++;
                if (i2 < i3 && (objArr[i2] instanceof Iterator)) {
                    int i4 = this.g0[i2];
                    if (z && i4 > 0 && (i2 == i3 - 1 || i2 == i3 - 2)) {
                        i4--;
                    }
                    sb.append('[');
                    sb.append(i4);
                    sb.append(']');
                }
            } else if ((objArr[i2] instanceof JsonObject) && (i2 = i2 + 1) < i3 && (objArr[i2] instanceof Iterator)) {
                sb.append('.');
                String[] strArr = this.f0;
                if (strArr[i2] != null) {
                    sb.append(strArr[i2]);
                }
            }
            i2++;
        }
    }

    private String l() {
        return " at path " + h();
    }

    private Object w() {
        return this.d0[this.e0 - 1];
    }

    private Object x() {
        Object[] objArr = this.d0;
        int i2 = this.e0 - 1;
        this.e0 = i2;
        Object obj = objArr[i2];
        objArr[this.e0] = null;
        return obj;
    }

    @Override // com.google.gson.e0.a
    public void c() throws IOException {
        a(com.google.gson.e0.c.BEGIN_ARRAY);
        a(((com.google.gson.h) w()).iterator());
        this.g0[this.e0 - 1] = 0;
    }

    @Override // com.google.gson.e0.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.d0 = new Object[]{i0};
        this.e0 = 1;
    }

    @Override // com.google.gson.e0.a
    public void d() throws IOException {
        a(com.google.gson.e0.c.BEGIN_OBJECT);
        a(((JsonObject) w()).entrySet().iterator());
    }

    @Override // com.google.gson.e0.a
    public void f() throws IOException {
        a(com.google.gson.e0.c.END_ARRAY);
        x();
        x();
        int i2 = this.e0;
        if (i2 > 0) {
            int[] iArr = this.g0;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    @Override // com.google.gson.e0.a
    public void g() throws IOException {
        a(com.google.gson.e0.c.END_OBJECT);
        this.f0[this.e0 - 1] = null;
        x();
        x();
        int i2 = this.e0;
        if (i2 > 0) {
            int[] iArr = this.g0;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    @Override // com.google.gson.e0.a
    public String h() {
        return b(false);
    }

    @Override // com.google.gson.e0.a
    public String i() {
        return b(true);
    }

    @Override // com.google.gson.e0.a
    public boolean j() throws IOException {
        com.google.gson.e0.c cVarPeek = peek();
        return (cVarPeek == com.google.gson.e0.c.END_OBJECT || cVarPeek == com.google.gson.e0.c.END_ARRAY || cVarPeek == com.google.gson.e0.c.END_DOCUMENT) ? false : true;
    }

    @Override // com.google.gson.e0.a
    public boolean m() throws IOException {
        a(com.google.gson.e0.c.BOOLEAN);
        boolean asBoolean = ((p) x()).getAsBoolean();
        int i2 = this.e0;
        if (i2 > 0) {
            int[] iArr = this.g0;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return asBoolean;
    }

    @Override // com.google.gson.e0.a
    public double n() throws IOException {
        com.google.gson.e0.c cVarPeek = peek();
        if (cVarPeek != com.google.gson.e0.c.NUMBER && cVarPeek != com.google.gson.e0.c.STRING) {
            throw new IllegalStateException("Expected " + com.google.gson.e0.c.NUMBER + " but was " + cVarPeek + l());
        }
        double asDouble = ((p) w()).getAsDouble();
        if (!k() && (Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
            throw new com.google.gson.e0.e("JSON forbids NaN and infinities: " + asDouble);
        }
        x();
        int i2 = this.e0;
        if (i2 > 0) {
            int[] iArr = this.g0;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return asDouble;
    }

    @Override // com.google.gson.e0.a
    public int o() throws IOException {
        com.google.gson.e0.c cVarPeek = peek();
        if (cVarPeek != com.google.gson.e0.c.NUMBER && cVarPeek != com.google.gson.e0.c.STRING) {
            throw new IllegalStateException("Expected " + com.google.gson.e0.c.NUMBER + " but was " + cVarPeek + l());
        }
        int asInt = ((p) w()).getAsInt();
        x();
        int i2 = this.e0;
        if (i2 > 0) {
            int[] iArr = this.g0;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return asInt;
    }

    @Override // com.google.gson.e0.a
    public long p() throws IOException {
        com.google.gson.e0.c cVarPeek = peek();
        if (cVarPeek != com.google.gson.e0.c.NUMBER && cVarPeek != com.google.gson.e0.c.STRING) {
            throw new IllegalStateException("Expected " + com.google.gson.e0.c.NUMBER + " but was " + cVarPeek + l());
        }
        long asLong = ((p) w()).getAsLong();
        x();
        int i2 = this.e0;
        if (i2 > 0) {
            int[] iArr = this.g0;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return asLong;
    }

    @Override // com.google.gson.e0.a
    public com.google.gson.e0.c peek() throws IOException {
        if (this.e0 == 0) {
            return com.google.gson.e0.c.END_DOCUMENT;
        }
        Object objW = w();
        if (objW instanceof Iterator) {
            boolean z = this.d0[this.e0 - 2] instanceof JsonObject;
            Iterator it = (Iterator) objW;
            if (!it.hasNext()) {
                return z ? com.google.gson.e0.c.END_OBJECT : com.google.gson.e0.c.END_ARRAY;
            }
            if (z) {
                return com.google.gson.e0.c.NAME;
            }
            a(it.next());
            return peek();
        }
        if (objW instanceof JsonObject) {
            return com.google.gson.e0.c.BEGIN_OBJECT;
        }
        if (objW instanceof com.google.gson.h) {
            return com.google.gson.e0.c.BEGIN_ARRAY;
        }
        if (objW instanceof p) {
            p pVar = (p) objW;
            if (pVar.c()) {
                return com.google.gson.e0.c.STRING;
            }
            if (pVar.a()) {
                return com.google.gson.e0.c.BOOLEAN;
            }
            if (pVar.b()) {
                return com.google.gson.e0.c.NUMBER;
            }
            throw new AssertionError();
        }
        if (objW instanceof com.google.gson.m) {
            return com.google.gson.e0.c.NULL;
        }
        if (objW == i0) {
            throw new IllegalStateException("JsonReader is closed");
        }
        throw new com.google.gson.e0.e("Custom JsonElement subclass " + objW.getClass().getName() + " is not supported");
    }

    @Override // com.google.gson.e0.a
    public String q() throws IOException {
        return c(false);
    }

    @Override // com.google.gson.e0.a
    public void r() throws IOException {
        a(com.google.gson.e0.c.NULL);
        x();
        int i2 = this.e0;
        if (i2 > 0) {
            int[] iArr = this.g0;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    @Override // com.google.gson.e0.a
    public String s() throws IOException {
        com.google.gson.e0.c cVarPeek = peek();
        if (cVarPeek == com.google.gson.e0.c.STRING || cVarPeek == com.google.gson.e0.c.NUMBER) {
            String asString = ((p) x()).getAsString();
            int i2 = this.e0;
            if (i2 > 0) {
                int[] iArr = this.g0;
                int i3 = i2 - 1;
                iArr[i3] = iArr[i3] + 1;
            }
            return asString;
        }
        throw new IllegalStateException("Expected " + com.google.gson.e0.c.STRING + " but was " + cVarPeek + l());
    }

    @Override // com.google.gson.e0.a
    public void t() throws IOException {
        int i2 = b.f5566a[peek().ordinal()];
        if (i2 == 1) {
            c(true);
            return;
        }
        if (i2 == 2) {
            f();
            return;
        }
        if (i2 == 3) {
            g();
            return;
        }
        if (i2 != 4) {
            x();
            int i3 = this.e0;
            if (i3 > 0) {
                int[] iArr = this.g0;
                int i4 = i3 - 1;
                iArr[i4] = iArr[i4] + 1;
            }
        }
    }

    @Override // com.google.gson.e0.a
    public String toString() {
        return f.class.getSimpleName() + l();
    }

    com.google.gson.k u() throws IOException {
        com.google.gson.e0.c cVarPeek = peek();
        if (cVarPeek != com.google.gson.e0.c.NAME && cVarPeek != com.google.gson.e0.c.END_ARRAY && cVarPeek != com.google.gson.e0.c.END_OBJECT && cVarPeek != com.google.gson.e0.c.END_DOCUMENT) {
            com.google.gson.k kVar = (com.google.gson.k) w();
            t();
            return kVar;
        }
        throw new IllegalStateException("Unexpected " + cVarPeek + " when reading a JsonElement.");
    }

    public void v() throws IOException {
        a(com.google.gson.e0.c.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) w()).next();
        a(entry.getValue());
        a(new p((String) entry.getKey()));
    }

    private void a(Object obj) {
        int i2 = this.e0;
        Object[] objArr = this.d0;
        if (i2 == objArr.length) {
            int i3 = i2 * 2;
            this.d0 = Arrays.copyOf(objArr, i3);
            this.g0 = Arrays.copyOf(this.g0, i3);
            this.f0 = (String[]) Arrays.copyOf(this.f0, i3);
        }
        Object[] objArr2 = this.d0;
        int i4 = this.e0;
        this.e0 = i4 + 1;
        objArr2[i4] = obj;
    }

    private String c(boolean z) throws IOException {
        a(com.google.gson.e0.c.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) w()).next();
        String str = (String) entry.getKey();
        this.f0[this.e0 - 1] = z ? "<skipped>" : str;
        a(entry.getValue());
        return str;
    }
}
