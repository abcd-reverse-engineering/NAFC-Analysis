package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.bugly.beta.download.DownloadTask;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    public static p f9423a = new p();

    public synchronized ContentValues a(String str) {
        ContentValues contentValues = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Cursor cursorA = ae.a().a("dl_1002", null, "_dUrl=?", new String[]{str}, null, true);
        if (cursorA != null && cursorA.moveToFirst()) {
            contentValues = new ContentValues();
            contentValues.put("_dUrl", cursorA.getString(cursorA.getColumnIndex("_dUrl")));
            contentValues.put("_sFile", cursorA.getString(cursorA.getColumnIndex("_sFile")));
            contentValues.put("_sLen", Long.valueOf(cursorA.getLong(cursorA.getColumnIndex("_sLen"))));
            contentValues.put("_tLen", Long.valueOf(cursorA.getLong(cursorA.getColumnIndex("_tLen"))));
            contentValues.put("_MD5", cursorA.getString(cursorA.getColumnIndex("_MD5")));
            contentValues.put("_DLTIME", Long.valueOf(cursorA.getLong(cursorA.getColumnIndex("_DLTIME"))));
        }
        if (cursorA != null) {
            cursorA.close();
        }
        return contentValues;
    }

    public synchronized int b(DownloadTask downloadTask) {
        return ae.a().a("dl_1002", "_dUrl = ?", new String[]{downloadTask.getDownloadUrl()}, (ad) null, true);
    }

    public synchronized boolean c(String str) {
        return ae.a().a("st_1002", "_id = ? and _tp = ? ", new String[]{"1002", str}, (ad) null, true) > 0;
    }

    public synchronized int b(String str) {
        return ae.a().a("dl_1002", "_sFile = ?", new String[]{str}, (ad) null, true);
    }

    public synchronized Map<String, byte[]> c() {
        Cursor cursorA;
        try {
            cursorA = ae.a().a("st_1002", null, "_id = 1002", null, null, true);
            if (cursorA == null) {
                return null;
            }
            try {
                HashMap map = new HashMap();
                while (cursorA.moveToNext()) {
                    map.put(cursorA.getString(cursorA.getColumnIndex(com.umeng.analytics.pro.bl.f10171e)), cursorA.getBlob(cursorA.getColumnIndex("_dt")));
                }
                if (cursorA != null) {
                    cursorA.close();
                }
                return map;
            } catch (Throwable th) {
                th = th;
                try {
                    if (!an.a(th)) {
                        th.printStackTrace();
                    }
                    if (cursorA != null) {
                        cursorA.close();
                    }
                    return null;
                } finally {
                    if (cursorA != null) {
                        cursorA.close();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursorA = null;
        }
    }

    public synchronized int b() {
        return ae.a().a("ge_1002", (String) null, (String[]) null, (ad) null, true);
    }

    public synchronized boolean a(DownloadTask downloadTask) {
        ContentValues contentValues;
        contentValues = new ContentValues();
        contentValues.put("_dUrl", downloadTask.getDownloadUrl());
        contentValues.put("_sFile", downloadTask.getSaveFile().getAbsolutePath());
        contentValues.put("_sLen", Long.valueOf(downloadTask.getSavedLength()));
        contentValues.put("_tLen", Long.valueOf(downloadTask.getTotalLength()));
        contentValues.put("_MD5", downloadTask.getMD5());
        contentValues.put("_DLTIME", Long.valueOf(downloadTask.getCostTime()));
        return ae.a().a("dl_1002", contentValues, (ad) null, true) >= 0;
    }

    public synchronized List<w> a() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Cursor cursorA = ae.a().a("ge_1002", null, null, null, null, true);
        while (cursorA != null && cursorA.moveToNext()) {
            w wVar = (w) ah.a(cursorA.getBlob(cursorA.getColumnIndex("_datas")), w.class);
            if (wVar != null) {
                arrayList.add(wVar);
            }
        }
        if (cursorA != null) {
            cursorA.close();
        }
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        return arrayList;
    }

    public synchronized boolean a(w wVar) {
        if (wVar == null) {
            return false;
        }
        byte[] bArrA = ah.a((m) wVar);
        if (bArrA != null && bArrA.length > 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("_time", Long.valueOf(wVar.f9465b));
            contentValues.put("_datas", bArrA);
            return ae.a().a("ge_1002", contentValues, (ad) null, true) >= 0;
        }
        return false;
    }

    public synchronized int a(long j2) {
        return ae.a().a("ge_1002", "_time = ?", new String[]{String.valueOf(j2)}, (ad) null, true);
    }

    public synchronized boolean a(int i2, String str, byte[] bArr) {
        ContentValues contentValues;
        contentValues = new ContentValues();
        contentValues.put(com.umeng.analytics.pro.bl.f10170d, Integer.valueOf(i2));
        contentValues.put("_tm", Long.valueOf(System.currentTimeMillis()));
        contentValues.put(com.umeng.analytics.pro.bl.f10171e, str);
        contentValues.put("_dt", bArr);
        return ae.a().a("st_1002", contentValues, (ad) null, true) >= 0;
    }
}
