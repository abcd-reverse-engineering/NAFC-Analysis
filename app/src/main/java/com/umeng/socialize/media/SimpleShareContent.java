package com.umeng.socialize.media;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.umeng.socialize.ShareContent;
import com.umeng.socialize.c.a.a;
import com.umeng.socialize.interfaces.CompressListener;
import com.umeng.socialize.utils.ContextUtil;
import com.umeng.socialize.utils.DefaultClass;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import java.io.File;

/* loaded from: classes2.dex */
public class SimpleShareContent {

    /* renamed from: a, reason: collision with root package name */
    private UMImage f11694a;

    /* renamed from: b, reason: collision with root package name */
    private UMImage[] f11695b;

    /* renamed from: c, reason: collision with root package name */
    private String f11696c;

    /* renamed from: d, reason: collision with root package name */
    private UMVideo f11697d;

    /* renamed from: e, reason: collision with root package name */
    private UMVideo[] f11698e;

    /* renamed from: f, reason: collision with root package name */
    private UMEmoji f11699f;

    /* renamed from: g, reason: collision with root package name */
    private UMusic f11700g;

    /* renamed from: h, reason: collision with root package name */
    private UMMin f11701h;

    /* renamed from: i, reason: collision with root package name */
    private UMQQMini f11702i;

    /* renamed from: j, reason: collision with root package name */
    private UMWeb f11703j;

    /* renamed from: k, reason: collision with root package name */
    private File f11704k;

    /* renamed from: l, reason: collision with root package name */
    private BaseMediaObject f11705l;

    /* renamed from: m, reason: collision with root package name */
    private int f11706m;
    private String n;
    private String o;
    private CompressListener p;
    public int THUMB_LIMIT = 24576;
    public int WX_THUMB_LIMIT = 18432;
    public int WX_MIN_LIMIT = 131072;
    public final int IMAGE_LIMIT = 491520;
    public final String DEFAULT_TITLE = "这里是标题";
    public final String DEFAULT_DESCRIPTION = "这里是描述";

    public SimpleShareContent(ShareContent shareContent) {
        this.f11696c = shareContent.mText;
        UMediaObject uMediaObject = shareContent.mMedia;
        if (uMediaObject == null || !(uMediaObject instanceof UMImage) || shareContent.Video_mMedias == null) {
            UMediaObject uMediaObject2 = shareContent.mMedia;
            if (uMediaObject2 != null && (uMediaObject2 instanceof UMImage)) {
                this.f11694a = (UMImage) uMediaObject2;
                this.f11705l = this.f11694a;
                UMImage[] uMImageArr = shareContent.mMedias;
                if (uMImageArr != null && uMImageArr.length > 0) {
                    this.f11695b = uMImageArr;
                }
            }
            UMediaObject uMediaObject3 = shareContent.mMedia;
            if (uMediaObject3 != null && (uMediaObject3 instanceof UMusic)) {
                this.f11700g = (UMusic) uMediaObject3;
                this.f11705l = this.f11700g;
            }
            UMediaObject uMediaObject4 = shareContent.mMedia;
            if (uMediaObject4 != null && (uMediaObject4 instanceof UMVideo)) {
                this.f11697d = (UMVideo) uMediaObject4;
                this.f11705l = this.f11697d;
                UMVideo[] uMVideoArr = shareContent.Video_mMedias;
                if (uMVideoArr != null && uMVideoArr.length > 0) {
                    this.f11698e = uMVideoArr;
                }
            }
            UMediaObject uMediaObject5 = shareContent.mMedia;
            if (uMediaObject5 != null && (uMediaObject5 instanceof UMEmoji)) {
                this.f11699f = (UMEmoji) uMediaObject5;
                this.f11705l = this.f11699f;
            }
            UMediaObject uMediaObject6 = shareContent.mMedia;
            if (uMediaObject6 != null && (uMediaObject6 instanceof UMWeb)) {
                this.f11703j = (UMWeb) uMediaObject6;
                this.f11705l = this.f11703j;
            }
            UMediaObject uMediaObject7 = shareContent.mMedia;
            if (uMediaObject7 != null && (uMediaObject7 instanceof UMMin)) {
                this.f11701h = (UMMin) uMediaObject7;
                this.f11705l = this.f11703j;
            }
            UMediaObject uMediaObject8 = shareContent.mMedia;
            if (uMediaObject8 != null && (uMediaObject8 instanceof UMQQMini)) {
                this.f11702i = (UMQQMini) uMediaObject8;
                this.f11705l = this.f11703j;
            }
            File file = shareContent.file;
            if (file != null) {
                this.f11704k = file;
            }
        } else {
            this.f11694a = (UMImage) uMediaObject;
            this.f11705l = this.f11694a;
            UMImage[] uMImageArr2 = shareContent.mMedias;
            if (uMImageArr2 != null && uMImageArr2.length > 0) {
                this.f11695b = uMImageArr2;
            }
            this.f11705l = this.f11697d;
            UMVideo[] uMVideoArr2 = shareContent.Video_mMedias;
            if (uMVideoArr2 != null && uMVideoArr2.length > 0) {
                this.f11698e = uMVideoArr2;
            }
        }
        this.o = shareContent.subject;
        this.f11706m = shareContent.getShareType();
        this.n = a();
    }

