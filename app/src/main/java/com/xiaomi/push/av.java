package com.xiaomi.push;

import android.net.NetworkInfo;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public class av {

    /* renamed from: a, reason: collision with root package name */
    private final NetworkInfo f12467a;

    /* renamed from: a, reason: collision with other field name */
    private final ConcurrentHashMap<String, Object> f199a = new ConcurrentHashMap<>();

    public av(NetworkInfo networkInfo) {
        this.f12467a = networkInfo;
    }

    private <T> T a(String str) {
        Object objValueOf;
        if (!this.f199a.containsKey(str)) {
            synchronized (str) {
                if (!this.f199a.contains(str)) {
                    objValueOf = null;
                    switch (str) {
                        case "getType":
                            objValueOf = Integer.valueOf(this.f12467a.getType());
                            break;
                        case "getTypeName":
                            objValueOf = this.f12467a.getTypeName();
                            break;
                        case "getSubtype":
                            objValueOf = Integer.valueOf(this.f12467a.getSubtype());
                            break;
                        case "getSubtypeName":
                            objValueOf = this.f12467a.getSubtypeName();
                            break;
                        case "isConnected":
                            objValueOf = Boolean.valueOf(this.f12467a.isConnected());
                            break;
                        case "getState":
                            objValueOf = this.f12467a.getState();
                            break;
                        case "getDetailedState":
                            objValueOf = this.f12467a.getDetailedState();
                            break;
                    }
                    if (objValueOf != null) {
                        this.f199a.put(str, objValueOf);
                    }
                }
            }
        }
        return (T) this.f199a.get(str);
    }

    public int b() {
        return ((Integer) a("getSubtype")).intValue();
    }

    /* renamed from: b, reason: collision with other method in class */
    public String m156b() {
        return (String) a("getSubtypeName");
    }

    public int a() {
        return ((Integer) a("getType")).intValue();
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m154a() {
        return (String) a("getTypeName");
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m155a() {
        return ((Boolean) a("isConnected")).booleanValue();
    }

    /* renamed from: a, reason: collision with other method in class */
    public NetworkInfo.State m153a() {
        return (NetworkInfo.State) a("getState");
    }

    /* renamed from: a, reason: collision with other method in class */
    public NetworkInfo.DetailedState m152a() {
        return (NetworkInfo.DetailedState) a("getDetailedState");
    }
}
