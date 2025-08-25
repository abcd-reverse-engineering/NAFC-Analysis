package com.umeng.message.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.umeng.message.common.UPLog;

/* loaded from: classes2.dex */
public final class ao {

    /* renamed from: b, reason: collision with root package name */
    private static ao f11291b;

    /* renamed from: a, reason: collision with root package name */
    public final Context f11292a;

    private ao(Context context) {
        this.f11292a = context.getApplicationContext();
    }

    public static ao a(Context context) {
        if (f11291b == null) {
            f11291b = new ao(context);
        }
        return f11291b;
    }

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f11293a;

        /* renamed from: b, reason: collision with root package name */
        public long f11294b;

        /* renamed from: c, reason: collision with root package name */
        public int f11295c;

        public a(String str, int i2, long j2) {
            this.f11293a = str;
            this.f11295c = i2;
            this.f11294b = j2;
        }

        public final ContentValues a() {
            ContentValues contentValues = new ContentValues();
            contentValues.put("MsgId", this.f11293a);
            contentValues.put("Time", Long.valueOf(this.f11294b));
            contentValues.put("ActionType", Integer.valueOf(this.f11295c));
            return contentValues;
        }

        public a(Cursor cursor) {
            this.f11293a = cursor.getString(cursor.getColumnIndex("MsgId"));
            this.f11294b = cursor.getLong(cursor.getColumnIndex("Time"));
            this.f11295c = cursor.getInt(cursor.getColumnIndex("ActionType"));
        }
    }

    public final void a(String str, int i2, long j2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.f11292a.getContentResolver().insert(h.d(this.f11292a), new a(str, i2, j2).a());
        } catch (Exception e2) {
            UPLog.e("MsgLog", e2);
        }
    }
}
