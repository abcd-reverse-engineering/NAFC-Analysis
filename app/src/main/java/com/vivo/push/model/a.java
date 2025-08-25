package com.vivo.push.model;

/* compiled from: ConfigItem.java */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private String f12112a;

    /* renamed from: b, reason: collision with root package name */
    private String f12113b;

    public a(String str, String str2) {
        this.f12112a = str;
        this.f12113b = str2;
    }

    public final String a() {
        return this.f12112a;
    }

    public final String b() {
        return this.f12113b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        String str = this.f12112a;
        if (str == null) {
            if (aVar.f12112a != null) {
                return false;
            }
        } else if (!str.equals(aVar.f12112a)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.f12112a;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public final String toString() {
        return "ConfigItem{mKey='" + this.f12112a + "', mValue='" + this.f12113b + "'}";
    }
}
