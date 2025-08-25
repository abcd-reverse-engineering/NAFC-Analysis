package androidx.core.os;

import android.os.Build;
import android.os.Trace;
import androidx.annotation.NonNull;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class TraceCompat {
    private static final String TAG = "TraceCompat";
    private static Method sAsyncTraceBeginMethod;
    private static Method sAsyncTraceEndMethod;
    private static Method sIsTagEnabledMethod;
    private static Method sTraceCounterMethod;
    private static long sTraceTagApp;

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 18 || i2 >= 29) {
            return;
        }
        try {
            sTraceTagApp = Trace.class.getField("TRACE_TAG_APP").getLong(null);
            sIsTagEnabledMethod = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            sAsyncTraceBeginMethod = Trace.class.getMethod("asyncTraceBegin", Long.TYPE, String.class, Integer.TYPE);
            sAsyncTraceEndMethod = Trace.class.getMethod("asyncTraceEnd", Long.TYPE, String.class, Integer.TYPE);
            sTraceCounterMethod = Trace.class.getMethod("traceCounter", Long.TYPE, String.class, Integer.TYPE);
        } catch (Exception unused) {
        }
    }

    private TraceCompat() {
    }

    public static void beginAsyncSection(@NonNull String str, int i2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 29) {
            Trace.beginAsyncSection(str, i2);
        } else if (i3 >= 18) {
            try {
                sAsyncTraceBeginMethod.invoke(null, Long.valueOf(sTraceTagApp), str, Integer.valueOf(i2));
            } catch (Exception unused) {
            }
        }
    }

    public static void beginSection(@NonNull String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.beginSection(str);
        }
    }

    public static void endAsyncSection(@NonNull String str, int i2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 29) {
            Trace.endAsyncSection(str, i2);
        } else if (i3 >= 18) {
            try {
                sAsyncTraceEndMethod.invoke(null, Long.valueOf(sTraceTagApp), str, Integer.valueOf(i2));
            } catch (Exception unused) {
            }
        }
    }

    public static void endSection() {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.endSection();
        }
    }

    public static boolean isEnabled() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            return Trace.isEnabled();
        }
        if (i2 >= 18) {
            try {
                return ((Boolean) sIsTagEnabledMethod.invoke(null, Long.valueOf(sTraceTagApp))).booleanValue();
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static void setCounter(@NonNull String str, int i2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 29) {
            Trace.setCounter(str, i2);
        } else if (i3 >= 18) {
            try {
                sTraceCounterMethod.invoke(null, Long.valueOf(sTraceTagApp), str, Integer.valueOf(i2));
            } catch (Exception unused) {
            }
        }
    }
}
