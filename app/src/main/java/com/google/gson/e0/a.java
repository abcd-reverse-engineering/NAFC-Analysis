package com.google.gson.e0;

import com.google.gson.b0.g;
import h.z2.h0;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;

/* compiled from: JsonReader.java */
/* loaded from: classes.dex */
public class a implements Closeable {
    private static final int A = 10;
    private static final int B = 11;
    private static final int C = 12;
    private static final int D = 13;
    private static final int E = 14;
    private static final int F = 15;
    private static final int G = 16;
    private static final int H = 17;
    private static final int I = 0;
    private static final int J = 1;
    private static final int K = 2;
    private static final int L = 3;
    private static final int M = 4;
    private static final int N = 5;
    private static final int O = 6;
    private static final int b0 = 7;
    static final int c0 = 1024;
    private static final long p = -922337203685477580L;
    private static final int q = 0;
    private static final int r = 1;
    private static final int s = 2;
    private static final int t = 3;
    private static final int u = 4;
    private static final int v = 5;
    private static final int w = 6;
    private static final int x = 7;
    private static final int y = 8;
    private static final int z = 9;

    /* renamed from: a, reason: collision with root package name */
    private final Reader f5701a;

    /* renamed from: i, reason: collision with root package name */
    private long f5709i;

    /* renamed from: j, reason: collision with root package name */
    private int f5710j;

    /* renamed from: k, reason: collision with root package name */
    private String f5711k;

    /* renamed from: m, reason: collision with root package name */
    private int f5713m;
    private String[] n;
    private int[] o;

    /* renamed from: b, reason: collision with root package name */
    private boolean f5702b = false;

    /* renamed from: c, reason: collision with root package name */
    private final char[] f5703c = new char[1024];

    /* renamed from: d, reason: collision with root package name */
    private int f5704d = 0;

    /* renamed from: e, reason: collision with root package name */
    private int f5705e = 0;

    /* renamed from: f, reason: collision with root package name */
    private int f5706f = 0;

    /* renamed from: g, reason: collision with root package name */
    private int f5707g = 0;

    /* renamed from: h, reason: collision with root package name */
    int f5708h = 0;

    /* renamed from: l, reason: collision with root package name */
    private int[] f5712l = new int[32];

    /* compiled from: JsonReader.java */
    /* renamed from: com.google.gson.e0.a$a, reason: collision with other inner class name */
    class C0092a extends g {
        C0092a() {
        }

        @Override // com.google.gson.b0.g
        public void a(a aVar) throws IOException {
            if (aVar instanceof com.google.gson.b0.q.f) {
                ((com.google.gson.b0.q.f) aVar).v();
                return;
            }
            int iE = aVar.f5708h;
            if (iE == 0) {
                iE = aVar.e();
            }
            if (iE == 13) {
                aVar.f5708h = 9;
                return;
            }
            if (iE == 12) {
                aVar.f5708h = 8;
                return;
            }
            if (iE == 14) {
                aVar.f5708h = 10;
                return;
            }
            throw new IllegalStateException("Expected a name but was " + aVar.peek() + aVar.l());
        }
    }

    static {
        g.f5520a = new C0092a();
    }

    public a(Reader reader) {
        this.f5713m = 0;
        int[] iArr = this.f5712l;
        int i2 = this.f5713m;
        this.f5713m = i2 + 1;
        iArr[i2] = 6;
        this.n = new String[32];
        this.o = new int[32];
        this.f5701a = (Reader) Objects.requireNonNull(reader, "in == null");
    }

