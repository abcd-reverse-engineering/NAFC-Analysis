package com.xiaomi.push;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class dx extends dv {

    /* renamed from: a, reason: collision with root package name */
    private int f12723a;

    /* renamed from: a, reason: collision with other field name */
    protected Bitmap f407a;

    /* renamed from: a, reason: collision with other field name */
    private RemoteViews f408a;

    /* renamed from: a, reason: collision with other field name */
    protected CharSequence f409a;

    /* renamed from: a, reason: collision with other field name */
    private String f410a;

    /* renamed from: a, reason: collision with other field name */
    private ArrayList<Notification.Action> f411a;

    /* renamed from: a, reason: collision with other field name */
    protected Map<String, String> f412a;

    /* renamed from: a, reason: collision with other field name */
    private boolean f413a;

    /* renamed from: b, reason: collision with root package name */
    private int f12724b;

    /* renamed from: b, reason: collision with other field name */
    protected CharSequence f414b;

    /* renamed from: b, reason: collision with other field name */
    private boolean f415b;

    public dx(Context context, String str) {
        this(context, 0, str);
    }

    /* renamed from: c, reason: collision with other method in class */
    private boolean m364c() {
        Map<String, String> map = this.f412a;
        return map != null && Boolean.parseBoolean(map.get("custom_builder_set_title"));
    }

    private void d() {
        super.setContentTitle(this.f409a);
        super.setContentText(this.f414b);
    }

    private boolean e() {
        return m365d() && f();
    }

    private boolean f() {
        List<StatusBarNotification> listM687b;
        if (Build.VERSION.SDK_INT >= 20 && (listM687b = com.xiaomi.push.service.af.a(a(), this.f410a).m687b()) != null && !listM687b.isEmpty()) {
            for (StatusBarNotification statusBarNotification : listM687b) {
                if (statusBarNotification.getId() == this.f12723a) {
                    if (statusBarNotification.getNotification() == null) {
                        return false;
                    }
                    return !r0.extras.getBoolean("mipush.customCopyLayout", true);
                }
            }
        }
        return false;
    }

    @Override // android.app.Notification.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public dx setContentTitle(CharSequence charSequence) {
        this.f409a = charSequence;
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    protected abstract String mo367a();

    protected void a(int i2, Notification.Action action) {
    }

    /* renamed from: a */
    protected abstract boolean mo361a();

    @Override // android.app.Notification.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public dx setContentText(CharSequence charSequence) {
        this.f414b = charSequence;
        return this;
    }

    protected abstract String b();

    public dx(Context context, int i2, String str) {
        super(context);
        this.f411a = new ArrayList<>();
        this.f12724b = 0;
        this.f410a = str;
        this.f12723a = i2;
        m363c();
    }

    @Override // android.app.Notification.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public dx setLargeIcon(Bitmap bitmap) {
        this.f407a = bitmap;
        return this;
    }

    /* renamed from: b, reason: collision with other method in class */
    protected final void m369b() {
        super.setContentTitle(this.f409a);
        super.setContentText(this.f414b);
        Bitmap bitmap = this.f407a;
        if (bitmap != null) {
            super.setLargeIcon(bitmap);
        }
    }

    /* renamed from: d, reason: collision with other method in class */
    private boolean m365d() {
        return (TextUtils.isEmpty(b()) || TextUtils.isEmpty(this.f410a)) ? false : true;
    }

    @Override // com.xiaomi.push.dv
    public dv a(Map<String, String> map) {
        this.f412a = map;
        return this;
    }

    /* renamed from: c, reason: collision with other method in class */
    private void m363c() {
        int iA = a(a().getResources(), c(), "layout", a().getPackageName());
        if (iA != 0) {
            this.f408a = new RemoteViews(a().getPackageName(), iA);
            this.f413a = mo361a();
        } else {
            com.xiaomi.channel.commonutils.logger.b.m50a("create RemoteViews failed, no such layout resource was found");
        }
    }

    @Override // android.app.Notification.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public dx addAction(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
        addAction(new Notification.Action(i2, charSequence, pendingIntent));
        return this;
    }

    @Override // android.app.Notification.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public dx addAction(Notification.Action action) {
        if (action != null) {
            this.f411a.add(action);
        }
        int i2 = this.f12724b;
        this.f12724b = i2 + 1;
        a(i2, action);
        return this;
    }

    /* renamed from: b, reason: collision with other method in class */
    protected final boolean m370b() {
        return this.f413a;
    }

    @Override // com.xiaomi.push.dv
    /* renamed from: a */
    protected void mo360a() {
        super.mo360a();
        Bundle bundle = new Bundle();
        if (m365d()) {
            bundle.putBoolean("mipush.customCopyLayout", this.f415b);
        } else {
            bundle.putBoolean("mipush.customCopyLayout", false);
        }
        bundle.putBoolean("miui.customHeight", false);
        bundle.putBoolean("mipush.customNotification", true);
        bundle.putInt("mipush.customLargeIconId", a("large_icon"));
        if (this.f411a.size() > 0) {
            Notification.Action[] actionArr = new Notification.Action[this.f411a.size()];
            this.f411a.toArray(actionArr);
            bundle.putParcelableArray("mipush.customActions", actionArr);
        }
        if (!m364c() && com.xiaomi.push.service.ag.m689a(a().getContentResolver())) {
            bundle.putCharSequence("mipush.customTitle", this.f409a);
            bundle.putCharSequence("mipush.customContent", this.f414b);
        } else {
            d();
        }
        addExtras(bundle);
    }

    private String c() {
        this.f415b = e();
        return this.f415b ? b() : mo367a();
    }

    /* renamed from: a, reason: collision with other method in class */
    public final RemoteViews m366a() {
        return this.f408a;
    }

    protected void a(int i2) {
        Bitmap bitmapA = a();
        if (bitmapA != null) {
            m366a().setImageViewBitmap(i2, bitmapA);
            return;
        }
        int iB = g.b(a(), this.f410a);
        if (iB != 0) {
            m366a().setImageViewResource(i2, iB);
        }
    }

    private Bitmap a() {
        return com.xiaomi.push.service.x.a(g.m450a(a(), this.f410a));
    }

    protected int a(float f2) {
        return (int) ((f2 * a().getResources().getDisplayMetrics().density) + 0.5f);
    }

    protected Bitmap a(Bitmap bitmap, float f2) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        canvas.drawRoundRect(new RectF(rect), f2, f2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        if (!bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    /* renamed from: a, reason: collision with other method in class */
    protected final boolean m368a(int i2) {
        return ((((double) Color.red(i2)) * 0.299d) + (((double) Color.green(i2)) * 0.587d)) + (((double) Color.blue(i2)) * 0.114d) < 192.0d;
    }
}
