package ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public final class VictimDetialActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private VictimDetialActivity f19208a;

    /* renamed from: b, reason: collision with root package name */
    private View f19209b;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ VictimDetialActivity f19210a;

        a(VictimDetialActivity victimDetialActivity) {
            this.f19210a = victimDetialActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19210a.onClick(view);
        }
    }

    @UiThread
    public VictimDetialActivity_ViewBinding(VictimDetialActivity victimDetialActivity) {
        this(victimDetialActivity, victimDetialActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        VictimDetialActivity victimDetialActivity = this.f19208a;
        if (victimDetialActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f19208a = null;
        victimDetialActivity.mIvBack = null;
        victimDetialActivity.mTvTitle = null;
        victimDetialActivity.mTvPeopName = null;
        victimDetialActivity.mTvPeopPhone = null;
        victimDetialActivity.mTvPeopCredentType = null;
        victimDetialActivity.mEtPeopCredentNumber = null;
        this.f19209b.setOnClickListener(null);
        this.f19209b = null;
    }

    @UiThread
    public VictimDetialActivity_ViewBinding(VictimDetialActivity victimDetialActivity, View view) {
        this.f19208a = victimDetialActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        victimDetialActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f19209b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(victimDetialActivity));
        victimDetialActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        victimDetialActivity.mTvPeopName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_peop_name, "field 'mTvPeopName'", TextView.class);
        victimDetialActivity.mTvPeopPhone = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_num_phone, "field 'mTvPeopPhone'", TextView.class);
        victimDetialActivity.mTvPeopCredentType = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_peop_credent_type, "field 'mTvPeopCredentType'", TextView.class);
        victimDetialActivity.mEtPeopCredentNumber = (TextView) Utils.findRequiredViewAsType(view, R.id.et_peop_credent_number, "field 'mEtPeopCredentNumber'", TextView.class);
    }
}
