package cn.cloudwalk;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/* loaded from: classes.dex */
public class PreferencesUtils {
    public static boolean getBoolean(Context context, String str, boolean z) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(str, z);
    }

    public static float getFloat(Context context, String str, float f2) {
        return PreferenceManager.getDefaultSharedPreferences(context).getFloat(str, f2);
    }

    public static int getInt(Context context, String str, int i2) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(str, i2);
    }

    public static long getLong(Context context, String str) {
        return getLong(context, str, -1L);
    }

    public static String getString(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(str, null);
    }

    public static boolean putBoolean(Context context, String str, boolean z) {
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.putBoolean(str, z);
        return editorEdit.commit();
    }

    public static boolean putFloat(Context context, String str, float f2) {
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.putFloat(str, f2);
        return editorEdit.commit();
    }

    public static boolean putInt(Context context, String str, int i2) {
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.putInt(str, i2);
        return editorEdit.commit();
    }

    public static boolean putLong(Context context, String str, long j2) {
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.putLong(str, j2);
        return editorEdit.commit();
    }

    public static boolean putString(Context context, String str, String str2) {
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.putString(str, str2);
        return editorEdit.commit();
    }

    public static boolean removeSharedPreferenceByKey(Context context, String str) {
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.remove(str);
        return editorEdit.commit();
    }

    public static long getLong(Context context, String str, long j2) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong(str, j2);
    }

    public static String getString(Context context, String str, String str2) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(str, str2);
    }
}
