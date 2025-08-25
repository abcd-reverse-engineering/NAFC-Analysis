package com.luck.picture.lib.thread;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.CallSuper;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import com.umeng.analytics.pro.bh;
import java.lang.Thread;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import ui.activity.SmsRecordSelectActivity;

/* loaded from: classes.dex */
public final class PictureThreadUtils {
    private static final byte TYPE_CACHED = -2;
    private static final byte TYPE_CPU = -8;
    private static final byte TYPE_IO = -4;
    private static final byte TYPE_SINGLE = -1;
    private static Executor sDeliver;
    private static final Map<Integer, Map<Integer, ExecutorService>> TYPE_PRIORITY_POOLS = new HashMap();
    private static final Map<Task, TaskInfo> TASK_TASKINFO_MAP = new ConcurrentHashMap();
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static final Timer TIMER = new Timer();

    private static final class LinkedBlockingQueue4Util extends LinkedBlockingQueue<Runnable> {
        private int mCapacity;
        private volatile ThreadPoolExecutor4Util mPool;

        LinkedBlockingQueue4Util() {
            this.mCapacity = Integer.MAX_VALUE;
        }

        @Override // java.util.concurrent.LinkedBlockingQueue, java.util.Queue, java.util.concurrent.BlockingQueue
        public boolean offer(@NonNull Runnable runnable) {
            if (this.mCapacity > size() || this.mPool == null || this.mPool.getPoolSize() >= this.mPool.getMaximumPoolSize()) {
                return super.offer((LinkedBlockingQueue4Util) runnable);
            }
            return false;
        }

        LinkedBlockingQueue4Util(boolean z) {
            this.mCapacity = Integer.MAX_VALUE;
            if (z) {
                this.mCapacity = 0;
            }
        }

        LinkedBlockingQueue4Util(int i2) {
            this.mCapacity = Integer.MAX_VALUE;
            this.mCapacity = i2;
        }
    }

    public static abstract class SimpleTask<T> extends Task<T> {
        @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
        public void onCancel() {
            String str = "onCancel: " + Thread.currentThread();
        }

        @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
        public void onFail(Throwable th) {
        }
    }

    public static abstract class Task<T> implements Runnable {
        private static final int CANCELLED = 4;
        private static final int COMPLETING = 3;
        private static final int EXCEPTIONAL = 2;
        private static final int INTERRUPTED = 5;
        private static final int NEW = 0;
        private static final int RUNNING = 1;
        private static final int TIMEOUT = 6;
        private Executor deliver;
        private volatile boolean isSchedule;
        private Timer mTimer;
        private volatile Thread runner;
        private final AtomicInteger state = new AtomicInteger(0);

        public interface OnTimeoutListener {
            void onTimeout();
        }

