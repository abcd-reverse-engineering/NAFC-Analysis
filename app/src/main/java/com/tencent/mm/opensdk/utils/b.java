package com.tencent.mm.opensdk.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static Context f9710a;

    /* renamed from: b, reason: collision with root package name */
    private static final int f9711b;

    /* renamed from: c, reason: collision with root package name */
    private static final int f9712c;

    /* renamed from: d, reason: collision with root package name */
    private static final int f9713d;

    /* renamed from: e, reason: collision with root package name */
    public static ThreadPoolExecutor f9714e;

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        f9711b = iAvailableProcessors;
        f9712c = iAvailableProcessors + 1;
        f9713d = (iAvailableProcessors * 2) + 1;
        f9714e = new ThreadPoolExecutor(f9712c, f9713d, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque());
    }

    public static int a(ContentResolver contentResolver, Uri uri) throws IOException {
        Log.i("MicroMsg.SDK.Util", "getFileSize with content url");
        if (contentResolver == null || uri == null) {
            Log.w("MicroMsg.SDK.Util", "getFileSize fail, resolver or uri is null");
            return 0;
        }
        InputStream inputStream = null;
        try {
            try {
                InputStream inputStreamOpenInputStream = contentResolver.openInputStream(uri);
                if (inputStreamOpenInputStream == null) {
                    if (inputStreamOpenInputStream != null) {
                        try {
                            inputStreamOpenInputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                    return 0;
                }
                int iAvailable = inputStreamOpenInputStream.available();
                try {
                    inputStreamOpenInputStream.close();
                } catch (IOException unused2) {
                }
                return iAvailable;
            } catch (Exception e2) {
                Log.w("MicroMsg.SDK.Util", "getFileSize fail, " + e2.getMessage());
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                return 0;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException unused4) {
                }
            }
            throw th;
        }
    }

    public static int a(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        File file = new File(str);
        if (file.exists()) {
            return (int) file.length();
        }
        if (f9710a != null && str.startsWith("content")) {
            try {
                return a(f9710a.getContentResolver(), Uri.parse(str));
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public static int a(String str, int i2) {
        if (str == null) {
            return i2;
        }
        try {
            return str.length() <= 0 ? i2 : Integer.parseInt(str);
        } catch (Exception unused) {
            return i2;
        }
    }

    public static boolean a(int i2) {
        return i2 == 36 || i2 == 46;
    }

    public static boolean b(String str) {
        return str == null || str.length() <= 0;
    }
}
