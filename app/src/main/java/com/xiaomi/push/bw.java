package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.xiaomi.push.ae;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class bw {

    /* renamed from: a, reason: collision with root package name */
    private static volatile bw f12520a;

    /* renamed from: a, reason: collision with other field name */
    private Context f228a;

    /* renamed from: a, reason: collision with other field name */
    private bv f229a;

    /* renamed from: a, reason: collision with other field name */
    private final HashMap<String, bu> f231a = new HashMap<>();

    /* renamed from: a, reason: collision with other field name */
    private ThreadPoolExecutor f232a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: a, reason: collision with other field name */
    private final ArrayList<a> f230a = new ArrayList<>();

    public static class d extends a {

        /* renamed from: a, reason: collision with root package name */
        private String f12531a;

        /* renamed from: a, reason: collision with other field name */
        protected String[] f242a;

        public d(String str, String str2, String[] strArr) {
            super(str);
            this.f12531a = str2;
            this.f242a = strArr;
        }

        @Override // com.xiaomi.push.bw.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.delete(this.f12523b, this.f12531a, this.f242a);
        }
    }

    public static class e extends a {

        /* renamed from: a, reason: collision with root package name */
        private ContentValues f12532a;

        public e(String str, ContentValues contentValues) {
            super(str);
            this.f12532a = contentValues;
        }

        @Override // com.xiaomi.push.bw.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.insert(this.f12523b, null, this.f12532a);
        }
    }

    private bw(Context context) {
        this.f228a = context;
    }

    public void b(a aVar) {
        bu buVarA;
        if (aVar == null) {
            return;
        }
        if (this.f229a == null) {
            throw new IllegalStateException("should exec init method first!");
        }
        String strM194a = aVar.m194a();
        synchronized (this.f231a) {
            buVarA = this.f231a.get(strM194a);
            if (buVarA == null) {
                buVarA = this.f229a.a(this.f228a, strM194a);
                this.f231a.put(strM194a, buVarA);
            }
        }
        if (this.f232a.isShutdown()) {
            return;
        }
        aVar.a(buVarA, this.f228a);
        a((Runnable) aVar);
    }

    public static class c extends a {

        /* renamed from: a, reason: collision with root package name */
        private ArrayList<a> f12530a;

        public c(String str, ArrayList<a> arrayList) {
            super(str);
            this.f12530a = new ArrayList<>();
            this.f12530a.addAll(arrayList);
        }

        @Override // com.xiaomi.push.bw.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            Iterator<a> it = this.f12530a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.a(context, sQLiteDatabase);
                }
            }
        }

        @Override // com.xiaomi.push.bw.a
        public final void a(Context context) {
            super.a(context);
            Iterator<a> it = this.f12530a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.a(context);
                }
            }
        }
    }

    public static bw a(Context context) {
        if (f12520a == null) {
            synchronized (bw.class) {
                if (f12520a == null) {
                    f12520a = new bw(context);
                }
            }
        }
        return f12520a;
    }

    public static abstract class a implements Runnable {

        /* renamed from: a, reason: collision with other field name */
        private a f234a;

        /* renamed from: a, reason: collision with other field name */
        private String f235a;

        /* renamed from: a, reason: collision with other field name */
        private WeakReference<Context> f236a;

        /* renamed from: b, reason: collision with root package name */
        protected String f12523b;

        /* renamed from: a, reason: collision with other field name */
        protected bu f233a = null;

        /* renamed from: a, reason: collision with other field name */
        private Random f237a = new Random();

        /* renamed from: a, reason: collision with root package name */
        private int f12522a = 0;

        public a(String str) {
            this.f235a = str;
        }

        /* renamed from: a, reason: collision with other method in class */
        public Object mo193a() {
            return null;
        }

        public abstract void a(Context context, SQLiteDatabase sQLiteDatabase);

        void a(bu buVar, Context context) {
            this.f233a = buVar;
            this.f12523b = this.f233a.a();
            this.f236a = new WeakReference<>(context);
        }

        public void b(Context context) {
        }

        @Override // java.lang.Runnable
        public final void run() throws IOException {
            final Context context;
            WeakReference<Context> weakReference = this.f236a;
            if (weakReference == null || (context = weakReference.get()) == null || context.getFilesDir() == null || this.f233a == null || TextUtils.isEmpty(this.f235a)) {
                return;
            }
            File file = new File(this.f235a);
            u.a(context, new File(file.getParentFile(), ba.b(file.getAbsolutePath())), new Runnable() { // from class: com.xiaomi.push.bw.a.1
                @Override // java.lang.Runnable
                public void run() {
                    SQLiteDatabase sQLiteDatabaseA = null;
                    try {
                        try {
                            sQLiteDatabaseA = a.this.a();
                            if (sQLiteDatabaseA != null && sQLiteDatabaseA.isOpen()) {
                                sQLiteDatabaseA.beginTransaction();
                                a.this.a(context, sQLiteDatabaseA);
                                sQLiteDatabaseA.setTransactionSuccessful();
                            }
                            if (sQLiteDatabaseA != null) {
                                try {
                                    sQLiteDatabaseA.endTransaction();
                                } catch (Exception e2) {
                                    e = e2;
                                    com.xiaomi.channel.commonutils.logger.b.a(e);
                                    a.this.a(context);
                                }
                            }
                            if (a.this.f233a != null) {
                                a.this.f233a.close();
                            }
                        } catch (Exception e3) {
                            com.xiaomi.channel.commonutils.logger.b.a(e3);
                            if (sQLiteDatabaseA != null) {
                                try {
                                    sQLiteDatabaseA.endTransaction();
                                } catch (Exception e4) {
                                    e = e4;
                                    com.xiaomi.channel.commonutils.logger.b.a(e);
                                    a.this.a(context);
                                }
                            }
                            if (a.this.f233a != null) {
                                a.this.f233a.close();
                            }
                        }
                        a.this.a(context);
                    } catch (Throwable th) {
                        if (sQLiteDatabaseA != null) {
                            try {
                                sQLiteDatabaseA.endTransaction();
                            } catch (Exception e5) {
                                com.xiaomi.channel.commonutils.logger.b.a(e5);
                                a.this.a(context);
                                throw th;
                            }
                        }
                        if (a.this.f233a != null) {
                            a.this.f233a.close();
                        }
                        a.this.a(context);
                        throw th;
                    }
                }
            });
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m195a() {
            return this.f233a == null || TextUtils.isEmpty(this.f12523b) || this.f236a == null;
        }

        public void a(a aVar) {
            this.f234a = aVar;
        }

        public void a(Context context, Object obj) {
            bw.a(context).a(this);
        }

        /* renamed from: a, reason: collision with other method in class */
        public String m194a() {
            return this.f235a;
        }

        public SQLiteDatabase a() {
            return this.f233a.getWritableDatabase();
        }

        void a(Context context) {
            a aVar = this.f234a;
            if (aVar != null) {
                aVar.a(context, mo193a());
            }
            b(context);
        }
    }

    private void a() {
        ae.a(this.f228a).b(new ae.a() { // from class: com.xiaomi.push.bw.1
            @Override // com.xiaomi.push.ae.a
            /* renamed from: a */
            public String mo183a() {
                return "100957";
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (bw.this.f230a) {
                    if (bw.this.f230a.size() > 0) {
                        if (bw.this.f230a.size() > 1) {
                            bw.this.a(bw.this.f230a);
                        } else {
                            bw.this.b((a) bw.this.f230a.get(0));
                        }
                        bw.this.f230a.clear();
                        System.gc();
                    }
                }
            }
        }, com.xiaomi.push.service.ah.a(this.f228a).a(gk.StatDataProcessFrequency.a(), 5));
    }

    public static abstract class b<T> extends a {

        /* renamed from: a, reason: collision with root package name */
        private int f12525a;

        /* renamed from: a, reason: collision with other field name */
        private String f239a;

        /* renamed from: a, reason: collision with other field name */
        private List<String> f240a;

        /* renamed from: a, reason: collision with other field name */
        private String[] f241a;

        /* renamed from: b, reason: collision with root package name */
        private List<T> f12526b;

        /* renamed from: c, reason: collision with root package name */
        private String f12527c;

        /* renamed from: d, reason: collision with root package name */
        private String f12528d;

        /* renamed from: e, reason: collision with root package name */
        private String f12529e;

        public b(String str, List<String> list, String str2, String[] strArr, String str3, String str4, String str5, int i2) {
            super(str);
            this.f12526b = new ArrayList();
            this.f240a = list;
            this.f239a = str2;
            this.f241a = strArr;
            this.f12527c = str3;
            this.f12528d = str4;
            this.f12529e = str5;
            this.f12525a = i2;
        }

        public abstract T a(Context context, Cursor cursor);

        @Override // com.xiaomi.push.bw.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            String[] strArr;
            this.f12526b.clear();
            List<String> list = this.f240a;
            if (list == null || list.size() <= 0) {
                strArr = null;
            } else {
                String[] strArr2 = new String[this.f240a.size()];
                this.f240a.toArray(strArr2);
                strArr = strArr2;
            }
            int i2 = this.f12525a;
            Cursor cursorQuery = sQLiteDatabase.query(super.f12523b, strArr, this.f239a, this.f241a, this.f12527c, this.f12528d, this.f12529e, i2 > 0 ? String.valueOf(i2) : null);
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                do {
                    T tA = a(context, cursorQuery);
                    if (tA != null) {
                        this.f12526b.add(tA);
                    }
                } while (cursorQuery.moveToNext());
                cursorQuery.close();
            }
            a(context, (List) this.f12526b);
        }

        public abstract void a(Context context, List<T> list);

        @Override // com.xiaomi.push.bw.a
        public SQLiteDatabase a() {
            return ((a) this).f233a.getReadableDatabase();
        }
    }

    public void a(a aVar) {
        bu buVarA;
        if (aVar == null) {
            return;
        }
        if (this.f229a != null) {
            String strM194a = aVar.m194a();
            synchronized (this.f231a) {
                buVarA = this.f231a.get(strM194a);
                if (buVarA == null) {
                    buVarA = this.f229a.a(this.f228a, strM194a);
                    this.f231a.put(strM194a, buVarA);
                }
            }
            if (this.f232a.isShutdown()) {
                return;
            }
            aVar.a(buVarA, this.f228a);
            synchronized (this.f230a) {
                this.f230a.add(aVar);
                a();
            }
            return;
        }
        throw new IllegalStateException("should exec init method first!");
    }

    public void a(Runnable runnable) {
        if (this.f232a.isShutdown()) {
            return;
        }
        this.f232a.execute(runnable);
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m192a(String str) {
        return a(str).a();
    }

    public void a(ArrayList<a> arrayList) {
        if (this.f229a != null) {
            HashMap map = new HashMap();
            if (this.f232a.isShutdown()) {
                return;
            }
            Iterator<a> it = arrayList.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next.m195a()) {
                    next.a(a(next.m194a()), this.f228a);
                }
                ArrayList arrayList2 = (ArrayList) map.get(next.m194a());
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    map.put(next.m194a(), arrayList2);
                }
                arrayList2.add(next);
            }
            for (String str : map.keySet()) {
                ArrayList arrayList3 = (ArrayList) map.get(str);
                if (arrayList3 != null && arrayList3.size() > 0) {
                    c cVar = new c(str, arrayList3);
                    cVar.a(((a) arrayList3.get(0)).f233a, this.f228a);
                    this.f232a.execute(cVar);
                }
            }
            return;
        }
        throw new IllegalStateException("should exec setDbHelperFactory method first!");
    }

    private bu a(String str) {
        bu buVarA = this.f231a.get(str);
        if (buVarA == null) {
            synchronized (this.f231a) {
                if (buVarA == null) {
                    buVarA = this.f229a.a(this.f228a, str);
                    this.f231a.put(str, buVarA);
                }
            }
        }
        return buVarA;
    }
}
