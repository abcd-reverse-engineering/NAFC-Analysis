package com.tencent.bugly.beta.tinker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.Signature;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.util.TinkerLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Formatter;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class TinkerUtils {
    public static final int ERROR_PATCH_CONDITION_NOT_SATISFIED = -24;
    public static final int ERROR_PATCH_CRASH_LIMIT = -23;
    public static final int ERROR_PATCH_GOOGLEPLAY_CHANNEL = -20;
    public static final int ERROR_PATCH_MEMORY_LIMIT = -22;
    public static final int ERROR_PATCH_ROM_SPACE = -21;
    public static final int MIN_MEMORY_HEAP_SIZE = 45;
    public static final String PLATFORM = "platform";
    private static final String TAG = "Tinker.TinkerUtils";
    private static boolean background = false;

    /* compiled from: BUGLY */
    public static class ScreenState {

        /* compiled from: BUGLY */
        interface IOnScreenOff {
            void onScreenOff();
        }

        ScreenState(Context context, final IOnScreenOff iOnScreenOff) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            context.registerReceiver(new BroadcastReceiver() { // from class: com.tencent.bugly.beta.tinker.TinkerUtils.ScreenState.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context2, Intent intent) {
                    String action = intent == null ? "" : intent.getAction();
                    TinkerLog.i(TinkerUtils.TAG, "ScreenReceiver action [%s] ", new Object[]{action});
                    if ("android.intent.action.SCREEN_OFF".equals(action)) {
                        IOnScreenOff iOnScreenOff2 = iOnScreenOff;
                        if (iOnScreenOff2 != null) {
                            iOnScreenOff2.onScreenOff();
                        }
                        context2.unregisterReceiver(this);
                    }
                }
            }, intentFilter);
        }
    }

    public static String bytesToHexString(byte[] bArr, boolean z) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        Formatter formatter = new Formatter(stringBuffer);
        for (byte b2 : bArr) {
            formatter.format("%02x", Byte.valueOf(b2));
        }
        formatter.close();
        String string = stringBuffer.toString();
        return z ? string.toUpperCase() : string.toLowerCase();
    }

    public static int checkForPatchRecover(long j2, int i2) {
        if (isGooglePlay()) {
            return -20;
        }
        if (i2 < 45) {
            return -22;
        }
        return !checkRomSpaceEnough(j2) ? -21 : 0;
    }

    @Deprecated
    public static boolean checkRomSpaceEnough(long j2) {
        long availableBlocks;
        long blockSize;
        StatFs statFs;
        try {
            statFs = new StatFs(Environment.getDataDirectory().getPath());
            availableBlocks = statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Exception unused) {
            availableBlocks = 0;
        }
        try {
            blockSize = statFs.getBlockSize() * statFs.getBlockCount();
        } catch (Exception unused2) {
            blockSize = 0;
            return blockSize == 0 ? false : false;
        }
        if (blockSize == 0 && availableBlocks > j2) {
            return true;
        }
    }

    public static boolean copy(File file, File file2) throws Throwable {
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream2;
        if (file == null || file2 == null || !file.exists()) {
            return false;
        }
        BufferedInputStream bufferedInputStream2 = null;
        try {
            String absolutePath = file2.getAbsolutePath();
            File file3 = new File(absolutePath.substring(0, absolutePath.lastIndexOf(File.separator)));
            if (!file3.exists()) {
                file3.mkdirs();
            }
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file2));
            } catch (Throwable th) {
                th = th;
                bufferedOutputStream = null;
                bufferedInputStream2 = bufferedInputStream;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedOutputStream = null;
        }
        try {
            byte[] bArr = new byte[5120];
            while (true) {
                int i2 = bufferedInputStream.read(bArr);
                if (i2 == -1) {
                    break;
                }
                bufferedOutputStream2.write(bArr, 0, i2);
            }
            bufferedOutputStream2.flush();
            try {
                bufferedInputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            try {
                bufferedOutputStream2.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            return true;
        } catch (Throwable th3) {
            bufferedInputStream2 = bufferedInputStream;
            bufferedOutputStream = bufferedOutputStream2;
            th = th3;
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            if (bufferedOutputStream == null) {
                throw th;
            }
            try {
                bufferedOutputStream.close();
                throw th;
            } catch (IOException e5) {
                e5.printStackTrace();
                throw th;
            }
        }
    }

    public static String getExceptionCauseString(Throwable th) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        while (th != null) {
            try {
                if (th.getCause() == null) {
                    break;
                }
                th = th.getCause();
            } catch (Throwable th2) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                throw th2;
            }
        }
        if (th != null) {
            th.printStackTrace(printStream);
        }
        String visualString = toVisualString(byteArrayOutputStream.toString());
        try {
            byteArrayOutputStream.close();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        return visualString;
    }

    public static String getSignature(Context context) throws NoSuchAlgorithmException {
        try {
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
            if (signatureArr == null || signatureArr.length <= 0) {
                return "";
            }
            X509Certificate x509Certificate = (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()));
            MessageDigest.getInstance("SHA-1");
            return new String(x509Certificate.getEncoded());
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static boolean isBackground() {
        return background;
    }

    public static boolean isGooglePlay() {
        return false;
    }

    public static boolean isXposedExists(Throwable th) {
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            String className = stackTraceElement.getClassName();
            if (className != null && className.contains("de.robv.android.xposed.XposedBridge")) {
                return true;
            }
        }
        return false;
    }

    public static byte[] readBytes(InputStream inputStream) throws IOException {
        try {
            byte[] bArr = new byte[512];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int i2 = inputStream.read(bArr);
                if (i2 == -1) {
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, i2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static byte[] readJarEntry(File file, String str) {
        if (file != null) {
            try {
                if (file.exists() && !TextUtils.isEmpty(str)) {
                    return readJarEntry(new JarFile(file), str);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static void rollbackPatch(Context context) {
        Tinker.with(context).rollbackPatch();
    }

    public static void setBackground(boolean z) {
        background = z;
    }

    private static String toVisualString(String str) {
        char[] charArray;
        boolean z;
        if (str == null || (charArray = str.toCharArray()) == null) {
            return null;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= charArray.length) {
                z = false;
                break;
            }
            if (charArray[i2] > 127) {
                charArray[i2] = 0;
                z = true;
                break;
            }
            i2++;
        }
        return z ? new String(charArray, 0, i2) : str;
    }

    public static byte[] readJarEntry(JarFile jarFile, String str) {
        if (jarFile != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    return readJarEntry(jarFile, jarFile.getJarEntry(str));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static byte[] readJarEntry(JarFile jarFile, JarEntry jarEntry) {
        if (jarFile != null && jarEntry != null) {
            try {
                return readBytes(jarFile.getInputStream(jarEntry));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }
}
