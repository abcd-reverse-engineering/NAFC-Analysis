package com.huawei.secure.android.common.ssl.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class c extends AsyncTask<Context, Integer, Boolean> {

    /* renamed from: b, reason: collision with root package name */
    private static final long f7659b = 432000000;

    /* renamed from: c, reason: collision with root package name */
    private static final String f7660c = "lastCheckTime";

    /* renamed from: a, reason: collision with root package name */
    private static final String f7658a = c.class.getSimpleName();

    /* renamed from: d, reason: collision with root package name */
    private static volatile boolean f7661d = false;

    @SuppressLint({"NewApi"})
    public static void a() {
        if (b()) {
            e.c(f7658a, "checkUpgradeBks, execute check task");
            new c().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, ContextUtil.getInstance());
        }
    }

    private static boolean b() {
        if (f7661d) {
            return false;
        }
        Context contextUtil = ContextUtil.getInstance();
        if (contextUtil == null) {
            e.e(f7658a, "checkUpgradeBks, context is null");
            return false;
        }
        f7661d = true;
        long jA = g.a(f7660c, 0L, contextUtil);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - jA > f7659b) {
            g.b(f7660c, jCurrentTimeMillis, contextUtil);
            return true;
        }
        e.c(f7658a, "checkUpgradeBks, ignore");
        return false;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        e.a(f7658a, "onPreExecute");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean doInBackground(Context... contextArr) throws IOException {
        InputStream bksFromTss;
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            bksFromTss = BksUtil.getBksFromTss(contextArr[0]);
        } catch (Exception e2) {
            e.b(f7658a, "doInBackground: exception : " + e2.getMessage());
            bksFromTss = null;
        }
        e.a(f7658a, "doInBackground: get bks from hms tss cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
        if (bksFromTss != null) {
            d.a(bksFromTss);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Boolean bool) {
        if (bool.booleanValue()) {
            e.c(f7658a, "onPostExecute: upate done");
        } else {
            e.b(f7658a, "onPostExecute: upate failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onProgressUpdate(Integer... numArr) {
        e.c(f7658a, "onProgressUpdate");
    }
}
