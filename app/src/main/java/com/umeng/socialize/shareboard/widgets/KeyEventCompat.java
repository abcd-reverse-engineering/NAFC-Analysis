package com.umeng.socialize.shareboard.widgets;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.KeyEvent;

/* loaded from: classes2.dex */
class KeyEventCompat {
    private static final KeyEventVersionImpl IMPL;

    private static class BaseKeyEventVersionImpl implements KeyEventVersionImpl {
        private static final int META_ALL_MASK = 247;
        private static final int META_MODIFIER_MASK = 247;

        private BaseKeyEventVersionImpl() {
        }

        private static int metaStateFilterDirectionalModifiers(int i2, int i3, int i4, int i5, int i6) {
            int i7;
            boolean z = (i3 & i4) != 0;
            int i8 = i5 | i6;
            boolean z2 = (i3 & i8) != 0;
            if (z) {
                if (z2) {
                    throw new IllegalArgumentException("bad arguments");
                }
                i7 = ~i8;
            } else {
                if (!z2) {
                    return i2;
                }
                i7 = ~i4;
            }
            return i2 & i7;
        }

        private int normalizeMetaState(int i2) {
            if ((i2 & 192) != 0) {
                i2 |= 1;
            }
            if ((i2 & 48) != 0) {
                i2 |= 2;
            }
            return i2 & 247;
        }

        @Override // com.umeng.socialize.shareboard.widgets.KeyEventCompat.KeyEventVersionImpl
        public boolean metaStateHasModifiers(int i2, int i3) {
            return metaStateFilterDirectionalModifiers(metaStateFilterDirectionalModifiers(normalizeMetaState(i2) & 247, i3, 1, 64, 128), i3, 2, 16, 32) == i3;
        }

        @Override // com.umeng.socialize.shareboard.widgets.KeyEventCompat.KeyEventVersionImpl
        public boolean metaStateHasNoModifiers(int i2) {
            return (normalizeMetaState(i2) & 247) == 0;
        }
    }

    @TargetApi(11)
    private static class HoneycombKeyEventVersionImpl extends BaseKeyEventVersionImpl {
        private HoneycombKeyEventVersionImpl() {
            super();
        }

        @Override // com.umeng.socialize.shareboard.widgets.KeyEventCompat.BaseKeyEventVersionImpl, com.umeng.socialize.shareboard.widgets.KeyEventCompat.KeyEventVersionImpl
        public boolean metaStateHasModifiers(int i2, int i3) {
            return KeyEvent.metaStateHasModifiers(i2, i3);
        }

        @Override // com.umeng.socialize.shareboard.widgets.KeyEventCompat.BaseKeyEventVersionImpl, com.umeng.socialize.shareboard.widgets.KeyEventCompat.KeyEventVersionImpl
        public boolean metaStateHasNoModifiers(int i2) {
            return KeyEvent.metaStateHasNoModifiers(i2);
        }
    }

    interface KeyEventVersionImpl {
        boolean metaStateHasModifiers(int i2, int i3);

        boolean metaStateHasNoModifiers(int i2);
    }

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            IMPL = new HoneycombKeyEventVersionImpl();
        } else {
            IMPL = new BaseKeyEventVersionImpl();
        }
    }

    KeyEventCompat() {
    }

    public static boolean hasModifiers(KeyEvent keyEvent, int i2) {
        return IMPL.metaStateHasModifiers(keyEvent.getMetaState(), i2);
    }

    public static boolean hasNoModifiers(KeyEvent keyEvent) {
        return IMPL.metaStateHasNoModifiers(keyEvent.getMetaState());
    }
}
