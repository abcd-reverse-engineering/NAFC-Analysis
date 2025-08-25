package androidx.camera.view;

import android.content.Context;
import android.graphics.Point;
import android.util.Pair;
import android.util.Size;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
final class ScaleTypeTransform {
    private ScaleTypeTransform() {
    }

    static Pair<Float, Float> getFillScaleWithBufferAspectRatio(@NonNull View view, @NonNull View view2, @NonNull Size size) {
        int width;
        int height;
        if (view.getWidth() == 0 || view.getHeight() == 0 || view2.getWidth() == 0 || view2.getHeight() == 0 || size.getWidth() == 0 || size.getHeight() == 0) {
            return new Pair<>(Float.valueOf(1.0f), Float.valueOf(1.0f));
        }
        int rotationDegrees = getRotationDegrees(view2);
        if (isNaturalPortrait(view2.getContext(), rotationDegrees)) {
            width = size.getHeight();
            height = size.getWidth();
        } else {
            width = size.getWidth();
            height = size.getHeight();
        }
        float width2 = width / view2.getWidth();
        float height2 = height / view2.getHeight();
        if (rotationDegrees == 0 || rotationDegrees == 180) {
            int i2 = width;
            width = height;
            height = i2;
        }
        float fMax = Math.max(view.getWidth() / height, view.getHeight() / width);
        return new Pair<>(Float.valueOf(width2 * fMax), Float.valueOf(height2 * fMax));
    }

    static Point getOriginOfCenteredView(@NonNull View view, @NonNull View view2) {
        return new Point(-((view2.getWidth() - view.getWidth()) / 2), -((view2.getHeight() - view.getHeight()) / 2));
    }

    static int getRotationDegrees(@NonNull View view) {
        WindowManager windowManager = (WindowManager) view.getContext().getSystemService("window");
        if (windowManager == null) {
            return 0;
        }
        return SurfaceRotation.rotationDegreesFromSurfaceRotation(windowManager.getDefaultDisplay().getRotation());
    }

    private static boolean isNaturalPortrait(@NonNull Context context, int i2) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            return true;
        }
        Display defaultDisplay = windowManager.getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        int i3 = point.x;
        int i4 = point.y;
        if ((i2 == 0 || i2 == 180) && i3 < i4) {
            return true;
        }
        return (i2 == 90 || i2 == 270) && i3 >= i4;
    }
}
