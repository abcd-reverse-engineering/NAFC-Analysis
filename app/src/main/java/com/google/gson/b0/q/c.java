package com.google.gson.b0.q;

import com.google.gson.t;
import com.google.gson.y;
import com.google.gson.z;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* compiled from: DateTypeAdapter.java */
/* loaded from: classes.dex */
public final class c extends y<Date> {

    /* renamed from: b, reason: collision with root package name */
    public static final z f5558b = new a();

    /* renamed from: a, reason: collision with root package name */
    private final List<DateFormat> f5559a = new ArrayList();

    /* compiled from: DateTypeAdapter.java */
    class a implements z {
        a() {
        }

        @Override // com.google.gson.z
        public <T> y<T> create(com.google.gson.e eVar, com.google.gson.d0.a<T> aVar) {
            if (aVar.getRawType() == Date.class) {
                return new c();
            }
            return null;
        }
    }

    public c() {
        this.f5559a.add(DateFormat.getDateTimeInstance(2, 2, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.f5559a.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (com.google.gson.b0.f.c()) {
            this.f5559a.add(com.google.gson.b0.l.a(2, 2));
        }
    }

    private Date a(com.google.gson.e0.a aVar) throws IOException {
        String strS = aVar.s();
        synchronized (this.f5559a) {
            Iterator<DateFormat> it = this.f5559a.iterator();
            while (it.hasNext()) {
                try {
                    return it.next().parse(strS);
                } catch (ParseException unused) {
                }
            }
            try {
                return com.google.gson.b0.q.p.a.a(strS, new ParsePosition(0));
            } catch (ParseException e2) {
                throw new t("Failed parsing '" + strS + "' as Date; at path " + aVar.i(), e2);
            }
        }
    }

    @Override // com.google.gson.y
    /* renamed from: read, reason: avoid collision after fix types in other method */
    public Date read2(com.google.gson.e0.a aVar) throws IOException {
        if (aVar.peek() != com.google.gson.e0.c.NULL) {
            return a(aVar);
        }
        aVar.r();
        return null;
    }

    @Override // com.google.gson.y
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void write(com.google.gson.e0.d dVar, Date date) throws IOException {
        String str;
        if (date == null) {
            dVar.j();
            return;
        }
        DateFormat dateFormat = this.f5559a.get(0);
        synchronized (this.f5559a) {
            str = dateFormat.format(date);
        }
        dVar.d(str);
    }
}
