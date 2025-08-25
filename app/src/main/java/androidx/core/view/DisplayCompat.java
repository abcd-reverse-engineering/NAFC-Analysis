package androidx.core.view;

import android.annotation.SuppressLint;
import android.app.UiModeManager;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.view.Display;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class DisplayCompat {
    private static final int DISPLAY_SIZE_4K_HEIGHT = 2160;
    private static final int DISPLAY_SIZE_4K_WIDTH = 3840;

    private DisplayCompat() {
    }

    private static Point getPhysicalDisplaySize(@NonNull Context context, @NonNull Display display) {
        Point physicalDisplaySizeFromSystemProperties = Build.VERSION.SDK_INT < 28 ? parsePhysicalDisplaySizeFromSystemProperties("sys.display-size", display) : parsePhysicalDisplaySizeFromSystemProperties("vendor.display-size", display);
        if (physicalDisplaySizeFromSystemProperties != null) {
            return physicalDisplaySizeFromSystemProperties;
        }
        if (isSonyBravia4kTv(context)) {
            return new Point(DISPLAY_SIZE_4K_WIDTH, DISPLAY_SIZE_4K_HEIGHT);
        }
        Point point = new Point();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            Display.Mode mode = display.getMode();
            point.x = mode.getPhysicalWidth();
            point.y = mode.getPhysicalHeight();
        } else if (i2 >= 17) {
            display.getRealSize(point);
        } else {
            display.getSize(point);
        }
        return point;
    }

    @NonNull
    @SuppressLint({"ArrayReturn"})
    public static ModeCompat[] getSupportedModes(@NonNull Context context, @NonNull Display display) {
        Point physicalDisplaySize = getPhysicalDisplaySize(context, display);
        if (Build.VERSION.SDK_INT < 23) {
            return new ModeCompat[]{new ModeCompat(physicalDisplaySize)};
        }
        Display.Mode[] supportedModes = display.getSupportedModes();
        ArrayList arrayList = new ArrayList(supportedModes.length);
        boolean z = false;
        for (int i2 = 0; i2 < supportedModes.length; i2++) {
            if (physicalSizeEquals(supportedModes[i2], physicalDisplaySize)) {
                arrayList.add(i2, new ModeCompat(supportedModes[i2], true));
                z = true;
            } else {
                arrayList.add(i2, new ModeCompat(supportedModes[i2], false));
            }
        }
        if (!z) {
            arrayList.add(new ModeCompat(physicalDisplaySize));
        }
        return (ModeCompat[]) arrayList.toArray(new ModeCompat[0]);
    }

    @Nullable
    private static String getSystemProperty(String str) throws ClassNotFoundException {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls, str);
        } catch (Exception unused) {
            return null;
        }
    }

    private static boolean isSonyBravia4kTv(@NonNull Context context) {
        return isTv(context) && "Sony".equals(Build.MANUFACTURER) && Build.MODEL.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd");
    }

    private static boolean isTv(@NonNull Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getSystemService("uimode");
        return uiModeManager != null && uiModeManager.getCurrentModeType() == 4;
    }

    private static Point parseDisplaySize(@NonNull String str) throws NumberFormatException {
        String[] strArrSplit = str.trim().split("x", -1);
        if (strArrSplit.length == 2) {
            int i2 = Integer.parseInt(strArrSplit[0]);
            int i3 = Integer.parseInt(strArrSplit[1]);
            if (i2 > 0 && i3 > 0) {
                return new Point(i2, i3);
            }
        }
        throw new NumberFormatException();
    }

    @Nullable
    private static Point parsePhysicalDisplaySizeFromSystemProperties(@NonNull String str, @NonNull Display display) throws ClassNotFoundException {
        if (display.getDisplayId() != 0) {
            return null;
        }
        String systemProperty = getSystemProperty(str);
        if (TextUtils.isEmpty(systemProperty)) {
            return null;
        }
        try {
            return parseDisplaySize(systemProperty);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @RequiresApi(23)
    private static boolean physicalSizeEquals(Display.Mode mode, Point point) {
        return (mode.getPhysicalWidth() == point.x && mode.getPhysicalHeight() == point.y) || (mode.getPhysicalWidth() == point.y && mode.getPhysicalHeight() == point.x);
    }

    public static final class ModeCompat {
        private final boolean mIsNative;
        private final Display.Mode mMode;
        private final Point mPhysicalDisplaySize;

        ModeCompat(@NonNull Point point) {
            Preconditions.checkNotNull(point, "physicalDisplaySize == null");
            this.mIsNative = true;
            this.mPhysicalDisplaySize = point;
            this.mMode = null;
        }

        public int getPhysicalHeight() {
            return this.mPhysicalDisplaySize.y;
        }

        public int getPhysicalWidth() {
            return this.mPhysicalDisplaySize.x;
        }

        public boolean isNative() {
            return this.mIsNative;
        }

        @Nullable
        @RequiresApi(23)
        public Display.Mode toMode() {
            return this.mMode;
        }

        @RequiresApi(23)
        ModeCompat(@NonNull Display.Mode mode, boolean z) {
            Preconditions.checkNotNull(mode, "Display.Mode == null, can't wrap a null reference");
            this.mIsNative = z;
            this.mPhysicalDisplaySize = new Point(mode.getPhysicalWidth(), mode.getPhysicalHeight());
            this.mMode = mode;
        }
    }
}
