package com.vivo.push.f;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.just.agentweb.DefaultWebClient;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.util.NotifyAdapterUtil;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: NotifyOpenClientClickTask.java */
/* loaded from: classes2.dex */
public final class e extends aa {
    e(com.vivo.push.v vVar) {
        super(vVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Intent b(Intent intent, Map<String, String> map) {
        if (map != null && map.entrySet() != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry != null && entry.getKey() != null) {
                    intent.putExtra(entry.getKey(), entry.getValue());
                }
            }
        }
        return intent;
    }

    @Override // com.vivo.push.s
    protected final void a(com.vivo.push.v vVar) throws URISyntaxException {
        Intent uri;
        String str;
        com.vivo.push.b.p pVar = (com.vivo.push.b.p) vVar;
        InsideNotificationItem insideNotificationItemF = pVar.f();
        if (insideNotificationItemF == null) {
            com.vivo.push.util.u.d("NotifyOpenClientTask", "current notification item is null");
            return;
        }
        UPSNotificationMessage uPSNotificationMessageA = com.vivo.push.util.v.a(insideNotificationItemF);
        boolean zEquals = this.f12207a.getPackageName().equals(pVar.d());
        if (zEquals) {
            NotifyAdapterUtil.cancelNotify(this.f12207a);
        }
        if (zEquals) {
            com.vivo.push.b.x xVar = new com.vivo.push.b.x(1030L);
            HashMap<String, String> map = new HashMap<>();
            map.put("type", "2");
            map.put(com.heytap.mcssdk.constant.b.f5825c, String.valueOf(pVar.e()));
            map.put("platform", this.f12207a.getPackageName());
            String strA = com.vivo.push.restructure.a.a().e().a();
            if (!TextUtils.isEmpty(strA)) {
                map.put("remoteAppId", strA);
            }
            xVar.a(map);
            com.vivo.push.m.a().a(xVar);
            com.vivo.push.util.u.d("NotifyOpenClientTask", "notification is clicked by skip type[" + uPSNotificationMessageA.getSkipType() + "]");
            int skipType = uPSNotificationMessageA.getSkipType();
            boolean z = true;
            if (skipType == 1) {
                new Thread(new f(this, this.f12207a, uPSNotificationMessageA.getParams())).start();
                a(uPSNotificationMessageA);
                return;
            }
            if (skipType == 2) {
                String skipContent = uPSNotificationMessageA.getSkipContent();
                if (!skipContent.startsWith(DefaultWebClient.HTTP_SCHEME) && !skipContent.startsWith(DefaultWebClient.HTTPS_SCHEME)) {
                    z = false;
                }
                if (z) {
                    Uri uri2 = Uri.parse(skipContent);
                    Intent intent = new Intent("android.intent.action.VIEW", uri2);
                    intent.setFlags(CommonNetImpl.FLAG_AUTH);
                    b(intent, uPSNotificationMessageA.getParams());
                    try {
                        this.f12207a.startActivity(intent);
                    } catch (Exception unused) {
                        com.vivo.push.util.u.a("NotifyOpenClientTask", "startActivity error : ".concat(String.valueOf(uri2)));
                    }
                } else {
                    com.vivo.push.util.u.a("NotifyOpenClientTask", "url not legal");
                }
                a(uPSNotificationMessageA);
                return;
            }
            if (skipType == 3) {
                a(uPSNotificationMessageA);
                return;
            }
            if (skipType != 4) {
                com.vivo.push.util.u.a("NotifyOpenClientTask", "illegitmacy skip type error : " + uPSNotificationMessageA.getSkipType());
                return;
            }
            String skipContent2 = uPSNotificationMessageA.getSkipContent();
            try {
                uri = Intent.parseUri(skipContent2, 1);
                str = uri.getPackage();
            } catch (Exception e2) {
                com.vivo.push.util.u.a("NotifyOpenClientTask", "open activity error : ".concat(String.valueOf(skipContent2)), e2);
            }
            if (!TextUtils.isEmpty(str) && !this.f12207a.getPackageName().equals(str)) {
                com.vivo.push.util.u.a("NotifyOpenClientTask", "open activity error : local pkgName is " + this.f12207a.getPackageName() + "; but remote pkgName is " + uri.getPackage());
                return;
            }
            String packageName = uri.getComponent() == null ? null : uri.getComponent().getPackageName();
            if (!TextUtils.isEmpty(packageName) && !this.f12207a.getPackageName().equals(packageName)) {
                com.vivo.push.util.u.a("NotifyOpenClientTask", "open activity component error : local pkgName is " + this.f12207a.getPackageName() + "; but remote pkgName is " + uri.getPackage());
                return;
            }
            uri.setSelector(null);
            uri.setPackage(this.f12207a.getPackageName());
            uri.addFlags(335544320);
            b(uri, uPSNotificationMessageA.getParams());
            ActivityInfo activityInfoResolveActivityInfo = uri.resolveActivityInfo(this.f12207a.getPackageManager(), 65536);
            if (activityInfoResolveActivityInfo != null && !activityInfoResolveActivityInfo.exported) {
                com.vivo.push.util.u.a("NotifyOpenClientTask", "activity is not exported : " + activityInfoResolveActivityInfo.toString());
                return;
            } else {
                this.f12207a.startActivity(uri);
                a(uPSNotificationMessageA);
                return;
            }
        }
        com.vivo.push.util.u.a("NotifyOpenClientTask", "notify is " + uPSNotificationMessageA + " ; isMatch is " + zEquals);
    }

    private void a(UPSNotificationMessage uPSNotificationMessage) {
        com.vivo.push.t.c(new g(this, uPSNotificationMessage));
    }
}
