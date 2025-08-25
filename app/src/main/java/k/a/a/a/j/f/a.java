package k.a.a.a.j.f;

import android.os.Process;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* compiled from: Record.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final SimpleDateFormat f17042a;

    /* renamed from: b, reason: collision with root package name */
    private final long f17043b;

    /* renamed from: c, reason: collision with root package name */
    private final long f17044c;

    /* renamed from: d, reason: collision with root package name */
    private final long f17045d;

    /* renamed from: e, reason: collision with root package name */
    private final int f17046e;

    /* renamed from: f, reason: collision with root package name */
    private final String f17047f;

    /* renamed from: g, reason: collision with root package name */
    private final String f17048g;

    /* renamed from: h, reason: collision with root package name */
    private final int f17049h;

    /* renamed from: i, reason: collision with root package name */
    private final String f17050i;

    /* renamed from: j, reason: collision with root package name */
    private final String f17051j;

    /* compiled from: Record.java */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final long f17052a;

        /* renamed from: b, reason: collision with root package name */
        private final long f17053b;

        /* renamed from: c, reason: collision with root package name */
        private final long f17054c;

        /* renamed from: d, reason: collision with root package name */
        private final int f17055d;

        /* renamed from: e, reason: collision with root package name */
        private final String f17056e;

        /* renamed from: f, reason: collision with root package name */
        private String f17057f;

        /* renamed from: g, reason: collision with root package name */
        private int f17058g;

        /* renamed from: h, reason: collision with root package name */
        private String f17059h;

        /* renamed from: i, reason: collision with root package name */
        private String f17060i;

        private b(int i2, String str) {
            this.f17052a = System.currentTimeMillis();
            this.f17053b = Process.myPid();
            this.f17054c = Process.myTid();
            this.f17055d = i2;
            this.f17056e = str;
            this.f17057f = "";
            this.f17058g = 0;
            this.f17060i = "";
        }

        public a a() {
            return new a(this);
        }

        public b a(String str) {
            this.f17059h = str;
            return this;
        }
    }

    private static char a(int i2) {
        if (i2 == 3) {
            return 'D';
        }
        if (i2 == 4) {
            return 'I';
        }
        if (i2 == 5) {
            return 'W';
        }
        if (i2 != 6) {
            return i2 != 7 ? 'V' : 'A';
        }
        return 'E';
    }

    public static b a(int i2, String str) {
        return new b(i2, str);
    }

    public void b(StringBuilder sb) {
        sb.append(this.f17050i);
    }

    public void c(StringBuilder sb) {
        if (this.f17051j != null) {
            sb.append('\n');
            sb.append(this.f17051j);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        a(sb);
        sb.append(c.c.a.b.a.a.f3100g);
        b(sb);
        c(sb);
        sb.append("\n");
        return sb.toString();
    }

    private a(b bVar) {
        this.f17042a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
        this.f17043b = bVar.f17052a;
        this.f17044c = bVar.f17053b;
        this.f17045d = bVar.f17054c;
        this.f17046e = bVar.f17055d;
        this.f17047f = bVar.f17056e;
        this.f17048g = bVar.f17057f;
        this.f17049h = bVar.f17058g;
        this.f17050i = bVar.f17059h;
        this.f17051j = bVar.f17060i;
    }

    public void a(StringBuilder sb) {
        sb.append("[");
        sb.append(this.f17042a.format(Long.valueOf(this.f17043b)));
        sb.append(c.c.a.b.a.a.f3100g);
        sb.append(a(this.f17046e));
        sb.append("/");
        sb.append(this.f17047f);
        sb.append(c.c.a.b.a.a.f3100g);
        sb.append(this.f17044c);
        sb.append(Constants.COLON_SEPARATOR);
        sb.append(this.f17045d);
        sb.append(c.c.a.b.a.a.f3100g);
        sb.append(this.f17048g);
        sb.append(Constants.COLON_SEPARATOR);
        sb.append(this.f17049h);
        sb.append("]");
    }
}
