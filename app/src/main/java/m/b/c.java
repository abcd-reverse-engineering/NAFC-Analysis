package m.b;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import c.b.c.e;
import c.b.c.u;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import zxing.android.CaptureActivity;
import zxing.android.f;

/* compiled from: DecodeThread.java */
/* loaded from: classes2.dex */
public final class c extends Thread {

    /* renamed from: e, reason: collision with root package name */
    public static final String f17297e = "barcode_bitmap";

    /* renamed from: f, reason: collision with root package name */
    public static final String f17298f = "barcode_scaled_factor";

    /* renamed from: a, reason: collision with root package name */
    private final CaptureActivity f17299a;

    /* renamed from: c, reason: collision with root package name */
    private Handler f17301c;

    /* renamed from: d, reason: collision with root package name */
    private final CountDownLatch f17302d = new CountDownLatch(1);

    /* renamed from: b, reason: collision with root package name */
    private final Map<e, Object> f17300b = new EnumMap(e.class);

    public c(CaptureActivity captureActivity, Collection<c.b.c.a> collection, Map<e, ?> map, String str, u uVar) {
        this.f17299a = captureActivity;
        if (map != null) {
            this.f17300b.putAll(map);
        }
        if (collection == null || collection.isEmpty()) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(captureActivity);
            collection = EnumSet.noneOf(c.b.c.a.class);
            if (defaultSharedPreferences.getBoolean(f.f21132a, true)) {
                collection.addAll(a.f17285b);
            }
            if (defaultSharedPreferences.getBoolean(f.f21133b, true)) {
                collection.addAll(a.f17286c);
            }
            if (defaultSharedPreferences.getBoolean(f.f21134c, true)) {
                collection.addAll(a.f17288e);
            }
            if (defaultSharedPreferences.getBoolean(f.f21135d, true)) {
                collection.addAll(a.f17289f);
            }
            if (defaultSharedPreferences.getBoolean(f.f21136e, false)) {
                collection.addAll(a.f17290g);
            }
            if (defaultSharedPreferences.getBoolean(f.f21137f, false)) {
                collection.addAll(a.f17291h);
            }
        }
        this.f17300b.put(e.POSSIBLE_FORMATS, collection);
        if (str != null) {
            this.f17300b.put(e.CHARACTER_SET, str);
        }
        this.f17300b.put(e.NEED_RESULT_POINT_CALLBACK, uVar);
        String str2 = "Hints: " + this.f17300b;
    }

    public Handler a() throws InterruptedException {
        try {
            this.f17302d.await();
        } catch (InterruptedException unused) {
        }
        return this.f17301c;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Looper.prepare();
        this.f17301c = new b(this.f17299a, this.f17300b);
        this.f17302d.countDown();
        Looper.loop();
    }
}