        private Executor getDeliver() {
            Executor executor = this.deliver;
            return executor == null ? PictureThreadUtils.getGlobalDeliver() : executor;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSchedule(boolean z) {
            this.isSchedule = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void timeout() {
            synchronized (this.state) {
                if (this.state.get() > 1) {
                    return;
                }
                this.state.set(6);
                if (this.runner != null) {
                    this.runner.interrupt();
                }
                onDone();
            }
        }

        public void cancel() {
            cancel(true);
        }

        public abstract T doInBackground() throws Throwable;

        public boolean isCanceled() {
            return this.state.get() >= 4;
        }

        public boolean isDone() {
            return this.state.get() > 1;
        }

        public abstract void onCancel();

        @CallSuper
        protected void onDone() {
            PictureThreadUtils.TASK_TASKINFO_MAP.remove(this);
            Timer timer = this.mTimer;
            if (timer != null) {
                timer.cancel();
                this.mTimer = null;
            }
        }

        public abstract void onFail(Throwable th);

        public abstract void onSuccess(T t);

        @Override // java.lang.Runnable
        public void run() {
            if (this.isSchedule) {
                if (this.runner == null) {
                    if (!this.state.compareAndSet(0, 1)) {
                        return;
                    } else {
                        this.runner = Thread.currentThread();
                    }
                } else if (this.state.get() != 1) {
                    return;
                }
            } else if (!this.state.compareAndSet(0, 1)) {
                return;
            } else {
                this.runner = Thread.currentThread();
            }
            try {
                final T tDoInBackground = doInBackground();
                if (this.isSchedule) {
                    if (this.state.get() != 1) {
                        return;
                    }
                    getDeliver().execute(new Runnable() { // from class: com.luck.picture.lib.thread.PictureThreadUtils.Task.1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.lang.Runnable
                        public void run() {
                            Task.this.onSuccess(tDoInBackground);
                        }
                    });
                } else if (this.state.compareAndSet(1, 3)) {
                    getDeliver().execute(new Runnable() { // from class: com.luck.picture.lib.thread.PictureThreadUtils.Task.2
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.lang.Runnable
                        public void run() {
                            Task.this.onSuccess(tDoInBackground);
                            Task.this.onDone();
                        }
                    });
                }
            } catch (InterruptedException unused) {
                this.state.compareAndSet(4, 5);
            } catch (Throwable th) {
                if (this.state.compareAndSet(1, 2)) {
                    getDeliver().execute(new Runnable() { // from class: com.luck.picture.lib.thread.PictureThreadUtils.Task.3
                        @Override // java.lang.Runnable
                        public void run() {
                            Task.this.onFail(th);
                            Task.this.onDone();
                        }
                    });
                }
            }
        }

        public Task<T> setDeliver(Executor executor) {
            this.deliver = executor;
            return this;
        }

        public void setTimeout(long j2, final OnTimeoutListener onTimeoutListener) {
            this.mTimer = new Timer();
            this.mTimer.schedule(new TimerTask() { // from class: com.luck.picture.lib.thread.PictureThreadUtils.Task.5
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (Task.this.isDone() || onTimeoutListener == null) {
                        return;
                    }
                    Task.this.timeout();
                    onTimeoutListener.onTimeout();
                }
            }, j2);
        }

        public void cancel(boolean z) {
            synchronized (this.state) {
                if (this.state.get() > 1) {
                    return;
                }
                this.state.set(4);
                if (z && this.runner != null) {
                    this.runner.interrupt();
                }
                getDeliver().execute(new Runnable() { // from class: com.luck.picture.lib.thread.PictureThreadUtils.Task.4
                    @Override // java.lang.Runnable
                    public void run() {
                        Task.this.onCancel();
                        Task.this.onDone();
                    }
                });
            }
        }
    }

    private static class TaskInfo {
        private ExecutorService mService;
        private TimerTask mTimerTask;

        private TaskInfo(ExecutorService executorService) {
            this.mService = executorService;
        }
    }

    static final class ThreadPoolExecutor4Util extends ThreadPoolExecutor {
        private final AtomicInteger mSubmittedCount;
        private LinkedBlockingQueue4Util mWorkQueue;

        ThreadPoolExecutor4Util(int i2, int i3, long j2, TimeUnit timeUnit, LinkedBlockingQueue4Util linkedBlockingQueue4Util, ThreadFactory threadFactory) {
            super(i2, i3, j2, timeUnit, linkedBlockingQueue4Util, threadFactory);
            this.mSubmittedCount = new AtomicInteger();
            linkedBlockingQueue4Util.mPool = this;
            this.mWorkQueue = linkedBlockingQueue4Util;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static ExecutorService createPool(int i2, int i3) {
            if (i2 == -8) {
                return new ThreadPoolExecutor4Util(PictureThreadUtils.CPU_COUNT + 1, (PictureThreadUtils.CPU_COUNT * 2) + 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue4Util(true), new UtilsThreadFactory(bh.w, i3));
            }
            if (i2 == -4) {
                return new ThreadPoolExecutor4Util((PictureThreadUtils.CPU_COUNT * 2) + 1, (PictureThreadUtils.CPU_COUNT * 2) + 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue4Util(), new UtilsThreadFactory("io", i3));
            }
            if (i2 == -2) {
                return new ThreadPoolExecutor4Util(0, 128, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue4Util(true), new UtilsThreadFactory("cached", i3));
            }
            if (i2 == -1) {
                return new ThreadPoolExecutor4Util(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue4Util(), new UtilsThreadFactory(SmsRecordSelectActivity.f19032l, i3));
            }
            return new ThreadPoolExecutor4Util(i2, i2, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue4Util(), new UtilsThreadFactory("fixed(" + i2 + ")", i3));
        }

        private int getSubmittedCount() {
            return this.mSubmittedCount.get();
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        protected void afterExecute(Runnable runnable, Throwable th) {
            this.mSubmittedCount.decrementAndGet();
            super.afterExecute(runnable, th);
        }

        @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            if (isShutdown()) {
                return;
            }
            this.mSubmittedCount.incrementAndGet();
            try {
                super.execute(runnable);
            } catch (RejectedExecutionException unused) {
                this.mWorkQueue.offer(runnable);
            } catch (Throwable unused2) {
                this.mSubmittedCount.decrementAndGet();
            }
        }
    }

