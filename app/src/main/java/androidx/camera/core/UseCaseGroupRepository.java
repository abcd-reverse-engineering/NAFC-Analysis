package androidx.camera.core;

import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.impl.UseCaseGroup;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
final class UseCaseGroupRepository {
    final Object mUseCasesLock = new Object();

    @GuardedBy("mUseCasesLock")
    final Map<LifecycleOwner, UseCaseGroupLifecycleController> mLifecycleToUseCaseGroupControllerMap = new HashMap();

    @GuardedBy("mUseCasesLock")
    final List<LifecycleOwner> mActiveLifecycleOwnerList = new ArrayList();

    @GuardedBy("mUseCasesLock")
    LifecycleOwner mCurrentActiveLifecycleOwner = null;

    public interface UseCaseGroupSetup {
        void setup(UseCaseGroup useCaseGroup);
    }

    UseCaseGroupRepository() {
    }

    private LifecycleObserver createLifecycleObserver() {
        return new LifecycleObserver() { // from class: androidx.camera.core.UseCaseGroupRepository.2
            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            public void onDestroy(LifecycleOwner lifecycleOwner) {
                synchronized (UseCaseGroupRepository.this.mUseCasesLock) {
                    UseCaseGroupRepository.this.mLifecycleToUseCaseGroupControllerMap.remove(lifecycleOwner);
                }
                lifecycleOwner.getLifecycle().removeObserver(this);
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_START)
            public void onStart(LifecycleOwner lifecycleOwner) {
                synchronized (UseCaseGroupRepository.this.mUseCasesLock) {
                    for (Map.Entry<LifecycleOwner, UseCaseGroupLifecycleController> entry : UseCaseGroupRepository.this.mLifecycleToUseCaseGroupControllerMap.entrySet()) {
                        if (entry.getKey() != lifecycleOwner) {
                            UseCaseGroup useCaseGroup = entry.getValue().getUseCaseGroup();
                            if (useCaseGroup.isActive()) {
                                useCaseGroup.stop();
                            }
                        }
                    }
                    UseCaseGroupRepository.this.mCurrentActiveLifecycleOwner = lifecycleOwner;
                    UseCaseGroupRepository.this.mActiveLifecycleOwnerList.add(0, UseCaseGroupRepository.this.mCurrentActiveLifecycleOwner);
                }
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
            public void onStop(LifecycleOwner lifecycleOwner) {
                synchronized (UseCaseGroupRepository.this.mUseCasesLock) {
                    UseCaseGroupRepository.this.mActiveLifecycleOwnerList.remove(lifecycleOwner);
                    if (UseCaseGroupRepository.this.mCurrentActiveLifecycleOwner == lifecycleOwner) {
                        if (UseCaseGroupRepository.this.mActiveLifecycleOwnerList.size() > 0) {
                            UseCaseGroupRepository.this.mCurrentActiveLifecycleOwner = UseCaseGroupRepository.this.mActiveLifecycleOwnerList.get(0);
                            UseCaseGroupRepository.this.mLifecycleToUseCaseGroupControllerMap.get(UseCaseGroupRepository.this.mCurrentActiveLifecycleOwner).getUseCaseGroup().start();
                        } else {
                            UseCaseGroupRepository.this.mCurrentActiveLifecycleOwner = null;
                        }
                    }
                }
            }
        };
    }

    private UseCaseGroupLifecycleController createUseCaseGroup(LifecycleOwner lifecycleOwner) {
        if (lifecycleOwner.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
            throw new IllegalArgumentException("Trying to create use case group with destroyed lifecycle.");
        }
        lifecycleOwner.getLifecycle().addObserver(createLifecycleObserver());
        UseCaseGroupLifecycleController useCaseGroupLifecycleController = new UseCaseGroupLifecycleController(lifecycleOwner.getLifecycle());
        synchronized (this.mUseCasesLock) {
            this.mLifecycleToUseCaseGroupControllerMap.put(lifecycleOwner, useCaseGroupLifecycleController);
        }
        return useCaseGroupLifecycleController;
    }

    UseCaseGroupLifecycleController getOrCreateUseCaseGroup(LifecycleOwner lifecycleOwner) {
        return getOrCreateUseCaseGroup(lifecycleOwner, new UseCaseGroupSetup() { // from class: androidx.camera.core.UseCaseGroupRepository.1
            @Override // androidx.camera.core.UseCaseGroupRepository.UseCaseGroupSetup
            public void setup(UseCaseGroup useCaseGroup) {
            }
        });
    }

    Collection<UseCaseGroupLifecycleController> getUseCaseGroups() {
        Collection<UseCaseGroupLifecycleController> collectionUnmodifiableCollection;
        synchronized (this.mUseCasesLock) {
            collectionUnmodifiableCollection = Collections.unmodifiableCollection(this.mLifecycleToUseCaseGroupControllerMap.values());
        }
        return collectionUnmodifiableCollection;
    }

    @VisibleForTesting
    Map<LifecycleOwner, UseCaseGroupLifecycleController> getUseCasesMap() {
        Map<LifecycleOwner, UseCaseGroupLifecycleController> map;
        synchronized (this.mUseCasesLock) {
            map = this.mLifecycleToUseCaseGroupControllerMap;
        }
        return map;
    }

    UseCaseGroupLifecycleController getOrCreateUseCaseGroup(LifecycleOwner lifecycleOwner, UseCaseGroupSetup useCaseGroupSetup) {
        UseCaseGroupLifecycleController useCaseGroupLifecycleControllerCreateUseCaseGroup;
        synchronized (this.mUseCasesLock) {
            useCaseGroupLifecycleControllerCreateUseCaseGroup = this.mLifecycleToUseCaseGroupControllerMap.get(lifecycleOwner);
            if (useCaseGroupLifecycleControllerCreateUseCaseGroup == null) {
                useCaseGroupLifecycleControllerCreateUseCaseGroup = createUseCaseGroup(lifecycleOwner);
                useCaseGroupSetup.setup(useCaseGroupLifecycleControllerCreateUseCaseGroup.getUseCaseGroup());
            }
        }
        return useCaseGroupLifecycleControllerCreateUseCaseGroup;
    }
}
