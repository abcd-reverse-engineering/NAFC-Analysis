package a.a.n;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import anet.channel.util.ALog;
import anet.channel.util.HttpHelper;
import anet.channel.util.StringUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class a {

    /* renamed from: e, reason: collision with root package name */
    public static final String f1146e = "anet.DownloadManager";

    /* renamed from: f, reason: collision with root package name */
    public static final int f1147f = -100;

    /* renamed from: g, reason: collision with root package name */
    public static final int f1148g = -101;

    /* renamed from: h, reason: collision with root package name */
    public static final int f1149h = -102;

    /* renamed from: i, reason: collision with root package name */
    public static final int f1150i = -103;

    /* renamed from: j, reason: collision with root package name */
    public static final int f1151j = -104;

    /* renamed from: k, reason: collision with root package name */
    public static final int f1152k = -105;

    /* renamed from: l, reason: collision with root package name */
    public static final int f1153l = -106;

    /* renamed from: a, reason: collision with root package name */
    SparseArray<c> f1154a;

    /* renamed from: b, reason: collision with root package name */
    AtomicInteger f1155b;

    /* renamed from: c, reason: collision with root package name */
    ThreadPoolExecutor f1156c;

    /* renamed from: d, reason: collision with root package name */
    Context f1157d;

    /* compiled from: Taobao */
    /* renamed from: a.a.n.a$a, reason: collision with other inner class name */
    public interface InterfaceC0003a {
        void a(int i2, int i3, String str);

        void a(int i2, long j2, long j3);

        void a(int i2, String str);
    }

    /* compiled from: Taobao */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        static a f1158a = new a();

        private b() {
        }
    }

    public static a b() {
        return b.f1158a;
    }

    /* compiled from: Taobao */
    class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final int f1159a;

        /* renamed from: b, reason: collision with root package name */
        final URL f1160b;

        /* renamed from: c, reason: collision with root package name */
        private final String f1161c;

        /* renamed from: d, reason: collision with root package name */
        private final CopyOnWriteArrayList<InterfaceC0003a> f1162d;

        /* renamed from: e, reason: collision with root package name */
        private final AtomicBoolean f1163e = new AtomicBoolean(false);

        /* renamed from: f, reason: collision with root package name */
        private final AtomicBoolean f1164f = new AtomicBoolean(false);

        /* renamed from: g, reason: collision with root package name */
        private volatile anetwork.channel.aidl.a f1165g = null;

        /* renamed from: h, reason: collision with root package name */
        private boolean f1166h;

        c(URL url, String str, String str2, InterfaceC0003a interfaceC0003a) {
            this.f1166h = true;
            this.f1159a = a.this.f1155b.getAndIncrement();
            this.f1160b = url;
            str2 = TextUtils.isEmpty(str2) ? a(url) : str2;
            if (TextUtils.isEmpty(str)) {
                this.f1161c = a.this.b(str2);
            } else {
                if (str.endsWith("/")) {
                    this.f1161c = str + str2;
                } else {
                    this.f1161c = str + '/' + str2;
                }
                if (str.startsWith("/data/user") || str.startsWith("/data/data")) {
                    this.f1166h = false;
                }
            }
            this.f1162d = new CopyOnWriteArrayList<>();
            this.f1162d.add(interfaceC0003a);
        }

        public boolean a(InterfaceC0003a interfaceC0003a) {
            if (this.f1164f.get()) {
                return false;
            }
            this.f1162d.add(interfaceC0003a);
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:208:0x0272 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:212:0x0260 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:220:0x0258 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:224:0x024a A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:234:0x0251 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:244:0x0288 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:246:0x0279 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:258:0x0280 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 662
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: a.a.n.a.c.run():void");
        }

        public void a() {
            this.f1163e.set(true);
            a(-105, "download canceled.");
            if (this.f1165g != null) {
                try {
                    this.f1165g.cancel();
                } catch (RemoteException unused) {
                }
            }
        }

        private void a(String str) {
            if (this.f1164f.compareAndSet(false, true)) {
                Iterator<InterfaceC0003a> it = this.f1162d.iterator();
                while (it.hasNext()) {
                    it.next().a(this.f1159a, str);
                }
            }
        }

        private void a(int i2, String str) {
            if (this.f1164f.compareAndSet(false, true)) {
                Iterator<InterfaceC0003a> it = this.f1162d.iterator();
                while (it.hasNext()) {
                    it.next().a(this.f1159a, i2, str);
                }
            }
        }

        private void a(long j2, long j3) {
            if (this.f1164f.get()) {
                return;
            }
            Iterator<InterfaceC0003a> it = this.f1162d.iterator();
            while (it.hasNext()) {
                it.next().a(this.f1159a, j2, j3);
            }
        }

        private long a(int i2, Map<String, List<String>> map, long j2) {
            int iLastIndexOf;
            try {
                if (i2 == 200) {
                    return Long.parseLong(HttpHelper.getSingleHeaderFieldByKey(map, "Content-Length"));
                }
                if (i2 != 206) {
                    return 0L;
                }
                String singleHeaderFieldByKey = HttpHelper.getSingleHeaderFieldByKey(map, "Content-Range");
                long j3 = (singleHeaderFieldByKey == null || (iLastIndexOf = singleHeaderFieldByKey.lastIndexOf(47)) == -1) ? 0L : Long.parseLong(singleHeaderFieldByKey.substring(iLastIndexOf + 1));
                if (j3 == 0) {
                    try {
                        return Long.parseLong(HttpHelper.getSingleHeaderFieldByKey(map, "Content-Length")) + j2;
                    } catch (Exception unused) {
                    }
                }
                return j3;
            } catch (Exception unused2) {
                return 0L;
            }
        }

        private void a(List<a.a.a> list) {
            if (list != null) {
                ListIterator<a.a.a> listIterator = list.listIterator();
                while (listIterator.hasNext()) {
                    if (HttpHeaders.RANGE.equalsIgnoreCase(listIterator.next().getName())) {
                        listIterator.remove();
                        return;
                    }
                }
            }
        }

        private String a(URL url) {
            String path = url.getPath();
            int iLastIndexOf = path.lastIndexOf(47);
            String strSubstring = iLastIndexOf != -1 ? path.substring(iLastIndexOf + 1, path.length()) : null;
            if (!TextUtils.isEmpty(strSubstring)) {
                return strSubstring;
            }
            String strMd5ToHex = StringUtils.md5ToHex(url.toString());
            return strMd5ToHex == null ? url.getFile() : strMd5ToHex;
        }
    }

    private a() {
        this.f1154a = new SparseArray<>(6);
        this.f1155b = new AtomicInteger(0);
        this.f1156c = new ThreadPoolExecutor(2, 2, 30L, TimeUnit.SECONDS, new LinkedBlockingDeque());
        this.f1157d = null;
        this.f1157d = a.a.o.c.getContext();
        this.f1156c.allowCoreThreadTimeOut(true);
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(String str) {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.f1157d.getExternalFilesDir(null));
        sb.append("/");
        sb.append("downloads");
        sb.append("/");
        sb.append(str);
        return sb.toString();
    }

    public int a(String str, String str2, InterfaceC0003a interfaceC0003a) {
        return a(str, null, str2, interfaceC0003a);
    }

    public int a(String str, String str2, String str3, InterfaceC0003a interfaceC0003a) {
        int i2 = 0;
        if (ALog.isPrintLog(2)) {
            ALog.i(f1146e, "enqueue", null, "folder", str2, "filename", str3, "url", str);
        }
        if (this.f1157d == null) {
            ALog.e(f1146e, "network sdk not initialized.", null, new Object[0]);
            return -1;
        }
        try {
            URL url = new URL(str);
            if (!TextUtils.isEmpty(str2) && !a(str2)) {
                ALog.e(f1146e, "file folder invalid.", null, new Object[0]);
                if (interfaceC0003a != null) {
                    interfaceC0003a.a(-1, -101, "file folder path invalid");
                }
                return -1;
            }
            synchronized (this.f1154a) {
                int size = this.f1154a.size();
                while (true) {
                    if (i2 >= size) {
                        break;
                    }
                    c cVarValueAt = this.f1154a.valueAt(i2);
                    if (!url.equals(cVarValueAt.f1160b)) {
                        i2++;
                    } else if (cVarValueAt.a(interfaceC0003a)) {
                        return cVarValueAt.f1159a;
                    }
                }
                c cVar = new c(url, str2, str3, interfaceC0003a);
                this.f1154a.put(cVar.f1159a, cVar);
                this.f1156c.submit(cVar);
                return cVar.f1159a;
            }
        } catch (MalformedURLException e2) {
            ALog.e(f1146e, "url invalid.", null, e2, new Object[0]);
            if (interfaceC0003a != null) {
                interfaceC0003a.a(-1, -100, "url invalid");
            }
            return -1;
        }
    }

    public void a(int i2) {
        synchronized (this.f1154a) {
            c cVar = this.f1154a.get(i2);
            if (cVar != null) {
                if (ALog.isPrintLog(2)) {
                    ALog.i(f1146e, "try cancel task" + i2 + " url=" + cVar.f1160b.toString(), null, new Object[0]);
                }
                this.f1154a.remove(i2);
                cVar.a();
            }
        }
    }

    private void a() {
        Context context = this.f1157d;
        if (context != null) {
            File file = new File(context.getExternalFilesDir(null), "downloads");
            if (file.exists()) {
                return;
            }
            file.mkdir();
        }
    }

    private boolean a(String str) {
        if (this.f1157d != null) {
            try {
                File file = new File(str);
                if (file.exists()) {
                    return true;
                }
                return file.mkdir();
            } catch (Exception unused) {
                ALog.e(f1146e, "create folder failed", null, "folder", str);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File a(String str, boolean z) {
        String strMd5ToHex = StringUtils.md5ToHex(str);
        if (strMd5ToHex != null) {
            str = strMd5ToHex;
        }
        if (z) {
            return new File(this.f1157d.getExternalCacheDir(), str);
        }
        return new File(this.f1157d.getCacheDir(), str);
    }
}
