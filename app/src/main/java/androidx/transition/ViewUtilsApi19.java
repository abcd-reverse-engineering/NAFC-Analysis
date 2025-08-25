package androidx.transition;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RequiresApi(19)
/* loaded from: classes.dex */
class ViewUtilsApi19 extends ViewUtilsBase {
    private static final String TAG = "ViewUtilsApi19";
    private static Method sGetTransitionAlphaMethod;
    private static boolean sGetTransitionAlphaMethodFetched;
    private static Method sSetTransitionAlphaMethod;
    private static boolean sSetTransitionAlphaMethodFetched;

    ViewUtilsApi19() {
    }

    private void fetchGetTransitionAlphaMethod() {
        if (sGetTransitionAlphaMethodFetched) {
            return;
        }
        try {
            sGetTransitionAlphaMethod = View.class.getDeclaredMethod("getTransitionAlpha", new Class[0]);
            sGetTransitionAlphaMethod.setAccessible(true);
        } catch (NoSuchMethodException unused) {
        }
        sGetTransitionAlphaMethodFetched = true;
    }

    private void fetchSetTransitionAlphaMethod() {
        if (sSetTransitionAlphaMethodFetched) {
            return;
        }
        try {
            sSetTransitionAlphaMethod = View.class.getDeclaredMethod("setTransitionAlpha", Float.TYPE);
            sSetTransitionAlphaMethod.setAccessible(true);
        } catch (NoSuchMethodException unused) {
        }
        sSetTransitionAlphaMethodFetched = true;
    }

    @Override // androidx.transition.ViewUtilsBase
    public void clearNonTransitionAlpha(@NonNull View view) {
    }

    @Override // androidx.transition.ViewUtilsBase
    public float getTransitionAlpha(@NonNull View view) {
        fetchGetTransitionAlphaMethod();
        Method method = sGetTransitionAlphaMethod;
        if (method != null) {
            try {
                return ((Float) method.invoke(view, new Object[0])).floatValue();
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
        return super.getTransitionAlpha(view);
    }

    @Override // androidx.transition.ViewUtilsBase
    public void saveNonTransitionAlpha(@NonNull View view) {
    }

    @Override // androidx.transition.ViewUtilsBase
    public void setTransitionAlpha(@NonNull View view, float f2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        fetchSetTransitionAlphaMethod();
        Method method = sSetTransitionAlphaMethod;
        if (method == null) {
            view.setAlpha(f2);
            return;
        }
        try {
            method.invoke(view, Float.valueOf(f2));
        } catch (IllegalAccessException unused) {
        } catch (InvocationTargetException e2) {
            throw new RuntimeException(e2.getCause());
        }
    }
}
