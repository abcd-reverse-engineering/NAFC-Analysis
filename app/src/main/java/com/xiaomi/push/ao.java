package com.xiaomi.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import h.f1;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes2.dex */
class ao implements ai {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f12445a;

    /* renamed from: a, reason: collision with other field name */
    private Context f188a;

    /* renamed from: a, reason: collision with other field name */
    private ServiceConnection f189a;

    /* renamed from: a, reason: collision with other field name */
    private volatile int f187a = 0;

    /* renamed from: a, reason: collision with other field name */
    private volatile a f190a = null;

    /* renamed from: a, reason: collision with other field name */
    private final Object f191a = new Object();

    private class a {

        /* renamed from: a, reason: collision with other field name */
        String f192a;

        /* renamed from: b, reason: collision with root package name */
        String f12447b;

        /* renamed from: c, reason: collision with root package name */
        String f12448c;

        /* renamed from: d, reason: collision with root package name */
        String f12449d;

        private a() {
            this.f192a = null;
            this.f12447b = null;
            this.f12448c = null;
            this.f12449d = null;
        }
    }

    private class b implements ServiceConnection {
        private b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
            if (ao.this.f190a != null) {
                return;
            }
            new Thread(new Runnable() { // from class: com.xiaomi.push.ao.b.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        String packageName = ao.this.f188a.getPackageName();
                        String strB = ao.this.b();
                        a aVar = new a();
                        aVar.f12447b = c.a(iBinder, packageName, strB, "OUID");
                        ao.this.f190a = aVar;
                        ao.this.m143b();
                        ao.this.f187a = 2;
                        synchronized (ao.this.f191a) {
                            try {
                                ao.this.f191a.notifyAll();
                            } catch (Exception unused) {
                            }
                        }
                    } catch (Exception unused2) {
                        ao.this.m143b();
                        ao.this.f187a = 2;
                        synchronized (ao.this.f191a) {
                            try {
                                ao.this.f191a.notifyAll();
                            } catch (Exception unused3) {
                            }
                        }
                    } catch (Throwable th) {
                        ao.this.m143b();
                        ao.this.f187a = 2;
                        synchronized (ao.this.f191a) {
                            try {
                                ao.this.f191a.notifyAll();
                            } catch (Exception unused4) {
                            }
                            throw th;
                        }
                    }
                }
            }).start();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    private static class c {
        static String a(IBinder iBinder, String str, String str2, String str3) {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                parcelObtain.writeString(str);
                parcelObtain.writeString(str2);
                parcelObtain.writeString(str3);
                iBinder.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }

    public ao(Context context) {
        this.f188a = context;
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b, reason: collision with other method in class */
    public void m143b() {
        ServiceConnection serviceConnection = this.f189a;
        if (serviceConnection != null) {
            try {
                this.f188a.unbindService(serviceConnection);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b() throws NoSuchAlgorithmException {
        try {
            Signature[] signatureArr = this.f188a.getPackageManager().getPackageInfo(this.f188a.getPackageName(), 64).signatures;
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            StringBuilder sb = new StringBuilder();
            for (byte b2 : messageDigest.digest(signatureArr[0].toByteArray())) {
                sb.append(Integer.toHexString((b2 & f1.f16099c) | 256).substring(1, 3));
            }
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.xiaomi.push.ai
    /* renamed from: a */
    public boolean mo137a() {
        return f12445a;
    }

    @Override // com.xiaomi.push.ai
    /* renamed from: a */
    public String mo136a() {
        a("getOAID");
        if (this.f190a == null) {
            return null;
        }
        return this.f190a.f12447b;
    }

    private void a() {
        boolean zBindService;
        this.f189a = new b();
        Intent intent = new Intent();
        intent.setClassName("com.heytap.openid", "com.heytap.openid.IdentifyService");
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        try {
            zBindService = this.f188a.bindService(intent, this.f189a, 1);
        } catch (Exception unused) {
            zBindService = false;
        }
        this.f187a = zBindService ? 1 : 2;
    }

    private void a(String str) {
        if (this.f187a != 1 || Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        synchronized (this.f191a) {
            try {
                com.xiaomi.channel.commonutils.logger.b.m50a("oppo's " + str + " wait...");
                this.f191a.wait(3000L);
            } catch (Exception unused) {
            }
        }
    }

    public static boolean a(Context context) throws PackageManager.NameNotFoundException {
        long longVersionCode;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.heytap.openid", 128);
            if (packageInfo != null) {
                if (Build.VERSION.SDK_INT >= 28) {
                    longVersionCode = packageInfo.getLongVersionCode();
                } else {
                    longVersionCode = packageInfo.versionCode;
                }
                boolean z = (packageInfo.applicationInfo.flags & 1) != 0;
                f12445a = longVersionCode >= 1;
                if (z) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
