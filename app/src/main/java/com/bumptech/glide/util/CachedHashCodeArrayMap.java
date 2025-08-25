package com.bumptech.glide.util;

import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;

/* loaded from: classes.dex */
public final class CachedHashCodeArrayMap<K, V> extends ArrayMap<K, V> {

    /* renamed from: a, reason: collision with root package name */
    private int f5355a;

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public void clear() {
        this.f5355a = 0;
        super.clear();
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public int hashCode() {
        if (this.f5355a == 0) {
            this.f5355a = super.hashCode();
        }
        return this.f5355a;
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public V put(K k2, V v) {
        this.f5355a = 0;
        return (V) super.put(k2, v);
    }

    @Override // androidx.collection.SimpleArrayMap
    public void putAll(SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        this.f5355a = 0;
        super.putAll(simpleArrayMap);
    }

    @Override // androidx.collection.SimpleArrayMap
    public V removeAt(int i2) {
        this.f5355a = 0;
        return (V) super.removeAt(i2);
    }

    @Override // androidx.collection.SimpleArrayMap
    public V setValueAt(int i2, V v) {
        this.f5355a = 0;
        return (V) super.setValueAt(i2, v);
    }
}
