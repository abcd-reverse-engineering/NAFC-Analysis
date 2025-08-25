package com.bumptech.glide.load.r.f;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.l;
import com.bumptech.glide.load.p.v;
import java.util.List;

/* compiled from: ResourceDrawableDecoder.java */
/* loaded from: classes.dex */
public class e implements l<Uri, Drawable> {

    /* renamed from: b, reason: collision with root package name */
    private static final String f4977b = "android";

    /* renamed from: c, reason: collision with root package name */
    private static final int f4978c = 0;

    /* renamed from: d, reason: collision with root package name */
    private static final int f4979d = 2;

    /* renamed from: e, reason: collision with root package name */
    private static final int f4980e = 0;

    /* renamed from: f, reason: collision with root package name */
    private static final int f4981f = 1;

    /* renamed from: g, reason: collision with root package name */
    private static final int f4982g = 1;

    /* renamed from: h, reason: collision with root package name */
    private static final int f4983h = 0;

    /* renamed from: a, reason: collision with root package name */
    private final Context f4984a;

    public e(Context context) {
        this.f4984a = context.getApplicationContext();
    }

    @DrawableRes
    private int b(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            return a(context, uri);
        }
        if (pathSegments.size() == 1) {
            return a(uri);
        }
        throw new IllegalArgumentException("Unrecognized Uri format: " + uri);
    }

    @Override // com.bumptech.glide.load.l
    public boolean a(@NonNull Uri uri, @NonNull j jVar) {
        return uri.getScheme().equals("android.resource");
    }

    @Override // com.bumptech.glide.load.l
    @Nullable
    public v<Drawable> a(@NonNull Uri uri, int i2, int i3, @NonNull j jVar) {
        Context contextA = a(uri, uri.getAuthority());
        return d.a(a.a(this.f4984a, contextA, b(contextA, uri)));
    }

    @NonNull
    private Context a(Uri uri, String str) {
        if (str.equals(this.f4984a.getPackageName())) {
            return this.f4984a;
        }
        try {
            return this.f4984a.createPackageContext(str, 0);
        } catch (PackageManager.NameNotFoundException e2) {
            if (str.contains(this.f4984a.getPackageName())) {
                return this.f4984a;
            }
            throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + uri, e2);
        }
    }

    @DrawableRes
    private int a(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        String authority = uri.getAuthority();
        String str = pathSegments.get(0);
        String str2 = pathSegments.get(1);
        int identifier = context.getResources().getIdentifier(str2, str, authority);
        if (identifier == 0) {
            identifier = Resources.getSystem().getIdentifier(str2, str, "android");
        }
        if (identifier != 0) {
            return identifier;
        }
        throw new IllegalArgumentException("Failed to find resource id for: " + uri);
    }

    @DrawableRes
    private int a(Uri uri) {
        try {
            return Integer.parseInt(uri.getPathSegments().get(0));
        } catch (NumberFormatException e2) {
            throw new IllegalArgumentException("Unrecognized Uri format: " + uri, e2);
        }
    }
}
