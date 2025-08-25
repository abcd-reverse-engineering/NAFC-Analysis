package com.google.gson.b0;

/* compiled from: $Gson$Preconditions.java */
/* loaded from: classes.dex */
public final class a {
    private a() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <T> T a(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    public static void a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }
}
