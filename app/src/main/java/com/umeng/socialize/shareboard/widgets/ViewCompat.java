package com.umeng.socialize.shareboard.widgets;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;

/* loaded from: classes2.dex */
class ViewCompat {
    private static final long FAKE_FRAME_TIME = 10;
    private static final ViewCompatImpl IMPL;

    private static class Api24ViewCompatImpl extends MarshmallowViewCompatImpl {
        private Api24ViewCompatImpl() {
            super();
        }
    }

    static class BaseViewCompatImpl implements ViewCompatImpl {
        BaseViewCompatImpl() {
        }

        @Override // com.umeng.socialize.shareboard.widgets.ViewCompat.ViewCompatImpl
        public boolean canScrollHorizontally(View view, int i2) {
            return false;
        }

        @Override // com.umeng.socialize.shareboard.widgets.ViewCompat.ViewCompatImpl
        public WindowInsetsCompat dispatchApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            return windowInsetsCompat;
        }

        long getFrameTime() {
            return ViewCompat.FAKE_FRAME_TIME;
        }

        @Override // com.umeng.socialize.shareboard.widgets.ViewCompat.ViewCompatImpl
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            return windowInsetsCompat;
        }

        @Override // com.umeng.socialize.shareboard.widgets.ViewCompat.ViewCompatImpl
        public void postInvalidateOnAnimation(View view) {
            view.invalidate();
        }

        @Override // com.umeng.socialize.shareboard.widgets.ViewCompat.ViewCompatImpl
        public void postOnAnimation(View view, Runnable runnable) {
            view.postDelayed(runnable, getFrameTime());
        }

        @Override // com.umeng.socialize.shareboard.widgets.ViewCompat.ViewCompatImpl
        public void setOnApplyWindowInsetsListener(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        }
    }

    @TargetApi(11)
    static class HCViewCompatImpl extends BaseViewCompatImpl {
        HCViewCompatImpl() {
        }

        @Override // com.umeng.socialize.shareboard.widgets.ViewCompat.BaseViewCompatImpl
        long getFrameTime() {
            return ValueAnimator.getFrameDelay();
        }
    }

    static class ICSMr1ViewCompatImpl extends ICSViewCompatImpl {
        ICSMr1ViewCompatImpl() {
        }
    }

    @TargetApi(14)
    static class ICSViewCompatImpl extends HCViewCompatImpl {
        ICSViewCompatImpl() {
        }

        @Override // com.umeng.socialize.shareboard.widgets.ViewCompat.BaseViewCompatImpl, com.umeng.socialize.shareboard.widgets.ViewCompat.ViewCompatImpl
        public boolean canScrollHorizontally(View view, int i2) {
            return view.canScrollHorizontally(i2);
        }
    }

    @TargetApi(16)
    static class JBViewCompatImpl extends ICSMr1ViewCompatImpl {
        JBViewCompatImpl() {
        }

        @Override // com.umeng.socialize.shareboard.widgets.ViewCompat.BaseViewCompatImpl, com.umeng.socialize.shareboard.widgets.ViewCompat.ViewCompatImpl
        public void postInvalidateOnAnimation(View view) {
            view.postInvalidateOnAnimation();
        }

        @Override // com.umeng.socialize.shareboard.widgets.ViewCompat.BaseViewCompatImpl, com.umeng.socialize.shareboard.widgets.ViewCompat.ViewCompatImpl
        public void postOnAnimation(View view, Runnable runnable) {
            view.postOnAnimation(runnable);
        }
    }

    private static class JbMr1ViewCompatImpl extends JBViewCompatImpl {
        private JbMr1ViewCompatImpl() {
        }
    }

    private static class JbMr2ViewCompatImpl extends JbMr1ViewCompatImpl {
        private JbMr2ViewCompatImpl() {
            super();
        }
    }

    private static class KitKatViewCompatImpl extends JbMr2ViewCompatImpl {
        private KitKatViewCompatImpl() {
            super();
        }
    }

    @TargetApi(20)
    private static class LollipopViewCompatImpl extends KitKatViewCompatImpl {
        private LollipopViewCompatImpl() {
            super();
        }

        @Override // com.umeng.socialize.shareboard.widgets.ViewCompat.BaseViewCompatImpl, com.umeng.socialize.shareboard.widgets.ViewCompat.ViewCompatImpl
        public WindowInsetsCompat dispatchApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            return WindowInsetsCompat.wrap(dispatchApplyWindowInsets(view, WindowInsetsCompat.unwrap(windowInsetsCompat)));
        }

        @Override // com.umeng.socialize.shareboard.widgets.ViewCompat.BaseViewCompatImpl, com.umeng.socialize.shareboard.widgets.ViewCompat.ViewCompatImpl
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            return WindowInsetsCompat.wrap(onApplyWindowInsets(view, WindowInsetsCompat.unwrap(windowInsetsCompat)));
        }

        @Override // com.umeng.socialize.shareboard.widgets.ViewCompat.BaseViewCompatImpl, com.umeng.socialize.shareboard.widgets.ViewCompat.ViewCompatImpl
        public void setOnApplyWindowInsetsListener(View view, final OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
            if (onApplyWindowInsetsListener == null) {
                view.setOnApplyWindowInsetsListener(null);
            } else {
                final OnApplyWindowInsetsListenerBridge onApplyWindowInsetsListenerBridge = new OnApplyWindowInsetsListenerBridge() { // from class: com.umeng.socialize.shareboard.widgets.ViewCompat.LollipopViewCompatImpl.1
                    @Override // com.umeng.socialize.shareboard.widgets.ViewCompat.OnApplyWindowInsetsListenerBridge
                    public Object onApplyWindowInsets(View view2, Object obj) {
                        return WindowInsetsCompat.unwrap(onApplyWindowInsetsListener.onApplyWindowInsets(view2, WindowInsetsCompat.wrap(obj)));
                    }
                };
                view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.umeng.socialize.shareboard.widgets.ViewCompat.LollipopViewCompatImpl.2
                    @Override // android.view.View.OnApplyWindowInsetsListener
                    public WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
                        return (WindowInsets) onApplyWindowInsetsListenerBridge.onApplyWindowInsets(view2, windowInsets);
                    }
                });
            }
        }

        private static Object dispatchApplyWindowInsets(View view, Object obj) {
            WindowInsets windowInsets = (WindowInsets) obj;
            WindowInsets windowInsetsDispatchApplyWindowInsets = view.dispatchApplyWindowInsets(windowInsets);
            return windowInsetsDispatchApplyWindowInsets != windowInsets ? new WindowInsets(windowInsetsDispatchApplyWindowInsets) : obj;
        }

        private static Object onApplyWindowInsets(View view, Object obj) {
            WindowInsets windowInsets = (WindowInsets) obj;
            WindowInsets windowInsetsOnApplyWindowInsets = view.onApplyWindowInsets(windowInsets);
            return windowInsetsOnApplyWindowInsets != windowInsets ? new WindowInsets(windowInsetsOnApplyWindowInsets) : obj;
        }
    }

    private static class MarshmallowViewCompatImpl extends LollipopViewCompatImpl {
        private MarshmallowViewCompatImpl() {
            super();
        }
    }

    interface OnApplyWindowInsetsListener {
        WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat);
    }

    interface OnApplyWindowInsetsListenerBridge {
        Object onApplyWindowInsets(View view, Object obj);
    }

    interface ViewCompatImpl {
        boolean canScrollHorizontally(View view, int i2);

        WindowInsetsCompat dispatchApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat);

        WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat);

        void postInvalidateOnAnimation(View view);

        void postOnAnimation(View view, Runnable runnable);

        void setOnApplyWindowInsetsListener(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener);
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 24) {
            IMPL = new Api24ViewCompatImpl();
            return;
        }
        if (i2 >= 23) {
            IMPL = new MarshmallowViewCompatImpl();
            return;
        }
        if (i2 >= 21) {
            IMPL = new LollipopViewCompatImpl();
            return;
        }
        if (i2 >= 19) {
            IMPL = new KitKatViewCompatImpl();
            return;
        }
        if (i2 >= 18) {
            IMPL = new JbMr2ViewCompatImpl();
            return;
        }
        if (i2 >= 17) {
            IMPL = new JbMr1ViewCompatImpl();
            return;
        }
        if (i2 >= 16) {
            IMPL = new JBViewCompatImpl();
            return;
        }
        if (i2 >= 15) {
            IMPL = new ICSMr1ViewCompatImpl();
            return;
        }
        if (i2 >= 14) {
            IMPL = new ICSViewCompatImpl();
        } else if (i2 >= 11) {
            IMPL = new HCViewCompatImpl();
        } else {
            IMPL = new BaseViewCompatImpl();
        }
    }

    ViewCompat() {
    }

    static boolean canScrollHorizontally(View view, int i2) {
        return IMPL.canScrollHorizontally(view, i2);
    }

    public static WindowInsetsCompat dispatchApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return IMPL.dispatchApplyWindowInsets(view, windowInsetsCompat);
    }

    public static WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return IMPL.onApplyWindowInsets(view, windowInsetsCompat);
    }

    static void postInvalidateOnAnimation(View view) {
        IMPL.postInvalidateOnAnimation(view);
    }

    static void postOnAnimation(View view, Runnable runnable) {
        IMPL.postOnAnimation(view, runnable);
    }

    public static void setOnApplyWindowInsetsListener(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        IMPL.setOnApplyWindowInsetsListener(view, onApplyWindowInsetsListener);
    }
}
