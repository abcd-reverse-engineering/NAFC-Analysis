package com.airbnb.lottie.a0.l0;

import androidx.annotation.Nullable;
import com.airbnb.lottie.a0.l0.c;
import java.io.EOFException;
import java.io.IOException;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/* compiled from: JsonUtf8Reader.java */
/* loaded from: classes.dex */
final class e extends c {
    private static final int A = 7;
    private static final int B = 8;
    private static final int C = 9;
    private static final int D = 10;
    private static final int E = 11;
    private static final int F = 12;
    private static final int G = 13;
    private static final int H = 14;
    private static final int I = 15;
    private static final int J = 16;
    private static final int K = 17;
    private static final int L = 18;
    private static final int M = 0;
    private static final int N = 1;
    private static final int O = 2;
    private static final int b0 = 3;
    private static final int c0 = 4;
    private static final int d0 = 5;
    private static final int e0 = 6;
    private static final int f0 = 7;
    private static final long n = -922337203685477580L;
    private static final ByteString o = ByteString.encodeUtf8("'\\");
    private static final ByteString p = ByteString.encodeUtf8("\"\\");
    private static final ByteString q = ByteString.encodeUtf8("{}[]:, \n\t\r\f/\\;#=");
    private static final ByteString r = ByteString.encodeUtf8("\n\r");
    private static final ByteString s = ByteString.encodeUtf8("*/");
    private static final int t = 0;
    private static final int u = 1;
    private static final int v = 2;
    private static final int w = 3;
    private static final int x = 4;
    private static final int y = 5;
    private static final int z = 6;

    /* renamed from: h, reason: collision with root package name */
    private final BufferedSource f3371h;

    /* renamed from: i, reason: collision with root package name */
    private final Buffer f3372i;

    /* renamed from: j, reason: collision with root package name */
    private int f3373j = 0;

    /* renamed from: k, reason: collision with root package name */
    private long f3374k;

    /* renamed from: l, reason: collision with root package name */
    private int f3375l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    private String f3376m;

    e(BufferedSource bufferedSource) {
        if (bufferedSource == null) {
            throw new NullPointerException("source == null");
        }
        this.f3371h = bufferedSource;
        this.f3372i = bufferedSource.buffer();
        a(6);
    }

