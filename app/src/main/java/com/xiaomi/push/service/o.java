package com.xiaomi.push.service;

import android.text.TextUtils;
import com.xiaomi.push.ge;
import com.xiaomi.push.gf;
import com.xiaomi.push.gj;
import com.xiaomi.push.gs;
import com.xiaomi.push.hb;
import com.xiaomi.push.he;
import com.xiaomi.push.hp;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class o implements ge {

    /* renamed from: a, reason: collision with root package name */
    private final XMPushService f13442a;

    public o(XMPushService xMPushService) {
        this.f13442a = xMPushService;
    }

    @Override // com.xiaomi.push.ge
    public void a(final List<gj> list, final String str, final String str2) {
        this.f13442a.a(new XMPushService.j(4) { // from class: com.xiaomi.push.service.o.1
            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "Send tiny data.";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* renamed from: a */
            public void mo379a() throws NumberFormatException {
                String strA = o.this.a(str);
                ArrayList<he> arrayListA = az.a(list, str, strA, 32768);
                if (arrayListA == null) {
                    com.xiaomi.channel.commonutils.logger.b.d("TinyData LongConnUploader.upload Get a null XmPushActionNotification list when TinyDataHelper.pack() in XMPushService.");
                    return;
                }
                Iterator<he> it = arrayListA.iterator();
                while (it.hasNext()) {
                    he next = it.next();
                    next.a("uploadWay", "longXMPushService");
                    hb hbVarA = w.a(str, strA, next, gf.Notification);
                    if (!TextUtils.isEmpty(str2) && !TextUtils.equals(str, str2)) {
                        if (hbVarA.m529a() == null) {
                            gs gsVar = new gs();
                            gsVar.a("-1");
                            hbVarA.a(gsVar);
                        }
                        hbVarA.m529a().b("ext_traffic_source_pkg", str2);
                    }
                    o.this.f13442a.a(str, hp.a(hbVarA), true);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        return "com.xiaomi.xmsf".equals(str) ? "1000271" : this.f13442a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null);
    }
}