    private void A() throws IOException {
        char c2;
        do {
            if (this.f5704d >= this.f5705e && !a(1)) {
                return;
            }
            char[] cArr = this.f5703c;
            int i2 = this.f5704d;
            this.f5704d = i2 + 1;
            c2 = cArr[i2];
            if (c2 == '\n') {
                this.f5706f++;
                this.f5707g = this.f5704d;
                return;
            }
        } while (c2 != '\r');
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0048, code lost:
    
        u();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void B() throws java.io.IOException {
        /*
            r4 = this;
        L0:
            r0 = 0
        L1:
            int r1 = r4.f5704d
            int r2 = r1 + r0
            int r3 = r4.f5705e
            if (r2 >= r3) goto L51
            char[] r2 = r4.f5703c
            int r1 = r1 + r0
            char r1 = r2[r1]
            r2 = 9
            if (r1 == r2) goto L4b
            r2 = 10
            if (r1 == r2) goto L4b
            r2 = 12
            if (r1 == r2) goto L4b
            r2 = 13
            if (r1 == r2) goto L4b
            r2 = 32
            if (r1 == r2) goto L4b
            r2 = 35
            if (r1 == r2) goto L48
            r2 = 44
            if (r1 == r2) goto L4b
            r2 = 47
            if (r1 == r2) goto L48
            r2 = 61
            if (r1 == r2) goto L48
            r2 = 123(0x7b, float:1.72E-43)
            if (r1 == r2) goto L4b
            r2 = 125(0x7d, float:1.75E-43)
            if (r1 == r2) goto L4b
            r2 = 58
            if (r1 == r2) goto L4b
            r2 = 59
            if (r1 == r2) goto L48
            switch(r1) {
                case 91: goto L4b;
                case 92: goto L48;
                case 93: goto L4b;
                default: goto L45;
            }
        L45:
            int r0 = r0 + 1
            goto L1
        L48:
            r4.u()
        L4b:
            int r1 = r4.f5704d
            int r1 = r1 + r0
            r4.f5704d = r1
            return
        L51:
            int r1 = r1 + r0
            r4.f5704d = r1
            r0 = 1
            boolean r0 = r4.a(r0)
            if (r0 != 0) goto L0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.e0.a.B():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005b, code lost:
    
        if (r1 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005d, code lost:
    
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r2 - r4) * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006b, code lost:
    
        r1.append(r0, r4, r2 - r4);
        r9.f5704d = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String b(char r10) throws java.io.IOException {
        /*
            r9 = this;
            char[] r0 = r9.f5703c
            r1 = 0
        L3:
            int r2 = r9.f5704d
            int r3 = r9.f5705e
        L7:
            r4 = r2
        L8:
            r5 = 16
            r6 = 1
            if (r2 >= r3) goto L5b
            int r7 = r2 + 1
            char r2 = r0[r2]
            if (r2 != r10) goto L27
            r9.f5704d = r7
            int r7 = r7 - r4
            int r7 = r7 - r6
            if (r1 != 0) goto L1f
            java.lang.String r10 = new java.lang.String
            r10.<init>(r0, r4, r7)
            return r10
        L1f:
            r1.append(r0, r4, r7)
            java.lang.String r10 = r1.toString()
            return r10
        L27:
            r8 = 92
            if (r2 != r8) goto L4e
            r9.f5704d = r7
            int r7 = r7 - r4
            int r7 = r7 - r6
            if (r1 != 0) goto L3f
            int r1 = r7 + 1
            int r1 = r1 * 2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r5)
            r2.<init>(r1)
            r1 = r2
        L3f:
            r1.append(r0, r4, r7)
            char r2 = r9.z()
            r1.append(r2)
            int r2 = r9.f5704d
            int r3 = r9.f5705e
            goto L7
        L4e:
            r5 = 10
            if (r2 != r5) goto L59
            int r2 = r9.f5706f
            int r2 = r2 + r6
            r9.f5706f = r2
            r9.f5707g = r7
        L59:
            r2 = r7
            goto L8
        L5b:
            if (r1 != 0) goto L6b
            int r1 = r2 - r4
            int r1 = r1 * 2
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r5)
            r3.<init>(r1)
            r1 = r3
        L6b:
            int r3 = r2 - r4
            r1.append(r0, r4, r3)
            r9.f5704d = r2
            boolean r2 = r9.a(r6)
            if (r2 == 0) goto L79
            goto L3
        L79:
            java.lang.String r10 = "Unterminated string"
            java.io.IOException r10 = r9.b(r10)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.e0.a.b(char):java.lang.String");
    }

    private void u() throws IOException {
        if (!this.f5702b) {
            throw b("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void v() throws IOException {
        c(true);
        this.f5704d--;
        if (this.f5704d + 5 <= this.f5705e || a(5)) {
            int i2 = this.f5704d;
            char[] cArr = this.f5703c;
            if (cArr[i2] == ')' && cArr[i2 + 1] == ']' && cArr[i2 + 2] == '}' && cArr[i2 + 3] == '\'' && cArr[i2 + 4] == '\n') {
                this.f5704d = i2 + 5;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x004b, code lost:
    
        u();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0045. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String w() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
            r2 = r1
        L3:
            r1 = 0
        L4:
            int r3 = r6.f5704d
            int r4 = r3 + r1
            int r5 = r6.f5705e
            if (r4 >= r5) goto L4f
            char[] r4 = r6.f5703c
            int r3 = r3 + r1
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L5d
            r4 = 10
            if (r3 == r4) goto L5d
            r4 = 12
            if (r3 == r4) goto L5d
            r4 = 13
            if (r3 == r4) goto L5d
            r4 = 32
            if (r3 == r4) goto L5d
            r4 = 35
            if (r3 == r4) goto L4b
            r4 = 44
            if (r3 == r4) goto L5d
            r4 = 47
            if (r3 == r4) goto L4b
            r4 = 61
            if (r3 == r4) goto L4b
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L5d
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L5d
            r4 = 58
            if (r3 == r4) goto L5d
            r4 = 59
            if (r3 == r4) goto L4b
            switch(r3) {
                case 91: goto L5d;
                case 92: goto L4b;
                case 93: goto L5d;
                default: goto L48;
            }
        L48:
            int r1 = r1 + 1
            goto L4
        L4b:
            r6.u()
            goto L5d
        L4f:
            char[] r3 = r6.f5703c
            int r3 = r3.length
            if (r1 >= r3) goto L5f
            int r3 = r1 + 1
            boolean r3 = r6.a(r3)
            if (r3 == 0) goto L5d
            goto L4
        L5d:
            r0 = r1
            goto L7f
        L5f:
            if (r2 != 0) goto L6c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r1, r3)
            r2.<init>(r3)
        L6c:
            char[] r3 = r6.f5703c
            int r4 = r6.f5704d
            r2.append(r3, r4, r1)
            int r3 = r6.f5704d
            int r3 = r3 + r1
            r6.f5704d = r3
            r1 = 1
            boolean r1 = r6.a(r1)
            if (r1 != 0) goto L3
        L7f:
            if (r2 != 0) goto L8b
            java.lang.String r1 = new java.lang.String
            char[] r2 = r6.f5703c
            int r3 = r6.f5704d
            r1.<init>(r2, r3, r0)
            goto L96
        L8b:
            char[] r1 = r6.f5703c
            int r3 = r6.f5704d
            r2.append(r1, r3, r0)
            java.lang.String r1 = r2.toString()
        L96:
            int r2 = r6.f5704d
            int r2 = r2 + r0
            r6.f5704d = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.e0.a.w():java.lang.String");
    }

    private int x() throws IOException {
        int i2;
        String str;
        String str2;
        char c2 = this.f5703c[this.f5704d];
        if (c2 == 't' || c2 == 'T') {
            i2 = 5;
            str = a.a.u.a.f1253j;
            str2 = "TRUE";
        } else if (c2 == 'f' || c2 == 'F') {
            i2 = 6;
            str = a.a.u.a.f1254k;
            str2 = "FALSE";
        } else {
            if (c2 != 'n' && c2 != 'N') {
                return 0;
            }
            i2 = 7;
            str = c.c.a.b.a.a.f3101h;
            str2 = "NULL";
        }
        int length = str.length();
        for (int i3 = 1; i3 < length; i3++) {
            if (this.f5704d + i3 >= this.f5705e && !a(i3 + 1)) {
                return 0;
            }
            char c3 = this.f5703c[this.f5704d + i3];
            if (c3 != str.charAt(i3) && c3 != str2.charAt(i3)) {
                return 0;
            }
        }
        if ((this.f5704d + length < this.f5705e || a(length + 1)) && a(this.f5703c[this.f5704d + length])) {
            return 0;
        }
        this.f5704d += length;
        this.f5708h = i2;
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0098, code lost:
    
        if (a(r14) != false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x009a, code lost:
    
        if (r9 != 2) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x009c, code lost:
    
        if (r10 == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00a2, code lost:
    
        if (r11 != Long.MIN_VALUE) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00a4, code lost:
    
        if (r13 == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00aa, code lost:
    
        if (r11 != 0) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00ac, code lost:
    
        if (r13 != false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00ae, code lost:
    
        if (r13 == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00b1, code lost:
    
        r11 = -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00b2, code lost:
    
        r18.f5709i = r11;
        r18.f5704d += r3;
        r18.f5708h = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00bd, code lost:
    
        return 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00be, code lost:
    
        if (r9 == 2) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00c1, code lost:
    
        if (r9 == 4) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00c4, code lost:
    
        if (r9 != 7) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00c7, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00c9, code lost:
    
        r18.f5710j = r3;
        r18.f5708h = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00cf, code lost:
    
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00d0, code lost:
    
        return 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00f3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int y() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 255
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.e0.a.y():int");
    }

    private char z() throws IOException {
        int i2;
        int i3;
        if (this.f5704d == this.f5705e && !a(1)) {
            throw b("Unterminated escape sequence");
        }
        char[] cArr = this.f5703c;
        int i4 = this.f5704d;
        this.f5704d = i4 + 1;
        char c2 = cArr[i4];
        if (c2 == '\n') {
            this.f5706f++;
            this.f5707g = this.f5704d;
        } else if (c2 != '\"' && c2 != '\'' && c2 != '/' && c2 != '\\') {
            if (c2 == 'b') {
                return '\b';
            }
            if (c2 == 'f') {
                return '\f';
            }
            if (c2 == 'n') {
                return '\n';
            }
            if (c2 == 'r') {
                return '\r';
            }
            if (c2 == 't') {
                return '\t';
            }
            if (c2 != 'u') {
                throw b("Invalid escape sequence");
            }
            if (this.f5704d + 4 > this.f5705e && !a(4)) {
                throw b("Unterminated escape sequence");
            }
            char c3 = 0;
            int i5 = this.f5704d;
            int i6 = i5 + 4;
            while (i5 < i6) {
                char c4 = this.f5703c[i5];
                char c5 = (char) (c3 << 4);
                if (c4 < '0' || c4 > '9') {
                    if (c4 >= 'a' && c4 <= 'f') {
                        i2 = c4 - 'a';
                    } else {
                        if (c4 < 'A' || c4 > 'F') {
                            throw new NumberFormatException("\\u" + new String(this.f5703c, this.f5704d, 4));
                        }
                        i2 = c4 - 'A';
                    }
                    i3 = i2 + 10;
                } else {
                    i3 = c4 - '0';
                }
                c3 = (char) (c5 + i3);
                i5++;
            }
            this.f5704d += 4;
            return c3;
        }
        return c2;
    }

    public final void a(boolean z2) {
        this.f5702b = z2;
    }

    public void c() throws IOException {
        int iE = this.f5708h;
        if (iE == 0) {
            iE = e();
        }
        if (iE == 3) {
            b(1);
            this.o[this.f5713m - 1] = 0;
            this.f5708h = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_ARRAY but was " + peek() + l());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f5708h = 0;
        this.f5712l[0] = 8;
        this.f5713m = 1;
        this.f5701a.close();
    }

    public void d() throws IOException {
        int iE = this.f5708h;
        if (iE == 0) {
            iE = e();
        }
        if (iE == 1) {
            b(3);
            this.f5708h = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_OBJECT but was " + peek() + l());
        }
    }

    int e() throws IOException {
        int iC;
        int[] iArr = this.f5712l;
        int i2 = this.f5713m;
        int i3 = iArr[i2 - 1];
        if (i3 == 1) {
            iArr[i2 - 1] = 2;
        } else if (i3 == 2) {
            int iC2 = c(true);
            if (iC2 != 44) {
                if (iC2 != 59) {
                    if (iC2 != 93) {
                        throw b("Unterminated array");
                    }
                    this.f5708h = 4;
                    return 4;
                }
                u();
            }
        } else {
            if (i3 == 3 || i3 == 5) {
                this.f5712l[this.f5713m - 1] = 4;
                if (i3 == 5 && (iC = c(true)) != 44) {
                    if (iC != 59) {
                        if (iC != 125) {
                            throw b("Unterminated object");
                        }
                        this.f5708h = 2;
                        return 2;
                    }
                    u();
                }
                int iC3 = c(true);
                if (iC3 == 34) {
                    this.f5708h = 13;
                    return 13;
                }
                if (iC3 == 39) {
                    u();
                    this.f5708h = 12;
                    return 12;
                }
                if (iC3 == 125) {
                    if (i3 == 5) {
                        throw b("Expected name");
                    }
                    this.f5708h = 2;
                    return 2;
                }
                u();
                this.f5704d--;
                if (!a((char) iC3)) {
                    throw b("Expected name");
                }
                this.f5708h = 14;
                return 14;
            }
            if (i3 == 4) {
                iArr[i2 - 1] = 5;
                int iC4 = c(true);
                if (iC4 != 58) {
                    if (iC4 != 61) {
                        throw b("Expected ':'");
                    }
                    u();
                    if (this.f5704d < this.f5705e || a(1)) {
                        char[] cArr = this.f5703c;
                        int i4 = this.f5704d;
                        if (cArr[i4] == '>') {
                            this.f5704d = i4 + 1;
                        }
                    }
                }
            } else if (i3 == 6) {
                if (this.f5702b) {
                    v();
                }
                this.f5712l[this.f5713m - 1] = 7;
            } else if (i3 == 7) {
                if (c(false) == -1) {
                    this.f5708h = 17;
                    return 17;
                }
                u();
                this.f5704d--;
            } else if (i3 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int iC5 = c(true);
        if (iC5 == 34) {
            this.f5708h = 9;
            return 9;
        }
        if (iC5 == 39) {
            u();
            this.f5708h = 8;
            return 8;
        }
        if (iC5 != 44 && iC5 != 59) {
            if (iC5 == 91) {
                this.f5708h = 3;
                return 3;
            }
            if (iC5 != 93) {
                if (iC5 == 123) {
                    this.f5708h = 1;
                    return 1;
                }
                this.f5704d--;
                int iX = x();
                if (iX != 0) {
                    return iX;
                }
                int iY = y();
                if (iY != 0) {
                    return iY;
                }
                if (!a(this.f5703c[this.f5704d])) {
                    throw b("Expected value");
                }
                u();
                this.f5708h = 10;
                return 10;
            }
            if (i3 == 1) {
                this.f5708h = 4;
                return 4;
            }
        }
        if (i3 != 1 && i3 != 2) {
            throw b("Unexpected value");
        }
        u();
        this.f5704d--;
        this.f5708h = 7;
        return 7;
    }

    public void f() throws IOException {
        int iE = this.f5708h;
        if (iE == 0) {
            iE = e();
        }
        if (iE != 4) {
            throw new IllegalStateException("Expected END_ARRAY but was " + peek() + l());
        }
        this.f5713m--;
        int[] iArr = this.o;
        int i2 = this.f5713m - 1;
        iArr[i2] = iArr[i2] + 1;
        this.f5708h = 0;
    }

    public void g() throws IOException {
        int iE = this.f5708h;
        if (iE == 0) {
            iE = e();
        }
        if (iE != 2) {
            throw new IllegalStateException("Expected END_OBJECT but was " + peek() + l());
        }
        this.f5713m--;
        String[] strArr = this.n;
        int i2 = this.f5713m;
        strArr[i2] = null;
        int[] iArr = this.o;
        int i3 = i2 - 1;
        iArr[i3] = iArr[i3] + 1;
        this.f5708h = 0;
    }

    public String h() {
        return b(false);
    }

    public String i() {
        return b(true);
    }

    public boolean j() throws IOException {
        int iE = this.f5708h;
        if (iE == 0) {
            iE = e();
        }
        return (iE == 2 || iE == 4 || iE == 17) ? false : true;
    }

    public final boolean k() {
        return this.f5702b;
    }

    String l() {
        return " at line " + (this.f5706f + 1) + " column " + ((this.f5704d - this.f5707g) + 1) + " path " + h();
    }

    public boolean m() throws IOException {
        int iE = this.f5708h;
        if (iE == 0) {
            iE = e();
        }
        if (iE == 5) {
            this.f5708h = 0;
            int[] iArr = this.o;
            int i2 = this.f5713m - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        }
        if (iE == 6) {
            this.f5708h = 0;
            int[] iArr2 = this.o;
            int i3 = this.f5713m - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        }
        throw new IllegalStateException("Expected a boolean but was " + peek() + l());
    }

    public double n() throws IOException, NumberFormatException {
        int iE = this.f5708h;
        if (iE == 0) {
            iE = e();
        }
        if (iE == 15) {
            this.f5708h = 0;
            int[] iArr = this.o;
            int i2 = this.f5713m - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.f5709i;
        }
        if (iE == 16) {
            this.f5711k = new String(this.f5703c, this.f5704d, this.f5710j);
            this.f5704d += this.f5710j;
        } else if (iE == 8 || iE == 9) {
            this.f5711k = b(iE == 8 ? '\'' : h0.f16704a);
        } else if (iE == 10) {
            this.f5711k = w();
        } else if (iE != 11) {
            throw new IllegalStateException("Expected a double but was " + peek() + l());
        }
        this.f5708h = 11;
        double d2 = Double.parseDouble(this.f5711k);
        if (!this.f5702b && (Double.isNaN(d2) || Double.isInfinite(d2))) {
            throw new e("JSON forbids NaN and infinities: " + d2 + l());
        }
        this.f5711k = null;
        this.f5708h = 0;
        int[] iArr2 = this.o;
        int i3 = this.f5713m - 1;
        iArr2[i3] = iArr2[i3] + 1;
        return d2;
    }

    public int o() throws IOException, NumberFormatException {
        int iE = this.f5708h;
        if (iE == 0) {
            iE = e();
        }
        if (iE == 15) {
            long j2 = this.f5709i;
            int i2 = (int) j2;
            if (j2 == i2) {
                this.f5708h = 0;
                int[] iArr = this.o;
                int i3 = this.f5713m - 1;
                iArr[i3] = iArr[i3] + 1;
                return i2;
            }
            throw new NumberFormatException("Expected an int but was " + this.f5709i + l());
        }
        if (iE == 16) {
            this.f5711k = new String(this.f5703c, this.f5704d, this.f5710j);
            this.f5704d += this.f5710j;
        } else {
            if (iE != 8 && iE != 9 && iE != 10) {
                throw new IllegalStateException("Expected an int but was " + peek() + l());
            }
            if (iE == 10) {
                this.f5711k = w();
            } else {
                this.f5711k = b(iE == 8 ? '\'' : h0.f16704a);
            }
            try {
                int i4 = Integer.parseInt(this.f5711k);
                this.f5708h = 0;
                int[] iArr2 = this.o;
                int i5 = this.f5713m - 1;
                iArr2[i5] = iArr2[i5] + 1;
                return i4;
            } catch (NumberFormatException unused) {
            }
        }
        this.f5708h = 11;
        double d2 = Double.parseDouble(this.f5711k);
        int i6 = (int) d2;
        if (i6 != d2) {
            throw new NumberFormatException("Expected an int but was " + this.f5711k + l());
        }
        this.f5711k = null;
        this.f5708h = 0;
        int[] iArr3 = this.o;
        int i7 = this.f5713m - 1;
        iArr3[i7] = iArr3[i7] + 1;
        return i6;
    }

    public long p() throws IOException, NumberFormatException {
        int iE = this.f5708h;
        if (iE == 0) {
            iE = e();
        }
        if (iE == 15) {
            this.f5708h = 0;
            int[] iArr = this.o;
            int i2 = this.f5713m - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.f5709i;
        }
        if (iE == 16) {
            this.f5711k = new String(this.f5703c, this.f5704d, this.f5710j);
            this.f5704d += this.f5710j;
        } else {
            if (iE != 8 && iE != 9 && iE != 10) {
                throw new IllegalStateException("Expected a long but was " + peek() + l());
            }
            if (iE == 10) {
                this.f5711k = w();
            } else {
                this.f5711k = b(iE == 8 ? '\'' : h0.f16704a);
            }
            try {
                long j2 = Long.parseLong(this.f5711k);
                this.f5708h = 0;
                int[] iArr2 = this.o;
                int i3 = this.f5713m - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return j2;
            } catch (NumberFormatException unused) {
            }
        }
        this.f5708h = 11;
        double d2 = Double.parseDouble(this.f5711k);
        long j3 = (long) d2;
        if (j3 != d2) {
            throw new NumberFormatException("Expected a long but was " + this.f5711k + l());
        }
        this.f5711k = null;
        this.f5708h = 0;
        int[] iArr3 = this.o;
        int i4 = this.f5713m - 1;
        iArr3[i4] = iArr3[i4] + 1;
        return j3;
    }

    public c peek() throws IOException {
        int iE = this.f5708h;
        if (iE == 0) {
            iE = e();
        }
        switch (iE) {
            case 1:
                return c.BEGIN_OBJECT;
            case 2:
                return c.END_OBJECT;
            case 3:
                return c.BEGIN_ARRAY;
            case 4:
                return c.END_ARRAY;
            case 5:
            case 6:
                return c.BOOLEAN;
            case 7:
                return c.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return c.STRING;
            case 12:
            case 13:
            case 14:
                return c.NAME;
            case 15:
            case 16:
                return c.NUMBER;
            case 17:
                return c.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public String q() throws IOException {
        String strB;
        int iE = this.f5708h;
        if (iE == 0) {
            iE = e();
        }
        if (iE == 14) {
            strB = w();
        } else if (iE == 12) {
            strB = b('\'');
        } else {
            if (iE != 13) {
                throw new IllegalStateException("Expected a name but was " + peek() + l());
            }
            strB = b(h0.f16704a);
        }
        this.f5708h = 0;
        this.n[this.f5713m - 1] = strB;
        return strB;
    }

    public void r() throws IOException {
        int iE = this.f5708h;
        if (iE == 0) {
            iE = e();
        }
        if (iE == 7) {
            this.f5708h = 0;
            int[] iArr = this.o;
            int i2 = this.f5713m - 1;
            iArr[i2] = iArr[i2] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + peek() + l());
    }

    public String s() throws IOException {
        String str;
        int iE = this.f5708h;
        if (iE == 0) {
            iE = e();
        }
        if (iE == 10) {
            str = w();
        } else if (iE == 8) {
            str = b('\'');
        } else if (iE == 9) {
            str = b(h0.f16704a);
        } else if (iE == 11) {
            str = this.f5711k;
            this.f5711k = null;
        } else if (iE == 15) {
            str = Long.toString(this.f5709i);
        } else {
            if (iE != 16) {
                throw new IllegalStateException("Expected a string but was " + peek() + l());
            }
            str = new String(this.f5703c, this.f5704d, this.f5710j);
            this.f5704d += this.f5710j;
        }
        this.f5708h = 0;
        int[] iArr = this.o;
        int i2 = this.f5713m - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void t() throws IOException {
        int i2 = 0;
        do {
            int iE = this.f5708h;
            if (iE == 0) {
                iE = e();
            }
            switch (iE) {
                case 1:
                    b(3);
                    i2++;
                    this.f5708h = 0;
                    break;
                case 2:
                    if (i2 == 0) {
                        this.n[this.f5713m - 1] = null;
                    }
                    this.f5713m--;
                    i2--;
                    this.f5708h = 0;
                    break;
                case 3:
                    b(1);
                    i2++;
                    this.f5708h = 0;
                    break;
                case 4:
                    this.f5713m--;
                    i2--;
                    this.f5708h = 0;
                    break;
                case 5:
                case 6:
                case 7:
                case 11:
                case 15:
                default:
                    this.f5708h = 0;
                    break;
                case 8:
                    c('\'');
                    this.f5708h = 0;
                    break;
                case 9:
                    c(h0.f16704a);
                    this.f5708h = 0;
                    break;
                case 10:
                    B();
                    this.f5708h = 0;
                    break;
                case 12:
                    c('\'');
                    if (i2 == 0) {
                        this.n[this.f5713m - 1] = "<skipped>";
                    }
                    this.f5708h = 0;
                    break;
                case 13:
                    c(h0.f16704a);
                    if (i2 == 0) {
                        this.n[this.f5713m - 1] = "<skipped>";
                    }
                    this.f5708h = 0;
                    break;
                case 14:
                    B();
                    if (i2 == 0) {
                        this.n[this.f5713m - 1] = "<skipped>";
                    }
                    this.f5708h = 0;
                    break;
                case 16:
                    this.f5704d += this.f5710j;
                    this.f5708h = 0;
                    break;
                case 17:
                    break;
            }
            return;
        } while (i2 > 0);
        int[] iArr = this.o;
        int i3 = this.f5713m - 1;
        iArr[i3] = iArr[i3] + 1;
    }

    public String toString() {
        return getClass().getSimpleName() + l();
    }

    private boolean a(char c2) throws IOException {
        if (c2 == '\t' || c2 == '\n' || c2 == '\f' || c2 == '\r' || c2 == ' ') {
            return false;
        }
        if (c2 != '#') {
            if (c2 == ',') {
                return false;
            }
            if (c2 != '/' && c2 != '=') {
                if (c2 == '{' || c2 == '}' || c2 == ':') {
                    return false;
                }
                if (c2 != ';') {
                    switch (c2) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        u();
        return false;
    }

    private boolean a(int i2) throws IOException {
        int i3;
        char[] cArr = this.f5703c;
        int i4 = this.f5707g;
        int i5 = this.f5704d;
        this.f5707g = i4 - i5;
        int i6 = this.f5705e;
        if (i6 != i5) {
            this.f5705e = i6 - i5;
            System.arraycopy(cArr, i5, cArr, 0, this.f5705e);
        } else {
            this.f5705e = 0;
        }
        this.f5704d = 0;
        do {
            Reader reader = this.f5701a;
            int i7 = this.f5705e;
            int i8 = reader.read(cArr, i7, cArr.length - i7);
            if (i8 == -1) {
                return false;
            }
            this.f5705e += i8;
            if (this.f5706f == 0 && (i3 = this.f5707g) == 0 && this.f5705e > 0 && cArr[0] == 65279) {
                this.f5704d++;
                this.f5707g = i3 + 1;
                i2++;
            }
        } while (this.f5705e < i2);
        return true;
    }

    private void c(char c2) throws IOException {
        char[] cArr = this.f5703c;
        do {
            int i2 = this.f5704d;
            int i3 = this.f5705e;
            while (i2 < i3) {
                int i4 = i2 + 1;
                char c3 = cArr[i2];
                if (c3 == c2) {
                    this.f5704d = i4;
                    return;
                }
                if (c3 == '\\') {
                    this.f5704d = i4;
                    z();
                    i2 = this.f5704d;
                    i3 = this.f5705e;
                } else {
                    if (c3 == '\n') {
                        this.f5706f++;
                        this.f5707g = i4;
                    }
                    i2 = i4;
                }
            }
            this.f5704d = i2;
        } while (a(1));
        throw b("Unterminated string");
    }

    private boolean a(String str) throws IOException {
        int length = str.length();
        while (true) {
            if (this.f5704d + length > this.f5705e && !a(length)) {
                return false;
            }
            char[] cArr = this.f5703c;
            int i2 = this.f5704d;
            if (cArr[i2] != '\n') {
                for (int i3 = 0; i3 < length; i3++) {
                    if (this.f5703c[this.f5704d + i3] != str.charAt(i3)) {
                        break;
                    }
                }
                return true;
            }
            this.f5706f++;
            this.f5707g = i2 + 1;
            this.f5704d++;
        }
    }

    private int c(boolean z2) throws IOException {
        char[] cArr = this.f5703c;
        int i2 = this.f5704d;
        int i3 = this.f5705e;
        while (true) {
            if (i2 == i3) {
                this.f5704d = i2;
                if (!a(1)) {
                    if (!z2) {
                        return -1;
                    }
                    throw new EOFException("End of input" + l());
                }
                i2 = this.f5704d;
                i3 = this.f5705e;
            }
            int i4 = i2 + 1;
            char c2 = cArr[i2];
            if (c2 == '\n') {
                this.f5706f++;
                this.f5707g = i4;
            } else if (c2 != ' ' && c2 != '\r' && c2 != '\t') {
                if (c2 == '/') {
                    this.f5704d = i4;
                    if (i4 == i3) {
                        this.f5704d--;
                        boolean zA = a(2);
                        this.f5704d++;
                        if (!zA) {
                            return c2;
                        }
                    }
                    u();
                    int i5 = this.f5704d;
                    char c3 = cArr[i5];
                    if (c3 == '*') {
                        this.f5704d = i5 + 1;
                        if (a("*/")) {
                            i2 = this.f5704d + 2;
                            i3 = this.f5705e;
                        } else {
                            throw b("Unterminated comment");
                        }
                    } else {
                        if (c3 != '/') {
                            return c2;
                        }
                        this.f5704d = i5 + 1;
                        A();
                        i2 = this.f5704d;
                        i3 = this.f5705e;
                    }
                } else if (c2 == '#') {
                    this.f5704d = i4;
                    u();
                    A();
                    i2 = this.f5704d;
                    i3 = this.f5705e;
                } else {
                    this.f5704d = i4;
                    return c2;
                }
            }
            i2 = i4;
        }
    }

    private void b(int i2) {
        int i3 = this.f5713m;
        int[] iArr = this.f5712l;
        if (i3 == iArr.length) {
            int i4 = i3 * 2;
            this.f5712l = Arrays.copyOf(iArr, i4);
            this.o = Arrays.copyOf(this.o, i4);
            this.n = (String[]) Arrays.copyOf(this.n, i4);
        }
        int[] iArr2 = this.f5712l;
        int i5 = this.f5713m;
        this.f5713m = i5 + 1;
        iArr2[i5] = i2;
    }

    private String b(boolean z2) {
        StringBuilder sb = new StringBuilder();
        sb.append(h0.f16705b);
        for (int i2 = 0; i2 < this.f5713m; i2++) {
            int i3 = this.f5712l[i2];
            if (i3 == 1 || i3 == 2) {
                int i4 = this.o[i2];
                if (z2 && i4 > 0 && i2 == this.f5713m - 1) {
                    i4--;
                }
                sb.append('[');
                sb.append(i4);
                sb.append(']');
            } else if (i3 == 3 || i3 == 4 || i3 == 5) {
                sb.append('.');
                String[] strArr = this.n;
                if (strArr[i2] != null) {
                    sb.append(strArr[i2]);
                }
            }
        }
        return sb.toString();
    }

    private IOException b(String str) throws IOException {
        throw new e(str + l());
    }
}
