package com.hicorenational.antifraud.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import util.f1;

/* loaded from: classes.dex */
public class RecorderService extends Service {

    /* renamed from: a, reason: collision with root package name */
    private MediaRecorder f5961a;

    class a extends PhoneStateListener {
        a() {
        }

        private void a() {
            File file = new File(f1.b() + "/recorder");
            if (file.exists()) {
                return;
            }
            file.mkdir();
        }

        private String b() {
            return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        }

        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int i2, String str) throws IllegalStateException, IOException {
            if (i2 == 0) {
                if (RecorderService.this.f5961a != null) {
                    RecorderService.this.f5961a.stop();
                    RecorderService.this.f5961a.release();
                    RecorderService.this.f5961a = null;
                    return;
                }
                return;
            }
            if (i2 != 1) {
                if (i2 == 2 && RecorderService.this.f5961a != null) {
                    RecorderService.this.f5961a.start();
                    return;
                }
                return;
            }
            if (RecorderService.this.f5961a == null) {
                RecorderService.this.f5961a = new MediaRecorder();
                RecorderService.this.f5961a.setAudioSource(1);
                RecorderService.this.f5961a.setOutputFormat(1);
                a();
                RecorderService.this.f5961a.setOutputFile("sdcard/recorder/" + b() + ".3gp");
                RecorderService.this.f5961a.setAudioEncoder(1);
                try {
                    RecorderService.this.f5961a.prepare();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        ((TelephonyManager) getSystemService("phone")).listen(new a(), 32);
    }
}
