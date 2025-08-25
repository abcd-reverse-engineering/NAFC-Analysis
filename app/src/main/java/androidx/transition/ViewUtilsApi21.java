package androidx.transition;

import android.graphics.Matrix;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RequiresApi(21)
/* loaded from: classes.dex */
class ViewUtilsApi21 extends ViewUtilsApi19 {
    private static final String TAG = "ViewUtilsApi21";
    private static Method sSetAnimationMatrixMethod;
    private static boolean sSetAnimationMatrixMethodFetched;
    private static Method sTransformMatrixToGlobalMethod;
    private static boolean sTransformMatrixToGlobalMethodFetched;
    private static Method sTransformMatrixToLocalMethod;
    private static boolean sTransformMatrixToLocalMethodFetched;

    ViewUtilsApi21() {
    }

    private void fetchSetAnimationMatrix() {
        if (sSetAnimationMatrixMethodFetched) {
            return;
        }
        try {
            sSetAnimationMatrixMethod = View.class.getDeclaredMethod("setAnimationMatrix", Matrix.class);
            sSetAnimationMatrixMethod.setAccessible(true);
        } catch (NoSuchMethodException unused) {
        }
        sSetAnimationMatrixMethodFetched = true;
    }

    private void fetchTransformMatrixToGlobalMethod() {
        if (sTransformMatrixToGlobalMethodFetched) {
            return;
        }
        try {
            sTransformMatrixToGlobalMethod = View.class.getDeclaredMethod("transformMatrixToGlobal", Matrix.class);
            sTransformMatrixToGlobalMethod.setAccessible(true);
        } catch (NoSuchMethodException unused) {
        }
        sTransformMatrixToGlobalMethodFetched = true;
    }

    private void fetchTransformMatrixToLocalMethod() {
        if (sTransformMatrixToLocalMethodFetched) {
            return;
        }
        try {
            sTransformMatrixToLocalMethod = View.class.getDeclaredMethod("transformMatrixToLocal", Matrix.class);
            sTransformMatrixToLocalMethod.setAccessible(true);
        } catch (NoSuchMethodException unused) {
        }
        sTransformMatrixToLocalMethodFetched = true;
    }

    @Override // androidx.transition.ViewUtilsBase
    public void setAnimationMatrix(@NonNull View view, Matrix matrix) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        fetchSetAnimationMatrix();
        Method method = sSetAnimationMatrixMethod;
        if (method != null) {
            try {
                method.invoke(view, matrix);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2.getCause());
            } catch (InvocationTargetException unused) {
            }
        }
    }

    @Override // androidx.transition.ViewUtilsBase
    public void transformMatrixToGlobal(@NonNull View view, @NonNull Matrix matrix) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        fetchTransformMatrixToGlobalMethod();
        Method method = sTransformMatrixToGlobalMethod;
        if (method != null) {
            try {
                method.invoke(view, matrix);
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }

    @Override // androidx.transition.ViewUtilsBase
    public void transformMatrixToLocal(@NonNull View view, @NonNull Matrix matrix) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        fetchTransformMatrixToLocalMethod();
        Method method = sTransformMatrixToLocalMethod;
        if (method != null) {
            try {
                method.invoke(view, matrix);
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }
}
