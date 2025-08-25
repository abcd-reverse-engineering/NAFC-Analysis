package com.google.gson.b0.q;

import com.google.gson.t;
import com.google.gson.y;
import com.google.gson.z;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/* compiled from: DefaultDateTypeAdapter.java */
/* loaded from: classes.dex */
public final class d<T extends Date> extends y<T> {

    /* renamed from: c, reason: collision with root package name */
    private static final String f5560c = "DefaultDateTypeAdapter";

    /* renamed from: a, reason: collision with root package name */
    private final b<T> f5561a;

    /* renamed from: b, reason: collision with root package name */
    private final List<DateFormat> f5562b;

    /* compiled from: DefaultDateTypeAdapter.java */
    public static abstract class b<T extends Date> {

        /* renamed from: b, reason: collision with root package name */
        public static final b<Date> f5563b = new a(Date.class);

        /* renamed from: a, reason: collision with root package name */
        private final Class<T> f5564a;

        /* compiled from: DefaultDateTypeAdapter.java */
        class a extends b<Date> {
            a(Class cls) {
                super(cls);
            }

            @Override // com.google.gson.b0.q.d.b
            protected Date a(Date date) {
                return date;
            }
        }

        protected b(Class<T> cls) {
            this.f5564a = cls;
        }

        private z a(d<T> dVar) {
            return o.a(this.f5564a, dVar);
        }

        protected abstract T a(Date date);

        public final z a(String str) {
            return a(new d<>(this, str));
        }

        public final z a(int i2) {
            return a(new d<>(this, i2));
        }

        public final z a(int i2, int i3) {
            return a(new d<>(this, i2, i3));
        }

        public final z a() {
            int i2 = 2;
            return a(new d<>(this, i2, i2));
        }
    }

    @Override // com.google.gson.y
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void write(com.google.gson.e0.d dVar, Date date) throws IOException {
        String str;
        if (date == null) {
            dVar.j();
            return;
        }
        DateFormat dateFormat = this.f5562b.get(0);
        synchronized (this.f5562b) {
            str = dateFormat.format(date);
        }
        dVar.d(str);
    }

    public String toString() {
        DateFormat dateFormat = this.f5562b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }

    @Override // com.google.gson.y
    /* renamed from: read */
    public T read2(com.google.gson.e0.a aVar) throws IOException {
        if (aVar.peek() == com.google.gson.e0.c.NULL) {
            aVar.r();
            return null;
        }
        return (T) this.f5561a.a(a(aVar));
    }

    private d(b<T> bVar, String str) {
        this.f5562b = new ArrayList();
        this.f5561a = (b) Objects.requireNonNull(bVar);
        this.f5562b.add(new SimpleDateFormat(str, Locale.US));
        if (Locale.getDefault().equals(Locale.US)) {
            return;
        }
        this.f5562b.add(new SimpleDateFormat(str));
    }

    private Date a(com.google.gson.e0.a aVar) throws IOException {
        String strS = aVar.s();
        synchronized (this.f5562b) {
            Iterator<DateFormat> it = this.f5562b.iterator();
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

    private d(b<T> bVar, int i2) {
        this.f5562b = new ArrayList();
        this.f5561a = (b) Objects.requireNonNull(bVar);
        this.f5562b.add(DateFormat.getDateInstance(i2, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.f5562b.add(DateFormat.getDateInstance(i2));
        }
        if (com.google.gson.b0.f.c()) {
            this.f5562b.add(com.google.gson.b0.l.d(i2));
        }
    }

    private d(b<T> bVar, int i2, int i3) {
        this.f5562b = new ArrayList();
        this.f5561a = (b) Objects.requireNonNull(bVar);
        this.f5562b.add(DateFormat.getDateTimeInstance(i2, i3, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.f5562b.add(DateFormat.getDateTimeInstance(i2, i3));
        }
        if (com.google.gson.b0.f.c()) {
            this.f5562b.add(com.google.gson.b0.l.a(i2, i3));
        }
    }
}
