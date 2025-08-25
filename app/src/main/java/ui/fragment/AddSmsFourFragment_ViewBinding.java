package ui.fragment;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public class AddSmsFourFragment_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private AddSmsFourFragment f19561a;

    /* renamed from: b, reason: collision with root package name */
    private View f19562b;

    /* renamed from: c, reason: collision with root package name */
    private View f19563c;

    /* renamed from: d, reason: collision with root package name */
    private View f19564d;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AddSmsFourFragment f19565a;

        a(AddSmsFourFragment addSmsFourFragment) {
            this.f19565a = addSmsFourFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19565a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AddSmsFourFragment f19567a;

        b(AddSmsFourFragment addSmsFourFragment) {
            this.f19567a = addSmsFourFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19567a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AddSmsFourFragment f19569a;

        c(AddSmsFourFragment addSmsFourFragment) {
            this.f19569a = addSmsFourFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19569a.onViewClicked(view);
        }
    }

    @UiThread
    public AddSmsFourFragment_ViewBinding(AddSmsFourFragment addSmsFourFragment, View view) {
        this.f19561a = addSmsFourFragment;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.confirm, "field 'mBtnCommit' and method 'onViewClicked'");
        addSmsFourFragment.mBtnCommit = (TextView) Utils.castView(viewFindRequiredView, R.id.confirm, "field 'mBtnCommit'", TextView.class);
        this.f19562b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(addSmsFourFragment));
        addSmsFourFragment.mEtDescribe = (EditText) Utils.findRequiredViewAsType(view, R.id.et_describe, "field 'mEtDescribe'", EditText.class);
        addSmsFourFragment.mEtVictimPhone = (EditText) Utils.findRequiredViewAsType(view, R.id.tv_victim_phone, "field 'mEtVictimPhone'", EditText.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_time, "field 'mTvTime' and method 'onViewClicked'");
        addSmsFourFragment.mTvTime = (TextView) Utils.castView(viewFindRequiredView2, R.id.tv_time, "field 'mTvTime'", TextView.class);
        this.f19563c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(addSmsFourFragment));
        addSmsFourFragment.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.tv_brand, "field 'mTvBrand' and method 'onViewClicked'");
        addSmsFourFragment.mTvBrand = (TextView) Utils.castView(viewFindRequiredView3, R.id.tv_brand, "field 'mTvBrand'", TextView.class);
        this.f19564d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(addSmsFourFragment));
        addSmsFourFragment.mEtBrandOther = (EditText) Utils.findRequiredViewAsType(view, R.id.et_brand_other, "field 'mEtBrandOther'", EditText.class);
        addSmsFourFragment.mGpBrandOther = (Group) Utils.findRequiredViewAsType(view, R.id.gp_brand_other, "field 'mGpBrandOther'", Group.class);
        addSmsFourFragment.mLlPicture = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_picture, "field 'mLlPicture'", LinearLayout.class);
        addSmsFourFragment.mTvTipPicture = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tip_picture, "field 'mTvTipPicture'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AddSmsFourFragment addSmsFourFragment = this.f19561a;
        if (addSmsFourFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f19561a = null;
        addSmsFourFragment.mBtnCommit = null;
        addSmsFourFragment.mEtDescribe = null;
        addSmsFourFragment.mEtVictimPhone = null;
        addSmsFourFragment.mTvTime = null;
        addSmsFourFragment.mRecyclerview = null;
        addSmsFourFragment.mTvBrand = null;
        addSmsFourFragment.mEtBrandOther = null;
        addSmsFourFragment.mGpBrandOther = null;
        addSmsFourFragment.mLlPicture = null;
        addSmsFourFragment.mTvTipPicture = null;
        this.f19562b.setOnClickListener(null);
        this.f19562b = null;
        this.f19563c.setOnClickListener(null);
        this.f19563c = null;
        this.f19564d.setOnClickListener(null);
        this.f19564d = null;
    }
}