    private static final class UtilsThreadFactory extends AtomicLong implements ThreadFactory {
        private static final AtomicInteger POOL_NUMBER = new AtomicInteger(1);
        private static final long serialVersionUID = -9209200509960368598L;
        private final boolean isDaemon;
        private final String namePrefix;
        private final int priority;

        UtilsThreadFactory(String str, int i2) {
            this(str, i2, false);
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            Thread thread = new Thread(runnable, this.namePrefix + getAndIncrement()) { // from class: com.luck.picture.lib.thread.PictureThreadUtils.UtilsThreadFactory.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        super.run();
                    } catch (Throwable unused) {
                    }
                }
            };
            thread.setDaemon(this.isDaemon);
            thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.luck.picture.lib.thread.PictureThreadUtils.UtilsThreadFactory.2
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public void uncaughtException(Thread thread2, Throwable th) {
                    System.out.println(th);
                }
            });
            thread.setPriority(this.priority);
            return thread;
        }

        UtilsThreadFactory(String str, int i2, boolean z) {
            this.namePrefix = str + "-pool-" + POOL_NUMBER.getAndIncrement() + "-thread-";
            this.priority = i2;
            this.isDaemon = z;
        }
    }

    public static void cancel(Task task) {
        if (task == null) {
            return;
        }
        task.cancel();
    }

    private static <T> void execute(ExecutorService executorService, Task<T> task) {
        execute(executorService, task, 0L, 0L, null);
    }

    private static <T> void executeAtFixedRate(ExecutorService executorService, Task<T> task, long j2, long j3, TimeUnit timeUnit) {
        execute(executorService, task, j2, j3, timeUnit);
    }

    public static <T> void executeByCached(Task<T> task) {
        execute(getPoolByTypeAndPriority(-2), task);
    }

    public static <T> void executeByCachedAtFixRate(Task<T> task, long j2, TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(-2), task, 0L, j2, timeUnit);
    }

    public static <T> void executeByCachedWithDelay(Task<T> task, long j2, TimeUnit timeUnit) {
        executeWithDelay(getPoolByTypeAndPriority(-2), task, j2, timeUnit);
    }

    public static <T> void executeByCpu(Task<T> task) {
        execute(getPoolByTypeAndPriority(-8), task);
    }

    public static <T> void executeByCpuAtFixRate(Task<T> task, long j2, TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(-8), task, 0L, j2, timeUnit);
    }

    public static <T> void executeByCpuWithDelay(Task<T> task, long j2, TimeUnit timeUnit) {
        executeWithDelay(getPoolByTypeAndPriority(-8), task, j2, timeUnit);
    }

    public static <T> void executeByCustom(ExecutorService executorService, Task<T> task) {
        execute(executorService, task);
    }

    public static <T> void executeByCustomAtFixRate(ExecutorService executorService, Task<T> task, long j2, TimeUnit timeUnit) {
        executeAtFixedRate(executorService, task, 0L, j2, timeUnit);
    }

    public static <T> void executeByCustomWithDelay(ExecutorService executorService, Task<T> task, long j2, TimeUnit timeUnit) {
        executeWithDelay(executorService, task, j2, timeUnit);
    }

    public static <T> void executeByFixed(@IntRange(from = 1) int i2, Task<T> task) {
        execute(getPoolByTypeAndPriority(i2), task);
    }

    public static <T> void executeByFixedAtFixRate(@IntRange(from = 1) int i2, Task<T> task, long j2, TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(i2), task, 0L, j2, timeUnit);
    }

    public static <T> void executeByFixedWithDelay(@IntRange(from = 1) int i2, Task<T> task, long j2, TimeUnit timeUnit) {
        executeWithDelay(getPoolByTypeAndPriority(i2), task, j2, timeUnit);
    }

    public static <T> void executeByIo(Task<T> task) {
        execute(getPoolByTypeAndPriority(-4), task);
    }

    public static <T> void executeByIoAtFixRate(Task<T> task, long j2, TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(-4), task, 0L, j2, timeUnit);
    }

    public static <T> void executeByIoWithDelay(Task<T> task, long j2, TimeUnit timeUnit) {
        executeWithDelay(getPoolByTypeAndPriority(-4), task, j2, timeUnit);
    }

    public static <T> void executeBySingle(Task<T> task) {
        execute(getPoolByTypeAndPriority(-1), task);
    }

    public static <T> void executeBySingleAtFixRate(Task<T> task, long j2, TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(-1), task, 0L, j2, timeUnit);
    }

    public static <T> void executeBySingleWithDelay(Task<T> task, long j2, TimeUnit timeUnit) {
        executeWithDelay(getPoolByTypeAndPriority(-1), task, j2, timeUnit);
    }

    private static <T> void executeWithDelay(ExecutorService executorService, Task<T> task, long j2, TimeUnit timeUnit) {
        execute(executorService, task, j2, 0L, timeUnit);
    }

    public static ExecutorService getCachedPool() {
        return getPoolByTypeAndPriority(-2);
    }

    public static ExecutorService getCpuPool() {
        return getPoolByTypeAndPriority(-8);
    }

    public static ExecutorService getFixedPool(@IntRange(from = 1) int i2) {
        return getPoolByTypeAndPriority(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Executor getGlobalDeliver() {
        if (sDeliver == null) {
            sDeliver = new Executor() { // from class: com.luck.picture.lib.thread.PictureThreadUtils.3
                private final Handler mHandler = new Handler(Looper.getMainLooper());

                @Override // java.util.concurrent.Executor
                public void execute(@NonNull Runnable runnable) {
                    this.mHandler.post(runnable);
                }
            };
        }
        return sDeliver;
    }

    public static ExecutorService getIoPool() {
        return getPoolByTypeAndPriority(-4);
    }

    private static ExecutorService getPoolByTypeAndPriority(int i2) {
        return getPoolByTypeAndPriority(i2, 5);
    }

    public static ExecutorService getSinglePool() {
        return getPoolByTypeAndPriority(-1);
    }

    public static boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static void setDeliver(Executor executor) {
        sDeliver = executor;
    }

    public static void cancel(Task... taskArr) {
        if (taskArr == null || taskArr.length == 0) {
            return;
        }
        for (Task task : taskArr) {
            if (task != null) {
                task.cancel();
            }
        }
    }

    private static <T> void execute(final ExecutorService executorService, final Task<T> task, long j2, long j3, TimeUnit timeUnit) {
        synchronized (TASK_TASKINFO_MAP) {
            if (TASK_TASKINFO_MAP.get(task) != null) {
                return;
            }
            TaskInfo taskInfo = new TaskInfo(executorService);
            TASK_TASKINFO_MAP.put(task, taskInfo);
            if (j3 != 0) {
                task.setSchedule(true);
                TimerTask timerTask = new TimerTask() { // from class: com.luck.picture.lib.thread.PictureThreadUtils.2
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        executorService.execute(task);
                    }
                };
                taskInfo.mTimerTask = timerTask;
                TIMER.scheduleAtFixedRate(timerTask, timeUnit.toMillis(j2), timeUnit.toMillis(j3));
                return;
            }
            if (j2 == 0) {
                executorService.execute(task);
                return;
            }
            TimerTask timerTask2 = new TimerTask() { // from class: com.luck.picture.lib.thread.PictureThreadUtils.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    executorService.execute(task);
                }
            };
            taskInfo.mTimerTask = timerTask2;
            TIMER.schedule(timerTask2, timeUnit.toMillis(j2));
        }
    }

    public static <T> void executeByCached(Task<T> task, @IntRange(from = 1, to = 10) int i2) {
        execute(getPoolByTypeAndPriority(-2, i2), task);
    }

    public static <T> void executeByCachedAtFixRate(Task<T> task, long j2, TimeUnit timeUnit, @IntRange(from = 1, to = 10) int i2) {
        executeAtFixedRate(getPoolByTypeAndPriority(-2, i2), task, 0L, j2, timeUnit);
    }

    public static <T> void executeByCachedWithDelay(Task<T> task, long j2, TimeUnit timeUnit, @IntRange(from = 1, to = 10) int i2) {
        executeWithDelay(getPoolByTypeAndPriority(-2, i2), task, j2, timeUnit);
    }

    public static <T> void executeByCpu(Task<T> task, @IntRange(from = 1, to = 10) int i2) {
        execute(getPoolByTypeAndPriority(-8, i2), task);
    }

    public static <T> void executeByCpuAtFixRate(Task<T> task, long j2, TimeUnit timeUnit, @IntRange(from = 1, to = 10) int i2) {
        executeAtFixedRate(getPoolByTypeAndPriority(-8, i2), task, 0L, j2, timeUnit);
    }

    public static <T> void executeByCpuWithDelay(Task<T> task, long j2, TimeUnit timeUnit, @IntRange(from = 1, to = 10) int i2) {
        executeWithDelay(getPoolByTypeAndPriority(-8, i2), task, j2, timeUnit);
    }

    public static <T> void executeByCustomAtFixRate(ExecutorService executorService, Task<T> task, long j2, long j3, TimeUnit timeUnit) {
        executeAtFixedRate(executorService, task, j2, j3, timeUnit);
    }

    public static <T> void executeByFixed(@IntRange(from = 1) int i2, Task<T> task, @IntRange(from = 1, to = 10) int i3) {
        execute(getPoolByTypeAndPriority(i2, i3), task);
    }

    public static <T> void executeByFixedAtFixRate(@IntRange(from = 1) int i2, Task<T> task, long j2, TimeUnit timeUnit, @IntRange(from = 1, to = 10) int i3) {
        executeAtFixedRate(getPoolByTypeAndPriority(i2, i3), task, 0L, j2, timeUnit);
    }

    public static <T> void executeByFixedWithDelay(@IntRange(from = 1) int i2, Task<T> task, long j2, TimeUnit timeUnit, @IntRange(from = 1, to = 10) int i3) {
        executeWithDelay(getPoolByTypeAndPriority(i2, i3), task, j2, timeUnit);
    }

    public static <T> void executeByIo(Task<T> task, @IntRange(from = 1, to = 10) int i2) {
        execute(getPoolByTypeAndPriority(-4, i2), task);
    }

    public static <T> void executeByIoAtFixRate(Task<T> task, long j2, TimeUnit timeUnit, @IntRange(from = 1, to = 10) int i2) {
        executeAtFixedRate(getPoolByTypeAndPriority(-4, i2), task, 0L, j2, timeUnit);
    }

    public static <T> void executeByIoWithDelay(Task<T> task, long j2, TimeUnit timeUnit, @IntRange(from = 1, to = 10) int i2) {
        executeWithDelay(getPoolByTypeAndPriority(-4, i2), task, j2, timeUnit);
    }

    public static <T> void executeBySingle(Task<T> task, @IntRange(from = 1, to = 10) int i2) {
        execute(getPoolByTypeAndPriority(-1, i2), task);
    }

    public static <T> void executeBySingleAtFixRate(Task<T> task, long j2, TimeUnit timeUnit, @IntRange(from = 1, to = 10) int i2) {
        executeAtFixedRate(getPoolByTypeAndPriority(-1, i2), task, 0L, j2, timeUnit);
    }

    public static <T> void executeBySingleWithDelay(Task<T> task, long j2, TimeUnit timeUnit, @IntRange(from = 1, to = 10) int i2) {
        executeWithDelay(getPoolByTypeAndPriority(-1, i2), task, j2, timeUnit);
    }

    public static ExecutorService getCachedPool(@IntRange(from = 1, to = 10) int i2) {
        return getPoolByTypeAndPriority(-2, i2);
    }

    public static ExecutorService getCpuPool(@IntRange(from = 1, to = 10) int i2) {
        return getPoolByTypeAndPriority(-8, i2);
    }

    public static ExecutorService getFixedPool(@IntRange(from = 1) int i2, @IntRange(from = 1, to = 10) int i3) {
        return getPoolByTypeAndPriority(i2, i3);
    }

    public static ExecutorService getIoPool(@IntRange(from = 1, to = 10) int i2) {
        return getPoolByTypeAndPriority(-4, i2);
    }

    private static ExecutorService getPoolByTypeAndPriority(int i2, int i3) {
        ExecutorService executorServiceCreatePool;
        synchronized (TYPE_PRIORITY_POOLS) {
            Map<Integer, ExecutorService> map = TYPE_PRIORITY_POOLS.get(Integer.valueOf(i2));
            if (map == null) {
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                executorServiceCreatePool = ThreadPoolExecutor4Util.createPool(i2, i3);
                concurrentHashMap.put(Integer.valueOf(i3), executorServiceCreatePool);
                TYPE_PRIORITY_POOLS.put(Integer.valueOf(i2), concurrentHashMap);
            } else {
                executorServiceCreatePool = map.get(Integer.valueOf(i3));
                if (executorServiceCreatePool == null) {
                    executorServiceCreatePool = ThreadPoolExecutor4Util.createPool(i2, i3);
                    map.put(Integer.valueOf(i3), executorServiceCreatePool);
                }
            }
        }
        return executorServiceCreatePool;
    }

    public static ExecutorService getSinglePool(@IntRange(from = 1, to = 10) int i2) {
        return getPoolByTypeAndPriority(-1, i2);
    }

    public static <T> void executeByCachedAtFixRate(Task<T> task, long j2, long j3, TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(-2), task, j2, j3, timeUnit);
    }

    public static <T> void executeByCpuAtFixRate(Task<T> task, long j2, long j3, TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(-8), task, j2, j3, timeUnit);
    }

    public static <T> void executeByFixedAtFixRate(@IntRange(from = 1) int i2, Task<T> task, long j2, long j3, TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(i2), task, j2, j3, timeUnit);
    }

    public static <T> void executeByIoAtFixRate(Task<T> task, long j2, long j3, TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(-4), task, j2, j3, timeUnit);
    }

    public static <T> void executeBySingleAtFixRate(Task<T> task, long j2, long j3, TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(-1), task, j2, j3, timeUnit);
    }

    public static <T> void executeByCachedAtFixRate(Task<T> task, long j2, long j3, TimeUnit timeUnit, @IntRange(from = 1, to = 10) int i2) {
        executeAtFixedRate(getPoolByTypeAndPriority(-2, i2), task, j2, j3, timeUnit);
    }

    public static <T> void executeByCpuAtFixRate(Task<T> task, long j2, long j3, TimeUnit timeUnit, @IntRange(from = 1, to = 10) int i2) {
        executeAtFixedRate(getPoolByTypeAndPriority(-8, i2), task, j2, j3, timeUnit);
    }

    public static <T> void executeByFixedAtFixRate(@IntRange(from = 1) int i2, Task<T> task, long j2, long j3, TimeUnit timeUnit, @IntRange(from = 1, to = 10) int i3) {
        executeAtFixedRate(getPoolByTypeAndPriority(i2, i3), task, j2, j3, timeUnit);
    }

    public static <T> void executeByIoAtFixRate(Task<T> task, long j2, long j3, TimeUnit timeUnit, @IntRange(from = 1, to = 10) int i2) {
        executeAtFixedRate(getPoolByTypeAndPriority(-4, i2), task, j2, j3, timeUnit);
    }

    public static <T> void executeBySingleAtFixRate(Task<T> task, long j2, long j3, TimeUnit timeUnit, @IntRange(from = 1, to = 10) int i2) {
        executeAtFixedRate(getPoolByTypeAndPriority(-1, i2), task, j2, j3, timeUnit);
    }

    public static void cancel(List<Task> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        for (Task task : list) {
            if (task != null) {
                task.cancel();
            }
        }
    }

    public static void cancel(ExecutorService executorService) {
        if (executorService instanceof ThreadPoolExecutor4Util) {
            for (Map.Entry<Task, TaskInfo> entry : TASK_TASKINFO_MAP.entrySet()) {
                if (entry.getValue().mService == executorService) {
                    cancel(entry.getKey());
                }
            }
        }
    }
}
