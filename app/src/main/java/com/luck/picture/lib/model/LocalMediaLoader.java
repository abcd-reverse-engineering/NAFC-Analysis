package com.luck.picture.lib.model;

import android.content.Context;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.entity.LocalMediaFolder;
import com.luck.picture.lib.tools.DESUtils;
import com.luck.picture.lib.tools.MediaUtils;
import com.luck.picture.lib.tools.SdkVersionUtils;
import com.luck.picture.lib.tools.ValueOf;
import com.umeng.analytics.pro.bl;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import h.q2.t.m0;
import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class LocalMediaLoader {
    private static final int AUDIO_DURATION = 500;
    private static final long FILE_SIZE_UNIT = 1048576;
    private static final String NOT_GIF = "!='image/gif'";
    private static final String ORDER_BY = "_id DESC";
    private static final String SELECTION = "media_type=? AND _size>0";
    private static final String SELECTION_NOT_GIF = "media_type=? AND _size>0 AND mime_type!='image/gif'";
    private static final String SELECTION_SPECIFIED_FORMAT = "media_type=? AND _size>0 AND mime_type";
    private static final String TAG = "LocalMediaLoader";
    private PictureSelectionConfig config;
    private boolean isAndroidQ = SdkVersionUtils.checkedAndroid_Q();
    private Context mContext;
    private static final Uri QUERY_URI = MediaStore.Files.getContentUri("external");
    private static final String[] PROJECTION = {bl.f10170d, "_data", "mime_type", SocializeProtocolConstants.WIDTH, SocializeProtocolConstants.HEIGHT, "duration", "_size", "bucket_display_name", "_display_name"};
    private static final String[] SELECTION_ALL_ARGS = {String.valueOf(1), String.valueOf(3)};

    public LocalMediaLoader(Context context, PictureSelectionConfig pictureSelectionConfig) {
        this.mContext = context.getApplicationContext();
        this.config = pictureSelectionConfig;
    }

    static /* synthetic */ int a(LocalMediaFolder localMediaFolder, LocalMediaFolder localMediaFolder2) {
        if (localMediaFolder.getImages() == null || localMediaFolder2.getImages() == null) {
            return 0;
        }
        return Integer.compare(localMediaFolder2.getImageNum(), localMediaFolder.getImageNum());
    }

    private String getDurationCondition(long j2, long j3) {
        int i2 = this.config.videoMaxSecond;
        long jMin = i2 == 0 ? m0.f16408b : i2;
        if (j2 != 0) {
            jMin = Math.min(jMin, j2);
        }
        Locale locale = Locale.CHINA;
        Object[] objArr = new Object[3];
        objArr[0] = Long.valueOf(Math.max(j3, this.config.videoMinSecond));
        objArr[1] = Math.max(j3, (long) this.config.videoMinSecond) == 0 ? "" : ContainerUtils.KEY_VALUE_DELIMITER;
        objArr[2] = Long.valueOf(jMin);
        return String.format(locale, "%d <%s duration and duration <= %d", objArr);
    }

    private LocalMediaFolder getImageFolder(String str, String str2, List<LocalMediaFolder> list) {
        if (!this.config.isFallbackVersion) {
            for (LocalMediaFolder localMediaFolder : list) {
                String name = localMediaFolder.getName();
                if (!TextUtils.isEmpty(name) && name.equals(str2)) {
                    return localMediaFolder;
                }
            }
            LocalMediaFolder localMediaFolder2 = new LocalMediaFolder();
            localMediaFolder2.setName(str2);
            localMediaFolder2.setFirstImagePath(str);
            list.add(localMediaFolder2);
            return localMediaFolder2;
        }
        File parentFile = new File(str).getParentFile();
        for (LocalMediaFolder localMediaFolder3 : list) {
            String name2 = localMediaFolder3.getName();
            if (!TextUtils.isEmpty(name2) && name2.equals(parentFile.getName())) {
                return localMediaFolder3;
            }
        }
        LocalMediaFolder localMediaFolder4 = new LocalMediaFolder();
        localMediaFolder4.setName(parentFile.getName());
        localMediaFolder4.setFirstImagePath(str);
        list.add(localMediaFolder4);
        return localMediaFolder4;
    }

    private String getRealPathAndroid_Q(long j2) {
        return QUERY_URI.buildUpon().appendPath(ValueOf.toString(Long.valueOf(j2))).build().toString();
    }

    private String getSelection() {
        PictureSelectionConfig pictureSelectionConfig = this.config;
        int i2 = pictureSelectionConfig.chooseMode;
        if (i2 == 0) {
            return getSelectionArgsForAllMediaCondition(getDurationCondition(0L, 0L), this.config.isGif);
        }
        if (i2 == 1) {
            if (TextUtils.isEmpty(pictureSelectionConfig.specifiedFormat)) {
                return this.config.isGif ? SELECTION : SELECTION_NOT_GIF;
            }
            return "media_type=? AND _size>0 AND mime_type='" + this.config.specifiedFormat + "'";
        }
        if (i2 == 2) {
            if (TextUtils.isEmpty(pictureSelectionConfig.specifiedFormat)) {
                return getSelectionArgsForSingleMediaCondition();
            }
            return "media_type=? AND _size>0 AND mime_type='" + this.config.specifiedFormat + "'";
        }
        if (i2 != 3) {
            return null;
        }
        if (TextUtils.isEmpty(pictureSelectionConfig.specifiedFormat)) {
            return getSelectionArgsForSingleMediaCondition(getDurationCondition(0L, 500L));
        }
        return "media_type=? AND _size>0 AND mime_type='" + this.config.specifiedFormat + "'";
    }

    private String[] getSelectionArgs() {
        int i2 = this.config.chooseMode;
        if (i2 == 0) {
            return SELECTION_ALL_ARGS;
        }
        if (i2 == 1) {
            return getSelectionArgsForSingleMediaType(1);
        }
        if (i2 == 2) {
            return getSelectionArgsForSingleMediaType(3);
        }
        if (i2 != 3) {
            return null;
        }
        return getSelectionArgsForSingleMediaType(2);
    }

    private static String getSelectionArgsForAllMediaCondition(String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("(media_type=?");
        sb.append(z ? "" : " AND mime_type!='image/gif'");
        sb.append(" OR ");
        sb.append("media_type=? AND ");
        sb.append(str);
        sb.append(")");
        sb.append(" AND ");
        sb.append("_size");
        sb.append(">0");
        return sb.toString();
    }

    private static String getSelectionArgsForSingleMediaCondition() {
        return SELECTION;
    }

    private static String getSelectionArgsForSingleMediaCondition(String str) {
        return "media_type=? AND _size>0 AND " + str;
    }

    private static String[] getSelectionArgsForSingleMediaType(int i2) {
        return new String[]{String.valueOf(i2)};
    }

    private void savaCourseMedia(long j2, String str, String str2, String str3, long j3, String str4, int i2, int i3, long j4, List<LocalMediaFolder> list, List<LocalMedia> list2, LocalMediaFolder localMediaFolder) {
        LocalMedia localMedia = new LocalMedia(j2, str, str2, str3, j3, this.config.chooseMode, str4, i2, i3, j4);
        localMedia.setFileMd5(DESUtils.encode(DESUtils.DES_KEY_STRING, str, i2, i3));
        LocalMediaFolder imageFolder = getImageFolder(str, str3, list);
        imageFolder.getImages().add(localMedia);
        imageFolder.setImageNum(imageFolder.getImageNum() + 1);
        list2.add(localMedia);
        localMediaFolder.setImageNum(localMediaFolder.getImageNum() + 1);
    }

    private void sortFolder(List<LocalMediaFolder> list) {
        Collections.sort(list, new Comparator() { // from class: com.luck.picture.lib.model.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return LocalMediaLoader.a((LocalMediaFolder) obj, (LocalMediaFolder) obj2);
            }
        });
    }

    public void getFilesAllName(String str, File file, List<LocalMediaFolder> list, List<LocalMedia> list2, LocalMediaFolder localMediaFolder) {
        String str2;
        int i2;
        File file2;
        File[] fileArr;
        LocalMediaLoader localMediaLoader = this;
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        boolean z = false;
        int i3 = 0;
        while (i3 < fileArrListFiles.length) {
            String absolutePath = fileArrListFiles[i3].getAbsolutePath();
            File file3 = new File(absolutePath);
            String name = file3.getName();
            long jExtractDuration = SdkVersionUtils.checkedAndroid_Q() ? MediaUtils.extractDuration(localMediaLoader.mContext, true, absolutePath) : MediaUtils.extractDuration(localMediaLoader.mContext, z, absolutePath);
            if (jExtractDuration >= 1000) {
                try {
                    str2 = "audio/" + file3.getName().substring(file3.getName().lastIndexOf(".") + 1);
                } catch (Exception unused) {
                    str2 = "audio/*";
                }
                i2 = i3;
                file2 = file3;
                fileArr = fileArrListFiles;
                savaCourseMedia(0L, absolutePath, name, str, jExtractDuration, str2, 0, 0, file3.length(), list, list2, localMediaFolder);
            } else {
                i2 = i3;
                file2 = file3;
                fileArr = fileArrListFiles;
            }
            getFilesAllName(str, file2, list, list2, localMediaFolder);
            i3 = i2 + 1;
            z = false;
            localMediaLoader = this;
            fileArrListFiles = fileArr;
        }
    }

    public boolean isExist(String str) {
        return !TextUtils.isEmpty(str) && new File(str).exists();
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0093, code lost:
    
        if (com.luck.picture.lib.config.PictureMimeType.isGif(r1) != false) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:121:0x017d A[EDGE_INSN: B:121:0x017d->B:62:0x017d BREAK  A[LOOP:0: B:7:0x0036->B:81:0x01fc], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01fc A[LOOP:0: B:7:0x0036->B:81:0x01fc, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<com.luck.picture.lib.entity.LocalMediaFolder> loadAllMedia() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 613
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.model.LocalMediaLoader.loadAllMedia():java.util.List");
    }
}
