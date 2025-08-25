package com.google.gson.b0.t;

import com.google.gson.e;
import com.google.gson.t;
import com.google.gson.y;
import com.google.gson.z;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* compiled from: SqlDateTypeAdapter.java */
/* loaded from: classes.dex */
final class a extends y<Date> {

    /* renamed from: b, reason: collision with root package name */
    static final z f5670b = new C0089a();

    /* renamed from: a, reason: collision with root package name */
    private final DateFormat f5671a;

    /* compiled from: SqlDateTypeAdapter.java */
    /* renamed from: com.google.gson.b0.t.a$a, reason: collision with other inner class name */
    class C0089a implements z {
        C0089a() {
        }

        @Override // com.google.gson.z
        public <T> y<T> create(e eVar, com.google.gson.d0.a<T> aVar) {
            C0089a c0089a = null;
            if (aVar.getRawType() == Date.class) {
                return new a(c0089a);
            }
            return null;
        }
    }

    /* synthetic */ a(C0089a c0089a) {
        this();
    }

    @Override // com.google.gson.y
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void write(com.google.gson.e0.d dVar, Date date) throws IOException {
        String str;
        if (date == null) {
            dVar.j();
            return;
        }
        synchronized (this) {
            str = this.f5671a.format((java.util.Date) date);
        }
        dVar.d(str);
    }

    private a() {
        this.f5671a = new SimpleDateFormat("MMM d, yyyy");
    }

    @Override // com.google.gson.y
    /* renamed from: read, reason: avoid collision after fix types in other method */
    public Date read2(com.google.gson.e0.a aVar) throws IOException {
        java.util.Date date;
        if (aVar.peek() == com.google.gson.e0.c.NULL) {
            aVar.r();
            return null;
        }
        String strS = aVar.s();
        try {
            synchronized (this) {
                date = this.f5671a.parse(strS);
            }
            return new Date(date.getTime());
        } catch (ParseException e2) {
            throw new t("Failed parsing '" + strS + "' as SQL Date; at path " + aVar.i(), e2);
        }
    }
}
