package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Set;

/* loaded from: classes.dex */
public interface Config {

    @c.b.a.a.c
    public static abstract class Option<T> {
        Option() {
        }

        @NonNull
        public static <T> Option<T> create(@NonNull String str, @NonNull Class<?> cls) {
            return create(str, cls, null);
        }

        @NonNull
        public abstract String getId();

        @Nullable
        public abstract Object getToken();

        @NonNull
        public abstract Class<T> getValueClass();

        @NonNull
        public static <T> Option<T> create(@NonNull String str, @NonNull Class<?> cls, @Nullable Object obj) {
            return new AutoValue_Config_Option(str, cls, obj);
        }
    }

    public interface OptionMatcher {
        boolean onOptionMatched(@NonNull Option<?> option);
    }

    boolean containsOption(@NonNull Option<?> option);

    void findOptions(@NonNull String str, @NonNull OptionMatcher optionMatcher);

    @NonNull
    Set<Option<?>> listOptions();

    @Nullable
    <ValueT> ValueT retrieveOption(@NonNull Option<ValueT> option);

    @Nullable
    <ValueT> ValueT retrieveOption(@NonNull Option<ValueT> option, @Nullable ValueT valuet);
}
