package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import java.nio.charset.Charset;
import java.security.MessageDigest;

/* compiled from: Key.java */
/* loaded from: classes.dex */
public interface g {

    /* renamed from: a, reason: collision with root package name */
    public static final String f4248a = "UTF-8";

    /* renamed from: b, reason: collision with root package name */
    public static final Charset f4249b = Charset.forName("UTF-8");

    void a(@NonNull MessageDigest messageDigest);

    boolean equals(Object obj);

    int hashCode();
}
