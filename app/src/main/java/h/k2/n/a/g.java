package h.k2.n.a;

import h.e1;
import h.q2.t.i0;
import h.t0;
import java.lang.reflect.Field;
import java.util.ArrayList;

/* compiled from: DebugMetadata.kt */
/* loaded from: classes2.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private static final int f16301a = 1;

    private static final f a(@i.c.a.d a aVar) {
        return (f) aVar.getClass().getAnnotation(f.class);
    }

    private static final int b(@i.c.a.d a aVar) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        try {
            Field declaredField = aVar.getClass().getDeclaredField("label");
            i0.a((Object) declaredField, "field");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(aVar);
            if (!(obj instanceof Integer)) {
                obj = null;
            }
            Integer num = (Integer) obj;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    @h.q2.e(name = "getSpilledVariableFieldMapping")
    @t0(version = "1.3")
    @i.c.a.e
    public static final String[] c(@i.c.a.d a aVar) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        i0.f(aVar, "$this$getSpilledVariableFieldMapping");
        f fVarA = a(aVar);
        if (fVarA == null) {
            return null;
        }
        a(1, fVarA.v());
        ArrayList arrayList = new ArrayList();
        int iB = b(aVar);
        int[] iArrI = fVarA.i();
        int length = iArrI.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (iArrI[i2] == iB) {
                arrayList.add(fVarA.s()[i2]);
                arrayList.add(fVarA.n()[i2]);
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new e1("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @h.q2.e(name = "getStackTraceElement")
    @t0(version = "1.3")
    @i.c.a.e
    public static final StackTraceElement d(@i.c.a.d a aVar) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        String strC;
        i0.f(aVar, "$this$getStackTraceElementImpl");
        f fVarA = a(aVar);
        if (fVarA == null) {
            return null;
        }
        a(1, fVarA.v());
        int iB = b(aVar);
        int i2 = iB < 0 ? -1 : fVarA.l()[iB];
        String strA = i.f16304c.a(aVar);
        if (strA == null) {
            strC = fVarA.c();
        } else {
            strC = strA + '/' + fVarA.c();
        }
        return new StackTraceElement(strC, fVarA.m(), fVarA.f(), i2);
    }

    private static final void a(int i2, int i3) {
        if (i3 <= i2) {
            return;
        }
        throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + i2 + ", got " + i3 + ". Please update the Kotlin standard library.").toString());
    }
}
