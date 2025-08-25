package com.bumptech.glide.m;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: GlideOption.java */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes.dex */
public @interface d {

    /* renamed from: a, reason: collision with root package name */
    public static final int f5050a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static final int f5051b = 1;

    /* renamed from: c, reason: collision with root package name */
    public static final int f5052c = 2;

    boolean memoizeStaticMethod() default false;

    int override() default 0;

    boolean skipStaticMethod() default false;

    String staticMethodName() default "";
}
