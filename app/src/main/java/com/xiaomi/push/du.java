package com.xiaomi.push;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.view.ViewCompat;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.Map;

/* loaded from: classes2.dex */
public class du extends dx {

    /* renamed from: a, reason: collision with root package name */
    private int f12716a;

    /* renamed from: b, reason: collision with root package name */
    private Bitmap f12717b;

    /* renamed from: c, reason: collision with root package name */
    private Bitmap f12718c;

    public du(Context context, String str) {
        super(context, str);
        this.f12716a = 16777216;
    }

    @Override // com.xiaomi.push.dx, android.app.Notification.Builder
    /* renamed from: a */
    public dx setLargeIcon(Bitmap bitmap) {
        return this;
    }

    @Override // com.xiaomi.push.dx
    /* renamed from: a */
    protected String mo367a() {
        return "notification_banner";
    }

    @Override // com.xiaomi.push.dx
    /* renamed from: a, reason: collision with other method in class */
    protected boolean mo361a() {
        if (!j.m626a()) {
            return false;
        }
        Resources resources = a().getResources();
        String packageName = a().getPackageName();
        return (a(a().getResources(), "bg", "id", a().getPackageName()) == 0 || a(resources, RemoteMessageConst.Notification.ICON, "id", packageName) == 0 || a(resources, "title", "id", packageName) == 0 || j.a(a()) < 9) ? false : true;
    }

    public du b(Bitmap bitmap) {
        if (m370b() && bitmap != null) {
            this.f12718c = bitmap;
        }
        return this;
    }

    @Override // com.xiaomi.push.dx
    protected String b() {
        return null;
    }

    @Override // com.xiaomi.push.dx
    /* renamed from: a */
    public du setLargeIcon(Bitmap bitmap) {
        if (m370b() && bitmap != null) {
            if (bitmap.getWidth() == 984 && 184 <= bitmap.getHeight() && bitmap.getHeight() <= 1678) {
                this.f12717b = bitmap;
            } else {
                com.xiaomi.channel.commonutils.logger.b.m50a("colorful notification banner image resolution error, must belong to [984*184, 984*1678]");
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.dv
    /* renamed from: a */
    public du mo362a(String str) {
        if (m370b() && !TextUtils.isEmpty(str)) {
            try {
                this.f12716a = Color.parseColor(str);
            } catch (Exception unused) {
                com.xiaomi.channel.commonutils.logger.b.m50a("parse banner notification image text color error");
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.dx, com.xiaomi.push.dv
    /* renamed from: a, reason: collision with other method in class */
    public void mo360a() {
        if (m370b() && this.f12717b != null) {
            super.mo360a();
            Resources resources = a().getResources();
            String packageName = a().getPackageName();
            int iA = a(resources, "bg", "id", packageName);
            if (j.a(a()) >= 10) {
                m366a().setImageViewBitmap(iA, a(this.f12717b, 30.0f));
            } else {
                m366a().setImageViewBitmap(iA, this.f12717b);
            }
            int iA2 = a(resources, RemoteMessageConst.Notification.ICON, "id", packageName);
            if (this.f12718c != null) {
                m366a().setImageViewBitmap(iA2, this.f12718c);
            } else {
                a(iA2);
            }
            int iA3 = a(resources, "title", "id", packageName);
            m366a().setTextViewText(iA3, ((dx) this).f409a);
            Map<String, String> map = ((dx) this).f412a;
            if (map != null && this.f12716a == 16777216) {
                mo362a(map.get("notification_image_text_color"));
            }
            RemoteViews remoteViewsM366a = m366a();
            int i2 = this.f12716a;
            remoteViewsM366a.setTextColor(iA3, (i2 == 16777216 || !m368a(i2)) ? -1 : ViewCompat.MEASURED_STATE_MASK);
            setCustomContentView(m366a());
            Bundle bundle = new Bundle();
            bundle.putBoolean("miui.customHeight", true);
            addExtras(bundle);
            return;
        }
        m369b();
    }
}
