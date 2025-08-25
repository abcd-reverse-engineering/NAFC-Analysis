package androidx.fragment.app;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;

/* loaded from: classes.dex */
class FragmentViewLifecycleOwner implements LifecycleOwner {
    private LifecycleRegistry mLifecycleRegistry = null;

    FragmentViewLifecycleOwner() {
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        initialize();
        return this.mLifecycleRegistry;
    }

    void handleLifecycleEvent(@NonNull Lifecycle.Event event2) {
        this.mLifecycleRegistry.handleLifecycleEvent(event2);
    }

    void initialize() {
        if (this.mLifecycleRegistry == null) {
            this.mLifecycleRegistry = new LifecycleRegistry(this);
        }
    }

    boolean isInitialized() {
        return this.mLifecycleRegistry != null;
    }
}
