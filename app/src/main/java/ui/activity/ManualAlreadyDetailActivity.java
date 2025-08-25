package ui.activity;

import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import bean.CheckUserBean;
import com.hicorenational.antifraud.R;
import com.luck.picture.lib.entity.LocalMedia;
import java.util.ArrayList;
import ui.callview.ManualAlreadyDetailView;
import ui.presenter.ManualAlreadyDetailPresenter;
import ui.view.swip.SwipBackLayout;

/* compiled from: ManualAlreadyDetailActivity.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010\u001c\u001a\u00020\u001bH\u0016J\u0006\u0010\u001d\u001a\u00020\u001bJ\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0012\u0010!\u001a\u00020\u001b2\b\u0010\"\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u001b2\b\u0010&\u001a\u0004\u0018\u00010'R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lui/activity/ManualAlreadyDetailActivity;", "Lui/activity/BaseActivity;", "Landroid/view/View$OnClickListener;", "Lui/callview/ManualAlreadyDetailView;", "()V", "checkBean", "Lbean/CheckUserBean;", "getCheckBean", "()Lbean/CheckUserBean;", "setCheckBean", "(Lbean/CheckUserBean;)V", "mIvBack", "Landroid/widget/ImageView;", "mPicF", "mPicZ", "mPresenter", "Lui/presenter/ManualAlreadyDetailPresenter;", "getMPresenter", "()Lui/presenter/ManualAlreadyDetailPresenter;", "setMPresenter", "(Lui/presenter/ManualAlreadyDetailPresenter;)V", "mTvIdNum", "Landroid/widget/TextView;", "mTvName", "mTvPhoneNum", "mTvTitle", "initListener", "", "initPage", "initViewData", "onClick", "view", "Landroid/view/View;", "onSuccess", "result", "setLayoutView", "", "showPreviewPic", "path", "", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class ManualAlreadyDetailActivity extends BaseActivity implements View.OnClickListener, ManualAlreadyDetailView {

    @i.c.a.e
    private CheckUserBean checkBean;
    private ImageView mIvBack;
    private ImageView mPicF;
    private ImageView mPicZ;

    @i.c.a.e
    private ManualAlreadyDetailPresenter mPresenter;
    private TextView mTvIdNum;
    private TextView mTvName;
    private TextView mTvPhoneNum;
    private TextView mTvTitle;

    @i.c.a.e
    public final CheckUserBean getCheckBean() {
        return this.checkBean;
    }

    @i.c.a.e
    public final ManualAlreadyDetailPresenter getMPresenter() {
        return this.mPresenter;
    }

    public final void initListener() {
        ImageView imageView = this.mIvBack;
        if (imageView == null) {
            h.q2.t.i0.k("mIvBack");
        }
        if (imageView == null) {
            h.q2.t.i0.f();
        }
        imageView.setOnClickListener(this);
        ImageView imageView2 = this.mPicZ;
        if (imageView2 == null) {
            h.q2.t.i0.k("mPicZ");
        }
        if (imageView2 == null) {
            h.q2.t.i0.f();
        }
        imageView2.setOnClickListener(this);
        ImageView imageView3 = this.mPicF;
        if (imageView3 == null) {
            h.q2.t.i0.k("mPicF");
        }
        if (imageView3 == null) {
            h.q2.t.i0.f();
        }
        imageView3.setOnClickListener(this);
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.a(this.mActivity).a();
        View viewFindViewById = findViewById(R.id.iv_back);
        h.q2.t.i0.a((Object) viewFindViewById, "findViewById(R.id.iv_back)");
        this.mIvBack = (ImageView) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.tv_title);
        h.q2.t.i0.a((Object) viewFindViewById2, "findViewById(R.id.tv_title)");
        this.mTvTitle = (TextView) viewFindViewById2;
        View viewFindViewById3 = findViewById(R.id.tv_name);
        h.q2.t.i0.a((Object) viewFindViewById3, "findViewById(R.id.tv_name)");
        this.mTvName = (TextView) viewFindViewById3;
        View viewFindViewById4 = findViewById(R.id.tv_id_num);
        h.q2.t.i0.a((Object) viewFindViewById4, "findViewById(R.id.tv_id_num)");
        this.mTvIdNum = (TextView) viewFindViewById4;
        View viewFindViewById5 = findViewById(R.id.tv_phone_num);
        h.q2.t.i0.a((Object) viewFindViewById5, "findViewById(R.id.tv_phone_num)");
        this.mTvPhoneNum = (TextView) viewFindViewById5;
        View viewFindViewById6 = findViewById(R.id.iv_upload_pic_z);
        h.q2.t.i0.a((Object) viewFindViewById6, "findViewById(R.id.iv_upload_pic_z)");
        this.mPicZ = (ImageView) viewFindViewById6;
        View viewFindViewById7 = findViewById(R.id.iv_upload_pic_f);
        h.q2.t.i0.a((Object) viewFindViewById7, "findViewById(R.id.iv_upload_pic_f)");
        this.mPicF = (ImageView) viewFindViewById7;
        TextView textView = this.mTvTitle;
        if (textView == null) {
            h.q2.t.i0.k("mTvTitle");
        }
        if (textView == null) {
            h.q2.t.i0.f();
        }
        textView.setText("已审核详情");
        this.mPresenter = new ManualAlreadyDetailPresenter(this.mActivity, this);
        long longExtra = getIntent().getLongExtra(util.k1.f20845c, -1L);
        ManualAlreadyDetailPresenter manualAlreadyDetailPresenter = this.mPresenter;
        if (manualAlreadyDetailPresenter != null) {
            manualAlreadyDetailPresenter.detail(Long.valueOf(longExtra));
        }
        initListener();
    }

    public final void initViewData() {
        TextView textView = this.mTvName;
        if (textView == null) {
            h.q2.t.i0.k("mTvName");
        }
        if (textView == null) {
            h.q2.t.i0.f();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("姓名：");
        CheckUserBean checkUserBean = this.checkBean;
        sb.append(checkUserBean != null ? checkUserBean.getName() : null);
        textView.setText(sb.toString());
        TextView textView2 = this.mTvIdNum;
        if (textView2 == null) {
            h.q2.t.i0.k("mTvIdNum");
        }
        if (textView2 == null) {
            h.q2.t.i0.f();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("证件号：");
        CheckUserBean checkUserBean2 = this.checkBean;
        sb2.append(checkUserBean2 != null ? checkUserBean2.getIdNumber() : null);
        textView2.setText(sb2.toString());
        TextView textView3 = this.mTvPhoneNum;
        if (textView3 == null) {
            h.q2.t.i0.k("mTvPhoneNum");
        }
        if (textView3 == null) {
            h.q2.t.i0.f();
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("手机号：");
        CheckUserBean checkUserBean3 = this.checkBean;
        sb3.append(checkUserBean3 != null ? checkUserBean3.getTelnumber() : null);
        textView3.setText(sb3.toString());
        CheckUserBean checkUserBean4 = this.checkBean;
        String frontImg = checkUserBean4 != null ? checkUserBean4.getFrontImg() : null;
        ImageView imageView = this.mPicZ;
        if (imageView == null) {
            h.q2.t.i0.k("mPicZ");
        }
        j.d.a(frontImg, imageView, Integer.valueOf(R.drawable.iv_id_z_default));
        CheckUserBean checkUserBean5 = this.checkBean;
        String backImg = checkUserBean5 != null ? checkUserBean5.getBackImg() : null;
        ImageView imageView2 = this.mPicF;
        if (imageView2 == null) {
            h.q2.t.i0.k("mPicF");
        }
        j.d.a(backImg, imageView2, Integer.valueOf(R.drawable.iv_id_f_default));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@i.c.a.d View view) {
        h.q2.t.i0.f(view, "view");
        if (isDouble()) {
        }
        switch (view.getId()) {
            case R.id.iv_back /* 2131296762 */:
                a();
                break;
            case R.id.iv_upload_pic_f /* 2131296855 */:
                CheckUserBean checkUserBean = this.checkBean;
                showPreviewPic(checkUserBean != null ? checkUserBean.getBackImg() : null);
                break;
            case R.id.iv_upload_pic_z /* 2131296856 */:
                CheckUserBean checkUserBean2 = this.checkBean;
                showPreviewPic(checkUserBean2 != null ? checkUserBean2.getFrontImg() : null);
                break;
        }
    }

    @Override // ui.callview.ManualAlreadyDetailView
    public void onSuccess(@i.c.a.e CheckUserBean checkUserBean) {
        if (checkUserBean != null) {
            this.checkBean = checkUserBean;
            initViewData();
        }
    }

    public final void setCheckBean(@i.c.a.e CheckUserBean checkUserBean) {
        this.checkBean = checkUserBean;
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_manual_already_detail;
    }

    public final void setMPresenter(@i.c.a.e ManualAlreadyDetailPresenter manualAlreadyDetailPresenter) {
        this.mPresenter = manualAlreadyDetailPresenter;
    }

    public final void showPreviewPic(@i.c.a.e String str) {
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        LocalMedia localMedia = new LocalMedia();
        localMedia.setPath(str);
        arrayList.add(localMedia);
        Intent intent = new Intent(this, (Class<?>) PreviewPictureActivity.class);
        intent.putParcelableArrayListExtra(PreviewPictureActivity.f18539f, arrayList);
        intent.putExtra(PreviewPictureActivity.f18540g, 0);
        intent.putExtra(PreviewPictureActivity.f18541h, arrayList.size());
        intent.putExtra(PreviewPictureActivity.f18542i, str);
        startActivity(intent);
    }
}
