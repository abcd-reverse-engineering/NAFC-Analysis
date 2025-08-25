package anet.channel.e;

import android.content.SharedPreferences;
import anet.channel.entity.ConnType;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.IStrategyListener;
import anet.channel.strategy.l;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class c implements IStrategyListener {
    c() {
    }

    @Override // anet.channel.strategy.IStrategyListener
    public void onStrategyUpdated(l.d dVar) {
        String str;
        if (dVar == null || dVar.f2012b == null) {
            return;
        }
        int i2 = 0;
        loop0: while (true) {
            l.b[] bVarArr = dVar.f2012b;
            if (i2 >= bVarArr.length) {
                return;
            }
            str = bVarArr[i2].f1997a;
            l.a[] aVarArr = bVarArr[i2].f2004h;
            if (aVarArr != null && aVarArr.length > 0) {
                for (l.a aVar : aVarArr) {
                    String str2 = aVar.f1990b;
                    if (ConnType.HTTP3.equals(str2) || ConnType.HTTP3_PLAIN.equals(str2)) {
                        break loop0;
                    }
                }
            }
            i2++;
        }
        if (!str.equals(a.f1744b)) {
            String unused = a.f1744b = str;
            SharedPreferences.Editor editorEdit = a.f1748f.edit();
            editorEdit.putString("http3_detector_host", a.f1744b);
            editorEdit.apply();
        }
        a.a(NetworkStatusHelper.getStatus());
    }
}
