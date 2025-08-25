package com.sina.weibo.sdk.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* loaded from: classes.dex */
public abstract class c<Params, Progress, Result> {
    Params[] P;
    volatile int L = b.U;
    int O = 5;
    Handler x = new Handler(Looper.getMainLooper()) { // from class: com.sina.weibo.sdk.a.c.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            a aVar = (a) message.obj;
            if (message.what != 1) {
                return;
            }
            c.a(aVar.S, aVar.T[0]);
            message.obj = null;
        }
    };
    final d<Params, Result> M = new d<Params, Result>() { // from class: com.sina.weibo.sdk.a.c.2
        @Override // java.util.concurrent.Callable
        public final Result call() throws SecurityException, IllegalArgumentException {
            Process.setThreadPriority(c.this.O);
            return (Result) c.this.l();
        }
    };
    final FutureTask<Result> N = new c<Params, Progress, Result>.AbstractC0120c(this.M) { // from class: com.sina.weibo.sdk.a.c.3
        @Override // java.lang.Comparable
        public final int compareTo(Object obj) {
            return 0;
        }

        @Override // java.util.concurrent.FutureTask
        protected final void done() {
            try {
                Result result = get();
                c cVar = c.this;
                cVar.x.obtainMessage(1, new a(cVar, result)).sendToTarget();
            } catch (InterruptedException unused) {
                throw new RuntimeException("An error occur while execute doInBackground().");
            } catch (CancellationException unused2) {
                c cVar2 = c.this;
                cVar2.x.obtainMessage(3, new a(cVar2, null)).sendToTarget();
            } catch (ExecutionException unused3) {
                throw new RuntimeException("An error occur while execute doInBackground().");
            }
        }
    };

    /* renamed from: com.sina.weibo.sdk.a.c$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] R = new int[b.m().length];

        static {
            try {
                R[b.V - 1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                R[b.W - 1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static class a<Data> {
        final c S;
        final Data[] T;

        a(c cVar, Data... dataArr) {
            this.S = cVar;
            this.T = dataArr;
        }
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class b {
        public static final int U = 1;
        public static final int V = 2;
        public static final int W = 3;
        private static final /* synthetic */ int[] X = {U, V, W};

        public static int[] m() {
            return (int[]) X.clone();
        }
    }

    /* renamed from: com.sina.weibo.sdk.a.c$c, reason: collision with other inner class name */
    abstract class AbstractC0120c extends FutureTask<Result> implements Comparable<Object> {
        int priority;

        public AbstractC0120c(d dVar) {
            super(dVar);
            this.priority = dVar.priority;
        }
    }

    static /* synthetic */ void a(c cVar, Object obj) {
        cVar.onPostExecute(obj);
        cVar.L = b.W;
    }

    protected abstract Result l();

    protected void onPostExecute(Result result) {
    }

    static abstract class d<Params, Result> implements Callable<Result> {
        Params[] Y;
        int priority;

        private d() {
            this.priority = 10;
        }

        /* synthetic */ d(byte b2) {
            this();
        }
    }
}
