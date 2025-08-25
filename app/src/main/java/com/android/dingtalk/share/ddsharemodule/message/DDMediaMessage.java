package com.android.dingtalk.share.ddsharemodule.message;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.android.dingtalk.share.ddsharemodule.ShareConstant;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class DDMediaMessage {
    private static final int MAX_CONTENT_LENGTH = 1024;
    private static final int MAX_THUMB_DATA_LENGTH = 32768;
    private static final int MAX_TITLE_LENGTH = 512;
    private static final String TAG = "DDMediaMessage";
    public String mContent;
    public IMediaObject mMediaObject;
    public int mSDKVersion;
    public byte[] mThumbData;
    public String mThumbUrl;
    public String mTitle;
    public String mUrl;

    public static class Builder {
        public static DDMediaMessage fromBundle(Bundle bundle) {
            if (bundle == null) {
                return null;
            }
            DDMediaMessage dDMediaMessage = new DDMediaMessage();
            dDMediaMessage.mSDKVersion = bundle.getInt(ShareConstant.EXTRA_AP_OBJECT_SDK_VERSION);
            dDMediaMessage.mTitle = bundle.getString(ShareConstant.EXTRA_AP_OBJECT_TITLE);
            dDMediaMessage.mContent = bundle.getString(ShareConstant.EXTRA_AP_OBJECT_DESCRIPTION);
            dDMediaMessage.mThumbData = bundle.getByteArray(ShareConstant.EXTRA_AP_OBJECT_THUMB_DATA);
            dDMediaMessage.mThumbUrl = bundle.getString(ShareConstant.EXTRA_AP_OBJECT_THUMB_URL);
            String string = bundle.getString(ShareConstant.EXTRA_AP_OBJECT_IDENTIFIER);
            if (string != null && string.length() > 0) {
                try {
                    dDMediaMessage.mMediaObject = (IMediaObject) Class.forName(string).newInstance();
                    dDMediaMessage.mMediaObject.unserialize(bundle);
                    return dDMediaMessage;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    String str = "get media object from bundle failed: unknown ident " + string;
                }
            }
            return dDMediaMessage;
        }

        public static Bundle toBundle(DDMediaMessage dDMediaMessage) {
            IMediaObject iMediaObject;
            Bundle bundle = new Bundle();
            bundle.putInt(ShareConstant.EXTRA_AP_OBJECT_SDK_VERSION, dDMediaMessage.mSDKVersion);
            bundle.putString(ShareConstant.EXTRA_AP_OBJECT_TITLE, dDMediaMessage.mTitle);
            bundle.putString(ShareConstant.EXTRA_AP_OBJECT_DESCRIPTION, dDMediaMessage.mContent);
            bundle.putByteArray(ShareConstant.EXTRA_AP_OBJECT_THUMB_DATA, dDMediaMessage.mThumbData);
            bundle.putString(ShareConstant.EXTRA_AP_OBJECT_THUMB_URL, dDMediaMessage.mThumbUrl);
            if (dDMediaMessage != null && (iMediaObject = dDMediaMessage.mMediaObject) != null) {
                bundle.putString(ShareConstant.EXTRA_AP_OBJECT_IDENTIFIER, iMediaObject.getClass().getName());
                dDMediaMessage.mMediaObject.serialize(bundle);
            }
            return bundle;
        }
    }

    public interface IMediaObject {
        public static final int TYPE_IMAGE = 3;
        public static final int TYPE_TEXT = 2;
        public static final int TYPE_WEBPAGE = 1;
        public static final int TYPE_ZHIFUBAO = 0;

        void attachContext(Context context);

        boolean checkArgs();

        int getSupportVersion();

        void serialize(Bundle bundle);

        int type();

        void unserialize(Bundle bundle);
    }

    public DDMediaMessage() {
        this(null);
    }

    public final void attachContext(Context context) {
        IMediaObject iMediaObject = this.mMediaObject;
        if (iMediaObject != null) {
            iMediaObject.attachContext(context);
        }
    }

    public final boolean checkArgs() {
        IMediaObject iMediaObject;
        byte[] bArr = this.mThumbData;
        if (bArr != null && bArr.length > 32768) {
            return false;
        }
        String str = this.mTitle;
        if (str != null && str.length() > 512) {
            return false;
        }
        String str2 = this.mContent;
        if ((str2 == null || str2.length() <= 1024) && (iMediaObject = this.mMediaObject) != null) {
            return iMediaObject.checkArgs();
        }
        return false;
    }

    public final int getSupportVersion() {
        IMediaObject iMediaObject = this.mMediaObject;
        if (iMediaObject == null) {
            return Integer.MAX_VALUE;
        }
        return iMediaObject.getSupportVersion();
    }

    public final int getType() {
        IMediaObject iMediaObject = this.mMediaObject;
        if (iMediaObject == null) {
            return 0;
        }
        return iMediaObject.type();
    }

    public final void setThumbImage(Bitmap bitmap) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 85, byteArrayOutputStream);
            this.mThumbData = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public DDMediaMessage(IMediaObject iMediaObject) {
        this.mMediaObject = iMediaObject;
    }
}
