package ui.activity;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.hicorenational.antifraud.R;

/* compiled from: SurveyDealActivity.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lui/activity/SurveyDealActivity;", "Lui/activity/BaseActivity;", "Landroid/view/View$OnClickListener;", "()V", "mIvBack", "Landroid/widget/ImageView;", "mTvCancle", "Landroid/widget/TextView;", "mTvConfirm", "mTvTitle", "initListener", "", "initPage", "onClick", "view", "Landroid/view/View;", "setLayoutView", "", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class SurveyDealActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private ImageView f19091a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f19092b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f19093c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f19094d;

    public final void initListener() {
        ImageView imageView = this.f19091a;
        if (imageView == null) {
            h.q2.t.i0.k("mIvBack");
        }
        if (imageView == null) {
            h.q2.t.i0.f();
        }
        imageView.setOnClickListener(this);
        TextView textView = this.f19093c;
        if (textView == null) {
            h.q2.t.i0.k("mTvCancle");
        }
        if (textView == null) {
            h.q2.t.i0.f();
        }
        textView.setOnClickListener(this);
        TextView textView2 = this.f19094d;
        if (textView2 == null) {
            h.q2.t.i0.k("mTvConfirm");
        }
        if (textView2 == null) {
            h.q2.t.i0.f();
        }
        textView2.setOnClickListener(this);
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        ui.statusbarcompat.b.a((Activity) this, true, true);
        View viewFindViewById = findViewById(R.id.iv_back);
        h.q2.t.i0.a((Object) viewFindViewById, "findViewById(R.id.iv_back)");
        this.f19091a = (ImageView) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.tv_title);
        h.q2.t.i0.a((Object) viewFindViewById2, "findViewById(R.id.tv_title)");
        this.f19092b = (TextView) viewFindViewById2;
        View viewFindViewById3 = findViewById(R.id.cancle);
        h.q2.t.i0.a((Object) viewFindViewById3, "findViewById(R.id.cancle)");
        this.f19093c = (TextView) viewFindViewById3;
        View viewFindViewById4 = findViewById(R.id.confirm);
        h.q2.t.i0.a((Object) viewFindViewById4, "findViewById(R.id.confirm)");
        this.f19094d = (TextView) viewFindViewById4;
        TextView textView = this.f19092b;
        if (textView == null) {
            h.q2.t.i0.k("mTvTitle");
        }
        if (textView == null) {
            h.q2.t.i0.f();
        }
        textView.setText("报案助手");
        initListener();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@i.c.a.d View view) {
        h.q2.t.i0.f(view, "view");
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == R.id.cancle) {
            finish();
        } else if (id == R.id.confirm) {
            finish();
        } else {
            if (id != R.id.iv_back) {
                return;
            }
            a();
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_survey_deal;
    }
}
