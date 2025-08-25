package com.taobao.agoo.a.a;

import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.p;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class a extends b {
    public static final String JSON_CMD_REMOVEALIAS = "removeAlias";
    public static final String JSON_CMD_REMOVEALLALIAS = "unbindAllAlias";
    public static final String JSON_CMD_SETALIAS = "setAlias";
    public static final String JSON_PUSH_USER_TOKEN = "pushAliasToken";

    /* renamed from: a, reason: collision with root package name */
    public String f8708a;

    /* renamed from: b, reason: collision with root package name */
    public String f8709b;

    /* renamed from: c, reason: collision with root package name */
    public String f8710c;

    /* renamed from: d, reason: collision with root package name */
    public String f8711d;

    public static byte[] b(String str, String str2, String str3) {
        a aVar = new a();
        aVar.f8708a = str;
        aVar.f8709b = str2;
        aVar.f8711d = str3;
        aVar.f8712e = JSON_CMD_REMOVEALIAS;
        return aVar.a();
    }

    public static byte[] c(String str, String str2, String str3) {
        a aVar = new a();
        aVar.f8708a = str;
        aVar.f8709b = str2;
        aVar.f8710c = str3;
        aVar.f8712e = JSON_CMD_REMOVEALIAS;
        return aVar.a();
    }

    public byte[] a() {
        try {
            String string = new p.a().a(b.JSON_CMD, this.f8712e).a("appKey", this.f8708a).a("deviceId", this.f8709b).a("alias", this.f8710c).a(JSON_PUSH_USER_TOKEN, this.f8711d).a().toString();
            ALog.i("AliasDO", "buildData", "data", string);
            return string.getBytes("utf-8");
        } catch (Throwable th) {
            ALog.e("AliasDO", "buildData", th, new Object[0]);
            return null;
        }
    }

    public static byte[] a(String str, String str2, String str3) {
        a aVar = new a();
        aVar.f8708a = str;
        aVar.f8709b = str2;
        aVar.f8710c = str3;
        aVar.f8712e = JSON_CMD_SETALIAS;
        return aVar.a();
    }

    public static byte[] a(String str, String str2) {
        a aVar = new a();
        aVar.f8708a = str;
        aVar.f8709b = str2;
        aVar.f8712e = JSON_CMD_REMOVEALLALIAS;
        return aVar.a();
    }
}
