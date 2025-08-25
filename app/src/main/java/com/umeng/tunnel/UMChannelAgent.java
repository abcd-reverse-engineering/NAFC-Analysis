package com.umeng.tunnel;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/* loaded from: classes2.dex */
public class UMChannelAgent {
    private static final String TAG = "UMChannelAgent";
    private static final String UMENG_VCHANNEL = "com.umeng.commonsdk.vchannel.Sender";
    private static boolean vChannelReady = false;

    static {
        try {
            if (Class.forName(UMENG_VCHANNEL) != null) {
                vChannelReady = true;
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean init() {
        boolean z = vChannelReady;
        return vChannelReady;
    }

    public static void onDebugEvent(Context context, String str, Map<String, Object> map) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        reflectOnEvent(context, str, map);
    }

    private static void reflectOnEvent(Context context, String str, Map<String, Object> map) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            Class.forName(UMENG_VCHANNEL).getMethod("onEvent", Context.class, String.class, Map.class).invoke(null, context, str, map);
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | Exception unused) {
        }
    }

    private static void reflectSetCustomHeader(Map<String, String> map) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            Class.forName(UMENG_VCHANNEL).getMethod("setCustomHeader", Map.class).invoke(null, map);
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | Exception unused) {
        }
    }

    public static void setCustomHeader(Map<String, String> map) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        reflectSetCustomHeader(map);
    }
}
