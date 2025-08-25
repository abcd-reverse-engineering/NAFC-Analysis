package ui.fragment;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public class AddSmsTwoFragment_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private AddSmsTwoFragment f19609a;

    /* renamed from: b, reason: collision with root package name */
    private View f19610b;

    /* renamed from: c, reason: collision with root package name */
    private View f19611c;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AddSmsTwoFragment f19612a;

        a(AddSmsTwoFragment addSmsTwoFragment) {
            this.f19612a = addSmsTwoFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19612a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AddSmsTwoFragment f19614a;

        b(AddSmsTwoFragment addSmsTwoFragment) {
            this.f19614a = addSmsTwoFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19614a.onViewClicked(view);
        }
    }

    @UiThread
    public AddSmsTwoFragment_ViewBinding(AddSmsTwoFragment addSmsTwoFragment, View view) {
        this.f19609a = addSmsTwoFragment;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.confirm, "field 'mBtnCommit' and method 'onViewClicked'");
        addSmsTwoFragment.mBtnCommit = (TextView) Utils.castView(viewFindRequiredView, R.id.confirm, "field 'mBtnCommit'", TextView.class);
        this.f19610b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(addSmsTwoFragment));
        addSmsTwoFragment.mEtPhone = (EditText) Utils.findRequiredViewAsType(view, R.id.et_phone, "field 'mEtPhone'", EditText.class);
        addSmsTwoFragment.mEtDescribe = (EditText) Utils.findRequiredViewAsType(view, R.id.et_describe, "field 'mEtDescribe'", EditText.class);
        addSmsTwoFragment.mEtVictimPhone = (EditText) Utils.findRequiredViewAsType(view, R.id.tv_victim_phone, "field 'mEtVictimPhone'", EditText.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_time, "field 'mTvTime' and method 'onViewClicked'");
        addSmsTwoFragment.mTvTime = (TextView) Utils.castView(viewFindRequiredView2, R.id.tv_time, "field 'mTvTime'", TextView.class);
        this.f19611c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(addSmsTwoFragment));
        addSmsTwoFragment.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        addSmsTwoFragment.mTvTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tip, "field 'mTvTip'", TextView.class);
        addSmsTwoFragment.mTvDescribeLabel = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_describe_label, "field 'mTvDescribeLabel'", TextView.class);
        addSmsTwoFragment.mLlPicture = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_picture, "field 'mLlPicture'", LinearLayout.class);
        addSmsTwoFragment.mTvTipPicture = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tip_picture, "field 'mTvTipPicture'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AddSmsTwoFragment addSmsTwoFragment = this.f19609a;
        if (addSmsTwoFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f19609a = null;
        addSmsTwoFragment.mBtnCommit = null;
        addSmsTwoFragment.mEtPhone = null;
        addSmsTwoFragment.mEtDescribe = null;
        addSmsTwoFragment.mEtVictimPhone = null;
        addSmsTwoFragment.mTvTime = null;
        addSmsTwoFragment.mRecyclerview = null;
        addSmsTwoFragment.mTvTip = null;
        addSmsTwoFragment.mTvDescribeLabel = null;
        addSmsTwoFragment.mLlPicture = null;
        addSmsTwoFragment.mTvTipPicture = null;
        this.f19610b.setOnClickListener(null);
        this.f19610b = null;
        this.f19611c.setOnClickListener(null);
        this.f19611c = null;
    }
}
