package c.b.c.a0.e;

/* compiled from: X12Encoder.java */
/* loaded from: classes.dex */
final class n extends c {
    n() {
    }

    @Override // c.b.c.a0.e.c, c.b.c.a0.e.g
    public int a() {
        return 3;
    }

    @Override // c.b.c.a0.e.c, c.b.c.a0.e.g
    public void a(h hVar) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!hVar.i()) {
                break;
            }
            char cD = hVar.d();
            hVar.f2375f++;
            a(cD, sb);
            if (sb.length() % 3 == 0) {
                c.b(hVar, sb);
                int iA = j.a(hVar.e(), hVar.f2375f, a());
                if (iA != a()) {
                    hVar.b(iA);
                    break;
                }
            }
        }
        a(hVar, sb);
    }

    @Override // c.b.c.a0.e.c
    int a(char c2, StringBuilder sb) {
        if (c2 == '\r') {
            sb.append((char) 0);
        } else if (c2 == '*') {
            sb.append((char) 1);
        } else if (c2 == '>') {
            sb.append((char) 2);
        } else if (c2 == ' ') {
            sb.append((char) 3);
        } else if (c2 >= '0' && c2 <= '9') {
            sb.append((char) ((c2 - '0') + 4));
        } else if (c2 >= 'A' && c2 <= 'Z') {
            sb.append((char) ((c2 - 'A') + 14));
        } else {
            j.a(c2);
        }
        return 1;
    }

    @Override // c.b.c.a0.e.c
    void a(h hVar, StringBuilder sb) {
        hVar.l();
        int iB = hVar.h().b() - hVar.a();
        hVar.f2375f -= sb.length();
        if (hVar.g() > 1 || iB > 1 || hVar.g() != iB) {
            hVar.a((char) 254);
        }
        if (hVar.f() < 0) {
            hVar.b(0);
        }
    }
}
