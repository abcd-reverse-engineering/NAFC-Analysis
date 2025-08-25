package cn.cloudwalk.util;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class AssetsManager {
    public static boolean copyAsset(Context context, String str, String str2) {
        return copyAsset(context.getAssets(), new AssetFile(str), new File(str2));
    }

    public static boolean copyAssetFile(Context context, String str, File file) {
        return copyAssetFile(context.getAssets(), str, file);
    }

    public static boolean copyAsset(AssetManager assetManager, AssetFile assetFile, File file) throws IOException {
        try {
            File file2 = new File(file.getAbsolutePath(), assetFile.getName());
            String assetPath = assetFile.getAssetPath();
            String[] list = assetManager.list(assetPath);
            if (list.length <= 0) {
                copyAssetFile(assetManager, assetPath, file2);
                return true;
            }
            if (!file2.exists()) {
                file2.mkdirs();
            }
            for (String str : list) {
                copyAsset(assetManager, new AssetFile(assetPath, str), file2);
            }
            return true;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean copyAssetFile(AssetManager assetManager, String str, File file) throws IOException {
        try {
            InputStream inputStreamOpen = assetManager.open(str);
            if (file.exists() && inputStreamOpen.available() == file.length()) {
                inputStreamOpen.close();
                return true;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int i2 = inputStreamOpen.read(bArr);
                if (i2 == -1) {
                    fileOutputStream.close();
                    inputStreamOpen.close();
                    return true;
                }
                fileOutputStream.write(bArr, 0, i2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
