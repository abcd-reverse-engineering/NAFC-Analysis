package com.umeng.socialize;

import android.text.TextUtils;
import com.umeng.socialize.media.UMEmoji;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMMin;
import com.umeng.socialize.media.UMQQMini;
import com.umeng.socialize.media.UMVideo;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.media.UMusic;
import java.io.File;

/* loaded from: classes2.dex */
public class ShareContent {
    public static final int EMOJI_STYLE = 64;
    public static final int ERROR_STYLE = 0;
    public static final int FILE_STYLE = 32;
    public static final int IMAGE_STYLE = 2;
    public static final int IMAGE_VIDEO = 11;
    public static final int MINAPP_STYLE = 128;
    public static final int MUSIC_STYLE = 4;
    public static final int QQMINI_STYLE = 256;
    public static final int TEXT_IMAGE_STYLE = 3;
    public static final int TEXT_STYLE = 1;
    public static final int VIDEO_STYLE = 8;
    public static final int WEB_STYLE = 16;
    public UMVideo[] Video_mMedias;
    public File app;
    public boolean bySystem;
    public File file;
    public UMediaObject mExtra;
    public String mFollow;
    public UMediaObject mMedia;
    public UMImage[] mMedias;
    public String subject = "";
    public String mText = "";

    public int getShareType() {
        if (this.mMedia == null && this.mExtra == null && this.file == null) {
            return TextUtils.isEmpty(this.mText) ? 0 : 1;
        }
        if (this.file != null) {
            return 32;
        }
        UMediaObject uMediaObject = this.mMedia;
        if (uMediaObject != null) {
            if (uMediaObject instanceof UMEmoji) {
                return 64;
            }
            if ((uMediaObject instanceof UMImage) && this.Video_mMedias != null) {
                return 11;
            }
            UMediaObject uMediaObject2 = this.mMedia;
            if (uMediaObject2 instanceof UMImage) {
                return TextUtils.isEmpty(this.mText) ? 2 : 3;
            }
            if (uMediaObject2 instanceof UMusic) {
                return 4;
            }
            if (uMediaObject2 instanceof UMVideo) {
                return 8;
            }
            if (uMediaObject2 instanceof UMWeb) {
                return 16;
            }
            if (uMediaObject2 instanceof UMMin) {
                return 128;
            }
            if (uMediaObject2 instanceof UMQQMini) {
                return 256;
            }
        }
        return 0;
    }
}
