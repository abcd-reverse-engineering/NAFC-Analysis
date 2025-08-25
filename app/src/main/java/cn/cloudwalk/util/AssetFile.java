package cn.cloudwalk.util;

import android.content.res.AssetManager;
import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class AssetFile {
    private String assetPath;
    private Boolean directory;
    private String name;

    interface AssetFileFilter {
        boolean accept(AssetFile assetFile);
    }

    static class SystemAssetFileFilter implements AssetFileFilter {
        private final String[] SYSTEM_FILE_NAME_ARRAY = {"device_features", "huangli.idf", "hybrid", "images", "keys", "license", "operators.dat", "pinyinindex.idf", "sounds", "telocation.idf", "webkit", "xiaomi_mobile.dat"};
        private List<String> mSystemFileName = Arrays.asList(this.SYSTEM_FILE_NAME_ARRAY);

        @Override // cn.cloudwalk.util.AssetFile.AssetFileFilter
        public boolean accept(AssetFile assetFile) {
            return !this.mSystemFileName.contains(assetFile.getName());
        }
    }

    public AssetFile() {
        this("");
    }

    public static String parserName(String str) {
        return TextUtils.isEmpty(str) ? "" : str.substring(str.lastIndexOf(File.separatorChar) + 1, str.length());
    }

    public static String parserPath(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        return str + File.separator + str2;
    }

    public boolean exists(AssetManager assetManager) throws IOException {
        try {
            assetManager.list(this.assetPath);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public String getAssetPath() {
        return this.assetPath;
    }

    protected Boolean getDirectory() {
        return this.directory;
    }

    public String getName() {
        return this.name;
    }

    public String getParent() {
        return this.assetPath.substring(0, this.assetPath.lastIndexOf(File.separatorChar));
    }

    public AssetFile getParentFile() {
        return new AssetFile(getParent());
    }

    public Uri getUri() {
        StringBuilder sb = new StringBuilder();
        sb.append("file:///android_asset/");
        sb.append(isRootDir() ? "" : this.assetPath);
        return Uri.parse(sb.toString());
    }

    public boolean isDirectory(AssetManager assetManager) {
        if (this.directory == null) {
            try {
                this.directory = Boolean.valueOf(assetManager.list(this.assetPath).length > 0);
            } catch (Exception e2) {
                e2.printStackTrace();
                this.directory = false;
            }
        }
        return this.directory.booleanValue();
    }

    public boolean isRootDir() {
        return this.assetPath.equals(File.separator);
    }

    public List<AssetFile> listFiles(AssetManager assetManager) {
        return listFiles(assetManager, new SystemAssetFileFilter());
    }

    public AssetFile(AssetFile assetFile, String str) {
        this(assetFile.getAssetPath(), str);
    }

    public List<AssetFile> listFiles(AssetManager assetManager, AssetFileFilter assetFileFilter) throws IOException {
        try {
            String str = TextUtils.isEmpty(this.assetPath) ? "" : this.assetPath;
            String[] list = assetManager.list(str);
            ArrayList arrayList = new ArrayList();
            for (String str2 : list) {
                AssetFile assetFile = new AssetFile(str, str2);
                if (assetFileFilter == null) {
                    arrayList.add(assetFile);
                } else if (assetFileFilter.accept(assetFile)) {
                    arrayList.add(assetFile);
                }
            }
            return arrayList;
        } catch (IOException e2) {
            e2.printStackTrace();
            return new ArrayList();
        }
    }

    public AssetFile(String str, String str2) {
        this(parserPath(str, str2));
    }

    public AssetFile(String str) {
        this.assetPath = str == null ? "" : str;
        this.name = parserName(this.assetPath);
    }
}
