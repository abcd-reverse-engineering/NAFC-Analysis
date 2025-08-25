package com.tencent.open.utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import com.tencent.open.log.SLog;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: c, reason: collision with root package name */
    private static String f9906c;

    /* renamed from: a, reason: collision with root package name */
    private String f9907a;

    /* renamed from: b, reason: collision with root package name */
    private d f9908b;

    /* renamed from: d, reason: collision with root package name */
    private long f9909d;

    /* renamed from: e, reason: collision with root package name */
    private Handler f9910e;

    /* renamed from: f, reason: collision with root package name */
    private WeakReference<Activity> f9911f;

    /* renamed from: g, reason: collision with root package name */
    private Runnable f9912g = new Runnable() { // from class: com.tencent.open.utils.c.2
        @Override // java.lang.Runnable
        public void run() throws Throwable {
            boolean zA;
            SLog.v("AsynLoadImg", "saveFileRunnable:");
            String str = "share_qq_" + m.g(c.this.f9907a) + ".jpg";
            String str2 = c.f9906c + str;
            File file = new File(str2);
            Message messageObtainMessage = c.this.f9910e.obtainMessage();
            if (file.exists()) {
                messageObtainMessage.arg1 = 0;
                messageObtainMessage.obj = str2;
                SLog.v("AsynLoadImg", "file exists: time:" + (System.currentTimeMillis() - c.this.f9909d));
            } else {
                Bitmap bitmapA = c.a(c.this.f9907a);
                if (bitmapA != null) {
                    zA = c.this.a(bitmapA, str);
                } else {
                    SLog.v("AsynLoadImg", "saveFileRunnable:get bmp fail---");
                    zA = false;
                }
                if (zA) {
                    messageObtainMessage.arg1 = 0;
                    messageObtainMessage.obj = str2;
                } else {
                    messageObtainMessage.arg1 = 1;
                }
                SLog.v("AsynLoadImg", "file not exists: download time:" + (System.currentTimeMillis() - c.this.f9909d));
            }
            c.this.f9910e.sendMessage(messageObtainMessage);
        }
    };

    public c(Activity activity) {
        this.f9911f = new WeakReference<>(activity);
        this.f9910e = new Handler(activity.getMainLooper()) { // from class: com.tencent.open.utils.c.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                SLog.v("AsynLoadImg", "handleMessage:" + message.arg1);
                if (message.arg1 == 0) {
                    c.this.f9908b.a(message.arg1, (String) message.obj);
                } else {
                    c.this.f9908b.a(message.arg1, (String) null);
                }
            }
        };
    }

    public void a(String str, d dVar) {
        SLog.v("AsynLoadImg", "--save---");
        if (str != null && !str.equals("")) {
            if (!m.a()) {
                dVar.a(2, (String) null);
                return;
            }
            if (this.f9911f.get() != null) {
                Activity activity = this.f9911f.get();
                File fileH = m.h(activity, "Images");
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                if (fileH == null) {
                    SLog.e("AsynLoadImg", "externalImageFile is null");
                    dVar.a(2, (String) null);
                    return;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(k.d(activity) ? fileH.getAbsolutePath() : externalStorageDirectory.getAbsolutePath());
                    sb.append("/tmp/");
                    f9906c = sb.toString();
                }
            }
            this.f9909d = System.currentTimeMillis();
            this.f9907a = str;
            this.f9908b = dVar;
            new Thread(this.f9912g).start();
            return;
        }
        dVar.a(1, (String) null);
    }

    public boolean a(Bitmap bitmap, String str) throws Throwable {
        String str2 = f9906c;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                File file = new File(str2);
                if (!file.exists()) {
                    file.mkdir();
                }
                SLog.v("AsynLoadImg", "saveFile:" + str);
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(new File(str2 + str)));
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 80, bufferedOutputStream2);
                    bufferedOutputStream2.flush();
                    try {
                        bufferedOutputStream2.close();
                        return true;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        return true;
                    }
                } catch (IOException e3) {
                    e = e3;
                    bufferedOutputStream = bufferedOutputStream2;
                    e.printStackTrace();
                    SLog.e("AsynLoadImg", "saveFile bmp fail---", e);
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    bufferedOutputStream = bufferedOutputStream2;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e6) {
            e = e6;
        }
    }

    public static Bitmap a(String str) throws IOException {
        SLog.v("AsynLoadImg", "getbitmap:" + str);
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStream);
            inputStream.close();
            SLog.v("AsynLoadImg", "image download finished." + str);
            return bitmapDecodeStream;
        } catch (IOException e2) {
            e2.printStackTrace();
            SLog.v("AsynLoadImg", "getbitmap bmp fail---");
            return null;
        } catch (OutOfMemoryError e3) {
            e3.printStackTrace();
            SLog.v("AsynLoadImg", "getbitmap bmp fail---");
            return null;
        }
    }
}
