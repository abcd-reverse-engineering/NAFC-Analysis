package com.vivo.push.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;

/* compiled from: DefaultNotifyDataAdapter.java */
/* loaded from: classes2.dex */
public final class l implements BaseNotifyDataAdapter {

    /* renamed from: e, reason: collision with root package name */
    private static int f12273e;

    /* renamed from: f, reason: collision with root package name */
    private static int f12274f;

    /* renamed from: a, reason: collision with root package name */
    private Resources f12275a;

    /* renamed from: b, reason: collision with root package name */
    private String f12276b;

    /* renamed from: c, reason: collision with root package name */
    private String f12277c;

    /* renamed from: d, reason: collision with root package name */
    private String f12278d;

    private static boolean a(int i2) {
        return (i2 == -1 || i2 == 0) ? false : true;
    }

    private static boolean a(String str) {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        if (!TextUtils.isEmpty(str)) {
            return true;
        }
        u.d("DefaultNotifyDataAdapter", "systemVersion is not suit ");
        return false;
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getDefaultNotifyIcon() {
        if (a(f12273e)) {
            return f12273e;
        }
        String str = this.f12278d;
        int iA = !a(str) ? -1 : a(str, "_notifyicon");
        f12273e = iA;
        if (a(iA)) {
            return f12273e;
        }
        for (String strSubstring = this.f12277c; !TextUtils.isEmpty(strSubstring); strSubstring = strSubstring.substring(0, strSubstring.length() - 1)) {
            int identifier = this.f12275a.getIdentifier("vivo_push_rom" + strSubstring + "_notifyicon", "drawable", this.f12276b);
            if (identifier > 0) {
                return identifier;
            }
        }
        return this.f12275a.getIdentifier("vivo_push_notifyicon", "drawable", this.f12276b);
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getDefaultSmallIconId() {
        if (a(f12274f)) {
            return f12274f;
        }
        String str = this.f12278d;
        int iA = !a(str) ? -1 : a(str, "_icon");
        f12274f = iA;
        if (a(iA)) {
            return f12274f;
        }
        for (String strSubstring = this.f12277c; !TextUtils.isEmpty(strSubstring); strSubstring = strSubstring.substring(0, strSubstring.length() - 1)) {
            int identifier = this.f12275a.getIdentifier("vivo_push_rom" + strSubstring + "_icon", "drawable", this.f12276b);
            if (identifier > 0) {
                return identifier;
            }
        }
        return this.f12275a.getIdentifier("vivo_push_icon", "drawable", this.f12276b);
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getNotifyMode(InsideNotificationItem insideNotificationItem) {
        return Build.VERSION.SDK_INT >= 21 ? 2 : 1;
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final void init(Context context) {
        this.f12276b = context.getPackageName();
        this.f12275a = context.getResources();
        this.f12277c = n.a();
        this.f12278d = Build.VERSION.RELEASE;
    }

    private int a(String str, String str2) throws NumberFormatException {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String[] strArrSplit = str.split("\\.");
            if (strArrSplit != null && strArrSplit.length > 0) {
                str = strArrSplit[0];
            }
            try {
                for (int i2 = Integer.parseInt(str); i2 > 0; i2--) {
                    String str3 = "vivo_push_ard" + i2 + str2;
                    u.c("DefaultNotifyDataAdapter", "get notify icon : ".concat(String.valueOf(str3)));
                    int identifier = this.f12275a.getIdentifier(str3, "drawable", this.f12276b);
                    if (identifier > 0) {
                        u.c("DefaultNotifyDataAdapter", "find notify icon : ".concat(String.valueOf(str3)));
                        return identifier;
                    }
                }
            } catch (Exception e2) {
                u.a("DefaultNotifyDataAdapter", e2);
            }
        }
        return -1;
    }
}
