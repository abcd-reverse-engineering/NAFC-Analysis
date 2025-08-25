package com.xiaomi.push;

import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.view.ViewCompat;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.Map;

/* loaded from: classes2.dex */
public class dw extends dx {

    /* renamed from: a, reason: collision with root package name */
    private int f12720a;

    /* renamed from: a, reason: collision with other field name */
    private PendingIntent f404a;

    /* renamed from: b, reason: collision with root package name */
    private int f12721b;

    /* renamed from: b, reason: collision with other field name */
    private Bitmap f405b;

    /* renamed from: c, reason: collision with root package name */
    private int f12722c;

    /* renamed from: c, reason: collision with other field name */
    private CharSequence f406c;

    public dw(Context context, int i2, String str) {
        super(context, i2, str);
        this.f12720a = 16777216;
        this.f12721b = 16777216;
        this.f12722c = 16777216;
    }

    @Override // com.xiaomi.push.dx
    /* renamed from: a */
    protected String mo367a() {
        return "notification_colorful";
    }

    @Override // com.xiaomi.push.dx
    /* renamed from: a */
    protected boolean mo361a() {
        if (!j.m626a()) {
            return false;
        }
        Resources resources = a().getResources();
        String packageName = a().getPackageName();
        return (a(resources, RemoteMessageConst.Notification.ICON, "id", packageName) == 0 || a(resources, "title", "id", packageName) == 0 || a(resources, "content", "id", packageName) == 0) ? false : true;
    }

    public dw b(String str) {
        if (m370b() && !TextUtils.isEmpty(str)) {
            try {
                this.f12720a = Color.parseColor(str);
            } catch (Exception unused) {
                com.xiaomi.channel.commonutils.logger.b.m50a("parse colorful notification bg color error");
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.dx
    protected String b() {
        return "notification_colorful_copy";
    }

    public dw c(String str) {
        if (m370b() && !TextUtils.isEmpty(str)) {
            try {
                this.f12722c = Color.parseColor(str);
            } catch (Exception unused) {
                com.xiaomi.channel.commonutils.logger.b.m50a("parse colorful notification image text color error");
            }
        }
        return this;
    }

    public dw a(CharSequence charSequence, PendingIntent pendingIntent) {
        if (m370b()) {
            super.addAction(0, charSequence, pendingIntent);
            this.f406c = charSequence;
            this.f404a = pendingIntent;
        }
        return this;
    }

    @Override // com.xiaomi.push.dv
    /* renamed from: a */
    public dw mo362a(String str) {
        if (m370b() && !TextUtils.isEmpty(str)) {
            try {
                this.f12721b = Color.parseColor(str);
            } catch (Exception unused) {
                com.xiaomi.channel.commonutils.logger.b.m50a("parse colorful notification button bg color error");
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.dx
    /* renamed from: a */
    public dw setLargeIcon(Bitmap bitmap) {
        if (m370b() && bitmap != null) {
            if (bitmap.getWidth() == 984 && bitmap.getHeight() >= 177 && bitmap.getHeight() <= 207) {
                this.f405b = bitmap;
            } else {
                com.xiaomi.channel.commonutils.logger.b.m50a("colorful notification bg image resolution error, must [984*177, 984*207]");
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.dx, com.xiaomi.push.dv
    /* renamed from: a */
    public void mo360a() {
        if (m370b()) {
            super.mo360a();
            Resources resources = a().getResources();
            String packageName = a().getPackageName();
            int iA = a(resources, RemoteMessageConst.Notification.ICON, "id", packageName);
            if (((dx) this).f407a == null) {
                a(iA);
            } else {
                m366a().setImageViewBitmap(iA, ((dx) this).f407a);
            }
            int iA2 = a(resources, "title", "id", packageName);
            int iA3 = a(resources, "content", "id", packageName);
            m366a().setTextViewText(iA2, ((dx) this).f409a);
            m366a().setTextViewText(iA3, ((dx) this).f414b);
            if (!TextUtils.isEmpty(this.f406c)) {
                int iA4 = a(resources, "buttonContainer", "id", packageName);
                int iA5 = a(resources, "button", "id", packageName);
                int iA6 = a(resources, "buttonBg", "id", packageName);
                m366a().setViewVisibility(iA4, 0);
                m366a().setTextViewText(iA5, this.f406c);
                m366a().setOnClickPendingIntent(iA4, this.f404a);
                if (this.f12721b != 16777216) {
                    int iA7 = a(70.0f);
                    int iA8 = a(29.0f);
                    m366a().setImageViewBitmap(iA6, com.xiaomi.push.service.x.a(a(this.f12721b, iA7, iA8, iA8 / 2.0f)));
                    m366a().setTextColor(iA5, m368a(this.f12721b) ? -1 : ViewCompat.MEASURED_STATE_MASK);
                }
            }
            int iA9 = a(resources, "bg", "id", packageName);
            int iA10 = a(resources, "container", "id", packageName);
            if (this.f12720a != 16777216) {
                if (j.a(a()) >= 10) {
                    m366a().setImageViewBitmap(iA9, com.xiaomi.push.service.x.a(a(this.f12720a, 984, 192, 30.0f)));
                } else {
                    m366a().setImageViewBitmap(iA9, com.xiaomi.push.service.x.a(a(this.f12720a, 984, 192, 0.0f)));
                }
                a(m366a(), iA10, iA2, iA3, m368a(this.f12720a));
            } else if (this.f405b != null) {
                if (j.a(a()) >= 10) {
                    m366a().setImageViewBitmap(iA9, a(this.f405b, 30.0f));
                } else {
                    m366a().setImageViewBitmap(iA9, this.f405b);
                }
                Map<String, String> map = ((dx) this).f412a;
                if (map != null && this.f12722c == 16777216) {
                    c(map.get("notification_image_text_color"));
                }
                int i2 = this.f12722c;
                a(m366a(), iA10, iA2, iA3, i2 == 16777216 || !m368a(i2));
            } else if (Build.VERSION.SDK_INT >= 24) {
                m366a().setViewVisibility(iA, 8);
                m366a().setViewVisibility(iA9, 8);
                try {
                    aw.a((Object) this, "setStyle", C0343r.a(a(), "android.app.Notification$DecoratedCustomViewStyle").getConstructor(new Class[0]).newInstance(new Object[0]));
                } catch (Exception unused) {
                    com.xiaomi.channel.commonutils.logger.b.m50a("load class DecoratedCustomViewStyle failed");
                }
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("miui.customHeight", true);
            addExtras(bundle);
            setCustomContentView(m366a());
            return;
        }
        m369b();
    }

    private void a(RemoteViews remoteViews, int i2, int i3, int i4, boolean z) {
        int iA = a(6.0f);
        remoteViews.setViewPadding(i2, iA, 0, iA, 0);
        if (z) {
            remoteViews.setTextColor(i3, -1);
            remoteViews.setTextColor(i4, -1);
        } else {
            remoteViews.setTextColor(i3, ViewCompat.MEASURED_STATE_MASK);
            remoteViews.setTextColor(i4, ViewCompat.MEASURED_STATE_MASK);
        }
    }

    private Drawable a(int i2, int i3, int i4, float f2) {
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.setShape(new RoundRectShape(new float[]{f2, f2, f2, f2, f2, f2, f2, f2}, null, null));
        shapeDrawable.getPaint().setColor(i2);
        shapeDrawable.getPaint().setStyle(Paint.Style.FILL);
        shapeDrawable.setIntrinsicWidth(i3);
        shapeDrawable.setIntrinsicHeight(i4);
        return shapeDrawable;
    }
}
