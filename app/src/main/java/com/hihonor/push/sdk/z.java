package com.hihonor.push.sdk;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.hihonor.push.sdk.b0;
import com.hihonor.push.sdk.bean.RemoteServiceBean;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class z implements Handler.Callback {

    /* renamed from: c, reason: collision with root package name */
    public static final z f6357c = new z();

    /* renamed from: a, reason: collision with root package name */
    public final Handler f6358a;

    /* renamed from: b, reason: collision with root package name */
    public final Map<w, a> f6359b = new ConcurrentHashMap(5, 0.75f, 1);

    public static class b implements i0 {

        /* renamed from: a, reason: collision with root package name */
        public f1<?> f6366a;

        public b(f1<?> f1Var) {
            this.f6366a = f1Var;
        }
    }

    public z() {
        HandlerThread handlerThread = new HandlerThread("HonorApiManager");
        handlerThread.start();
        this.f6358a = new Handler(handlerThread.getLooper(), this);
    }

    public <TResult> a1<TResult> a(f1<TResult> f1Var) {
        n0<TResult> n0Var = new n0<>();
        f1Var.f6276a = n0Var;
        Handler handler = this.f6358a;
        handler.sendMessage(handler.obtainMessage(1, f1Var));
        return n0Var.f6310a;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        a aVar;
        int i2 = message.what;
        if (i2 != 1) {
            if (i2 != 2) {
                return false;
            }
            f1 f1Var = (f1) message.obj;
            w wVar = f1Var.f6279d;
            if (wVar != null && this.f6359b.containsKey(wVar) && (aVar = this.f6359b.get(wVar)) != null) {
                synchronized (aVar) {
                    String str = "resolveResult apiCall " + f1Var.f6277b;
                    aVar.f6361b.remove(f1Var);
                    if (aVar.f6360a.peek() == null || aVar.f6361b.peek() == null) {
                        aVar.a();
                        z.this.f6359b.remove(aVar.f6364e);
                    }
                }
            }
            return true;
        }
        f1<?> f1Var2 = (f1) message.obj;
        w wVar2 = f1Var2.f6279d;
        a aVar2 = this.f6359b.get(wVar2);
        if (aVar2 == null) {
            aVar2 = new a(wVar2);
            this.f6359b.put(wVar2, aVar2);
        }
        synchronized (aVar2) {
            com.hihonor.push.sdk.b.a(z.this.f6358a);
            String str2 = "sendRequest " + f1Var2.f6277b;
            if (((d0) aVar2.f6362c).a()) {
                aVar2.a(f1Var2);
            } else {
                aVar2.f6360a.add(f1Var2);
                HonorPushErrorEnum honorPushErrorEnum = aVar2.f6363d;
                if (honorPushErrorEnum == null || honorPushErrorEnum.getErrorCode() == 0) {
                    synchronized (aVar2) {
                        com.hihonor.push.sdk.b.a(z.this.f6358a);
                        if (!((d0) aVar2.f6362c).a()) {
                            if (!(((d0) aVar2.f6362c).f6261a.get() == 5)) {
                                d0 d0Var = (d0) aVar2.f6362c;
                                d0Var.getClass();
                                int i3 = d0Var.f6261a.get();
                                String str3 = "enter connect, connection Status: " + i3;
                                if (i3 != 3 && i3 != 5 && i3 != 4) {
                                    l lVar = l.f6299e;
                                    int iB = com.hihonor.push.sdk.b.b(lVar.a());
                                    if (iB == HonorPushErrorEnum.SUCCESS.getErrorCode()) {
                                        d0Var.f6261a.set(5);
                                        RemoteServiceBean remoteServiceBeanA = com.hihonor.push.sdk.b.a(lVar.a());
                                        f0 f0Var = new f0(remoteServiceBeanA);
                                        d0Var.f6264d = f0Var;
                                        f0Var.f6273b = new c0(d0Var);
                                        if (remoteServiceBeanA.checkServiceInfo()) {
                                            Intent intent = new Intent();
                                            String packageName = f0Var.f6272a.getPackageName();
                                            String packageAction = f0Var.f6272a.getPackageAction();
                                            String packageServiceName = f0Var.f6272a.getPackageServiceName();
                                            if (TextUtils.isEmpty(packageServiceName)) {
                                                intent.setAction(packageAction);
                                                intent.setPackage(packageName);
                                            } else {
                                                intent.setComponent(new ComponentName(packageName, packageServiceName));
                                            }
                                            synchronized (f0.f6271e) {
                                                if (lVar.a().bindService(intent, f0Var, 1)) {
                                                    Handler handler = f0Var.f6274c;
                                                    if (handler != null) {
                                                        handler.removeMessages(1001);
                                                    } else {
                                                        f0Var.f6274c = new Handler(Looper.getMainLooper(), new e0(f0Var));
                                                    }
                                                    f0Var.f6274c.sendEmptyMessageDelayed(1001, com.heytap.mcssdk.constant.a.q);
                                                } else {
                                                    f0Var.f6275d = true;
                                                    f0Var.a(8002001);
                                                }
                                            }
                                        } else {
                                            String str4 = "bind core is null : " + f0Var.f6272a;
                                            f0Var.a(8002004);
                                        }
                                    } else {
                                        d0Var.a(iB);
                                    }
                                }
                            }
                        }
                    }
                } else {
                    aVar2.a(aVar2.f6363d);
                }
            }
        }
        return true;
    }

    public class a implements b0.a {

        /* renamed from: a, reason: collision with root package name */
        public final Queue<f1<?>> f6360a = new LinkedList();

        /* renamed from: b, reason: collision with root package name */
        public final Queue<f1<?>> f6361b = new LinkedList();

        /* renamed from: c, reason: collision with root package name */
        public final b0 f6362c = new d0(this);

        /* renamed from: d, reason: collision with root package name */
        public HonorPushErrorEnum f6363d = null;

        /* renamed from: e, reason: collision with root package name */
        public final w f6364e;

        public a(w wVar) {
            this.f6364e = wVar;
        }

        public final synchronized void a(HonorPushErrorEnum honorPushErrorEnum) {
            com.hihonor.push.sdk.b.a(z.this.f6358a);
            Iterator<f1<?>> it = this.f6360a.iterator();
            while (it.hasNext()) {
                it.next().b(honorPushErrorEnum.toApiException(), null);
            }
            this.f6360a.clear();
            this.f6363d = honorPushErrorEnum;
            a();
            z.this.f6359b.remove(this.f6364e);
        }

        public final synchronized void b() {
            com.hihonor.push.sdk.b.a(z.this.f6358a);
            this.f6363d = null;
            Iterator<f1<?>> it = this.f6360a.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            this.f6360a.clear();
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x0089 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final synchronized void a(com.hihonor.push.sdk.f1<?> r8) {
            /*
                r7 = this;
                monitor-enter(r7)
                java.util.Queue<com.hihonor.push.sdk.f1<?>> r0 = r7.f6361b     // Catch: java.lang.Throwable -> La0
                r0.add(r8)     // Catch: java.lang.Throwable -> La0
                com.hihonor.push.sdk.b0 r0 = r7.f6362c     // Catch: java.lang.Throwable -> La0
                com.hihonor.push.sdk.z$b r1 = new com.hihonor.push.sdk.z$b     // Catch: java.lang.Throwable -> La0
                r1.<init>(r8)     // Catch: java.lang.Throwable -> La0
                com.hihonor.push.sdk.h0 r2 = new com.hihonor.push.sdk.h0     // Catch: java.lang.Throwable -> La0
                r8.getClass()     // Catch: java.lang.Throwable -> La0
                r3 = 0
                java.lang.Class r4 = r8.getClass()     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> La0
                java.lang.reflect.Type r4 = r4.getGenericSuperclass()     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> La0
                if (r4 == 0) goto L2b
                java.lang.reflect.ParameterizedType r4 = (java.lang.reflect.ParameterizedType) r4     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> La0
                java.lang.reflect.Type[] r4 = r4.getActualTypeArguments()     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> La0
                r5 = 0
                r4 = r4[r5]     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> La0
                if (r4 == 0) goto L2b
                java.lang.Class r4 = (java.lang.Class) r4     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> La0
                goto L2c
            L2b:
                r4 = r3
            L2c:
                if (r4 == 0) goto L53
                boolean r5 = r4.isPrimitive()     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> La0
                if (r5 == 0) goto L35
                goto L53
            L35:
                java.lang.Object r3 = r4.newInstance()     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> La0
                goto L53
            L3a:
                r4 = move-exception
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La0
                r5.<init>()     // Catch: java.lang.Throwable -> La0
                java.lang.String r6 = "In newResponseInstance, instancing exception."
                r5.append(r6)     // Catch: java.lang.Throwable -> La0
                java.lang.String r4 = r4.getMessage()     // Catch: java.lang.Throwable -> La0
                r5.append(r4)     // Catch: java.lang.Throwable -> La0
                java.lang.String r4 = r5.toString()     // Catch: java.lang.Throwable -> La0
                com.hihonor.push.sdk.c.a(r4)     // Catch: java.lang.Throwable -> La0
            L53:
                r2.<init>(r3, r1)     // Catch: java.lang.Throwable -> La0
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La0
                r1.<init>()     // Catch: java.lang.Throwable -> La0
                java.lang.String r3 = "start transport parse. "
                r1.append(r3)     // Catch: java.lang.Throwable -> La0
                java.lang.String r3 = r8.f6277b     // Catch: java.lang.Throwable -> La0
                r1.append(r3)     // Catch: java.lang.Throwable -> La0
                r1.toString()     // Catch: java.lang.Throwable -> La0
                com.hihonor.push.sdk.d0 r0 = (com.hihonor.push.sdk.d0) r0     // Catch: java.lang.Throwable -> La0
                com.hihonor.push.framework.aidl.IPushInvoke r0 = r0.f6262b     // Catch: java.lang.Throwable -> La0
                java.lang.String r1 = r8.f6277b     // Catch: java.lang.Throwable -> La0
                com.hihonor.push.framework.aidl.entity.RequestHeader r3 = r8.f6280e     // Catch: java.lang.Throwable -> La0
                com.hihonor.push.framework.aidl.IMessageEntity r8 = r8.f6278c     // Catch: java.lang.Throwable -> La0
                android.os.Bundle r4 = new android.os.Bundle     // Catch: java.lang.Throwable -> La0
                r4.<init>()     // Catch: java.lang.Throwable -> La0
                android.os.Bundle r5 = new android.os.Bundle     // Catch: java.lang.Throwable -> La0
                r5.<init>()     // Catch: java.lang.Throwable -> La0
                com.hihonor.push.framework.aidl.MessageCodec.formMessageEntity(r3, r4)     // Catch: java.lang.Throwable -> La0
                com.hihonor.push.framework.aidl.MessageCodec.formMessageEntity(r8, r5)     // Catch: java.lang.Throwable -> La0
                com.hihonor.push.framework.aidl.DataBuffer r8 = new com.hihonor.push.framework.aidl.DataBuffer     // Catch: java.lang.Throwable -> La0
                r8.<init>(r1, r4, r5)     // Catch: java.lang.Throwable -> La0
                if (r0 == 0) goto L9e
                r0.call(r8, r2)     // Catch: java.lang.Exception -> L8d java.lang.Throwable -> La0
                goto L9e
            L8d:
                r8 = move-exception
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La0
                r0.<init>()     // Catch: java.lang.Throwable -> La0
                java.lang.String r1 = "transport remote error. "
                r0.append(r1)     // Catch: java.lang.Throwable -> La0
                r0.append(r8)     // Catch: java.lang.Throwable -> La0
                r0.toString()     // Catch: java.lang.Throwable -> La0
            L9e:
                monitor-exit(r7)
                return
            La0:
                r8 = move-exception
                monitor-exit(r7)
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hihonor.push.sdk.z.a.a(com.hihonor.push.sdk.f1):void");
        }

        public void a() {
            com.hihonor.push.sdk.b.a(z.this.f6358a);
            d0 d0Var = (d0) this.f6362c;
            int i2 = d0Var.f6261a.get();
            String str = "enter disconnect, connection Status: " + i2;
            if (i2 != 3) {
                if (i2 != 5) {
                    return;
                }
                d0Var.f6261a.set(4);
            } else {
                f0 f0Var = d0Var.f6264d;
                if (f0Var != null) {
                    f0Var.b();
                }
                d0Var.f6261a.set(1);
            }
        }
    }
}
