package com.xiaomi.push;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import java.util.Map;

@SuppressLint({"NewApi"})
/* loaded from: classes2.dex */
public class dv extends Notification.Builder {

    /* renamed from: a, reason: collision with root package name */
    private Context f12719a;

    public dv(Context context) {
        super(context);
        this.f12719a = context;
    }

    protected Context a() {
        return this.f12719a;
    }

    public dv a(Map<String, String> map) {
        return this;
    }

    /* renamed from: a */
    protected void mo360a() {
    }

    @Override // android.app.Notification.Builder
    public Notification build() {
        mo360a();
        return super.build();
    }

    public int a(Resources resources, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return resources.getIdentifier(str, str2, str3);
    }

    public final int a(String str) {
        return a(a().getResources(), str, "id", a().getPackageName());
    }

    @Override // android.app.Notification.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public dv addExtras(Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 20) {
            super.addExtras(bundle);
        }
        return this;
    }

    @Override // android.app.Notification.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public dv setCustomContentView(RemoteViews remoteViews) {
        if (Build.VERSION.SDK_INT >= 24) {
            super.setCustomContentView(remoteViews);
        } else {
            super.setContent(remoteViews);
        }
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public dv mo362a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                aw.a((Object) this, "setColor", Integer.valueOf(Color.parseColor(str)));
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.d("fail to set color. " + e2);
            }
        }
        return this;
    }
}
