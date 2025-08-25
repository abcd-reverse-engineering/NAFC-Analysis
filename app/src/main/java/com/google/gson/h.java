package com.google.gson;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: JsonArray.java */
/* loaded from: classes.dex */
public final class h extends k implements Iterable<k> {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<k> f5748a;

    public h() {
        this.f5748a = new ArrayList<>();
    }

    public void a(Boolean bool) {
        this.f5748a.add(bool == null ? m.f5749a : new p(bool));
    }

    public boolean b(k kVar) {
        return this.f5748a.contains(kVar);
    }

    public boolean c(k kVar) {
        return this.f5748a.remove(kVar);
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof h) && ((h) obj).f5748a.equals(this.f5748a));
    }

    public k get(int i2) {
        return this.f5748a.get(i2);
    }

    @Override // com.google.gson.k
    public BigDecimal getAsBigDecimal() {
        return b().getAsBigDecimal();
    }

    @Override // com.google.gson.k
    public BigInteger getAsBigInteger() {
        return b().getAsBigInteger();
    }

    @Override // com.google.gson.k
    public boolean getAsBoolean() {
        return b().getAsBoolean();
    }

    @Override // com.google.gson.k
    public byte getAsByte() {
        return b().getAsByte();
    }

    @Override // com.google.gson.k
    @Deprecated
    public char getAsCharacter() {
        return b().getAsCharacter();
    }

    @Override // com.google.gson.k
    public double getAsDouble() {
        return b().getAsDouble();
    }

    @Override // com.google.gson.k
    public float getAsFloat() {
        return b().getAsFloat();
    }

    @Override // com.google.gson.k
    public int getAsInt() {
        return b().getAsInt();
    }

    @Override // com.google.gson.k
    public long getAsLong() {
        return b().getAsLong();
    }

    @Override // com.google.gson.k
    public Number getAsNumber() {
        return b().getAsNumber();
    }

    @Override // com.google.gson.k
    public short getAsShort() {
        return b().getAsShort();
    }

    @Override // com.google.gson.k
    public String getAsString() {
        return b().getAsString();
    }

    public int hashCode() {
        return this.f5748a.hashCode();
    }

    public boolean isEmpty() {
        return this.f5748a.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<k> iterator() {
        return this.f5748a.iterator();
    }

    public k remove(int i2) {
        return this.f5748a.remove(i2);
    }

    public int size() {
        return this.f5748a.size();
    }

    private k b() {
        int size = this.f5748a.size();
        if (size == 1) {
            return this.f5748a.get(0);
        }
        throw new IllegalStateException("Array must have size 1, but has size " + size);
    }

    public void a(Character ch) {
        this.f5748a.add(ch == null ? m.f5749a : new p(ch));
    }

    @Override // com.google.gson.k
    public h deepCopy() {
        if (this.f5748a.isEmpty()) {
            return new h();
        }
        h hVar = new h(this.f5748a.size());
        Iterator<k> it = this.f5748a.iterator();
        while (it.hasNext()) {
            hVar.a(it.next().deepCopy());
        }
        return hVar;
    }

    public h(int i2) {
        this.f5748a = new ArrayList<>(i2);
    }

    public void a(Number number) {
        this.f5748a.add(number == null ? m.f5749a : new p(number));
    }

    public void a(String str) {
        this.f5748a.add(str == null ? m.f5749a : new p(str));
    }

    public void a(k kVar) {
        if (kVar == null) {
            kVar = m.f5749a;
        }
        this.f5748a.add(kVar);
    }

    public void a(h hVar) {
        this.f5748a.addAll(hVar.f5748a);
    }

    public k a(int i2, k kVar) {
        ArrayList<k> arrayList = this.f5748a;
        if (kVar == null) {
            kVar = m.f5749a;
        }
        return arrayList.set(i2, kVar);
    }

    public List<k> a() {
        return new com.google.gson.b0.j(this.f5748a);
    }
}
