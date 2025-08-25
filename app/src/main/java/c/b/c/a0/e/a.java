package c.b.c.a0.e;

/* compiled from: ASCIIEncoder.java */
/* loaded from: classes.dex */
final class a implements g {
    a() {
    }

    @Override // c.b.c.a0.e.g
    public int a() {
        return 0;
    }

    @Override // c.b.c.a0.e.g
    public void a(h hVar) {
        if (j.a(hVar.e(), hVar.f2375f) >= 2) {
            hVar.a(a(hVar.e().charAt(hVar.f2375f), hVar.e().charAt(hVar.f2375f + 1)));
            hVar.f2375f += 2;
            return;
        }
        char cD = hVar.d();
        int iA = j.a(hVar.e(), hVar.f2375f, a());
        if (iA == a()) {
            if (!j.c(cD)) {
                hVar.a((char) (cD + 1));
                hVar.f2375f++;
                return;
            } else {
                hVar.a((char) 235);
                hVar.a((char) ((cD - 128) + 1));
                hVar.f2375f++;
                return;
            }
        }
        if (iA == 1) {
            hVar.a((char) 230);
            hVar.b(1);
            return;
        }
        if (iA == 2) {
            hVar.a((char) 239);
            hVar.b(2);
            return;
        }
        if (iA == 3) {
            hVar.a((char) 238);
            hVar.b(3);
            return;
        }
        if (iA == 4) {
            hVar.a((char) 240);
            hVar.b(4);
        } else if (iA == 5) {
            hVar.a((char) 231);
            hVar.b(5);
        } else {
            throw new IllegalStateException("Illegal mode: " + iA);
        }
    }

    private static char a(char c2, char c3) {
        if (j.b(c2) && j.b(c3)) {
            return (char) (((c2 - '0') * 10) + (c3 - '0') + 130);
        }
        throw new IllegalArgumentException("not digits: " + c2 + c3);
    }
}
