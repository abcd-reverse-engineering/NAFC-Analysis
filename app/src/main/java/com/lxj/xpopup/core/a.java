package com.lxj.xpopup.core;

import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import com.lxj.xpopup.c.b;
import com.lxj.xpopup.d.c;
import com.lxj.xpopup.d.d;
import com.lxj.xpopup.d.f;
import com.lxj.xpopup.e.i;

/* compiled from: PopupInfo.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: k, reason: collision with root package name */
    public int f8037k;

    /* renamed from: l, reason: collision with root package name */
    public int f8038l;
    public i n;
    public ViewGroup o;
    public int s;
    public int t;

    /* renamed from: a, reason: collision with root package name */
    public f f8027a = null;

    /* renamed from: b, reason: collision with root package name */
    public Boolean f8028b = true;

    /* renamed from: c, reason: collision with root package name */
    public Boolean f8029c = true;

    /* renamed from: d, reason: collision with root package name */
    public Boolean f8030d = true;

    /* renamed from: e, reason: collision with root package name */
    public Boolean f8031e = true;

    /* renamed from: f, reason: collision with root package name */
    public View f8032f = null;

    /* renamed from: g, reason: collision with root package name */
    public View f8033g = null;

    /* renamed from: h, reason: collision with root package name */
    public c f8034h = null;

    /* renamed from: i, reason: collision with root package name */
    public b f8035i = null;

    /* renamed from: j, reason: collision with root package name */
    public PointF f8036j = null;

    /* renamed from: m, reason: collision with root package name */
    public Boolean f8039m = false;
    public Boolean p = true;
    public d q = null;
    public Boolean r = false;
    public Boolean u = true;
    public boolean v = false;
    public boolean w = true;
    public boolean x = true;

    public View a() {
        return this.f8032f;
    }

    public String toString() {
        return "PopupInfo{popupType=" + this.f8027a + ", isDismissOnBackPressed=" + this.f8028b + ", isDismissOnTouchOutside=" + this.f8029c + ", hasShadowBg=" + this.f8031e + ", atView=" + this.f8032f + ", popupAnimation=" + this.f8034h + ", customAnimator=" + this.f8035i + ", touchPoint=" + this.f8036j + ", maxWidth=" + this.f8037k + ", maxHeight=" + this.f8038l + '}';
    }
}
