package androidx.transition;

import android.os.Build;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
class ViewGroupUtils {
    private ViewGroupUtils() {
    }

    static ViewGroupOverlayImpl getOverlay(@NonNull ViewGroup viewGroup) {
        return Build.VERSION.SDK_INT >= 18 ? new ViewGroupOverlayApi18(viewGroup) : ViewGroupOverlayApi14.createFrom(viewGroup);
    }

    static void suppressLayout(@NonNull ViewGroup viewGroup, boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (Build.VERSION.SDK_INT >= 18) {
            ViewGroupUtilsApi18.suppressLayout(viewGroup, z);
        } else {
            ViewGroupUtilsApi14.suppressLayout(viewGroup, z);
        }
    }
}
