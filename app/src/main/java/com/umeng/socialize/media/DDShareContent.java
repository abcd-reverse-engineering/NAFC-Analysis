package com.umeng.socialize.media;

import android.content.Context;
import android.net.Uri;
import androidx.core.content.FileProvider;
import com.android.dingtalk.share.ddsharemodule.ShareConstant;
import com.android.dingtalk.share.ddsharemodule.message.DDImageMessage;
import com.android.dingtalk.share.ddsharemodule.message.DDMediaMessage;
import com.android.dingtalk.share.ddsharemodule.message.DDTextMessage;
import com.android.dingtalk.share.ddsharemodule.message.DDWebpageMessage;
import com.umeng.socialize.ShareContent;
import java.io.File;

/* loaded from: classes2.dex */
public class DDShareContent extends SimpleShareContent {
    public DDShareContent(ShareContent shareContent) {
        super(shareContent);
    }

    private DDImageMessage buildImage(boolean z, Context context, String str) {
        DDImageMessage dDImageMessage = new DDImageMessage();
        if (getImage().getImageStyle() == UMImage.URL_IMAGE) {
            dDImageMessage.mImageUrl = getImage().asUrlImage();
        } else if (!canFileValid(getImage())) {
            dDImageMessage.mImageData = getStrictImageData(getImage());
        } else if (z) {
            dDImageMessage.mImageUri = getFileUri(context, new File(getImage().asFileImage().toString()), str);
        } else {
            dDImageMessage.mImagePath = getImage().asFileImage().toString();
        }
        return dDImageMessage;
    }

    private DDWebpageMessage buildMusic() {
        DDWebpageMessage dDWebpageMessage = new DDWebpageMessage();
        dDWebpageMessage.mUrl = getMusic().toUrl();
        return dDWebpageMessage;
    }

    private DDTextMessage buildText() {
        DDTextMessage dDTextMessage = new DDTextMessage();
        dDTextMessage.mText = getText();
        return dDTextMessage;
    }

    private DDWebpageMessage buildVideo() {
        DDWebpageMessage dDWebpageMessage = new DDWebpageMessage();
        dDWebpageMessage.mUrl = getVideo().toUrl();
        return dDWebpageMessage;
    }

    private DDWebpageMessage buildWeb() {
        DDWebpageMessage dDWebpageMessage = new DDWebpageMessage();
        dDWebpageMessage.mUrl = getUmWeb().toUrl();
        return dDWebpageMessage;
    }

    private DDMediaMessage setThumb(DDMediaMessage dDMediaMessage, BaseMediaObject baseMediaObject) {
        if (baseMediaObject != null && baseMediaObject.getThumbImage() != null) {
            if (baseMediaObject.getThumbImage().isUrlMedia()) {
                dDMediaMessage.mThumbUrl = baseMediaObject.getThumbImage().asUrlImage();
            } else {
                dDMediaMessage.mThumbData = objectSetThumb(baseMediaObject);
            }
        }
        return dDMediaMessage;
    }

    public Uri getFileUri(Context context, File file, String str) {
        if (file == null || !file.exists()) {
            return null;
        }
        Uri uriForFile = FileProvider.getUriForFile(context, str, file);
        context.grantUriPermission(ShareConstant.DD_APP_PACKAGE, uriForFile, 1);
        return uriForFile;
    }

    public DDMediaMessage getMessage(Context context, boolean z, String str) {
        DDMediaMessage dDMediaMessage = new DDMediaMessage();
        if (getmStyle() == 4 && getMusic() != null) {
            dDMediaMessage.mMediaObject = buildMusic();
            dDMediaMessage.mTitle = objectSetTitle(getMusic());
            dDMediaMessage.mContent = objectSetDescription(getMusic());
            return setThumb(dDMediaMessage, getMusic());
        }
        if (getmStyle() == 8 && getVideo() != null) {
            dDMediaMessage.mMediaObject = buildVideo();
            dDMediaMessage.mTitle = objectSetTitle(getVideo());
            dDMediaMessage.mContent = objectSetDescription(getVideo());
            return setThumb(dDMediaMessage, getVideo());
        }
        if ((getmStyle() != 2 && getmStyle() != 3) || getImage() == null) {
            if (getmStyle() != 16 || getUmWeb() == null) {
                dDMediaMessage.mMediaObject = buildText();
                return dDMediaMessage;
            }
            dDMediaMessage.mMediaObject = buildWeb();
            dDMediaMessage.mTitle = objectSetTitle(getUmWeb());
            dDMediaMessage.mContent = objectSetDescription(getUmWeb());
            return setThumb(dDMediaMessage, getUmWeb());
        }
        if (z) {
            dDMediaMessage.mMediaObject = buildImage(z, context, str);
            DDMediaMessage thumb = setThumb(dDMediaMessage, getImage());
            thumb.mContent = getText();
            return thumb;
        }
        dDMediaMessage.mMediaObject = buildImage(false, context, str);
        DDMediaMessage thumb2 = setThumb(dDMediaMessage, getImage());
        thumb2.mContent = getText();
        return thumb2;
    }
}
