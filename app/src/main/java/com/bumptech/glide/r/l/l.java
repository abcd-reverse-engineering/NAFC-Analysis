package com.bumptech.glide.r.l;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: NotificationTarget.java */
/* loaded from: classes.dex */
public class l extends e<Bitmap> {

    /* renamed from: d, reason: collision with root package name */
    private final RemoteViews f5298d;

    /* renamed from: e, reason: collision with root package name */
    private final Context f5299e;

    /* renamed from: f, reason: collision with root package name */
    private final int f5300f;

    /* renamed from: g, reason: collision with root package name */
    private final String f5301g;

    /* renamed from: h, reason: collision with root package name */
    private final Notification f5302h;

    /* renamed from: i, reason: collision with root package name */
    private final int f5303i;

    public l(Context context, int i2, RemoteViews remoteViews, Notification notification, int i3) {
        this(context, i2, remoteViews, notification, i3, null);
    }

    private void b() {
        ((NotificationManager) com.bumptech.glide.util.j.a((NotificationManager) this.f5299e.getSystemService("notification"))).notify(this.f5301g, this.f5300f, this.f5302h);
    }

    @Override // com.bumptech.glide.r.l.p
    public /* bridge */ /* synthetic */ void a(@NonNull Object obj, @Nullable com.bumptech.glide.r.m.f fVar) {
        a((Bitmap) obj, (com.bumptech.glide.r.m.f<? super Bitmap>) fVar);
    }

    @Override // com.bumptech.glide.r.l.p
    public void c(@Nullable Drawable drawable) {
        a((Bitmap) null);
    }

    public l(Context context, int i2, RemoteViews remoteViews, Notification notification, int i3, String str) {
        this(context, Integer.MIN_VALUE, Integer.MIN_VALUE, i2, remoteViews, notification, i3, str);
    }

    public void a(@NonNull Bitmap bitmap, @Nullable com.bumptech.glide.r.m.f<? super Bitmap> fVar) {
        a(bitmap);
    }

    public l(Context context, int i2, int i3, int i4, RemoteViews remoteViews, Notification notification, int i5, String str) {
        super(i2, i3);
        this.f5299e = (Context) com.bumptech.glide.util.j.a(context, "Context must not be null!");
        this.f5302h = (Notification) com.bumptech.glide.util.j.a(notification, "Notification object can not be null!");
        this.f5298d = (RemoteViews) com.bumptech.glide.util.j.a(remoteViews, "RemoteViews object can not be null!");
        this.f5303i = i4;
        this.f5300f = i5;
        this.f5301g = str;
    }

    private void a(@Nullable Bitmap bitmap) {
        this.f5298d.setImageViewBitmap(this.f5303i, bitmap);
        b();
    }
}
