package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import com.taobao.accs.common.Constants;
import com.xiaomi.push.af;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class db {

    /* renamed from: a, reason: collision with root package name */
    private static volatile db f12625a;

    /* renamed from: a, reason: collision with other field name */
    private Context f304a;

    /* renamed from: a, reason: collision with other field name */
    private final ConcurrentLinkedQueue<b> f305a = new ConcurrentLinkedQueue<>();

    class a extends b {
        a() {
            super();
        }

        @Override // com.xiaomi.push.db.b, com.xiaomi.push.af.b
        public void b() {
            db.this.b();
        }
    }

    class b extends af.b {

        /* renamed from: a, reason: collision with root package name */
        long f12630a = System.currentTimeMillis();

        b() {
        }

        public boolean a() {
            return true;
        }

        @Override // com.xiaomi.push.af.b
        public void b() {
        }

        /* renamed from: b, reason: collision with other method in class */
        final boolean m264b() {
            return System.currentTimeMillis() - this.f12630a > 172800000;
        }
    }

    private db(Context context) {
        this.f304a = context;
        this.f305a.add(new a());
        b(0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        try {
            File file = new File(this.f304a.getFilesDir() + "/.logcache");
            if (file.exists() && file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    file2.delete();
                }
            }
        } catch (NullPointerException unused) {
        }
    }

    private void c() {
        while (!this.f305a.isEmpty()) {
            b bVarPeek = this.f305a.peek();
            if (bVarPeek != null) {
                if (!bVarPeek.m264b() && this.f305a.size() <= 6) {
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.c("remove Expired task");
                this.f305a.remove(bVarPeek);
            }
        }
    }

    public static db a(Context context) {
        if (f12625a == null) {
            synchronized (db.class) {
                if (f12625a == null) {
                    f12625a = new db(context);
                }
            }
        }
        f12625a.f304a = context;
        return f12625a;
    }

    private void b(long j2) {
        if (this.f305a.isEmpty()) {
            return;
        }
        fy.a(new af.b() { // from class: com.xiaomi.push.db.2

            /* renamed from: a, reason: collision with root package name */
            af.b f12628a;

            @Override // com.xiaomi.push.af.b
            public void b() {
                b bVar = (b) db.this.f305a.peek();
                if (bVar == null || !bVar.a()) {
                    return;
                }
                if (db.this.f305a.remove(bVar)) {
                    this.f12628a = bVar;
                }
                af.b bVar2 = this.f12628a;
                if (bVar2 != null) {
                    bVar2.b();
                }
            }

            @Override // com.xiaomi.push.af.b
            /* renamed from: c */
            public void mo265c() {
                af.b bVar = this.f12628a;
                if (bVar != null) {
                    bVar.mo265c();
                }
            }
        }, j2);
    }

    class c extends b {

        /* renamed from: a, reason: collision with root package name */
        int f12632a;

        /* renamed from: a, reason: collision with other field name */
        File f314a;

        /* renamed from: a, reason: collision with other field name */
        String f315a;

        /* renamed from: a, reason: collision with other field name */
        boolean f316a;

        /* renamed from: b, reason: collision with root package name */
        String f12633b;

        /* renamed from: b, reason: collision with other field name */
        boolean f317b;

        c(String str, String str2, File file, boolean z) {
            super();
            this.f315a = str;
            this.f12633b = str2;
            this.f314a = file;
            this.f317b = z;
        }

        private boolean c() throws JSONException {
            int i2;
            int i3 = 0;
            SharedPreferences sharedPreferences = db.this.f304a.getSharedPreferences("log.timestamp", 0);
            String string = sharedPreferences.getString("log.requst", "");
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                JSONObject jSONObject = new JSONObject(string);
                jCurrentTimeMillis = jSONObject.getLong("time");
                i2 = jSONObject.getInt(Constants.KEY_TIMES);
            } catch (JSONException unused) {
                i2 = 0;
            }
            if (System.currentTimeMillis() - jCurrentTimeMillis >= 86400000) {
                jCurrentTimeMillis = System.currentTimeMillis();
            } else {
                if (i2 > 10) {
                    return false;
                }
                i3 = i2;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("time", jCurrentTimeMillis);
                jSONObject2.put(Constants.KEY_TIMES, i3 + 1);
                sharedPreferences.edit().putString("log.requst", jSONObject2.toString()).commit();
            } catch (JSONException e2) {
                com.xiaomi.channel.commonutils.logger.b.c("JSONException on put " + e2.getMessage());
            }
            return true;
        }

        @Override // com.xiaomi.push.db.b
        public boolean a() {
            return au.d(db.this.f304a) || (this.f317b && au.m151a(db.this.f304a));
        }

        @Override // com.xiaomi.push.db.b, com.xiaomi.push.af.b
        public void b() {
            try {
                if (c()) {
                    HashMap map = new HashMap();
                    map.put("uid", com.xiaomi.push.service.ax.m705a());
                    map.put("token", this.f12633b);
                    map.put("net", au.m147a(db.this.f304a));
                    au.a(this.f315a, map, this.f314a, "file");
                }
                this.f316a = true;
            } catch (IOException unused) {
            }
        }

        @Override // com.xiaomi.push.af.b
        /* renamed from: c, reason: collision with other method in class */
        public void mo265c() {
            if (!this.f316a) {
                this.f12632a++;
                if (this.f12632a < 3) {
                    db.this.f305a.add(this);
                }
            }
            if (this.f316a || this.f12632a >= 3) {
                this.f314a.delete();
            }
            db.this.a((1 << this.f12632a) * 1000);
        }
    }

    public void a(final String str, final String str2, final Date date, final Date date2, final int i2, final boolean z) {
        this.f305a.add(new b() { // from class: com.xiaomi.push.db.1

            /* renamed from: a, reason: collision with other field name */
            File f307a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.xiaomi.push.db.b, com.xiaomi.push.af.b
            public void b() {
                try {
                    File file = new File(db.this.f304a.getFilesDir() + "/.logcache");
                    if (v.m764a(file)) {
                        file.mkdirs();
                        if (file.isDirectory()) {
                            da daVar = new da();
                            daVar.a(i2);
                            this.f307a = daVar.a(db.this.f304a, date, date2, file);
                        }
                    }
                } catch (NullPointerException unused) {
                }
            }

            @Override // com.xiaomi.push.af.b
            /* renamed from: c */
            public void mo265c() {
                File file = this.f307a;
                if (file != null && file.exists()) {
                    db.this.f305a.add(db.this.new c(str, str2, this.f307a, z));
                }
                db.this.a(0L);
            }
        });
        b(0L);
    }

    public void a() {
        c();
        a(0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j2) {
        b bVarPeek = this.f305a.peek();
        if (bVarPeek == null || !bVarPeek.a()) {
            return;
        }
        b(j2);
    }
}
