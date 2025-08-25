package com.luck.picture.lib.tools;

import android.content.Context;
import android.net.Uri;
import java.io.File;

/* loaded from: classes.dex */
public class AndroidQTransformUtils {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006c A[PHI: r3
  0x006c: PHI (r3v6 ??) = (r3v13 ??), (r3v14 ??) binds: [B:32:0x006a, B:21:0x0058] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.Closeable, java.nio.channels.ReadableByteChannel] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v12, types: [java.io.Closeable, java.nio.channels.ReadableByteChannel, okio.BufferedSource] */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.nio.channels.ReadableByteChannel] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.io.Closeable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String copyPathToAndroidQ(android.content.Context r3, java.lang.String r4, int r5, int r6, java.lang.String r7, java.lang.String r8) throws java.lang.Throwable {
        /*
            com.luck.picture.lib.engine.CacheResourcesEngine r0 = com.luck.picture.lib.config.PictureSelectionConfig.cacheResourcesEngine
            if (r0 == 0) goto Lf
            java.lang.String r0 = r0.onCachePath(r3, r4)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto Lf
            return r0
        Lf:
            r0 = 0
            android.net.Uri r1 = android.net.Uri.parse(r4)     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L5f
            java.lang.String r2 = "lmw#2020"
            java.lang.String r4 = com.luck.picture.lib.tools.DESUtils.encode(r2, r4, r5, r6)     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L5f
            java.lang.String r4 = com.luck.picture.lib.tools.PictureFileUtils.createFilePath(r3, r4, r7, r8)     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L5f
            java.io.File r5 = new java.io.File     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L5f
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L5f
            boolean r6 = r5.exists()     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L5f
            if (r6 == 0) goto L2a
            return r4
        L2a:
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L5f
            java.io.InputStream r3 = r3.openInputStream(r1)     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L5f
            java.lang.Object r3 = java.util.Objects.requireNonNull(r3)     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L5f
            java.io.InputStream r3 = (java.io.InputStream) r3     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L5f
            okio.Source r3 = okio.Okio.source(r3)     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L5f
            okio.BufferedSource r3 = okio.Okio.buffer(r3)     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L5f
            boolean r5 = com.luck.picture.lib.tools.PictureFileUtils.bufferCopy(r3, r5)     // Catch: java.lang.Exception -> L5b java.lang.Throwable -> L70
            if (r5 == 0) goto L52
            if (r3 == 0) goto L51
            boolean r5 = r3.isOpen()
            if (r5 == 0) goto L51
            com.luck.picture.lib.tools.PictureFileUtils.close(r3)
        L51:
            return r4
        L52:
            if (r3 == 0) goto L6f
            boolean r4 = r3.isOpen()
            if (r4 == 0) goto L6f
            goto L6c
        L5b:
            r4 = move-exception
            goto L61
        L5d:
            r4 = move-exception
            goto L72
        L5f:
            r4 = move-exception
            r3 = r0
        L61:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L70
            if (r3 == 0) goto L6f
            boolean r4 = r3.isOpen()
            if (r4 == 0) goto L6f
        L6c:
            com.luck.picture.lib.tools.PictureFileUtils.close(r3)
        L6f:
            return r0
        L70:
            r4 = move-exception
            r0 = r3
        L72:
            if (r0 == 0) goto L7d
            boolean r3 = r0.isOpen()
            if (r3 == 0) goto L7d
            com.luck.picture.lib.tools.PictureFileUtils.close(r0)
        L7d:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.tools.AndroidQTransformUtils.copyPathToAndroidQ(android.content.Context, java.lang.String, int, int, java.lang.String, java.lang.String):java.lang.String");
    }

    public static boolean copyPathToDCIM(Context context, File file, Uri uri) {
        try {
            return PictureFileUtils.bufferCopy(file, context.getContentResolver().openOutputStream(uri));
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
