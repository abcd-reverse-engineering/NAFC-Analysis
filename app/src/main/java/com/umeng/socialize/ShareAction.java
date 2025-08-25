package com.umeng.socialize;

import android.app.Activity;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import anet.channel.util.HttpConstant;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMEmoji;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMMin;
import com.umeng.socialize.media.UMQQMini;
import com.umeng.socialize.media.UMVideo;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.media.UMusic;
import com.umeng.socialize.shareboard.ShareBoard;
import com.umeng.socialize.shareboard.ShareBoardConfig;
import com.umeng.socialize.shareboard.SnsPlatform;
import com.umeng.socialize.utils.CommonUtil;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.ShareBoardlistener;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class ShareAction {

    /* renamed from: b, reason: collision with root package name */
    private SHARE_MEDIA f11498b;

    /* renamed from: c, reason: collision with root package name */
    private UMShareListener f11499c;

    /* renamed from: d, reason: collision with root package name */
    private ShareBoardlistener f11500d;

    /* renamed from: e, reason: collision with root package name */
    private Activity f11501e;

    /* renamed from: f, reason: collision with root package name */
    private List<SHARE_MEDIA> f11502f;

    /* renamed from: k, reason: collision with root package name */
    private View f11507k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f11508l;

    /* renamed from: m, reason: collision with root package name */
    private ShareBoard f11509m;

    /* renamed from: a, reason: collision with root package name */
    private ShareContent f11497a = new ShareContent();

    /* renamed from: g, reason: collision with root package name */
    private final List<SnsPlatform> f11503g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    private List<ShareContent> f11504h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    private List<UMShareListener> f11505i = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    private int f11506j = 80;
    private ShareBoardlistener n = new ShareBoardlistener() { // from class: com.umeng.socialize.ShareAction.1
        @Override // com.umeng.socialize.utils.ShareBoardlistener
        public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
            ShareAction.this.setPlatform(share_media);
            ShareAction.this.share();
        }
    };
    private ShareBoardlistener o = new ShareBoardlistener() { // from class: com.umeng.socialize.ShareAction.2
        @Override // com.umeng.socialize.utils.ShareBoardlistener
        public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
            int iIndexOf = ShareAction.this.f11502f.indexOf(share_media);
            int size = ShareAction.this.f11504h.size();
            if (size != 0) {
                ShareAction.this.f11497a = iIndexOf < size ? (ShareContent) ShareAction.this.f11504h.get(iIndexOf) : (ShareContent) ShareAction.this.f11504h.get(size - 1);
            }
            int size2 = ShareAction.this.f11505i.size();
            if (size2 != 0) {
                if (iIndexOf < size2) {
                    ShareAction shareAction = ShareAction.this;
                    shareAction.f11499c = (UMShareListener) shareAction.f11505i.get(iIndexOf);
                } else {
                    ShareAction shareAction2 = ShareAction.this;
                    shareAction2.f11499c = (UMShareListener) shareAction2.f11505i.get(size2 - 1);
                }
            }
            ShareAction.this.setPlatform(share_media);
            ShareAction.this.share();
        }
    };

    public ShareAction(Activity activity) {
        if (activity != null) {
            this.f11501e = (Activity) new WeakReference(activity).get();
        }
    }

    public static Rect locateView(View view) {
        int[] iArr = new int[2];
        if (view == null) {
            return null;
        }
        try {
            view.getLocationOnScreen(iArr);
            Rect rect = new Rect();
            rect.left = iArr[0];
            rect.top = iArr[1];
            rect.right = rect.left + view.getWidth();
            rect.bottom = rect.top + view.getHeight();
            return rect;
        } catch (NullPointerException e2) {
            SLog.error(e2);
            return null;
        }
    }

    public ShareAction addButton(String str, String str2, String str3, String str4) {
        this.f11503g.add(SHARE_MEDIA.createSnsPlatform(str, str2, str3, str4, 0));
        return this;
    }

    public ShareAction bySystem() {
        this.f11508l = true;
        return this;
    }

    public void close() {
        ShareBoard shareBoard = this.f11509m;
        if (shareBoard != null) {
            shareBoard.dismiss();
            this.f11509m = null;
        }
    }

    public SHARE_MEDIA getPlatform() {
        return this.f11498b;
    }

    public ShareContent getShareContent() {
        return this.f11497a;
    }

    public boolean getUrlValid() {
        UMediaObject uMediaObject;
        ShareContent shareContent = this.f11497a;
        return shareContent == null || (uMediaObject = shareContent.mMedia) == null || !(uMediaObject instanceof UMWeb) || uMediaObject.toUrl() == null || this.f11497a.mMedia.toUrl().startsWith(HttpConstant.HTTP);
    }

    public void open(ShareBoardConfig shareBoardConfig) {
        if (CommonUtil.isSilentMode(this.f11501e)) {
            return;
        }
        if (this.f11503g.size() != 0) {
            HashMap map = new HashMap();
            map.put("listener", this.f11499c);
            map.put("content", this.f11497a);
            try {
                this.f11509m = new ShareBoard(this.f11501e, this.f11503g, shareBoardConfig);
                if (this.f11500d == null) {
                    this.f11509m.setShareBoardlistener(this.o);
                } else {
                    this.f11509m.setShareBoardlistener(this.f11500d);
                }
                this.f11509m.setFocusable(true);
                this.f11509m.setBackgroundDrawable(new BitmapDrawable());
                if (this.f11507k == null) {
                    this.f11507k = this.f11501e.getWindow().getDecorView();
                }
                this.f11509m.showAtLocation(this.f11507k, this.f11506j, 0, 0);
                return;
            } catch (Exception e2) {
                SLog.error(e2);
                return;
            }
        }
        this.f11503g.add(SHARE_MEDIA.WEIXIN.toSnsPlatform());
        this.f11503g.add(SHARE_MEDIA.WEIXIN_CIRCLE.toSnsPlatform());
        this.f11503g.add(SHARE_MEDIA.SINA.toSnsPlatform());
        this.f11503g.add(SHARE_MEDIA.QQ.toSnsPlatform());
        this.f11503g.add(SHARE_MEDIA.DINGTALK.toSnsPlatform());
        HashMap map2 = new HashMap();
        map2.put("listener", this.f11499c);
        map2.put("content", this.f11497a);
        this.f11509m = new ShareBoard(this.f11501e, this.f11503g, shareBoardConfig);
        ShareBoardlistener shareBoardlistener = this.f11500d;
        if (shareBoardlistener == null) {
            this.f11509m.setShareBoardlistener(this.n);
        } else {
            this.f11509m.setShareBoardlistener(shareBoardlistener);
        }
        this.f11509m.setFocusable(true);
        this.f11509m.setBackgroundDrawable(new BitmapDrawable());
        if (this.f11507k == null) {
            this.f11507k = this.f11501e.getWindow().getDecorView();
        }
        this.f11509m.showAtLocation(this.f11507k, 80, 0, 0);
    }

    public ShareAction setCallback(UMShareListener uMShareListener) {
        this.f11499c = uMShareListener;
        return this;
    }

    @Deprecated
    public ShareAction setContentList(ShareContent... shareContentArr) {
        if (shareContentArr == null || Arrays.asList(shareContentArr).size() == 0) {
            ShareContent shareContent = new ShareContent();
            shareContent.mText = "empty";
            this.f11504h.add(shareContent);
        } else {
            this.f11504h = Arrays.asList(shareContentArr);
        }
        return this;
    }

    public ShareAction setDisplayList(SHARE_MEDIA... share_mediaArr) {
        this.f11502f = Arrays.asList(share_mediaArr);
        this.f11503g.clear();
        Iterator<SHARE_MEDIA> it = this.f11502f.iterator();
        while (it.hasNext()) {
            this.f11503g.add(it.next().toSnsPlatform());
        }
        return this;
    }

    @Deprecated
    public ShareAction setListenerList(UMShareListener... uMShareListenerArr) {
        this.f11505i = Arrays.asList(uMShareListenerArr);
        return this;
    }

    public ShareAction setPlatform(SHARE_MEDIA share_media) {
        this.f11498b = share_media;
        return this;
    }

    public ShareAction setShareContent(ShareContent shareContent) {
        this.f11497a = shareContent;
        return this;
    }

    public ShareAction setShareboardclickCallback(ShareBoardlistener shareBoardlistener) {
        this.f11500d = shareBoardlistener;
        return this;
    }

    public void share() {
        UMShareAPI uMShareAPI = UMShareAPI.get(this.f11501e);
        if (uMShareAPI != null) {
            ShareContent shareContent = getShareContent();
            if (shareContent != null) {
                shareContent.bySystem = this.f11508l;
            }
            uMShareAPI.doShare(this.f11501e, this, this.f11499c);
        }
    }

    public ShareAction withApp(File file) {
        this.f11497a.app = file;
        return this;
    }

    public ShareAction withExtra(UMImage uMImage) {
        this.f11497a.mExtra = uMImage;
        return this;
    }

    public ShareAction withFile(File file) {
        this.f11497a.file = file;
        return this;
    }

    public ShareAction withFollow(String str) {
        this.f11497a.mFollow = str;
        return this;
    }

    public ShareAction withMedia(UMImage uMImage) {
        this.f11497a.mMedia = uMImage;
        return this;
    }

    public ShareAction withMedias(UMImage... uMImageArr) {
        if (uMImageArr != null && uMImageArr.length > 0) {
            this.f11497a.mMedia = uMImageArr[0];
        }
        this.f11497a.mMedias = uMImageArr;
        return this;
    }

    public ShareAction withShareBoardDirection(View view, int i2) {
        this.f11506j = i2;
        this.f11507k = view;
        return this;
    }

    public ShareAction withSubject(String str) {
        this.f11497a.subject = str;
        return this;
    }

    public ShareAction withText(String str) {
        this.f11497a.mText = str;
        return this;
    }

    public ShareAction withMedia(UMMin uMMin) {
        this.f11497a.mMedia = uMMin;
        return this;
    }

    public ShareAction withMedia(UMQQMini uMQQMini) {
        this.f11497a.mMedia = uMQQMini;
        return this;
    }

    public ShareAction withMedia(UMEmoji uMEmoji) {
        this.f11497a.mMedia = uMEmoji;
        return this;
    }

    public ShareAction withMedias(UMVideo... uMVideoArr) {
        if (uMVideoArr != null && uMVideoArr.length > 0) {
            this.f11497a.mMedia = uMVideoArr[0];
        }
        this.f11497a.Video_mMedias = uMVideoArr;
        return this;
    }

    public ShareAction withMedia(UMWeb uMWeb) {
        this.f11497a.mMedia = uMWeb;
        return this;
    }

    public ShareAction withMedia(UMusic uMusic) {
        this.f11497a.mMedia = uMusic;
        return this;
    }

    public ShareAction withMedia(UMVideo uMVideo) {
        this.f11497a.mMedia = uMVideo;
        return this;
    }

    public void open() {
        open(null);
    }
}
