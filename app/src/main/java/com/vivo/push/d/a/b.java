package com.vivo.push.d.a;

import android.text.TextUtils;
import com.vivo.push.restructure.request.a.a.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

/* compiled from: SyncProfileInfoInputDS.java */
/* loaded from: classes2.dex */
public final class b implements com.vivo.push.restructure.request.a.a.b {

    /* renamed from: a, reason: collision with root package name */
    public static final b.a<b> f12000a = new c();

    /* renamed from: b, reason: collision with root package name */
    private String f12001b;

    /* renamed from: c, reason: collision with root package name */
    private List<com.vivo.push.d.b> f12002c;

    /* renamed from: d, reason: collision with root package name */
    private int f12003d;

    public b(String str, List<com.vivo.push.d.b> list, int i2) {
        this.f12002c = new ArrayList();
        this.f12001b = str;
        this.f12003d = i2;
        this.f12002c = list;
    }

    @Override // com.vivo.push.restructure.request.a.a.b
    public final void a(com.vivo.push.restructure.request.a.a.a aVar) {
        aVar.a(this.f12001b);
        aVar.a(this.f12003d);
        aVar.a(this.f12002c);
    }

    public final List<String> a() {
        ArrayList arrayList = new ArrayList();
        Iterator<com.vivo.push.d.b> it = this.f12002c.iterator();
        while (it.hasNext()) {
            String strB = it.next().b();
            if (!TextUtils.isEmpty(strB)) {
                arrayList.add(strB);
            }
        }
        return arrayList;
    }

    protected b(com.vivo.push.restructure.request.a.a.a aVar) throws JSONException {
        this.f12002c = new ArrayList();
        this.f12001b = aVar.c();
        this.f12003d = aVar.a();
        aVar.a(com.vivo.push.d.b.f12004a, this.f12002c);
    }
}
