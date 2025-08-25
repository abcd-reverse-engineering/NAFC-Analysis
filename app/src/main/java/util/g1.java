package util;

import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import bean.LocalVideoBean;
import com.luck.picture.lib.tools.PictureFileUtils;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.List;

/* compiled from: GetVideoFile.java */
/* loaded from: classes2.dex */
public class g1 {

    /* compiled from: GetVideoFile.java */
    static class a implements FileFilter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f20818a;

        a(List list) {
            this.f20818a = list;
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) throws IOException, IllegalArgumentException {
            String name = file.getName();
            int iIndexOf = name.indexOf(46);
            if (iIndexOf == -1) {
                if (!file.isDirectory()) {
                    return false;
                }
                g1.a(this.f20818a, file);
                return false;
            }
            String strSubstring = name.substring(iIndexOf);
            if (!strSubstring.equalsIgnoreCase(".mp4") && !strSubstring.equalsIgnoreCase(PictureFileUtils.POST_AUDIO)) {
                return false;
            }
            LocalVideoBean localVideoBean = new LocalVideoBean();
            file.getUsableSpace();
            localVideoBean.setName(file.getName());
            localVideoBean.setPath(file.getPath());
            localVideoBean.setLastTime(file.lastModified());
            g1.a(localVideoBean);
            this.f20818a.add(localVideoBean);
            return true;
        }
    }

    public static List<LocalVideoBean> a(List<LocalVideoBean> list, File file) {
        if (file == null) {
            return list;
        }
        file.listFiles(new a(list));
        return list;
    }

    public static LocalVideoBean a(LocalVideoBean localVideoBean) throws IOException, IllegalArgumentException {
        String str = "text";
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        String path = localVideoBean.getPath();
        if (!TextUtils.isEmpty(path)) {
            try {
                mediaMetadataRetriever.setDataSource(path);
                try {
                    localVideoBean.setDuration(Long.parseLong(mediaMetadataRetriever.extractMetadata(9)));
                } catch (Exception unused) {
                    localVideoBean.setDuration(0L);
                }
                try {
                    String strExtractMetadata = mediaMetadataRetriever.extractMetadata(12);
                    if (!TextUtils.isEmpty(strExtractMetadata)) {
                        str = strExtractMetadata;
                    }
                } catch (Exception unused2) {
                }
                if (localVideoBean.getName().endsWith("mp3") || str.startsWith("audio")) {
                    localVideoBean.setMimeType(1);
                } else if (localVideoBean.getName().endsWith("mp4") || str.startsWith("video")) {
                    localVideoBean.setMimeType(2);
                }
                mediaMetadataRetriever.release();
            } catch (Exception unused3) {
                mediaMetadataRetriever.release();
            }
        }
        return localVideoBean;
    }
}
