package androidx.transition;

import android.graphics.Matrix;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
class GhostViewUtils {
    private GhostViewUtils() {
    }

    static GhostViewImpl addGhost(View view, ViewGroup viewGroup, Matrix matrix) {
        return Build.VERSION.SDK_INT >= 21 ? GhostViewApi21.addGhost(view, viewGroup, matrix) : GhostViewApi14.addGhost(view, viewGroup);
    }

    static void removeGhost(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (Build.VERSION.SDK_INT >= 21) {
            GhostViewApi21.removeGhost(view);
        } else {
            GhostViewApi14.removeGhost(view);
        }
    }
}
