package com.google.gson.b0.t;

import com.google.gson.e;
import com.google.gson.t;
import com.google.gson.y;
import com.google.gson.z;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: SqlTimeTypeAdapter.java */
/* loaded from: classes.dex */
final class b extends y<Time> {

    /* renamed from: b, reason: collision with root package name */
    static final z f5672b = new a();

    /* renamed from: a, reason: collision with root package name */
    private final DateFormat f5673a;

    /* compiled from: SqlTimeTypeAdapter.java */
    class a implements z {
        a() {
        }

        @Override // com.google.gson.z
        public <T> y<T> create(e eVar, com.google.gson.d0.a<T> aVar) {
            a aVar2 = null;
            if (aVar.getRawType() == Time.class) {
                return new b(aVar2);
            }
            return null;
        }
    }

    /* synthetic */ b(a aVar) {
        this();
    }

    @Override // com.google.gson.y
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void write(com.google.gson.e0.d dVar, Time time) throws IOException {
        String str;
        if (time == null) {
            dVar.j();
            return;
        }
        synchronized (this) {
            str = this.f5673a.format((Date) time);
        }
        dVar.d(str);
    }

    private b() {
        this.f5673a = new SimpleDateFormat("hh:mm:ss a");
    }

    @Override // com.google.gson.y
    /* renamed from: read, reason: avoid collision after fix types in other method */
    public Time read2(com.google.gson.e0.a aVar) throws IOException {
        Time time;
        if (aVar.peek() == com.google.gson.e0.c.NULL) {
            aVar.r();
            return null;
        }
        String strS = aVar.s();
        try {
            synchronized (this) {
                time = new Time(this.f5673a.parse(strS).getTime());
            }
            return time;
        } catch (ParseException e2) {
            throw new t("Failed parsing '" + strS + "' as SQL Time; at path " + aVar.i(), e2);
        }
    }
}
