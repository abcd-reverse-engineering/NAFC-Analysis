package com.vivo.push.f;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;

/* compiled from: OnSetTagsReceiveTask.java */
/* loaded from: classes2.dex */
final class ab extends aa {
    ab(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    protected final void a(com.vivo.push.v vVar) throws JSONException {
        com.vivo.push.b.t tVar = (com.vivo.push.b.t) vVar;
        ArrayList<String> arrayListD = tVar.d();
        List<String> listE = tVar.e();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        int i2 = tVar.i();
        com.vivo.push.util.u.c("OnSetTagsTask", "doTask,删除成功的标签 = " + arrayListD + " 删除失败的= " + listE + " 错误码= " + i2);
        String strH = tVar.h();
        if (arrayListD != null) {
            for (String str : arrayListD) {
                if (str.startsWith("ali/")) {
                    arrayList2.add(str.replace("ali/", ""));
                } else if (str.startsWith("tag/")) {
                    arrayList.add(str.replace("tag/", ""));
                }
            }
        }
        if (listE != null) {
            for (String str2 : listE) {
                if (str2.startsWith("ali/")) {
                    arrayList4.add(str2.replace("ali/", ""));
                } else if (str2.startsWith("tag/")) {
                    arrayList3.add(str2.replace("tag/", ""));
                }
            }
        }
        if (arrayList.size() > 0 || arrayList3.size() > 0) {
            com.vivo.push.util.u.c("OnSetTagsTask", "doTask1,订阅成功的标签 = " + arrayList + " 订阅失败的标签= " + arrayList3 + " 错误码= " + i2);
            if (arrayList.size() > 0) {
                com.vivo.push.m.a();
                com.vivo.push.m.a(arrayList);
            }
            com.vivo.push.m.a().a(tVar.h(), i2);
            com.vivo.push.t.b(new ac(this, i2, arrayList, arrayList3, strH));
        }
        if (arrayList2.size() > 0 || arrayList4.size() > 0) {
            com.vivo.push.util.u.c("OnSetTagsTask", "doTask1,订阅成功的别名 = " + arrayList + " 订阅失败的别名= " + arrayList3 + " 错误码= " + i2);
            if (arrayList2.size() > 0) {
                com.vivo.push.m.a().a((String) arrayList2.get(0));
            }
            com.vivo.push.m.a().a(tVar.h(), i2);
            com.vivo.push.t.b(new ad(this, i2, arrayList2, arrayList4, strH));
        }
    }
}
