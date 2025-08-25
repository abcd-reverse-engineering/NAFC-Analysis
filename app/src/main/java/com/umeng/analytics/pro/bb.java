package com.umeng.analytics.pro;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/* compiled from: NubiaDeviceIdSupplier.java */
/* loaded from: classes2.dex */
class bb implements au {

    /* renamed from: a, reason: collision with root package name */
    private static final String f10110a = "content://cn.nubia.provider.deviceid.dataid/oaid";

    bb() {
    }

    @Override // com.umeng.analytics.pro.au
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        Cursor cursorQuery = context.getContentResolver().query(Uri.parse(f10110a), null, null, null, null);
        if (cursorQuery != null) {
            string = cursorQuery.moveToNext() ? cursorQuery.getString(cursorQuery.getColumnIndex("device_ids_grndid")) : null;
            cursorQuery.close();
        }
        return string;
    }
}
