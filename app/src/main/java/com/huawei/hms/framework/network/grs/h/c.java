package com.huawei.hms.framework.network.grs.h;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.IoUtils;
import com.huawei.hms.framework.common.Logger;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final String f6919a = "c";

    public static String a(String str, Context context) throws IOException {
        Logger.d(f6919a, "Io getConfigContent, fileName: " + str);
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        InputStream inputStreamOpen = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                if (!new File(str).isDirectory()) {
                    inputStreamOpen = context.getAssets().open(str);
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int i2 = inputStreamOpen.read(bArr);
                        if (i2 == -1) {
                            byteArrayOutputStream.flush();
                            return byteArrayOutputStream.toString("UTF-8");
                        }
                        byteArrayOutputStream.write(bArr, 0, i2);
                    }
                }
            } catch (IOException unused) {
                Logger.w(f6919a, "local config file is not exist.filename is {%s}", str);
            }
            return "";
        } finally {
            IoUtils.closeSecure((OutputStream) byteArrayOutputStream);
            IoUtils.closeSecure(inputStreamOpen);
        }
    }
}
