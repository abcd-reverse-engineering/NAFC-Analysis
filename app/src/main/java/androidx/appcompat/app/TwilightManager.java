package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.PermissionChecker;
import java.util.Calendar;
import util.permissionutil.a;

/* loaded from: classes.dex */
class TwilightManager {
    private static final int SUNRISE = 6;
    private static final int SUNSET = 22;
    private static final String TAG = "TwilightManager";
    private static TwilightManager sInstance;
    private final Context mContext;
    private final LocationManager mLocationManager;
    private final TwilightState mTwilightState = new TwilightState();

    private static class TwilightState {
        boolean isNight;
        long nextUpdate;
        long todaySunrise;
        long todaySunset;
        long tomorrowSunrise;
        long yesterdaySunset;

        TwilightState() {
        }
    }

    @VisibleForTesting
    TwilightManager(@NonNull Context context, @NonNull LocationManager locationManager) {
        this.mContext = context;
        this.mLocationManager = locationManager;
    }

    static TwilightManager getInstance(@NonNull Context context) {
        if (sInstance == null) {
            Context applicationContext = context.getApplicationContext();
            sInstance = new TwilightManager(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return sInstance;
    }

    @SuppressLint({"MissingPermission"})
    private Location getLastKnownLocation() {
        Location lastKnownLocationForProvider = PermissionChecker.checkSelfPermission(this.mContext, a.f20914h) == 0 ? getLastKnownLocationForProvider("network") : null;
        Location lastKnownLocationForProvider2 = PermissionChecker.checkSelfPermission(this.mContext, a.f20913g) == 0 ? getLastKnownLocationForProvider("gps") : null;
        return (lastKnownLocationForProvider2 == null || lastKnownLocationForProvider == null) ? lastKnownLocationForProvider2 != null ? lastKnownLocationForProvider2 : lastKnownLocationForProvider : lastKnownLocationForProvider2.getTime() > lastKnownLocationForProvider.getTime() ? lastKnownLocationForProvider2 : lastKnownLocationForProvider;
    }

    @RequiresPermission(anyOf = {a.f20914h, a.f20913g})
    private Location getLastKnownLocationForProvider(String str) {
        try {
            if (this.mLocationManager.isProviderEnabled(str)) {
                return this.mLocationManager.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private boolean isStateValid() {
        return this.mTwilightState.nextUpdate > System.currentTimeMillis();
    }

    @VisibleForTesting
    static void setInstance(TwilightManager twilightManager) {
        sInstance = twilightManager;
    }

    private void updateState(@NonNull Location location) {
        long j2;
        TwilightState twilightState = this.mTwilightState;
        long jCurrentTimeMillis = System.currentTimeMillis();
        TwilightCalculator twilightCalculator = TwilightCalculator.getInstance();
        twilightCalculator.calculateTwilight(jCurrentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j3 = twilightCalculator.sunset;
        twilightCalculator.calculateTwilight(jCurrentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = twilightCalculator.state == 1;
        long j4 = twilightCalculator.sunrise;
        long j5 = twilightCalculator.sunset;
        boolean z2 = z;
        twilightCalculator.calculateTwilight(86400000 + jCurrentTimeMillis, location.getLatitude(), location.getLongitude());
        long j6 = twilightCalculator.sunrise;
        if (j4 == -1 || j5 == -1) {
            j2 = com.heytap.mcssdk.constant.a.f5803g + jCurrentTimeMillis;
        } else {
            j2 = (jCurrentTimeMillis > j5 ? 0 + j6 : jCurrentTimeMillis > j4 ? 0 + j5 : 0 + j4) + com.heytap.mcssdk.constant.a.f5800d;
        }
        twilightState.isNight = z2;
        twilightState.yesterdaySunset = j3;
        twilightState.todaySunrise = j4;
        twilightState.todaySunset = j5;
        twilightState.tomorrowSunrise = j6;
        twilightState.nextUpdate = j2;
    }

    boolean isNight() {
        TwilightState twilightState = this.mTwilightState;
        if (isStateValid()) {
            return twilightState.isNight;
        }
        Location lastKnownLocation = getLastKnownLocation();
        if (lastKnownLocation != null) {
            updateState(lastKnownLocation);
            return twilightState.isNight;
        }
        int i2 = Calendar.getInstance().get(11);
        return i2 < 6 || i2 >= 22;
    }
}
