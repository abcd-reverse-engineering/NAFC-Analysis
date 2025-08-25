package com.xiaomi.push;

import android.text.TextUtils;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
class cd {

    /* renamed from: a, reason: collision with root package name */
    private String f12549a;

    /* renamed from: a, reason: collision with other field name */
    private final ArrayList<cc> f252a = new ArrayList<>();

    public cd(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        this.f12549a = str;
    }

    public synchronized void a(cc ccVar) {
        int i2 = 0;
        while (true) {
            if (i2 >= this.f252a.size()) {
                break;
            }
            if (this.f252a.get(i2).a(ccVar)) {
                this.f252a.set(i2, ccVar);
                break;
            }
            i2++;
        }
        if (i2 >= this.f252a.size()) {
            this.f252a.add(ccVar);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f12549a);
        sb.append("\n");
        Iterator<cc> it = this.f252a.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }
        return sb.toString();
    }

    public cd() {
    }

    public synchronized cc a() {
        for (int size = this.f252a.size() - 1; size >= 0; size--) {
            cc ccVar = this.f252a.get(size);
            if (ccVar.m221a()) {
                cg.a().m232a(ccVar.a());
                return ccVar;
            }
        }
        return null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public ArrayList<cc> m223a() {
        return this.f252a;
    }

    public synchronized void a(boolean z) {
        for (int size = this.f252a.size() - 1; size >= 0; size--) {
            cc ccVar = this.f252a.get(size);
            if (z) {
                if (ccVar.c()) {
                    this.f252a.remove(size);
                }
            } else if (!ccVar.b()) {
                this.f252a.remove(size);
            }
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m222a() {
        return this.f12549a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized JSONObject m224a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put(Constants.KEY_HOST, this.f12549a);
        JSONArray jSONArray = new JSONArray();
        Iterator<cc> it = this.f252a.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().m219a());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    public synchronized cd a(JSONObject jSONObject) {
        this.f12549a = jSONObject.getString(Constants.KEY_HOST);
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            this.f252a.add(new cc(this.f12549a).a(jSONArray.getJSONObject(i2)));
        }
        return this;
    }
}
