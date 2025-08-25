package com.umeng.analytics.pro;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* compiled from: HuaweiDeviceIdSupplier.java */
/* loaded from: classes2.dex */
class ay implements au {

    /* renamed from: a, reason: collision with root package name */
    private static final String f10094a = "com.uodis.opendevice.aidl.OpenDeviceIdentifierService";

    /* renamed from: b, reason: collision with root package name */
    private static final int f10095b = 1;

    /* renamed from: c, reason: collision with root package name */
    private static final int f10096c = 2;

    /* compiled from: HuaweiDeviceIdSupplier.java */
    private static final class a implements ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        boolean f10097a;

        /* renamed from: b, reason: collision with root package name */
        private final LinkedBlockingQueue<IBinder> f10098b;

        private a() {
            this.f10097a = false;
            this.f10098b = new LinkedBlockingQueue<>();
        }

        public IBinder a() throws InterruptedException {
            if (this.f10097a) {
                throw new IllegalStateException();
            }
            this.f10097a = true;
            return this.f10098b.poll(5L, TimeUnit.SECONDS);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) throws InterruptedException {
            try {
                this.f10098b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* compiled from: HuaweiDeviceIdSupplier.java */
    private static final class b implements IInterface {

        /* renamed from: a, reason: collision with root package name */
        private IBinder f10099a;

        public b(IBinder iBinder) {
            this.f10099a = iBinder;
        }

        public String a() throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken(ay.f10094a);
                this.f10099a.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f10099a;
        }

        public boolean b() throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken(ay.f10094a);
                this.f10099a.transact(2, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readInt() != 0;
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }

    ay() {
    }

    @Override // com.umeng.analytics.pro.au
    public String a(Context context) {
        a aVar = new a();
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        if (context.bindService(intent, aVar, 1)) {
            try {
                return new b(aVar.a()).a();
            } catch (Exception unused) {
            } finally {
                context.unbindService(aVar);
            }
        }
        return null;
    }
}
