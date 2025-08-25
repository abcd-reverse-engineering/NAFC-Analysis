package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public class LensFacingConverter {
    private LensFacingConverter() {
    }

    @NonNull
    public static String nameOf(int i2) {
        if (i2 == 0) {
            return "FRONT";
        }
        if (i2 == 1) {
            return "BACK";
        }
        throw new IllegalArgumentException("Unknown lens facing " + i2);
    }

    public static int valueOf(@Nullable String str) {
        if (str == null) {
            throw new NullPointerException("name cannot be null");
        }
        char c2 = 65535;
        int iHashCode = str.hashCode();
        if (iHashCode != 2030823) {
            if (iHashCode == 67167753 && str.equals("FRONT")) {
                c2 = 0;
            }
        } else if (str.equals("BACK")) {
            c2 = 1;
        }
        if (c2 == 0) {
            return 0;
        }
        if (c2 == 1) {
            return 1;
        }
        throw new IllegalArgumentException("Unknown len facing name " + str);
    }

    @NonNull
    public static Integer[] values() {
        return new Integer[]{0, 1};
    }
}
