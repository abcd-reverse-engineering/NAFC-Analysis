package com.android.dingtalk.share.ddsharemodule.message;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.android.dingtalk.share.ddsharemodule.ShareConstant;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class DDImageMessage extends BaseMediaObject {
    private static final int MAX_IMAGE_DATA_LENGTH = 10485760;
    private static final int MAX_IMAGE_THUMB_DATA_LENGTH = 32768;
    private static final int MAX_IMAGE_URL_LENGTH = 10240;
    private static final String TAG = "DDImageMessage";
    public byte[] mImageData;
    public String mImagePath;
    public Uri mImageUri;
    public String mImageUrl;

    public DDImageMessage() {
    }

    @Override // com.android.dingtalk.share.ddsharemodule.message.BaseMediaObject, com.android.dingtalk.share.ddsharemodule.message.DDMediaMessage.IMediaObject
    public void attachContext(Context context) {
        Uri uri;
        if (context == null || (uri = this.mImageUri) == null) {
            return;
        }
        context.grantUriPermission(ShareConstant.DD_APP_PACKAGE, uri, 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0053  */
    @Override // com.android.dingtalk.share.ddsharemodule.message.BaseMediaObject, com.android.dingtalk.share.ddsharemodule.message.DDMediaMessage.IMediaObject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean checkArgs() {
        /*
            r6 = this;
            byte[] r0 = r6.mImageData
            r1 = 0
            if (r0 == 0) goto L8
            int r0 = r0.length
            if (r0 != 0) goto L20
        L8:
            java.lang.String r0 = r6.mImagePath
            if (r0 == 0) goto L12
            int r0 = r0.length()
            if (r0 != 0) goto L20
        L12:
            java.lang.String r0 = r6.mImageUrl
            if (r0 == 0) goto L1c
            int r0 = r0.length()
            if (r0 != 0) goto L20
        L1c:
            android.net.Uri r0 = r6.mImageUri
            if (r0 == 0) goto L64
        L20:
            byte[] r0 = r6.mImageData
            r2 = 10485760(0xa00000, float:1.469368E-38)
            if (r0 == 0) goto L2a
            int r0 = r0.length
            if (r0 <= r2) goto L2a
            return r1
        L2a:
            java.lang.String r0 = r6.mImagePath
            r3 = 10240(0x2800, float:1.4349E-41)
            if (r0 == 0) goto L37
            int r0 = r0.length()
            if (r0 <= r3) goto L37
            return r1
        L37:
            java.lang.String r0 = r6.mImagePath
            if (r0 == 0) goto L57
            int r4 = r0.length()
            if (r4 == 0) goto L53
            java.io.File r4 = new java.io.File
            r4.<init>(r0)
            boolean r0 = r4.exists()
            if (r0 != 0) goto L4d
            goto L53
        L4d:
            long r4 = r4.length()
            int r0 = (int) r4
            goto L54
        L53:
            r0 = 0
        L54:
            if (r0 <= r2) goto L57
            return r1
        L57:
            java.lang.String r0 = r6.mImageUrl
            if (r0 == 0) goto L62
            int r0 = r0.length()
            if (r0 <= r3) goto L62
            return r1
        L62:
            r0 = 1
            return r0
        L64:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.dingtalk.share.ddsharemodule.message.DDImageMessage.checkArgs():boolean");
    }

    @Override // com.android.dingtalk.share.ddsharemodule.message.BaseMediaObject, com.android.dingtalk.share.ddsharemodule.message.DDMediaMessage.IMediaObject
    public int getSupportVersion() {
        return ShareConstant.DINGDING_SDK_SHARE_VERSION_V1;
    }

    @Override // com.android.dingtalk.share.ddsharemodule.message.BaseMediaObject, com.android.dingtalk.share.ddsharemodule.message.DDMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        bundle.putByteArray(ShareConstant.EXTRA_IMAGE_OBJECT_IMAGE_DATA, this.mImageData);
        bundle.putString(ShareConstant.EXTRA_IMAGE_OBJECT_IMAGE_PATH, this.mImagePath);
        bundle.putString(ShareConstant.EXTRA_IMAGE_OBJECT_IMAGE_URL, this.mImageUrl);
        bundle.putParcelable(ShareConstant.EXTRA_IMAGE_OBJECT_IMAGE_URI, this.mImageUri);
    }

    @Override // com.android.dingtalk.share.ddsharemodule.message.BaseMediaObject, com.android.dingtalk.share.ddsharemodule.message.DDMediaMessage.IMediaObject
    public int type() {
        return 3;
    }

    @Override // com.android.dingtalk.share.ddsharemodule.message.BaseMediaObject, com.android.dingtalk.share.ddsharemodule.message.DDMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        this.mImageData = bundle.getByteArray(ShareConstant.EXTRA_IMAGE_OBJECT_IMAGE_DATA);
        this.mImagePath = bundle.getString(ShareConstant.EXTRA_IMAGE_OBJECT_IMAGE_PATH);
        this.mImageUrl = bundle.getString(ShareConstant.EXTRA_IMAGE_OBJECT_IMAGE_URL);
        this.mImageUri = (Uri) bundle.getParcelable(ShareConstant.EXTRA_IMAGE_OBJECT_IMAGE_URI);
    }

    public DDImageMessage(byte[] bArr) {
        this.mImageData = bArr;
    }

    public DDImageMessage(Bitmap bitmap) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 85, byteArrayOutputStream);
            this.mImageData = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
