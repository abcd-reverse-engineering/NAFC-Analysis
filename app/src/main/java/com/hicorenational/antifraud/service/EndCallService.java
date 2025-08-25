package com.hicorenational.antifraud.service;

import android.app.AlertDialog;
import android.app.Service;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.Toast;
import c.a.a.a.a;

/* loaded from: classes.dex */
public class EndCallService extends Service {

    /* renamed from: c, reason: collision with root package name */
    private static final String f5951c = "HTC";

    /* renamed from: a, reason: collision with root package name */
    private TelephonyManager f5952a;

    /* renamed from: b, reason: collision with root package name */
    private b f5953b;

    private class b extends PhoneStateListener {

        class a implements DialogInterface.OnClickListener {
            a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                EndCallService.this.c();
                Toast.makeText(EndCallService.this.getApplicationContext(), "挂断电话", 0).show();
            }
        }

        /* renamed from: com.hicorenational.antifraud.service.EndCallService$b$b, reason: collision with other inner class name */
        class DialogInterfaceOnClickListenerC0097b implements DialogInterface.OnClickListener {
            DialogInterfaceOnClickListenerC0097b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                EndCallService endCallService = EndCallService.this;
                endCallService.startService(new Intent(endCallService.getApplicationContext(), (Class<?>) RecorderService.class));
                Toast.makeText(EndCallService.this.getApplicationContext(), "开启电话录音", 0).show();
                EndCallService.this.a();
            }
        }

        class c extends ContentObserver {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ContentResolver f5957a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Uri f5958b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f5959c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(Handler handler, ContentResolver contentResolver, Uri uri, String str) {
                super(handler);
                this.f5957a = contentResolver;
                this.f5958b = uri;
                this.f5959c = str;
            }

            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                super.onChange(z);
                this.f5957a.delete(this.f5958b, "number=?", new String[]{this.f5959c});
                this.f5957a.unregisterContentObserver(this);
            }
        }

        private b() {
        }

        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int i2, String str) {
            super.onCallStateChanged(i2, str);
            if (i2 == 1) {
                EndCallService.this.c();
                AlertDialog alertDialogCreate = new AlertDialog.Builder(EndCallService.this.getApplicationContext()).setTitle("title").setMessage("这是诈骗电话").setCancelable(false).setPositiveButton("开启电话录音", new DialogInterfaceOnClickListenerC0097b()).setNegativeButton("挂断", new a()).create();
                alertDialogCreate.getWindow().setType(2003);
                alertDialogCreate.show();
                Toast.makeText(EndCallService.this.getApplicationContext(), "拦截号码:" + str, 0).show();
                ContentResolver contentResolver = EndCallService.this.getContentResolver();
                Uri uri = Uri.parse("content://call_log/calls");
                contentResolver.registerContentObserver(uri, true, new c(new Handler(), contentResolver, uri, str));
            }
        }
    }

    public void a() {
        try {
            a.AbstractBinderC0031a.a((IBinder) Class.forName("android.os.ServiceManager").getMethod("getService", String.class).invoke(null, "phone")).i();
        } catch (Exception unused) {
            b();
        }
    }

    public void b() {
    }

    public void c() {
        try {
            a.AbstractBinderC0031a.a((IBinder) EndCallService.class.getClassLoader().loadClass("android.os.ServiceManager").getDeclaredMethod("getService", String.class).invoke(null, "phone")).h();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f5952a = (TelephonyManager) getSystemService("phone");
        this.f5953b = new b();
        this.f5952a.listen(this.f5953b, 32);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.f5952a.listen(this.f5953b, 0);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        return 3;
    }
}
