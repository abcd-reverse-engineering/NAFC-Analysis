package ui.f;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import bean.ShareConfigBean;
import com.bumptech.glide.r.h;
import com.hicorenational.antifraud.R;
import manager.BaseDialog;
import util.w1;
import util.y1;

/* compiled from: SharePicDialog.java */
/* loaded from: classes2.dex */
public class e extends BaseDialog implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private Activity f19550a;

    /* renamed from: b, reason: collision with root package name */
    private ImageView f19551b;

    /* renamed from: c, reason: collision with root package name */
    private ShareConfigBean f19552c;

    public e(Activity activity, ShareConfigBean shareConfigBean) {
        super(activity, R.style.base_dialog_style);
        this.f19550a = activity;
        this.f19552c = shareConfigBean;
        a();
    }

    @SuppressLint({"ResourceType"})
    private void a() {
        setContentView(R.layout.share_save_pic_dlg);
        setGravityLayout(2);
        setWidthDialog(0.8d);
        setHeightDialog(-2.0d);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        initOnCreate();
        this.f19551b = (ImageView) findViewById(R.id.iv_img);
        ShareConfigBean shareConfigBean = this.f19552c;
        if (shareConfigBean != null) {
            a(shareConfigBean.saveImgUrl, this.f19551b);
        } else {
            this.f19551b.setBackgroundResource(R.drawable.iv_share_pic);
        }
        View viewFindViewById = findViewById(R.id.iv_close);
        View viewFindViewById2 = findViewById(R.id.ll_save);
        viewFindViewById.setOnClickListener(this);
        viewFindViewById2.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.iv_close) {
            dismiss();
        } else {
            if (id != R.id.ll_save) {
                return;
            }
            y1.a(this.f19550a, this.f19551b);
            w1.a("海报已保存至相册");
            dismiss();
        }
    }

    public void a(String str, ImageView imageView) {
        try {
            com.bumptech.glide.b.e(imageView.getContext()).a(str).a((com.bumptech.glide.r.a<?>) new h().b(R.drawable.iv_share_pic)).a(imageView);
        } catch (Exception unused) {
        }
    }
}
