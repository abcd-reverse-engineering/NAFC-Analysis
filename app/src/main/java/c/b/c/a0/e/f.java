package c.b.c.a0.e;

/* compiled from: EdifactEncoder.java */
/* loaded from: classes.dex */
final class f implements g {
    f() {
    }

    @Override // c.b.c.a0.e.g
    public int a() {
        return 4;
    }

    @Override // c.b.c.a0.e.g
    public void a(h hVar) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!hVar.i()) {
                break;
            }
            a(hVar.d(), sb);
            hVar.f2375f++;
            if (sb.length() >= 4) {
                hVar.a(a(sb, 0));
                sb.delete(0, 4);
                if (j.a(hVar.e(), hVar.f2375f, a()) != a()) {
                    hVar.b(0);
                    break;
                }
            }
        }
        sb.append((char) 31);
        a(hVar, sb);
    }

    private static void a(h hVar, CharSequence charSequence) {
        try {
            int length = charSequence.length();
            if (length == 0) {
                return;
            }
            boolean z = true;
            if (length == 1) {
                hVar.l();
                int iB = hVar.h().b() - hVar.a();
                if (hVar.g() == 0 && iB <= 2) {
                    return;
                }
            }
            if (length <= 4) {
                int i2 = length - 1;
                String strA = a(charSequence, 0);
                if (!(!hVar.i()) || i2 > 2) {
                    z = false;
                }
                if (i2 <= 2) {
                    hVar.c(hVar.a() + i2);
                    if (hVar.h().b() - hVar.a() >= 3) {
                        hVar.c(hVar.a() + strA.length());
                        z = false;
                    }
                }
                if (z) {
                    hVar.k();
                    hVar.f2375f -= i2;
                } else {
                    hVar.a(strA);
                }
                return;
            }
            throw new IllegalStateException("Count must not exceed 4");
        } finally {
            hVar.b(0);
        }
    }

    private static void a(char c2, StringBuilder sb) {
        if (c2 >= ' ' && c2 <= '?') {
            sb.append(c2);
        } else if (c2 >= '@' && c2 <= '^') {
            sb.append((char) (c2 - '@'));
        } else {
            j.a(c2);
        }
    }

    private static String a(CharSequence charSequence, int i2) {
        int length = charSequence.length() - i2;
        if (length != 0) {
            int iCharAt = (charSequence.charAt(i2) << 18) + ((length >= 2 ? charSequence.charAt(i2 + 1) : (char) 0) << '\f') + ((length >= 3 ? charSequence.charAt(i2 + 2) : (char) 0) << 6) + (length >= 4 ? charSequence.charAt(i2 + 3) : (char) 0);
            char c2 = (char) ((iCharAt >> 16) & 255);
            char c3 = (char) ((iCharAt >> 8) & 255);
            char c4 = (char) (iCharAt & 255);
            StringBuilder sb = new StringBuilder(3);
            sb.append(c2);
            if (length >= 2) {
                sb.append(c3);
            }
            if (length >= 3) {
                sb.append(c4);
            }
            return sb.toString();
        }
        throw new IllegalStateException("StringBuilder must not be empty");
    }
}
