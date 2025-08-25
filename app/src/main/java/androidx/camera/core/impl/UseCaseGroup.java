package androidx.camera.core.impl;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.camera.core.UseCase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class UseCaseGroup {
    private static final String TAG = "UseCaseGroup";

    @GuardedBy("mListenerLock")
    private StateChangeCallback mStateChangeCallback;
    private final Object mListenerLock = new Object();
    private final Object mUseCasesLock = new Object();

    @GuardedBy("mUseCasesLock")
    private final Set<UseCase> mUseCases = new HashSet();
    private volatile boolean mIsActive = false;

    public interface StateChangeCallback {
        void onGroupActive(@NonNull UseCaseGroup useCaseGroup);

        void onGroupInactive(@NonNull UseCaseGroup useCaseGroup);
    }

    public boolean addUseCase(@NonNull UseCase useCase) {
        boolean zAdd;
        synchronized (this.mUseCasesLock) {
            zAdd = this.mUseCases.add(useCase);
        }
        return zAdd;
    }

    public void clear() {
        ArrayList<UseCase> arrayList = new ArrayList();
        synchronized (this.mUseCasesLock) {
            arrayList.addAll(this.mUseCases);
            this.mUseCases.clear();
        }
        for (UseCase useCase : arrayList) {
            String str = "Clearing use case: " + useCase.getName();
            useCase.clear();
        }
    }

    public boolean contains(@NonNull UseCase useCase) {
        boolean zContains;
        synchronized (this.mUseCasesLock) {
            zContains = this.mUseCases.contains(useCase);
        }
        return zContains;
    }

    @NonNull
    public Map<String, Set<UseCase>> getCameraIdToUseCaseMap() {
        HashMap map = new HashMap();
        synchronized (this.mUseCasesLock) {
            for (UseCase useCase : this.mUseCases) {
                for (String str : useCase.getAttachedCameraIds()) {
                    Set hashSet = (Set) map.get(str);
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(useCase);
                    map.put(str, hashSet);
                }
            }
        }
        return Collections.unmodifiableMap(map);
    }

    @NonNull
    public Collection<UseCase> getUseCases() {
        Collection<UseCase> collectionUnmodifiableCollection;
        synchronized (this.mUseCasesLock) {
            collectionUnmodifiableCollection = Collections.unmodifiableCollection(this.mUseCases);
        }
        return collectionUnmodifiableCollection;
    }

    public boolean isActive() {
        return this.mIsActive;
    }

    public boolean removeUseCase(@NonNull UseCase useCase) {
        boolean zRemove;
        synchronized (this.mUseCasesLock) {
            zRemove = this.mUseCases.remove(useCase);
        }
        return zRemove;
    }

    public void setListener(@NonNull StateChangeCallback stateChangeCallback) {
        synchronized (this.mListenerLock) {
            this.mStateChangeCallback = stateChangeCallback;
        }
    }

    public void start() {
        synchronized (this.mListenerLock) {
            if (this.mStateChangeCallback != null) {
                this.mStateChangeCallback.onGroupActive(this);
            }
            this.mIsActive = true;
        }
    }

    public void stop() {
        synchronized (this.mListenerLock) {
            if (this.mStateChangeCallback != null) {
                this.mStateChangeCallback.onGroupInactive(this);
            }
            this.mIsActive = false;
        }
    }
}
