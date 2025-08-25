package com.umeng.message.proguard;

import android.content.ContentValues;
import android.database.Cursor;

/* loaded from: classes2.dex */
public final class ae {

    /* renamed from: a, reason: collision with root package name */
    long f11226a;

    /* renamed from: b, reason: collision with root package name */
    String f11227b;

    /* renamed from: c, reason: collision with root package name */
    int f11228c;

    /* renamed from: d, reason: collision with root package name */
    public int f11229d;

    /* renamed from: e, reason: collision with root package name */
    public int f11230e;

    /* renamed from: f, reason: collision with root package name */
    public int f11231f;

    /* renamed from: g, reason: collision with root package name */
    public int f11232g;

    /* renamed from: h, reason: collision with root package name */
    public int f11233h;

    /* renamed from: i, reason: collision with root package name */
    public int f11234i;

    /* renamed from: j, reason: collision with root package name */
    public int f11235j;

    public ae(String str, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.f11226a = System.currentTimeMillis();
        this.f11227b = str;
        this.f11228c = i2;
        this.f11229d = i3;
        this.f11230e = i4;
        this.f11231f = i5;
        this.f11232g = i6;
        this.f11233h = i7;
        this.f11234i = i8;
        this.f11235j = i9;
    }

    public final ContentValues a() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("Time", Long.valueOf(this.f11226a));
        contentValues.put("MsgId", this.f11227b);
        contentValues.put("MsgType", Integer.valueOf(this.f11228c));
        contentValues.put("NumDisplay", Integer.valueOf(this.f11229d));
        contentValues.put("NumOpenFull", Integer.valueOf(this.f11230e));
        contentValues.put("NumOpenTop", Integer.valueOf(this.f11231f));
        contentValues.put("NumOpenBottom", Integer.valueOf(this.f11232g));
        contentValues.put("NumClose", Integer.valueOf(this.f11233h));
        contentValues.put("NumDuration", Integer.valueOf(this.f11234i));
        contentValues.put("NumCustom", Integer.valueOf(this.f11235j));
        return contentValues;
    }

    public ae(Cursor cursor) {
        this.f11227b = cursor.getString(cursor.getColumnIndex("MsgId"));
        this.f11228c = cursor.getInt(cursor.getColumnIndex("MsgType"));
        this.f11229d = cursor.getInt(cursor.getColumnIndex("NumDisplay"));
        this.f11230e = cursor.getInt(cursor.getColumnIndex("NumOpenFull"));
        this.f11231f = cursor.getInt(cursor.getColumnIndex("NumOpenTop"));
        this.f11232g = cursor.getInt(cursor.getColumnIndex("NumOpenBottom"));
        this.f11233h = cursor.getInt(cursor.getColumnIndex("NumClose"));
        this.f11234i = cursor.getInt(cursor.getColumnIndex("NumDuration"));
        this.f11235j = cursor.getInt(cursor.getColumnIndex("NumCustom"));
    }
}
