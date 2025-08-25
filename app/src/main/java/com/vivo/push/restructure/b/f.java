package com.vivo.push.restructure.b;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.vivo.push.util.k;
import com.vivo.push.util.u;
import java.util.ArrayList;
import java.util.List;

/* compiled from: PushSystemRelyImpl.java */
/* loaded from: classes2.dex */
public final class f implements b {
    @Override // com.vivo.push.util.o
    public final List<String> a(Context context) {
        k.a("findAllCoreClientPush");
        List<ResolveInfo> listQueryIntentServices = null;
        if (!com.vivo.push.restructure.a.a().e().l().isAgreePrivacyStatement()) {
            u.d("PushSystemRelyImpl", " findAllCorePush  isAgreePrivacyStatement() is false ");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            listQueryIntentServices = context.getPackageManager().queryIntentServices(new Intent("com.vivo.pushservice.action.PUSH_SERVICE"), 576);
        } catch (Exception unused) {
        }
        if (listQueryIntentServices != null && listQueryIntentServices.size() > 0) {
            int size = listQueryIntentServices.size();
            for (int i2 = 0; i2 < size; i2++) {
                ResolveInfo resolveInfo = listQueryIntentServices.get(i2);
                if (resolveInfo != null) {
                    String str = resolveInfo.serviceInfo.packageName;
                    if (!TextUtils.isEmpty(str)) {
                        arrayList.add(str);
                    }
                }
            }
        }
        if (arrayList.size() <= 0) {
            u.d("PushSystemRelyImpl", "get all push packages is null");
        }
        return arrayList;
    }
}
