package com.vivo.push.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import androidx.core.view.ViewCompat;

/* compiled from: DefaultNotifyLayoutAdapter.java */
/* loaded from: classes2.dex */
public final class m implements BaseNotifyLayoutAdapter {

    /* renamed from: a, reason: collision with root package name */
    private Resources f12279a;

    /* renamed from: b, reason: collision with root package name */
    private String f12280b;

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getNotificationLayout() {
        return this.f12279a.getIdentifier("push_notify", "layout", this.f12280b);
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getSuitIconId() {
        Resources resources;
        String str;
        String str2;
        if (n.f12284d) {
            resources = this.f12279a;
            str = this.f12280b;
            str2 = "notify_icon_rom30";
        } else if (n.f12283c) {
            resources = this.f12279a;
            str = this.f12280b;
            str2 = "notify_icon_rom20";
        } else {
            resources = this.f12279a;
            str = this.f12280b;
            str2 = "notify_icon";
        }
        return resources.getIdentifier(str2, "id", str);
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getTitleColor() {
        int iIntValue;
        try {
            iIntValue = ((Integer) ag.a("com.android.internal.R$color", "vivo_notification_title_text_color")).intValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            iIntValue = 0;
        }
        if (iIntValue > 0) {
            return this.f12279a.getColor(iIntValue);
        }
        if (n.f12284d) {
            return -1;
        }
        if (!n.f12283c) {
            return ViewCompat.MEASURED_STATE_MASK;
        }
        if (n.f12284d) {
            return Color.parseColor("#ff999999");
        }
        return -1;
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final void init(Context context) {
        this.f12280b = context.getPackageName();
        this.f12279a = context.getResources();
    }
}
