package androidx.camera.core.impl.utils.futures;

import androidx.annotation.Nullable;

@FunctionalInterface
/* loaded from: classes.dex */
public interface AsyncFunction<I, O> {
    c.b.b.a.a.a<O> apply(@Nullable I i2) throws Exception;
}
