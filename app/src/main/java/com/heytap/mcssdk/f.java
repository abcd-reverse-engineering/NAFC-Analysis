package com.heytap.mcssdk;

import android.content.Context;
import android.content.Intent;
import com.heytap.mcssdk.k.g;
import com.heytap.mcssdk.k.i;
import com.heytap.msp.push.callback.IDataMessageCallBackService;
import com.heytap.msp.push.mode.BaseMode;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class f {

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f5857a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Intent f5858b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ IDataMessageCallBackService f5859c;

        a(Context context, Intent intent, IDataMessageCallBackService iDataMessageCallBackService) {
            this.f5857a = context;
            this.f5858b = intent;
            this.f5859c = iDataMessageCallBackService;
        }

        @Override // java.lang.Runnable
        public void run() throws NumberFormatException {
            List<BaseMode> listA = com.heytap.mcssdk.h.c.a(this.f5857a, this.f5858b);
            if (listA == null) {
                return;
            }
            for (BaseMode baseMode : listA) {
                if (baseMode != null) {
                    for (com.heytap.mcssdk.i.c cVar : com.heytap.mcssdk.a.w().m()) {
                        if (cVar != null) {
                            cVar.a(this.f5857a, baseMode, this.f5859c);
                        }
                    }
                }
            }
        }
    }

    public class b {

        /* renamed from: a, reason: collision with root package name */
        private long f5860a;

        /* renamed from: b, reason: collision with root package name */
        private int f5861b;

        public b(long j2, int i2) {
            this.f5860a = j2;
            this.f5861b = i2;
        }

        public long a() {
            return this.f5860a;
        }

        public void a(int i2) {
            this.f5861b = i2;
        }

        public void a(long j2) {
            this.f5860a = j2;
        }

        public int b() {
            return this.f5861b;
        }
    }

    public class c extends BaseMode {

        /* renamed from: j, reason: collision with root package name */
        private static final String f5862j = "&";

        /* renamed from: a, reason: collision with root package name */
        private String f5863a;

        /* renamed from: b, reason: collision with root package name */
        private String f5864b;

        /* renamed from: c, reason: collision with root package name */
        private String f5865c;

        /* renamed from: d, reason: collision with root package name */
        private String f5866d;

        /* renamed from: e, reason: collision with root package name */
        private int f5867e;

        /* renamed from: f, reason: collision with root package name */
        private String f5868f;

        /* renamed from: g, reason: collision with root package name */
        private int f5869g = -2;

        /* renamed from: h, reason: collision with root package name */
        private String f5870h;

        /* renamed from: i, reason: collision with root package name */
        private String f5871i;

        public static <T> String a(List<T> list) {
            StringBuilder sb = new StringBuilder();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append("&");
            }
            return sb.toString();
        }

        public String a() {
            return this.f5863a;
        }

        public void a(int i2) {
            this.f5867e = i2;
        }

        public void a(String str) {
            this.f5863a = str;
        }

        public String b() {
            return this.f5864b;
        }

        public void b(int i2) {
            this.f5869g = i2;
        }

        public void b(String str) {
            this.f5864b = str;
        }

        public String c() {
            return this.f5865c;
        }

        public void c(String str) {
            this.f5865c = str;
        }

        public String d() {
            return this.f5866d;
        }

        public void d(String str) {
            this.f5866d = str;
        }

        public int e() {
            return this.f5867e;
        }

        public void e(String str) {
            this.f5868f = str;
        }

        public String f() {
            return this.f5868f;
        }

        public void f(String str) {
            this.f5871i = str;
        }

        public int g() {
            return this.f5869g;
        }

        public void g(String str) {
            this.f5870h = str;
        }

        @Override // com.heytap.msp.push.mode.BaseMode
        public int getType() {
            return 4105;
        }

        public String h() {
            return this.f5871i;
        }

        public String i() {
            return this.f5870h;
        }

        public String toString() {
            return "CallBackResult{, mRegisterID='" + this.f5865c + "', mSdkVersion='" + this.f5866d + "', mCommand=" + this.f5867e + "', mContent='" + this.f5868f + "', mAppPackage=" + this.f5870h + "', mResponseCode=" + this.f5869g + ", miniProgramPkg=" + this.f5871i + '}';
        }
    }

    public static void a(Context context, Intent intent, IDataMessageCallBackService iDataMessageCallBackService) {
        if (context == null) {
            g.e("context is null , please check param of parseIntent()");
            return;
        }
        if (intent == null) {
            g.e("intent is null , please check param of parseIntent()");
            return;
        }
        if (iDataMessageCallBackService == null) {
            g.e("callback is null , please check param of parseIntent()");
        } else if (com.heytap.mcssdk.k.c.c(context)) {
            i.a(new a(context, intent, iDataMessageCallBackService));
        } else {
            g.e("push is null ,please check system has push");
        }
    }
}
