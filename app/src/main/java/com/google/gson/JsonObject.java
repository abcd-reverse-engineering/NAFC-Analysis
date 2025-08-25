package com.google.gson;

import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class JsonObject extends k {
    private final com.google.gson.b0.i<String, k> members = new com.google.gson.b0.i<>(false);

    public void add(String str, k kVar) {
        com.google.gson.b0.i<String, k> iVar = this.members;
        if (kVar == null) {
            kVar = m.f5749a;
        }
        iVar.put(str, kVar);
    }

    public void addProperty(String str, String str2) {
        add(str, str2 == null ? m.f5749a : new p(str2));
    }

    public Map<String, k> asMap() {
        return this.members;
    }

    public Set<Map.Entry<String, k>> entrySet() {
        return this.members.entrySet();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof JsonObject) && ((JsonObject) obj).members.equals(this.members));
    }

    public k get(String str) {
        return this.members.get(str);
    }

    public h getAsJsonArray(String str) {
        return (h) this.members.get(str);
    }

    public JsonObject getAsJsonObject(String str) {
        return (JsonObject) this.members.get(str);
    }

    public p getAsJsonPrimitive(String str) {
        return (p) this.members.get(str);
    }

    public boolean has(String str) {
        return this.members.containsKey(str);
    }

    public int hashCode() {
        return this.members.hashCode();
    }

    public boolean isEmpty() {
        return this.members.size() == 0;
    }

    public Set<String> keySet() {
        return this.members.keySet();
    }

    public k remove(String str) {
        return this.members.remove(str);
    }

    public int size() {
        return this.members.size();
    }

    public void addProperty(String str, Number number) {
        add(str, number == null ? m.f5749a : new p(number));
    }

    @Override // com.google.gson.k
    public JsonObject deepCopy() {
        JsonObject jsonObject = new JsonObject();
        for (Map.Entry<String, k> entry : this.members.entrySet()) {
            jsonObject.add(entry.getKey(), entry.getValue().deepCopy());
        }
        return jsonObject;
    }

    public void addProperty(String str, Boolean bool) {
        add(str, bool == null ? m.f5749a : new p(bool));
    }

    public void addProperty(String str, Character ch) {
        add(str, ch == null ? m.f5749a : new p(ch));
    }
}
