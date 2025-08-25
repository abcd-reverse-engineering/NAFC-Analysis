package com.luck.picture.lib.tools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.luck.picture.lib.PicturePreviewActivity;
import com.luck.picture.lib.PictureSelectorPreviewWeChatStyleActivity;
import com.luck.picture.lib.PictureVideoPlayActivity;
import com.umeng.socialize.net.dplus.CommonNetImpl;

/* loaded from: classes.dex */
public class JumpUtils {
    public static void startPicturePreviewActivity(Context context, boolean z, Bundle bundle, int i2) {
        if (DoubleUtils.isFastDoubleClick()) {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(context, z ? PictureSelectorPreviewWeChatStyleActivity.class : PicturePreviewActivity.class);
        intent.putExtras(bundle);
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, i2);
        } else {
            intent.addFlags(CommonNetImpl.FLAG_AUTH);
            context.startActivity(intent);
        }
    }

    public static void startPictureVideoPlayActivity(Context context, Bundle bundle, int i2) {
        if (DoubleUtils.isFastDoubleClick()) {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(context, PictureVideoPlayActivity.class);
        intent.putExtras(bundle);
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, i2);
        } else {
            intent.addFlags(CommonNetImpl.FLAG_AUTH);
            context.startActivity(intent);
        }
    }
}
