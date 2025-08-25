package androidx.camera.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
final class FlashModeConverter {
    private FlashModeConverter() {
    }

    @NonNull
    public static String nameOf(int i2) {
        if (i2 == 0) {
            return "AUTO";
        }
        if (i2 == 1) {
            return "ON";
        }
        if (i2 == 2) {
            return "OFF";
        }
        throw new IllegalArgumentException("Unknown flash mode " + i2);
    }

    public static int valueOf(@Nullable String str) {
        if (str == null) {
            throw new NullPointerException("name cannot be null");
        }
        char c2 = 65535;
        int iHashCode = str.hashCode();
        if (iHashCode != 2527) {
            if (iHashCode != 78159) {
                if (iHashCode == 2020783 && str.equals("AUTO")) {
                    c2 = 0;
                }
            } else if (str.equals("OFF")) {
                c2 = 2;
            }
        } else if (str.equals("ON")) {
            c2 = 1;
        }
        if (c2 == 0) {
            return 0;
        }
        if (c2 == 1) {
            return 1;
        }
        if (c2 == 2) {
            return 2;
        }
        throw new IllegalArgumentException("Unknown flash mode name " + str);
    }
}
