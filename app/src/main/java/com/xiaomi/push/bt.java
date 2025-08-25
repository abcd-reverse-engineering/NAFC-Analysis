package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.taobao.accs.common.Constants;
import com.xiaomi.push.bw;

/* loaded from: classes2.dex */
public class bt extends bw.e {

    /* renamed from: a, reason: collision with root package name */
    private String f12519a;

    public bt(String str, ContentValues contentValues, String str2) {
        super(str, contentValues);
        this.f12519a = "MessageInsertJob";
        this.f12519a = str2;
    }

    public static bt a(Context context, String str, gj gjVar) {
        byte[] bArrA = hp.a(gjVar);
        if (bArrA == null || bArrA.length <= 0) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_STATUS, (Integer) 0);
        contentValues.put("messageId", "");
        contentValues.put("messageItemId", gjVar.d());
        contentValues.put("messageItem", bArrA);
        contentValues.put("appId", bn.a(context).b());
        contentValues.put(Constants.KEY_PACKAGE_NAME, bn.a(context).m191a());
        contentValues.put("createTimeStamp", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("uploadTimestamp", (Integer) 0);
        return new bt(str, contentValues, "a job build to insert message to db");
    }
}
