package com.google.gson.b0.t;

import com.google.gson.e;
import com.google.gson.y;
import com.google.gson.z;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

/* compiled from: SqlTimestampTypeAdapter.java */
/* loaded from: classes.dex */
class c extends y<Timestamp> {

    /* renamed from: b, reason: collision with root package name */
    static final z f5674b = new a();

    /* renamed from: a, reason: collision with root package name */
    private final y<Date> f5675a;

    /* compiled from: SqlTimestampTypeAdapter.java */
    class a implements z {
        a() {
        }

        @Override // com.google.gson.z
        public <T> y<T> create(e eVar, com.google.gson.d0.a<T> aVar) {
            a aVar2 = null;
            if (aVar.getRawType() == Timestamp.class) {
                return new c(eVar.a((Class) Date.class), aVar2);
            }
            return null;
        }
    }

    /* synthetic */ c(y yVar, a aVar) {
        this(yVar);
    }

    @Override // com.google.gson.y
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void write(com.google.gson.e0.d dVar, Timestamp timestamp) throws IOException {
        this.f5675a.write(dVar, timestamp);
    }

    private c(y<Date> yVar) {
        this.f5675a = yVar;
    }

    @Override // com.google.gson.y
    /* renamed from: read, reason: avoid collision after fix types in other method */
    public Timestamp read2(com.google.gson.e0.a aVar) throws IOException {
        Date date = this.f5675a.read2(aVar);
        if (date != null) {
            return new Timestamp(date.getTime());
        }
        return null;
    }
}
