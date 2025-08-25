package j;

import android.content.Context;
import com.luck.picture.lib.engine.CacheResourcesEngine;
import java.io.File;

/* compiled from: GlideCacheEngine.java */
/* loaded from: classes2.dex */
public class a implements CacheResourcesEngine {

    /* renamed from: a, reason: collision with root package name */
    private static final int f16990a = 4;

    /* renamed from: b, reason: collision with root package name */
    private static a f16991b;

    private a() {
    }

    public static a a() {
        if (f16991b == null) {
            synchronized (a.class) {
                if (f16991b == null) {
                    f16991b = new a();
                }
            }
        }
        return f16991b;
    }

    @Override // com.luck.picture.lib.engine.CacheResourcesEngine
    public String onCachePath(Context context, String str) {
        File fileB = c.b(context, str);
        return fileB != null ? fileB.getAbsolutePath() : "";
    }
}
