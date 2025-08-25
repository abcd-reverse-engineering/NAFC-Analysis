package com.umeng.message.proguard;

import android.app.Application;
import android.content.Intent;
import android.text.TextUtils;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.PushAgent;
import com.umeng.message.api.UPushMessageHandler;
import com.umeng.message.common.UPLog;
import com.umeng.message.entity.UMessage;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class j {

    /* renamed from: b, reason: collision with root package name */
    private static final j f11365b = new j();

    /* renamed from: a, reason: collision with root package name */
    private final Vector<String> f11366a = new Vector<>();

    static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final UMessage f11367a;

        /* renamed from: b, reason: collision with root package name */
        private final ArrayList<String> f11368b = new ArrayList<>();

        /* renamed from: c, reason: collision with root package name */
        private final int f11369c;

        public a(UMessage uMessage) {
            this.f11367a = uMessage;
            if (uMessage.isLargeIconFromInternet()) {
                this.f11368b.add(uMessage.getLargeIconUrl());
            }
            if (uMessage.isSoundFromInternet()) {
                this.f11368b.add(uMessage.getSoundUri());
            }
            if (!TextUtils.isEmpty(uMessage.getBarImageUrl())) {
                this.f11368b.add(uMessage.getBarImageUrl());
            }
            if (uMessage.hasBackgroundImage()) {
                this.f11368b.add(uMessage.getBackgroundImageUrl());
            }
            if (!TextUtils.isEmpty(uMessage.getBigImage())) {
                this.f11368b.add(uMessage.getBigImage());
            }
            this.f11369c = 3;
        }

        private static boolean a(String str) throws Throwable {
            FileOutputStream fileOutputStream;
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            InputStream inputStream = null;
            try {
                Application applicationA = x.a();
                File file = new File(f.g(applicationA), UMUtils.MD5(str));
                File file2 = new File(f.g(applicationA), UMUtils.MD5(str) + ".tmp");
                if (file.exists()) {
                    f.a((Closeable) null);
                    f.a((Closeable) null);
                    return true;
                }
                if (file2.exists()) {
                    file2.delete();
                }
                InputStream inputStreamOpenStream = new URL(new URI(str).toASCIIString()).openStream();
                try {
                    fileOutputStream = new FileOutputStream(file2);
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream = null;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = null;
                }
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int i2 = inputStreamOpenStream.read(bArr);
                        if (i2 <= 0) {
                            file2.renameTo(file);
                            f.a(inputStreamOpenStream);
                            f.a(fileOutputStream);
                            return true;
                        }
                        fileOutputStream.write(bArr, 0, i2);
                    }
                } catch (Exception e3) {
                    e = e3;
                    inputStream = inputStreamOpenStream;
                    e = e;
                    try {
                        UPLog.e("DownloadResource", e);
                        f.a(inputStream);
                        f.a(fileOutputStream);
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        f.a(inputStream);
                        f.a(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = inputStreamOpenStream;
                    th = th;
                    f.a(inputStream);
                    f.a(fileOutputStream);
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                fileOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                j.a(f.g(x.a()));
                int i2 = 0;
                boolean z = true;
                do {
                    i2++;
                    Iterator<String> it = this.f11368b.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        boolean zA = a(next);
                        if (!zA) {
                            UPLog.d("DownloadResource", "download fail:", next);
                        }
                        z &= zA;
                    }
                    if (z) {
                        break;
                    }
                } while (i2 < this.f11369c);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            j.a().f11366a.remove(this.f11367a.getMsgId());
            Application applicationA = x.a();
            UPushMessageHandler messageHandler = PushAgent.getInstance(applicationA).getMessageHandler();
            if (messageHandler != null) {
                messageHandler.handleMessage(applicationA, this.f11367a);
            }
        }
    }

    public static j a() {
        return f11365b;
    }

    public final boolean a(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("body")) != null && stringExtra.length() != 0) {
            try {
                UMessage uMessage = new UMessage(new JSONObject(stringExtra));
                if (this.f11366a.contains(uMessage.getMsgId())) {
                    return true;
                }
                this.f11366a.add(uMessage.getMsgId());
                b.c(new a(uMessage));
                return true;
            } catch (Throwable th) {
                UPLog.e("DownloadResource", th);
            }
        }
        return false;
    }

    static /* synthetic */ void a(File file) {
        try {
            if (file.exists()) {
                long length = 0;
                if (file != null && file.exists()) {
                    if (!file.isDirectory()) {
                        length = file.length();
                    } else {
                        LinkedList linkedList = new LinkedList();
                        linkedList.push(file);
                        while (!linkedList.isEmpty()) {
                            File[] fileArrListFiles = ((File) linkedList.pop()).listFiles();
                            if (fileArrListFiles != null) {
                                for (File file2 : fileArrListFiles) {
                                    if (file2.isDirectory()) {
                                        linkedList.push(file2);
                                    } else {
                                        length += file2.length();
                                    }
                                }
                            }
                        }
                    }
                }
                if (length > 1048576) {
                    az.a(file.getPath(), new FileFilter() { // from class: com.umeng.message.proguard.j.1
                        @Override // java.io.FileFilter
                        public final boolean accept(File file3) {
                            return System.currentTimeMillis() - file3.lastModified() > 86400000;
                        }
                    });
                }
            }
        } catch (Throwable th) {
            UPLog.e("DownloadResource", th);
        }
    }
}
