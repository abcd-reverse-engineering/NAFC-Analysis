package org.greenrobot.eventbus;

import android.util.Log;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: Logger.java */
/* loaded from: classes2.dex */
public interface g {

    /* compiled from: Logger.java */
    public static class a implements g {

        /* renamed from: b, reason: collision with root package name */
        static final boolean f17406b;

        /* renamed from: a, reason: collision with root package name */
        private final String f17407a;

        static {
            boolean z = false;
            try {
                if (Class.forName("android.util.Log") != null) {
                    z = true;
                }
            } catch (ClassNotFoundException unused) {
            }
            f17406b = z;
        }

        public a(String str) {
            this.f17407a = str;
        }

        public static boolean a() {
            return f17406b;
        }

        @Override // org.greenrobot.eventbus.g
        public void a(Level level, String str) {
            if (level != Level.OFF) {
                Log.println(a(level), this.f17407a, str);
            }
        }

        @Override // org.greenrobot.eventbus.g
        public void a(Level level, String str, Throwable th) {
            if (level != Level.OFF) {
                Log.println(a(level), this.f17407a, str + "\n" + Log.getStackTraceString(th));
            }
        }

        protected int a(Level level) {
            int iIntValue = level.intValue();
            if (iIntValue < 800) {
                return iIntValue < 500 ? 2 : 3;
            }
            if (iIntValue < 900) {
                return 4;
            }
            return iIntValue < 1000 ? 5 : 6;
        }
    }

    /* compiled from: Logger.java */
    public static class b implements g {

        /* renamed from: a, reason: collision with root package name */
        protected final Logger f17408a;

        public b(String str) {
            this.f17408a = Logger.getLogger(str);
        }

        @Override // org.greenrobot.eventbus.g
        public void a(Level level, String str) {
            this.f17408a.log(level, str);
        }

        @Override // org.greenrobot.eventbus.g
        public void a(Level level, String str, Throwable th) {
            this.f17408a.log(level, str, th);
        }
    }

    /* compiled from: Logger.java */
    public static class c implements g {
        @Override // org.greenrobot.eventbus.g
        public void a(Level level, String str) {
            System.out.println("[" + level + "] " + str);
        }

        @Override // org.greenrobot.eventbus.g
        public void a(Level level, String str, Throwable th) {
            System.out.println("[" + level + "] " + str);
            th.printStackTrace(System.out);
        }
    }

    void a(Level level, String str);

    void a(Level level, String str, Throwable th);
}
