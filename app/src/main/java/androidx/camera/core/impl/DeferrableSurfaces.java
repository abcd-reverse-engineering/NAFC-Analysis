package androidx.camera.core.impl;

import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public final class DeferrableSurfaces {
    private DeferrableSurfaces() {
    }

    static /* synthetic */ Object a(List list, ScheduledExecutorService scheduledExecutorService, final Executor executor, final long j2, final boolean z, final CallbackToFutureAdapter.Completer completer) throws Exception {
        final c.b.b.a.a.a aVarSuccessfulAsList = Futures.successfulAsList(list);
        final ScheduledFuture<?> scheduledFutureSchedule = scheduledExecutorService.schedule(new Runnable() { // from class: androidx.camera.core.impl.d
            @Override // java.lang.Runnable
            public final void run() {
                executor.execute(new Runnable() { // from class: androidx.camera.core.impl.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        DeferrableSurfaces.a(aVar, completer, j);
                    }
                });
            }
        }, j2, TimeUnit.MILLISECONDS);
        completer.addCancellationListener(new Runnable() { // from class: androidx.camera.core.impl.e
            @Override // java.lang.Runnable
            public final void run() {
                aVarSuccessfulAsList.cancel(true);
            }
        }, executor);
        Futures.addCallback(aVarSuccessfulAsList, new FutureCallback<List<Surface>>() { // from class: androidx.camera.core.impl.DeferrableSurfaces.1
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(Throwable th) {
                completer.set(Collections.unmodifiableList(Collections.emptyList()));
                scheduledFutureSchedule.cancel(true);
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(@Nullable List<Surface> list2) {
                ArrayList arrayList = new ArrayList(list2);
                if (z) {
                    arrayList.removeAll(Collections.singleton(null));
                }
                completer.set(arrayList);
                scheduledFutureSchedule.cancel(true);
            }
        }, executor);
        return "surfaceList";
    }

    public static void decrementAll(@NonNull List<DeferrableSurface> list) {
        Iterator<DeferrableSurface> it = list.iterator();
        while (it.hasNext()) {
            it.next().decrementUseCount();
        }
    }

    public static void incrementAll(@NonNull List<DeferrableSurface> list) throws DeferrableSurface.SurfaceClosedException {
        if (list.isEmpty()) {
            return;
        }
        int i2 = 0;
        do {
            try {
                list.get(i2).incrementUseCount();
                i2++;
            } catch (DeferrableSurface.SurfaceClosedException e2) {
                for (int i3 = i2 - 1; i3 >= 0; i3--) {
                    list.get(i3).decrementUseCount();
                }
                throw e2;
            }
        } while (i2 < list.size());
    }

    @NonNull
    public static c.b.b.a.a.a<List<Surface>> surfaceListWithTimeout(@NonNull Collection<DeferrableSurface> collection, final boolean z, final long j2, @NonNull final Executor executor, @NonNull final ScheduledExecutorService scheduledExecutorService) {
        final ArrayList arrayList = new ArrayList();
        Iterator<DeferrableSurface> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getSurface());
        }
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.core.impl.f
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return DeferrableSurfaces.a(arrayList, scheduledExecutorService, executor, j2, z, completer);
            }
        });
    }

    public static boolean tryIncrementAll(@NonNull List<DeferrableSurface> list) {
        try {
            incrementAll(list);
            return true;
        } catch (DeferrableSurface.SurfaceClosedException unused) {
            return false;
        }
    }

    static /* synthetic */ void a(c.b.b.a.a.a aVar, CallbackToFutureAdapter.Completer completer, long j2) {
        if (aVar.isDone()) {
            return;
        }
        completer.setException(new TimeoutException("Cannot complete surfaceList within " + j2));
        aVar.cancel(true);
    }
}
