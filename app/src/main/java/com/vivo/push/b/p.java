package com.vivo.push.b;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;

/* compiled from: OnNotificationClickReceiveCommand.java */
/* loaded from: classes2.dex */
public final class p extends com.vivo.push.v {

    /* renamed from: a, reason: collision with root package name */
    private String f11961a;

    /* renamed from: b, reason: collision with root package name */
    private String f11962b;

    /* renamed from: c, reason: collision with root package name */
    private byte[] f11963c;

    /* renamed from: d, reason: collision with root package name */
    private long f11964d;

    /* renamed from: e, reason: collision with root package name */
    private InsideNotificationItem f11965e;

    /* renamed from: f, reason: collision with root package name */
    private String f11966f;

    /* renamed from: g, reason: collision with root package name */
    private String f11967g;

    /* renamed from: h, reason: collision with root package name */
    private Uri f11968h;

    /* renamed from: i, reason: collision with root package name */
    private String f11969i;

    /* renamed from: j, reason: collision with root package name */
    private Bundle f11970j;

    public p(String str, long j2, InsideNotificationItem insideNotificationItem) {
        super(5);
        this.f11961a = str;
        this.f11964d = j2;
        this.f11965e = insideNotificationItem;
    }

    public final void a(Uri uri) {
        this.f11968h = uri;
    }

    public final void b(String str) {
        this.f11966f = str;
    }

    public final void c(String str) {
        this.f11967g = str;
    }

    public final String d() {
        return this.f11961a;
    }

    public final long e() {
        return this.f11964d;
    }

    public final InsideNotificationItem f() {
        return this.f11965e;
    }

    public final String g() {
        return this.f11966f;
    }

    public final String h() {
        return this.f11967g;
    }

    public final String i() {
        return this.f11969i;
    }

    public final Uri j() {
        return this.f11968h;
    }

    public final Bundle k() {
        Bundle bundle = this.f11970j;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = new Bundle(bundle);
        try {
            bundle2.remove("command_type");
            bundle2.remove("security_avoid_pull");
            bundle2.remove("security_avoid_pull_rsa");
            bundle2.remove("security_avoid_rsa_public_key");
            bundle2.remove("security_avoid_rsa_public_key");
            bundle2.remove("notify_action");
            bundle2.remove("notify_componet_pkg");
            bundle2.remove("notify_componet_class_name");
            bundle2.remove("notification_v1");
            bundle2.remove("command");
            bundle2.remove("package_name");
            bundle2.remove("method");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return bundle2;
    }

    @Override // com.vivo.push.v
    public final String toString() {
        return "OnNotificationClickCommand";
    }

    private static Uri e(String str) {
        try {
            return Uri.parse(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.vivo.push.v
    protected final void c(com.vivo.push.d dVar) {
        dVar.a("package_name", this.f11961a);
        dVar.a("notify_id", this.f11964d);
        dVar.a("notification_v1", com.vivo.push.util.v.b(this.f11965e));
        dVar.a("open_pkg_name", this.f11962b);
        dVar.a("open_pkg_name_encode", this.f11963c);
        dVar.a("notify_action", this.f11966f);
        dVar.a("notify_componet_pkg", this.f11967g);
        dVar.a("notify_componet_class_name", this.f11969i);
        Uri uri = this.f11968h;
        if (uri != null) {
            dVar.a("notify_uri_data", uri.toString());
        }
    }

    public final void d(String str) {
        this.f11969i = str;
    }

    @Override // com.vivo.push.v
    protected final void d(com.vivo.push.d dVar) {
        this.f11961a = dVar.a("package_name");
        this.f11964d = dVar.b("notify_id", -1L);
        this.f11962b = dVar.a("open_pkg_name");
        this.f11963c = dVar.b("open_pkg_name_encode");
        this.f11966f = dVar.a("notify_action");
        this.f11967g = dVar.a("notify_componet_pkg");
        this.f11969i = dVar.a("notify_componet_class_name");
        String strA = dVar.a("notification_v1");
        if (!TextUtils.isEmpty(strA)) {
            this.f11965e = com.vivo.push.util.v.a(strA);
        }
        InsideNotificationItem insideNotificationItem = this.f11965e;
        if (insideNotificationItem != null) {
            insideNotificationItem.setMsgId(this.f11964d);
        }
        String strA2 = dVar.a("notify_uri_data");
        if (!TextUtils.isEmpty(strA2)) {
            this.f11968h = e(strA2);
        }
        this.f11970j = dVar.b();
    }

    public p() {
        super(5);
    }
}
