package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.impl.Config;
import java.util.Comparator;
import java.util.TreeMap;

/* loaded from: classes.dex */
public final class MutableOptionsBundle extends OptionsBundle implements MutableConfig {
    private static final Comparator<Config.Option<?>> ID_COMPARE = new Comparator<Config.Option<?>>() { // from class: androidx.camera.core.impl.MutableOptionsBundle.1
        @Override // java.util.Comparator
        public int compare(Config.Option<?> option, Config.Option<?> option2) {
            return option.getId().compareTo(option2.getId());
        }
    };

    private MutableOptionsBundle(TreeMap<Config.Option<?>, Object> treeMap) {
        super(treeMap);
    }

    @NonNull
    public static MutableOptionsBundle create() {
        return new MutableOptionsBundle(new TreeMap(ID_COMPARE));
    }

    @NonNull
    public static MutableOptionsBundle from(@NonNull Config config) {
        TreeMap treeMap = new TreeMap(ID_COMPARE);
        for (Config.Option<?> option : config.listOptions()) {
            treeMap.put(option, config.retrieveOption(option));
        }
        return new MutableOptionsBundle(treeMap);
    }

    @Override // androidx.camera.core.impl.MutableConfig
    public <ValueT> void insertOption(@NonNull Config.Option<ValueT> option, @Nullable ValueT valuet) {
        this.mOptions.put(option, valuet);
    }

    @Override // androidx.camera.core.impl.MutableConfig
    @Nullable
    public <ValueT> ValueT removeOption(@NonNull Config.Option<ValueT> option) {
        return (ValueT) this.mOptions.remove(option);
    }
}
