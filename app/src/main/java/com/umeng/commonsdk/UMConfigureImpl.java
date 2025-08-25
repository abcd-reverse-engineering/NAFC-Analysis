package com.umeng.commonsdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.analytics.pro.at;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.utils.onMessageSendListener;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class UMConfigureImpl {

    /* renamed from: e, reason: collision with root package name */
    private static final int f10660e = 1000;

    /* renamed from: f, reason: collision with root package name */
    private static ScheduledExecutorService f10661f;

    /* renamed from: g, reason: collision with root package name */
    private static Context f10662g;

    /* renamed from: a, reason: collision with root package name */
    private static String f10656a = at.b().b(at.o);

    /* renamed from: b, reason: collision with root package name */
    private static CopyOnWriteArrayList<onMessageSendListener> f10657b = new CopyOnWriteArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private static int f10658c = 0;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f10659d = false;

    /* renamed from: h, reason: collision with root package name */
    private static int f10663h = 0;

    /* renamed from: i, reason: collision with root package name */
    private static Runnable f10664i = new Runnable() { // from class: com.umeng.commonsdk.UMConfigureImpl.1
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (UMConfigureImpl.f10658c == 0 || UMConfigureImpl.f10663h >= 10) {
                    if (!UMConfigureImpl.f10659d) {
                        boolean unused = UMConfigureImpl.f10659d = true;
                        UMConfigureImpl.b(UMConfigureImpl.f10662g);
                    }
                    if (UMConfigureImpl.f10661f != null) {
                        UMConfigureImpl.f10661f.shutdown();
                        ScheduledExecutorService unused2 = UMConfigureImpl.f10661f = null;
                    }
                }
                UMConfigureImpl.f();
            } catch (Exception unused3) {
            }
        }
    };

    static /* synthetic */ int f() {
        int i2 = f10663h;
        f10663h = i2 + 1;
        return i2;
    }

    public static void init(Context context) {
        if (context == null) {
            return;
        }
        f10662g = context;
        try {
            if (f10658c < 1 || d(context)) {
                UMEnvelopeBuild.setTransmissionSendFlag(true);
            } else {
                UMEnvelopeBuild.setTransmissionSendFlag(false);
                c(context);
                if (f10661f == null) {
                    f10661f = Executors.newScheduledThreadPool(1);
                    f10661f.scheduleAtFixedRate(f10664i, 0L, 100L, TimeUnit.MILLISECONDS);
                }
            }
        } catch (Exception unused) {
        }
    }

    public static synchronized void registerInterruptFlag() {
        try {
            f10658c++;
        } catch (Exception unused) {
        }
    }

    public static synchronized void registerMessageSendListener(onMessageSendListener onmessagesendlistener) {
        try {
            if (f10657b != null) {
                f10657b.add(onmessagesendlistener);
            }
            if (UMEnvelopeBuild.getTransmissionSendFlag() && f10657b != null && f10657b.size() > 0) {
                Iterator<onMessageSendListener> it = f10657b.iterator();
                while (it.hasNext()) {
                    it.next().onMessageSend();
                }
            }
        } catch (Exception unused) {
        }
    }

    public static synchronized void removeInterruptFlag() {
        try {
            f10658c--;
        } catch (Exception unused) {
        }
    }

    public static synchronized void removeMessageSendListener(onMessageSendListener onmessagesendlistener) {
        try {
            if (f10657b != null) {
                f10657b.remove(onmessagesendlistener);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void b(Context context) {
        try {
            UMEnvelopeBuild.setTransmissionSendFlag(true);
            if (f10657b != null && f10657b.size() > 0) {
                Iterator<onMessageSendListener> it = f10657b.iterator();
                while (it.hasNext()) {
                    it.next().onMessageSend();
                }
            }
        } catch (Exception unused) {
        }
    }

    private static void c(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(f10656a, 0);
            if (sharedPreferences == null || sharedPreferences == null) {
                return;
            }
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putBoolean(f10656a, true);
            editorEdit.commit();
        } catch (Throwable unused) {
        }
    }

    private static boolean d(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(f10656a, 0);
            if (sharedPreferences == null || sharedPreferences == null) {
                return false;
            }
            return sharedPreferences.getBoolean(f10656a, false);
        } catch (Throwable unused) {
            return false;
        }
    }
}
