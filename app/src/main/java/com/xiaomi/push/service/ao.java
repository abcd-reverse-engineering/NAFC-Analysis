package com.xiaomi.push.service;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.C0343r;
import com.xiaomi.push.Cdo;
import com.xiaomi.push.cc;
import com.xiaomi.push.cf;
import com.xiaomi.push.cg;
import com.xiaomi.push.dp;
import com.xiaomi.push.ei;
import com.xiaomi.push.eo;
import com.xiaomi.push.ep;
import com.xiaomi.push.fa;
import com.xiaomi.push.fx;
import com.xiaomi.push.service.ax;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;

/* loaded from: classes2.dex */
public class ao extends ax.a implements cg.a {

    /* renamed from: a, reason: collision with root package name */
    private long f13377a;

    /* renamed from: a, reason: collision with other field name */
    private XMPushService f1007a;

    static class a implements cg.b {
        a() {
        }

        @Override // com.xiaomi.push.cg.b
        public String a(String str) throws IOException {
            Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
            builderBuildUpon.appendQueryParameter("sdkver", String.valueOf(48));
            builderBuildUpon.appendQueryParameter("osver", String.valueOf(Build.VERSION.SDK_INT));
            builderBuildUpon.appendQueryParameter("os", fx.a(Build.VERSION.INCREMENTAL));
            builderBuildUpon.appendQueryParameter("mi", String.valueOf(C0343r.a()));
            String string = builderBuildUpon.toString();
            com.xiaomi.channel.commonutils.logger.b.c("fetch bucket from : " + string);
            URL url = new URL(string);
            int port = url.getPort() == -1 ? 80 : url.getPort();
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                String strA = com.xiaomi.push.au.a(C0343r.m636a(), url);
                ep.a(url.getHost() + Constants.COLON_SEPARATOR + port, (int) (System.currentTimeMillis() - jCurrentTimeMillis), null);
                return strA;
            } catch (IOException e2) {
                ep.a(url.getHost() + Constants.COLON_SEPARATOR + port, -1, e2);
                throw e2;
            }
        }
    }

    static class b extends cg {
        protected b(Context context, cf cfVar, cg.b bVar, String str) {
            super(context, cfVar, bVar, str);
        }

        @Override // com.xiaomi.push.cg
        protected String a(ArrayList<String> arrayList, String str, String str2, boolean z) throws IOException {
            try {
                if (eo.m382a().m387a()) {
                    str2 = ax.m705a();
                }
                return super.a(arrayList, str, str2, z);
            } catch (IOException e2) {
                ep.a(0, ei.GSLB_ERR.a(), 1, null, com.xiaomi.push.au.b(cg.f12551a) ? 1 : 0);
                throw e2;
            }
        }
    }

    ao(XMPushService xMPushService) {
        this.f1007a = xMPushService;
    }

    public static void a(XMPushService xMPushService) {
        ao aoVar = new ao(xMPushService);
        ax.a().a(aoVar);
        synchronized (cg.class) {
            cg.a(aoVar);
            cg.a(xMPushService, null, new a(), "0", "push", "2.2");
        }
    }

    @Override // com.xiaomi.push.service.ax.a
    public void a(Cdo.a aVar) {
    }

    @Override // com.xiaomi.push.service.ax.a
    public void a(dp.b bVar) throws JSONException {
        cc ccVarB;
        if (bVar.m298b() && bVar.m297a() && System.currentTimeMillis() - this.f13377a > com.heytap.mcssdk.constant.a.f5801e) {
            com.xiaomi.channel.commonutils.logger.b.m50a("fetch bucket :" + bVar.m297a());
            this.f13377a = System.currentTimeMillis();
            cg cgVarA = cg.a();
            cgVarA.m231a();
            cgVarA.m234b();
            fa faVarM660a = this.f1007a.m660a();
            if (faVarM660a == null || (ccVarB = cgVarA.b(faVarM660a.m413a().c())) == null) {
                return;
            }
            ArrayList<String> arrayListM218a = ccVarB.m218a();
            boolean z = true;
            Iterator<String> it = arrayListM218a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().equals(faVarM660a.mo414a())) {
                    z = false;
                    break;
                }
            }
            if (!z || arrayListM218a.isEmpty()) {
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m50a("bucket changed, force reconnect");
            this.f1007a.a(0, (Exception) null);
            this.f1007a.a(false);
        }
    }

    @Override // com.xiaomi.push.cg.a
    public cg a(Context context, cf cfVar, cg.b bVar, String str) {
        return new b(context, cfVar, bVar, str);
    }
}
