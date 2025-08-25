package i.e.b.d.a;

import android.database.ContentObserver;

/* compiled from: IdentifierIdObserver.java */
/* loaded from: classes2.dex */
public class d extends ContentObserver {

    /* renamed from: d, reason: collision with root package name */
    private static final String f16965d = "VMS_SDK_Observer";

    /* renamed from: a, reason: collision with root package name */
    private String f16966a;

    /* renamed from: b, reason: collision with root package name */
    private int f16967b;

    /* renamed from: c, reason: collision with root package name */
    private c f16968c;

    d(c cVar, int i2, String str) {
        super(null);
        this.f16968c = cVar;
        this.f16967b = i2;
        this.f16966a = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        c cVar = this.f16968c;
        if (cVar != null) {
            cVar.a(this.f16967b, this.f16966a);
        }
    }
}
