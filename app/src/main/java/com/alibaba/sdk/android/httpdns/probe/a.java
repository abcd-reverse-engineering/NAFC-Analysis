package com.alibaba.sdk.android.httpdns.probe;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private f f4084a;

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<String, Long> f4085b = new ConcurrentHashMap<>();
    private String host;
    private String[] ips;

    /* renamed from: j, reason: collision with root package name */
    private long f4086j;
    private int port;

    public a(long j2, String str, String[] strArr, int i2, f fVar) {
        this.f4084a = null;
        this.f4086j = j2;
        this.host = str;
        this.ips = strArr;
        this.port = i2;
        this.f4084a = fVar;
    }

    private c a(String[] strArr) {
        String[] strArr2 = this.ips;
        if (strArr2 == null || strArr2.length == 0 || strArr == null || strArr.length == 0) {
            return null;
        }
        String str = strArr2[0];
        String str2 = strArr[0];
        return new c(this.host, strArr, str, str2, this.f4085b.containsKey(str) ? this.f4085b.get(str).longValue() : 2147483647L, this.f4085b.containsKey(str2) ? this.f4085b.get(str2).longValue() : 2147483647L);
    }

    private String[] a(ConcurrentHashMap<String, Long> concurrentHashMap) {
        if (concurrentHashMap == null) {
            return null;
        }
        String[] strArr = new String[concurrentHashMap.size()];
        Iterator<String> it = concurrentHashMap.keySet().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            strArr[i2] = new String(it.next());
            i2++;
        }
        for (int i3 = 0; i3 < strArr.length - 1; i3++) {
            int i4 = 0;
            while (i4 < (strArr.length - i3) - 1) {
                int i5 = i4 + 1;
                if (concurrentHashMap.get(strArr[i4]).longValue() > concurrentHashMap.get(strArr[i5]).longValue()) {
                    String str = strArr[i4];
                    strArr[i4] = strArr[i5];
                    strArr[i5] = str;
                }
                i4 = i5;
            }
        }
        return strArr;
    }

    @Override // java.lang.Runnable
    public void run() throws InterruptedException {
        String[] strArrA;
        String[] strArr = this.ips;
        if (strArr == null || strArr.length == 0) {
            return;
        }
        CountDownLatch countDownLatch = new CountDownLatch(strArr.length);
        for (int i2 = 0; i2 < this.ips.length; i2++) {
            com.alibaba.sdk.android.httpdns.c.a().execute(new g(this.ips[i2], this.port, countDownLatch, this.f4085b));
        }
        try {
            countDownLatch.await(com.heytap.mcssdk.constant.a.q, TimeUnit.MILLISECONDS);
            if (this.f4084a == null || (strArrA = a(this.f4085b)) == null || strArrA.length == 0) {
                return;
            }
            this.f4084a.a(this.f4086j, a(strArrA));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
