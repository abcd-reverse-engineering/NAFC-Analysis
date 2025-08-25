package c.b.c.d0.a0.g.e;

import com.tencent.bugly.beta.tinker.TinkerReport;
import h.z2.h0;

/* compiled from: GeneralAppIdDecoder.java */
/* loaded from: classes.dex */
final class s {

    /* renamed from: a, reason: collision with root package name */
    private final c.b.c.z.a f2523a;

    /* renamed from: b, reason: collision with root package name */
    private final m f2524b = new m();

    /* renamed from: c, reason: collision with root package name */
    private final StringBuilder f2525c = new StringBuilder();

    s(c.b.c.z.a aVar) {
        this.f2523a = aVar;
    }

    private o b() throws c.b.c.h {
        l lVarD;
        boolean zB;
        do {
            int iA = this.f2524b.a();
            if (this.f2524b.b()) {
                lVarD = a();
                zB = lVarD.b();
            } else if (this.f2524b.c()) {
                lVarD = c();
                zB = lVarD.b();
            } else {
                lVarD = d();
                zB = lVarD.b();
            }
            if (!(iA != this.f2524b.a()) && !zB) {
                break;
            }
        } while (!zB);
        return lVarD.a();
    }

    private p c(int i2) throws c.b.c.h {
        int i3 = i2 + 7;
        if (i3 > this.f2523a.c()) {
            int iA = a(i2, 4);
            return iA == 0 ? new p(this.f2523a.c(), 10, 10) : new p(this.f2523a.c(), iA - 1, 10);
        }
        int iA2 = a(i2, 7) - 8;
        return new p(i3, iA2 / 11, iA2 % 11);
    }

    private l d() throws c.b.c.h {
        while (i(this.f2524b.a())) {
            p pVarC = c(this.f2524b.a());
            this.f2524b.b(pVarC.a());
            if (pVarC.f()) {
                return new l(pVarC.g() ? new o(this.f2524b.a(), this.f2525c.toString()) : new o(this.f2524b.a(), this.f2525c.toString(), pVarC.c()), true);
            }
            this.f2525c.append(pVarC.b());
            if (pVarC.g()) {
                return new l(new o(this.f2524b.a(), this.f2525c.toString()), true);
            }
            this.f2525c.append(pVarC.c());
        }
        if (f(this.f2524b.a())) {
            this.f2524b.e();
            this.f2524b.a(4);
        }
        return new l(false);
    }

    private boolean e(int i2) {
        int i3;
        if (i2 + 1 > this.f2523a.c()) {
            return false;
        }
        for (int i4 = 0; i4 < 5 && (i3 = i4 + i2) < this.f2523a.c(); i4++) {
            if (i4 == 2) {
                if (!this.f2523a.b(i2 + 2)) {
                    return false;
                }
            } else if (this.f2523a.b(i3)) {
                return false;
            }
        }
        return true;
    }

    private boolean f(int i2) {
        int i3;
        if (i2 + 1 > this.f2523a.c()) {
            return false;
        }
        for (int i4 = 0; i4 < 4 && (i3 = i4 + i2) < this.f2523a.c(); i4++) {
            if (this.f2523a.b(i3)) {
                return false;
            }
        }
        return true;
    }

    private boolean g(int i2) {
        int iA;
        if (i2 + 5 > this.f2523a.c()) {
            return false;
        }
        int iA2 = a(i2, 5);
        if (iA2 < 5 || iA2 >= 16) {
            return i2 + 6 <= this.f2523a.c() && (iA = a(i2, 6)) >= 16 && iA < 63;
        }
        return true;
    }

    private boolean h(int i2) {
        int iA;
        if (i2 + 5 > this.f2523a.c()) {
            return false;
        }
        int iA2 = a(i2, 5);
        if (iA2 >= 5 && iA2 < 16) {
            return true;
        }
        if (i2 + 7 > this.f2523a.c()) {
            return false;
        }
        int iA3 = a(i2, 7);
        if (iA3 < 64 || iA3 >= 116) {
            return i2 + 8 <= this.f2523a.c() && (iA = a(i2, 8)) >= 232 && iA < 253;
        }
        return true;
    }

    private boolean i(int i2) {
        if (i2 + 7 > this.f2523a.c()) {
            return i2 + 4 <= this.f2523a.c();
        }
        int i3 = i2;
        while (true) {
            int i4 = i2 + 3;
            if (i3 >= i4) {
                return this.f2523a.b(i4);
            }
            if (this.f2523a.b(i3)) {
                return true;
            }
            i3++;
        }
    }

    String a(StringBuilder sb, int i2) throws c.b.c.h, c.b.c.m {
        String str = null;
        while (true) {
            o oVarA = a(i2, str);
            String strA = r.a(oVarA.b());
            if (strA != null) {
                sb.append(strA);
            }
            String strValueOf = oVarA.d() ? String.valueOf(oVarA.c()) : null;
            if (i2 == oVarA.a()) {
                return sb.toString();
            }
            i2 = oVarA.a();
            str = strValueOf;
        }
    }

