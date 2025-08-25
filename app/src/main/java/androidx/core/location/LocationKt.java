package androidx.core.location;

import android.location.Location;
import h.q2.t.i0;
import h.y;
import i.c.a.d;

/* compiled from: Location.kt */
@y(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086\n\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0086\n¨\u0006\u0004"}, d2 = {"component1", "", "Landroid/location/Location;", "component2", "core-ktx_release"}, k = 2, mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class LocationKt {
    public static final double component1(@d Location location) {
        i0.f(location, "$receiver");
        return location.getLatitude();
    }

    public static final double component2(@d Location location) {
        i0.f(location, "$receiver");
        return location.getLongitude();
    }
}
