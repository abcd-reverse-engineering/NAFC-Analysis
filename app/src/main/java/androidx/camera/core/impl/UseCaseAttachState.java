package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.SessionConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class UseCaseAttachState {
    private static final String TAG = "UseCaseAttachState";
    private final Map<UseCase, UseCaseAttachInfo> mAttachedUseCasesToInfoMap = new HashMap();
    private final String mCameraId;

    private interface AttachStateFilter {
        boolean filter(UseCaseAttachInfo useCaseAttachInfo);
    }

    private static final class UseCaseAttachInfo {
        private final SessionConfig mSessionConfig;
        private boolean mOnline = false;
        private boolean mActive = false;

        UseCaseAttachInfo(SessionConfig sessionConfig) {
            this.mSessionConfig = sessionConfig;
        }

        boolean getActive() {
            return this.mActive;
        }

        boolean getOnline() {
            return this.mOnline;
        }

        SessionConfig getSessionConfig() {
            return this.mSessionConfig;
        }

        void setActive(boolean z) {
            this.mActive = z;
        }

        void setOnline(boolean z) {
            this.mOnline = z;
        }
    }

    public UseCaseAttachState(@NonNull String str) {
        this.mCameraId = str;
    }

    private UseCaseAttachInfo getOrCreateUseCaseAttachInfo(UseCase useCase) {
        UseCaseAttachInfo useCaseAttachInfo = this.mAttachedUseCasesToInfoMap.get(useCase);
        if (useCaseAttachInfo != null) {
            return useCaseAttachInfo;
        }
        UseCaseAttachInfo useCaseAttachInfo2 = new UseCaseAttachInfo(useCase.getSessionConfig(this.mCameraId));
        this.mAttachedUseCasesToInfoMap.put(useCase, useCaseAttachInfo2);
        return useCaseAttachInfo2;
    }

    private Collection<UseCase> getUseCases(AttachStateFilter attachStateFilter) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<UseCase, UseCaseAttachInfo> entry : this.mAttachedUseCasesToInfoMap.entrySet()) {
            if (attachStateFilter == null || attachStateFilter.filter(entry.getValue())) {
                arrayList.add(entry.getKey());
            }
        }
        return arrayList;
    }

    @NonNull
    public SessionConfig.ValidatingBuilder getActiveAndOnlineBuilder() {
        SessionConfig.ValidatingBuilder validatingBuilder = new SessionConfig.ValidatingBuilder();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<UseCase, UseCaseAttachInfo> entry : this.mAttachedUseCasesToInfoMap.entrySet()) {
            UseCaseAttachInfo value = entry.getValue();
            if (value.getActive() && value.getOnline()) {
                UseCase key = entry.getKey();
                validatingBuilder.add(value.getSessionConfig());
                arrayList.add(key.getName());
            }
        }
        String str = "Active and online use case: " + arrayList + " for camera: " + this.mCameraId;
        return validatingBuilder;
    }

    @NonNull
    public Collection<UseCase> getActiveAndOnlineUseCases() {
        return Collections.unmodifiableCollection(getUseCases(new AttachStateFilter() { // from class: androidx.camera.core.impl.UseCaseAttachState.2
            @Override // androidx.camera.core.impl.UseCaseAttachState.AttachStateFilter
            public boolean filter(UseCaseAttachInfo useCaseAttachInfo) {
                return useCaseAttachInfo.getActive() && useCaseAttachInfo.getOnline();
            }
        }));
    }

    @NonNull
    public SessionConfig.ValidatingBuilder getOnlineBuilder() {
        SessionConfig.ValidatingBuilder validatingBuilder = new SessionConfig.ValidatingBuilder();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<UseCase, UseCaseAttachInfo> entry : this.mAttachedUseCasesToInfoMap.entrySet()) {
            UseCaseAttachInfo value = entry.getValue();
            if (value.getOnline()) {
                validatingBuilder.add(value.getSessionConfig());
                arrayList.add(entry.getKey().getName());
            }
        }
        String str = "All use case: " + arrayList + " for camera: " + this.mCameraId;
        return validatingBuilder;
    }

    @NonNull
    public Collection<UseCase> getOnlineUseCases() {
        return Collections.unmodifiableCollection(getUseCases(new AttachStateFilter() { // from class: androidx.camera.core.impl.UseCaseAttachState.1
            @Override // androidx.camera.core.impl.UseCaseAttachState.AttachStateFilter
            public boolean filter(UseCaseAttachInfo useCaseAttachInfo) {
                return useCaseAttachInfo.getOnline();
            }
        }));
    }

    @NonNull
    public SessionConfig getUseCaseSessionConfig(@NonNull UseCase useCase) {
        return !this.mAttachedUseCasesToInfoMap.containsKey(useCase) ? SessionConfig.defaultEmptySessionConfig() : this.mAttachedUseCasesToInfoMap.get(useCase).getSessionConfig();
    }

    public boolean isUseCaseOnline(@NonNull UseCase useCase) {
        if (this.mAttachedUseCasesToInfoMap.containsKey(useCase)) {
            return this.mAttachedUseCasesToInfoMap.get(useCase).getOnline();
        }
        return false;
    }

    public void setUseCaseActive(@NonNull UseCase useCase) {
        getOrCreateUseCaseAttachInfo(useCase).setActive(true);
    }

    public void setUseCaseInactive(@NonNull UseCase useCase) {
        if (this.mAttachedUseCasesToInfoMap.containsKey(useCase)) {
            UseCaseAttachInfo useCaseAttachInfo = this.mAttachedUseCasesToInfoMap.get(useCase);
            useCaseAttachInfo.setActive(false);
            if (useCaseAttachInfo.getOnline()) {
                return;
            }
            this.mAttachedUseCasesToInfoMap.remove(useCase);
        }
    }

    public void setUseCaseOffline(@NonNull UseCase useCase) {
        if (this.mAttachedUseCasesToInfoMap.containsKey(useCase)) {
            UseCaseAttachInfo useCaseAttachInfo = this.mAttachedUseCasesToInfoMap.get(useCase);
            useCaseAttachInfo.setOnline(false);
            if (useCaseAttachInfo.getActive()) {
                return;
            }
            this.mAttachedUseCasesToInfoMap.remove(useCase);
        }
    }

    public void setUseCaseOnline(@NonNull UseCase useCase) {
        getOrCreateUseCaseAttachInfo(useCase).setOnline(true);
    }

    public void updateUseCase(@NonNull UseCase useCase) {
        if (this.mAttachedUseCasesToInfoMap.containsKey(useCase)) {
            UseCaseAttachInfo useCaseAttachInfo = new UseCaseAttachInfo(useCase.getSessionConfig(this.mCameraId));
            UseCaseAttachInfo useCaseAttachInfo2 = this.mAttachedUseCasesToInfoMap.get(useCase);
            useCaseAttachInfo.setOnline(useCaseAttachInfo2.getOnline());
            useCaseAttachInfo.setActive(useCaseAttachInfo2.getActive());
            this.mAttachedUseCasesToInfoMap.put(useCase, useCaseAttachInfo);
        }
    }
}
