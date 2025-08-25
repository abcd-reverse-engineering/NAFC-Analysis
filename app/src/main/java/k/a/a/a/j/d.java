package k.a.a.a.j;

import android.content.Context;
import android.util.Log;
import cn.cloudwalk.util.LogUtils;
import java.io.File;
import k.a.a.a.j.b;

/* compiled from: LogHnIDAdpater.java */
/* loaded from: classes2.dex */
public final class d extends b {

    /* renamed from: b, reason: collision with root package name */
    private static final k.a.a.a.j.a f17037b = new k.a.a.a.j.a();

    /* renamed from: c, reason: collision with root package name */
    private static String f17038c = b.a();

    /* renamed from: d, reason: collision with root package name */
    private static d f17039d;

    /* compiled from: LogHnIDAdpater.java */
    static class a extends Thread {

        /* renamed from: a, reason: collision with root package name */
        private Context f17040a;

        a(Context context) {
            this.f17040a = context;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                try {
                    String strB = b.a.b(this.f17040a);
                    b.a.a(this.f17040a);
                    d.b(strB);
                    d.f17037b.a(new File(strB, "honorid_advanced_log.txt"));
                    c.a(d.f17037b);
                } catch (ArrayIndexOutOfBoundsException e2) {
                    String str = "ArrayIndexOutOfBoundsException" + e2.getMessage();
                    b.a.a(this.f17040a);
                } catch (Exception e3) {
                    String str2 = LogUtils.LOG_EXCEPTION + e3.getClass().getSimpleName();
                    b.a.a(this.f17040a);
                }
            } catch (Throwable th) {
                b.a.a(this.f17040a);
                throw th;
            }
        }
    }

    private d(Context context) {
        new a(context).start();
    }

    @Override // k.a.a.a.j.b
    public void c(String str, String str2) {
        a(4, str, str2, null, 2);
        c.b(str, str2);
    }

    private static synchronized void a(int i2, String str, String str2, Throwable th, int i3) {
        if (a(i2)) {
            if (str2 == null) {
                str2 = "";
            }
            try {
                Log.println(i2, f17038c + str, str2);
            } catch (IllegalArgumentException e2) {
                String str3 = "println IllegalArgumentException" + e2.getMessage();
            } catch (Exception e3) {
                String str4 = "println Exception" + e3.getClass().getSimpleName();
            }
        }
    }

    public static synchronized d b(Context context) {
        if (f17039d == null) {
            f17039d = new d(context);
            f17038c = b.a(context);
        }
        return f17039d;
    }

    private static boolean a(int i2) {
        return Log.isLoggable("honorid", i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str) {
        File file = new File(str, "apphnid.txt");
        File file2 = new File(str, "apphnid.txt.bak");
        k.a.a.a.c.a(file);
        k.a.a.a.c.a(file2);
    }

    @Override // k.a.a.a.j.b
    public void a(String str, String str2) {
        a(3, str, str2, null, 2);
    }

    @Override // k.a.a.a.j.b
    public void b(String str, String str2) {
        a(6, str, str2, null, 2);
        c.a(str, str2);
    }
}
