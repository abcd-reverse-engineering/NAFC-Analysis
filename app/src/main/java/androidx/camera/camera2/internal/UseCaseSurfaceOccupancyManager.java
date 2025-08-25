package androidx.camera.camera2.internal;

import androidx.camera.core.ImageCapture;
import androidx.camera.core.UseCase;
import androidx.camera.core.VideoCapture;
import java.util.List;

/* loaded from: classes.dex */
final class UseCaseSurfaceOccupancyManager {
    private UseCaseSurfaceOccupancyManager() {
    }

    static void checkUseCaseLimitNotExceeded(List<UseCase> list, List<UseCase> list2) {
        int i2;
        if (list2 == null || list2.isEmpty()) {
            throw new IllegalArgumentException("No new use cases to be bound.");
        }
        int i3 = 0;
        if (list != null) {
            i2 = 0;
            for (UseCase useCase : list) {
                if (useCase instanceof ImageCapture) {
                    i3++;
                } else if (useCase instanceof VideoCapture) {
                    i2++;
                }
            }
        } else {
            i2 = 0;
        }
        for (UseCase useCase2 : list2) {
            if (useCase2 instanceof ImageCapture) {
                i3++;
            } else if (useCase2 instanceof VideoCapture) {
                i2++;
            }
        }
        if (i3 > 1) {
            throw new IllegalArgumentException("Exceeded max simultaneously bound image capture use cases.");
        }
        if (i2 > 1) {
            throw new IllegalArgumentException("Exceeded max simultaneously bound video capture use cases.");
        }
    }
}
