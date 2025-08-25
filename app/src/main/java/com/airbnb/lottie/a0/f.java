package com.airbnb.lottie.a0;

import android.graphics.Color;
import com.airbnb.lottie.a0.l0.c;
import java.io.IOException;

/* compiled from: ColorParser.java */
/* loaded from: classes.dex */
public class f implements k0<Integer> {

    /* renamed from: a, reason: collision with root package name */
    public static final f f3338a = new f();

    private f() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.a0.k0
    public Integer a(com.airbnb.lottie.a0.l0.c cVar, float f2) throws IOException {
        boolean z = cVar.peek() == c.b.BEGIN_ARRAY;
        if (z) {
            cVar.c();
        }
        double dJ = cVar.j();
        double dJ2 = cVar.j();
        double dJ3 = cVar.j();
        double dJ4 = cVar.peek() == c.b.NUMBER ? cVar.j() : 1.0d;
        if (z) {
            cVar.e();
        }
        if (dJ <= 1.0d && dJ2 <= 1.0d && dJ3 <= 1.0d) {
            dJ *= 255.0d;
            dJ2 *= 255.0d;
            dJ3 *= 255.0d;
            if (dJ4 <= 1.0d) {
                dJ4 *= 255.0d;
            }
        }
        return Integer.valueOf(Color.argb((int) dJ4, (int) dJ, (int) dJ2, (int) dJ3));
    }
}
