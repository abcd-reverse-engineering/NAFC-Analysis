package com.bumptech.glide.load.p.c0;

import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* compiled from: RuntimeCompat.java */
/* loaded from: classes.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f4485a = "GlideRuntimeCompat";

    /* renamed from: b, reason: collision with root package name */
    private static final String f4486b = "cpu[0-9]+";

    /* renamed from: c, reason: collision with root package name */
    private static final String f4487c = "/sys/devices/system/cpu/";

    /* compiled from: RuntimeCompat.java */
    class a implements FilenameFilter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Pattern f4488a;

        a(Pattern pattern) {
            this.f4488a = pattern;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return this.f4488a.matcher(str).matches();
        }
    }

    private b() {
    }

    static int a() {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        return Build.VERSION.SDK_INT < 17 ? Math.max(b(), iAvailableProcessors) : iAvailableProcessors;
    }

    private static int b() {
        File[] fileArrListFiles;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                fileArrListFiles = new File(f4487c).listFiles(new a(Pattern.compile(f4486b)));
            } catch (Throwable unused) {
                Log.isLoggable(f4485a, 6);
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                fileArrListFiles = null;
            }
            return Math.max(1, fileArrListFiles != null ? fileArrListFiles.length : 0);
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }
}
