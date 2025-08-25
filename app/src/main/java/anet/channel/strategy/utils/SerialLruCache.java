package anet.channel.strategy.utils;

import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class SerialLruCache<K, V> extends LinkedHashMap<K, V> {

    /* renamed from: a, reason: collision with root package name */
    private int f2025a;

    public SerialLruCache(LinkedHashMap<K, V> linkedHashMap, int i2) {
        super(linkedHashMap);
        this.f2025a = i2;
    }

    public boolean entryRemoved(Map.Entry<K, V> entry) {
        return true;
    }

    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry<K, V> entry) {
        if (size() > this.f2025a) {
            return entryRemoved(entry);
        }
        return false;
    }

    @Deprecated
    public SerialLruCache(LinkedHashMap<K, V> linkedHashMap) {
        this(linkedHashMap, 256);
    }

    public SerialLruCache(int i2) {
        super(i2 + 1, 1.0f, true);
        this.f2025a = i2;
    }
}
