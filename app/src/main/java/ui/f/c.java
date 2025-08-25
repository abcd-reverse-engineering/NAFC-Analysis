package ui.f;

import adapter.HRecyclerViewAdapter;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.ShareConfigBean;
import com.hicorenational.antifraud.R;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMVideo;
import com.umeng.socialize.media.UMWeb;
import manager.AccountManager;
import manager.BaseDialog;
import util.w1;
import util.y1;

/* compiled from: HiShareDialog.java */
/* loaded from: classes2.dex */
public class c extends BaseDialog implements d {

    /* renamed from: a, reason: collision with root package name */
    private int f19538a;

    /* renamed from: b, reason: collision with root package name */
    private Activity f19539b;

    /* renamed from: c, reason: collision with root package name */
    private String f19540c;

    /* renamed from: e, reason: collision with root package name */
    private String f19541e;

    /* renamed from: f, reason: collision with root package name */
    private String f19542f;

    /* renamed from: g, reason: collision with root package name */
    private UMImage f19543g;

    /* renamed from: h, reason: collision with root package name */
    private ShareAction f19544h;

    /* renamed from: i, reason: collision with root package name */
    private e f19545i;

    /* renamed from: j, reason: collision with root package name */
    private ShareConfigBean f19546j;

    /* renamed from: k, reason: collision with root package name */
    private b f19547k;

    /* renamed from: l, reason: collision with root package name */
    private UMShareListener f19548l;

    /* compiled from: HiShareDialog.java */
    class a implements UMShareListener {
        a() {
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onCancel(SHARE_MEDIA share_media) {
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onError(SHARE_MEDIA share_media, Throwable th) {
            w1.a("分享失败");
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onResult(SHARE_MEDIA share_media) {
            w1.a("分享成功");
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onStart(SHARE_MEDIA share_media) {
        }
    }

    /* compiled from: HiShareDialog.java */
    public interface b {
        void a();
    }

    public c(Activity activity, ShareConfigBean shareConfigBean, int i2) {
        super(activity, R.style.base_dialog_style);
        this.f19540c = d.a.f13520f + "/QRCode/?appkey=a28ft4&pcode=10000";
        this.f19541e = "下载国家反诈中心APP,公安部打击防范电信网络诈骗官方应用";
        this.f19542f = "看更多反诈文章，上国家反诈中心APP";
        this.f19547k = null;
        this.f19548l = new a();
        this.f19539b = activity;
        this.f19538a = i2;
        this.f19546j = shareConfigBean;
        this.f19544h = new ShareAction(this.f19539b);
        this.f19545i = new e(this.f19539b, shareConfigBean);
        b();
    }

    @SuppressLint({"ResourceType"})
    private void b() {
        setContentView(R.layout.share_dlg);
        setGravityLayout(0);
        setWidthDialog(-2.0d);
        setHeightDialogdp(-2.0f);
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        initOnCreate();
        getWindow().setWindowAnimations(R.anim.anim_bottom_in);
        findViewById(R.id.cancel_btn).setOnClickListener(new View.OnClickListener() { // from class: ui.f.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f19537a.a(view);
            }
        });
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.h_recyclerview);
        HRecyclerViewAdapter hRecyclerViewAdapter = new HRecyclerViewAdapter(this.f19539b, this.f19538a);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f19539b);
        linearLayoutManager.setOrientation(0);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(hRecyclerViewAdapter);
        hRecyclerViewAdapter.setOnItemClickListener(new HRecyclerViewAdapter.a() { // from class: ui.f.a
            @Override // adapter.HRecyclerViewAdapter.a
            public final void a(int i2, String str) {
                this.f19536a.a(i2, str);
            }
        });
        ShareConfigBean shareConfigBean = this.f19546j;
        if (shareConfigBean != null) {
            if (!TextUtils.isEmpty(shareConfigBean.downloadUrl)) {
                this.f19540c = this.f19546j.downloadUrl;
            }
            if (!TextUtils.isEmpty(this.f19546j.title)) {
                this.f19541e = this.f19546j.title;
            }
            if (!TextUtils.isEmpty(this.f19546j.description)) {
                this.f19542f = this.f19546j.description;
            }
            if (TextUtils.isEmpty(this.f19546j.iconUrl)) {
                this.f19543g = new UMImage(this.f19539b, R.mipmap.logo);
            } else {
                this.f19543g = new UMImage(this.f19539b, this.f19546j.iconUrl);
            }
        } else {
            this.f19543g = new UMImage(this.f19539b, R.mipmap.logo);
        }
        this.f19540c += AccountManager.getShareParam();
    }

