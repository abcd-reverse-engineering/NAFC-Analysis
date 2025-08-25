package com.heytap.mcssdk.d;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.heytap.mcssdk.R;
import com.heytap.mcssdk.k.h;
import com.heytap.mcssdk.k.i;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f5852a = "Heytap PUSH";

    /* renamed from: b, reason: collision with root package name */
    private static final String f5853b = "System Default Channel";

    /* renamed from: c, reason: collision with root package name */
    private static final int f5854c = 3;

    /* renamed from: com.heytap.mcssdk.d.a$a, reason: collision with other inner class name */
    class RunnableC0095a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f5855a;

        RunnableC0095a(Context context) {
            this.f5855a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (h.c().a()) {
                return;
            }
            String string = this.f5855a.getString(R.string.system_default_channel);
            if (TextUtils.isEmpty(string)) {
                string = a.f5853b;
            }
            h.c().a(a.this.a(this.f5855a, a.f5852a, string, 3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(26)
    public boolean a(Context context, String str, String str2, int i2) {
        NotificationManager notificationManager;
        if (context == null || (notificationManager = (NotificationManager) context.getSystemService("notification")) == null) {
            return false;
        }
        notificationManager.createNotificationChannel(new NotificationChannel(str, str2, i2));
        return true;
    }

    public void a(Context context) {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        i.a(new RunnableC0095a(context));
    }
}
