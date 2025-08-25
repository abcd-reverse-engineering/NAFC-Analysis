package com.bumptech.glide.load.p;

/* compiled from: CallbackException.java */
/* loaded from: classes.dex */
final class b extends RuntimeException {
    private static final long serialVersionUID = -7530898992688511851L;

    b(Throwable th) {
        super("Unexpected exception thrown by non-Glide code", th);
    }
}
