package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public interface Observable<T> {

    public interface Observer<T> {
        void onError(@NonNull Throwable th);

        void onNewData(@Nullable T t);
    }

    void addObserver(@NonNull Executor executor, @NonNull Observer<T> observer);

    @NonNull
    c.b.b.a.a.a<T> fetchData();

    void removeObserver(@NonNull Observer<T> observer);
}
