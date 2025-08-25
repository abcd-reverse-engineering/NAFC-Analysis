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
public class AddSmsOneFragment_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private AddSmsOneFragment f19579a;

    /* renamed from: b, reason: collision with root package name */
    private View f19580b;

    /* renamed from: c, reason: collision with root package name */
    private View f19581c;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AddSmsOneFragment f19582a;

        a(AddSmsOneFragment addSmsOneFragment) {
            this.f19582a = addSmsOneFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19582a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AddSmsOneFragment f19584a;

        b(AddSmsOneFragment addSmsOneFragment) {
            this.f19584a = addSmsOneFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19584a.onViewClicked(view);
        }
    }

    @UiThread
    public AddSmsOneFragment_ViewBinding(AddSmsOneFragment addSmsOneFragment, View view) {
        this.f19579a = addSmsOneFragment;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.confirm, "field 'mBtnCommit' and method 'onViewClicked'");
        addSmsOneFragment.mBtnCommit = (TextView) Utils.castView(viewFindRequiredView, R.id.confirm, "field 'mBtnCommit'", TextView.class);
        this.f19580b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(addSmsOneFragment));
        addSmsOneFragment.mEtPhone = (EditText) Utils.findRequiredViewAsType(view, R.id.et_phone, "field 'mEtPhone'", EditText.class);
        addSmsOneFragment.mEtDescribe = (EditText) Utils.findRequiredViewAsType(view, R.id.et_describe, "field 'mEtDescribe'", EditText.class);
        addSmsOneFragment.mEtVictimPhone = (EditText) Utils.findRequiredViewAsType(view, R.id.tv_victim_phone, "field 'mEtVictimPhone'", EditText.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_time, "field 'mTvTime' and method 'onViewClicked'");
        addSmsOneFragment.mTvTime = (TextView) Utils.castView(viewFindRequiredView2, R.id.tv_time, "field 'mTvTime'", TextView.class);
        this.f19581c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(addSmsOneFragment));
        addSmsOneFragment.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        addSmsOneFragment.mLlPicture = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_picture, "field 'mLlPicture'", LinearLayout.class);
        addSmsOneFragment.mTvTipPicture = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tip_picture, "field 'mTvTipPicture'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AddSmsOneFragment addSmsOneFragment = this.f19579a;
        if (addSmsOneFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f19579a = null;
        addSmsOneFragment.mBtnCommit = null;
        addSmsOneFragment.mEtPhone = null;
        addSmsOneFragment.mEtDescribe = null;
        addSmsOneFragment.mEtVictimPhone = null;
        addSmsOneFragment.mTvTime = null;
        addSmsOneFragment.mRecyclerview = null;
        addSmsOneFragment.mLlPicture = null;
        addSmsOneFragment.mTvTipPicture = null;
        this.f19580b.setOnClickListener(null);
        this.f19580b = null;
        this.f19581c.setOnClickListener(null);
        this.f19581c = null;
    }
}
