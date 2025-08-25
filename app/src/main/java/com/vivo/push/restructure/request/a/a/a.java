package com.vivo.push.restructure.request.a.a;

import com.vivo.push.restructure.request.a.a.c;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: JsonParcel.java */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private int f12188a;

    /* renamed from: b, reason: collision with root package name */
    private int f12189b;

    /* renamed from: c, reason: collision with root package name */
    private JSONArray f12190c;

    public a() {
        this.f12188a = 0;
        this.f12190c = new JSONArray();
    }

    public final void a(int i2) {
        this.f12190c.put(i2);
    }

    public final long b() throws JSONException {
        int i2 = this.f12188a;
        if (i2 >= this.f12189b) {
            return 0L;
        }
        JSONArray jSONArray = this.f12190c;
        this.f12188a = i2 + 1;
        return jSONArray.getLong(i2);
    }

    public final String c() throws JSONException {
        int i2 = this.f12188a;
        if (i2 >= this.f12189b) {
            return null;
        }
        JSONArray jSONArray = this.f12190c;
        this.f12188a = i2 + 1;
        return jSONArray.getString(i2);
    }

    public final String d() {
        JSONArray jSONArray = this.f12190c;
        return jSONArray != null ? jSONArray.toString() : "";
    }

    public final void a(long j2) {
        this.f12190c.put(j2);
    }

    public final void a(String str) {
        this.f12190c.put(str);
    }

    public a(String str) throws JSONException {
        this.f12188a = 0;
        this.f12190c = new JSONArray(str);
        this.f12188a = 0;
        this.f12189b = this.f12190c.length();
    }

    public final <T extends c> void a(List<T> list) {
        if (list != null) {
            this.f12190c.put(list.size());
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                this.f12190c.put(it.next().a());
            }
            return;
        }
        this.f12190c.put((Object) null);
    }

    public final int a() throws JSONException {
        int i2 = this.f12188a;
        if (i2 >= this.f12189b) {
            return 0;
        }
        JSONArray jSONArray = this.f12190c;
        this.f12188a = i2 + 1;
        return jSONArray.getInt(i2);
    }

    public final <T extends c> void a(c.a<T> aVar, List<T> list) throws JSONException {
        T tA;
        int i2 = this.f12188a;
        if (i2 < this.f12189b ? this.f12190c.isNull(i2) : true) {
            this.f12188a++;
            return;
        }
        JSONArray jSONArray = this.f12190c;
        int i3 = this.f12188a;
        this.f12188a = i3 + 1;
        int i4 = jSONArray.getInt(i3);
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = this.f12188a;
            if (i6 < this.f12189b) {
                JSONArray jSONArray2 = this.f12190c;
                this.f12188a = i6 + 1;
                tA = aVar.a(jSONArray2.getString(i6));
            } else {
                tA = null;
            }
            list.add(tA);
        }
    }
}
