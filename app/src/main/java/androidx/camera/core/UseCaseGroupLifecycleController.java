package androidx.camera.core;

import androidx.annotation.GuardedBy;
import androidx.camera.core.impl.UseCaseGroup;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import java.util.Iterator;

/* loaded from: classes.dex */
final class UseCaseGroupLifecycleController implements LifecycleObserver {
    private final Lifecycle mLifecycle;

    @GuardedBy("mUseCaseGroupLock")
    private final UseCaseGroup mUseCaseGroup;
    private final Object mUseCaseGroupLock;

    UseCaseGroupLifecycleController(Lifecycle lifecycle) {
        this(lifecycle, new UseCaseGroup());
    }

    UseCaseGroup getUseCaseGroup() {
        UseCaseGroup useCaseGroup;
        synchronized (this.mUseCaseGroupLock) {
            useCaseGroup = this.mUseCaseGroup;
        }
        return useCaseGroup;
    }

    void notifyState() {
        synchronized (this.mUseCaseGroupLock) {
            if (this.mLifecycle.getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
                this.mUseCaseGroup.start();
            }
            Iterator<UseCase> it = this.mUseCaseGroup.getUseCases().iterator();
            while (it.hasNext()) {
                it.next().notifyState();
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy(LifecycleOwner lifecycleOwner) {
        synchronized (this.mUseCaseGroupLock) {
            this.mUseCaseGroup.clear();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart(LifecycleOwner lifecycleOwner) {
        synchronized (this.mUseCaseGroupLock) {
            this.mUseCaseGroup.start();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop(LifecycleOwner lifecycleOwner) {
        synchronized (this.mUseCaseGroupLock) {
            this.mUseCaseGroup.stop();
        }
    }

    void release() {
        this.mLifecycle.removeObserver(this);
    }

    UseCaseGroupLifecycleController(Lifecycle lifecycle, UseCaseGroup useCaseGroup) {
        this.mUseCaseGroupLock = new Object();
        this.mUseCaseGroup = useCaseGroup;
        this.mLifecycle = lifecycle;
        lifecycle.addObserver(this);
    }
}
