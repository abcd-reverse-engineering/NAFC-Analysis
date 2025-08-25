package androidx.core.os;

import android.os.Build;
import android.os.PersistableBundle;
import androidx.annotation.RequiresApi;
import h.e1;
import h.i0;
import h.y;
import h.z2.h0;
import i.c.a.d;

/* compiled from: PersistableBundle.kt */
@y(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a=\u0010\u0000\u001a\u00020\u00012.\u0010\u0002\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00040\u0003\"\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0007¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"persistableBundleOf", "Landroid/os/PersistableBundle;", "pairs", "", "Lkotlin/Pair;", "", "", "([Lkotlin/Pair;)Landroid/os/PersistableBundle;", "core-ktx_release"}, k = 2, mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class PersistableBundleKt {
    @RequiresApi(21)
    @d
    public static final PersistableBundle persistableBundleOf(@d i0<String, ? extends Object>... i0VarArr) {
        h.q2.t.i0.f(i0VarArr, "pairs");
        PersistableBundle persistableBundle = new PersistableBundle(i0VarArr.length);
        for (i0<String, ? extends Object> i0Var : i0VarArr) {
            String strComponent1 = i0Var.component1();
            Object objComponent2 = i0Var.component2();
            if (objComponent2 == null) {
                persistableBundle.putString(strComponent1, null);
            } else if (objComponent2 instanceof Boolean) {
                if (Build.VERSION.SDK_INT < 22) {
                    throw new IllegalArgumentException("Illegal value type boolean for key \"" + strComponent1 + h0.f16704a);
                }
                persistableBundle.putBoolean(strComponent1, ((Boolean) objComponent2).booleanValue());
            } else if (objComponent2 instanceof Double) {
                persistableBundle.putDouble(strComponent1, ((Number) objComponent2).doubleValue());
            } else if (objComponent2 instanceof Integer) {
                persistableBundle.putInt(strComponent1, ((Number) objComponent2).intValue());
            } else if (objComponent2 instanceof Long) {
                persistableBundle.putLong(strComponent1, ((Number) objComponent2).longValue());
            } else if (objComponent2 instanceof String) {
                persistableBundle.putString(strComponent1, (String) objComponent2);
            } else if (objComponent2 instanceof boolean[]) {
                if (Build.VERSION.SDK_INT < 22) {
                    throw new IllegalArgumentException("Illegal value type boolean[] for key \"" + strComponent1 + h0.f16704a);
                }
                persistableBundle.putBooleanArray(strComponent1, (boolean[]) objComponent2);
            } else if (objComponent2 instanceof double[]) {
                persistableBundle.putDoubleArray(strComponent1, (double[]) objComponent2);
            } else if (objComponent2 instanceof int[]) {
                persistableBundle.putIntArray(strComponent1, (int[]) objComponent2);
            } else if (objComponent2 instanceof long[]) {
                persistableBundle.putLongArray(strComponent1, (long[]) objComponent2);
            } else {
                if (!(objComponent2 instanceof Object[])) {
                    throw new IllegalArgumentException("Illegal value type " + objComponent2.getClass().getCanonicalName() + " for key \"" + strComponent1 + h0.f16704a);
                }
                Class<?> componentType = objComponent2.getClass().getComponentType();
                if (!String.class.isAssignableFrom(componentType)) {
                    h.q2.t.i0.a((Object) componentType, "componentType");
                    throw new IllegalArgumentException("Illegal value array type " + componentType.getCanonicalName() + " for key \"" + strComponent1 + h0.f16704a);
                }
                if (objComponent2 == null) {
                    throw new e1("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                }
                persistableBundle.putStringArray(strComponent1, (String[]) objComponent2);
            }
        }
        return persistableBundle;
    }
}
