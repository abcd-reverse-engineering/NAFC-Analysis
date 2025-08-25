package com.vivo.push.sdk;

import android.content.Intent;
import android.os.Message;
import com.vivo.push.ab;
import com.vivo.push.util.g;
import com.vivo.push.util.u;

/* compiled from: CommandWorker.java */
/* loaded from: classes2.dex */
public final class a extends ab {

    /* renamed from: c, reason: collision with root package name */
    private static a f12215c;

    /* renamed from: d, reason: collision with root package name */
    private String f12216d = "";

    private a() {
    }

    public final String b() {
        return this.f12216d;
    }

    public static synchronized a a() {
        if (f12215c == null) {
            f12215c = new a();
        }
        return f12215c;
    }

    @Override // com.vivo.push.ab
    public final void b(Message message) {
        Intent intent = (Intent) message.obj;
        if (intent == null || this.f11925a == null) {
            u.d("CommandWorker", " handleMessage error: intent : " + intent + ", mContext: " + this.f11925a);
            return;
        }
        com.vivo.push.restructure.a.b bVar = new com.vivo.push.restructure.a.b(intent);
        try {
            u.d("CommandWorker", "received msg : ".concat(String.valueOf(bVar.a())));
            g.a().execute(new b(this, bVar));
        } catch (Exception e2) {
            u.a("CommandWorker", "handle message err : " + e2.getMessage());
        }
    }

    public final void a(String str) {
        this.f12216d = str;
    }

    public final void a(Intent intent) {
        if (intent != null && this.f11925a != null) {
            Message messageObtain = Message.obtain();
            messageObtain.obj = intent;
            a(messageObtain);
        } else {
            u.d("CommandWorker", " sendMessage error: intent : " + intent + ", mContext: " + this.f11925a);
        }
    }
}
