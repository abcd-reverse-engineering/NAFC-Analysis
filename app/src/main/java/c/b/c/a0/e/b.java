package c.b.c.a0.e;

import androidx.core.view.InputDeviceCompat;

/* compiled from: Base256Encoder.java */
/* loaded from: classes.dex */
final class b implements g {
    b() {
    }

    @Override // c.b.c.a0.e.g
    public int a() {
        return 5;
    }

    @Override // c.b.c.a0.e.g
    public void a(h hVar) {
        StringBuilder sb = new StringBuilder();
        sb.append((char) 0);
        while (true) {
            if (!hVar.i()) {
                break;
            }
            sb.append(hVar.d());
            hVar.f2375f++;
            int iA = j.a(hVar.e(), hVar.f2375f, a());
            if (iA != a()) {
                hVar.b(iA);
                break;
            }
        }
        int length = sb.length() - 1;
        int iA2 = hVar.a() + length + 1;
        hVar.c(iA2);
        boolean z = hVar.h().b() - iA2 > 0;
        if (hVar.i() || z) {
            if (length <= 249) {
                sb.setCharAt(0, (char) length);
            } else {
                if (length <= 249 || length > 1555) {
                    throw new IllegalStateException("Message length not in valid ranges: " + length);
                }
                sb.setCharAt(0, (char) ((length / 250) + 249));
                sb.insert(1, (char) (length % 250));
            }
        }
        int length2 = sb.length();
        for (int i2 = 0; i2 < length2; i2++) {
            hVar.a(a(sb.charAt(i2), hVar.a() + 1));
        }
    }

    private static char a(char c2, int i2) {
        int i3 = c2 + ((i2 * 149) % 255) + 1;
        return i3 <= 255 ? (char) i3 : (char) (i3 + InputDeviceCompat.SOURCE_ANY);
    }
}
