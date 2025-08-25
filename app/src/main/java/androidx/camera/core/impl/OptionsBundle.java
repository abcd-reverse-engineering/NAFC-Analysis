package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.impl.Config;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class OptionsBundle implements Config {
    private static final OptionsBundle EMPTY_BUNDLE = new OptionsBundle(new TreeMap(new Comparator<Config.Option<?>>() { // from class: androidx.camera.core.impl.OptionsBundle.1
        @Override // java.util.Comparator
        public int compare(Config.Option<?> option, Config.Option<?> option2) {
            return option.getId().compareTo(option2.getId());
        }
    }));
    protected final TreeMap<Config.Option<?>, Object> mOptions;

    OptionsBundle(TreeMap<Config.Option<?>, Object> treeMap) {
        this.mOptions = treeMap;
    }

    @NonNull
    public static OptionsBundle emptyBundle() {
        return EMPTY_BUNDLE;
    }

    @NonNull
    public static OptionsBundle from(@NonNull Config config) {
        if (OptionsBundle.class.equals(config.getClass())) {
            return (OptionsBundle) config;
        }
        TreeMap treeMap = new TreeMap(new Comparator<Config.Option<?>>() { // from class: androidx.camera.core.impl.OptionsBundle.2
            @Override // java.util.Comparator
            public int compare(Config.Option<?> option, Config.Option<?> option2) {
                return option.getId().compareTo(option2.getId());
            }
        });
        for (Config.Option<?> option : config.listOptions()) {
            treeMap.put(option, config.retrieveOption(option));
        }
        return new OptionsBundle(treeMap);
    }

    @Override // androidx.camera.core.impl.Config
    public boolean containsOption(@NonNull Config.Option<?> option) {
        return this.mOptions.containsKey(option);
    }

    @Override // androidx.camera.core.impl.Config
    public void findOptions(@NonNull String str, @NonNull Config.OptionMatcher optionMatcher) {
        for (Map.Entry<Config.Option<?>, Object> entry : this.mOptions.tailMap(Config.Option.create(str, Void.class)).entrySet()) {
            if (!entry.getKey().getId().startsWith(str) || !optionMatcher.onOptionMatched(entry.getKey())) {
                return;
            }
        }
    }

    @Override // androidx.camera.core.impl.Config
    @NonNull
    public Set<Config.Option<?>> listOptions() {
        return Collections.unmodifiableSet(this.mOptions.keySet());
    }

    @Override // androidx.camera.core.impl.Config
    @Nullable
    public <ValueT> ValueT retrieveOption(@NonNull Config.Option<ValueT> option) {
        if (this.mOptions.containsKey(option)) {
            return (ValueT) this.mOptions.get(option);
        }
        throw new IllegalArgumentException("Option does not exist: " + option);
    }

    @Override // androidx.camera.core.impl.Config
    @Nullable
    public <ValueT> ValueT retrieveOption(@NonNull Config.Option<ValueT> option, @Nullable ValueT valuet) {
        return this.mOptions.containsKey(option) ? (ValueT) this.mOptions.get(option) : valuet;
    }
}
