package com.tencent.bugly.beta.global;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.p;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static f f8804a = new f();

    /* renamed from: d, reason: collision with root package name */
    private List<Runnable> f8807d = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    final Map<String, DownloadTask> f8805b = Collections.synchronizedMap(new HashMap());

    /* renamed from: c, reason: collision with root package name */
    Handler f8806c = new Handler(Looper.getMainLooper());

    public synchronized void a(Runnable runnable, int i2) {
        if (this.f8805b.size() == 0) {
            runnable.run();
        } else {
            d dVar = new d(6, false, runnable);
            this.f8806c.postDelayed(dVar, i2);
            a(dVar);
        }
    }

    public void b() {
        synchronized (this) {
            Iterator<Runnable> it = this.f8807d.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
            Iterator<DownloadTask> it2 = this.f8805b.values().iterator();
            while (it2.hasNext()) {
                it2.next().delete(false);
            }
            this.f8807d.clear();
            this.f8805b.clear();
        }
    }

    public synchronized void a(Runnable runnable) {
        if (this.f8805b.size() == 0) {
            runnable.run();
        } else {
            this.f8807d.add(runnable);
        }
    }

    public void a(com.tencent.bugly.beta.download.b bVar, Map<String, String> map) {
        DownloadTask downloadTaskA;
        if (bVar == null) {
            return;
        }
        if (map != null && !map.isEmpty()) {
            Iterator<DownloadTask> it = this.f8805b.values().iterator();
            while (it.hasNext()) {
                it.next().delete(true);
            }
            this.f8805b.clear();
            com.tencent.bugly.beta.download.a aVar = new com.tencent.bugly.beta.download.a(1, this, this.f8805b);
            for (String str : ResBean.f8781b) {
                if (!map.containsKey(str)) {
                    this.f8805b.clear();
                    ResBean.f8780a = new ResBean();
                    a.a("rb.bch", ResBean.f8780a);
                    return;
                }
                String str2 = map.get(str);
                if (str.startsWith("IMG_") && !TextUtils.isEmpty(str2)) {
                    ResBean.f8780a.a(str, "");
                    Iterator<DownloadTask> it2 = this.f8805b.values().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            downloadTaskA = it2.next();
                            if (downloadTaskA.getDownloadUrl().equals(str2)) {
                                break;
                            }
                        } else {
                            downloadTaskA = null;
                            break;
                        }
                    }
                    if (downloadTaskA == null) {
                        downloadTaskA = bVar.a(str2, e.G.t.getAbsolutePath(), null, null);
                    }
                    if (downloadTaskA != null) {
                        downloadTaskA.addListener(aVar);
                        downloadTaskA.setNeededNotify(false);
                        this.f8805b.put(str, downloadTaskA);
                    }
                } else {
                    ResBean.f8780a.a(str, str2);
                }
            }
            a.a("rb.bch", ResBean.f8780a);
            if (this.f8805b.isEmpty()) {
                return;
            }
            Iterator<DownloadTask> it3 = this.f8805b.values().iterator();
            while (it3.hasNext()) {
                it3.next().download();
            }
            return;
        }
        this.f8805b.clear();
        ResBean.f8780a = new ResBean();
        a.a("rb.bch", ResBean.f8780a);
    }

    public void a() {
        ArrayList arrayList = new ArrayList();
        for (String str : ResBean.f8781b) {
            String strA = ResBean.f8780a.a(str);
            if (str.startsWith("IMG_") && !TextUtils.isEmpty(strA)) {
                arrayList.add(strA);
            }
        }
        File[] fileArrListFiles = e.G.t.listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length <= 0) {
            return;
        }
        for (File file : fileArrListFiles) {
            Iterator it = arrayList.iterator();
            boolean z = true;
            while (it.hasNext()) {
                if (file.getAbsolutePath().equals((String) it.next())) {
                    z = false;
                }
            }
            if (z) {
                p.f9423a.b(file.getAbsolutePath());
                if (!file.delete()) {
                    an.e("cannot deleteCache file:%s", file.getAbsolutePath());
                }
            }
        }
    }
}
