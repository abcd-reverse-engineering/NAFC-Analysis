package com.umeng.socialize.handler;

import android.app.Activity;
import android.content.Intent;
import com.umeng.socialize.Config;
import com.umeng.socialize.ShareContent;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.SocializeUtils;
import com.umeng.socialize.utils.UmengText;
import java.io.File;

/* loaded from: classes2.dex */
public class UMMoreHandler extends UMSSOHandler {
    @Override // com.umeng.socialize.handler.UMSSOHandler
    public String getVersion() {
        return "7.3.2";
    }

    @Override // com.umeng.socialize.handler.UMSSOHandler
    public boolean share(ShareContent shareContent, UMShareListener uMShareListener) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        if (shareContent.mMedia instanceof UMImage) {
            intent.setType("image/*");
            File fileAsFileImage = ((UMImage) shareContent.mMedia).asFileImage();
            if (fileAsFileImage != null) {
                intent.putExtra("android.intent.extra.STREAM", SocializeUtils.insertImage(getContext(), fileAsFileImage.getPath()));
            }
        } else {
            intent.setType("text/plain");
        }
        intent.putExtra("android.intent.extra.SUBJECT", shareContent.subject);
        intent.putExtra("android.intent.extra.TEXT", shareContent.mText);
        Intent intentCreateChooser = Intent.createChooser(intent, Config.MORE_TITLE);
        intentCreateChooser.addFlags(CommonNetImpl.FLAG_AUTH);
        try {
            Activity currentActivity = getCurrentActivity();
            if (currentActivity == null || currentActivity.isFinishing()) {
                uMShareListener.onError(SHARE_MEDIA.MORE, new Exception("activity null!"));
            } else {
                currentActivity.startActivity(intentCreateChooser);
                uMShareListener.onResult(SHARE_MEDIA.MORE);
            }
            return true;
        } catch (Exception e2) {
            SLog.error(UmengText.INTER.MOREERROR, e2);
            uMShareListener.onError(SHARE_MEDIA.MORE, e2);
            return true;
        }
    }
}