    private l c() throws c.b.c.h {
        while (h(this.f2524b.a())) {
            n nVarB = b(this.f2524b.a());
            this.f2524b.b(nVarB.a());
            if (nVarB.c()) {
                return new l(new o(this.f2524b.a(), this.f2525c.toString()), true);
            }
            this.f2525c.append(nVarB.b());
        }
        if (d(this.f2524b.a())) {
            this.f2524b.a(3);
            this.f2524b.g();
        } else if (e(this.f2524b.a())) {
            if (this.f2524b.a() + 5 < this.f2523a.c()) {
                this.f2524b.a(5);
            } else {
                this.f2524b.b(this.f2523a.c());
            }
            this.f2524b.e();
        }
        return new l(false);
    }

    int a(int i2, int i3) {
        return a(this.f2523a, i2, i3);
    }

    static int a(c.b.c.z.a aVar, int i2, int i3) {
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            if (aVar.b(i2 + i5)) {
                i4 |= 1 << ((i3 - i5) - 1);
            }
        }
        return i4;
    }

    o a(int i2, String str) throws c.b.c.h {
        this.f2525c.setLength(0);
        if (str != null) {
            this.f2525c.append(str);
        }
        this.f2524b.b(i2);
        o oVarB = b();
        if (oVarB != null && oVarB.d()) {
            return new o(this.f2524b.a(), this.f2525c.toString(), oVarB.c());
        }
        return new o(this.f2524b.a(), this.f2525c.toString());
    }

    private n b(int i2) throws c.b.c.h {
        char c2;
        int iA = a(i2, 5);
        if (iA == 15) {
            return new n(i2 + 5, h0.f16705b);
        }
        if (iA >= 5 && iA < 15) {
            return new n(i2 + 5, (char) ((iA + 48) - 5));
        }
        int iA2 = a(i2, 7);
        if (iA2 >= 64 && iA2 < 90) {
            return new n(i2 + 7, (char) (iA2 + 1));
        }
        if (iA2 >= 90 && iA2 < 116) {
            return new n(i2 + 7, (char) (iA2 + 7));
        }
        switch (a(i2, 8)) {
            case 232:
                c2 = '!';
                break;
            case 233:
                c2 = h0.f16704a;
                break;
            case 234:
                c2 = '%';
                break;
            case util.c2.a.C0 /* 235 */:
                c2 = h0.f16706c;
                break;
            case 236:
                c2 = '\'';
                break;
            case 237:
                c2 = '(';
                break;
            case 238:
                c2 = ')';
                break;
            case 239:
                c2 = '*';
                break;
            case 240:
                c2 = '+';
                break;
            case 241:
                c2 = ',';
                break;
            case 242:
                c2 = '-';
                break;
            case 243:
                c2 = '.';
                break;
            case 244:
                c2 = '/';
                break;
            case 245:
                c2 = ':';
                break;
            case 246:
                c2 = ';';
                break;
            case 247:
                c2 = h0.f16707d;
                break;
            case 248:
                c2 = '=';
                break;
            case 249:
                c2 = h0.f16708e;
                break;
            case 250:
                c2 = '?';
                break;
            case TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION /* 251 */:
                c2 = '_';
                break;
            case TinkerReport.KEY_LOADED_EXCEPTION_DEX /* 252 */:
                c2 = ' ';
                break;
            default:
                throw c.b.c.h.getFormatInstance();
        }
        return new n(i2 + 8, c2);
    }

    private l a() {
        while (g(this.f2524b.a())) {
            n nVarA = a(this.f2524b.a());
            this.f2524b.b(nVarA.a());
            if (nVarA.c()) {
                return new l(new o(this.f2524b.a(), this.f2525c.toString()), true);
            }
            this.f2525c.append(nVarA.b());
        }
        if (d(this.f2524b.a())) {
            this.f2524b.a(3);
            this.f2524b.g();
        } else if (e(this.f2524b.a())) {
            if (this.f2524b.a() + 5 < this.f2523a.c()) {
                this.f2524b.a(5);
            } else {
                this.f2524b.b(this.f2523a.c());
            }
            this.f2524b.f();
        }
        return new l(false);
    }

    private boolean d(int i2) {
        int i3 = i2 + 3;
        if (i3 > this.f2523a.c()) {
            return false;
        }
        while (i2 < i3) {
            if (this.f2523a.b(i2)) {
                return false;
            }
            i2++;
        }
        return true;
    }

    private n a(int i2) {
        char c2;
        int iA = a(i2, 5);
        if (iA == 15) {
            return new n(i2 + 5, h0.f16705b);
        }
        if (iA >= 5 && iA < 15) {
            return new n(i2 + 5, (char) ((iA + 48) - 5));
        }
        int iA2 = a(i2, 6);
        if (iA2 >= 32 && iA2 < 58) {
            return new n(i2 + 6, (char) (iA2 + 33));
        }
        switch (iA2) {
            case 58:
                c2 = '*';
                break;
            case 59:
                c2 = ',';
                break;
            case 60:
                c2 = '-';
                break;
            case 61:
                c2 = '.';
                break;
            case 62:
                c2 = '/';
                break;
            default:
                throw new IllegalStateException("Decoding invalid alphanumeric value: " + iA2);
        }
        return new n(i2 + 6, c2);
    }
}
