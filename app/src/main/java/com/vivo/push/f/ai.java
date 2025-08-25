package com.vivo.push.f;

import android.content.Context;
import android.content.pm.PackageManager;
import com.vivo.push.cache.ClientConfigManagerImpl;
import ui.activity.BaseProgressUploadActivity;

/* compiled from: SendCommandTask.java */
/* loaded from: classes2.dex */
final class ai extends com.vivo.push.s {
    ai(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    protected final void a(com.vivo.push.v vVar) throws PackageManager.NameNotFoundException {
        Context context = this.f12207a;
        if (context == null) {
            com.vivo.push.util.u.d("SendCommandTask", "SendCommandTask " + vVar + " ; mContext is Null");
            return;
        }
        if (vVar == null) {
            com.vivo.push.util.u.d("SendCommandTask", "SendCommandTask pushCommand is Null");
            return;
        }
        com.vivo.push.model.b bVarA = com.vivo.push.util.aa.a(context, com.vivo.push.restructure.a.a().f());
        int iB = vVar.b();
        if (iB != 0) {
            if (iB == 2009) {
                com.vivo.push.util.u.a(ClientConfigManagerImpl.getInstance(this.f12207a).isDebug());
                if (com.vivo.push.util.u.b()) {
                    com.vivo.push.m.a();
                    com.vivo.push.restructure.a.a().e().e();
                    com.vivo.push.util.c cVar = new com.vivo.push.util.c();
                    cVar.a(this.f12207a, "com.vivo.push_preferences.hybridapptoken_v1");
                    cVar.a();
                    com.vivo.push.util.c cVar2 = new com.vivo.push.util.c();
                    cVar2.a(this.f12207a, "com.vivo.push_preferences.appconfig_v1");
                    cVar2.a();
                    if (!com.vivo.push.m.a().f()) {
                        ClientConfigManagerImpl.getInstance(this.f12207a).clearPush();
                    }
                }
            } else if (iB != 2011) {
                switch (iB) {
                    case BaseProgressUploadActivity.REQUESTION_CODE_RECORD_AUDIO_2 /* 2002 */:
                    case 2003:
                    case 2004:
                    case 2005:
                        if (bVarA == null || bVarA.c()) {
                            com.vivo.push.m.a().a(((com.vivo.push.b.c) vVar).f(), 1005);
                            break;
                        } else {
                            com.vivo.push.b.c cVar3 = (com.vivo.push.b.c) vVar;
                            int iA = com.vivo.push.util.y.a(cVar3);
                            if (iA != 0) {
                                com.vivo.push.m.a().a(cVar3.f(), iA);
                                return;
                            }
                        }
                        break;
                }
            } else {
                com.vivo.push.util.u.a(ClientConfigManagerImpl.getInstance(this.f12207a).isDebug(((com.vivo.push.b.w) vVar).d()));
            }
        }
        if (bVarA == null) {
            com.vivo.push.util.u.d("SendCommandTask", "SendCommandTask " + vVar + " ; pushPkgInfo is Null");
            return;
        }
        String strA = bVarA.a();
        if (bVarA.c()) {
            try {
                com.vivo.push.m.a().a(((com.vivo.push.b.c) vVar).f(), 1004);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            vVar = new com.vivo.push.b.e();
            com.vivo.push.util.u.d("SendCommandTask", "SendCommandTask " + vVar + " ; pkgName is InBlackList ");
        }
        com.vivo.push.a.a.a(this.f12207a, strA, vVar);
    }
}
