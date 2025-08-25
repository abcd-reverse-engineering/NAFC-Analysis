package com.huawei.secure.android.common.ssl.hostname;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.security.auth.x500.X500Principal;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final String f7632a;

    /* renamed from: b, reason: collision with root package name */
    private final int f7633b;

    /* renamed from: c, reason: collision with root package name */
    private int f7634c;

    /* renamed from: d, reason: collision with root package name */
    private int f7635d;

    /* renamed from: e, reason: collision with root package name */
    private int f7636e;

    /* renamed from: f, reason: collision with root package name */
    private int f7637f;

    /* renamed from: g, reason: collision with root package name */
    private char[] f7638g;

    public a(X500Principal x500Principal) {
        this.f7632a = x500Principal.getName("RFC2253");
        this.f7633b = this.f7632a.length();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0053, code lost:
    
        r1 = r8.f7638g;
        r2 = r8.f7635d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005f, code lost:
    
        return new java.lang.String(r1, r2, r8.f7636e - r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a() {
        /*
            r8 = this;
            int r0 = r8.f7634c
            r8.f7635d = r0
            r8.f7636e = r0
        L6:
            int r0 = r8.f7634c
            int r1 = r8.f7633b
            if (r0 < r1) goto L19
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f7638g
            int r2 = r8.f7635d
            int r3 = r8.f7636e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L19:
            char[] r1 = r8.f7638g
            char r2 = r1[r0]
            r3 = 44
            r4 = 43
            r5 = 59
            r6 = 32
            if (r2 == r6) goto L60
            if (r2 == r5) goto L53
            r5 = 92
            if (r2 == r5) goto L40
            if (r2 == r4) goto L53
            if (r2 == r3) goto L53
            int r2 = r8.f7636e
            int r3 = r2 + 1
            r8.f7636e = r3
            char r3 = r1[r0]
            r1[r2] = r3
            int r0 = r0 + 1
            r8.f7634c = r0
            goto L6
        L40:
            int r0 = r8.f7636e
            int r2 = r0 + 1
            r8.f7636e = r2
            char r2 = r8.b()
            r1[r0] = r2
            int r0 = r8.f7634c
            int r0 = r0 + 1
            r8.f7634c = r0
            goto L6
        L53:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f7638g
            int r2 = r8.f7635d
            int r3 = r8.f7636e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L60:
            int r2 = r8.f7636e
            r8.f7637f = r2
            int r0 = r0 + 1
            r8.f7634c = r0
            int r0 = r2 + 1
            r8.f7636e = r0
            r1[r2] = r6
        L6e:
            int r0 = r8.f7634c
            int r1 = r8.f7633b
            if (r0 >= r1) goto L87
            char[] r1 = r8.f7638g
            char r2 = r1[r0]
            if (r2 != r6) goto L87
            int r2 = r8.f7636e
            int r7 = r2 + 1
            r8.f7636e = r7
            r1[r2] = r6
            int r0 = r0 + 1
            r8.f7634c = r0
            goto L6e
        L87:
            int r0 = r8.f7634c
            int r1 = r8.f7633b
            if (r0 == r1) goto L9b
            char[] r1 = r8.f7638g
            char r2 = r1[r0]
            if (r2 == r3) goto L9b
            char r2 = r1[r0]
            if (r2 == r4) goto L9b
            char r0 = r1[r0]
            if (r0 != r5) goto L6
        L9b:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f7638g
            int r2 = r8.f7635d
            int r3 = r8.f7637f
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.ssl.hostname.a.a():java.lang.String");
    }

    private char b() {
        this.f7634c++;
        int i2 = this.f7634c;
        if (i2 == this.f7633b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f7632a);
        }
        char[] cArr = this.f7638g;
        char c2 = cArr[i2];
        if (c2 != ' ' && c2 != '%' && c2 != '\\' && c2 != '_' && c2 != '\"' && c2 != '#') {
            switch (c2) {
                case '*':
                case '+':
                case ',':
                    break;
                default:
                    switch (c2) {
                        case ';':
                        case '<':
                        case '=':
                        case '>':
                            break;
                        default:
                            return c();
                    }
            }
        }
        return cArr[i2];
    }

    private char c() {
        int i2;
        int i3;
        int iA = a(this.f7634c);
        this.f7634c++;
        if (iA < 128) {
            return (char) iA;
        }
        if (iA < 192 || iA > 247) {
            return '?';
        }
        if (iA <= 223) {
            i3 = iA & 31;
            i2 = 1;
        } else if (iA <= 239) {
            i2 = 2;
            i3 = iA & 15;
        } else {
            i2 = 3;
            i3 = iA & 7;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            this.f7634c++;
            int i5 = this.f7634c;
            if (i5 == this.f7633b || this.f7638g[i5] != '\\') {
                return '?';
            }
            this.f7634c = i5 + 1;
            int iA2 = a(this.f7634c);
            this.f7634c++;
            if ((iA2 & 192) != 128) {
                return '?';
            }
            i3 = (i3 << 6) + (iA2 & 63);
        }
        return (char) i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0061, code lost:
    
        r6.f7636e = r6.f7634c;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String d() {
        /*
            r6 = this;
            int r0 = r6.f7634c
            int r1 = r0 + 4
            int r2 = r6.f7633b
            java.lang.String r3 = "Unexpected end of DN: "
            if (r1 >= r2) goto La8
            r6.f7635d = r0
            int r0 = r0 + 1
            r6.f7634c = r0
        L10:
            int r0 = r6.f7634c
            int r1 = r6.f7633b
            if (r0 == r1) goto L61
            char[] r1 = r6.f7638g
            char r2 = r1[r0]
            r4 = 43
            if (r2 == r4) goto L61
            char r2 = r1[r0]
            r4 = 44
            if (r2 == r4) goto L61
            char r2 = r1[r0]
            r4 = 59
            if (r2 != r4) goto L2b
            goto L61
        L2b:
            char r2 = r1[r0]
            r4 = 32
            if (r2 != r4) goto L48
            r6.f7636e = r0
            int r0 = r0 + 1
            r6.f7634c = r0
        L37:
            int r0 = r6.f7634c
            int r1 = r6.f7633b
            if (r0 >= r1) goto L65
            char[] r1 = r6.f7638g
            char r1 = r1[r0]
            if (r1 != r4) goto L65
            int r0 = r0 + 1
            r6.f7634c = r0
            goto L37
        L48:
            char r2 = r1[r0]
            r5 = 65
            if (r2 < r5) goto L5a
            char r2 = r1[r0]
            r5 = 70
            if (r2 > r5) goto L5a
            char r2 = r1[r0]
            int r2 = r2 + r4
            char r2 = (char) r2
            r1[r0] = r2
        L5a:
            int r0 = r6.f7634c
            int r0 = r0 + 1
            r6.f7634c = r0
            goto L10
        L61:
            int r0 = r6.f7634c
            r6.f7636e = r0
        L65:
            int r0 = r6.f7636e
            int r1 = r6.f7635d
            int r0 = r0 - r1
            r2 = 5
            if (r0 < r2) goto L91
            r2 = r0 & 1
            if (r2 == 0) goto L91
            int r2 = r0 / 2
            byte[] r2 = new byte[r2]
            r3 = 0
            int r1 = r1 + 1
        L78:
            int r4 = r2.length
            if (r3 >= r4) goto L87
            int r4 = r6.a(r1)
            byte r4 = (byte) r4
            r2[r3] = r4
            int r1 = r1 + 2
            int r3 = r3 + 1
            goto L78
        L87:
            java.lang.String r1 = new java.lang.String
            char[] r2 = r6.f7638g
            int r3 = r6.f7635d
            r1.<init>(r2, r3, r0)
            return r1
        L91:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            java.lang.String r2 = r6.f7632a
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        La8:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            java.lang.String r2 = r6.f7632a
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.ssl.hostname.a.d():java.lang.String");
    }

    private String e() {
        while (true) {
            int i2 = this.f7634c;
            if (i2 >= this.f7633b || this.f7638g[i2] != ' ') {
                break;
            }
            this.f7634c = i2 + 1;
        }
        int i3 = this.f7634c;
        if (i3 == this.f7633b) {
            return null;
        }
        this.f7635d = i3;
        this.f7634c = i3 + 1;
        while (true) {
            int i4 = this.f7634c;
            if (i4 >= this.f7633b) {
                break;
            }
            char[] cArr = this.f7638g;
            if (cArr[i4] == '=' || cArr[i4] == ' ') {
                break;
            }
            this.f7634c = i4 + 1;
        }
        int i5 = this.f7634c;
        if (i5 >= this.f7633b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f7632a);
        }
        this.f7636e = i5;
        if (this.f7638g[i5] == ' ') {
            while (true) {
                int i6 = this.f7634c;
                if (i6 >= this.f7633b) {
                    break;
                }
                char[] cArr2 = this.f7638g;
                if (cArr2[i6] == '=' || cArr2[i6] != ' ') {
                    break;
                }
                this.f7634c = i6 + 1;
            }
            char[] cArr3 = this.f7638g;
            int i7 = this.f7634c;
            if (cArr3[i7] != '=' || i7 == this.f7633b) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f7632a);
            }
        }
        this.f7634c++;
        while (true) {
            int i8 = this.f7634c;
            if (i8 >= this.f7633b || this.f7638g[i8] != ' ') {
                break;
            }
            this.f7634c = i8 + 1;
        }
        int i9 = this.f7636e;
        int i10 = this.f7635d;
        if (i9 - i10 > 4) {
            char[] cArr4 = this.f7638g;
            if (cArr4[i10 + 3] == '.' && (cArr4[i10] == 'O' || cArr4[i10] == 'o')) {
                char[] cArr5 = this.f7638g;
                int i11 = this.f7635d + 1;
                if (cArr5[i11] == 'I' || cArr5[i11] == 'i') {
                    char[] cArr6 = this.f7638g;
                    int i12 = this.f7635d + 2;
                    if (cArr6[i12] == 'D' || cArr6[i12] == 'd') {
                        this.f7635d += 4;
                    }
                }
            }
        }
        char[] cArr7 = this.f7638g;
        int i13 = this.f7635d;
        return new String(cArr7, i13, this.f7636e - i13);
    }

    private String f() {
        this.f7634c++;
        this.f7635d = this.f7634c;
        this.f7636e = this.f7635d;
        while (true) {
            int i2 = this.f7634c;
            if (i2 == this.f7633b) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f7632a);
            }
            char[] cArr = this.f7638g;
            if (cArr[i2] == '\"') {
                this.f7634c = i2 + 1;
                while (true) {
                    int i3 = this.f7634c;
                    if (i3 >= this.f7633b || this.f7638g[i3] != ' ') {
                        break;
                    }
                    this.f7634c = i3 + 1;
                }
                char[] cArr2 = this.f7638g;
                int i4 = this.f7635d;
                return new String(cArr2, i4, this.f7636e - i4);
            }
            if (cArr[i2] == '\\') {
                cArr[this.f7636e] = b();
            } else {
                cArr[this.f7636e] = cArr[i2];
            }
            this.f7634c++;
            this.f7636e++;
        }
    }

    public List<String> b(String str) {
        String strF;
        this.f7634c = 0;
        this.f7635d = 0;
        this.f7636e = 0;
        this.f7637f = 0;
        this.f7638g = this.f7632a.toCharArray();
        List<String> listEmptyList = Collections.emptyList();
        String strE = e();
        if (strE == null) {
            return listEmptyList;
        }
        do {
            int i2 = this.f7634c;
            if (i2 < this.f7633b) {
                char c2 = this.f7638g[i2];
                if (c2 == '\"') {
                    strF = f();
                } else if (c2 != '#') {
                    strF = (c2 == '+' || c2 == ',' || c2 == ';') ? "" : a();
                } else {
                    strF = d();
                }
                if (str.equalsIgnoreCase(strE)) {
                    if (listEmptyList.isEmpty()) {
                        listEmptyList = new ArrayList<>();
                    }
                    listEmptyList.add(strF);
                }
                int i3 = this.f7634c;
                if (i3 < this.f7633b) {
                    char[] cArr = this.f7638g;
                    if (cArr[i3] != ',' && cArr[i3] != ';' && cArr[i3] != '+') {
                        throw new IllegalStateException("Malformed DN: " + this.f7632a);
                    }
                    this.f7634c++;
                    strE = e();
                }
            }
            return listEmptyList;
        } while (strE != null);
        throw new IllegalStateException("Malformed DN: " + this.f7632a);
    }

    private int a(int i2) {
        int i3;
        int i4;
        int i5 = i2 + 1;
        if (i5 < this.f7633b) {
            char c2 = this.f7638g[i2];
            if (c2 >= '0' && c2 <= '9') {
                i3 = c2 - '0';
            } else if (c2 >= 'a' && c2 <= 'f') {
                i3 = c2 - 'W';
            } else {
                if (c2 < 'A' || c2 > 'F') {
                    throw new IllegalStateException("Malformed DN: " + this.f7632a);
                }
                i3 = c2 - '7';
            }
            char c3 = this.f7638g[i5];
            if (c3 >= '0' && c3 <= '9') {
                i4 = c3 - '0';
            } else if (c3 >= 'a' && c3 <= 'f') {
                i4 = c3 - 'W';
            } else {
                if (c3 < 'A' || c3 > 'F') {
                    throw new IllegalStateException("Malformed DN: " + this.f7632a);
                }
                i4 = c3 - '7';
            }
            return (i3 << 4) + i4;
        }
        throw new IllegalStateException("Malformed DN: " + this.f7632a);
    }

    public String a(String str) {
        String strF;
        this.f7634c = 0;
        this.f7635d = 0;
        this.f7636e = 0;
        this.f7637f = 0;
        this.f7638g = this.f7632a.toCharArray();
        String strE = e();
        if (strE == null) {
            return null;
        }
        do {
            int i2 = this.f7634c;
            if (i2 == this.f7633b) {
                return null;
            }
            char c2 = this.f7638g[i2];
            if (c2 == '\"') {
                strF = f();
            } else if (c2 != '#') {
                strF = (c2 == '+' || c2 == ',' || c2 == ';') ? "" : a();
            } else {
                strF = d();
            }
            if (str.equalsIgnoreCase(strE)) {
                return strF;
            }
            int i3 = this.f7634c;
            if (i3 >= this.f7633b) {
                return null;
            }
            char[] cArr = this.f7638g;
            if (cArr[i3] != ',' && cArr[i3] != ';' && cArr[i3] != '+') {
                throw new IllegalStateException("Malformed DN: " + this.f7632a);
            }
            this.f7634c++;
            strE = e();
        } while (strE != null);
        throw new IllegalStateException("Malformed DN: " + this.f7632a);
    }
}
