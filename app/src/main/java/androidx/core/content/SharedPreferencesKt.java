package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import h.q2.s.l;
import h.q2.t.i0;
import h.y;
import h.y1;
import i.c.a.d;

/* compiled from: SharedPreferences.kt */
@y(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a0\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\bH\u0087\b¨\u0006\t"}, d2 = {"edit", "", "Landroid/content/SharedPreferences;", "commit", "", "action", "Lkotlin/Function1;", "Landroid/content/SharedPreferences$Editor;", "Lkotlin/ExtensionFunctionType;", "core-ktx_release"}, k = 2, mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class SharedPreferencesKt {
    @SuppressLint({"ApplySharedPref"})
    public static final void edit(@d SharedPreferences sharedPreferences, boolean z, @d l<? super SharedPreferences.Editor, y1> lVar) {
        i0.f(sharedPreferences, "$receiver");
        i0.f(lVar, "action");
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        i0.a((Object) editorEdit, "editor");
        lVar.invoke(editorEdit);
        if (z) {
            editorEdit.commit();
        } else {
            editorEdit.apply();
        }
    }

    @SuppressLint({"ApplySharedPref"})
    public static /* bridge */ /* synthetic */ void edit$default(SharedPreferences sharedPreferences, boolean z, l lVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        i0.f(sharedPreferences, "$receiver");
        i0.f(lVar, "action");
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        i0.a((Object) editorEdit, "editor");
        lVar.invoke(editorEdit);
        if (z) {
            editorEdit.commit();
        } else {
            editorEdit.apply();
        }
    }
}
