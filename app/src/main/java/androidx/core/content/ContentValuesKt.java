package androidx.core.content;

import android.content.ContentValues;
import h.i0;
import h.y;
import h.z2.h0;
import i.c.a.d;

/* compiled from: ContentValues.kt */
@y(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\u00020\u00012.\u0010\u0002\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00040\u0003\"\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"contentValuesOf", "Landroid/content/ContentValues;", "pairs", "", "Lkotlin/Pair;", "", "", "([Lkotlin/Pair;)Landroid/content/ContentValues;", "core-ktx_release"}, k = 2, mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class ContentValuesKt {
    @d
    public static final ContentValues contentValuesOf(@d i0<String, ? extends Object>... i0VarArr) {
        h.q2.t.i0.f(i0VarArr, "pairs");
        ContentValues contentValues = new ContentValues(i0VarArr.length);
        for (i0<String, ? extends Object> i0Var : i0VarArr) {
            String strComponent1 = i0Var.component1();
            Object objComponent2 = i0Var.component2();
            if (objComponent2 == null) {
                contentValues.putNull(strComponent1);
            } else if (objComponent2 instanceof String) {
                contentValues.put(strComponent1, (String) objComponent2);
            } else if (objComponent2 instanceof Integer) {
                contentValues.put(strComponent1, (Integer) objComponent2);
            } else if (objComponent2 instanceof Long) {
                contentValues.put(strComponent1, (Long) objComponent2);
            } else if (objComponent2 instanceof Boolean) {
                contentValues.put(strComponent1, (Boolean) objComponent2);
            } else if (objComponent2 instanceof Float) {
                contentValues.put(strComponent1, (Float) objComponent2);
            } else if (objComponent2 instanceof Double) {
                contentValues.put(strComponent1, (Double) objComponent2);
            } else if (objComponent2 instanceof byte[]) {
                contentValues.put(strComponent1, (byte[]) objComponent2);
            } else if (objComponent2 instanceof Byte) {
                contentValues.put(strComponent1, (Byte) objComponent2);
            } else {
                if (!(objComponent2 instanceof Short)) {
                    throw new IllegalArgumentException("Illegal value type " + objComponent2.getClass().getCanonicalName() + " for key \"" + strComponent1 + h0.f16704a);
                }
                contentValues.put(strComponent1, (Short) objComponent2);
            }
        }
        return contentValues;
    }
}
