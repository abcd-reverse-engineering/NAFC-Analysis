package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.push.ae;
import com.xiaomi.push.bw;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public class bn {

    /* renamed from: a, reason: collision with root package name */
    private static volatile bn f12506a;

    /* renamed from: a, reason: collision with other field name */
    private Context f217a;

    /* renamed from: a, reason: collision with other field name */
    private bx f219a;

    /* renamed from: a, reason: collision with other field name */
    private by f220a;

    /* renamed from: e, reason: collision with root package name */
    private String f12510e;

    /* renamed from: f, reason: collision with root package name */
    private String f12511f;

    /* renamed from: a, reason: collision with other field name */
    private final String f221a = "push_stat_sp";

    /* renamed from: b, reason: collision with other field name */
    private final String f222b = "upload_time";

    /* renamed from: c, reason: collision with other field name */
    private final String f223c = "delete_time";

    /* renamed from: d, reason: collision with root package name */
    private final String f12509d = "check_time";

    /* renamed from: a, reason: collision with other field name */
    private ae.a f218a = new ae.a() { // from class: com.xiaomi.push.bn.1
        @Override // com.xiaomi.push.ae.a
        /* renamed from: a */
        public String mo183a() {
            return "10052";
        }

        @Override // java.lang.Runnable
        public void run() {
            com.xiaomi.channel.commonutils.logger.b.c("exec== mUploadJob");
            if (bn.this.f220a != null) {
                bn.this.f220a.a(bn.this.f217a);
                bn.this.b("upload_time");
            }
        }
    };

    /* renamed from: b, reason: collision with root package name */
    private ae.a f12507b = new ae.a() { // from class: com.xiaomi.push.bn.2
        @Override // com.xiaomi.push.ae.a
        /* renamed from: a */
        public String mo183a() {
            return "10054";
        }

        @Override // java.lang.Runnable
        public void run() {
            com.xiaomi.channel.commonutils.logger.b.c("exec== DbSizeControlJob");
            bw.a(bn.this.f217a).a(new bp(bn.this.c(), new WeakReference(bn.this.f217a)));
            bn.this.b("check_time");
        }
    };

    /* renamed from: c, reason: collision with root package name */
    private ae.a f12508c = new ae.a() { // from class: com.xiaomi.push.bn.3
        @Override // com.xiaomi.push.ae.a
        /* renamed from: a */
        public String mo183a() {
            return "10053";
        }

        @Override // java.lang.Runnable
        public void run() {
            if (bn.this.f220a != null) {
                bn.this.f220a.b(bn.this.f217a);
                bn.this.b("delete_time");
            }
        }
    };

    private bn(Context context) {
        this.f217a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        SharedPreferences.Editor editorEdit = this.f217a.getSharedPreferences("push_stat_sp", 0).edit();
        editorEdit.putLong(str, System.currentTimeMillis());
        p.a(editorEdit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c() {
        return this.f217a.getDatabasePath(bo.f225a).getAbsolutePath();
    }

    public static bn a(Context context) {
        if (f12506a == null) {
            synchronized (bn.class) {
                if (f12506a == null) {
                    f12506a = new bn(context);
                }
            }
        }
        return f12506a;
    }

    public String b() {
        return this.f12511f;
    }

    private boolean a() {
        return com.xiaomi.push.service.ah.a(this.f217a).a(gk.StatDataSwitch.a(), true);
    }

    public void a(bw.a aVar) {
        bw.a(this.f217a).a(aVar);
    }

    public void a(String str, String str2, Boolean bool) {
        if (this.f219a != null) {
            if (bool.booleanValue()) {
                this.f219a.a(this.f217a, str2, str);
            } else {
                this.f219a.b(this.f217a, str2, str);
            }
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m191a() {
        return this.f12510e;
    }

    public void a(String str) {
        if (a() && !TextUtils.isEmpty(str)) {
            a(bz.a(this.f217a, str));
        }
    }

    public void a(gj gjVar) {
        if (a() && com.xiaomi.push.service.az.a(gjVar.e())) {
            a(bt.a(this.f217a, c(), gjVar));
        }
    }
}
