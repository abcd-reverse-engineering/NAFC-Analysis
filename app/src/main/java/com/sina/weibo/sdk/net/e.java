package com.sina.weibo.sdk.net;

import android.os.Bundle;
import com.tencent.bugly.BuglyStrategy;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class e implements d {

    /* renamed from: i, reason: collision with root package name */
    private String f8363i;

    /* renamed from: j, reason: collision with root package name */
    private Bundle f8364j = new Bundle();

    /* renamed from: k, reason: collision with root package name */
    private Bundle f8365k = new Bundle();

    /* renamed from: l, reason: collision with root package name */
    private Map<String, Object<File>> f8366l = new HashMap();

    /* renamed from: m, reason: collision with root package name */
    private Map<String, byte[]> f8367m = new HashMap();
    private int n;
    private int o;

    public static final class a {

        /* renamed from: i, reason: collision with root package name */
        public String f8368i;

        /* renamed from: j, reason: collision with root package name */
        Bundle f8369j = new Bundle();

        /* renamed from: k, reason: collision with root package name */
        Bundle f8370k = new Bundle();

        /* renamed from: l, reason: collision with root package name */
        Map<String, Object<File>> f8371l = new HashMap();

        /* renamed from: m, reason: collision with root package name */
        Map<String, byte[]> f8372m = new HashMap();
        int n = BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH;
        int o = 60000;

        public final a a(String str, Object obj) {
            a(this.f8369j, str, obj);
            return this;
        }

        public final a b(String str, Object obj) {
            a(this.f8370k, str, obj);
            return this;
        }

        public final e e() {
            return new e(this);
        }

        private void a(Bundle bundle, String str, Object obj) {
            if (obj != null) {
                if (obj instanceof String) {
                    bundle.putString(str, String.valueOf(obj));
                    return;
                }
                if (obj instanceof Integer) {
                    bundle.putInt(str, ((Integer) obj).intValue());
                    return;
                }
                if (obj instanceof Short) {
                    bundle.putShort(str, ((Short) obj).shortValue());
                    return;
                }
                if (obj instanceof Character) {
                    bundle.putChar(str, ((Character) obj).charValue());
                    return;
                }
                if (obj instanceof Byte) {
                    bundle.putByte(str, ((Byte) obj).byteValue());
                    return;
                }
                if (obj instanceof Long) {
                    bundle.putLong(str, ((Long) obj).longValue());
                    return;
                }
                if (obj instanceof Float) {
                    bundle.putFloat(str, ((Float) obj).floatValue());
                    return;
                }
                if (obj instanceof Double) {
                    bundle.putDouble(str, ((Double) obj).doubleValue());
                    return;
                }
                if (obj instanceof Boolean) {
                    bundle.putBoolean(str, ((Boolean) obj).booleanValue());
                } else if (obj instanceof byte[]) {
                    this.f8372m.put(str, (byte[]) obj);
                } else {
                    if (!(obj instanceof Serializable)) {
                        throw new IllegalArgumentException("Unsupported params type!");
                    }
                    bundle.putSerializable(str, (Serializable) obj);
                }
            }
        }
    }

    public e(a aVar) {
        this.f8363i = aVar.f8368i;
        this.f8364j.putAll(aVar.f8369j);
        this.f8365k.putAll(aVar.f8370k);
        this.f8366l.putAll(aVar.f8371l);
        this.f8367m.putAll(aVar.f8372m);
        this.n = aVar.n;
        this.o = aVar.o;
    }

    @Override // com.sina.weibo.sdk.net.d
    public final Bundle d() {
        return this.f8365k;
    }

    @Override // com.sina.weibo.sdk.net.d
    public final int getConnectTimeout() {
        return this.n;
    }

    @Override // com.sina.weibo.sdk.net.d
    public final Bundle getParams() {
        return this.f8364j;
    }

    @Override // com.sina.weibo.sdk.net.d
    public final int getReadTimeout() {
        return this.o;
    }

    @Override // com.sina.weibo.sdk.net.d
    public final String getUrl() {
        return this.f8363i;
    }
}