    private String a() {
        int i2 = this.f11706m;
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 8 ? i2 != 16 ? i2 != 32 ? i2 != 64 ? i2 != 128 ? i2 != 256 ? "error" : "qqMini" : "minapp" : "emoji" : "file" : "web" : "video" : "music" : "textandimage" : "image" : "text";
    }

    private byte[] b() {
        byte[] bytes = DefaultClass.getBytes();
        if (ContextUtil.getIcon() != 0 && ((bytes = a.a(new UMImage(ContextUtil.getContext(), ContextUtil.getIcon()), this.WX_THUMB_LIMIT)) == null || bytes.length <= 0)) {
            SLog.E(UmengText.IMAGE.SHARECONTENT_THUMB_ERROR);
        }
        return bytes;
    }

    public boolean canFileValid(UMImage uMImage) {
        return uMImage.asFileImage() != null;
    }

    public String getAssertSubject() {
        return TextUtils.isEmpty(this.o) ? "umengshare" : this.o;
    }

    public BaseMediaObject getBaseMediaObject() {
        return this.f11705l;
    }

    public File getFile() {
        return this.f11704k;
    }

    public UMImage getImage() {
        return this.f11694a;
    }

    public byte[] getImageData(UMImage uMImage) {
        return uMImage.asBinImage();
    }

    public byte[] getImageThumb(UMImage uMImage) {
        if (uMImage.getThumbImage() == null) {
            return b();
        }
        byte[] bArrA = a.a(uMImage.getThumbImage(), this.WX_THUMB_LIMIT);
        if (bArrA != null && bArrA.length > 0) {
            return bArrA;
        }
        SLog.E(UmengText.IMAGE.SHARECONTENT_THUMB_ERROR);
        return b();
    }

    public UMusic getMusic() {
        return this.f11700g;
    }

    public String getMusicTargetUrl(UMusic uMusic) {
        return TextUtils.isEmpty(uMusic.getmTargetUrl()) ? uMusic.toUrl() : uMusic.getmTargetUrl();
    }

    public UMQQMini getQQMini() {
        return this.f11702i;
    }

    public String getStrStyle() {
        return this.n;
    }

    public byte[] getStrictImageData(UMImage uMImage) {
        if (getUMImageScale(uMImage) <= 491520) {
            return getImageData(uMImage);
        }
        byte[] bArrA = a.a(getImage(), 491520);
        if (bArrA != null && bArrA.length > 0) {
            return bArrA;
        }
        SLog.E(UmengText.IMAGE.SHARECONTENT_THUMB_ERROR);
        return null;
    }

    public String getSubject() {
        return this.o;
    }

    public String getText() {
        return this.f11696c;
    }

