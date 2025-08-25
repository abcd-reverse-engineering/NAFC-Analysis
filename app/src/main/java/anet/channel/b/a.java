package anet.channel.b;

import a.a.j.a;
import anet.channel.util.ALog;
import anet.channel.util.StringUtils;
import com.taobao.alivfssdk.cache.AVFSCache;
import com.taobao.alivfssdk.cache.AVFSCacheConfig;
import com.taobao.alivfssdk.cache.AVFSCacheManager;
import com.taobao.alivfssdk.cache.IAVFSCache;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class a implements a.a.j.a {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f1683a = true;

    /* renamed from: b, reason: collision with root package name */
    private static Object f1684b;

    /* renamed from: c, reason: collision with root package name */
    private static Object f1685c;

    /* renamed from: d, reason: collision with root package name */
    private static Object f1686d;

    static {
        try {
            Class.forName("com.taobao.alivfssdk.cache.AVFSCacheManager");
            f1684b = new b();
            f1685c = new c();
            f1686d = new d();
        } catch (ClassNotFoundException unused) {
            f1683a = false;
            ALog.w("anet.AVFSCacheImpl", "no alivfs sdk!", null, new Object[0]);
        }
    }

    private IAVFSCache b() {
        AVFSCache aVFSCacheCacheForModule = AVFSCacheManager.getInstance().cacheForModule("networksdk.httpcache");
        if (aVFSCacheCacheForModule != null) {
            return aVFSCacheCacheForModule.getFileCache();
        }
        return null;
    }

    public void a() {
        AVFSCache aVFSCacheCacheForModule;
        if (f1683a && (aVFSCacheCacheForModule = AVFSCacheManager.getInstance().cacheForModule("networksdk.httpcache")) != null) {
            AVFSCacheConfig aVFSCacheConfig = new AVFSCacheConfig();
            aVFSCacheConfig.limitSize = 5242880L;
            aVFSCacheConfig.fileMemMaxSize = 1048576L;
            aVFSCacheCacheForModule.moduleConfig(aVFSCacheConfig);
        }
    }

    @Override // a.a.j.a
    public void clear() {
        if (f1683a) {
            try {
                IAVFSCache iAVFSCacheB = b();
                if (iAVFSCacheB != null) {
                    iAVFSCacheB.removeAllObject((IAVFSCache.OnAllObjectRemoveCallback) f1686d);
                }
            } catch (Exception e2) {
                ALog.e("anet.AVFSCacheImpl", "clear cache failed", null, e2, new Object[0]);
            }
        }
    }

    @Override // a.a.j.a
    public a.C0001a get(String str) {
        if (!f1683a) {
            return null;
        }
        try {
            IAVFSCache iAVFSCacheB = b();
            if (iAVFSCacheB != null) {
                return (a.C0001a) iAVFSCacheB.objectForKey(StringUtils.md5ToHex(str));
            }
        } catch (Exception e2) {
            ALog.e("anet.AVFSCacheImpl", "get cache failed", null, e2, new Object[0]);
        }
        return null;
    }

    @Override // a.a.j.a
    public void put(String str, a.C0001a c0001a) {
        if (f1683a) {
            try {
                IAVFSCache iAVFSCacheB = b();
                if (iAVFSCacheB != null) {
                    iAVFSCacheB.setObjectForKey(StringUtils.md5ToHex(str), c0001a, (IAVFSCache.OnObjectSetCallback) f1684b);
                }
            } catch (Exception e2) {
                ALog.e("anet.AVFSCacheImpl", "put cache failed", null, e2, new Object[0]);
            }
        }
    }

    @Override // a.a.j.a
    public void remove(String str) {
        if (f1683a) {
            try {
                IAVFSCache iAVFSCacheB = b();
                if (iAVFSCacheB != null) {
                    iAVFSCacheB.removeObjectForKey(StringUtils.md5ToHex(str), (IAVFSCache.OnObjectRemoveCallback) f1685c);
                }
            } catch (Exception e2) {
                ALog.e("anet.AVFSCacheImpl", "remove cache failed", null, e2, new Object[0]);
            }
        }
    }
}
