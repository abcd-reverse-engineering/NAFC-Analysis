package com.bumptech.glide.r.l;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: AppWidgetTarget.java */
/* loaded from: classes.dex */
public class a extends e<Bitmap> {

    /* renamed from: d, reason: collision with root package name */
    private final int[] f5264d;

    /* renamed from: e, reason: collision with root package name */
    private final ComponentName f5265e;

    /* renamed from: f, reason: collision with root package name */
    private final RemoteViews f5266f;

    /* renamed from: g, reason: collision with root package name */
    private final Context f5267g;

    /* renamed from: h, reason: collision with root package name */
    private final int f5268h;

    public a(Context context, int i2, int i3, int i4, RemoteViews remoteViews, int... iArr) {
        super(i2, i3);
        if (iArr.length == 0) {
            throw new IllegalArgumentException("WidgetIds must have length > 0");
        }
        this.f5267g = (Context) com.bumptech.glide.util.j.a(context, "Context can not be null!");
        this.f5266f = (RemoteViews) com.bumptech.glide.util.j.a(remoteViews, "RemoteViews object can not be null!");
        this.f5264d = (int[]) com.bumptech.glide.util.j.a(iArr, "WidgetIds can not be null!");
        this.f5268h = i4;
        this.f5265e = null;
    }

    private void b() {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this.f5267g);
        ComponentName componentName = this.f5265e;
        if (componentName != null) {
            appWidgetManager.updateAppWidget(componentName, this.f5266f);
        } else {
            appWidgetManager.updateAppWidget(this.f5264d, this.f5266f);
        }
    }

    @Override // com.bumptech.glide.r.l.p
    public /* bridge */ /* synthetic */ void a(@NonNull Object obj, @Nullable com.bumptech.glide.r.m.f fVar) {
        a((Bitmap) obj, (com.bumptech.glide.r.m.f<? super Bitmap>) fVar);
    }

    @Override // com.bumptech.glide.r.l.p
    public void c(@Nullable Drawable drawable) {
        a((Bitmap) null);
    }

    public void a(@NonNull Bitmap bitmap, @Nullable com.bumptech.glide.r.m.f<? super Bitmap> fVar) {
        a(bitmap);
    }

    private void a(@Nullable Bitmap bitmap) {
        this.f5266f.setImageViewBitmap(this.f5268h, bitmap);
        b();
    }

    public a(Context context, int i2, RemoteViews remoteViews, int... iArr) {
        this(context, Integer.MIN_VALUE, Integer.MIN_VALUE, i2, remoteViews, iArr);
    }

    public a(Context context, int i2, int i3, int i4, RemoteViews remoteViews, ComponentName componentName) {
        super(i2, i3);
        this.f5267g = (Context) com.bumptech.glide.util.j.a(context, "Context can not be null!");
        this.f5266f = (RemoteViews) com.bumptech.glide.util.j.a(remoteViews, "RemoteViews object can not be null!");
        this.f5265e = (ComponentName) com.bumptech.glide.util.j.a(componentName, "ComponentName can not be null!");
        this.f5268h = i4;
        this.f5264d = null;
    }

    public a(Context context, int i2, RemoteViews remoteViews, ComponentName componentName) {
        this(context, Integer.MIN_VALUE, Integer.MIN_VALUE, i2, remoteViews, componentName);
    }
}
