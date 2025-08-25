package com.vivo.push.util;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: SpCache.java */
/* loaded from: classes2.dex */
public final class ae implements e {

    /* renamed from: a, reason: collision with root package name */
    private static String f12240a = "SpCache";

    /* renamed from: b, reason: collision with root package name */
    private static String f12241b = "com.vivo.push.cache";

    /* renamed from: c, reason: collision with root package name */
    private SharedPreferences f12242c;

    @Override // com.vivo.push.util.e
    public final boolean a(Context context) {
        if (this.f12242c != null) {
            return true;
        }
        this.f12242c = context.getSharedPreferences(f12241b, 0);
        return true;
    }

    @Override // com.vivo.push.util.e
    public final void b(String str, String str2) {
        SharedPreferences.Editor editorEdit = this.f12242c.edit();
        if (editorEdit == null) {
            u.b(f12240a, "putString error by ".concat(String.valueOf(str)));
            return;
        }
        editorEdit.putString(str, str2);
        c.a(editorEdit);
        u.d(f12240a, "putString by ".concat(String.valueOf(str)));
    }

    @Override // com.vivo.push.util.e
    public final String a(String str, String str2) {
        String string = this.f12242c.getString(str, str2);
        u.d(f12240a, "getString " + str + " is " + string);
        return string;
    }

    public final void a() {
        SharedPreferences.Editor editorEdit = this.f12242c.edit();
        if (editorEdit != null) {
            editorEdit.clear();
            c.a(editorEdit);
        }
        u.d(f12240a, "system cache is cleared");
    }
}
