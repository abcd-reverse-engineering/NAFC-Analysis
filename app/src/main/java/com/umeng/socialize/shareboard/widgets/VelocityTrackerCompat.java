package com.umeng.socialize.shareboard.widgets;

import android.os.Build;
import android.view.VelocityTracker;

/* loaded from: classes2.dex */
class VelocityTrackerCompat {
    private static final VelocityTrackerVersionImpl IMPL;

    private static class BaseVelocityTrackerVersionImpl implements VelocityTrackerVersionImpl {
        private BaseVelocityTrackerVersionImpl() {
        }

        @Override // com.umeng.socialize.shareboard.widgets.VelocityTrackerCompat.VelocityTrackerVersionImpl
        public float getXVelocity(VelocityTracker velocityTracker, int i2) {
            return velocityTracker.getXVelocity();
        }
    }

    private static class HoneycombVelocityTrackerVersionImpl implements VelocityTrackerVersionImpl {
        private HoneycombVelocityTrackerVersionImpl() {
        }

        @Override // com.umeng.socialize.shareboard.widgets.VelocityTrackerCompat.VelocityTrackerVersionImpl
        public float getXVelocity(VelocityTracker velocityTracker, int i2) {
            return velocityTracker.getXVelocity(i2);
        }
    }

    interface VelocityTrackerVersionImpl {
        float getXVelocity(VelocityTracker velocityTracker, int i2);
    }

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            IMPL = new HoneycombVelocityTrackerVersionImpl();
        } else {
            IMPL = new BaseVelocityTrackerVersionImpl();
        }
    }

    VelocityTrackerCompat() {
    }

    static float getXVelocity(VelocityTracker velocityTracker, int i2) {
        return IMPL.getXVelocity(velocityTracker, i2);
    }
}
