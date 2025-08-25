package com.xiaomi.push;

import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes2.dex */
public class ez implements fj {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f12797a = false;

    /* renamed from: a, reason: collision with other field name */
    private fa f488a;

    /* renamed from: a, reason: collision with other field name */
    private SimpleDateFormat f491a = new SimpleDateFormat("hh:mm:ss aaa");

    /* renamed from: a, reason: collision with other field name */
    private a f487a = null;

    /* renamed from: b, reason: collision with root package name */
    private a f12798b = null;

    /* renamed from: a, reason: collision with other field name */
    private fd f489a = null;

    /* renamed from: a, reason: collision with other field name */
    private final String f490a = "[Slim] ";

    public ez(fa faVar) {
        this.f488a = null;
        this.f488a = faVar;
        a();
    }

    private void a() {
        this.f487a = new a(true);
        this.f12798b = new a(false);
        fa faVar = this.f488a;
        a aVar = this.f487a;
        faVar.a(aVar, aVar);
        fa faVar2 = this.f488a;
        a aVar2 = this.f12798b;
        faVar2.b(aVar2, aVar2);
        this.f489a = new fd() { // from class: com.xiaomi.push.ez.1
            @Override // com.xiaomi.push.fd
            public void a(fa faVar3, int i2, Exception exc) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + ez.this.f491a.format(new Date()) + " Connection closed (" + ez.this.f488a.hashCode() + ")");
            }

            @Override // com.xiaomi.push.fd
            public void b(fa faVar3) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + ez.this.f491a.format(new Date()) + " Connection reconnected (" + ez.this.f488a.hashCode() + ")");
            }

            @Override // com.xiaomi.push.fd
            public void a(fa faVar3, Exception exc) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + ez.this.f491a.format(new Date()) + " Reconnection failed due to an exception (" + ez.this.f488a.hashCode() + ")");
                exc.printStackTrace();
            }

            @Override // com.xiaomi.push.fd
            public void a(fa faVar3) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + ez.this.f491a.format(new Date()) + " Connection started (" + ez.this.f488a.hashCode() + ")");
            }
        };
    }

    class a implements ff, fk {

        /* renamed from: a, reason: collision with other field name */
        String f492a;

        /* renamed from: a, reason: collision with other field name */
        private boolean f493a;

        a(boolean z) {
            this.f493a = true;
            this.f493a = z;
            this.f492a = z ? " RCV " : " Sent ";
        }

        @Override // com.xiaomi.push.ff
        public void a(fo foVar) {
            if (ez.f12797a) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + ez.this.f491a.format(new Date()) + this.f492a + " PKT " + foVar.mo431a());
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + ez.this.f491a.format(new Date()) + this.f492a + " PKT [" + foVar.k() + Constants.ACCEPT_TIME_SEPARATOR_SP + foVar.j() + "]");
        }

        @Override // com.xiaomi.push.fk
        /* renamed from: a */
        public boolean mo240a(fo foVar) {
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0137  */
        @Override // com.xiaomi.push.ff
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(com.xiaomi.push.er r6) throws java.lang.NumberFormatException {
            /*
                Method dump skipped, instructions count: 367
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.ez.a.a(com.xiaomi.push.er):void");
        }
    }
}