    public int getUMImageScale(UMImage uMImage) {
        return a.a(uMImage);
    }

    public UMEmoji getUmEmoji() {
        return this.f11699f;
    }

    public UMMin getUmMin() {
        return this.f11701h;
    }

    public UMVideo[] getUmVideos() {
        return this.f11698e;
    }

    public UMWeb getUmWeb() {
        return this.f11703j;
    }

    public UMVideo getVideo() {
        return this.f11697d;
    }

    public UMImage[] getmImages() {
        return this.f11695b;
    }

    public int getmStyle() {
        return this.f11706m;
    }

    public String objectSetDescription(BaseMediaObject baseMediaObject) {
        if (TextUtils.isEmpty(baseMediaObject.getDescription())) {
            return "这里是描述";
        }
        String description = baseMediaObject.getDescription();
        return description.length() > 1024 ? description.substring(0, 1024) : description;
    }

    public byte[] objectSetMInAppThumb(BaseMediaObject baseMediaObject) {
        if (baseMediaObject.getThumbImage() == null) {
            return DefaultClass.getBytes();
        }
        if (this.p != null) {
            UMImage thumbImage = baseMediaObject.getThumbImage();
            if (thumbImage == null) {
                return DefaultClass.getBytes();
            }
            byte[] bArrAsBinImage = thumbImage.asBinImage();
            return (bArrAsBinImage == null || a.a(thumbImage) > this.WX_MIN_LIMIT) ? this.p.compressThumb(bArrAsBinImage) : bArrAsBinImage;
        }
        byte[] bArrA = a.a(baseMediaObject.getThumbImage().asBinImage(), this.WX_MIN_LIMIT, Bitmap.CompressFormat.JPEG);
        if (bArrA != null && bArrA.length > 0) {
            return bArrA;
        }
        SLog.E(UmengText.IMAGE.SHARECONTENT_THUMB_ERROR);
        return bArrA;
    }

    public String objectSetText(String str, int i2) {
        return TextUtils.isEmpty(str) ? "这里是描述" : str.length() > i2 ? str.substring(0, i2) : str;
    }

    public byte[] objectSetThumb(BaseMediaObject baseMediaObject) {
        if (baseMediaObject.getThumbImage() == null) {
            return b();
        }
        if (this.p != null) {
            UMImage thumbImage = baseMediaObject.getThumbImage();
            if (thumbImage == null) {
                return DefaultClass.getBytes();
            }
            byte[] bArrAsBinImage = thumbImage.asBinImage();
            return (bArrAsBinImage == null || a.a(thumbImage) > this.THUMB_LIMIT) ? this.p.compressThumb(bArrAsBinImage) : bArrAsBinImage;
        }
        byte[] bArrA = a.a(baseMediaObject.getThumbImage(), this.THUMB_LIMIT);
        if (bArrA != null && bArrA.length > 0) {
            return bArrA;
        }
        SLog.E(UmengText.IMAGE.SHARECONTENT_THUMB_ERROR);
        return b();
    }

    public String objectSetTitle(BaseMediaObject baseMediaObject) {
        if (TextUtils.isEmpty(baseMediaObject.getTitle())) {
            return "这里是标题";
        }
        String title = baseMediaObject.getTitle();
        return title.length() > 512 ? title.substring(0, 512) : title;
    }

    public void setCompressListener(CompressListener compressListener) {
        this.p = compressListener;
    }

    public void setImage(UMImage uMImage) {
        this.f11694a = uMImage;
    }

    public void setMusic(UMusic uMusic) {
        this.f11700g = uMusic;
    }

    public void setText(String str) {
        this.f11696c = str;
    }

    public void setVideo(UMVideo uMVideo) {
        this.f11697d = uMVideo;
    }

    public String subString(String str, int i2) {
        return (!TextUtils.isEmpty(str) || str.length() <= i2) ? str : str.substring(0, i2);
    }

    public String objectSetText(String str) {
        return objectSetText(str, 10240);
    }
}
