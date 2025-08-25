package com.umeng.message.proguard;

import android.annotation.TargetApi;
import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import com.umeng.message.common.UPLog;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes2.dex */
public abstract class q extends Service {
    private static final String TAG = "BaseService";
    private static final int jobIndex = 21000;
    final ArrayList<d> mCompatQueue;
    h mCompatWorkEnqueuer;
    a mCurProcessor;
    b mJobImpl;
    static final Object sLock = new Object();
    static final HashMap<ComponentName, h> sClassWorkEnqueuer = new HashMap<>();
    private static final HashMap<Class<?>, Integer> jobMap = new HashMap<>();
    private static final Object mRealTimeModeLock = new Object();
    boolean mInterruptIfStopped = false;
    boolean mStopped = false;
    boolean mDestroyed = false;

    static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private q f11405a;

        a(q qVar) {
            this.f11405a = qVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            while (true) {
                try {
                    e eVarDequeueWork = this.f11405a.dequeueWork();
                    if (eVarDequeueWork != null) {
                        this.f11405a.onHandleWork(eVarDequeueWork.a());
                        eVarDequeueWork.b();
                    }
                } catch (Throwable th) {
                    UPLog.e(q.TAG, th);
                }
                try {
                    break;
                } catch (Throwable th2) {
                    UPLog.e(q.TAG, th2);
                }
            }
            this.f11405a.processorFinished();
            this.f11405a = null;
        }
    }

    interface b {
        IBinder a();

        e b();
    }

    final class d implements e {

        /* renamed from: a, reason: collision with root package name */
        final Intent f11411a;

        /* renamed from: b, reason: collision with root package name */
        final int f11412b;

        d(Intent intent, int i2) {
            this.f11411a = intent;
            this.f11412b = i2;
        }

        @Override // com.umeng.message.proguard.q.e
        public final Intent a() {
            return this.f11411a;
        }

        @Override // com.umeng.message.proguard.q.e
        public final void b() {
            try {
                q.this.stopSelf(this.f11412b);
            } catch (Throwable th) {
                UPLog.e(q.TAG, th);
            }
        }
    }

    interface e {
        Intent a();

        void b();
    }

    @TargetApi(26)
    static final class f extends JobServiceEngine implements b {

        /* renamed from: a, reason: collision with root package name */
        final q f11414a;

        /* renamed from: b, reason: collision with root package name */
        final Object f11415b;

        /* renamed from: c, reason: collision with root package name */
        JobParameters f11416c;

        final class a implements e {

            /* renamed from: a, reason: collision with root package name */
            final JobWorkItem f11417a;

            a(JobWorkItem jobWorkItem) {
                this.f11417a = jobWorkItem;
            }

            @Override // com.umeng.message.proguard.q.e
            public final Intent a() {
                return this.f11417a.getIntent();
            }

            @Override // com.umeng.message.proguard.q.e
            public final void b() {
                try {
                    synchronized (f.this.f11415b) {
                        if (f.this.f11416c != null) {
                            try {
                                f.this.f11416c.completeWork(this.f11417a);
                            } catch (Throwable th) {
                                UPLog.e(q.TAG, th);
                            }
                        }
                    }
                } catch (Throwable th2) {
                    UPLog.e(q.TAG, th2);
                }
            }
        }

        f(q qVar) {
            super(qVar);
            this.f11415b = new Object();
            this.f11414a = qVar;
        }

        @Override // com.umeng.message.proguard.q.b
        public final IBinder a() {
            return getBinder();
        }

        @Override // com.umeng.message.proguard.q.b
        public final e b() {
            try {
                synchronized (this.f11415b) {
                    if (this.f11416c == null) {
                        return null;
                    }
                    JobWorkItem jobWorkItemDequeueWork = this.f11416c.dequeueWork();
                    if (jobWorkItemDequeueWork == null) {
                        return null;
                    }
                    jobWorkItemDequeueWork.getIntent().setExtrasClassLoader(this.f11414a.getClassLoader());
                    return new a(jobWorkItemDequeueWork);
                }
            } catch (Throwable th) {
                UPLog.e(q.TAG, th);
                return null;
            }
        }

        @Override // android.app.job.JobServiceEngine
        public final boolean onStartJob(JobParameters jobParameters) {
            this.f11416c = jobParameters;
            this.f11414a.ensureProcessorRunningLocked(false);
            return true;
        }

        @Override // android.app.job.JobServiceEngine
        public final boolean onStopJob(JobParameters jobParameters) {
            boolean zDoStopCurrentWork = this.f11414a.doStopCurrentWork();
            synchronized (this.f11415b) {
                this.f11416c = null;
            }
            return zDoStopCurrentWork;
        }
    }

    @TargetApi(21)
    static final class g extends h {

        /* renamed from: a, reason: collision with root package name */
        private final JobInfo f11419a;

        /* renamed from: b, reason: collision with root package name */
        private JobScheduler f11420b;

        g(Context context, ComponentName componentName, int i2) {
            super(componentName);
            a(i2);
            this.f11419a = new JobInfo.Builder(i2, this.f11421c).setOverrideDeadline(0L).build();
            try {
                this.f11420b = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
            } catch (Throwable th) {
                UPLog.e(q.TAG, th);
            }
        }

        @Override // com.umeng.message.proguard.q.h
        final void a(Intent intent) {
            try {
                if (Build.VERSION.SDK_INT >= 26) {
                    this.f11420b.enqueue(this.f11419a, new JobWorkItem(intent));
                }
            } catch (Throwable th) {
                UPLog.e(q.TAG, th);
            }
        }
    }

    static abstract class h {

        /* renamed from: c, reason: collision with root package name */
        final ComponentName f11421c;

        /* renamed from: d, reason: collision with root package name */
        boolean f11422d;

        /* renamed from: e, reason: collision with root package name */
        int f11423e;

        h(ComponentName componentName) {
            this.f11421c = componentName;
        }

        public void a() {
        }

        final void a(int i2) {
            if (!this.f11422d) {
                this.f11422d = true;
                this.f11423e = i2;
            } else {
                if (this.f11423e == i2) {
                    return;
                }
                throw new IllegalArgumentException("Given job ID " + i2 + " is different than previous " + this.f11423e);
            }
        }

        abstract void a(Intent intent);

        public void b() {
        }

        public void c() {
        }
    }

    public q() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.mCompatQueue = null;
        } else {
            this.mCompatQueue = new ArrayList<>();
        }
    }

    private static void enqueueWork(Context context, Class<?> cls, int i2, Intent intent) {
        if (context == null || cls == null || intent == null) {
            return;
        }
        try {
            enqueueWork(context, new ComponentName(context, cls), i2, intent);
        } catch (Throwable th) {
            UPLog.e(TAG, "jobId:", Integer.valueOf(i2), "failed:", th.getMessage());
        }
    }

    static h getWorkEnqueuer(Context context, ComponentName componentName, boolean z, int i2) {
        h cVar;
        h hVar = sClassWorkEnqueuer.get(componentName);
        if (hVar != null) {
            return hVar;
        }
        if (Build.VERSION.SDK_INT < 26) {
            cVar = new c(context, componentName);
        } else {
            if (!z) {
                throw new IllegalArgumentException("Can't be here without a job id");
            }
            cVar = new g(context, componentName, i2);
        }
        h hVar2 = cVar;
        sClassWorkEnqueuer.put(componentName, hVar2);
        return hVar2;
    }

    private void init() {
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                this.mJobImpl = new f(this);
                this.mCompatWorkEnqueuer = null;
            } else {
                this.mJobImpl = null;
                this.mCompatWorkEnqueuer = getWorkEnqueuer(this, new ComponentName(this, getClass()), false, 0);
            }
        } catch (Throwable th) {
            UPLog.e(TAG, th);
        }
    }

    e dequeueWork() {
        d dVarRemove;
        b bVar = this.mJobImpl;
        if (bVar != null) {
            return bVar.b();
        }
        ArrayList<d> arrayList = this.mCompatQueue;
        if (arrayList == null) {
            return null;
        }
        synchronized (arrayList) {
            dVarRemove = this.mCompatQueue.size() > 0 ? this.mCompatQueue.remove(0) : null;
        }
        return dVarRemove;
    }

    boolean doStopCurrentWork() {
        this.mStopped = true;
        return onStopCurrentWork();
    }

    void ensureProcessorRunningLocked(boolean z) {
        try {
            if (this.mCurProcessor == null) {
                this.mCurProcessor = new a(this);
                if (this.mCompatWorkEnqueuer != null && z) {
                    this.mCompatWorkEnqueuer.b();
                }
                com.umeng.message.proguard.b.a(this.mCurProcessor);
            }
        } catch (Throwable th) {
            UPLog.e(TAG, th);
        }
    }

    public boolean isStopped() {
        return this.mStopped;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (intent != null) {
            try {
                if (this.mJobImpl != null) {
                    return this.mJobImpl.a();
                }
                return null;
            } catch (Throwable th) {
                UPLog.e(TAG, th);
            }
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        init();
    }

    @Override // android.app.Service
    public void onDestroy() {
        try {
            super.onDestroy();
            if (this.mCompatQueue != null) {
                synchronized (this.mCompatQueue) {
                    this.mDestroyed = true;
                    this.mCompatWorkEnqueuer.c();
                }
            }
        } catch (Throwable th) {
            UPLog.e(TAG, th);
        }
    }

    protected void onHandleWork(Intent intent) {
        UPLog.i(TAG, "onHandleWork");
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        if (intent != null) {
            try {
                if (this.mCompatQueue == null) {
                    return 2;
                }
                if (this.mCompatWorkEnqueuer == null) {
                    init();
                }
                this.mCompatWorkEnqueuer.a();
                synchronized (this.mCompatQueue) {
                    this.mCompatQueue.add(new d(intent, i3));
                    ensureProcessorRunningLocked(true);
                }
                return 3;
            } catch (Throwable th) {
                UPLog.e(TAG, th);
            }
        }
        return 2;
    }

    public boolean onStopCurrentWork() {
        return true;
    }

    void processorFinished() {
        try {
            if (this.mCompatQueue != null) {
                synchronized (this.mCompatQueue) {
                    this.mCurProcessor = null;
                    if (this.mCompatQueue.size() > 0) {
                        ensureProcessorRunningLocked(false);
                    } else if (!this.mDestroyed) {
                        this.mCompatWorkEnqueuer.c();
                    }
                }
            }
        } catch (Throwable th) {
            UPLog.e(TAG, th);
        }
    }

    public void setInterruptIfStopped(boolean z) {
        this.mInterruptIfStopped = z;
    }

    private static void enqueueWork(Context context, ComponentName componentName, int i2, Intent intent) {
        if (intent == null) {
            throw new IllegalArgumentException("work must not be null");
        }
        if (context == null || componentName == null) {
            return;
        }
        synchronized (sLock) {
            h workEnqueuer = getWorkEnqueuer(context, componentName, true, i2);
            workEnqueuer.a(i2);
            workEnqueuer.a(intent);
        }
    }

    public static <T extends q> void enqueueWork(Context context, Class<T> cls, Intent intent) {
        int iIntValue;
        synchronized (mRealTimeModeLock) {
            if (context == null || cls == null || intent == null) {
                return;
            }
            UPLog.i(TAG, "enqueue cls:", cls.getSimpleName());
            if (!jobMap.containsKey(cls)) {
                iIntValue = jobMap.size() + 21000;
                jobMap.put(cls, Integer.valueOf(iIntValue));
            } else {
                Integer num = jobMap.get(cls);
                if (num == null) {
                    return;
                } else {
                    iIntValue = num.intValue();
                }
            }
            UPLog.i(TAG, "jobId:", Integer.valueOf(iIntValue));
            enqueueWork(context, (Class<?>) cls, iIntValue, intent);
        }
    }

    static final class c extends h {

        /* renamed from: a, reason: collision with root package name */
        boolean f11406a;

        /* renamed from: b, reason: collision with root package name */
        boolean f11407b;

        /* renamed from: f, reason: collision with root package name */
        private final Context f11408f;

        /* renamed from: g, reason: collision with root package name */
        private final PowerManager.WakeLock f11409g;

        /* renamed from: h, reason: collision with root package name */
        private final PowerManager.WakeLock f11410h;

        c(Context context, ComponentName componentName) {
            super(componentName);
            this.f11408f = context.getApplicationContext();
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            this.f11409g = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
            this.f11409g.setReferenceCounted(false);
            this.f11410h = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
            this.f11410h.setReferenceCounted(false);
        }

        @Override // com.umeng.message.proguard.q.h
        final void a(Intent intent) {
            try {
                Intent intent2 = new Intent(intent);
                intent2.setComponent(this.f11421c);
                if (this.f11408f.startService(intent2) != null) {
                    synchronized (this) {
                        if (!this.f11406a) {
                            this.f11406a = true;
                            if (!this.f11407b) {
                                this.f11409g.acquire(com.heytap.mcssdk.constant.a.f5800d);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                UPLog.e(q.TAG, th);
            }
        }

        @Override // com.umeng.message.proguard.q.h
        public final void b() {
            try {
                synchronized (this) {
                    if (!this.f11407b) {
                        this.f11407b = true;
                        this.f11410h.acquire(600000L);
                        this.f11409g.release();
                    }
                }
            } catch (Throwable th) {
                UPLog.e(q.TAG, th);
            }
        }

        @Override // com.umeng.message.proguard.q.h
        public final void c() {
            try {
                synchronized (this) {
                    if (this.f11407b) {
                        if (this.f11406a) {
                            this.f11409g.acquire(com.heytap.mcssdk.constant.a.f5800d);
                        }
                        this.f11407b = false;
                        this.f11410h.release();
                    }
                }
            } catch (Throwable th) {
                UPLog.e(q.TAG, th);
            }
        }

        @Override // com.umeng.message.proguard.q.h
        public final void a() {
            synchronized (this) {
                this.f11406a = false;
            }
        }
    }
}