    public /* synthetic */ void a(View view) {
        dismiss();
    }

    private void a(String str) {
        if (TextUtils.equals("微博", str)) {
            this.f19542f = this.f19541e;
        }
        int i2 = this.f19538a;
        if (i2 == 3) {
            UMImage uMImage = new UMImage(this.f19539b, this.f19540c);
            uMImage.setTitle(this.f19541e);
            uMImage.setThumb(this.f19543g);
            uMImage.setDescription(this.f19542f);
            this.f19544h.withMedia(uMImage);
            return;
        }
        if (i2 == 4) {
            UMVideo uMVideo = new UMVideo(this.f19540c);
            uMVideo.setTitle(this.f19541e);
            uMVideo.setThumb(this.f19543g);
            uMVideo.setDescription(this.f19542f);
            this.f19544h.withMedia(uMVideo);
            return;
        }
        UMWeb uMWeb = new UMWeb(this.f19540c);
        uMWeb.setTitle(this.f19541e);
        uMWeb.setThumb(this.f19543g);
        uMWeb.setDescription(this.f19542f);
        this.f19544h.withMedia(uMWeb);
    }

    public c(Activity activity, ShareConfigBean shareConfigBean, int i2, b bVar) {
        super(activity, R.style.base_dialog_style);
        this.f19540c = d.a.f13520f + "/QRCode/?appkey=a28ft4&pcode=10000";
        this.f19541e = "下载国家反诈中心APP,公安部打击防范电信网络诈骗官方应用";
        this.f19542f = "看更多反诈文章，上国家反诈中心APP";
        this.f19547k = null;
        this.f19548l = new a();
        this.f19539b = activity;
        this.f19538a = i2;
        this.f19546j = shareConfigBean;
        this.f19544h = new ShareAction(this.f19539b);
        this.f19545i = new e(this.f19539b, shareConfigBean);
        this.f19547k = bVar;
        b();
    }

    public static boolean a(Activity activity, SHARE_MEDIA share_media) {
        return UMShareAPI.get(activity).isInstall(activity, share_media);
    }

    private void a() {
        b bVar = this.f19547k;
        if (bVar != null) {
            bVar.a();
        }
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(int i2, String str) {
        a(str);
        switch (i2) {
            case 0:
                if (a(this.f19539b, SHARE_MEDIA.WEIXIN)) {
                    a();
                    this.f19544h.setPlatform(SHARE_MEDIA.WEIXIN).share();
                    break;
                } else {
                    w1.a("您未安装微信");
                    break;
                }
            case 1:
                if (a(this.f19539b, SHARE_MEDIA.WEIXIN)) {
                    a();
                    this.f19544h.setPlatform(SHARE_MEDIA.WEIXIN_CIRCLE).share();
                    break;
                } else {
                    w1.a("您未安装微信");
                    break;
                }
            case 2:
                if (a(this.f19539b, SHARE_MEDIA.QQ)) {
                    a();
                    this.f19544h.setPlatform(SHARE_MEDIA.QQ).setCallback(this.f19548l).share();
                    break;
                } else {
                    w1.a("分享失败");
                    break;
                }
            case 3:
                if (a(this.f19539b, SHARE_MEDIA.QZONE)) {
                    a();
                    this.f19544h.setPlatform(SHARE_MEDIA.QZONE).setCallback(this.f19548l).share();
                    break;
                } else {
                    w1.a("分享失败");
                    break;
                }
            case 4:
                a();
                this.f19544h.setPlatform(SHARE_MEDIA.SINA).setCallback(this.f19548l).share();
                break;
            case 5:
                if (a(this.f19539b, SHARE_MEDIA.DINGTALK)) {
                    a();
                    this.f19544h.setPlatform(SHARE_MEDIA.DINGTALK).setCallback(this.f19548l).share();
                    break;
                } else {
                    w1.a("您未安装钉钉");
                    break;
                }
            case 6:
                int i3 = this.f19538a;
                if (i3 != 1) {
                    if (i3 == 2) {
                        y1.s(this.f19540c);
                        a();
                        break;
                    }
                } else {
                    this.f19545i.show();
                    a();
                    break;
                }
                break;
        }
        dismiss();
    }
}