    private boolean b(int i2) throws IOException {
        if (i2 == 9 || i2 == 10 || i2 == 12 || i2 == 13 || i2 == 32) {
            return false;
        }
        if (i2 != 35) {
            if (i2 == 44) {
                return false;
            }
            if (i2 != 47 && i2 != 61) {
                if (i2 == 123 || i2 == 125 || i2 == 58) {
                    return false;
                }
                if (i2 != 59) {
                    switch (i2) {
                        case 91:
                        case 93:
                            return false;
                        case 92:
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        p();
        return false;
    }

    private void p() throws IOException {
        if (!this.f3358e) {
            throw a("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private int q() throws IOException {
        int[] iArr = this.f3355b;
        int i2 = this.f3354a;
        int i3 = iArr[i2 - 1];
        if (i3 == 1) {
            iArr[i2 - 1] = 2;
        } else if (i3 == 2) {
            int iA = a(true);
            this.f3372i.readByte();
            if (iA != 44) {
                if (iA != 59) {
                    if (iA != 93) {
                        throw a("Unterminated array");
                    }
                    this.f3373j = 4;
                    return 4;
                }
                p();
            }
        } else {
            if (i3 == 3 || i3 == 5) {
                this.f3355b[this.f3354a - 1] = 4;
                if (i3 == 5) {
                    int iA2 = a(true);
                    this.f3372i.readByte();
                    if (iA2 != 44) {
                        if (iA2 != 59) {
                            if (iA2 != 125) {
                                throw a("Unterminated object");
                            }
                            this.f3373j = 2;
                            return 2;
                        }
                        p();
                    }
                }
                int iA3 = a(true);
                if (iA3 == 34) {
                    this.f3372i.readByte();
                    this.f3373j = 13;
                    return 13;
                }
                if (iA3 == 39) {
                    this.f3372i.readByte();
                    p();
                    this.f3373j = 12;
                    return 12;
                }
                if (iA3 != 125) {
                    p();
                    if (!b((char) iA3)) {
                        throw a("Expected name");
                    }
                    this.f3373j = 14;
                    return 14;
                }
                if (i3 == 5) {
                    throw a("Expected name");
                }
                this.f3372i.readByte();
                this.f3373j = 2;
                return 2;
            }
            if (i3 == 4) {
                iArr[i2 - 1] = 5;
                int iA4 = a(true);
                this.f3372i.readByte();
                if (iA4 != 58) {
                    if (iA4 != 61) {
                        throw a("Expected ':'");
                    }
                    p();
                    if (this.f3371h.request(1L) && this.f3372i.getByte(0L) == 62) {
                        this.f3372i.readByte();
                    }
                }
            } else if (i3 == 6) {
                iArr[i2 - 1] = 7;
            } else if (i3 == 7) {
                if (a(false) == -1) {
                    this.f3373j = 18;
                    return 18;
                }
                p();
            } else if (i3 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int iA5 = a(true);
        if (iA5 == 34) {
            this.f3372i.readByte();
            this.f3373j = 9;
            return 9;
        }
        if (iA5 == 39) {
            p();
            this.f3372i.readByte();
            this.f3373j = 8;
            return 8;
        }
        if (iA5 != 44 && iA5 != 59) {
            if (iA5 == 91) {
                this.f3372i.readByte();
                this.f3373j = 3;
                return 3;
            }
            if (iA5 != 93) {
                if (iA5 == 123) {
                    this.f3372i.readByte();
                    this.f3373j = 1;
                    return 1;
                }
                int iS = s();
                if (iS != 0) {
                    return iS;
                }
                int iT = t();
                if (iT != 0) {
                    return iT;
                }
                if (!b(this.f3372i.getByte(0L))) {
                    throw a("Expected value");
                }
                p();
                this.f3373j = 10;
                return 10;
            }
            if (i3 == 1) {
                this.f3372i.readByte();
                this.f3373j = 4;
                return 4;
            }
        }
        if (i3 != 1 && i3 != 2) {
            throw a("Unexpected value");
        }
        p();
        this.f3373j = 7;
        return 7;
    }

    private String r() throws IOException {
        long jIndexOfElement = this.f3371h.indexOfElement(q);
        return jIndexOfElement != -1 ? this.f3372i.readUtf8(jIndexOfElement) : this.f3372i.readUtf8();
    }

    private int s() throws IOException {
        int i2;
        String str;
        String str2;
        byte b2 = this.f3372i.getByte(0L);
        if (b2 == 116 || b2 == 84) {
            i2 = 5;
            str = a.a.u.a.f1253j;
            str2 = "TRUE";
        } else if (b2 == 102 || b2 == 70) {
            i2 = 6;
            str = a.a.u.a.f1254k;
            str2 = "FALSE";
        } else {
            if (b2 != 110 && b2 != 78) {
                return 0;
            }
            i2 = 7;
            str = c.c.a.b.a.a.f3101h;
            str2 = "NULL";
        }
        int length = str.length();
        int i3 = 1;
        while (i3 < length) {
            int i4 = i3 + 1;
            if (!this.f3371h.request(i4)) {
                return 0;
            }
            byte b3 = this.f3372i.getByte(i3);
            if (b3 != str.charAt(i3) && b3 != str2.charAt(i3)) {
                return 0;
            }
            i3 = i4;
        }
        if (this.f3371h.request(length + 1) && b(this.f3372i.getByte(length))) {
            return 0;
        }
        this.f3372i.skip(length);
        this.f3373j = i2;
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x0089, code lost:
    
        if (b(r11) != false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x008b, code lost:
    
        if (r6 != 2) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x008d, code lost:
    
        if (r7 == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0093, code lost:
    
        if (r8 != Long.MIN_VALUE) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0095, code lost:
    
        if (r10 == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0099, code lost:
    
        if (r8 != 0) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x009b, code lost:
    
        if (r10 != false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x009d, code lost:
    
        if (r10 == false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00a0, code lost:
    
        r8 = -r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00a1, code lost:
    
        r16.f3374k = r8;
        r16.f3372i.skip(r5);
        r16.f3373j = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00ad, code lost:
    
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00ae, code lost:
    
        if (r6 == 2) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00b1, code lost:
    
        if (r6 == 4) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00b4, code lost:
    
        if (r6 != 7) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00b7, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00b9, code lost:
    
        r16.f3375l = r5;
        r16.f3373j = 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00bf, code lost:
    
        return 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00c0, code lost:
    
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int t() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 228
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.a0.l0.e.t():int");
    }

    private char u() throws IOException {
        int i2;
        int i3;
        if (!this.f3371h.request(1L)) {
            throw a("Unterminated escape sequence");
        }
        byte b2 = this.f3372i.readByte();
        if (b2 == 10 || b2 == 34 || b2 == 39 || b2 == 47 || b2 == 92) {
            return (char) b2;
        }
        if (b2 == 98) {
            return '\b';
        }
        if (b2 == 102) {
            return '\f';
        }
        if (b2 == 110) {
            return '\n';
        }
        if (b2 == 114) {
            return '\r';
        }
        if (b2 == 116) {
            return '\t';
        }
        if (b2 != 117) {
            if (this.f3358e) {
                return (char) b2;
            }
            throw a("Invalid escape sequence: \\" + ((char) b2));
        }
        if (!this.f3371h.request(4L)) {
            throw new EOFException("Unterminated escape sequence at path " + g());
        }
        char c2 = 0;
        for (int i4 = 0; i4 < 4; i4++) {
            byte b3 = this.f3372i.getByte(i4);
            char c3 = (char) (c2 << 4);
            if (b3 < 48 || b3 > 57) {
                if (b3 >= 97 && b3 <= 102) {
                    i2 = b3 - 97;
                } else {
                    if (b3 < 65 || b3 > 70) {
                        throw a("\\u" + this.f3372i.readUtf8(4L));
                    }
                    i2 = b3 - 65;
                }
                i3 = i2 + 10;
            } else {
                i3 = b3 - 48;
            }
            c2 = (char) (c3 + i3);
        }
        this.f3372i.skip(4L);
        return c2;
    }

    private boolean v() throws IOException {
        long jIndexOf = this.f3371h.indexOf(s);
        boolean z2 = jIndexOf != -1;
        Buffer buffer = this.f3372i;
        buffer.skip(z2 ? jIndexOf + s.size() : buffer.size());
        return z2;
    }

    private void w() throws IOException {
        long jIndexOfElement = this.f3371h.indexOfElement(r);
        Buffer buffer = this.f3372i;
        buffer.skip(jIndexOfElement != -1 ? jIndexOfElement + 1 : buffer.size());
    }

    private void x() throws IOException {
        long jIndexOfElement = this.f3371h.indexOfElement(q);
        Buffer buffer = this.f3372i;
        if (jIndexOfElement == -1) {
            jIndexOfElement = buffer.size();
        }
        buffer.skip(jIndexOfElement);
    }

    @Override // com.airbnb.lottie.a0.l0.c
    public int a(c.a aVar) throws IOException {
        int iQ = this.f3373j;
        if (iQ == 0) {
            iQ = q();
        }
        if (iQ < 12 || iQ > 15) {
            return -1;
        }
        if (iQ == 15) {
            return a(this.f3376m, aVar);
        }
        int iSelect = this.f3371h.select(aVar.f3361b);
        if (iSelect != -1) {
            this.f3373j = 0;
            this.f3356c[this.f3354a - 1] = aVar.f3360a[iSelect];
            return iSelect;
        }
        String str = this.f3356c[this.f3354a - 1];
        String strL = l();
        int iA = a(strL, aVar);
        if (iA == -1) {
            this.f3373j = 15;
            this.f3376m = strL;
            this.f3356c[this.f3354a - 1] = str;
        }
        return iA;
    }

    @Override // com.airbnb.lottie.a0.l0.c
    public void c() throws IOException {
        int iQ = this.f3373j;
        if (iQ == 0) {
            iQ = q();
        }
        if (iQ == 3) {
            a(1);
            this.f3357d[this.f3354a - 1] = 0;
            this.f3373j = 0;
        } else {
            throw new a("Expected BEGIN_ARRAY but was " + peek() + " at path " + g());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f3373j = 0;
        this.f3355b[0] = 8;
        this.f3354a = 1;
        this.f3372i.clear();
        this.f3371h.close();
    }

    @Override // com.airbnb.lottie.a0.l0.c
    public void d() throws IOException {
        int iQ = this.f3373j;
        if (iQ == 0) {
            iQ = q();
        }
        if (iQ == 1) {
            a(3);
            this.f3373j = 0;
            return;
        }
        throw new a("Expected BEGIN_OBJECT but was " + peek() + " at path " + g());
    }

    @Override // com.airbnb.lottie.a0.l0.c
    public void e() throws IOException {
        int iQ = this.f3373j;
        if (iQ == 0) {
            iQ = q();
        }
        if (iQ == 4) {
            this.f3354a--;
            int[] iArr = this.f3357d;
            int i2 = this.f3354a - 1;
            iArr[i2] = iArr[i2] + 1;
            this.f3373j = 0;
            return;
        }
        throw new a("Expected END_ARRAY but was " + peek() + " at path " + g());
    }

    @Override // com.airbnb.lottie.a0.l0.c
    public void f() throws IOException {
        int iQ = this.f3373j;
        if (iQ == 0) {
            iQ = q();
        }
        if (iQ != 2) {
            throw new a("Expected END_OBJECT but was " + peek() + " at path " + g());
        }
        this.f3354a--;
        String[] strArr = this.f3356c;
        int i2 = this.f3354a;
        strArr[i2] = null;
        int[] iArr = this.f3357d;
        int i3 = i2 - 1;
        iArr[i3] = iArr[i3] + 1;
        this.f3373j = 0;
    }

    @Override // com.airbnb.lottie.a0.l0.c
    public boolean h() throws IOException {
        int iQ = this.f3373j;
        if (iQ == 0) {
            iQ = q();
        }
        return (iQ == 2 || iQ == 4 || iQ == 18) ? false : true;
    }

    @Override // com.airbnb.lottie.a0.l0.c
    public boolean i() throws IOException {
        int iQ = this.f3373j;
        if (iQ == 0) {
            iQ = q();
        }
        if (iQ == 5) {
            this.f3373j = 0;
            int[] iArr = this.f3357d;
            int i2 = this.f3354a - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        }
        if (iQ == 6) {
            this.f3373j = 0;
            int[] iArr2 = this.f3357d;
            int i3 = this.f3354a - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        }
        throw new a("Expected a boolean but was " + peek() + " at path " + g());
    }

    @Override // com.airbnb.lottie.a0.l0.c
    public double j() throws IOException, NumberFormatException {
        int iQ = this.f3373j;
        if (iQ == 0) {
            iQ = q();
        }
        if (iQ == 16) {
            this.f3373j = 0;
            int[] iArr = this.f3357d;
            int i2 = this.f3354a - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.f3374k;
        }
        if (iQ == 17) {
            this.f3376m = this.f3372i.readUtf8(this.f3375l);
        } else if (iQ == 9) {
            this.f3376m = a(p);
        } else if (iQ == 8) {
            this.f3376m = a(o);
        } else if (iQ == 10) {
            this.f3376m = r();
        } else if (iQ != 11) {
            throw new a("Expected a double but was " + peek() + " at path " + g());
        }
        this.f3373j = 11;
        try {
            double d2 = Double.parseDouble(this.f3376m);
            if (this.f3358e || !(Double.isNaN(d2) || Double.isInfinite(d2))) {
                this.f3376m = null;
                this.f3373j = 0;
                int[] iArr2 = this.f3357d;
                int i3 = this.f3354a - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return d2;
            }
            throw new b("JSON forbids NaN and infinities: " + d2 + " at path " + g());
        } catch (NumberFormatException unused) {
            throw new a("Expected a double but was " + this.f3376m + " at path " + g());
        }
    }

    @Override // com.airbnb.lottie.a0.l0.c
    public int k() throws IOException, NumberFormatException {
        int iQ = this.f3373j;
        if (iQ == 0) {
            iQ = q();
        }
        if (iQ == 16) {
            long j2 = this.f3374k;
            int i2 = (int) j2;
            if (j2 == i2) {
                this.f3373j = 0;
                int[] iArr = this.f3357d;
                int i3 = this.f3354a - 1;
                iArr[i3] = iArr[i3] + 1;
                return i2;
            }
            throw new a("Expected an int but was " + this.f3374k + " at path " + g());
        }
        if (iQ == 17) {
            this.f3376m = this.f3372i.readUtf8(this.f3375l);
        } else if (iQ == 9 || iQ == 8) {
            this.f3376m = iQ == 9 ? a(p) : a(o);
            try {
                int i4 = Integer.parseInt(this.f3376m);
                this.f3373j = 0;
                int[] iArr2 = this.f3357d;
                int i5 = this.f3354a - 1;
                iArr2[i5] = iArr2[i5] + 1;
                return i4;
            } catch (NumberFormatException unused) {
            }
        } else if (iQ != 11) {
            throw new a("Expected an int but was " + peek() + " at path " + g());
        }
        this.f3373j = 11;
        try {
            double d2 = Double.parseDouble(this.f3376m);
            int i6 = (int) d2;
            if (i6 == d2) {
                this.f3376m = null;
                this.f3373j = 0;
                int[] iArr3 = this.f3357d;
                int i7 = this.f3354a - 1;
                iArr3[i7] = iArr3[i7] + 1;
                return i6;
            }
            throw new a("Expected an int but was " + this.f3376m + " at path " + g());
        } catch (NumberFormatException unused2) {
            throw new a("Expected an int but was " + this.f3376m + " at path " + g());
        }
    }

    @Override // com.airbnb.lottie.a0.l0.c
    public String l() throws IOException {
        String strA;
        int iQ = this.f3373j;
        if (iQ == 0) {
            iQ = q();
        }
        if (iQ == 14) {
            strA = r();
        } else if (iQ == 13) {
            strA = a(p);
        } else if (iQ == 12) {
            strA = a(o);
        } else {
            if (iQ != 15) {
                throw new a("Expected a name but was " + peek() + " at path " + g());
            }
            strA = this.f3376m;
        }
        this.f3373j = 0;
        this.f3356c[this.f3354a - 1] = strA;
        return strA;
    }

    @Override // com.airbnb.lottie.a0.l0.c
    public String m() throws IOException {
        String utf8;
        int iQ = this.f3373j;
        if (iQ == 0) {
            iQ = q();
        }
        if (iQ == 10) {
            utf8 = r();
        } else if (iQ == 9) {
            utf8 = a(p);
        } else if (iQ == 8) {
            utf8 = a(o);
        } else if (iQ == 11) {
            utf8 = this.f3376m;
            this.f3376m = null;
        } else if (iQ == 16) {
            utf8 = Long.toString(this.f3374k);
        } else {
            if (iQ != 17) {
                throw new a("Expected a string but was " + peek() + " at path " + g());
            }
            utf8 = this.f3372i.readUtf8(this.f3375l);
        }
        this.f3373j = 0;
        int[] iArr = this.f3357d;
        int i2 = this.f3354a - 1;
        iArr[i2] = iArr[i2] + 1;
        return utf8;
    }

    @Override // com.airbnb.lottie.a0.l0.c
    public void n() throws IOException {
        if (this.f3359f) {
            throw new a("Cannot skip unexpected " + peek() + " at " + g());
        }
        int iQ = this.f3373j;
        if (iQ == 0) {
            iQ = q();
        }
        if (iQ == 14) {
            x();
        } else if (iQ == 13) {
            b(p);
        } else if (iQ == 12) {
            b(o);
        } else if (iQ != 15) {
            throw new a("Expected a name but was " + peek() + " at path " + g());
        }
        this.f3373j = 0;
        this.f3356c[this.f3354a - 1] = c.c.a.b.a.a.f3101h;
    }

    @Override // com.airbnb.lottie.a0.l0.c
    public void o() throws IOException {
        if (this.f3359f) {
            throw new a("Cannot skip unexpected " + peek() + " at " + g());
        }
        int i2 = 0;
        do {
            int iQ = this.f3373j;
            if (iQ == 0) {
                iQ = q();
            }
            if (iQ == 3) {
                a(1);
            } else if (iQ == 1) {
                a(3);
            } else {
                if (iQ == 4) {
                    i2--;
                    if (i2 < 0) {
                        throw new a("Expected a value but was " + peek() + " at path " + g());
                    }
                    this.f3354a--;
                } else if (iQ == 2) {
                    i2--;
                    if (i2 < 0) {
                        throw new a("Expected a value but was " + peek() + " at path " + g());
                    }
                    this.f3354a--;
                } else if (iQ == 14 || iQ == 10) {
                    x();
                } else if (iQ == 9 || iQ == 13) {
                    b(p);
                } else if (iQ == 8 || iQ == 12) {
                    b(o);
                } else if (iQ == 17) {
                    this.f3372i.skip(this.f3375l);
                } else if (iQ == 18) {
                    throw new a("Expected a value but was " + peek() + " at path " + g());
                }
                this.f3373j = 0;
            }
            i2++;
            this.f3373j = 0;
        } while (i2 != 0);
        int[] iArr = this.f3357d;
        int i3 = this.f3354a;
        int i4 = i3 - 1;
        iArr[i4] = iArr[i4] + 1;
        this.f3356c[i3 - 1] = c.c.a.b.a.a.f3101h;
    }

    @Override // com.airbnb.lottie.a0.l0.c
    public c.b peek() throws IOException {
        int iQ = this.f3373j;
        if (iQ == 0) {
            iQ = q();
        }
        switch (iQ) {
            case 1:
                return c.b.BEGIN_OBJECT;
            case 2:
                return c.b.END_OBJECT;
            case 3:
                return c.b.BEGIN_ARRAY;
            case 4:
                return c.b.END_ARRAY;
            case 5:
            case 6:
                return c.b.BOOLEAN;
            case 7:
                return c.b.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return c.b.STRING;
            case 12:
            case 13:
            case 14:
            case 15:
                return c.b.NAME;
            case 16:
            case 17:
                return c.b.NUMBER;
            case 18:
                return c.b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public String toString() {
        return "JsonReader(" + this.f3371h + ")";
    }

    private int b(String str, c.a aVar) {
        int length = aVar.f3360a.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(aVar.f3360a[i2])) {
                this.f3373j = 0;
                int[] iArr = this.f3357d;
                int i3 = this.f3354a - 1;
                iArr[i3] = iArr[i3] + 1;
                return i2;
            }
        }
        return -1;
    }

    private void b(ByteString byteString) throws IOException {
        while (true) {
            long jIndexOfElement = this.f3371h.indexOfElement(byteString);
            if (jIndexOfElement != -1) {
                if (this.f3372i.getByte(jIndexOfElement) == 92) {
                    this.f3372i.skip(jIndexOfElement + 1);
                    u();
                } else {
                    this.f3372i.skip(jIndexOfElement + 1);
                    return;
                }
            } else {
                throw a("Unterminated string");
            }
        }
    }

    private int a(String str, c.a aVar) {
        int length = aVar.f3360a.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(aVar.f3360a[i2])) {
                this.f3373j = 0;
                this.f3356c[this.f3354a - 1] = str;
                return i2;
            }
        }
        return -1;
    }

    private String a(ByteString byteString) throws IOException {
        StringBuilder sb = null;
        while (true) {
            long jIndexOfElement = this.f3371h.indexOfElement(byteString);
            if (jIndexOfElement != -1) {
                if (this.f3372i.getByte(jIndexOfElement) != 92) {
                    if (sb == null) {
                        String utf8 = this.f3372i.readUtf8(jIndexOfElement);
                        this.f3372i.readByte();
                        return utf8;
                    }
                    sb.append(this.f3372i.readUtf8(jIndexOfElement));
                    this.f3372i.readByte();
                    return sb.toString();
                }
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append(this.f3372i.readUtf8(jIndexOfElement));
                this.f3372i.readByte();
                sb.append(u());
            } else {
                throw a("Unterminated string");
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0025, code lost:
    
        r6.f3372i.skip(r3 - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
    
        if (r1 != 47) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0039, code lost:
    
        if (r6.f3371h.request(2) != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003b, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003c, code lost:
    
        p();
        r3 = r6.f3372i.getByte(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0049, code lost:
    
        if (r3 == 42) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004b, code lost:
    
        if (r3 == 47) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004d, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004e, code lost:
    
        r6.f3372i.readByte();
        r6.f3372i.readByte();
        w();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005c, code lost:
    
        r6.f3372i.readByte();
        r6.f3372i.readByte();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006a, code lost:
    
        if (v() == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0073, code lost:
    
        throw a("Unterminated comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0076, code lost:
    
        if (r1 != 35) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0078, code lost:
    
        p();
        w();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007f, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int a(boolean r7) throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
        L1:
            r1 = 0
        L2:
            okio.BufferedSource r2 = r6.f3371h
            int r3 = r1 + 1
            long r4 = (long) r3
            boolean r2 = r2.request(r4)
            if (r2 == 0) goto L82
            okio.Buffer r2 = r6.f3372i
            long r4 = (long) r1
            byte r1 = r2.getByte(r4)
            r2 = 10
            if (r1 == r2) goto L80
            r2 = 32
            if (r1 == r2) goto L80
            r2 = 13
            if (r1 == r2) goto L80
            r2 = 9
            if (r1 != r2) goto L25
            goto L80
        L25:
            okio.Buffer r2 = r6.f3372i
            int r3 = r3 + (-1)
            long r3 = (long) r3
            r2.skip(r3)
            r2 = 47
            if (r1 != r2) goto L74
            okio.BufferedSource r3 = r6.f3371h
            r4 = 2
            boolean r3 = r3.request(r4)
            if (r3 != 0) goto L3c
            return r1
        L3c:
            r6.p()
            okio.Buffer r3 = r6.f3372i
            r4 = 1
            byte r3 = r3.getByte(r4)
            r4 = 42
            if (r3 == r4) goto L5c
            if (r3 == r2) goto L4e
            return r1
        L4e:
            okio.Buffer r1 = r6.f3372i
            r1.readByte()
            okio.Buffer r1 = r6.f3372i
            r1.readByte()
            r6.w()
            goto L1
        L5c:
            okio.Buffer r1 = r6.f3372i
            r1.readByte()
            okio.Buffer r1 = r6.f3372i
            r1.readByte()
            boolean r1 = r6.v()
            if (r1 == 0) goto L6d
            goto L1
        L6d:
            java.lang.String r7 = "Unterminated comment"
            com.airbnb.lottie.a0.l0.b r7 = r6.a(r7)
            throw r7
        L74:
            r2 = 35
            if (r1 != r2) goto L7f
            r6.p()
            r6.w()
            goto L1
        L7f:
            return r1
        L80:
            r1 = r3
            goto L2
        L82:
            if (r7 != 0) goto L86
            r7 = -1
            return r7
        L86:
            java.io.EOFException r7 = new java.io.EOFException
            java.lang.String r0 = "End of input"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.a0.l0.e.a(boolean):int");
    }
}
