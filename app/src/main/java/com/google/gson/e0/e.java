package com.google.gson.e0;

import java.io.IOException;

/* compiled from: MalformedJsonException.java */
/* loaded from: classes.dex */
public final class e extends IOException {
    private static final long serialVersionUID = 1;

    public e(String str) {
        super(str);
    }

    public e(String str, Throwable th) {
        super(str, th);
    }

    public e(Throwable th) {
        super(th);
    }
}
