package com.xiaomi.push.providers;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.pro.d;
import com.xiaomi.push.fz;

/* loaded from: classes2.dex */
public class TrafficProvider extends ContentProvider {

    /* renamed from: a, reason: collision with other field name */
    private SQLiteOpenHelper f917a;

    /* renamed from: a, reason: collision with other field name */
    public static final Uri f916a = Uri.parse("content://com.xiaomi.push.providers.TrafficProvider/traffic");

    /* renamed from: a, reason: collision with root package name */
    private static final UriMatcher f13263a = new UriMatcher(-1);

    static {
        f13263a.addURI("com.xiaomi.push.providers.TrafficProvider", d.F, 1);
        f13263a.addURI("com.xiaomi.push.providers.TrafficProvider", "update_imsi", 2);
    }

    @Override // android.content.ContentProvider
    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        if (f13263a.match(uri) == 1) {
            return "vnd.android.cursor.dir/vnd.xiaomi.push.traffic";
        }
        throw new IllegalArgumentException("Unknown URI " + uri);
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.f917a = new a(getContext());
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Cursor cursorQuery;
        synchronized (a.f918a) {
            if (f13263a.match(uri) != 1) {
                throw new IllegalArgumentException("Unknown URI " + uri);
            }
            cursorQuery = this.f917a.getReadableDatabase().query(d.F, strArr, str, strArr2, null, null, str2);
        }
        return cursorQuery;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (f13263a.match(uri) != 2 || contentValues == null || !contentValues.containsKey(Constants.KEY_IMSI)) {
            return 0;
        }
        fz.m448a(contentValues.getAsString(Constants.KEY_IMSI));
        return 0;
    }
}
