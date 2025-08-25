package com.google.gson.e0;

import com.xiaomi.mipush.sdk.Constants;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

/* compiled from: JsonWriter.java */
/* loaded from: classes.dex */
public class d implements Closeable, Flushable {

    /* renamed from: j, reason: collision with root package name */
    private static final Pattern f5723j = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");

    /* renamed from: k, reason: collision with root package name */
    private static final String[] f5724k = new String[128];

    /* renamed from: l, reason: collision with root package name */
    private static final String[] f5725l;

    /* renamed from: a, reason: collision with root package name */
    private final Writer f5726a;

    /* renamed from: b, reason: collision with root package name */
    private int[] f5727b = new int[32];

    /* renamed from: c, reason: collision with root package name */
    private int f5728c = 0;

    /* renamed from: d, reason: collision with root package name */
    private String f5729d;

    /* renamed from: e, reason: collision with root package name */
    private String f5730e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f5731f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f5732g;

    /* renamed from: h, reason: collision with root package name */
    private String f5733h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f5734i;

    static {
        for (int i2 = 0; i2 <= 31; i2++) {
            f5724k[i2] = String.format("\\u%04x", Integer.valueOf(i2));
        }
        String[] strArr = f5724k;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        f5725l = (String[]) strArr.clone();
        String[] strArr2 = f5725l;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public d(Writer writer) {
        a(6);
        this.f5730e = Constants.COLON_SEPARATOR;
        this.f5734i = true;
        this.f5726a = (Writer) Objects.requireNonNull(writer, "out == null");
    }

    private void k() throws IOException {
        int iPeek = peek();
        if (iPeek == 5) {
            this.f5726a.write(44);
        } else if (iPeek != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        m();
        b(4);
    }

    private void l() throws IOException {
        int iPeek = peek();
        if (iPeek == 1) {
            b(2);
            m();
            return;
        }
        if (iPeek == 2) {
            this.f5726a.append(',');
            m();
        } else {
            if (iPeek == 4) {
                this.f5726a.append((CharSequence) this.f5730e);
                b(5);
                return;
            }
            if (iPeek != 6) {
                if (iPeek != 7) {
                    throw new IllegalStateException("Nesting problem.");
                }
                if (!this.f5731f) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            b(7);
        }
    }

    private void m() throws IOException {
        if (this.f5729d == null) {
            return;
        }
        this.f5726a.write(10);
        int i2 = this.f5728c;
        for (int i3 = 1; i3 < i2; i3++) {
            this.f5726a.write(this.f5729d);
        }
    }

    private void n() throws IOException {
        if (this.f5733h != null) {
            k();
            e(this.f5733h);
            this.f5733h = null;
        }
    }

    private int peek() {
        int i2 = this.f5728c;
        if (i2 != 0) {
            return this.f5727b[i2 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public final void a(boolean z) {
        this.f5732g = z;
    }

    public final void b(boolean z) {
        this.f5731f = z;
    }

    public final void c(String str) {
        if (str.length() == 0) {
            this.f5729d = null;
            this.f5730e = Constants.COLON_SEPARATOR;
        } else {
            this.f5729d = str;
            this.f5730e = ": ";
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f5726a.close();
        int i2 = this.f5728c;
        if (i2 > 1 || (i2 == 1 && this.f5727b[i2 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f5728c = 0;
    }

    public d d() throws IOException {
        n();
        return a(3, '{');
    }

    public d e() throws IOException {
        return a(1, 2, ']');
    }

    public d f() throws IOException {
        return a(3, 5, '}');
    }

    public void flush() throws IOException {
        if (this.f5728c == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f5726a.flush();
    }

    public final boolean g() {
        return this.f5734i;
    }

    public final boolean h() {
        return this.f5732g;
    }

    public boolean i() {
        return this.f5731f;
    }

    public d j() throws IOException {
        if (this.f5733h != null) {
            if (!this.f5734i) {
                this.f5733h = null;
                return this;
            }
            n();
        }
        l();
        this.f5726a.write(c.c.a.b.a.a.f3101h);
        return this;
    }

    private d a(int i2, char c2) throws IOException {
        l();
        a(i2);
        this.f5726a.write(c2);
        return this;
    }

    private void b(int i2) {
        this.f5727b[this.f5728c - 1] = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void e(java.lang.String r9) throws java.io.IOException {
        /*
            r8 = this;
            boolean r0 = r8.f5732g
            if (r0 == 0) goto L7
            java.lang.String[] r0 = com.google.gson.e0.d.f5725l
            goto L9
        L7:
            java.lang.String[] r0 = com.google.gson.e0.d.f5724k
        L9:
            java.io.Writer r1 = r8.f5726a
            r2 = 34
            r1.write(r2)
            int r1 = r9.length()
            r3 = 0
            r4 = 0
        L16:
            if (r3 >= r1) goto L45
            char r5 = r9.charAt(r3)
            r6 = 128(0x80, float:1.8E-43)
            if (r5 >= r6) goto L25
            r5 = r0[r5]
            if (r5 != 0) goto L32
            goto L42
        L25:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L2c
            java.lang.String r5 = "\\u2028"
            goto L32
        L2c:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L42
            java.lang.String r5 = "\\u2029"
        L32:
            if (r4 >= r3) goto L3b
            java.io.Writer r6 = r8.f5726a
            int r7 = r3 - r4
            r6.write(r9, r4, r7)
        L3b:
            java.io.Writer r4 = r8.f5726a
            r4.write(r5)
            int r4 = r3 + 1
        L42:
            int r3 = r3 + 1
            goto L16
        L45:
            if (r4 >= r1) goto L4d
            java.io.Writer r0 = r8.f5726a
            int r1 = r1 - r4
            r0.write(r9, r4, r1)
        L4d:
            java.io.Writer r9 = r8.f5726a
            r9.write(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.e0.d.e(java.lang.String):void");
    }

    public d b(String str) throws IOException {
        Objects.requireNonNull(str, "name == null");
        if (this.f5733h == null) {
            if (this.f5728c != 0) {
                this.f5733h = str;
                return this;
            }
            throw new IllegalStateException("JsonWriter is closed.");
        }
        throw new IllegalStateException();
    }

    public d d(String str) throws IOException {
        if (str == null) {
            return j();
        }
        n();
        l();
        e(str);
        return this;
    }

    private d a(int i2, int i3, char c2) throws IOException {
        int iPeek = peek();
        if (iPeek != i3 && iPeek != i2) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.f5733h == null) {
            this.f5728c--;
            if (iPeek == i3) {
                m();
            }
            this.f5726a.write(c2);
            return this;
        }
        throw new IllegalStateException("Dangling name: " + this.f5733h);
    }

    public final void c(boolean z) {
        this.f5734i = z;
    }

    public d c() throws IOException {
        n();
        return a(1, '[');
    }

    public d d(boolean z) throws IOException {
        n();
        l();
        this.f5726a.write(z ? a.a.u.a.f1253j : a.a.u.a.f1254k);
        return this;
    }

    private void a(int i2) {
        int i3 = this.f5728c;
        int[] iArr = this.f5727b;
        if (i3 == iArr.length) {
            this.f5727b = Arrays.copyOf(iArr, i3 * 2);
        }
        int[] iArr2 = this.f5727b;
        int i4 = this.f5728c;
        this.f5728c = i4 + 1;
        iArr2[i4] = i2;
    }

    public d a(String str) throws IOException {
        if (str == null) {
            return j();
        }
        n();
        l();
        this.f5726a.append((CharSequence) str);
        return this;
    }

    public d a(Boolean bool) throws IOException {
        if (bool == null) {
            return j();
        }
        n();
        l();
        this.f5726a.write(bool.booleanValue() ? a.a.u.a.f1253j : a.a.u.a.f1254k);
        return this;
    }

    public d a(float f2) throws IOException {
        n();
        if (!this.f5731f && (Float.isNaN(f2) || Float.isInfinite(f2))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + f2);
        }
        l();
        this.f5726a.append((CharSequence) Float.toString(f2));
        return this;
    }

    public d a(double d2) throws IOException {
        n();
        if (!this.f5731f && (Double.isNaN(d2) || Double.isInfinite(d2))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + d2);
        }
        l();
        this.f5726a.append((CharSequence) Double.toString(d2));
        return this;
    }

    public d a(long j2) throws IOException {
        n();
        l();
        this.f5726a.write(Long.toString(j2));
        return this;
    }

    private static boolean a(Class<? extends Number> cls) {
        return cls == Integer.class || cls == Long.class || cls == Double.class || cls == Float.class || cls == Byte.class || cls == Short.class || cls == BigDecimal.class || cls == BigInteger.class || cls == AtomicInteger.class || cls == AtomicLong.class;
    }

    public d a(Number number) throws IOException {
        if (number == null) {
            return j();
        }
        n();
        String string = number.toString();
        if (!string.equals("-Infinity") && !string.equals("Infinity") && !string.equals("NaN")) {
            Class<?> cls = number.getClass();
            if (!a((Class<? extends Number>) cls) && !f5723j.matcher(string).matches()) {
                throw new IllegalArgumentException("String created by " + cls + " is not a valid JSON number: " + string);
            }
        } else if (!this.f5731f) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + string);
        }
        l();
        this.f5726a.append((CharSequence) string);
        return this;
    }
}
