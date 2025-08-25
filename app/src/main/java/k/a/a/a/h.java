package k.a.a.a;

import android.content.Context;
import android.text.TextUtils;
import java.util.UUID;

/* compiled from: TerminalInfo.java */
/* loaded from: classes2.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static String f17029a = "";

    public static String a(Context context, int i2) {
        if (i2 >= 2) {
            return "NULL";
        }
        int i3 = i2 + 1;
        if (TextUtils.isEmpty(f17029a)) {
            a(k.a.a.b.a.a.a(context).a("UUID", ""));
            if (TextUtils.isEmpty(f17029a)) {
                a(UUID.randomUUID().toString());
                if (TextUtils.isEmpty(f17029a)) {
                    return "NULL";
                }
                k.a.a.b.a.a.a(context).b("UUID", f17029a);
            }
        }
        if (!TextUtils.isEmpty(f17029a) && (f17029a.length() > 40 || !com.hihonor.honorid.f.a.c(f17029a))) {
            f17029a = "";
            k.a.a.b.a.a.a(context).a("UUID");
            f17029a = a(context, i3);
        }
        return f17029a;
    }

    private static synchronized void a(String str) {
        f17029a = str;
    }
}
